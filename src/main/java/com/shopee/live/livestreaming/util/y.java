package com.shopee.live.livestreaming.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.shopee.live.livestreaming.b;
import com.shopee.sdk.modules.ui.c.a;

public class y {

    public interface a {
        void a();

        void b();
    }

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 2;
            }
        }
        return -1;
    }

    public static boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b.b().c().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public static void a(Activity activity, a aVar) {
        if (com.shopee.sdk.b.a().d().b()) {
            aVar.a();
            return;
        }
        com.shopee.sdk.b.a().b().a(activity, new a.C0473a().a());
        aVar.b();
    }
}
