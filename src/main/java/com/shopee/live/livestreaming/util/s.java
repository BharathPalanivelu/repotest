package com.shopee.live.livestreaming.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;

public class s {
    public static String a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
            case 17:
                return "4g";
            default:
                return "unknow";
        }
    }

    public static String a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "unknow";
            }
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase(ConnectivityEvent.TECHNOLOGY_WIFI)) {
                return "wifi";
            }
            if (!typeName.equalsIgnoreCase("MOBILE")) {
                return "";
            }
            try {
                return a(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }
}
