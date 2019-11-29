package com.bca.xco.widget.e;

import android.content.Context;
import android.provider.Settings;
import android.webkit.WebView;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;

public class f {
    public String a(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        if (bool.booleanValue()) {
            try {
                str2 = b(context);
            } catch (Exception unused) {
                str2 = "null";
            }
            stringBuffer.append(str2);
            stringBuffer.append(str);
            c.a("Device ID", str2);
        }
        if (bool3.booleanValue()) {
            String a2 = a(context);
            stringBuffer.append(a2);
            stringBuffer.append(str);
            c.a("User Agent", a2);
        }
        if (bool2.booleanValue()) {
            stringBuffer.append(a(true));
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public String a(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Exception unused) {
            return "null";
        }
    }

    public String b(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private String a(boolean z) {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            boolean z2 = hostAddress.indexOf(58) < 0;
                            if (z) {
                                if (z2) {
                                    return hostAddress;
                                }
                            } else if (!z2) {
                                int indexOf = hostAddress.indexOf(37);
                                return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
