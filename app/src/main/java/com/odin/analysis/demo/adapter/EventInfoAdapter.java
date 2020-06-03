package com.odin.analysis.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.demo.R;
import com.odin.analysis.demo.data.EventInfo;

import java.util.List;

public class EventInfoAdapter extends RecyclerView.Adapter<EventInfoAdapter.EventAttributeHolder> {

    private List<EventInfo> eventInfoList;

    public EventInfoAdapter(List<EventInfo> eventInfoList) {
        this.eventInfoList = eventInfoList;
    }

    @NonNull
    @Override
    public EventAttributeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_arrtribute, parent, false);
        return new EventAttributeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAttributeHolder holder, int position) {
        EventInfo eventInfo = eventInfoList.get(position);
        holder.mTvName.setText(eventInfo.getName());
        holder.mTvDescription.setText(eventInfo.getDescription());
        holder.mTvType.setText(eventInfo.getDataType());
        holder.mTvCommon.setText(eventInfo.getCommon());
        holder.mTvNess.setText(eventInfo.getIsNecessary());

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorGray));
        } else {
            holder.itemView.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorWhite));
        }
    }

    @Override
    public int getItemCount() {
        if (eventInfoList != null) {
            return eventInfoList.size();
        }
        return 0;
    }

    class EventAttributeHolder extends RecyclerView.ViewHolder {

        TextView mTvName;
        TextView mTvDescription;
        TextView mTvType;
        TextView mTvCommon;
        TextView mTvNess;

        EventAttributeHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_item_event_name);
            mTvDescription = itemView.findViewById(R.id.tv_item_event_description);
            mTvType = itemView.findViewById(R.id.tv_item_event_type);
            mTvCommon = itemView.findViewById(R.id.tv_item_event_common);
            mTvNess = itemView.findViewById(R.id.tv_item_event_ness);
        }
    }
}
