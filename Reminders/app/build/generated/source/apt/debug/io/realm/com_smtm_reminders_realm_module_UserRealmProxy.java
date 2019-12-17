package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_smtm_reminders_realm_module_UserRealmProxy extends com.smtm.reminders.realm.module.User
    implements RealmObjectProxy, com_smtm_reminders_realm_module_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long idIndex;
        long nicknameIndex;
        long choiceIndex;
        long genderIndex;
        long birthdayIndex;
        long sessionTimerIndex;
        long isBlinkEyeIndex;
        long isSmilingIndex;
        long isEyeeMeasureIndex;
        long isStreamVolumeIndex;
        long distanceCMIndex;
        long eyeDistanceAvgIndex;
        long eyeDistanceWarningIndex;
        long eyeDistanceCancelIndex;
        long checkPasswordIndex;
        long passwordIndex;
        long passwordConfirmIndex;
        long daysIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(18);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nicknameIndex = addColumnDetails("nickname", "nickname", objectSchemaInfo);
            this.choiceIndex = addColumnDetails("choice", "choice", objectSchemaInfo);
            this.genderIndex = addColumnDetails("gender", "gender", objectSchemaInfo);
            this.birthdayIndex = addColumnDetails("birthday", "birthday", objectSchemaInfo);
            this.sessionTimerIndex = addColumnDetails("sessionTimer", "sessionTimer", objectSchemaInfo);
            this.isBlinkEyeIndex = addColumnDetails("isBlinkEye", "isBlinkEye", objectSchemaInfo);
            this.isSmilingIndex = addColumnDetails("isSmiling", "isSmiling", objectSchemaInfo);
            this.isEyeeMeasureIndex = addColumnDetails("isEyeeMeasure", "isEyeeMeasure", objectSchemaInfo);
            this.isStreamVolumeIndex = addColumnDetails("isStreamVolume", "isStreamVolume", objectSchemaInfo);
            this.distanceCMIndex = addColumnDetails("distanceCM", "distanceCM", objectSchemaInfo);
            this.eyeDistanceAvgIndex = addColumnDetails("eyeDistanceAvg", "eyeDistanceAvg", objectSchemaInfo);
            this.eyeDistanceWarningIndex = addColumnDetails("eyeDistanceWarning", "eyeDistanceWarning", objectSchemaInfo);
            this.eyeDistanceCancelIndex = addColumnDetails("eyeDistanceCancel", "eyeDistanceCancel", objectSchemaInfo);
            this.checkPasswordIndex = addColumnDetails("checkPassword", "checkPassword", objectSchemaInfo);
            this.passwordIndex = addColumnDetails("password", "password", objectSchemaInfo);
            this.passwordConfirmIndex = addColumnDetails("passwordConfirm", "passwordConfirm", objectSchemaInfo);
            this.daysIndex = addColumnDetails("days", "days", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nicknameIndex = src.nicknameIndex;
            dst.choiceIndex = src.choiceIndex;
            dst.genderIndex = src.genderIndex;
            dst.birthdayIndex = src.birthdayIndex;
            dst.sessionTimerIndex = src.sessionTimerIndex;
            dst.isBlinkEyeIndex = src.isBlinkEyeIndex;
            dst.isSmilingIndex = src.isSmilingIndex;
            dst.isEyeeMeasureIndex = src.isEyeeMeasureIndex;
            dst.isStreamVolumeIndex = src.isStreamVolumeIndex;
            dst.distanceCMIndex = src.distanceCMIndex;
            dst.eyeDistanceAvgIndex = src.eyeDistanceAvgIndex;
            dst.eyeDistanceWarningIndex = src.eyeDistanceWarningIndex;
            dst.eyeDistanceCancelIndex = src.eyeDistanceCancelIndex;
            dst.checkPasswordIndex = src.checkPasswordIndex;
            dst.passwordIndex = src.passwordIndex;
            dst.passwordConfirmIndex = src.passwordConfirmIndex;
            dst.daysIndex = src.daysIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.smtm.reminders.realm.module.User> proxyState;
    private RealmList<com.smtm.reminders.realm.module.ListSchema> daysRealmList;

    com_smtm_reminders_realm_module_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.smtm.reminders.realm.module.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nickname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nicknameIndex);
    }

    @Override
    public void realmSet$nickname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'nickname' to null.");
            }
            row.getTable().setString(columnInfo.nicknameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'nickname' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.nicknameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$choice() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.choiceIndex);
    }

    @Override
    public void realmSet$choice(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.choiceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.choiceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$gender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genderIndex);
    }

    @Override
    public void realmSet$gender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$birthday() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.birthdayIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.birthdayIndex);
    }

    @Override
    public void realmSet$birthday(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthdayIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.birthdayIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthdayIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.birthdayIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$sessionTimer() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.sessionTimerIndex);
    }

    @Override
    public void realmSet$sessionTimer(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sessionTimerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sessionTimerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isBlinkEye() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isBlinkEyeIndex);
    }

    @Override
    public void realmSet$isBlinkEye(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isBlinkEyeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isBlinkEyeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isSmiling() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isSmilingIndex);
    }

    @Override
    public void realmSet$isSmiling(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isSmilingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isSmilingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isEyeeMeasure() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isEyeeMeasureIndex);
    }

    @Override
    public void realmSet$isEyeeMeasure(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isEyeeMeasureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isEyeeMeasureIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isStreamVolume() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isStreamVolumeIndex);
    }

    @Override
    public void realmSet$isStreamVolume(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isStreamVolumeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isStreamVolumeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$distanceCM() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.distanceCMIndex);
    }

    @Override
    public void realmSet$distanceCM(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.distanceCMIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.distanceCMIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$eyeDistanceAvg() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.eyeDistanceAvgIndex);
    }

    @Override
    public void realmSet$eyeDistanceAvg(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.eyeDistanceAvgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.eyeDistanceAvgIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$eyeDistanceWarning() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.eyeDistanceWarningIndex);
    }

    @Override
    public void realmSet$eyeDistanceWarning(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.eyeDistanceWarningIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.eyeDistanceWarningIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$eyeDistanceCancel() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.eyeDistanceCancelIndex);
    }

    @Override
    public void realmSet$eyeDistanceCancel(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.eyeDistanceCancelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.eyeDistanceCancelIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$checkPassword() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.checkPasswordIndex);
    }

    @Override
    public void realmSet$checkPassword(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.checkPasswordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.checkPasswordIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$passwordConfirm() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordConfirmIndex);
    }

    @Override
    public void realmSet$passwordConfirm(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordConfirmIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordConfirmIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordConfirmIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordConfirmIndex, value);
    }

    @Override
    public RealmList<com.smtm.reminders.realm.module.ListSchema> realmGet$days() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (daysRealmList != null) {
            return daysRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.daysIndex);
            daysRealmList = new RealmList<com.smtm.reminders.realm.module.ListSchema>(com.smtm.reminders.realm.module.ListSchema.class, osList, proxyState.getRealm$realm());
            return daysRealmList;
        }
    }

    @Override
    public void realmSet$days(RealmList<com.smtm.reminders.realm.module.ListSchema> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("days")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.smtm.reminders.realm.module.ListSchema> original = value;
                value = new RealmList<com.smtm.reminders.realm.module.ListSchema>();
                for (com.smtm.reminders.realm.module.ListSchema item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.daysIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.ListSchema linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.ListSchema linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 18, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nickname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("choice", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("gender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("birthday", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sessionTimer", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isBlinkEye", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isSmiling", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isEyeeMeasure", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isStreamVolume", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("distanceCM", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("eyeDistanceAvg", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("eyeDistanceWarning", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("eyeDistanceCancel", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("checkPassword", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("passwordConfirm", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("days", RealmFieldType.LIST, "ListSchema");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.smtm.reminders.realm.module.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.smtm.reminders.realm.module.User obj = null;
        if (update) {
            Table table = realm.getTable(com.smtm.reminders.realm.module.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_smtm_reminders_realm_module_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("days")) {
                excludeFields.add("days");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_smtm_reminders_realm_module_UserRealmProxy) realm.createObjectInternal(com.smtm.reminders.realm.module.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_smtm_reminders_realm_module_UserRealmProxy) realm.createObjectInternal(com.smtm.reminders.realm.module.User.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_smtm_reminders_realm_module_UserRealmProxyInterface objProxy = (com_smtm_reminders_realm_module_UserRealmProxyInterface) obj;
        if (json.has("nickname")) {
            if (json.isNull("nickname")) {
                objProxy.realmSet$nickname(null);
            } else {
                objProxy.realmSet$nickname((String) json.getString("nickname"));
            }
        }
        if (json.has("choice")) {
            if (json.isNull("choice")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'choice' to null.");
            } else {
                objProxy.realmSet$choice((boolean) json.getBoolean("choice"));
            }
        }
        if (json.has("gender")) {
            if (json.isNull("gender")) {
                objProxy.realmSet$gender(null);
            } else {
                objProxy.realmSet$gender((String) json.getString("gender"));
            }
        }
        if (json.has("birthday")) {
            if (json.isNull("birthday")) {
                objProxy.realmSet$birthday(null);
            } else {
                Object timestamp = json.get("birthday");
                if (timestamp instanceof String) {
                    objProxy.realmSet$birthday(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$birthday(new Date(json.getLong("birthday")));
                }
            }
        }
        if (json.has("sessionTimer")) {
            if (json.isNull("sessionTimer")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sessionTimer' to null.");
            } else {
                objProxy.realmSet$sessionTimer((long) json.getLong("sessionTimer"));
            }
        }
        if (json.has("isBlinkEye")) {
            if (json.isNull("isBlinkEye")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isBlinkEye' to null.");
            } else {
                objProxy.realmSet$isBlinkEye((boolean) json.getBoolean("isBlinkEye"));
            }
        }
        if (json.has("isSmiling")) {
            if (json.isNull("isSmiling")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isSmiling' to null.");
            } else {
                objProxy.realmSet$isSmiling((boolean) json.getBoolean("isSmiling"));
            }
        }
        if (json.has("isEyeeMeasure")) {
            if (json.isNull("isEyeeMeasure")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isEyeeMeasure' to null.");
            } else {
                objProxy.realmSet$isEyeeMeasure((boolean) json.getBoolean("isEyeeMeasure"));
            }
        }
        if (json.has("isStreamVolume")) {
            if (json.isNull("isStreamVolume")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isStreamVolume' to null.");
            } else {
                objProxy.realmSet$isStreamVolume((boolean) json.getBoolean("isStreamVolume"));
            }
        }
        if (json.has("distanceCM")) {
            if (json.isNull("distanceCM")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'distanceCM' to null.");
            } else {
                objProxy.realmSet$distanceCM((int) json.getInt("distanceCM"));
            }
        }
        if (json.has("eyeDistanceAvg")) {
            if (json.isNull("eyeDistanceAvg")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'eyeDistanceAvg' to null.");
            } else {
                objProxy.realmSet$eyeDistanceAvg((float) json.getDouble("eyeDistanceAvg"));
            }
        }
        if (json.has("eyeDistanceWarning")) {
            if (json.isNull("eyeDistanceWarning")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'eyeDistanceWarning' to null.");
            } else {
                objProxy.realmSet$eyeDistanceWarning((float) json.getDouble("eyeDistanceWarning"));
            }
        }
        if (json.has("eyeDistanceCancel")) {
            if (json.isNull("eyeDistanceCancel")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'eyeDistanceCancel' to null.");
            } else {
                objProxy.realmSet$eyeDistanceCancel((float) json.getDouble("eyeDistanceCancel"));
            }
        }
        if (json.has("checkPassword")) {
            if (json.isNull("checkPassword")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'checkPassword' to null.");
            } else {
                objProxy.realmSet$checkPassword((boolean) json.getBoolean("checkPassword"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("passwordConfirm")) {
            if (json.isNull("passwordConfirm")) {
                objProxy.realmSet$passwordConfirm(null);
            } else {
                objProxy.realmSet$passwordConfirm((String) json.getString("passwordConfirm"));
            }
        }
        if (json.has("days")) {
            if (json.isNull("days")) {
                objProxy.realmSet$days(null);
            } else {
                objProxy.realmGet$days().clear();
                JSONArray array = json.getJSONArray("days");
                for (int i = 0; i < array.length(); i++) {
                    com.smtm.reminders.realm.module.ListSchema item = com_smtm_reminders_realm_module_ListSchemaRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$days().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.smtm.reminders.realm.module.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.smtm.reminders.realm.module.User obj = new com.smtm.reminders.realm.module.User();
        final com_smtm_reminders_realm_module_UserRealmProxyInterface objProxy = (com_smtm_reminders_realm_module_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("nickname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nickname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nickname(null);
                }
            } else if (name.equals("choice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$choice((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'choice' to null.");
                }
            } else if (name.equals("gender")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$gender((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$gender(null);
                }
            } else if (name.equals("birthday")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$birthday(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$birthday(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$birthday(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("sessionTimer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sessionTimer((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sessionTimer' to null.");
                }
            } else if (name.equals("isBlinkEye")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isBlinkEye((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isBlinkEye' to null.");
                }
            } else if (name.equals("isSmiling")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isSmiling((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isSmiling' to null.");
                }
            } else if (name.equals("isEyeeMeasure")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isEyeeMeasure((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isEyeeMeasure' to null.");
                }
            } else if (name.equals("isStreamVolume")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isStreamVolume((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isStreamVolume' to null.");
                }
            } else if (name.equals("distanceCM")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$distanceCM((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'distanceCM' to null.");
                }
            } else if (name.equals("eyeDistanceAvg")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eyeDistanceAvg((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'eyeDistanceAvg' to null.");
                }
            } else if (name.equals("eyeDistanceWarning")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eyeDistanceWarning((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'eyeDistanceWarning' to null.");
                }
            } else if (name.equals("eyeDistanceCancel")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eyeDistanceCancel((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'eyeDistanceCancel' to null.");
                }
            } else if (name.equals("checkPassword")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$checkPassword((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'checkPassword' to null.");
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("passwordConfirm")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$passwordConfirm((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$passwordConfirm(null);
                }
            } else if (name.equals("days")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$days(null);
                } else {
                    objProxy.realmSet$days(new RealmList<com.smtm.reminders.realm.module.ListSchema>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.smtm.reminders.realm.module.ListSchema item = com_smtm_reminders_realm_module_ListSchemaRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$days().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.smtm.reminders.realm.module.User copyOrUpdate(Realm realm, com.smtm.reminders.realm.module.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.smtm.reminders.realm.module.User) cachedRealmObject;
        }

        com.smtm.reminders.realm.module.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.smtm.reminders.realm.module.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_smtm_reminders_realm_module_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.smtm.reminders.realm.module.User copy(Realm realm, com.smtm.reminders.realm.module.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.smtm.reminders.realm.module.User) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.smtm.reminders.realm.module.User realmObject = realm.createObjectInternal(com.smtm.reminders.realm.module.User.class, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_smtm_reminders_realm_module_UserRealmProxyInterface realmObjectSource = (com_smtm_reminders_realm_module_UserRealmProxyInterface) newObject;
        com_smtm_reminders_realm_module_UserRealmProxyInterface realmObjectCopy = (com_smtm_reminders_realm_module_UserRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$nickname(realmObjectSource.realmGet$nickname());
        realmObjectCopy.realmSet$choice(realmObjectSource.realmGet$choice());
        realmObjectCopy.realmSet$gender(realmObjectSource.realmGet$gender());
        realmObjectCopy.realmSet$birthday(realmObjectSource.realmGet$birthday());
        realmObjectCopy.realmSet$sessionTimer(realmObjectSource.realmGet$sessionTimer());
        realmObjectCopy.realmSet$isBlinkEye(realmObjectSource.realmGet$isBlinkEye());
        realmObjectCopy.realmSet$isSmiling(realmObjectSource.realmGet$isSmiling());
        realmObjectCopy.realmSet$isEyeeMeasure(realmObjectSource.realmGet$isEyeeMeasure());
        realmObjectCopy.realmSet$isStreamVolume(realmObjectSource.realmGet$isStreamVolume());
        realmObjectCopy.realmSet$distanceCM(realmObjectSource.realmGet$distanceCM());
        realmObjectCopy.realmSet$eyeDistanceAvg(realmObjectSource.realmGet$eyeDistanceAvg());
        realmObjectCopy.realmSet$eyeDistanceWarning(realmObjectSource.realmGet$eyeDistanceWarning());
        realmObjectCopy.realmSet$eyeDistanceCancel(realmObjectSource.realmGet$eyeDistanceCancel());
        realmObjectCopy.realmSet$checkPassword(realmObjectSource.realmGet$checkPassword());
        realmObjectCopy.realmSet$password(realmObjectSource.realmGet$password());
        realmObjectCopy.realmSet$passwordConfirm(realmObjectSource.realmGet$passwordConfirm());

        RealmList<com.smtm.reminders.realm.module.ListSchema> daysList = realmObjectSource.realmGet$days();
        if (daysList != null) {
            RealmList<com.smtm.reminders.realm.module.ListSchema> daysRealmList = realmObjectCopy.realmGet$days();
            daysRealmList.clear();
            for (int i = 0; i < daysList.size(); i++) {
                com.smtm.reminders.realm.module.ListSchema daysItem = daysList.get(i);
                com.smtm.reminders.realm.module.ListSchema cachedays = (com.smtm.reminders.realm.module.ListSchema) cache.get(daysItem);
                if (cachedays != null) {
                    daysRealmList.add(cachedays);
                } else {
                    daysRealmList.add(com_smtm_reminders_realm_module_ListSchemaRealmProxy.copyOrUpdate(realm, daysItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.smtm.reminders.realm.module.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.smtm.reminders.realm.module.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$nickname = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$nickname();
        if (realmGet$nickname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nicknameIndex, rowIndex, realmGet$nickname, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$choice(), false);
        String realmGet$gender = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        }
        java.util.Date realmGet$birthday = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$birthday();
        if (realmGet$birthday != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.birthdayIndex, rowIndex, realmGet$birthday.getTime(), false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sessionTimerIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$sessionTimer(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlinkEyeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isBlinkEye(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isSmilingIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isSmiling(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isEyeeMeasureIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isEyeeMeasure(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isStreamVolumeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isStreamVolume(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.distanceCMIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$distanceCM(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceAvgIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceAvg(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceWarningIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceWarning(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceCancelIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceCancel(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.checkPasswordIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$checkPassword(), false);
        String realmGet$password = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        String realmGet$passwordConfirm = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$passwordConfirm();
        if (realmGet$passwordConfirm != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordConfirmIndex, rowIndex, realmGet$passwordConfirm, false);
        }

        RealmList<com.smtm.reminders.realm.module.ListSchema> daysList = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$days();
        if (daysList != null) {
            OsList daysOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.daysIndex);
            for (com.smtm.reminders.realm.module.ListSchema daysItem : daysList) {
                Long cacheItemIndexdays = cache.get(daysItem);
                if (cacheItemIndexdays == null) {
                    cacheItemIndexdays = com_smtm_reminders_realm_module_ListSchemaRealmProxy.insert(realm, daysItem, cache);
                }
                daysOsList.addRow(cacheItemIndexdays);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.smtm.reminders.realm.module.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.smtm.reminders.realm.module.User object = null;
        while (objects.hasNext()) {
            object = (com.smtm.reminders.realm.module.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$nickname = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$nickname();
            if (realmGet$nickname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nicknameIndex, rowIndex, realmGet$nickname, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$choice(), false);
            String realmGet$gender = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$gender();
            if (realmGet$gender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
            }
            java.util.Date realmGet$birthday = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$birthday();
            if (realmGet$birthday != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.birthdayIndex, rowIndex, realmGet$birthday.getTime(), false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sessionTimerIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$sessionTimer(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlinkEyeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isBlinkEye(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSmilingIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isSmiling(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isEyeeMeasureIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isEyeeMeasure(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isStreamVolumeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isStreamVolume(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.distanceCMIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$distanceCM(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceAvgIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceAvg(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceWarningIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceWarning(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceCancelIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceCancel(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.checkPasswordIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$checkPassword(), false);
            String realmGet$password = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            }
            String realmGet$passwordConfirm = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$passwordConfirm();
            if (realmGet$passwordConfirm != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordConfirmIndex, rowIndex, realmGet$passwordConfirm, false);
            }

            RealmList<com.smtm.reminders.realm.module.ListSchema> daysList = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$days();
            if (daysList != null) {
                OsList daysOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.daysIndex);
                for (com.smtm.reminders.realm.module.ListSchema daysItem : daysList) {
                    Long cacheItemIndexdays = cache.get(daysItem);
                    if (cacheItemIndexdays == null) {
                        cacheItemIndexdays = com_smtm_reminders_realm_module_ListSchemaRealmProxy.insert(realm, daysItem, cache);
                    }
                    daysOsList.addRow(cacheItemIndexdays);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.smtm.reminders.realm.module.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.smtm.reminders.realm.module.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$nickname = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$nickname();
        if (realmGet$nickname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nicknameIndex, rowIndex, realmGet$nickname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nicknameIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$choice(), false);
        String realmGet$gender = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
        }
        java.util.Date realmGet$birthday = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$birthday();
        if (realmGet$birthday != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.birthdayIndex, rowIndex, realmGet$birthday.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthdayIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sessionTimerIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$sessionTimer(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlinkEyeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isBlinkEye(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isSmilingIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isSmiling(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isEyeeMeasureIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isEyeeMeasure(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isStreamVolumeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isStreamVolume(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.distanceCMIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$distanceCM(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceAvgIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceAvg(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceWarningIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceWarning(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceCancelIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceCancel(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.checkPasswordIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$checkPassword(), false);
        String realmGet$password = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        String realmGet$passwordConfirm = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$passwordConfirm();
        if (realmGet$passwordConfirm != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordConfirmIndex, rowIndex, realmGet$passwordConfirm, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordConfirmIndex, rowIndex, false);
        }

        OsList daysOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.daysIndex);
        RealmList<com.smtm.reminders.realm.module.ListSchema> daysList = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$days();
        if (daysList != null && daysList.size() == daysOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = daysList.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.ListSchema daysItem = daysList.get(i);
                Long cacheItemIndexdays = cache.get(daysItem);
                if (cacheItemIndexdays == null) {
                    cacheItemIndexdays = com_smtm_reminders_realm_module_ListSchemaRealmProxy.insertOrUpdate(realm, daysItem, cache);
                }
                daysOsList.setRow(i, cacheItemIndexdays);
            }
        } else {
            daysOsList.removeAll();
            if (daysList != null) {
                for (com.smtm.reminders.realm.module.ListSchema daysItem : daysList) {
                    Long cacheItemIndexdays = cache.get(daysItem);
                    if (cacheItemIndexdays == null) {
                        cacheItemIndexdays = com_smtm_reminders_realm_module_ListSchemaRealmProxy.insertOrUpdate(realm, daysItem, cache);
                    }
                    daysOsList.addRow(cacheItemIndexdays);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.smtm.reminders.realm.module.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.smtm.reminders.realm.module.User object = null;
        while (objects.hasNext()) {
            object = (com.smtm.reminders.realm.module.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$nickname = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$nickname();
            if (realmGet$nickname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nicknameIndex, rowIndex, realmGet$nickname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nicknameIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$choice(), false);
            String realmGet$gender = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$gender();
            if (realmGet$gender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
            }
            java.util.Date realmGet$birthday = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$birthday();
            if (realmGet$birthday != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.birthdayIndex, rowIndex, realmGet$birthday.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.birthdayIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sessionTimerIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$sessionTimer(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlinkEyeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isBlinkEye(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSmilingIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isSmiling(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isEyeeMeasureIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isEyeeMeasure(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isStreamVolumeIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$isStreamVolume(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.distanceCMIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$distanceCM(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceAvgIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceAvg(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceWarningIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceWarning(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.eyeDistanceCancelIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$eyeDistanceCancel(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.checkPasswordIndex, rowIndex, ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$checkPassword(), false);
            String realmGet$password = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
            }
            String realmGet$passwordConfirm = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$passwordConfirm();
            if (realmGet$passwordConfirm != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordConfirmIndex, rowIndex, realmGet$passwordConfirm, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordConfirmIndex, rowIndex, false);
            }

            OsList daysOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.daysIndex);
            RealmList<com.smtm.reminders.realm.module.ListSchema> daysList = ((com_smtm_reminders_realm_module_UserRealmProxyInterface) object).realmGet$days();
            if (daysList != null && daysList.size() == daysOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = daysList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.smtm.reminders.realm.module.ListSchema daysItem = daysList.get(i);
                    Long cacheItemIndexdays = cache.get(daysItem);
                    if (cacheItemIndexdays == null) {
                        cacheItemIndexdays = com_smtm_reminders_realm_module_ListSchemaRealmProxy.insertOrUpdate(realm, daysItem, cache);
                    }
                    daysOsList.setRow(i, cacheItemIndexdays);
                }
            } else {
                daysOsList.removeAll();
                if (daysList != null) {
                    for (com.smtm.reminders.realm.module.ListSchema daysItem : daysList) {
                        Long cacheItemIndexdays = cache.get(daysItem);
                        if (cacheItemIndexdays == null) {
                            cacheItemIndexdays = com_smtm_reminders_realm_module_ListSchemaRealmProxy.insertOrUpdate(realm, daysItem, cache);
                        }
                        daysOsList.addRow(cacheItemIndexdays);
                    }
                }
            }

        }
    }

    public static com.smtm.reminders.realm.module.User createDetachedCopy(com.smtm.reminders.realm.module.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.smtm.reminders.realm.module.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.smtm.reminders.realm.module.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.smtm.reminders.realm.module.User) cachedObject.object;
            }
            unmanagedObject = (com.smtm.reminders.realm.module.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_smtm_reminders_realm_module_UserRealmProxyInterface unmanagedCopy = (com_smtm_reminders_realm_module_UserRealmProxyInterface) unmanagedObject;
        com_smtm_reminders_realm_module_UserRealmProxyInterface realmSource = (com_smtm_reminders_realm_module_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nickname(realmSource.realmGet$nickname());
        unmanagedCopy.realmSet$choice(realmSource.realmGet$choice());
        unmanagedCopy.realmSet$gender(realmSource.realmGet$gender());
        unmanagedCopy.realmSet$birthday(realmSource.realmGet$birthday());
        unmanagedCopy.realmSet$sessionTimer(realmSource.realmGet$sessionTimer());
        unmanagedCopy.realmSet$isBlinkEye(realmSource.realmGet$isBlinkEye());
        unmanagedCopy.realmSet$isSmiling(realmSource.realmGet$isSmiling());
        unmanagedCopy.realmSet$isEyeeMeasure(realmSource.realmGet$isEyeeMeasure());
        unmanagedCopy.realmSet$isStreamVolume(realmSource.realmGet$isStreamVolume());
        unmanagedCopy.realmSet$distanceCM(realmSource.realmGet$distanceCM());
        unmanagedCopy.realmSet$eyeDistanceAvg(realmSource.realmGet$eyeDistanceAvg());
        unmanagedCopy.realmSet$eyeDistanceWarning(realmSource.realmGet$eyeDistanceWarning());
        unmanagedCopy.realmSet$eyeDistanceCancel(realmSource.realmGet$eyeDistanceCancel());
        unmanagedCopy.realmSet$checkPassword(realmSource.realmGet$checkPassword());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$passwordConfirm(realmSource.realmGet$passwordConfirm());

        // Deep copy of days
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$days(null);
        } else {
            RealmList<com.smtm.reminders.realm.module.ListSchema> manageddaysList = realmSource.realmGet$days();
            RealmList<com.smtm.reminders.realm.module.ListSchema> unmanageddaysList = new RealmList<com.smtm.reminders.realm.module.ListSchema>();
            unmanagedCopy.realmSet$days(unmanageddaysList);
            int nextDepth = currentDepth + 1;
            int size = manageddaysList.size();
            for (int i = 0; i < size; i++) {
                com.smtm.reminders.realm.module.ListSchema item = com_smtm_reminders_realm_module_ListSchemaRealmProxy.createDetachedCopy(manageddaysList.get(i), nextDepth, maxDepth, cache);
                unmanageddaysList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.smtm.reminders.realm.module.User update(Realm realm, com.smtm.reminders.realm.module.User realmObject, com.smtm.reminders.realm.module.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_smtm_reminders_realm_module_UserRealmProxyInterface realmObjectTarget = (com_smtm_reminders_realm_module_UserRealmProxyInterface) realmObject;
        com_smtm_reminders_realm_module_UserRealmProxyInterface realmObjectSource = (com_smtm_reminders_realm_module_UserRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$nickname(realmObjectSource.realmGet$nickname());
        realmObjectTarget.realmSet$choice(realmObjectSource.realmGet$choice());
        realmObjectTarget.realmSet$gender(realmObjectSource.realmGet$gender());
        realmObjectTarget.realmSet$birthday(realmObjectSource.realmGet$birthday());
        realmObjectTarget.realmSet$sessionTimer(realmObjectSource.realmGet$sessionTimer());
        realmObjectTarget.realmSet$isBlinkEye(realmObjectSource.realmGet$isBlinkEye());
        realmObjectTarget.realmSet$isSmiling(realmObjectSource.realmGet$isSmiling());
        realmObjectTarget.realmSet$isEyeeMeasure(realmObjectSource.realmGet$isEyeeMeasure());
        realmObjectTarget.realmSet$isStreamVolume(realmObjectSource.realmGet$isStreamVolume());
        realmObjectTarget.realmSet$distanceCM(realmObjectSource.realmGet$distanceCM());
        realmObjectTarget.realmSet$eyeDistanceAvg(realmObjectSource.realmGet$eyeDistanceAvg());
        realmObjectTarget.realmSet$eyeDistanceWarning(realmObjectSource.realmGet$eyeDistanceWarning());
        realmObjectTarget.realmSet$eyeDistanceCancel(realmObjectSource.realmGet$eyeDistanceCancel());
        realmObjectTarget.realmSet$checkPassword(realmObjectSource.realmGet$checkPassword());
        realmObjectTarget.realmSet$password(realmObjectSource.realmGet$password());
        realmObjectTarget.realmSet$passwordConfirm(realmObjectSource.realmGet$passwordConfirm());
        RealmList<com.smtm.reminders.realm.module.ListSchema> daysList = realmObjectSource.realmGet$days();
        RealmList<com.smtm.reminders.realm.module.ListSchema> daysRealmList = realmObjectTarget.realmGet$days();
        if (daysList != null && daysList.size() == daysRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = daysList.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.ListSchema daysItem = daysList.get(i);
                com.smtm.reminders.realm.module.ListSchema cachedays = (com.smtm.reminders.realm.module.ListSchema) cache.get(daysItem);
                if (cachedays != null) {
                    daysRealmList.set(i, cachedays);
                } else {
                    daysRealmList.set(i, com_smtm_reminders_realm_module_ListSchemaRealmProxy.copyOrUpdate(realm, daysItem, true, cache));
                }
            }
        } else {
            daysRealmList.clear();
            if (daysList != null) {
                for (int i = 0; i < daysList.size(); i++) {
                    com.smtm.reminders.realm.module.ListSchema daysItem = daysList.get(i);
                    com.smtm.reminders.realm.module.ListSchema cachedays = (com.smtm.reminders.realm.module.ListSchema) cache.get(daysItem);
                    if (cachedays != null) {
                        daysRealmList.add(cachedays);
                    } else {
                        daysRealmList.add(com_smtm_reminders_realm_module_ListSchemaRealmProxy.copyOrUpdate(realm, daysItem, true, cache));
                    }
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nickname:");
        stringBuilder.append(realmGet$nickname());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{choice:");
        stringBuilder.append(realmGet$choice());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gender:");
        stringBuilder.append(realmGet$gender() != null ? realmGet$gender() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthday:");
        stringBuilder.append(realmGet$birthday() != null ? realmGet$birthday() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sessionTimer:");
        stringBuilder.append(realmGet$sessionTimer());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isBlinkEye:");
        stringBuilder.append(realmGet$isBlinkEye());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isSmiling:");
        stringBuilder.append(realmGet$isSmiling());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isEyeeMeasure:");
        stringBuilder.append(realmGet$isEyeeMeasure());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isStreamVolume:");
        stringBuilder.append(realmGet$isStreamVolume());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{distanceCM:");
        stringBuilder.append(realmGet$distanceCM());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eyeDistanceAvg:");
        stringBuilder.append(realmGet$eyeDistanceAvg());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eyeDistanceWarning:");
        stringBuilder.append(realmGet$eyeDistanceWarning());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eyeDistanceCancel:");
        stringBuilder.append(realmGet$eyeDistanceCancel());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{checkPassword:");
        stringBuilder.append(realmGet$checkPassword());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{passwordConfirm:");
        stringBuilder.append(realmGet$passwordConfirm() != null ? realmGet$passwordConfirm() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{days:");
        stringBuilder.append("RealmList<ListSchema>[").append(realmGet$days().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_smtm_reminders_realm_module_UserRealmProxy aUser = (com_smtm_reminders_realm_module_UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
