package com.tencent.qalsdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static j f32200a = null;

    /* renamed from: b  reason: collision with root package name */
    static String f32201b = "MSF.C.NetConnInfoCenter";
    private static boolean h = false;
    private static String i = "";
    private static int j;
    private static String k;
    private static String l;
    private static AtomicBoolean m = new AtomicBoolean(false);
    private static long n = -1;
    private static long o = 0;
    private static AtomicBoolean p = new AtomicBoolean();
    private static int q = 0;

    /* renamed from: c  reason: collision with root package name */
    public b f32202c = new b(this, (byte) 0);

    /* renamed from: d  reason: collision with root package name */
    int f32203d;

    /* renamed from: e  reason: collision with root package name */
    int f32204e;

    /* renamed from: f  reason: collision with root package name */
    int f32205f;

    /* renamed from: g  reason: collision with root package name */
    boolean f32206g;
    private boolean r = true;
    private long s = 0;
    private int t = 0;
    private long u = 0;

    private static String a(int i2) {
        return i2 != 0 ? i2 != 1 ? (i2 == 2 || i2 == 3) ? "WiFi" : "UNKNOWN" : "MOBILE" : "NONE";
    }

    static void a(j jVar) {
        f32200a = jVar;
        NetConnInfoCenter.servetTimeSecondInterv = jVar.k.getSharedPreferences(f32201b, 0).getLong("servetTimeDiff", 0);
    }

    public static void a() {
        System.currentTimeMillis();
        p.set(true);
    }

    public static boolean b() {
        return m.get();
    }

    public static void a(boolean z) {
        m.set(z);
        if (QLog.isColorLevel()) {
            String str = f32201b;
            QLog.d(str, 2, "setNetSupport " + m.get());
        }
    }

    public static boolean d() {
        int i2 = j;
        return i2 == 2 || i2 == 3;
    }

    public static boolean e() {
        return j == 1;
    }

    public static String f() {
        return k;
    }

    public static int g() {
        return q;
    }

    public static boolean h() {
        return h;
    }

    public static void b(boolean z) {
        h = false;
    }

    public static String i() {
        return i;
    }

    private static InetAddress b(int i2) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00bf, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01db, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c(int r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = qalsdk.c.c()     // Catch:{ all -> 0x01dc }
            java.lang.String r1 = qalsdk.c.a()     // Catch:{ all -> 0x01dc }
            int r2 = j     // Catch:{ all -> 0x01dc }
            r3 = 2
            if (r2 != r9) goto L_0x00c0
            boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x01dc }
            if (r2 == 0) goto L_0x003f
            java.lang.String r2 = f32201b     // Catch:{ all -> 0x01dc }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = "found repeat net event , now is "
            r4.<init>(r5)     // Catch:{ all -> 0x01dc }
            java.util.concurrent.atomic.AtomicBoolean r5 = m     // Catch:{ all -> 0x01dc }
            boolean r5 = r5.get()     // Catch:{ all -> 0x01dc }
            r4.append(r5)     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = " now:"
            r4.append(r5)     // Catch:{ all -> 0x01dc }
            r4.append(r9)     // Catch:{ all -> 0x01dc }
            java.lang.String r9 = " last:"
            r4.append(r9)     // Catch:{ all -> 0x01dc }
            int r9 = j     // Catch:{ all -> 0x01dc }
            r4.append(r9)     // Catch:{ all -> 0x01dc }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.util.QLog.d(r2, r3, r9)     // Catch:{ all -> 0x01dc }
        L_0x003f:
            if (r0 == 0) goto L_0x0080
            java.lang.String r9 = k     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x004d
            java.lang.String r9 = k     // Catch:{ all -> 0x01dc }
            boolean r9 = r9.equals(r0)     // Catch:{ all -> 0x01dc }
            if (r9 != 0) goto L_0x0080
        L_0x004d:
            boolean r9 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x0070
            java.lang.String r9 = f32201b     // Catch:{ all -> 0x01dc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            java.lang.String r4 = "new ssid :  "
            r2.<init>(r4)     // Catch:{ all -> 0x01dc }
            r2.append(r0)     // Catch:{ all -> 0x01dc }
            java.lang.String r4 = " old ssid: "
            r2.append(r4)     // Catch:{ all -> 0x01dc }
            java.lang.String r4 = k     // Catch:{ all -> 0x01dc }
            r2.append(r4)     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.util.QLog.d(r9, r3, r2)     // Catch:{ all -> 0x01dc }
        L_0x0070:
            k = r0     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x0080
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            qalsdk.c r9 = r9.m     // Catch:{ all -> 0x01dc }
            r9.g()     // Catch:{ all -> 0x01dc }
            p()     // Catch:{ all -> 0x01dc }
        L_0x0080:
            if (r1 == 0) goto L_0x00be
            java.lang.String r9 = l     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x008e
            java.lang.String r9 = l     // Catch:{ all -> 0x01dc }
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x01dc }
            if (r9 != 0) goto L_0x00be
        L_0x008e:
            boolean r9 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x00b1
            java.lang.String r9 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = "Mobile APN changed, load sso list new apn :  "
            r0.<init>(r2)     // Catch:{ all -> 0x01dc }
            r0.append(r1)     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = " old apn: "
            r0.append(r2)     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = l     // Catch:{ all -> 0x01dc }
            r0.append(r2)     // Catch:{ all -> 0x01dc }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.util.QLog.d(r9, r3, r0)     // Catch:{ all -> 0x01dc }
        L_0x00b1:
            l = r1     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x00be
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            qalsdk.c r9 = r9.m     // Catch:{ all -> 0x01dc }
            r9.f()     // Catch:{ all -> 0x01dc }
        L_0x00be:
            monitor-exit(r8)
            return
        L_0x00c0:
            r2 = 0
            r4 = 1
            if (r9 <= 0) goto L_0x00d5
            a((boolean) r4)     // Catch:{ all -> 0x01dc }
            java.util.concurrent.atomic.AtomicBoolean r5 = p     // Catch:{ all -> 0x01dc }
            boolean r5 = r5.get()     // Catch:{ all -> 0x01dc }
            if (r5 == 0) goto L_0x00d8
            java.util.concurrent.atomic.AtomicBoolean r5 = p     // Catch:{ all -> 0x01dc }
            r5.set(r2)     // Catch:{ all -> 0x01dc }
            goto L_0x00d8
        L_0x00d5:
            a((boolean) r2)     // Catch:{ all -> 0x01dc }
        L_0x00d8:
            java.lang.String r5 = f32201b     // Catch:{ all -> 0x01dc }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            java.lang.String r7 = "netchange "
            r6.<init>(r7)     // Catch:{ all -> 0x01dc }
            int r7 = j     // Catch:{ all -> 0x01dc }
            java.lang.String r7 = a((int) r7)     // Catch:{ all -> 0x01dc }
            r6.append(r7)     // Catch:{ all -> 0x01dc }
            java.lang.String r7 = " to "
            r6.append(r7)     // Catch:{ all -> 0x01dc }
            java.lang.String r7 = a((int) r9)     // Catch:{ all -> 0x01dc }
            r6.append(r7)     // Catch:{ all -> 0x01dc }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.util.QLog.d(r5, r4, r6)     // Catch:{ all -> 0x01dc }
            r8.o()     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = ""
            com.tencent.qalsdk.core.n.a((java.lang.String) r5)     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.n.a((int) r2)     // Catch:{ all -> 0x01dc }
            r5 = -2
            r6 = 3
            if (r9 != r4) goto L_0x015b
            int r0 = j     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x01aa
            int r0 = j     // Catch:{ all -> 0x01dc }
            if (r0 == r5) goto L_0x01aa
            int r0 = j     // Catch:{ all -> 0x01dc }
            if (r0 == r3) goto L_0x011c
            int r0 = j     // Catch:{ all -> 0x01dc }
            if (r0 != r6) goto L_0x01aa
        L_0x011c:
            if (r1 == 0) goto L_0x01ab
            java.lang.String r0 = l     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x012a
            java.lang.String r0 = l     // Catch:{ all -> 0x01dc }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x01dc }
            if (r0 != 0) goto L_0x01ab
        L_0x012a:
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x014d
            java.lang.String r0 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = "WIFI to Mobile load mobile sso list new apn :  "
            r2.<init>(r5)     // Catch:{ all -> 0x01dc }
            r2.append(r1)     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = " old apn: "
            r2.append(r5)     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = l     // Catch:{ all -> 0x01dc }
            r2.append(r5)     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.util.QLog.d(r0, r3, r2)     // Catch:{ all -> 0x01dc }
        L_0x014d:
            l = r1     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x01ab
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            qalsdk.c r0 = r0.m     // Catch:{ all -> 0x01dc }
            r0.f()     // Catch:{ all -> 0x01dc }
            goto L_0x01ab
        L_0x015b:
            if (r9 == r3) goto L_0x015f
            if (r9 != r6) goto L_0x01ab
        L_0x015f:
            int r1 = j     // Catch:{ all -> 0x01dc }
            if (r1 == 0) goto L_0x01aa
            int r1 = j     // Catch:{ all -> 0x01dc }
            if (r1 == r5) goto L_0x01aa
            int r1 = j     // Catch:{ all -> 0x01dc }
            if (r1 != r4) goto L_0x01aa
            if (r0 == 0) goto L_0x01ab
            java.lang.String r1 = k     // Catch:{ all -> 0x01dc }
            if (r1 == 0) goto L_0x0179
            java.lang.String r1 = k     // Catch:{ all -> 0x01dc }
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01dc }
            if (r1 != 0) goto L_0x01ab
        L_0x0179:
            boolean r1 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x01dc }
            if (r1 == 0) goto L_0x019c
            java.lang.String r1 = f32201b     // Catch:{ all -> 0x01dc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = "new ssid :  "
            r2.<init>(r5)     // Catch:{ all -> 0x01dc }
            r2.append(r0)     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = " old ssid: "
            r2.append(r5)     // Catch:{ all -> 0x01dc }
            java.lang.String r5 = k     // Catch:{ all -> 0x01dc }
            r2.append(r5)     // Catch:{ all -> 0x01dc }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.util.QLog.d(r1, r3, r2)     // Catch:{ all -> 0x01dc }
        L_0x019c:
            k = r0     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x01ab
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            qalsdk.c r0 = r0.m     // Catch:{ all -> 0x01dc }
            r0.g()     // Catch:{ all -> 0x01dc }
            goto L_0x01ab
        L_0x01aa:
            r4 = 0
        L_0x01ab:
            j = r9     // Catch:{ all -> 0x01dc }
            p()     // Catch:{ all -> 0x01dc }
            if (r4 == 0) goto L_0x01c7
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x01c7
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ all -> 0x01dc }
            if (r0 == 0) goto L_0x01c7
            com.tencent.qalsdk.core.j r0 = f32200a     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ all -> 0x01dc }
            com.tencent.qalsdk.base.CloseConnReason r1 = com.tencent.qalsdk.base.CloseConnReason.netChange     // Catch:{ all -> 0x01dc }
            qalsdk.k r0 = r0.k     // Catch:{ all -> 0x01dc }
            r0.a((com.tencent.qalsdk.base.CloseConnReason) r1)     // Catch:{ all -> 0x01dc }
        L_0x01c7:
            if (r9 <= 0) goto L_0x01da
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x01da
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            qalsdk.ad r9 = r9.f32188d     // Catch:{ all -> 0x01dc }
            if (r9 == 0) goto L_0x01da
            com.tencent.qalsdk.core.j r9 = f32200a     // Catch:{ all -> 0x01dc }
            qalsdk.ad r9 = r9.f32188d     // Catch:{ all -> 0x01dc }
            r9.c()     // Catch:{ all -> 0x01dc }
        L_0x01da:
            monitor-exit(r8)
            return
        L_0x01dc:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.m.c(int):void");
    }

    public static void k() {
        NetConnInfoCenter.socketConnState = 3;
        FromServiceMsg fromServiceMsg = new FromServiceMsg(f32200a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_connAllFailed");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(j.b());
        fromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
        if (f32200a.f32188d.b()) {
            fromServiceMsg.addAttribute("resp_needBootApp", 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f32200a.a((ToServiceMsg) null, fromServiceMsg);
        f32200a.f32187c.k.f34158b.b();
    }

    public static void a(String str, String str2) {
        NetConnInfoCenter.socketConnState = 2;
        f32200a.f32188d.d();
        FromServiceMsg fromServiceMsg = new FromServiceMsg(f32200a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_connOpened");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(j.b());
        fromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
        fromServiceMsg.addAttribute("resp_connopen_serverAdd", str);
        fromServiceMsg.addAttribute("resp_connopen_localAdd", str2);
        if (f32200a.f32188d.b()) {
            fromServiceMsg.addAttribute("resp_needBootApp", 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f32200a.a((ToServiceMsg) null, fromServiceMsg);
    }

    public static void a(CloseConnReason closeConnReason) {
        NetConnInfoCenter.socketConnState = 1;
        f32200a.f32188d.a(closeConnReason);
        FromServiceMsg fromServiceMsg = new FromServiceMsg(f32200a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_connClosed");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setMsfCommand(MsfCommand.onConnClosed);
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f32200a.a((ToServiceMsg) null, fromServiceMsg);
    }

    public final void a(Context context, NetworkInfo networkInfo) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            String typeName = activeNetworkInfo.getTypeName();
            try {
                activeNetworkInfo.getSubtypeName();
            } catch (Exception e2) {
                String str = f32201b;
                QLog.d(str, 1, "get subtypeName error " + e2);
            }
            if (!typeName.toLowerCase().contains("mobile_mms")) {
                String str2 = f32201b;
                QLog.d(str2, 1, "currentAPN:" + i + ". received networkInfo: " + activeNetworkInfo.getDetailedState() + " :" + activeNetworkInfo + ". extra NetworkInfo: " + networkInfo);
                if (!activeNetworkInfo.isAvailable() || activeNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
                    if (activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED || activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.FAILED || activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.IDLE || activeNetworkInfo.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED) {
                        if (1 == activeNetworkInfo.getType()) {
                            c(j & -3);
                        } else {
                            if (activeNetworkInfo.getType() == 0 || 50 == activeNetworkInfo.getType()) {
                                c(j & -2);
                            }
                        }
                    }
                } else if (1 == activeNetworkInfo.getType()) {
                    WifiInfo connectionInfo = ((WifiManager) f32200a.k.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        int ipAddress = connectionInfo.getIpAddress();
                        if (QLog.isColorLevel()) {
                            String str3 = f32201b;
                            QLog.d(str3, 2, "wifiConnected localAddress " + ipAddress + SQLBuilder.PARENTHESES_LEFT + b(ipAddress).getHostAddress() + "), " + connectionInfo.toString());
                        }
                    }
                    c(j | 2);
                } else {
                    if (activeNetworkInfo.getType() == 0 || 50 == activeNetworkInfo.getType()) {
                        c(j & -3);
                        a(activeNetworkInfo);
                    }
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                String str4 = f32201b;
                QLog.d(str4, 2, "currentAPN:" + i + ". active NetworkInfo: " + activeNetworkInfo + ". extra NetworkInfo: " + networkInfo);
            }
            if (networkInfo != null && (networkInfo.getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED || networkInfo.getDetailedState() == NetworkInfo.DetailedState.FAILED || networkInfo.getDetailedState() == NetworkInfo.DetailedState.IDLE || networkInfo.getDetailedState() == NetworkInfo.DetailedState.SUSPENDED)) {
                if (1 == networkInfo.getType()) {
                    c(j & -3);
                } else {
                    if (networkInfo.getType() == 0 || 50 == networkInfo.getType()) {
                        c(j & -2);
                    }
                }
            }
        }
        try {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 == null) {
                networkInfo2 = connectivityManager.getNetworkInfo(50);
            }
            if (networkInfo2 != null) {
                i = networkInfo2.getExtraInfo();
            }
        } catch (Exception e3) {
            String str5 = f32201b;
            QLog.d(str5, 1, "get currentAPN error " + e3);
        }
    }

    private void a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            q = networkInfo.getSubtype();
        } else {
            try {
                q = ((TelephonyManager) f32200a.k.getSystemService("phone")).getNetworkType();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        c(j | 1);
    }

    public final void m() {
        System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.u;
        if (elapsedRealtime - j2 <= 0 || elapsedRealtime - j2 > qalsdk.a.f()) {
            if (this.t < 10) {
                if (f32200a != null) {
                    ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "Client.CorrectTime");
                    toServiceMsg.setMsfCommand(MsfCommand.getServerTime);
                    toServiceMsg.setAppId(f32200a.f32187c.g());
                    toServiceMsg.setTimeout(10000);
                    toServiceMsg.setRequestSsoSeq(j.b());
                    toServiceMsg.addAttribute("__base_tag_isAppMsg", true);
                    toServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
                    f32200a.f32187c.a(toServiceMsg);
                }
                this.t++;
                this.u = elapsedRealtime;
            } else if (QLog.isColorLevel()) {
                QLog.d(f32201b, 2, "also send checkTimeMsg " + this.t);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.s;
            if (j3 == 0 || elapsedRealtime - j3 > 600000) {
                this.s = elapsedRealtime;
                this.t = 0;
            }
            n = currentTimeMillis;
            if (l.a() != null) {
                l.a().n_setConfig("recordSysTimeKey", String.valueOf(currentTimeMillis));
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(f32201b, 2, "quit to checkTimeMsg too frequency.");
        }
    }

    public final void n() {
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (0 != o && elapsedRealtime > o + qalsdk.a.i()) {
                o = elapsedRealtime;
                if (-1 == n) {
                    if (l.a() != null) {
                        String config = l.a().getConfig("recordSysTimeKey");
                        if (config != null) {
                            try {
                                n = Long.parseLong(config);
                            } catch (Exception e2) {
                                if (QLog.isColorLevel()) {
                                    String str = f32201b;
                                    QLog.d(str, 2, "get lastCheckTime catch Exception " + e2);
                                }
                            }
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (-1 != n) {
                    double d2 = (double) currentTimeMillis;
                    double g2 = (double) (n + qalsdk.a.g());
                    double random = Math.random();
                    double h2 = (double) qalsdk.a.h();
                    Double.isNaN(h2);
                    Double.isNaN(g2);
                    if (d2 > g2 + (random * h2)) {
                        m();
                        return;
                    }
                    return;
                }
                n = currentTimeMillis;
                if (l.a() != null) {
                    l.a().n_setConfig("recordSysTimeKey", String.valueOf(n));
                }
            } else if (0 == o) {
                o = elapsedRealtime;
            }
        } catch (Exception e3) {
            if (QLog.isColorLevel()) {
                String str2 = f32201b;
                QLog.d(str2, 2, "checkRecordTime catch Exception " + e3);
            }
        }
    }

    public static void a(long j2) {
        if (QLog.isDevelopLevel()) {
            String str = f32201b;
            QLog.e(str, 4, "handleGetServerTimeResp servertime is " + j2);
        }
        NetConnInfoCenter.servetTimeSecondInterv = j2 - (System.currentTimeMillis() / 1000);
        SharedPreferences.Editor edit = f32200a.k.getSharedPreferences(f32201b, 0).edit();
        edit.putLong("servetTimeDiff", NetConnInfoCenter.servetTimeSecondInterv);
        edit.commit();
        if (QLog.isColorLevel()) {
            String str2 = f32201b;
            QLog.d(str2, 2, "set serverTime is " + f32200a.h.format(Long.valueOf(System.currentTimeMillis() + (NetConnInfoCenter.servetTimeSecondInterv * 1000))));
        }
        j.a("*", f32200a.f32187c.g());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void o() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.r     // Catch:{ all -> 0x0054 }
            r1 = 0
            if (r0 == 0) goto L_0x0050
            r0 = 1
            com.tencent.qalsdk.core.j r2 = f32200a     // Catch:{ Exception -> 0x0038 }
            android.content.Context r2 = r2.k     // Catch:{ Exception -> 0x0038 }
            java.lang.String r3 = "wifi"
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x0038 }
            android.net.wifi.WifiManager r2 = (android.net.wifi.WifiManager) r2     // Catch:{ Exception -> 0x0038 }
            if (r2 == 0) goto L_0x0036
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()     // Catch:{ Exception -> 0x0038 }
            if (r2 == 0) goto L_0x001d
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            java.lang.String r4 = r2.getBSSID()     // Catch:{ Exception -> 0x0038 }
            if (r4 == 0) goto L_0x0026
            r4 = 1
            goto L_0x0027
        L_0x0026:
            r4 = 0
        L_0x0027:
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0036
            int r2 = r2.getRssi()     // Catch:{ Exception -> 0x0038 }
            r3 = 32
            int r2 = android.net.wifi.WifiManager.calculateSignalLevel(r2, r3)     // Catch:{ Exception -> 0x0038 }
            r6.f32203d = r2     // Catch:{ Exception -> 0x0038 }
        L_0x0036:
            monitor-exit(r6)
            return
        L_0x0038:
            r2 = move-exception
            java.lang.String r3 = f32201b     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "check WifiState error "
            r4.<init>(r5)     // Catch:{ all -> 0x0054 }
            r4.append(r2)     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0054 }
            com.tencent.qalsdk.util.QLog.d(r3, r0, r4, r2)     // Catch:{ all -> 0x0054 }
            r6.r = r1     // Catch:{ all -> 0x0054 }
            monitor-exit(r6)
            return
        L_0x0050:
            r6.f32203d = r1     // Catch:{ all -> 0x0054 }
            monitor-exit(r6)
            return
        L_0x0054:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.m.o():void");
    }

    class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(m mVar, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            m.this.o();
        }
    }

    class a extends PhoneStateListener {
        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            m.this.f32205f = signalStrength.getCdmaDbm();
            int gsmSignalStrength = signalStrength.getGsmSignalStrength();
            if (gsmSignalStrength == 99) {
                gsmSignalStrength = -3;
            }
            m mVar = m.this;
            mVar.f32204e = gsmSignalStrength;
            mVar.f32206g = signalStrength.isGsm();
            m.this.o();
        }
    }

    public static boolean c() {
        int i2 = j;
        if (!(i2 == 2 || i2 == 3)) {
            return j == 1;
        }
    }

    public static int j() {
        int i2 = j;
        boolean z = true;
        if (i2 == 2 || i2 == 3) {
            return j;
        }
        if (j != 1) {
            z = false;
        }
        if (z) {
            return q + 10000;
        }
        return 0;
    }

    private static void p() {
        int i2 = j;
        if (i2 == 2 || i2 == 3) {
            j jVar = f32200a;
            if (jVar != null && jVar.f32187c != null) {
                f32200a.f32187c.k.f34158b.a(k);
                return;
            }
            return;
        }
        j jVar2 = f32200a;
        if (jVar2 != null && jVar2.f32187c != null) {
            f32200a.f32187c.k.f34158b.a();
        }
    }

    public static void l() {
        int i2 = j;
        if (i2 == 2 || i2 == 3) {
            f32200a.f32187c.k.f34158b.b(k);
        }
        NetConnInfoCenter.socketConnState = 4;
        FromServiceMsg fromServiceMsg = new FromServiceMsg(f32200a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_recvFirstResp");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(j.b());
        fromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
        if (f32200a.f32188d.b()) {
            fromServiceMsg.addAttribute("resp_needBootApp", 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f32200a.a((ToServiceMsg) null, fromServiceMsg);
    }
}
