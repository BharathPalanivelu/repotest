package com.garena.android.gpns.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.UUID;

public final class DeviceUtil {
    public static boolean isConnectedToNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        boolean z = false;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if ((networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) || (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED)) {
            z = true;
        }
        AppLogger.d("Connected To Network: " + z);
        return z;
    }

    private DeviceUtil() {
    }

    public static long generateDeviceId() {
        return (((long) UUID.randomUUID().hashCode()) & -65536) + (((long) UUID.randomUUID().hashCode()) & 65535);
    }
}
