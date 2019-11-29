package com.shopee.app.react.modules.app.data;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.a.o;
import com.shopee.app.application.ar;

public class r implements h {
    public boolean a(String str) {
        return "wifi".equals(str);
    }

    public String b(String str) {
        NetworkInfo networkInfo = ((ConnectivityManager) ar.f().getSystemService("connectivity")).getNetworkInfo(1);
        o oVar = new o();
        oVar.a("wifi", Boolean.valueOf(networkInfo.isConnected()));
        return oVar.toString();
    }
}
