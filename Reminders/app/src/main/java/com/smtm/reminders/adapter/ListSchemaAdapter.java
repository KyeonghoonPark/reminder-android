package com.smtm.reminders.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smtm.reminders.R;
import com.smtm.reminders.custom.ClearEditText;
import com.smtm.reminders.realm.module.ListSchema;

import java.util.ArrayList;


public class ListSchemaAdapter extends RecyclerView.Adapter<ListSchemaAdapter.ViewHolder> {

    private ArrayList<ListSchema> mData;
    private Context mContext;
    private Resources mResources;
    private LayoutInflater inflater;

    ListSchemaClickListener mMenuItemClickListener;

    public interface ListSchemaClickListener {
        void onItemChoseListner(int position);

        void onItemModifyListner(int position);

        void onItemDeleteListner(int position);
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout parent;
        LinearLayout ll_bg;
        TextView tv_name;
        ImageView iv_user_edit;
        ImageView iv_user_delete;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_bg = itemView.findViewById(R.id.ll_bg);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_user_edit = itemView.findViewById(R.id.iv_user_edit);
            iv_user_delete = itemView.findViewById(R.id.iv_user_delete);
        }
    }

    public ListSchemaAdapter(Context context, ArrayList<ListSchema> data, ListSchemaClickListener menuItemClickListener) {
        this.mContext = mContext;
        this.mData = data;
        this.mResources = context.getResources();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mMenuItemClickListener = menuItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_list_schema, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ListSchema item = getUsageByPosition(position);

        // 활성화 체크
        if (item.isChoice()) {
            holder.tv_name.setSelected(true);
            holder.ll_bg.setBackgroundColor(mResources.getColor(R.color.gray));
            holder.iv_user_edit.setVisibility(View.VISIBLE);
            holder.iv_user_delete.setVisibility(View.VISIBLE);
        } else {
            holder.tv_name.setSelected(false);
            holder.ll_bg.setBackgroundColor(mResources.getColor(R.color.white));
            holder.iv_user_edit.setVisibility(View.INVISIBLE);
            holder.iv_user_delete.setVisibility(View.INVISIBLE);
        }

        holder.tv_name.setText(item.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuItemClickListener.onItemChoseListner(position);
            }
        });


        holder.iv_user_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuItemClickListener.onItemModifyListner(position);
            }
        });


        holder.iv_user_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuItemClickListener.onItemDeleteListner(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        else return 0;
    }


    private ListSchema getUsageByPosition(int position) {
        if (mData.size() > position) {
            return mData.get(position);
        }
        return null;
    }

}