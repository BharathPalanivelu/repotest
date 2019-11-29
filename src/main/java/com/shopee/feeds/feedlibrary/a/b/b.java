package com.shopee.feeds.feedlibrary.a.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class b {

    public enum a {
        NETWORK_WIFI("wifi"),
        NETWORK_4G("4G"),
        NETWORK_3G("3G"),
        NETWORK_2G("2G"),
        NETWORK_UNKNOWN("unknown"),
        NETWORK_NO("no");
        
        private String name;

        private a(String str) {
            this.name = str;
        }
    }

    private static NetworkInfo b() {
        return ((ConnectivityManager) c.a().getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static a a() {
        a aVar = a.NETWORK_NO;
        NetworkInfo b2 = b();
        if (b2 == null || !b2.isAvailable()) {
            return aVar;
        }
        if (b2.getType() == 1) {
            return a.NETWORK_WIFI;
        }
        if (b2.getType() != 0) {
            return a.NETWORK_UNKNOWN;
        }
        switch (b2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return a.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return a.NETWORK_3G;
            case 13:
            case 18:
                return a.NETWORK_4G;
            default:
                String subtypeName = b2.getSubtypeName();
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return a.NETWORK_3G;
                }
                return a.NETWORK_UNKNOWN;
        }
    }
}
