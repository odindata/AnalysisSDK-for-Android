package com.odin.analysis.demo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.analysis.OdinAnalysis;
import com.odin.analysis.demo.BaseActivity;
import com.odin.analysis.demo.Constant;
import com.odin.analysis.demo.Global;
import com.odin.analysis.demo.R;
import com.odin.analysis.demo.adapter.EventInfoAdapter;
import com.odin.analysis.demo.data.Event;
import com.odin.analysis.demo.data.EventInfo;
import com.odin.analysis.demo.data.EventShowData;
import com.odin.analysis.demo.data.InfoItem;
import com.odin.analysis.demo.ui.dialog.EventDialog;
import com.odin.analysis.demo.utils.EventApi;

import java.util.ArrayList;
import java.util.List;

/**
 * 显示事件信息的Activity，并且模拟事件的触发和收集动作
 */
public class EventInfoActivity extends BaseActivity {

    private static final String EXTRA_EVENT = "EXTRA_EVENT";

    public static void newInstance(Context context, Event event) {
        Intent intent = new Intent(context, EventInfoActivity.class);
        intent.putExtra(EXTRA_EVENT, event);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_event;
    }

    @Override
    public void initViews() {
        TextView mTvEventName = findViewById(R.id.tv_event_name);
        TextView mTvEventDescription = findViewById(R.id.tv_event_description);
        Button mBntSendEvent = findViewById(R.id.btn_send_event);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerview_event);

        Intent intent = getIntent();
        final Event event = (Event) intent.getSerializableExtra(EXTRA_EVENT);
        if (event == null) {
            return;
        }
        String name = event.getName();
        String description = event.getDescription();
        List<EventInfo> eventInfoList = event.getEventInfoList();

        setTitle(String.format(getString(R.string.str_event_title), name));
        mTvEventName.setText(String.format(getString(R.string.str_event_name), name));
        mTvEventDescription.setText(String.format(getString(R.string.str_event_description), description));

        //显示事件的埋点需要填入的属性信息，供用户参考
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new EventInfoAdapter(eventInfoList));

        mBntSendEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simulateEvent(event);
            }
        });
    }

    /**
     * 模拟事件
     */
    private void simulateEvent(Event event) {
        String eventName = event.getName();
        switch (eventName) {
            case Constant.EVENT.EVENT_NAME_USER_REGISTER: {
                Intent intentTo = new Intent(EventInfoActivity.this, RegisterActivity.class);
                startActivityForResult(intentTo, 1);
                break;
            }
            case Constant.EVENT.EVENT_NAME_LOGIN: {
                Intent intentTo = new Intent(EventInfoActivity.this, LoginActivity.class);
                startActivityForResult(intentTo, 1);
                break;
            }
            case Constant.EVENT.EVENT_NAME_PAGE_VIEW:
                Intent intentTo = new Intent(EventInfoActivity.this, FragmentActivity.class);
                startActivityForResult(intentTo, 1);
                break;
            case Constant.EVENT.EVENT_NAME_GET_CODE:
                doGetCodeWork();
                break;
            case Constant.EVENT.EVENT_NAME_PAYMENT:
                doPaymentWork();
                break;
            case Constant.EVENT.EVENT_NAME_COMMENT:
                doCommentWork();
                break;
            case Constant.EVENT.EVENT_NAME_SHARE:
                doShareWork();
                break;
            case Constant.EVENT.EVENT_NAME_READ:
                doReadWork();
                break;
        }
    }

    /**
     * 显示触发的事件的信息
     *
     * @param eventShowData 事件的信息
     */
    private void showEventDialog(EventShowData eventShowData) {
        EventDialog eventDialog = new EventDialog(this, eventShowData);
        eventDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (data == null) {
                return;
            }
            //获取注册和登录页面返回的事件信息
            EventShowData eventShowData = null;
            if (resultCode == Constant.EVENT.RESULT_CODE_LOGIN) {
                if (Global.getUserId() != null) {
                    //收集登录事件，收集信息：用户账户，是否登录成功
                    OdinAnalysis.login(Global.getUserId(), true);
                }
                eventShowData = (EventShowData) data.getSerializableExtra(Constant.EVENT.EXTRA_EVENT_LOGIN);
            } else if (resultCode == Constant.EVENT.RESULT_CODE_REGISTER) {
                if (Global.getUserId() != null) {
                    //收集注册事件，收集信息：用户账户
                    OdinAnalysis.register(Global.getUserId());
                }
                eventShowData = (EventShowData) data.getSerializableExtra(Constant.EVENT.EXTRA_EVENT_REGISTER);
            } else if (resultCode == Constant.EVENT.RESULT_CODE_PAGE_VIEW) {
                eventShowData = (EventShowData) data.getSerializableExtra(Constant.EVENT.EXTRA_EVENT_PAGE_VIEW);
            }
            if (eventShowData == null) {
                return;
            }
            //展示事件信息
            showEventDialog(eventShowData);
        }
    }

    /**
     * 做支付的工作，在支付完成后，需要收集支付事件的相关信息，
     * 以下信息请根据实际情况填写
     */
    private void doGetCodeWork() {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", Constant.EVENT.EVENT_CODE_GET_CODE));
        infoItemList.add(new InfoItem("事件id：", Constant.EVENT.EVENT_CODE_GET_CODE));
        infoItemList.add(new InfoItem("事件名称：", "获取验证码"));
        infoItemList.add(new InfoItem("业务类型：", "获取验证登录"));
        infoItemList.add(new InfoItem("当前页id：", EventInfoActivity.class.getName()));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_GET_CODE);
        eventShowData.setInfoItemList(infoItemList);

        EventApi.sendGetCodeEvent(Constant.EVENT.EVENT_CODE_GET_CODE, Constant.EVENT.EVENT_CODE_GET_CODE,
                "获取验证码", "获取验证登录", EventInfoActivity.class.getName());

        showEventDialog(eventShowData);
    }

    /**
     * 做支付的工作，在支付完成后，需要收集支付事件的相关信息，
     * 以下信息请根据实际情况填写
     */
    private void doPaymentWork() {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", Constant.EVENT.EVENT_CODE_PAYMENT));
        infoItemList.add(new InfoItem("事件id：", Constant.EVENT.EVENT_CODE_PAYMENT));
        infoItemList.add(new InfoItem("事件名称：", "支付"));
        infoItemList.add(new InfoItem("支付方式：", "支付宝"));
        infoItemList.add(new InfoItem("支付状态：", "支付成功"));
        infoItemList.add(new InfoItem("订单类型：", "购买书籍"));
        infoItemList.add(new InfoItem("订单号：", "order123456"));
        infoItemList.add(new InfoItem("支付账号：", "13412345678"));
        infoItemList.add(new InfoItem("订单金额：", "123.5"));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_PAYMENT);
        eventShowData.setInfoItemList(infoItemList);

        //payment_type:1 支付宝；2 微信...
        //payment_status:1 支付成功；2 支付失败...
        EventApi.sendPaymentEvent(Constant.EVENT.EVENT_CODE_PAYMENT, Constant.EVENT.EVENT_CODE_PAYMENT,
                "支付", 1, 0, "购买书籍",
                "order123456", "13412345678", 123.5f);

        showEventDialog(eventShowData);
    }

    /**
     * 做支付的工作，在支付完成后，需要收集支付事件的相关信息，
     * 以下信息请根据实际情况填写
     */
    private void doCommentWork() {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", Constant.EVENT.EVENT_CODE_COMMENT));
        infoItemList.add(new InfoItem("事件id：", Constant.EVENT.EVENT_CODE_COMMENT));
        infoItemList.add(new InfoItem("事件名称：", "评论"));
        infoItemList.add(new InfoItem("标签类型：", "电子产品"));
        infoItemList.add(new InfoItem("内容名称：", "英特尔CPU处理器"));
        infoItemList.add(new InfoItem("内容：", "这个商品很不错，值得购买"));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_COMMENT);
        eventShowData.setInfoItemList(infoItemList);

        EventApi.sendCommentEvent(Constant.EVENT.EVENT_CODE_COMMENT, Constant.EVENT.EVENT_CODE_COMMENT,
                "评论", "电子产品", "英特尔CPU处理器", "这个商品很不错，值得购买");

        showEventDialog(eventShowData);
    }

    /**
     * 做分享的工作，在分享完成后，需要收集分享事件的相关信息，
     * 以下信息请根据实际情况填写
     */
    private void doShareWork() {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", Constant.EVENT.EVENT_CODE_SHARE));
        infoItemList.add(new InfoItem("事件id：", Constant.EVENT.EVENT_CODE_SHARE));
        infoItemList.add(new InfoItem("事件名称：", "分享"));
        infoItemList.add(new InfoItem("内容id：", "book1001"));
        infoItemList.add(new InfoItem("内容名称：", "《傲慢与偏见》"));
        infoItemList.add(new InfoItem("分享方式：", "QQ好友分享"));
        infoItemList.add(new InfoItem("作者：", "简·奥斯汀"));
        infoItemList.add(new InfoItem("标签类型：", "分享书籍"));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_SHARE);
        eventShowData.setInfoItemList(infoItemList);

        EventApi.sendShareEvent(Constant.EVENT.EVENT_CODE_SHARE, Constant.EVENT.EVENT_CODE_SHARE, "分享",
                "book1001", "《傲慢与偏见》", "QQ好友分享", "简·奥斯汀", "分享书籍");

        showEventDialog(eventShowData);
    }

    /**
     * 做搜索的工作，在搜索完成后，需要收集搜索事件的相关信息，
     * 以下信息请根据实际情况填写
     */
    private void doReadWork() {
        EventShowData eventShowData = new EventShowData();
        List<InfoItem> infoItemList = new ArrayList<>();
        infoItemList.add(new InfoItem("事件code：", Constant.EVENT.EVENT_CODE_READ));
        infoItemList.add(new InfoItem("事件id：", Constant.EVENT.EVENT_CODE_READ));
        infoItemList.add(new InfoItem("事件名称：", "阅读"));
        infoItemList.add(new InfoItem("阅读起始章节：", "第一章"));
        infoItemList.add(new InfoItem("阅读结束章节：", "第八章"));
        infoItemList.add(new InfoItem("出版时间：", "2020-03-21"));
        infoItemList.add(new InfoItem("作者：", "曹雪芹"));
        eventShowData.setEventName(Constant.EVENT.EVENT_NAME_READ);
        eventShowData.setInfoItemList(infoItemList);

        EventApi.sendReadInfoEvent(Constant.EVENT.EVENT_CODE_SEARCH, Constant.EVENT.EVENT_CODE_SEARCH, "阅读",
                "第一章", "第八章", "2020-03-21", "曹雪芹");
        showEventDialog(eventShowData);
    }
}
