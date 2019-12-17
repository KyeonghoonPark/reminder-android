package com.smtm.reminders.realm.module;


import io.realm.annotations.RealmModule;

/**
 * DB 테이블 보는 법
 * chrome://inspect
 */

@RealmModule(classes = {ListSchema.class, TaskSchema.class})
public class SimpleRealmModule {

}
