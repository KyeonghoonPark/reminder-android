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
public class com_smtm_reminders_realm_module_TaskSchemaRealmProxy extends com.smtm.reminders.realm.module.TaskSchema
    implements RealmObjectProxy, com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface {

    static final class TaskSchemaColumnInfo extends ColumnInfo {
        long nameIndex;
        long statusIndex;
        long created_atIndex;
        long remind_atIndex;
        long idIndex;
        long listIndex;

        TaskSchemaColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("TaskSchema");
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.created_atIndex = addColumnDetails("created_at", "created_at", objectSchemaInfo);
            this.remind_atIndex = addColumnDetails("remind_at", "remind_at", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.listIndex = addColumnDetails("list", "list", objectSchemaInfo);
        }

        TaskSchemaColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TaskSchemaColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TaskSchemaColumnInfo src = (TaskSchemaColumnInfo) rawSrc;
            final TaskSchemaColumnInfo dst = (TaskSchemaColumnInfo) rawDst;
            dst.nameIndex = src.nameIndex;
            dst.statusIndex = src.statusIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.remind_atIndex = src.remind_atIndex;
            dst.idIndex = src.idIndex;
            dst.listIndex = src.listIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TaskSchemaColumnInfo columnInfo;
    private ProxyState<com.smtm.reminders.realm.module.TaskSchema> proxyState;

    com_smtm_reminders_realm_module_TaskSchemaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaskSchemaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.smtm.reminders.realm.module.TaskSchema>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'name' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$created_at() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.created_atIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.created_atIndex);
    }

    @Override
    public void realmSet$created_at(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.created_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.created_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.created_atIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.created_atIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$remind_at() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.remind_atIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.remind_atIndex);
    }

    @Override
    public void realmSet$remind_at(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.remind_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.remind_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.remind_atIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.remind_atIndex, value);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$list() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.listIndex);
    }

    @Override
    public void realmSet$list(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.listIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.listIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("TaskSchema", 6, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("created_at", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("remind_at", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("list", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TaskSchemaColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TaskSchemaColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "TaskSchema";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "TaskSchema";
    }

    @SuppressWarnings("cast")
    public static com.smtm.reminders.realm.module.TaskSchema createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.smtm.reminders.realm.module.TaskSchema obj = realm.createObjectInternal(com.smtm.reminders.realm.module.TaskSchema.class, true, excludeFields);

        final com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface objProxy = (com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                objProxy.realmSet$created_at(null);
            } else {
                Object timestamp = json.get("created_at");
                if (timestamp instanceof String) {
                    objProxy.realmSet$created_at(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$created_at(new Date(json.getLong("created_at")));
                }
            }
        }
        if (json.has("remind_at")) {
            if (json.isNull("remind_at")) {
                objProxy.realmSet$remind_at(null);
            } else {
                Object timestamp = json.get("remind_at");
                if (timestamp instanceof String) {
                    objProxy.realmSet$remind_at(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$remind_at(new Date(json.getLong("remind_at")));
                }
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("list")) {
            if (json.isNull("list")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'list' to null.");
            } else {
                objProxy.realmSet$list((int) json.getInt("list"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.smtm.reminders.realm.module.TaskSchema createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.smtm.reminders.realm.module.TaskSchema obj = new com.smtm.reminders.realm.module.TaskSchema();
        final com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface objProxy = (com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$created_at(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$created_at(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$created_at(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("remind_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$remind_at(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$remind_at(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$remind_at(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
            } else if (name.equals("list")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$list((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'list' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.smtm.reminders.realm.module.TaskSchema copyOrUpdate(Realm realm, com.smtm.reminders.realm.module.TaskSchema object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.smtm.reminders.realm.module.TaskSchema) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.smtm.reminders.realm.module.TaskSchema copy(Realm realm, com.smtm.reminders.realm.module.TaskSchema newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.smtm.reminders.realm.module.TaskSchema) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.smtm.reminders.realm.module.TaskSchema realmObject = realm.createObjectInternal(com.smtm.reminders.realm.module.TaskSchema.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface realmObjectSource = (com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) newObject;
        com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface realmObjectCopy = (com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$created_at(realmObjectSource.realmGet$created_at());
        realmObjectCopy.realmSet$remind_at(realmObjectSource.realmGet$remind_at());
        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$list(realmObjectSource.realmGet$list());
        return realmObject;
    }

    public static long insert(Realm realm, com.smtm.reminders.realm.module.TaskSchema object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.smtm.reminders.realm.module.TaskSchema.class);
        long tableNativePtr = table.getNativePtr();
        TaskSchemaColumnInfo columnInfo = (TaskSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.TaskSchema.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$status = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
        }
        java.util.Date realmGet$remind_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$remind_at();
        if (realmGet$remind_at != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.remind_atIndex, rowIndex, realmGet$remind_at.getTime(), false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.listIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$list(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.smtm.reminders.realm.module.TaskSchema.class);
        long tableNativePtr = table.getNativePtr();
        TaskSchemaColumnInfo columnInfo = (TaskSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.TaskSchema.class);
        com.smtm.reminders.realm.module.TaskSchema object = null;
        while (objects.hasNext()) {
            object = (com.smtm.reminders.realm.module.TaskSchema) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$status = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
            }
            java.util.Date realmGet$remind_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$remind_at();
            if (realmGet$remind_at != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.remind_atIndex, rowIndex, realmGet$remind_at.getTime(), false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.listIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$list(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.smtm.reminders.realm.module.TaskSchema object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.smtm.reminders.realm.module.TaskSchema.class);
        long tableNativePtr = table.getNativePtr();
        TaskSchemaColumnInfo columnInfo = (TaskSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.TaskSchema.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$status = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        java.util.Date realmGet$remind_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$remind_at();
        if (realmGet$remind_at != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.remind_atIndex, rowIndex, realmGet$remind_at.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.remind_atIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.listIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$list(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.smtm.reminders.realm.module.TaskSchema.class);
        long tableNativePtr = table.getNativePtr();
        TaskSchemaColumnInfo columnInfo = (TaskSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.TaskSchema.class);
        com.smtm.reminders.realm.module.TaskSchema object = null;
        while (objects.hasNext()) {
            object = (com.smtm.reminders.realm.module.TaskSchema) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$status = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
            }
            java.util.Date realmGet$remind_at = ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$remind_at();
            if (realmGet$remind_at != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.remind_atIndex, rowIndex, realmGet$remind_at.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.remind_atIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.listIndex, rowIndex, ((com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) object).realmGet$list(), false);
        }
    }

    public static com.smtm.reminders.realm.module.TaskSchema createDetachedCopy(com.smtm.reminders.realm.module.TaskSchema realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.smtm.reminders.realm.module.TaskSchema unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.smtm.reminders.realm.module.TaskSchema();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.smtm.reminders.realm.module.TaskSchema) cachedObject.object;
            }
            unmanagedObject = (com.smtm.reminders.realm.module.TaskSchema) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface unmanagedCopy = (com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) unmanagedObject;
        com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface realmSource = (com_smtm_reminders_realm_module_TaskSchemaRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$created_at(realmSource.realmGet$created_at());
        unmanagedCopy.realmSet$remind_at(realmSource.realmGet$remind_at());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$list(realmSource.realmGet$list());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("TaskSchema = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created_at:");
        stringBuilder.append(realmGet$created_at() != null ? realmGet$created_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{remind_at:");
        stringBuilder.append(realmGet$remind_at() != null ? realmGet$remind_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{list:");
        stringBuilder.append(realmGet$list());
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
        com_smtm_reminders_realm_module_TaskSchemaRealmProxy aTaskSchema = (com_smtm_reminders_realm_module_TaskSchemaRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aTaskSchema.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTaskSchema.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aTaskSchema.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
