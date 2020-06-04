package com.odin.analysis.demo;

import android.app.Application;

import com.odin.analysis.OdinAnalysis;

public class OdinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化OdinAnalysisSDK，使用功能前必须调用
        OdinAnalysis.init(this);
    }
}
