package com.odin.analysis.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.demo.R;
import com.odin.analysis.demo.data.InfoItem;

import java.util.List;

public class EventInfoDialogAdapter extends RecyclerView.Adapter<EventInfoDialogAdapter.InfoViewHolder> {

    private List<InfoItem> infoItemList;

    public EventInfoDialogAdapter(List<InfoItem> infoItemList) {
        this.infoItemList = infoItemList;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_info, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        InfoItem infoItem = infoItemList.get(position);
        holder.mTvName.setText(infoItem.getName());
        holder.mTvValue.setText(infoItem.getValue());
    }

    @Override
    public int getItemCount() {
        if (infoItemList != null) {
            return infoItemList.size();
        }
        return 0;
    }

    class InfoViewHolder extends RecyclerView.ViewHolder {

        TextView mTvName;
        TextView mTvValue;

        InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_item_base_info_name);
            mTvValue = itemView.findViewById(R.id.tv_item_base_info_value);
        }
    }
}
