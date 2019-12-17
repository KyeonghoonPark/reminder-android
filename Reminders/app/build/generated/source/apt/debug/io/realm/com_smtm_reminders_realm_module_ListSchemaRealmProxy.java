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
public class com_smtm_reminders_realm_module_ListSchemaRealmProxy extends com.smtm.reminders.realm.module.ListSchema
    implements RealmObjectProxy, com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface {

    static final class ListSchemaColumnInfo extends ColumnInfo {
        long nameIndex;
        long created_atIndex;
        long taskSchemasIndex;
        long idIndex;
        long choiceIndex;

        ListSchemaColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ListSchema");
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.created_atIndex = addColumnDetails("created_at", "created_at", objectSchemaInfo);
            this.taskSchemasIndex = addColumnDetails("taskSchemas", "taskSchemas", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.choiceIndex = addColumnDetails("choice", "choice", objectSchemaInfo);
        }

        ListSchemaColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ListSchemaColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ListSchemaColumnInfo src = (ListSchemaColumnInfo) rawSrc;
            final ListSchemaColumnInfo dst = (ListSchemaColumnInfo) rawDst;
            dst.nameIndex = src.nameIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.taskSchemasIndex = src.taskSchemasIndex;
            dst.idIndex = src.idIndex;
            dst.choiceIndex = src.choiceIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ListSchemaColumnInfo columnInfo;
    private ProxyState<com.smtm.reminders.realm.module.ListSchema> proxyState;
    private RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasRealmList;

    com_smtm_reminders_realm_module_ListSchemaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ListSchemaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.smtm.reminders.realm.module.ListSchema>(this);
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
    public RealmList<com.smtm.reminders.realm.module.TaskSchema> realmGet$taskSchemas() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (taskSchemasRealmList != null) {
            return taskSchemasRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.taskSchemasIndex);
            taskSchemasRealmList = new RealmList<com.smtm.reminders.realm.module.TaskSchema>(com.smtm.reminders.realm.module.TaskSchema.class, osList, proxyState.getRealm$realm());
            return taskSchemasRealmList;
        }
    }

    @Override
    public void realmSet$taskSchemas(RealmList<com.smtm.reminders.realm.module.TaskSchema> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("taskSchemas")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.smtm.reminders.realm.module.TaskSchema> original = value;
                value = new RealmList<com.smtm.reminders.realm.module.TaskSchema>();
                for (com.smtm.reminders.realm.module.TaskSchema item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.taskSchemasIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.TaskSchema linkedObject = value.get(i);
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
                com.smtm.reminders.realm.module.TaskSchema linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ListSchema", 5, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("created_at", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("taskSchemas", RealmFieldType.LIST, "TaskSchema");
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("choice", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ListSchemaColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ListSchemaColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ListSchema";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ListSchema";
    }

    @SuppressWarnings("cast")
    public static com.smtm.reminders.realm.module.ListSchema createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.smtm.reminders.realm.module.ListSchema obj = null;
        if (update) {
            Table table = realm.getTable(com.smtm.reminders.realm.module.ListSchema.class);
            ListSchemaColumnInfo columnInfo = (ListSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_smtm_reminders_realm_module_ListSchemaRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("taskSchemas")) {
                excludeFields.add("taskSchemas");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_smtm_reminders_realm_module_ListSchemaRealmProxy) realm.createObjectInternal(com.smtm.reminders.realm.module.ListSchema.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_smtm_reminders_realm_module_ListSchemaRealmProxy) realm.createObjectInternal(com.smtm.reminders.realm.module.ListSchema.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface objProxy = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
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
        if (json.has("taskSchemas")) {
            if (json.isNull("taskSchemas")) {
                objProxy.realmSet$taskSchemas(null);
            } else {
                objProxy.realmGet$taskSchemas().clear();
                JSONArray array = json.getJSONArray("taskSchemas");
                for (int i = 0; i < array.length(); i++) {
                    com.smtm.reminders.realm.module.TaskSchema item = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$taskSchemas().add(item);
                }
            }
        }
        if (json.has("choice")) {
            if (json.isNull("choice")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'choice' to null.");
            } else {
                objProxy.realmSet$choice((boolean) json.getBoolean("choice"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.smtm.reminders.realm.module.ListSchema createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.smtm.reminders.realm.module.ListSchema obj = new com.smtm.reminders.realm.module.ListSchema();
        final com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface objProxy = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) obj;
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
            } else if (name.equals("taskSchemas")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$taskSchemas(null);
                } else {
                    objProxy.realmSet$taskSchemas(new RealmList<com.smtm.reminders.realm.module.TaskSchema>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.smtm.reminders.realm.module.TaskSchema item = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$taskSchemas().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("choice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$choice((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'choice' to null.");
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

    public static com.smtm.reminders.realm.module.ListSchema copyOrUpdate(Realm realm, com.smtm.reminders.realm.module.ListSchema object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.smtm.reminders.realm.module.ListSchema) cachedRealmObject;
        }

        com.smtm.reminders.realm.module.ListSchema realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.smtm.reminders.realm.module.ListSchema.class);
            ListSchemaColumnInfo columnInfo = (ListSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_smtm_reminders_realm_module_ListSchemaRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.smtm.reminders.realm.module.ListSchema copy(Realm realm, com.smtm.reminders.realm.module.ListSchema newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.smtm.reminders.realm.module.ListSchema) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.smtm.reminders.realm.module.ListSchema realmObject = realm.createObjectInternal(com.smtm.reminders.realm.module.ListSchema.class, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface realmObjectSource = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) newObject;
        com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface realmObjectCopy = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$created_at(realmObjectSource.realmGet$created_at());

        RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasList = realmObjectSource.realmGet$taskSchemas();
        if (taskSchemasList != null) {
            RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasRealmList = realmObjectCopy.realmGet$taskSchemas();
            taskSchemasRealmList.clear();
            for (int i = 0; i < taskSchemasList.size(); i++) {
                com.smtm.reminders.realm.module.TaskSchema taskSchemasItem = taskSchemasList.get(i);
                com.smtm.reminders.realm.module.TaskSchema cachetaskSchemas = (com.smtm.reminders.realm.module.TaskSchema) cache.get(taskSchemasItem);
                if (cachetaskSchemas != null) {
                    taskSchemasRealmList.add(cachetaskSchemas);
                } else {
                    taskSchemasRealmList.add(com_smtm_reminders_realm_module_TaskSchemaRealmProxy.copyOrUpdate(realm, taskSchemasItem, update, cache));
                }
            }
        }

        realmObjectCopy.realmSet$choice(realmObjectSource.realmGet$choice());
        return realmObject;
    }

    public static long insert(Realm realm, com.smtm.reminders.realm.module.ListSchema object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.smtm.reminders.realm.module.ListSchema.class);
        long tableNativePtr = table.getNativePtr();
        ListSchemaColumnInfo columnInfo = (ListSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
        }

        RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasList = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$taskSchemas();
        if (taskSchemasList != null) {
            OsList taskSchemasOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.taskSchemasIndex);
            for (com.smtm.reminders.realm.module.TaskSchema taskSchemasItem : taskSchemasList) {
                Long cacheItemIndextaskSchemas = cache.get(taskSchemasItem);
                if (cacheItemIndextaskSchemas == null) {
                    cacheItemIndextaskSchemas = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.insert(realm, taskSchemasItem, cache);
                }
                taskSchemasOsList.addRow(cacheItemIndextaskSchemas);
            }
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$choice(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.smtm.reminders.realm.module.ListSchema.class);
        long tableNativePtr = table.getNativePtr();
        ListSchemaColumnInfo columnInfo = (ListSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.smtm.reminders.realm.module.ListSchema object = null;
        while (objects.hasNext()) {
            object = (com.smtm.reminders.realm.module.ListSchema) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
            }

            RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasList = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$taskSchemas();
            if (taskSchemasList != null) {
                OsList taskSchemasOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.taskSchemasIndex);
                for (com.smtm.reminders.realm.module.TaskSchema taskSchemasItem : taskSchemasList) {
                    Long cacheItemIndextaskSchemas = cache.get(taskSchemasItem);
                    if (cacheItemIndextaskSchemas == null) {
                        cacheItemIndextaskSchemas = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.insert(realm, taskSchemasItem, cache);
                    }
                    taskSchemasOsList.addRow(cacheItemIndextaskSchemas);
                }
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$choice(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.smtm.reminders.realm.module.ListSchema object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.smtm.reminders.realm.module.ListSchema.class);
        long tableNativePtr = table.getNativePtr();
        ListSchemaColumnInfo columnInfo = (ListSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }

        OsList taskSchemasOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.taskSchemasIndex);
        RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasList = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$taskSchemas();
        if (taskSchemasList != null && taskSchemasList.size() == taskSchemasOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = taskSchemasList.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.TaskSchema taskSchemasItem = taskSchemasList.get(i);
                Long cacheItemIndextaskSchemas = cache.get(taskSchemasItem);
                if (cacheItemIndextaskSchemas == null) {
                    cacheItemIndextaskSchemas = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.insertOrUpdate(realm, taskSchemasItem, cache);
                }
                taskSchemasOsList.setRow(i, cacheItemIndextaskSchemas);
            }
        } else {
            taskSchemasOsList.removeAll();
            if (taskSchemasList != null) {
                for (com.smtm.reminders.realm.module.TaskSchema taskSchemasItem : taskSchemasList) {
                    Long cacheItemIndextaskSchemas = cache.get(taskSchemasItem);
                    if (cacheItemIndextaskSchemas == null) {
                        cacheItemIndextaskSchemas = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.insertOrUpdate(realm, taskSchemasItem, cache);
                    }
                    taskSchemasOsList.addRow(cacheItemIndextaskSchemas);
                }
            }
        }

        Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$choice(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.smtm.reminders.realm.module.ListSchema.class);
        long tableNativePtr = table.getNativePtr();
        ListSchemaColumnInfo columnInfo = (ListSchemaColumnInfo) realm.getSchema().getColumnInfo(com.smtm.reminders.realm.module.ListSchema.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.smtm.reminders.realm.module.ListSchema object = null;
        while (objects.hasNext()) {
            object = (com.smtm.reminders.realm.module.ListSchema) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            java.util.Date realmGet$created_at = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$created_at();
            if (realmGet$created_at != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
            }

            OsList taskSchemasOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.taskSchemasIndex);
            RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasList = ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$taskSchemas();
            if (taskSchemasList != null && taskSchemasList.size() == taskSchemasOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = taskSchemasList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.smtm.reminders.realm.module.TaskSchema taskSchemasItem = taskSchemasList.get(i);
                    Long cacheItemIndextaskSchemas = cache.get(taskSchemasItem);
                    if (cacheItemIndextaskSchemas == null) {
                        cacheItemIndextaskSchemas = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.insertOrUpdate(realm, taskSchemasItem, cache);
                    }
                    taskSchemasOsList.setRow(i, cacheItemIndextaskSchemas);
                }
            } else {
                taskSchemasOsList.removeAll();
                if (taskSchemasList != null) {
                    for (com.smtm.reminders.realm.module.TaskSchema taskSchemasItem : taskSchemasList) {
                        Long cacheItemIndextaskSchemas = cache.get(taskSchemasItem);
                        if (cacheItemIndextaskSchemas == null) {
                            cacheItemIndextaskSchemas = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.insertOrUpdate(realm, taskSchemasItem, cache);
                        }
                        taskSchemasOsList.addRow(cacheItemIndextaskSchemas);
                    }
                }
            }

            Table.nativeSetBoolean(tableNativePtr, columnInfo.choiceIndex, rowIndex, ((com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) object).realmGet$choice(), false);
        }
    }

    public static com.smtm.reminders.realm.module.ListSchema createDetachedCopy(com.smtm.reminders.realm.module.ListSchema realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.smtm.reminders.realm.module.ListSchema unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.smtm.reminders.realm.module.ListSchema();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.smtm.reminders.realm.module.ListSchema) cachedObject.object;
            }
            unmanagedObject = (com.smtm.reminders.realm.module.ListSchema) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface unmanagedCopy = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) unmanagedObject;
        com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface realmSource = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$created_at(realmSource.realmGet$created_at());

        // Deep copy of taskSchemas
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$taskSchemas(null);
        } else {
            RealmList<com.smtm.reminders.realm.module.TaskSchema> managedtaskSchemasList = realmSource.realmGet$taskSchemas();
            RealmList<com.smtm.reminders.realm.module.TaskSchema> unmanagedtaskSchemasList = new RealmList<com.smtm.reminders.realm.module.TaskSchema>();
            unmanagedCopy.realmSet$taskSchemas(unmanagedtaskSchemasList);
            int nextDepth = currentDepth + 1;
            int size = managedtaskSchemasList.size();
            for (int i = 0; i < size; i++) {
                com.smtm.reminders.realm.module.TaskSchema item = com_smtm_reminders_realm_module_TaskSchemaRealmProxy.createDetachedCopy(managedtaskSchemasList.get(i), nextDepth, maxDepth, cache);
                unmanagedtaskSchemasList.add(item);
            }
        }
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$choice(realmSource.realmGet$choice());

        return unmanagedObject;
    }

    static com.smtm.reminders.realm.module.ListSchema update(Realm realm, com.smtm.reminders.realm.module.ListSchema realmObject, com.smtm.reminders.realm.module.ListSchema newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface realmObjectTarget = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) realmObject;
        com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface realmObjectSource = (com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$created_at(realmObjectSource.realmGet$created_at());
        RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasList = realmObjectSource.realmGet$taskSchemas();
        RealmList<com.smtm.reminders.realm.module.TaskSchema> taskSchemasRealmList = realmObjectTarget.realmGet$taskSchemas();
        if (taskSchemasList != null && taskSchemasList.size() == taskSchemasRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = taskSchemasList.size();
            for (int i = 0; i < objects; i++) {
                com.smtm.reminders.realm.module.TaskSchema taskSchemasItem = taskSchemasList.get(i);
                com.smtm.reminders.realm.module.TaskSchema cachetaskSchemas = (com.smtm.reminders.realm.module.TaskSchema) cache.get(taskSchemasItem);
                if (cachetaskSchemas != null) {
                    taskSchemasRealmList.set(i, cachetaskSchemas);
                } else {
                    taskSchemasRealmList.set(i, com_smtm_reminders_realm_module_TaskSchemaRealmProxy.copyOrUpdate(realm, taskSchemasItem, true, cache));
                }
            }
        } else {
            taskSchemasRealmList.clear();
            if (taskSchemasList != null) {
                for (int i = 0; i < taskSchemasList.size(); i++) {
                    com.smtm.reminders.realm.module.TaskSchema taskSchemasItem = taskSchemasList.get(i);
                    com.smtm.reminders.realm.module.TaskSchema cachetaskSchemas = (com.smtm.reminders.realm.module.TaskSchema) cache.get(taskSchemasItem);
                    if (cachetaskSchemas != null) {
                        taskSchemasRealmList.add(cachetaskSchemas);
                    } else {
                        taskSchemasRealmList.add(com_smtm_reminders_realm_module_TaskSchemaRealmProxy.copyOrUpdate(realm, taskSchemasItem, true, cache));
                    }
                }
            }
        }
        realmObjectTarget.realmSet$choice(realmObjectSource.realmGet$choice());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ListSchema = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created_at:");
        stringBuilder.append(realmGet$created_at() != null ? realmGet$created_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{taskSchemas:");
        stringBuilder.append("RealmList<TaskSchema>[").append(realmGet$taskSchemas().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{choice:");
        stringBuilder.append(realmGet$choice());
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
        com_smtm_reminders_realm_module_ListSchemaRealmProxy aListSchema = (com_smtm_reminders_realm_module_ListSchemaRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aListSchema.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aListSchema.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aListSchema.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
