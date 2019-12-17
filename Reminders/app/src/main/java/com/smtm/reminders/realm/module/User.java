package com.smtm.reminders.realm.module;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject {

    @PrimaryKey
    private int id;
    @Required // null 허용 하지 않음.
    private String nickname;
    private boolean choice;
    private String gender;
    private Date birthday;

    private long sessionTimer; // 사용시간
    private boolean isBlinkEye; // 눈 깜박임
    private boolean isSmiling; // 웃음 체크
    private boolean isEyeeMeasure; // 거리 측정

    private boolean isStreamVolume; // 음향 조절
    private int distanceCM; // 거리 cm

    private float eyeDistanceAvg;
    private float eyeDistanceWarning;
    private float eyeDistanceCancel;

    private boolean checkPassword; // 비밀번호 설정
    private String password; // 비밀번호
    private String passwordConfirm; // 비밀번호

    private RealmList<ListSchema> days;



}
