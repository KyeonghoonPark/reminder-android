package com.smtm.reminders.app;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.smtm.reminders.realm.module.SimpleRealmModule;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.nio.ByteBuffer;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;



public class MyApplication extends Application {
    public static boolean DEBUG = false;
    public static String PACKAGENAME = "";


    @Override
    public void onCreate() {
        super.onCreate();

        this.DEBUG = isDebuggable(this);// 디버그모드에 따라서 로그를 남기거나 남기지 않는다
//        this.DEBUG = false;// 디버그모드에 따라서 로그를 남기거나 남기지 않는다
        this.PACKAGENAME = getPackageName();

        Realm.init(this);
        byte[] securityKey = generateSecurityKey();
        RealmConfiguration myConfig = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(1)
                .modules(new SimpleRealmModule())
                .deleteRealmIfMigrationNeeded()
//                .encryptionKey(securityKey)
                .build();
        Realm.setDefaultConfiguration(myConfig);

        // Stetho
        RealmInspectorModulesProvider provider = RealmInspectorModulesProvider.builder(this)
                .withDeleteIfMigrationNeeded(true)
//                .withEncryptionKey("myrealm.realm", securityKey)
                .build();

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(provider)
                .build());

    }

    private byte[] generateSecurityKey() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[64]);
        bb.putInt(UUID.randomUUID().hashCode());
        return bb.array();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Realm realm = Realm.getDefaultInstance();
        if (!realm.isClosed()) {
            Realm.getDefaultInstance().close();
        }
    }

    /**
     * 현재 디버그모드여부를 리턴
     *
     * @param context
     * @return
     */
    private boolean isDebuggable(Context context) {
        boolean debuggable = false;
        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
            debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
        } catch (PackageManager.NameNotFoundException e) {
            /* debuggable variable will remain false */
        }
        return debuggable;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
