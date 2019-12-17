package com.smtm.reminders.realm.module;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ListSchema extends RealmObject {
    @Required
    private String name;
    private Date created_at;
    private RealmList<TaskSchema> taskSchemas;
    @PrimaryKey
    private int id;

    private boolean choice;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public RealmList<TaskSchema> getTaskSchemas() {
        return taskSchemas;
    }

    public void setTaskSchemas(RealmList<TaskSchema> taskSchemas) {
        this.taskSchemas = taskSchemas;
    }


    public boolean isChoice() {
        return choice;
    }

    public void setChoice(boolean choice) {
        this.choice = choice;
    }
}
