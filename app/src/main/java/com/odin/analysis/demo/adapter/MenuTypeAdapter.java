package com.odin.analysis.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.demo.Constant;
import com.odin.analysis.demo.R;
import com.odin.analysis.demo.data.MenuType;
import com.odin.analysis.demo.ui.activity.EventInfoActivity;

import java.util.List;

/**
 * 主页，menu的Adapter
 */
public class MenuTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MenuType> menuTypeList;

    public MenuTypeAdapter(List<MenuType> menuTypeList) {
        this.menuTypeList = menuTypeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Constant.AdapterMenuType.TYPE_TITLE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_type_title, parent, false);
            return new EventTypeTitleHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_type_content, parent, false);
            return new EventTypeContentHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MenuType menuType = menuTypeList.get(position);
        int itemViewType = getItemViewType(position);
        if (itemViewType == Constant.AdapterMenuType.TYPE_TITLE) {
            EventTypeTitleHolder titleHolder = (EventTypeTitleHolder) holder;
            titleHolder.mTvTitle.setText(menuType.getName());
        } else {
            EventTypeContentHolder contentHolder = (EventTypeContentHolder) holder;
            contentHolder.mTvName.setText(menuType.getName());
            contentHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventInfoActivity.newInstance(v.getContext(), menuType.getEvent());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (menuTypeList != null) {
            return menuTypeList.get(position).getAdapterType();
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if (menuTypeList != null) {
            return menuTypeList.size();
        }
        return 0;
    }

    class EventTypeTitleHolder extends RecyclerView.ViewHolder {

        TextView mTvTitle;

        EventTypeTitleHolder(@NonNull View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_item_event_type_title);
        }
    }

    class EventTypeContentHolder extends RecyclerView.ViewHolder {

        TextView mTvName;

        EventTypeContentHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_item_event_type_name);
        }
    }
}
