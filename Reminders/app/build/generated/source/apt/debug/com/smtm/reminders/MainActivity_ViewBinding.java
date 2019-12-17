// Generated code from Butter Knife. Do not modify!
package com.smtm.reminders;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.smtm.reminders.custom.ClearEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f070073;

  private View view7f07006b;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.ed_search = Utils.findRequiredViewAsType(source, R.id.ed_search, "field 'ed_search'", ClearEditText.class);
    target.ll_scheduled = Utils.findRequiredViewAsType(source, R.id.ll_scheduled, "field 'll_scheduled'", LinearLayout.class);
    target.rl_list_schema = Utils.findRequiredViewAsType(source, R.id.rl_list_schema, "field 'rl_list_schema'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ll_add_list, "field 'll_add_list' and method 'addList'");
    target.ll_add_list = Utils.castView(view, R.id.ll_add_list, "field 'll_add_list'", LinearLayout.class);
    view7f070073 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addList();
      }
    });
    target.tv_task_name = Utils.findRequiredViewAsType(source, R.id.tv_task_name, "field 'tv_task_name'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_task_add, "field 'iv_task_add' and method 'iv_task_add'");
    target.iv_task_add = Utils.castView(view, R.id.iv_task_add, "field 'iv_task_add'", ImageView.class);
    view7f07006b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.iv_task_add();
      }
    });
    target.rl_task_schema = Utils.findRequiredViewAsType(source, R.id.rl_task_schema, "field 'rl_task_schema'", RecyclerView.class);

    Context context = source.getContext();
    Resources res = context.getResources();
    target.add_list = res.getString(R.string.add_list);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ed_search = null;
    target.ll_scheduled = null;
    target.rl_list_schema = null;
    target.ll_add_list = null;
    target.tv_task_name = null;
    target.iv_task_add = null;
    target.rl_task_schema = null;

    view7f070073.setOnClickListener(null);
    view7f070073 = null;
    view7f07006b.setOnClickListener(null);
    view7f07006b = null;
  }
}
