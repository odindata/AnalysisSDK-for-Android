package com.odin.analysis.demo.data;

/**
 * 自己定义错误类型
 */
public enum ErrorType {

    ERROR_TYPE_HTTP(0, "网络请求异常"),
    ERROR_TYPE_DATA_FORMAT(1, "数据转换异常"),
    ERROR_TYPE_NULL_POINTER(2, "空指针异常"),
    ERROR_TYPE_OTHER(3, "其他异常");

    private int type;
    private String msg;

    private ErrorType(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public static int getType(ErrorType errorType) {
        switch (errorType) {
            case ERROR_TYPE_HTTP:
                return 1;
            case ERROR_TYPE_DATA_FORMAT:
                return 2;
            case ERROR_TYPE_NULL_POINTER:
                return 3;
            case ERROR_TYPE_OTHER:
            default:
                return 0;
        }
    }

    public static String getMsg(ErrorType errorType) {
        switch (errorType) {
            case ERROR_TYPE_HTTP:
                return "网络请求异常";
            case ERROR_TYPE_DATA_FORMAT:
                return "数据转换异常";
            case ERROR_TYPE_NULL_POINTER:
                return "空指针异常";
            case ERROR_TYPE_OTHER:
            default:
                return "其他异常";
        }
    }

}
