package com.odin.analysis.demo.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.odin.analysis.OdinAnalysis;
import com.odin.analysis.demo.BaseActivity;
import com.odin.analysis.demo.Constant;
import com.odin.analysis.demo.Global;
import com.odin.analysis.demo.R;
import com.odin.analysis.demo.data.EventShowData;
import com.odin.analysis.demo.data.InfoItem;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        final EditText mEtUser = findViewById(R.id.et_user_account);
        final EditText mEtPassword = findViewById(R.id.et_password);
        final CheckBox mCbStatus = findViewById(R.id.cb_status);
        Button mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean checked = mCbStatus.isChecked();
                //用户自己定义，如，1：保持登录状态；0：不保持登录状态
                String strStatus = checked ? "保持登录状态" : "不保持登录状态";

                //用户自己定义，如，1：账号密码登录；2：短信验证码登录
                String type = "账号密码登录";

                String userId = mEtUser.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "用户账户或者密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Global.setUserId(userId);
                showEventInfo(userId, strStatus, (System.currentTimeMillis() - currentTimeMillis) / 1000f, type);
            }
        });
    }

    private void showEventInfo(String userId, String status, float du, String type) {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", Constant.EVENT.EVENT_CODE_LOGIN));
        infoItemList.add(new InfoItem("用户ID：", userId));
        infoItemList.add(new InfoItem("登录状态：", status));
        infoItemList.add(new InfoItem("登录时长：", du + "秒"));
        infoItemList.add(new InfoItem("类型：", type));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_LOGIN);
        eventShowData.setInfoItemList(infoItemList);
        Intent intent = new Intent();
        intent.putExtra(Constant.EVENT.EXTRA_EVENT_LOGIN, eventShowData);
        setResult(Constant.EVENT.RESULT_CODE_LOGIN, intent);
        finish();
    }
}
