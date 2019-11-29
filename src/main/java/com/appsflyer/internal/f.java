package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;

public final class f {

    static final class a {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final f f169 = new f();
    }

    f() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static f m149() {
        return a.f169;
    }

    public static final class e {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final String f170;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String f171;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final String f172;

        e(String str, String str2, String str3) {
            this.f170 = str;
            this.f171 = str2;
            this.f172 = str3;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static e m148(Context context) {
        String str;
        String str2 = "unknown";
        String str3 = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                boolean z = false;
                if (21 <= Build.VERSION.SDK_INT) {
                    Network[] allNetworks = connectivityManager.getAllNetworks();
                    int length = allNetworks.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i]);
                        if (!(networkInfo != null && networkInfo.isConnectedOrConnecting())) {
                            i++;
                        } else if (1 != networkInfo.getType()) {
                            if (networkInfo.getType() == 0) {
                            }
                        }
                    }
                } else {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                    if (!(networkInfo2 != null && networkInfo2.isConnectedOrConnecting())) {
                        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
                        if (!(networkInfo3 != null && networkInfo3.isConnectedOrConnecting())) {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                                z = true;
                            }
                            if (z) {
                                if (1 != activeNetworkInfo.getType()) {
                                    if (activeNetworkInfo.getType() == 0) {
                                    }
                                }
                            }
                        }
                        str2 = "MOBILE";
                    }
                }
                str2 = ConnectivityEvent.TECHNOLOGY_WIFI;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager.getSimOperatorName();
            try {
                str3 = telephonyManager.getNetworkOperatorName();
                if ((str3 == null || str3.isEmpty()) && 2 == telephonyManager.getPhoneType()) {
                    str3 = ConnectivityEvent.RADIO_TYPE_CDMA;
                }
            } catch (Throwable th) {
                th = th;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                return new e(str2, str3, str);
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            AFLogger.afErrorLog("Exception while collecting network info. ", th);
            return new e(str2, str3, str);
        }
        return new e(str2, str3, str);
    }
}
