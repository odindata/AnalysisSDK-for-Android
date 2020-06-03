package com.odin.analysis.demo.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import androidx.core.content.ContextCompat;

public class DeviceUtils {

    private Context context;
    private static DeviceUtils deviceUtils;

    public static synchronized DeviceUtils getInstance(Context c) {
        if (deviceUtils == null && c != null) {
            deviceUtils = new DeviceUtils(c);
        }
        return deviceUtils;
    }

    private DeviceUtils(Context context) {
        this.context = context.getApplicationContext();
    }

    /**
     * 获取设备的品牌
     *
     * @return 品牌
     */
    public String getBrand() {
        return Build.BRAND;
    }

    /**
     * 获取设备的MODEL
     *
     * @return MODEL
     */
    public String getModel() {
        return Build.MODEL;
    }

    public String getLanguage() {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    @SuppressLint("HardwareIds")
    public String getIMEI() {
        try {
            TelephonyManager tm = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE));
            if (tm == null) {
                return "";
            }
            String imei = "";
            if (checkPermission(Manifest.permission.READ_PHONE_STATE)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    imei = tm.getImei();
                } else {
                    imei = tm.getDeviceId();
                }
            } else {
                imei = tm.getDeviceId();
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @SuppressLint("HardwareIds")
    public String getIMSI() {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm == null) {
                return "";
            }
            String imsi = "";
            if (checkPermission(Manifest.permission.READ_PHONE_STATE)) {
                imsi = tm.getSubscriberId();
            }
            if (null == imsi) {
                imsi = "";
            }
            return imsi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean checkPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, permission);
    }
}
