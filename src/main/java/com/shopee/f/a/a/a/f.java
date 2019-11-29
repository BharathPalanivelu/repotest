package com.shopee.f.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

public class f extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("TVC-NetWorkMonitor", "网络状态发生变化");
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if ((!networkInfo.isConnected() || !networkInfo2.isConnected()) && ((!networkInfo.isConnected() || networkInfo2.isConnected()) && (networkInfo.isConnected() || !networkInfo2.isConnected()))) {
                z = false;
            }
        } else {
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            Network[] allNetworks = connectivityManager2.getAllNetworks();
            StringBuilder sb = new StringBuilder();
            boolean z2 = false;
            for (Network networkInfo3 : allNetworks) {
                NetworkInfo networkInfo4 = connectivityManager2.getNetworkInfo(networkInfo3);
                sb.append(networkInfo4.getTypeName() + " connect is " + networkInfo4.isConnected());
                if (networkInfo4.isConnected()) {
                    z2 = true;
                }
            }
            z = z2;
        }
        if (z) {
            j.a().b();
        }
    }
}
