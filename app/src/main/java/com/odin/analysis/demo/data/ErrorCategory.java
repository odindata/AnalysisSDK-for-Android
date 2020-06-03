package com.odin.analysis.demo.data;

/**
 * 自己定义错误类别
 */
public enum ErrorCategory {

    ERROR_DEFAULT(0, "未知错误"),
    ERROR_GET_SERVE_CONFIG(1, "获取服务器配置错误"),
    ERROR_UPLOAD_FILE(2, "上传文件错误"),
    ERROR_OTHERS(3, "其他错误");

    private int category;
    private String msg;

    private ErrorCategory(int category, String msg) {
        this.category = category;
        this.msg = msg;
    }

    public static int getCategory(ErrorCategory errorCategory) {
        switch (errorCategory) {
            case ERROR_GET_SERVE_CONFIG:
                return 1;
            case ERROR_UPLOAD_FILE:
                return 2;
            case ERROR_OTHERS:
                return 3;
            case ERROR_DEFAULT:
            default:
                return 0;
        }
    }

    public static String getMsg(ErrorCategory errorCategory) {
        switch (errorCategory) {
            case ERROR_GET_SERVE_CONFIG:
                return "获取服务器配置错误";
            case ERROR_UPLOAD_FILE:
                return "上传文件错误";
            case ERROR_OTHERS:
                return "其他错误";
            case ERROR_DEFAULT:
            default:
                return "未知错误";
        }
    }
}
