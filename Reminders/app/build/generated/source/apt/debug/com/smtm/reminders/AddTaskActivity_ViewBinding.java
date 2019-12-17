// Generated code from Butter Knife. Do not modify!
package com.smtm.reminders;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.smtm.reminders.custom.ClearEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddTaskActivity_ViewBinding implements Unbinder {
  private AddTaskActivity target;

  private View view7f070066;

  private View view7f0700c3;

  private View view7f070043;

  @UiThread
  public AddTaskActivity_ViewBinding(AddTaskActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddTaskActivity_ViewBinding(final AddTaskActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgBackWhiteLeft, "field 'imgBackWhiteLeft' and method 'onClickBack'");
    target.imgBackWhiteLeft = Utils.castView(view, R.id.imgBackWhiteLeft, "field 'imgBackWhiteLeft'", ImageView.class);
    view7f070066 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickBack();
      }
    });
    target.ed_nick_name = Utils.findRequiredViewAsType(source, R.id.ed_nick_name, "field 'ed_nick_name'", ClearEditText.class);
    view = Utils.findRequiredView(source, R.id.tv_remind_at, "field 'tv_remind_at' and method 'tv_remind_at'");
    target.tv_remind_at = Utils.castView(view, R.id.tv_remind_at, "field 'tv_remind_at'", TextView.class);
    view7f0700c3 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.tv_remind_at();
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_done, "field 'bt_done' and method 'membership'");
    target.bt_done = Utils.castView(view, R.id.bt_done, "field 'bt_done'", TextView.class);
    view7f070043 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.membership();
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.register = res.getString(R.string.register);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddTaskActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgBackWhiteLeft = null;
    target.ed_nick_name = null;
    target.tv_remind_at = null;
    target.bt_done = null;

    view7f070066.setOnClickListener(null);
    view7f070066 = null;
    view7f0700c3.setOnClickListener(null);
    view7f0700c3 = null;
    view7f070043.setOnClickListener(null);
    view7f070043 = null;
  }
}
