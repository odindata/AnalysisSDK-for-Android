package com.odin.analysis.demo.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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

public class RegisterActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initViews() {
        final EditText mEtUserId = findViewById(R.id.et_user_id);
        final EditText mEtNickname = findViewById(R.id.et_nickname);
        final EditText mEtUserSex = findViewById(R.id.et_sex);
        Button mBtnRegister = findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAccount = mEtUserId.getText().toString().trim();
                String nickname = mEtNickname.getText().toString().trim();
                String strSex = mEtUserSex.getText().toString().trim();
                if (TextUtils.isEmpty(userAccount)) {
                    Toast.makeText(RegisterActivity.this, "用户账户不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                int sex = -1;
                if (!TextUtils.isEmpty(strSex)) {
                    if ("男".equals(strSex)) {
                        sex = 0;
                    } else if ("女".equals(strSex)) {
                        sex = 1;
                    } else {
                        Toast.makeText(RegisterActivity.this, "性别输入不正确", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Global.setUserId(userAccount);
                showEventInfo(Constant.EVENT.EVENT_CODE_REGISTER, userAccount, userAccount, nickname, strSex);
            }
        });
    }

    private void showEventInfo(String event_code, String user_id, String userAccount, String nickname, String sex) {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", event_code));
        infoItemList.add(new InfoItem("用户ID：", user_id));
        infoItemList.add(new InfoItem("昵称：", nickname));
        infoItemList.add(new InfoItem("用户账户：", userAccount));
        infoItemList.add(new InfoItem("性别：", sex));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_USER_REGISTER);
        eventShowData.setInfoItemList(infoItemList);
        Intent intent = new Intent();
        intent.putExtra(Constant.EVENT.EXTRA_EVENT_REGISTER, eventShowData);
        setResult(Constant.EVENT.RESULT_CODE_REGISTER, intent);
        finish();
    }
}
