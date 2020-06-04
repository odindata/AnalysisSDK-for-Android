package com.odin.analysis.demo.utils;

import com.odin.analysis.OdinAnalysis;
import com.odin.analysis.demo.Constant;

import java.util.HashMap;

/**
 * OdinAnalysisSDK泛事件的埋点：
 * 1、在奥丁数据开发者中心的AnalySDK找到“预置事件”；
 * 2、在“预置事件”找到需要埋点的事件，点击“操作”查看埋点的属性信息；
 * 3、调用OdinAnalysis.trackEvent(事件名, 属性信息)收集事件信息，属性信息存放在HashMap<String, Object>中，具体操作如下所示。
 */
public class EventApi {

    /**
     * 收集登录事件
     *
     * @param event_code 事件code
     * @param user_id    用户id
     */
    public static void loginEvent(String event_code, String user_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("user_id", user_id);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_LOGIN, hashMap);
    }

    /**
     * 收集注册事件
     *
     * @param event_code 事件code
     * @param user_id    用户id
     */
    public static void registerEvent(String event_code, String user_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("user_id", user_id);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_USER_REGISTER, hashMap);
    }

    /**
     * 收集获取验证码事件
     *
     * @param event_code   事件code
     * @param event_id     事件id
     * @param event_name   事件name
     * @param service_type 业务类型
     * @param page_id      当前页id
     */
    public static void sendGetCodeEvent(String event_code, String event_id, String event_name,
                                        String service_type, String page_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("event_id", event_id);
        hashMap.put("event_name", event_name);
        hashMap.put("service_type", service_type);
        hashMap.put("page_id", page_id);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_GET_CODE, hashMap);
    }

    /**
     * 收集支付事件
     *
     * @param event_code     事件code
     * @param event_id       事件id
     * @param event_name     事件name
     * @param payment_type   支付方式
     * @param payment_status 支付状态
     * @param order_type     订单类型
     * @param order_number   订单号
     * @param pay_number     支付账号
     * @param amount         订单金额
     */
    public static void sendPaymentEvent(String event_code, String event_id, String event_name,
                                        int payment_type, int payment_status, String order_type, String order_number, String pay_number, float amount) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("event_id", event_id);
        hashMap.put("event_name", event_name);
        hashMap.put("payment_type", payment_type);
        hashMap.put("payment_status", payment_status);
        hashMap.put("order_type", order_type);
        hashMap.put("order_number", order_number);
        hashMap.put("pay_number", pay_number);
        hashMap.put("amount", amount);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_PAYMENT, hashMap);
    }

    /**
     * 收集分享事件
     *
     * @param event_code       事件code
     * @param event_id         事件id
     * @param event_name       事件name
     * @param content_id       内容id
     * @param content_name     内容名称
     * @param way              分享方式
     * @param author           作者
     * @param content_category 标签类型
     */
    public static void sendShareEvent(String event_code, String event_id, String event_name,
                                      String content_id, String content_name, String way, String author, String content_category) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("event_id", event_id);
        hashMap.put("event_name", event_name);
        hashMap.put("content_id", content_id);
        hashMap.put("content_name", content_name);
        hashMap.put("way", way);
        hashMap.put("author", author);
        hashMap.put("content_category", content_category);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_SHARE, hashMap);
    }

    /**
     * 收集评论事件
     *
     * @param event_code       事件code
     * @param event_id         事件id
     * @param event_name       事件name
     * @param content_category 搜索词
     * @param content_name     是否使用推荐词
     * @param content          是否使用历史词
     */
    public static void sendCommentEvent(String event_code, String event_id, String event_name,
                                        String content_category, String content_name, String content) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("event_id", event_id);
        hashMap.put("event_name", event_name);
        hashMap.put("content_category", content_category);
        hashMap.put("content_name", content_name);
        hashMap.put("content", content);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_COMMENT, hashMap);
    }


    /**
     * 收集阅读事件
     *
     * @param event_code     事件code
     * @param event_id       事件id
     * @param event_name     事件name
     * @param chapter_finish 搜索词
     * @param chapter_start  是否使用推荐词
     * @param publish_time   是否使用历史词
     * @param author         是否有结果
     */
    public static void sendReadInfoEvent(String event_code, String event_id, String event_name,
                                         String chapter_finish, String chapter_start, String publish_time, String author) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_code", event_code);
        hashMap.put("event_id", event_id);
        hashMap.put("event_name", event_name);
        hashMap.put("chapter_finish", chapter_finish);
        hashMap.put("chapter_start", chapter_start);
        hashMap.put("publish_time", publish_time);
        hashMap.put("author", author);
        OdinAnalysis.trackEvent(Constant.EVENT.EVENT_NAME_READ, hashMap);
    }
}
