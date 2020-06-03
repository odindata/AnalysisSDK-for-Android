package com.odin.analysis.demo.ui.frag;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.odin.analysis.OdinAnalysis;
import com.odin.analysis.demo.BaseActivity;
import com.odin.analysis.demo.Constant;
import com.odin.analysis.demo.R;
import com.odin.analysis.demo.data.EventShowData;
import com.odin.analysis.demo.data.InfoItem;

import java.util.ArrayList;
import java.util.List;

public class PageBFragment extends BaseFragment {

    private long lastTime;

    public static final String NAME = PageBFragment.class.getSimpleName();

    public static PageBFragment newInstance() {
        return new PageBFragment();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "PageB";
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lastTime = System.currentTimeMillis();
            OdinAnalysis.pageStart(getName());
            Log.d(getName(), "pageStart");
        }
    }

    @Override
    public void initView(View mView) {
        Button mBtnSendEvent = mView.findViewById(R.id.btn_send_event_page);
        mBtnSendEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟收集页面结束的事件
                OdinAnalysis.pageEnd(getName());
                Log.d(getName(), "pageEnd");
                showEventInfo(Constant.EVENT.EVENT_CODE_PAGE_VIEW, NAME, PageAFragment.NAME, (System.currentTimeMillis() - lastTime) / 1000f);
                lastTime = System.currentTimeMillis();
            }
        });
    }

    private void showEventInfo(String event_code, String page_id, String prepage_id, float du) {
        BaseActivity activity = (BaseActivity) getActivity();
        if (activity == null) {
            return;
        }
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", event_code));
        infoItemList.add(new InfoItem("当前页id：", page_id));
        infoItemList.add(new InfoItem("前一个页面id：", prepage_id));
        infoItemList.add(new InfoItem("当前页访问时长：", du + "秒"));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_PAGE_VIEW);
        eventShowData.setExtraInfo(String.format(activity.getString(R.string.str_extra_info), du + "秒"));
        eventShowData.setInfoItemList(infoItemList);

        Intent intent = new Intent();
        intent.putExtra(Constant.EVENT.EXTRA_EVENT_PAGE_VIEW, eventShowData);

        activity.setResult(Constant.EVENT.RESULT_CODE_PAGE_VIEW, intent);
        activity.finish();
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_pageb;
    }

}
