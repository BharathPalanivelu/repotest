package com.tencent.qalsdk.core;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.g.a.a.e;
import com.garena.android.gpns.utility.CONSTANT;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.sdk.r;
import com.tencent.qalsdk.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import qalsdk.a;
import qalsdk.ad;
import qalsdk.ag;
import qalsdk.am;
import qalsdk.c;
import qalsdk.z;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f32185a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public static String f32186b = null;
    private static final AtomicInteger q = new AtomicInteger(new Random().nextInt(100000));
    private static j r = new j();

    /* renamed from: c  reason: collision with root package name */
    public n f32187c;

    /* renamed from: d  reason: collision with root package name */
    public ad f32188d;

    /* renamed from: e  reason: collision with root package name */
    public a f32189e;

    /* renamed from: f  reason: collision with root package name */
    public String f32190f = null;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f32191g = new AtomicBoolean();
    public SimpleDateFormat h = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
    public am i;
    public NetConnInfoCenter j;
    public Context k = null;
    public volatile String l;
    c m;
    String n = null;
    i o;
    AtomicBoolean p = new AtomicBoolean(false);
    private String s = null;
    private l t;
    private LinkedBlockingQueue<r> u = new LinkedBlockingQueue<>();
    private AtomicBoolean v = new AtomicBoolean();
    private a w;
    private int x = 537050853;
    private p y;
    private int z = 0;

    static {
        "0123456789abcdef".toCharArray();
        try {
            System.loadLibrary("qalcodecwrapper");
            System.loadLibrary("qalmsfboot");
            f32185a.set(true);
            QLog.e("MSF.C.MsfCore", "system load so library succ!");
        } catch (UnsatisfiedLinkError e2) {
            QLog.e("MSF.C.MsfCore", "system load so library error:" + e2.getMessage());
        }
    }

    public static j a() {
        return r;
    }

    public static synchronized int b() {
        int incrementAndGet;
        synchronized (j.class) {
            incrementAndGet = q.incrementAndGet();
            if (incrementAndGet > 1000000) {
                q.set(new Random().nextInt(100000) + CONSTANT.TIME.MIN_1);
            }
        }
        return incrementAndGet;
    }

    public static void a(String str, int i2) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_pushSetConfig");
        fromServiceMsg.setAppId(i2);
        fromServiceMsg.setMsfCommand(MsfCommand.pushSetConfig);
        MsfSdkUtils.addFromMsgProcessName(str, fromServiceMsg);
        fromServiceMsg.addAttribute("_attr_socket_connstate", Integer.valueOf(NetConnInfoCenter.socketConnState));
        fromServiceMsg.addAttribute("_attr_server", Long.valueOf(NetConnInfoCenter.servetTimeSecondInterv));
        fromServiceMsg.setMsgSuccess();
        com.tencent.qalsdk.service.c.a("*", (ToServiceMsg) null, fromServiceMsg);
    }

    public static byte[] a(FromServiceMsg fromServiceMsg) {
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer.length - 4 < 0) {
            return null;
        }
        byte[] bArr = new byte[(wupBuffer.length - 4)];
        System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
        return bArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.tencent.qalsdk.util.QLog.e("MSF.C.MsfCore", "MsfCore setLogLevel UnsatisfiedLinkError. so init:" + f32185a.get());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00b7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "load sso server env:"
            r1 = 1
            java.lang.String r2 = "MSF.C.MsfCore"
            java.lang.String r3 = "MsfCore init begin."
            com.tencent.qalsdk.util.QLog.d(r2, r1, r3)
            r7.k = r8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = r8.getFilesDir()
            java.lang.String r4 = r4.getAbsolutePath()
            r3.append(r4)
            java.lang.String r4 = "/tencent/qalsdk"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.s = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r7.s
            r3.append(r4)
            java.lang.String r4 = "/qalimid_v2"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.n = r3
            com.tencent.qalsdk.core.d.a((android.content.Context) r8)
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = r7.s     // Catch:{ Exception -> 0x0050 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0050 }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0050 }
            if (r4 != 0) goto L_0x0062
            r3.mkdirs()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0062
        L_0x0050:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "File operation error "
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r3)
        L_0x0062:
            com.tencent.qalsdk.core.k.a((android.content.Context) r8)
            r3 = 0
            com.tencent.qalsdk.core.l r4 = new com.tencent.qalsdk.core.l     // Catch:{ Exception -> 0x020f }
            r4.<init>()     // Catch:{ Exception -> 0x020f }
            r7.t = r4     // Catch:{ Exception -> 0x020f }
            com.tencent.qalsdk.core.l r4 = r7.t     // Catch:{ Exception -> 0x020f }
            boolean r4 = r4.a(r8)     // Catch:{ Exception -> 0x020f }
            if (r4 != 0) goto L_0x008d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
            java.lang.String r9 = "MsfStore init fail,so init:"
            r8.<init>(r9)     // Catch:{ Exception -> 0x020f }
            java.util.concurrent.atomic.AtomicBoolean r9 = f32185a     // Catch:{ Exception -> 0x020f }
            boolean r9 = r9.get()     // Catch:{ Exception -> 0x020f }
            r8.append(r9)     // Catch:{ Exception -> 0x020f }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x020f }
            com.tencent.qalsdk.util.QLog.e(r2, r1, r8)     // Catch:{ Exception -> 0x020f }
            return r3
        L_0x008d:
            com.tencent.qalsdk.config.NativeConfigStore r4 = com.tencent.qalsdk.core.l.a()     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            java.lang.String r5 = "_key_set_log_level"
            java.lang.String r4 = r4.getConfig(r5)     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            if (r4 == 0) goto L_0x00ce
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            if (r4 <= 0) goto L_0x00ce
            r5 = 5
            if (r4 > r5) goto L_0x00ce
            com.tencent.qalsdk.util.QLog.setOutputLogLevel(r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            java.lang.String r6 = "set saved log level:"
            r5.<init>(r6)     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            r5.append(r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            java.lang.String r4 = r5.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            com.tencent.qalsdk.util.QLog.i(r2, r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b7 }
            goto L_0x00ce
        L_0x00b7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
            java.lang.String r5 = "MsfCore setLogLevel UnsatisfiedLinkError. so init:"
            r4.<init>(r5)     // Catch:{ Exception -> 0x020f }
            java.util.concurrent.atomic.AtomicBoolean r5 = f32185a     // Catch:{ Exception -> 0x020f }
            boolean r5 = r5.get()     // Catch:{ Exception -> 0x020f }
            r4.append(r5)     // Catch:{ Exception -> 0x020f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x020f }
            com.tencent.qalsdk.util.QLog.e(r2, r4)     // Catch:{ Exception -> 0x020f }
        L_0x00ce:
            com.tencent.qalsdk.config.NativeConfigStore r4 = com.tencent.qalsdk.core.l.a()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r5 = "__key_sso_server_env"
            java.lang.String r4 = r4.getConfig(r5)     // Catch:{ Exception -> 0x0101 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0101 }
            r5.append(r4)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0101 }
            com.tencent.qalsdk.util.QLog.d(r2, r5)     // Catch:{ Exception -> 0x0101 }
            if (r4 == 0) goto L_0x0117
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0101 }
            r7.z = r4     // Catch:{ Exception -> 0x0101 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0101 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0101 }
            int r0 = r7.z     // Catch:{ Exception -> 0x0101 }
            r4.append(r0)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0101 }
            com.tencent.qalsdk.util.QLog.i(r2, r0)     // Catch:{ Exception -> 0x0101 }
            goto L_0x0117
        L_0x0101:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
            java.lang.String r5 = "setServerEnv exception"
            r4.<init>(r5)     // Catch:{ Exception -> 0x020f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x020f }
            r4.append(r0)     // Catch:{ Exception -> 0x020f }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x020f }
            com.tencent.qalsdk.util.QLog.e(r2, r0)     // Catch:{ Exception -> 0x020f }
        L_0x0117:
            com.tencent.qalsdk.core.a r0 = new com.tencent.qalsdk.core.a
            r0.<init>()
            r7.w = r0
            com.tencent.qalsdk.core.a r0 = r7.w
            r0.a()
            com.tencent.qalsdk.core.p r0 = new com.tencent.qalsdk.core.p
            r0.<init>(r7)
            r7.y = r0
            com.tencent.qalsdk.core.i r0 = new com.tencent.qalsdk.core.i     // Catch:{ Exception -> 0x0137 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0137 }
            r7.o = r0     // Catch:{ Exception -> 0x0137 }
            com.tencent.qalsdk.core.i r0 = r7.o     // Catch:{ Exception -> 0x0137 }
            r0.a()     // Catch:{ Exception -> 0x0137 }
            goto L_0x0149
        L_0x0137:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "msfAlarmer init failed "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r0)
        L_0x0149:
            qalsdk.a r0 = new qalsdk.a     // Catch:{ Exception -> 0x0156 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0156 }
            r7.f32189e = r0     // Catch:{ Exception -> 0x0156 }
            qalsdk.a r0 = r7.f32189e     // Catch:{ Exception -> 0x0156 }
            r0.n()     // Catch:{ Exception -> 0x0156 }
            goto L_0x0168
        L_0x0156:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "configManager init failed "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r0)
        L_0x0168:
            qalsdk.c r0 = new qalsdk.c     // Catch:{ Exception -> 0x0175 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0175 }
            r7.m = r0     // Catch:{ Exception -> 0x0175 }
            qalsdk.c r0 = r7.m     // Catch:{ Exception -> 0x0175 }
            r0.e()     // Catch:{ Exception -> 0x0175 }
            goto L_0x0187
        L_0x0175:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "SsoListManager init failed "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r0)
        L_0x0187:
            com.tencent.qalsdk.core.NetConnInfoCenter r0 = new com.tencent.qalsdk.core.NetConnInfoCenter     // Catch:{ Exception -> 0x01a4 }
            r0.<init>()     // Catch:{ Exception -> 0x01a4 }
            r7.j = r0     // Catch:{ Exception -> 0x01a4 }
            com.tencent.qalsdk.core.NetConnInfoCenter.init(r7)     // Catch:{ Exception -> 0x01a4 }
            com.tencent.qalsdk.core.NetConnInfoCenter.checkConnInfo(r8, r1)     // Catch:{ Exception -> 0x01a4 }
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ Exception -> 0x01a4 }
            r0.<init>()     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r0.addAction(r4)     // Catch:{ Exception -> 0x01a4 }
            com.tencent.qalsdk.core.NetConnInfoCenter r4 = r7.j     // Catch:{ Exception -> 0x01a4 }
            r8.registerReceiver(r4, r0)     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01b6
        L_0x01a4:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "MsfCore init netConnInfoCenter error "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r4, r0)
        L_0x01b6:
            qalsdk.am r0 = new qalsdk.am
            r0.<init>()
            r7.i = r0
            com.tencent.qalsdk.core.n r0 = new com.tencent.qalsdk.core.n     // Catch:{ Exception -> 0x01fc }
            r0.<init>(r7)     // Catch:{ Exception -> 0x01fc }
            r7.f32187c = r0     // Catch:{ Exception -> 0x01fc }
            com.tencent.qalsdk.core.n r0 = r7.f32187c     // Catch:{ Exception -> 0x01fc }
            r0.a((android.content.Context) r8)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r0 = "Sender init succ"
            com.tencent.qalsdk.util.QLog.d(r2, r1, r0)     // Catch:{ Exception -> 0x01fc }
            qalsdk.ad r0 = new qalsdk.ad     // Catch:{ Exception -> 0x01db }
            r0.<init>(r7)     // Catch:{ Exception -> 0x01db }
            r7.f32188d = r0     // Catch:{ Exception -> 0x01db }
            qalsdk.ad r0 = r7.f32188d     // Catch:{ Exception -> 0x01db }
            r0.a((android.content.Context) r8, (boolean) r9)     // Catch:{ Exception -> 0x01db }
            goto L_0x01f1
        L_0x01db:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "PushManager init failed "
            r9.<init>(r0)
            java.lang.StackTraceElement[] r8 = r8.getStackTrace()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r8)
        L_0x01f1:
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.v
            r8.set(r1)
            java.lang.String r8 = "MsfCore init finished."
            com.tencent.qalsdk.util.QLog.d(r2, r1, r8)
            return r1
        L_0x01fc:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Sender init failed "
            r9.<init>(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r8)
            return r3
        L_0x020f:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "MsfStore init error "
            r9.<init>(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r1, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.j.a(android.content.Context, boolean):boolean");
    }

    public static void a(int i2) {
        try {
            l.a().setConfig("_key_set_log_level", String.valueOf(i2));
        } catch (UnsatisfiedLinkError e2) {
            QLog.e("MSF.C.MsfCore", "save logLevel exception" + e2.getMessage());
        }
    }

    public final a c() {
        return this.w;
    }

    public static byte[] d() {
        return d.a();
    }

    public final void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg != null) {
            if (toServiceMsg.getAttributes().containsKey("to_login_changeuin")) {
                fromServiceMsg.addAttribute("to_login_changeuin", fromServiceMsg.getUin());
                toServiceMsg.setUin((String) toServiceMsg.getAttribute("to_login_changeuin"));
            }
            if (toServiceMsg.getAttributes().containsKey("to_srcCmd")) {
                String str = (String) toServiceMsg.getAttribute("to_srcCmd");
                toServiceMsg.setServiceCmd(str);
                fromServiceMsg.setServiceCmd(str);
            }
        }
        if (toServiceMsg == null && fromServiceMsg.isSuccess()) {
            fromServiceMsg.getUin().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (toServiceMsg != null) {
            toServiceMsg.getAttributes().remove("to_timeoutCallbacker");
        }
        fromServiceMsg.addAttribute("__timestamp_msf2app", Long.valueOf(System.currentTimeMillis()));
        QLog.d("MSF.C.MsfCore", 4, "service recv msg . ssoCmd:" + fromServiceMsg.getServiceCmd() + " ssoSeq:" + fromServiceMsg.getRequestSsoSeq());
        this.u.add(new r(toServiceMsg, fromServiceMsg));
    }

    public final void b(ToServiceMsg toServiceMsg) {
        this.f32188d.a(com.tencent.qalsdk.config.a.b(toServiceMsg), toServiceMsg);
        this.w.a(toServiceMsg.getUin());
    }

    public final int a(String str) {
        ad adVar = this.f32188d;
        for (String str2 : adVar.f34070b.keySet()) {
            z zVar = adVar.f34070b.get(str2);
            if (zVar != null && zVar.f34212g != null && zVar.f34212g.f34079a.equals(str)) {
                if (zVar.f34208c == 0) {
                    return -2;
                }
                return zVar.f34212g.f34081c;
            }
        }
        return -1;
    }

    public final LinkedBlockingQueue<r> e() {
        return this.u;
    }

    public final p f() {
        return this.y;
    }

    public final c g() {
        return this.m;
    }

    public final int h() {
        return this.x;
    }

    public final i i() {
        return this.o;
    }

    public final void j() {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(this.x, b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.setServerEnv");
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setMsfCommand(MsfCommand.qal_setServerEnv);
        fromServiceMsg.addAttribute("sso_server_env", Integer.valueOf(this.z));
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        QLog.i("MSF.C.MsfCore", "send to sdk server env:" + this.z);
        a((ToServiceMsg) null, fromServiceMsg);
    }

    public static void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            QLog.i("MSF.C.MsfCore", "save sso server env:" + i2);
            try {
                l.a().setConfig("__key_sso_server_env", String.valueOf(i2));
            } catch (UnsatisfiedLinkError e2) {
                QLog.e("MSF.C.MsfCore", "saveServerEnv exception:" + e2.getMessage());
            }
        } else {
            QLog.e("MSF.C.MsfCore", "save sso server env value error:" + i2);
        }
    }

    public final int k() {
        return this.z;
    }

    public final void a(ToServiceMsg toServiceMsg) {
        e eVar = new e((byte[]) toServiceMsg.getAttribute("to_set_accountInfo"));
        com.tencent.qalsdk.sdk.a aVar = new com.tencent.qalsdk.sdk.a();
        aVar.readFrom(eVar);
        this.w.a(aVar);
        this.f32190f = aVar.f32224b;
        this.f32188d.a(toServiceMsg, ag.appRegister);
    }
}
