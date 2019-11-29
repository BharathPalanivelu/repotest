package com.shopee.app.react.modules.app.data;

import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import com.google.a.o;
import com.shopee.app.application.ar;

public class f implements h {
    public boolean a(String str) {
        return "clientIp".equals(str);
    }

    public String b(String str) {
        String formatIpAddress = Formatter.formatIpAddress(((WifiManager) ar.f().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
        o oVar = new o();
        oVar.a("clientIp", formatIpAddress);
        return oVar.toString();
    }
}
