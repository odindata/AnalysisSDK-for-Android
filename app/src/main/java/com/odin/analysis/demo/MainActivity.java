package com.odin.analysis.demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.demo.adapter.MenuTypeAdapter;
import com.odin.analysis.demo.ui.activity.BaseInfoActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

        checkSelfPermission();

        RecyclerView mRecyclerView = findViewById(R.id.recyclerview_event_type);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new MenuTypeAdapter(Constant.EVENT.mainMenuTypeList));

        findViewById(R.id.img_base_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startToActivity(BaseInfoActivity.class);
            }
        });
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION};

    /**
     * OdinAnalysisSDK需要的权限的申请
     */
    public void checkSelfPermission() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int permission1 = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int permission2 = checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
            int permission3 = checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);
            if (permission1 != PackageManager.PERMISSION_GRANTED
                    || permission2 != PackageManager.PERMISSION_GRANTED
                    || permission3 != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        }
    }
}
