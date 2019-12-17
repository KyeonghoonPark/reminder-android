package com.smtm.reminders.realm.module;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * null값이 들어갈 가능성이 있는 타입의 필드 중, null값을 허용하지 않으려면 @Required 어노테이션을 붙인다.
 * Boolean, Byte, Short, Integer, Long, Float, Double, String, byte[], Date 타입에 @Required 어노테이션을 붙일 수 있다.
 * 그 외의 타입들은 @Required 어노테이션을 붙이게 되면, 컴파일이 실패하게 된다.
 */
public class TaskSchema extends RealmObject {
    //    @PrimaryKey


    @Required
    private String name;
    private String status;
    private Date created_at;
    private Date remind_at;

    private int id;
    private int list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getList() {
        return list;
    }

    public void setList(int list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getRemind_at() {
        return remind_at;
    }

    public void setRemind_at(Date remind_at) {
        this.remind_at = remind_at;
    }
}
