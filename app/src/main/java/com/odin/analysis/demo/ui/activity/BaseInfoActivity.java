package com.odin.analysis.demo.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.OdinAnalysis;
import com.odin.analysis.demo.BaseActivity;
import com.odin.analysis.demo.R;
import com.odin.analysis.demo.adapter.BaseInfoAdapter;
import com.odin.analysis.demo.data.InfoItem;
import com.odin.analysis.demo.utils.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseInfoActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_info;
    }

    @Override
    public void initViews() {
        setTitle(getString(R.string.str_base_info_title));

        List<InfoItem> sdkInfo = new ArrayList<>();
        sdkInfo.add(new InfoItem("SDK名称：", "OdinAnalysis"));
        sdkInfo.add(new InfoItem("SDK版本：", OdinAnalysis.SDK_VERSION));
        sdkInfo.add(new InfoItem("更新日期：", "2020/05/14"));

        DeviceUtils deviceUtils = DeviceUtils.getInstance(this);

        List<InfoItem> deviceInfo = new ArrayList<>();
        deviceInfo.add(new InfoItem("品牌：", deviceUtils.getBrand()));
        deviceInfo.add(new InfoItem("型号：", deviceUtils.getModel()));
        deviceInfo.add(new InfoItem("IMEI：", deviceUtils.getIMEI()));
        deviceInfo.add(new InfoItem("IMSI：", deviceUtils.getIMSI()));
//        deviceInfo.add(new InfoItem("手机号码：", "134xxxxxxxx"));
        deviceInfo.add(new InfoItem("当前系统语音：", deviceUtils.getLanguage()));

        RecyclerView mRecyclerViewSDKInfo = findViewById(R.id.recyclerview_sdk_info);
        RecyclerView mRecyclerViewDeviceInfo = findViewById(R.id.recyclerview_device_info);

        mRecyclerViewSDKInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewSDKInfo.setAdapter(new BaseInfoAdapter(sdkInfo));

        mRecyclerViewDeviceInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerViewDeviceInfo.setAdapter(new BaseInfoAdapter(deviceInfo));
    }
}
