package com.tencent.qalsdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.service.QalService;
import com.tencent.qalsdk.util.QLog;
import qalsdk.a;

public class NetConnInfoCenter extends BroadcastReceiver {
    public static final String TAG = "NetConnInfoCenter";
    public static m impl = new m();
    private static boolean sHasBooted = false;
    public static long servetTimeSecondInterv = 0;
    public static volatile int socketConnState = 0;

    public static long getServerTime() {
        return (System.currentTimeMillis() / 1000) + servetTimeSecondInterv;
    }

    public static void init(j jVar) {
        m.a(jVar);
        m mVar = impl;
        Context context = jVar.k;
        ((TelephonyManager) context.getSystemService("phone")).listen(new m.a(mVar, (byte) 0), 256);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        context.registerReceiver(mVar.f32202c, intentFilter);
    }

    public static String getSignalStrengthsLog() {
        return " SignalStrengths wifi:" + getWifiStrength() + " gsm:" + getGsmStrength() + " cdma:" + getCdmaStrength() + " net:" + m.j();
    }

    public static void checkConnInfo(Context context) {
        impl.a(context, (NetworkInfo) null);
    }

    public static void checkConnInfo(Context context, boolean z) {
        impl.a(context, (NetworkInfo) null);
    }

    public static void onConnOpened(String str, String str2) {
        m.a(str, str2);
    }

    public static void onRecvFirstResp() {
        m.l();
    }

    public static void onOepnConnAllFailed() {
        m.k();
    }

    public static void onConnClosed(CloseConnReason closeConnReason) {
        m.a(closeConnReason);
    }

    public static void handleGetServerTimeResp(long j) {
        m.a(j);
    }

    public static int getWifiStrength() {
        if (impl.f32203d == 0 && m.d()) {
            impl.o();
        }
        return impl.f32203d;
    }

    public static int getCdmaStrength() {
        return impl.f32205f;
    }

    public static int getGsmStrength() {
        return impl.f32204e;
    }

    public static boolean isGSM() {
        return impl.f32206g;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (QLog.isColorLevel()) {
                String str = m.f32201b;
                QLog.d(str, 2, "receive broadcast " + intent);
            }
            if (intent.getAction() != null) {
                boolean z = false;
                if (!sHasBooted) {
                    sHasBooted = true;
                    if (SystemClock.elapsedRealtime() < 300000) {
                        z = true;
                    }
                }
                if (!QalService.inited) {
                    try {
                        String str2 = m.f32201b;
                        QLog.e(str2, "receive broadcast, boot qalservice|" + z + ":" + intent.getAction());
                        QalService.sIsCreatedByAutoBoot = z;
                        context.startService(new Intent(context, QalService.class));
                    } catch (RuntimeException e2) {
                        String str3 = m.f32201b;
                        QLog.e(str3, "startService exception:" + e2.getMessage());
                    }
                }
                try {
                    if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        try {
                            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                            if (parcelableExtra != null) {
                                impl.a(context, (NetworkInfo) parcelableExtra);
                            }
                        } catch (ClassCastException e3) {
                            QLog.d(m.f32201b, 2, e3.toString());
                        } catch (Exception e4) {
                            if (QLog.isColorLevel()) {
                                QLog.d(m.f32201b, 2, e4.toString(), e4);
                            }
                        }
                    } else {
                        if (!intent.getAction().equals("android.intent.action.TIME_SET") && !intent.getAction().equals("android.intent.action.DATE_CHANGED")) {
                            if (!intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                                if (z) {
                                    a.a(true);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(m.f32201b, 2, "set StatReporter.needReportBooting true");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            String str4 = m.f32201b;
                            QLog.d(str4, 2, "recv broadcast " + intent.getAction());
                        }
                        impl.m();
                    }
                } catch (UnsatisfiedLinkError e5) {
                    String str5 = m.f32201b;
                    QLog.e(str5, "onReceive native not find" + e5.getMessage());
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(m.f32201b, 2, "receive broadcast intent.getAction() == null return");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(m.f32201b, 2, "receive broadcast intent == null return");
        }
    }
}
