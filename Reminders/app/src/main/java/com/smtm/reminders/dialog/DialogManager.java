package com.smtm.reminders.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.smtm.reminders.R;
import com.smtm.reminders.custom.ClearEditText;
import com.smtm.reminders.utils.Dlog;
import com.smtm.reminders.utils.Utils;


public class DialogManager {

    public interface MyDialogListener {
        public void onPositiveClicked(Bundle bundle);

        public void onNegativeClicked(Bundle bundle);
    }


    /**
     * 다이얼로그 창
     *
     * @param context
     */
    public static void ConfirmDialog(Context context, String title, String message, String button, View.OnClickListener onClickListener) {
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
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        lp.width = width - (int) Utils.convertDpToPixel(30, context);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
        TextView tvMessageBody = (TextView) dialog.findViewById(R.id.tvMessageBody);
        tvMessageBody.setGravity(Gravity.LEFT);
        tvMessageBody.setMovementMethod(new ScrollingMovementMethod());
        Button btPositive = (Button) dialog.findViewById(R.id.btPositive);

        tvTitle.setText(title);
        btPositive.setText(button);
        tvMessageBody.setText(message);

        btPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                isShowDialog = false;
                onClickListener.onClick(v);
                dialog.dismiss();
            }
        });

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dialog.dismiss();
                }
                return true;
            }
        });

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        if (!((Activity) context).isFinishing()) {
            //show dialog
            dialog.show();
        }
    }


    public static void addListDialog(Context context, String title, MyDialogListener myDialogListener) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.dialog_add_list, null, false);

        final ClearEditText ed_name = (ClearEditText) formElementsView.findViewById(R.id.ed_name);

        int m_nMaxLengthOfDeviceName = 4;
        ed_name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(m_nMaxLengthOfDeviceName)});


        // the alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(formElementsView);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Dlog.e("setPositiveButton");
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ed_name.getWindowToken(), 0);
                String name = ed_name.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(context, context.getResources().getString(R.string.input_check), Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.cancel();
                Bundle args = new Bundle();
                args.putString("name", name);
                myDialogListener.onPositiveClicked(args);
                dialog.dismiss();

            }
        });

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ed_name.getWindowToken(), 0);

                dialog.cancel();
                Bundle args = new Bundle();
                myDialogListener.onNegativeClicked(args);
            }
        });

        ed_name.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }




}