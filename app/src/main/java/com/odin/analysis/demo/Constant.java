package com.odin.analysis.demo;

import com.odin.analysis.demo.data.Event;
import com.odin.analysis.demo.data.EventInfo;
import com.odin.analysis.demo.data.MenuType;

import java.util.ArrayList;
import java.util.List;

public class Constant {

    public static class AdapterMenuType {
        public static final int TYPE_TITLE = 1;
        public static final int TYPE_CONTENT = 2;
    }

    /**
     * 事件的相关定义
     */
    public static class EVENT {

        public static final int RESULT_CODE_LOGIN = 900001;
        public static final int RESULT_CODE_REGISTER = 900002;
        public static final int RESULT_CODE_PAGE_VIEW = 900003;

        /***事件code*/
        public static final String EVENT_CODE_REGISTER = "100001";
        public static final String EVENT_CODE_LOGIN = "100002";
        public static final String EVENT_CODE_PAGE_VIEW = "100003";
        public static final String EVENT_CODE_PAYMENT = "100004";
        public static final String EVENT_CODE_SHARE = "100005";
        public static final String EVENT_CODE_SEARCH = "100006";
        public static final String EVENT_CODE_GET_CODE = "100007";
        public static final String EVENT_CODE_COMMENT = "100008";
        public static final String EVENT_CODE_READ = "100009";

        public static final String EXTRA_EVENT_LOGIN = "EXTRA_EVENT_LOGIN";
        public static final String EXTRA_EVENT_REGISTER = "EXTRA_EVENT_REGISTER";
        public static final String EXTRA_EVENT_PAGE_VIEW = "EXTRA_EVENT_PAGE_VIEW";

        /***事件名称*/
        public static final String EVENT_NAME_LOGIN = "login";
        public static final String EVENT_NAME_USER_REGISTER = "user_register";
        public static final String EVENT_NAME_PAGE_VIEW = "page_view";
        public static final String EVENT_NAME_PAYMENT = "payment";
        public static final String EVENT_NAME_SHARE = "share";
        public static final String EVENT_NAME_SEARCH = "search";
        public static final String EVENT_NAME_GET_CODE = "get_code";
        public static final String EVENT_NAME_COMMENT = "comment";
        public static final String EVENT_NAME_READ = "read_info";

        public static List<MenuType> mainMenuTypeList = new ArrayList<>();

        static {
            //事件的属性信息
            EventInfo titleEventInfo = new EventInfo("属性名", "属性描述", "是否必填", "数据类型", "通用属性");

            List<EventInfo> registerEventInfoList = new ArrayList<>();
            registerEventInfoList.add(titleEventInfo);
            registerEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            registerEventInfoList.add(new EventInfo("user_id", "用户ID", "否", "String(字符)", "非通用"));
            registerEventInfoList.add(new EventInfo("nick_name", "昵称", "否", "String(字符)", "非通用"));
            registerEventInfoList.add(new EventInfo("user_account", "用户账户", "否", "String(字符)", "非通用"));
            registerEventInfoList.add(new EventInfo("sex", "性别 0-男 1-女", "否", "整型(int)", "非通用"));
            registerEventInfoList.add(new EventInfo("age", "年龄", "否", "整型(int)", "非通用"));
            registerEventInfoList.add(new EventInfo("phone", "电话", "否", "String(字符)", "非通用"));
            registerEventInfoList.add(new EventInfo("email", "邮箱", "否", "String(字符)", "非通用"));
            registerEventInfoList.add(new EventInfo("vocation", "职业", "否", "整型(int)", "非通用"));
            registerEventInfoList.add(new EventInfo("monthly_income", "月收入", "否", "整型(int)", "非通用"));

            List<EventInfo> loginEventInfoList = new ArrayList<>();
            loginEventInfoList.add(titleEventInfo);
            loginEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            loginEventInfoList.add(new EventInfo("user_id", "用户ID", "否", "String(字符)", "非通用"));
            loginEventInfoList.add(new EventInfo("status", "登录状态", "否", "整型(int)", "非通用"));
            loginEventInfoList.add(new EventInfo("du", "登录时长", "否", "整型(int)", "非通用"));
            loginEventInfoList.add(new EventInfo("type", "类型", "否", "整型(int)", "非通用"));

            List<EventInfo> pageViewEventInfoList = new ArrayList<>();
            pageViewEventInfoList.add(titleEventInfo);
            pageViewEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            pageViewEventInfoList.add(new EventInfo("user_id", "用户ID", "否", "String(字符)", "非通用"));
            pageViewEventInfoList.add(new EventInfo("page_id", "当前页id", "否", "String(字符)", "非通用"));
            pageViewEventInfoList.add(new EventInfo("prepage_id", "前一个页面id", "否", "String(字符)", "非通用"));
            pageViewEventInfoList.add(new EventInfo("du", "当前页（page_id）访问时长", "否", "整型(int)", "非通用"));


            List<EventInfo> paymentEventInfoList = new ArrayList<>();
            paymentEventInfoList.add(titleEventInfo);
            paymentEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            paymentEventInfoList.add(new EventInfo("event_id", "事件id", "否", "String(字符)", "非通用"));
            paymentEventInfoList.add(new EventInfo("event_name", "事件名称", "否", "String(字符)", "非通用"));
            paymentEventInfoList.add(new EventInfo("payment_type", "支付方式", "否", "整型(int)", "非通用"));
            paymentEventInfoList.add(new EventInfo("payment_status", "支付状态", "否", "整型(int)", "非通用"));
            paymentEventInfoList.add(new EventInfo("order_type", "订单类型", "否", "String(字符)", "非通用"));
            paymentEventInfoList.add(new EventInfo("order_number", "订单号", "否", "String(字符)", "非通用"));
            paymentEventInfoList.add(new EventInfo("pay_number", "支付账号", "否", "String(字符)", "非通用"));
            paymentEventInfoList.add(new EventInfo("amount", "订单金额", "否", "整型(float)", "非通用"));


            List<EventInfo> shareEventInfoList = new ArrayList<>();
            shareEventInfoList.add(titleEventInfo);
            shareEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("event_id", "事件id", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("event_name", "事件名称", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("content_id", "内容id", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("content_name", "内容名称", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("way", "分享方式", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("author", "作者", "否", "String(字符)", "非通用"));
            shareEventInfoList.add(new EventInfo("content_category", "标签类型", "否", "String(字符)", "非通用"));


            List<EventInfo> getCodeEventInfoList = new ArrayList<>();
            getCodeEventInfoList.add(titleEventInfo);
            getCodeEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            getCodeEventInfoList.add(new EventInfo("event_id", "事件id", "否", "String(字符)", "非通用"));
            getCodeEventInfoList.add(new EventInfo("event_name", "事件名称", "否", "String(字符)", "非通用"));
            getCodeEventInfoList.add(new EventInfo("service_type", "业务类型", "否", "String(字符)", "非通用"));
            getCodeEventInfoList.add(new EventInfo("page_id", "当前页id", "否", "String(字符)", "非通用"));
            getCodeEventInfoList.add(new EventInfo("user_id", "用户id", "否", "String(字符)", "通用"));


            List<EventInfo> commentEventInfoList = new ArrayList<>();
            commentEventInfoList.add(titleEventInfo);
            commentEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("event_id", "事件id", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("event_name", "事件名称", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("content_name", "内容名称", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("author", "作者", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("operation_type", "操作类型", "否", "整型(int)", "非通用"));
            commentEventInfoList.add(new EventInfo("content", "内容", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("content_category", "标签类型", "否", "String(字符)", "非通用"));
            commentEventInfoList.add(new EventInfo("page_id", "当前页id", "否", "String(字符)", "非通用"));


            List<EventInfo> readEventInfoList = new ArrayList<>();
            readEventInfoList.add(titleEventInfo);
            readEventInfoList.add(new EventInfo("event_code", "事件code", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("event_id", "事件id", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("event_name", "事件名称", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("used_bytes", "使用流量", "否", "整型(int)", "非通用"));
            readEventInfoList.add(new EventInfo("chapter_finish", "阅读结束章节", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("chapter_start", "阅读起始章节", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("publish_time", "出版时间", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("author", "作者", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("user_id", "用户id", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("content_type", "内容类型", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("content_category", "标签类型", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("content_size", "内容大小", "否", "整型(int)", "非通用"));
            readEventInfoList.add(new EventInfo("content_id", "内容id", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("page_id", "当前页id", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("content_name", "内容名称", "否", "String(字符)", "非通用"));
            readEventInfoList.add(new EventInfo("du", "时长", "否", "整型(int)", "非通用"));


            Event eventRegister = new Event(EVENT_NAME_USER_REGISTER, "注册用户", registerEventInfoList);
            Event eventLogin = new Event(EVENT_NAME_LOGIN, "用户登录", loginEventInfoList);
            Event eventPageView = new Event(EVENT_NAME_PAGE_VIEW, "页面访问", pageViewEventInfoList);
            Event eventGetCode = new Event(EVENT_NAME_GET_CODE, "获取验证码", getCodeEventInfoList);
            Event eventPayment = new Event(EVENT_NAME_PAYMENT, "支付", paymentEventInfoList);
            Event eventComment = new Event(EVENT_NAME_COMMENT, "评论", commentEventInfoList);
            Event eventShare = new Event(EVENT_NAME_SHARE, "分享", shareEventInfoList);
            Event eventRead = new Event(EVENT_NAME_READ, "阅读", readEventInfoList);


            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_TITLE, "点击提交", null));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_USER_REGISTER + "事件", eventRegister));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_LOGIN + "事件", eventLogin));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_GET_CODE + "事件", eventGetCode));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_PAYMENT + "事件", eventPayment));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_COMMENT + "事件", eventComment));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_SHARE + "事件", eventShare));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_READ + "事件", eventRead));

            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_TITLE, "页面统计", null));
            mainMenuTypeList.add(new MenuType(AdapterMenuType.TYPE_CONTENT, EVENT_NAME_PAGE_VIEW + "事件", eventPageView));
        }
    }
}
