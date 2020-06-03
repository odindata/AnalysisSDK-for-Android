package com.odin.analysis.demo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.demo.R;
import com.odin.analysis.demo.adapter.EventInfoDialogAdapter;
import com.odin.analysis.demo.data.EventShowData;
import com.odin.analysis.demo.data.InfoItem;

import java.util.ArrayList;
import java.util.List;

public class EventDialog extends Dialog {

    private EventShowData eventShowData;

    public EventDialog(@NonNull Context context, EventShowData eventShowData) {
        super(context, R.style.AppDialog);
        this.eventShowData = eventShowData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_send_event);

        TextView mTvEvent = findViewById(R.id.tv_dialog_event);
        TextView mTvEventExtra = findViewById(R.id.tv_extra_info);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview_dialog);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        String eventName = null;
        String eventExtra = null;
        List<InfoItem> infoItemList = new ArrayList<>();
        if (eventShowData != null) {
            eventName = eventShowData.getEventName();
            eventExtra = eventShowData.getExtraInfo();
            infoItemList = eventShowData.getInfoItemList();
        }
        mTvEvent.setText(String.format(getContext().getString(R.string.str_dialog_event), eventName == null ? "" : eventName));
        if (!TextUtils.isEmpty(eventExtra)) {
            mTvEventExtra.setText(eventExtra);
            mTvEventExtra.setVisibility(View.VISIBLE);
        }
        mRecyclerView.setAdapter(new EventInfoDialogAdapter(infoItemList));

        Button mBtnEnsure = findViewById(R.id.btn_dialog_ensure);
        mBtnEnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
}
