package com.shopee.app.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shopee.app.application.ar;

public class a {
    public static boolean a(int i, int i2) {
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            switch (i2) {
                case 1:
                case 2:
                    break;
                case 3:
                    return true;
                case 4:
                    return false;
                case 5:
                case 6:
                    return true;
                case 7:
                    return false;
                case 8:
                case 9:
                case 10:
                    return true;
                case 11:
                    return false;
                case 12:
                case 13:
                case 14:
                case 15:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public static NetworkInfo a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean a() {
        NetworkInfo a2 = a(ar.a());
        return a2 != null && a2.isConnected();
    }

    public static boolean b(Context context) {
        NetworkInfo a2 = a(context);
        if (a2 == null || !a2.isConnected() || a2.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a2.isConnected() && a2.getType() == 0;
    }

    public static boolean d(Context context) {
        NetworkInfo a2 = a(context);
        return a2 != null && a(a2.getType(), a2.getSubtype());
    }

    public static String e(Context context) {
        NetworkInfo a2 = a(context);
        if (a2 == null || a2.getType() != 0) {
            return "NETWORK_TYPE_UNKNOWN";
        }
        switch (a2.getSubtype()) {
            case 1:
                return "NETWORK_TYPE_GPRS";
            case 2:
                return "NETWORK_TYPE_EDGE";
            case 3:
                return "NETWORK_TYPE_UMTS";
            case 4:
                return "NETWORK_TYPE_CDMA";
            case 5:
                return "NETWORK_TYPE_EVDO_0";
            case 6:
                return "NETWORK_TYPE_EVDO_A";
            case 7:
                return "NETWORK_TYPE_1xRTT";
            case 8:
                return "NETWORK_TYPE_HSDPA";
            case 9:
                return "NETWORK_TYPE_HSUPA";
            case 10:
                return "NETWORK_TYPE_HSPA";
            case 11:
                return "NETWORK_TYPE_IDEN";
            case 12:
                return "NETWORK_TYPE_EVDO_B";
            case 13:
                return "NETWORK_TYPE_LTE";
            case 14:
                return "NETWORK_TYPE_EHRPD";
            case 15:
                return "NETWORK_TYPE_HSPAP";
            default:
                return "NETWORK_TYPE_UNKNOWN";
        }
    }
}
