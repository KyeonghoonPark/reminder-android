package io.realm;


public interface com_smtm_reminders_realm_module_ListSchemaRealmProxyInterface {
    public String realmGet$name();
    public void realmSet$name(String value);
    public java.util.Date realmGet$created_at();
    public void realmSet$created_at(java.util.Date value);
    public RealmList<com.smtm.reminders.realm.module.TaskSchema> realmGet$taskSchemas();
    public void realmSet$taskSchemas(RealmList<com.smtm.reminders.realm.module.TaskSchema> value);
    public int realmGet$id();
    public void realmSet$id(int value);
    public boolean realmGet$choice();
    public void realmSet$choice(boolean value);
}
