package com.shopee.app.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shopee.app.application.ar;
import com.shopee.app.h.a.g;
import com.shopee.app.network.e;

public class al extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
        if (!a(context)) {
            g.f17615a.a();
        }
        if (ar.f().e().appLifeCycleManager().a()) {
            return;
        }
        if (booleanExtra) {
            e.c().a(false);
        } else {
            e.c().d();
        }
    }

    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
