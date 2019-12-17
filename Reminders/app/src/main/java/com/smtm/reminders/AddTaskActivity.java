package com.smtm.reminders;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.smtm.reminders.custom.ClearEditText;
import com.smtm.reminders.custom.DateInputMask;
import com.smtm.reminders.realm.module.ListSchema;
import com.smtm.reminders.realm.module.TaskSchema;
import com.smtm.reminders.realm.module.User;
import com.smtm.reminders.utils.Dlog;
import com.smtm.reminders.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class AddTaskActivity extends AppCompatActivity {
    @BindView(R.id.imgBackWhiteLeft)
    ImageView imgBackWhiteLeft;

    @BindView(R.id.ed_nick_name)
    ClearEditText ed_nick_name;


    @BindView(R.id.tv_remind_at)
    TextView tv_remind_at;

    @BindView(R.id.bt_done)
    TextView bt_done;

    @BindString(R.string.register)
    String register;


    private Realm mRealm;
    private Context mContext;
    private String mNickName = "";
    private String mBirthday = "";
    Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        ButterKnife.bind(this);

        Dlog.e("onCreate()");
        mContext = this;
        mRealm = Realm.getDefaultInstance();

        bt_done.setText(register);
        mNickName = "";
        mBirthday = "";


        ed_nick_name.setText(mNickName);
        tv_remind_at.setText(mBirthday);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close(); // Remember to close Realm when done.
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.tv_remind_at)
    void tv_remind_at() {
        mCalendar = Calendar.getInstance();

        Calendar cal = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(AddTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                String msg = String.format("%d 년 %d 월 %d 일", year, month + 1, date);
                Dlog.e("msg : " + msg);
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DATE, date);
                timePicker();
            }
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));

        dialog.getDatePicker().setMaxDate(new Date().getTime());    //입력한 날짜 이후로 클릭 안되게 옵션
        dialog.show();
    }

    private void timePicker() {
        Calendar cal = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(AddTaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                mCalendar.set(Calendar.HOUR_OF_DAY, hour);
                mCalendar.set(Calendar.MINUTE, min);
                String msg = String.format("%d 시 %d 분", hour, min);


                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String today = sdf.format(mCalendar.getTime());
                tv_remind_at.setText(today);
            }
        }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);  //마지막 boolean 값은 시간을 24시간으로 보일지 아닐지

        dialog.show();

    }


    @OnClick(R.id.bt_done)
    void membership() {
        mNickName = ed_nick_name.getText().toString().trim();
        mBirthday = tv_remind_at.getText().toString().trim();
        Dlog.e("nickName : " + mNickName);
        Dlog.e("birthday : " + mBirthday);

        mBirthday = Utils.StringReplace(mBirthday).trim();
        Dlog.e("mBirthday : " + mBirthday);
        boolean c = Pattern.matches("^[0-9]*$", mBirthday);
        Dlog.e("mBirthday : " + c);

        if (TextUtils.isEmpty(mNickName)) {
            Toast.makeText(AddTaskActivity.this, "이름을 입력해주셍쇼", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mBirthday)) {
            Toast.makeText(AddTaskActivity.this, "날짜 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }


        Date remind_at = mCalendar.getTime();


        setRegister(mNickName, remind_at);
    }

    private void setRegister(String nickName, Date remind_at) {
        try {
            Dlog.e("setRegister()");
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    ListSchema Item = mRealm.where(ListSchema.class).equalTo("choice", true).findFirst();
                    RealmList<TaskSchema> list_task = Item.getTaskSchemas();
                    int nextId = 0;
                    Number currentIdNum = mRealm.where(TaskSchema.class).max("id");
                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    TaskSchema taskSchema = new TaskSchema();
                    taskSchema.setList(Item.getId());
                    taskSchema.setId(nextId);
                    taskSchema.setName(nickName);
                    taskSchema.setStatus("to do");
                    taskSchema.setCreated_at(new Date());
                    taskSchema.setRemind_at(remind_at);
                    list_task.add(taskSchema);

                    setResult(Activity.RESULT_OK);
                    finish();
                }
            });

        } catch (Exception e) {
            Dlog.e("Exception : " + e.toString());
        }
    }

    private void showDialogConfirm(final Context context, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.dialog_confirm_line);

        //Grab the window of the dialog, and change the width
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        //This makes the dialog take up the full width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        lp.width = width - (int) Utils.convertDpToPixel(30, mContext);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        TextView tvMessageBody = (TextView) dialog.findViewById(R.id.tvMessageBody);
        Button btPositive = (Button) dialog.findViewById(R.id.btPositive);
        btPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });

        tvMessageBody.setText(message);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @OnClick(R.id.imgBackWhiteLeft)
    void onClickBack() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

}
