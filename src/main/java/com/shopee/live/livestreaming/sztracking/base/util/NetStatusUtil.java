package com.shopee.live.livestreaming.sztracking.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetStatusUtil {
    public static final int NETWORN_2G = 3;
    public static final int NETWORN_3G = 4;
    public static final int NETWORN_4G = 5;
    public static final int NETWORN_ETHERNET = 6;
    public static final int NETWORN_MOBILE = 2;
    public static final int NETWORN_NONE = 0;
    public static final int NETWORN_WIFI = 1;
    public static final int UnCon_WIFI = 7;

    public static int getNetworkState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null) {
                NetworkInfo.State state = networkInfo.getState();
                if (state != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING || state == NetworkInfo.State.DISCONNECTED)) {
                    return 1;
                }
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 3;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 4;
                        case 13:
                            return 5;
                        default:
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return 4;
                            }
                            return 2;
                    }
                }
            }
            NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(9);
            if (networkInfo3 != null) {
                NetworkInfo.State state3 = networkInfo3.getState();
                if (state3 == null || (state3 != NetworkInfo.State.CONNECTED && state3 != NetworkInfo.State.CONNECTING)) {
                    return 0;
                }
                return 6;
            }
        }
        return 0;
    }
}
