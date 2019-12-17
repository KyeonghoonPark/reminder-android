package com.smtm.reminders;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smtm.reminders.adapter.ListSchemaAdapter;
import com.smtm.reminders.adapter.TaskSchemaAdapter;
import com.smtm.reminders.custom.ClearEditText;
import com.smtm.reminders.dialog.DialogManager;
import com.smtm.reminders.realm.module.ListSchema;
import com.smtm.reminders.realm.module.TaskSchema;
import com.smtm.reminders.utils.Dlog;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements ListSchemaAdapter.ListSchemaClickListener, ClearEditText.AfterTextChangedListener, TaskSchemaAdapter.TaskSchemaClickListener {
    private Context mContext;
    private Realm mRealm;

    ArrayList<ListSchema> mListSchemaItem;
    ListSchemaAdapter mListSchemaAdapter;


    ArrayList<TaskSchema> mTaskSchemaItem;
    TaskSchemaAdapter mTaskSchemaAdapter;

    @BindView(R.id.ed_search)
    ClearEditText ed_search;


    @BindView(R.id.ll_scheduled)
    LinearLayout ll_scheduled;


    @BindView(R.id.rl_list_schema)
    RecyclerView rl_list_schema;


    @BindView(R.id.ll_add_list)
    LinearLayout ll_add_list;


    @BindView(R.id.tv_task_name)
    TextView tv_task_name;


    @BindView(R.id.iv_task_add)
    ImageView iv_task_add;

    @BindView(R.id.rl_task_schema)
    RecyclerView rl_task_schema;


    @BindString(R.string.add_list)
    String add_list;

    @OnClick(R.id.ll_add_list)
    void addList() {
        // 추가
        Dlog.e("addList()");
        DialogManager.addListDialog(mContext, add_list, new DialogManager.MyDialogListener() {
            @Override
            public void onPositiveClicked(Bundle bundle) {
                try {
                    String name = (String) bundle.get("name");
                    Date created_at = new Date();

                    final ListSchema listSchemaItem = new ListSchema();
                    Number currentIdNum = mRealm.where(ListSchema.class).max("id");
                    int nextId;
                    if (currentIdNum == null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    listSchemaItem.setId(nextId);
                    listSchemaItem.setName(name);
                    listSchemaItem.setCreated_at(created_at);
                    listSchemaItem.setChoice(true);
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            RealmResults<ListSchema> result2 = realm.where(ListSchema.class).findAll();
                            for (int i = 0; i < result2.size(); i++) {
                                ListSchema info = result2.get(i);
                                info.setChoice(false);
                            }

                            realm.copyToRealmOrUpdate(listSchemaItem);
                            ListSchemaNotivyData();
                        }
                    });

                } catch (Exception e) {
                    Dlog.e("Exception : " + e.toString());
                }
            }

            @Override
            public void onNegativeClicked(Bundle bundle) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Dlog.e("onActivityResult() : " + requestCode);
        if (resultCode == Activity.RESULT_OK) {
            Dlog.e("onActivityResult() : 1");
            if (requestCode == RESULT_ADD_TASK_CODE) {
                Dlog.e("onActivityResult() : 2");
                TaskSchemaNotivyData();
//                mRealm.executeTransaction(new Realm.Transaction() {
//                    @Override
//                    public void execute(Realm realm) {
//                        ListSchema item = mRealm.where(ListSchema.class).equalTo("choice", true).findFirst();
//                        RealmList<TaskSchema> list_task = item.getTaskSchemas();
//                        if (list_task != null && list_task.size() > 0) {
//                            RealmResults<TaskSchema> task_date = list_task.getRealm().where(TaskSchema.class)
//                                    .equalTo("id", item.getId())
//                                    .findAll();
//
//
//                            Dlog.e("onActivityResult() : 333");
//                        }
//                    }
//                });
            }
        }

    }



    @Override
    public void onItemChoseListner(int position) {
        Dlog.e("onItemChoseListner() : " + position);
        ListSchema item = mListSchemaItem.get(position);
        // 같은 아이디 클릭시 작동 안함.
        if (item.isChoice()) {
            return;
        }

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<ListSchema> result2 = realm.where(ListSchema.class).findAll();
                for (int i = 0; i < result2.size(); i++) {
                    ListSchema ListSchemaInfo = result2.get(i);
                    ListSchemaInfo.setChoice(false);
                    if (i == position) {
                        ListSchemaInfo.setChoice(true);
                    }
                }
//                ListSchema userInfo = mRealm.where(ListSchema.class).equalTo("choice", true).findFirst();


                ListSchemaNotivyData();
            }
        });


    }


    @Override
    public void onItemModifyListner(int position) {

    }

    @Override
    public void onItemDeleteListner(int position) {
        RealmResults<ListSchema> result = mRealm.where(ListSchema.class).findAll();
        // 사용자 없으니 기본 사용자
        if (result.size() <= 1) {
            return;
        } else {
            mRealm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm bgRealm) {
                    ListSchema result = bgRealm.where(ListSchema.class).equalTo("choice", true).findFirst();
                    result.deleteFromRealm();

                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    Dlog.e("onSuccess()");
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            RealmResults<ListSchema> result2 = realm.where(ListSchema.class).findAll();
                            for (int i = 0; i < result2.size(); i++) {
                                ListSchema listSchemaInfo = result2.get(i);
                                listSchemaInfo.setChoice(false);
                                if (i == 0) {
                                    listSchemaInfo.setChoice(true);
                                }
                            }
                            ListSchemaNotivyData();
                        }
                    });

                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    Dlog.e("onError()");
                    error.printStackTrace();
                }
            });
        }
    }



    @Override
    public void onTaskItemChoseListner(int position) {
        Dlog.e("onItemChoseListner() : " + position);
        mTaskSchemaAdapter.mPosition = position;
        mTaskSchemaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTaskItemDeleteListner(int position) {

    }



    // 검색
    @Override
    public void afterTextChangedAction(String value) {
        Dlog.e("value : " + value);

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<ListSchema> result2 = realm.where(ListSchema.class).findAll();

            }
        });
    }

    public final static int RESULT_ADD_TASK_CODE = 22222;
    @OnClick(R.id.iv_task_add)
    void iv_task_add() {
        Dlog.e("iv_task_add()");
        Intent intent = new Intent(mContext, AddTaskActivity.class);
        startActivityForResult(intent, RESULT_ADD_TASK_CODE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;
        mRealm = Realm.getDefaultInstance();

        //List Schema
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        rl_list_schema.setLayoutManager(mLinearLayoutManager);
        mListSchemaItem = new ArrayList<>();
        mListSchemaAdapter = new ListSchemaAdapter(mContext, mListSchemaItem, this);
        rl_list_schema.setAdapter(mListSchemaAdapter);



        LinearLayoutManager mLinearLayoutManager_one = new LinearLayoutManager(this);
        rl_task_schema.setLayoutManager(mLinearLayoutManager_one);
        mTaskSchemaItem = new ArrayList<>();
        mTaskSchemaAdapter = new TaskSchemaAdapter(mContext, mTaskSchemaItem, this);
        rl_task_schema.setAdapter(mTaskSchemaAdapter);


        ListSchemaSetting();

        ed_search.setAfterTextChangedListener(this);
    }


    public void ListSchemaSetting() {
        Dlog.e("ListSchemaSetting()");
        RealmResults<ListSchema> result = mRealm.where(ListSchema.class).findAll();
        // 사용자 없으니 기본 사용자
        if (result.size() == 0) {
            try {
                Date created_at = new Date();
                ListSchema listSchema = new ListSchema();
                listSchema.setId(1);
                listSchema.setName("새로운 목록");
                listSchema.setCreated_at(created_at);
                listSchema.setChoice(true);

                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.copyToRealmOrUpdate(listSchema);
                        ListSchemaNotivyData();
                    }
                });
            } catch (Exception e) {
                Dlog.e("Exception : " + e.toString());
            }
        } else {
            ListSchemaNotivyData();
        }

    }


    void ListSchemaNotivyData() {
        Dlog.e("ListSchemaNotivyData()");
        RealmResults<ListSchema> result = mRealm.where(ListSchema.class).findAll();
        mListSchemaItem.clear();
        for (int i = 0; i < result.size(); i++) {
            ArrayList<ListSchema> item = new ArrayList<ListSchema>();
            item.add(result.get(i));
            mListSchemaItem.add(result.get(i));
            if (result.get(i).isChoice()) {
                tv_task_name.setText(result.get(i).getName());
            }
        }
        mListSchemaAdapter.notifyDataSetChanged();
        TaskSchemaNotivyData();
    }


    void TaskSchemaNotivyData() {
        Dlog.e("TaskSchemaNotivyData()");
        mTaskSchemaItem.clear();
        ListSchema item = mRealm.where(ListSchema.class).equalTo("choice", true).findFirst();
        RealmList<TaskSchema> list_task = item.getTaskSchemas();
        if (list_task != null && list_task.size() > 0) {
            RealmResults<TaskSchema> task_date = list_task.getRealm().where(TaskSchema.class)
                    .equalTo("list", item.getId())
                    .findAll();
            Dlog.e("task_date.size() : " + task_date.size());
            for (int i = 0; i < task_date.size(); i++) {
                mTaskSchemaItem.add(task_date.get(i));
            }
            mTaskSchemaAdapter.notifyDataSetChanged();
        }

    }
}
