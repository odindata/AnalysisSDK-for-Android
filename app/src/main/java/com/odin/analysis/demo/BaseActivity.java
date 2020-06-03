package com.odin.analysis.demo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

public abstract class BaseActivity extends AppCompatActivity {

    private TextView mTvTitle;

    public abstract int getLayoutId();

    public abstract void initViews();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initHeaderView();
        initViews();

        ImmersionBar.with(this).barColor(R.color.colorWhite).statusBarDarkFont(true).transparentNavigationBar().init();
    }

    public void initHeaderView() {
        ImageView mImgBack = findViewById(R.id.img_header_back);
        if (mImgBack != null) {
            mImgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        mTvTitle = findViewById(R.id.tv_header_title);
    }

    public void setTitle(String title) {
        if (mTvTitle != null && !TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
    }

    public void startToActivity(Class<? extends BaseActivity> toActivity) {
        startActivity(new Intent(this, toActivity));
    }
}
