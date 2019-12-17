package com.smtm.reminders.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.smtm.reminders.R;
import com.smtm.reminders.utils.Dlog;

import java.util.Calendar;

/**
 * Created by asus on 2018-02-09.
 */

public class DateInputMask extends AppCompatEditText implements TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {

    private String current = "";
    private String yyyymmdd = "YYYYMMDD";
    private Calendar cal = Calendar.getInstance();

    private Drawable clearDrawable;
    private OnFocusChangeListener onFocusChangeListener;
    private OnTouchListener onTouchListener;
    public DateInputMask(final Context context) {
        super(context);
        init();
    }

    public DateInputMask(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DateInputMask(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

//    public DateInputMask(EditText input) {
//        this.input = input;
//        this.input.addTextChangedListener(this);
//    }

    private void init() {
        Drawable tempDrawable = ContextCompat.getDrawable(getContext(), R.drawable.input_icon_x);
        clearDrawable = DrawableCompat.wrap(tempDrawable);
        clearDrawable.setBounds(0, 0, clearDrawable.getIntrinsicWidth()/3, clearDrawable.getIntrinsicHeight()/3);
        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
//        addTextChangedListener(this);
    }
    @Override
    public void onFocusChange(final View view, final boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
//        if (onFocusChangeListener != null) {
//            onFocusChangeListener.onFocusChange(view, hasFocus);
//        }
    }

    @Override
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int x = (int) motionEvent.getX();
        if (clearDrawable.isVisible() && x > getWidth() - getPaddingRight() - clearDrawable.getIntrinsicWidth()) {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                current = " ";
                setError(null);
                setText(null);
            }
            return true;
        }
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        } else {
            return false;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        Dlog.e("onTextChanged  : " + s.toString());
//        Dlog.e("onTextChanged  current : " + current);

        if (isFocused()) {
            setClearIconVisible(s.length() > 0);
        }
        if (s.toString().equals("YYYY.MM.DD")) {
            current = " ";
            this.setText("");
            return;
        }

        if (TextUtils.isEmpty(s.toString())) {
            return;
        }

        if (s.toString().equals(current)) {
            Dlog.e("return");
            return;
        }
        String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
        String cleanC = current.replaceAll("[^\\d.]|\\.", "");
        Dlog.e("onTextChanged clean : " + clean);
        Dlog.e("onTextChanged cleanC : " + cleanC);
        int cl = clean.length();
        int sel = cl;
        for (int i = 4; i <= cl && i <= 6; i += 2) {
            sel++;
        }
        //Fix for pressing delete next to a forward slash
        if (clean.equals(cleanC)){
            sel--;
        }

        if (clean.length() < 8) {
            Dlog.e("if");
            clean = clean + yyyymmdd.substring(clean.length());

        } else {
            Dlog.e("else");
            //This part makes sure that when we finish entering numbers
            //the date is correct, fixing it otherwise
            int year = Integer.parseInt(clean.substring(0, 4));
            int mon = Integer.parseInt(clean.substring(4, 6));
            int day = Integer.parseInt(clean.substring(6, 8));
            mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
            cal.set(Calendar.MONTH, mon - 1);
            year = (year < 1900) ? 1900 : (year > 2100) ? 2100 : year;
            cal.set(Calendar.YEAR, year);
            // ^ first set year for the line below to work correctly
            //with leap years - otherwise, date e.g. 29/02/2012
            //would be automatically corrected to 28/02/2012

            day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
//            clean = String.format("%02d%02d%02d", day, mon, year);
            clean = String.format("%02d%02d%02d", year, mon, day);
        }

        clean = String.format("%s.%s.%s", clean.substring(0, 4),
                clean.substring(4, 6),
                clean.substring(6, 8));
        sel = sel < 0 ? 0 : sel;
        if(sel > 10){
            sel=10;
        }

        current = clean;
        Dlog.e("sel : " + sel);
        Dlog.e("current : " + current.length());
        SpannableStringBuilder ssb = new SpannableStringBuilder(current);
        ssb.setSpan(new ForegroundColorSpan(Color.parseColor("#ace4ed")), sel, current.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

//        input.setText(ssb);
//        input.setSelection(sel < current.length() ? sel : current.length());
        Dlog.e("end : " + current);
        this.setText(ssb);
        this.setSelection(sel < current.length() ? sel : current.length());
        Dlog.e("==============================");

    }

    @Override
    public void afterTextChanged(Editable s) {
        Dlog.e("afterTextChanged : " + s.toString());
    }

    private void setClearIconVisible(boolean visible) {
        Dlog.e("setClearIconVisible()");
        clearDrawable.setVisible(visible, false);
        setCompoundDrawables(null, null, visible ? clearDrawable : null, null);
    }
}
