package io.realm;


public interface com_smtm_reminders_realm_module_UserRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$nickname();
    public void realmSet$nickname(String value);
    public boolean realmGet$choice();
    public void realmSet$choice(boolean value);
    public String realmGet$gender();
    public void realmSet$gender(String value);
    public java.util.Date realmGet$birthday();
    public void realmSet$birthday(java.util.Date value);
    public long realmGet$sessionTimer();
    public void realmSet$sessionTimer(long value);
    public boolean realmGet$isBlinkEye();
    public void realmSet$isBlinkEye(boolean value);
    public boolean realmGet$isSmiling();
    public void realmSet$isSmiling(boolean value);
    public boolean realmGet$isEyeeMeasure();
    public void realmSet$isEyeeMeasure(boolean value);
    public boolean realmGet$isStreamVolume();
    public void realmSet$isStreamVolume(boolean value);
    public int realmGet$distanceCM();
    public void realmSet$distanceCM(int value);
    public float realmGet$eyeDistanceAvg();
    public void realmSet$eyeDistanceAvg(float value);
    public float realmGet$eyeDistanceWarning();
    public void realmSet$eyeDistanceWarning(float value);
    public float realmGet$eyeDistanceCancel();
    public void realmSet$eyeDistanceCancel(float value);
    public boolean realmGet$checkPassword();
    public void realmSet$checkPassword(boolean value);
    public String realmGet$password();
    public void realmSet$password(String value);
    public String realmGet$passwordConfirm();
    public void realmSet$passwordConfirm(String value);
    public RealmList<com.smtm.reminders.realm.module.ListSchema> realmGet$days();
    public void realmSet$days(RealmList<com.smtm.reminders.realm.module.ListSchema> value);
}
