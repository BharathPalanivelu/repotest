package com.tencent.qalsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.CodecWarpper;
import com.tencent.qalsdk.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import qalsdk.f;
import qalsdk.i;
import qalsdk.j;
import qalsdk.k;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f32209a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f32210b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public static String f32211c = ":";

    /* renamed from: d  reason: collision with root package name */
    public static String f32212d = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    /* renamed from: e  reason: collision with root package name */
    public static int f32213e;

    /* renamed from: f  reason: collision with root package name */
    public static long f32214f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static long f32215g = 0;
    public static AtomicBoolean h = new AtomicBoolean();
    static int i = -1;
    static AtomicBoolean j = new AtomicBoolean();
    private static final AtomicInteger q = new AtomicInteger();
    private static int r = -1;
    private static CopyOnWriteArraySet<String> s = new CopyOnWriteArraySet<>();
    private static String t = "";
    private static String[] u = {"StreamSvr.UploadStreamMsg"};
    /* access modifiers changed from: private */
    public static AtomicBoolean v = new AtomicBoolean();
    private Context A;
    private ConcurrentHashMap<Integer, ToServiceMsg> B = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, ArrayList<ToServiceMsg>> C = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<f, a> D = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, k> E = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public LinkedBlockingDeque<ToServiceMsg> F = new LinkedBlockingDeque<>(1000);
    /* access modifiers changed from: private */
    public AtomicInteger G = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public AtomicBoolean H = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public AtomicBoolean I = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public AtomicBoolean J = new AtomicBoolean(false);
    private int K = 0;
    private byte[] L = null;
    public k k;
    public int l = -1;
    public AtomicBoolean m = new AtomicBoolean();
    j n;
    AtomicBoolean o = new AtomicBoolean();
    long p = 0;
    private b w = new b();
    private int x = 0;
    private long y = 0;
    private ArrayList<HashMap> z = new ArrayList<>();

    public static void a(int i2) {
    }

    public static void e() {
    }

    public n(j jVar) {
        this.n = jVar;
        this.K = jVar.h();
        this.k = new k(jVar, false);
        this.w.setName("MsfCoreMsgSender");
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(bArr).flip();
        return allocate.array();
    }

    public static void a(String str, boolean z2) {
        s.remove(str);
        CodecWarpper.setUseSimpleHead(str, false);
    }

    public static void a() {
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            CodecWarpper.setUseSimpleHead(it.next(), false);
        }
        s.clear();
    }

    public static String b() {
        return t;
    }

    public static void a(String str) {
        t = str;
    }

    public final boolean a(Context context) {
        this.A = context;
        try {
            if (this.n.k() == 1) {
                QLog.i("MSF.C.NetConnTag", 4, "load test server env");
                b(context);
            }
        } catch (Exception e2) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "loadTestServerConfig error " + e2);
            }
        }
        this.H.set(false);
        this.I.set(false);
        this.J.set(false);
        this.w.start();
        try {
            String config = l.a().getConfig("LOGLEVEL_");
            if (config != null && config.length() > 0) {
                String config2 = l.a().getConfig("LOGLEVELTIME");
                if (config2 == null || config2.length() <= 0) {
                    l.a().setConfig("LOGLEVELTIME", String.valueOf(System.currentTimeMillis()));
                } else {
                    if (System.currentTimeMillis() - Long.parseLong(config2) > 259200000) {
                        o oVar = new o(this);
                        oVar.setName("resetLogLevelThread");
                        oVar.start();
                    }
                }
            }
        } catch (Exception e3) {
            QLog.e("MSF.C.NetConnTag", 1, "set logLevel error " + e3);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3 A[SYNTHETIC, Splitter:B:35:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0104 A[SYNTHETIC, Splitter:B:49:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = com.tencent.qalsdk.base.a.f32151e
            java.lang.String r1 = ""
            java.lang.String r2 = "MSF.C.NetConnTag"
            if (r0 == 0) goto L_0x004f
            boolean r3 = r0.equals(r1)
            if (r3 != 0) goto L_0x004f
            com.tencent.qalsdk.core.c r7 = com.tencent.qalsdk.core.c.a((java.lang.String) r0)
            java.lang.String r1 = r7.c()
            r3 = 4
            if (r1 == 0) goto L_0x003d
            int r1 = r7.d()
            if (r1 > 0) goto L_0x0020
            goto L_0x003d
        L_0x0020:
            qalsdk.k r7 = r6.k
            r7.a((java.lang.String) r0)
            boolean r7 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r7 == 0) goto L_0x003c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "set BaseConstantsTestServer Address "
            r7.<init>(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.tencent.qalsdk.util.QLog.i(r2, r3, r7)
        L_0x003c:
            return
        L_0x003d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "illeagal host and port: "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.tencent.qalsdk.util.QLog.e(r2, r3, r7)
            return
        L_0x004f:
            java.lang.String r7 = r7.getPackageName()
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r4.getPath()
            r3.append(r4)
            java.lang.String r4 = "/tencent/"
            r3.append(r4)
            java.lang.String r4 = "."
            java.lang.String r5 = "/"
            java.lang.String r7 = r7.replace(r4, r5)
            r3.append(r7)
            java.lang.String r7 = "/testserver"
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r0.<init>(r7)
            java.util.Properties r7 = new java.util.Properties
            r7.<init>()
            r3 = 0
            boolean r4 = r0.exists()     // Catch:{ Exception -> 0x00ad }
            if (r4 == 0) goto L_0x00a0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00ad }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00ad }
            r7.load(r4)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            r4.close()     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            r3 = r4
            goto L_0x00a0
        L_0x009a:
            r7 = move-exception
            r3 = r4
            goto L_0x0102
        L_0x009d:
            r0 = move-exception
            r3 = r4
            goto L_0x00ae
        L_0x00a0:
            if (r3 == 0) goto L_0x00b6
            r3.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00b6
        L_0x00a6:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00b6
        L_0x00ab:
            r7 = move-exception
            goto L_0x0102
        L_0x00ad:
            r0 = move-exception
        L_0x00ae:
            r0.printStackTrace()     // Catch:{ all -> 0x00ab }
            if (r3 == 0) goto L_0x00b6
            r3.close()     // Catch:{ IOException -> 0x00a6 }
        L_0x00b6:
            java.lang.String r0 = "server"
            java.lang.String r7 = r7.getProperty(r0)
            if (r7 == 0) goto L_0x0101
            java.lang.String r0 = r7.trim()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0101
            com.tencent.qalsdk.core.c r0 = com.tencent.qalsdk.core.c.a((java.lang.String) r7)
            java.lang.String r3 = r0.c()
            if (r3 == 0) goto L_0x0101
            int r0 = r0.d()
            if (r0 > 0) goto L_0x00d9
            goto L_0x0101
        L_0x00d9:
            java.lang.String r7 = r7.trim()
            java.lang.String r0 = " "
            java.lang.String r7 = r7.replace(r0, r1)
            qalsdk.k r0 = r6.k
            r0.a((java.lang.String) r7)
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x0101
            r0 = 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "set TestServer Address "
            r1.<init>(r3)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.tencent.qalsdk.util.QLog.d(r2, r0, r7)
        L_0x0101:
            return
        L_0x0102:
            if (r3 == 0) goto L_0x010c
            r3.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x010c
        L_0x0108:
            r0 = move-exception
            r0.printStackTrace()
        L_0x010c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.n.b(android.content.Context):void");
    }

    public final boolean c() {
        return this.B.isEmpty();
    }

    private int b(ToServiceMsg toServiceMsg) {
        if (toServiceMsg.getRequestSsoSeq() == -1) {
            toServiceMsg.setRequestSsoSeq(j.b());
        }
        toServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if (toServiceMsg.isNeedCallback()) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "add " + toServiceMsg + " to send");
            }
            this.B.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), toServiceMsg);
            toServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(q.incrementAndGet()));
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(10000);
            }
            toServiceMsg.addAttribute("to_timeoutCallbacker", this.n.o.a(toServiceMsg, toServiceMsg.getTimeout()));
        }
        try {
            this.F.addFirst(toServiceMsg);
        } catch (Exception e2) {
            QLog.d("MSF.C.NetConnTag", 1, "inset heartbeatMsg error. " + e2, e2);
        }
        return toServiceMsg.getRequestSsoSeq();
    }

    public final byte[] d() {
        return this.L;
    }

    public final void b(byte[] bArr) {
        this.L = bArr;
    }

    public final boolean a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z2;
        if (toServiceMsg.getMsfCommand().equals(MsfCommand.qal_Hello)) {
            this.I.set(true);
            this.H.set(false);
        } else {
            this.J.set(true);
        }
        if (this.I.get() && this.J.get()) {
            QLog.e("MSF.C.NetConnTag", 1, "Both ping pkg and non ping pkg timeout, close conn");
            this.n.f32187c.k.a(CloseConnReason.continueWaitRspTimeout);
        }
        if (toServiceMsg.getMsfCommand().equals(MsfCommand.qal_Hello)) {
            return false;
        }
        if (((Boolean) toServiceMsg.getAttribute("shortConnection", false)).booleanValue()) {
            k kVar = this.E.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            if (kVar == null) {
                return true;
            }
            f c2 = kVar.h().c();
            if (c2 != null) {
                this.D.remove(c2);
            }
            kVar.a(CloseConnReason.closeByOnetimeSocket);
            this.E.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            QLog.i("MSF.C.NetConnTag", 1, "remove codecWrappers & socket in hashmap");
            return true;
        }
        if (m.e()) {
            this.k.f34159c.b();
        }
        if (toServiceMsg != null && toServiceMsg.isNeedRemindSlowNetwork()) {
            i.a(i.b.f34147a);
        }
        toServiceMsg.addAttribute("_tag_socket_connerror", k.f34157a);
        fromServiceMsg.addAttribute("_tag_socket_connerror", k.f34157a);
        if (toServiceMsg.getAttributes().containsKey("_tag_socket")) {
            fromServiceMsg.addAttribute("_tag_socket", toServiceMsg.getAttribute("_tag_socket"));
        }
        long longValue = toServiceMsg.getAttributes().containsKey("__timestamp_msf2net") ? ((Long) toServiceMsg.getAttribute("__timestamp_msf2net")).longValue() : 0;
        long currentTimeMillis = System.currentTimeMillis();
        long longValue2 = toServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue") ? ((Long) toServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue() : 0;
        if (longValue2 != 0) {
            long j2 = currentTimeMillis - longValue2;
            if (j2 > toServiceMsg.getTimeout() && j2 > this.n.f32188d.e()) {
                if (longValue2 >= this.k.h().b()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + toServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + j2 + ",try close conn");
                    }
                    this.n.f32187c.k.a(CloseConnReason.closeByNetDetectTooLongForPhoneSleep);
                    this.x = 0;
                    this.o.set(false);
                }
                return true;
            }
        }
        if (longValue != 0 && longValue <= this.k.h().b()) {
            QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + toServiceMsg + " before connSucc.");
        } else if (toServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
            QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + toServiceMsg.getRequestSsoSeq());
            a(fromServiceMsg, toServiceMsg);
            return false;
        } else {
            synchronized (this) {
                if (toServiceMsg.getRequestSsoSeq() == r) {
                    r = -1;
                    QLog.i("MSF.C.NetConnTag", 1, "[Sender] found conn  first msg timeout ,wifi may fake" + toServiceMsg);
                    this.n.f32187c.k.f34158b.c();
                    this.n.f32187c.k.g();
                }
                if (toServiceMsg.getRequestSsoSeq() == i) {
                    i = -1;
                    QLog.d("MSF.C.NetConnTag", 1, "[Sender]found first msg screen on timeout try close conn " + toServiceMsg);
                    this.n.f32187c.k.a(CloseConnReason.closeForScrrenOnFirstMsgTimeout);
                    this.x = 0;
                    this.o.set(false);
                    return true;
                }
                j();
            }
        }
        if (toServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
            return false;
        }
        try {
            if (this.k.a()) {
                String[] strArr = u;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = true;
                        break;
                    }
                    String str = strArr[i2];
                    if (!TextUtils.isEmpty(str) && toServiceMsg != null && str.equals(toServiceMsg.getServiceCmd())) {
                        z2 = false;
                        break;
                    }
                    i2++;
                }
                if (z2 && f32210b.incrementAndGet() >= qalsdk.a.e()) {
                    QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
                    f32210b.set(0);
                    this.n.f32187c.k.a(CloseConnReason.continueWaitRspTimeout);
                    this.x = 0;
                    this.o.set(false);
                }
            }
        } catch (Exception e2) {
            QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + e2);
        }
        return true;
    }

    private void j() {
        if (this.k.a()) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "Heartbeat.Alive");
            toServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
            toServiceMsg.setRequestSsoSeq(j.b());
            toServiceMsg.setAppId(this.n.h());
            toServiceMsg.putWupBuffer(new byte[]{0, 0, 0, 4});
            toServiceMsg.setTimeout(qalsdk.a.c());
            b(toServiceMsg);
            this.x++;
            QLog.i("MSF.C.NetConnTag", 4, "send Heartbeat msg ok " + toServiceMsg.getRequestSsoSeq());
            this.y = System.currentTimeMillis();
            this.o.set(true);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
        }
        this.x = 0;
        this.o.set(false);
    }

    public final void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        if (fromServiceMsg.getBusinessFailCode() == 1002) {
            QLog.i("MSF.C.NetConnTag", 4, "handleHeartbeat wait " + toServiceMsg + " timeout.");
            if (!this.k.a()) {
                QLog.i("MSF.C.NetConnTag", 2, "conn is also closed.");
                this.x = 0;
                this.o.set(false);
            } else if (this.x >= qalsdk.a.d()) {
                try {
                    QLog.i("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.x + ",try close conn");
                    this.n.f32187c.k.a(CloseConnReason.closeByNetDetectFailed);
                    this.x = 0;
                    this.o.set(false);
                } catch (Exception e2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag", 2, e2.toString(), e2);
                    }
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                qalsdk.a.d();
                if (currentTimeMillis - this.y > qalsdk.a.c() * 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (currentTimeMillis - this.y) + ",try close conn");
                    }
                    this.n.f32187c.k.a(CloseConnReason.continueWaitRspTimeout);
                    this.x = 0;
                    this.o.set(false);
                    return;
                }
                j();
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
            }
            this.x = 0;
            this.o.set(false);
        }
    }

    public final int a(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return -1;
        }
        if (this.n.p.get()) {
            FromServiceMsg a2 = k.a(toServiceMsg);
            a2.setBusinessFail(2009, "MSF is suspeded.");
            this.n.a(toServiceMsg, a2);
            return toServiceMsg.getRequestSsoSeq();
        } else if (toServiceMsg.getAppId() <= 0 && toServiceMsg.getMsfCommand() != MsfCommand.openConn) {
            FromServiceMsg a3 = k.a(toServiceMsg);
            a3.setBusinessFail(1007, "msg appid is " + toServiceMsg.getAppId());
            this.n.a(toServiceMsg, a3);
            return toServiceMsg.getRequestSsoSeq();
        } else if (v.get()) {
            FromServiceMsg a4 = k.a(toServiceMsg);
            a4.setBusinessFail(2014, "error");
            this.n.a(toServiceMsg, a4);
            return toServiceMsg.getRequestSsoSeq();
        } else {
            if (this.K != toServiceMsg.getAppId()) {
                this.K = toServiceMsg.getAppId();
            }
            if (toServiceMsg.getRequestSsoSeq() == -1) {
                toServiceMsg.setRequestSsoSeq(j.b());
            }
            if (!toServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
                toServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
            }
            toServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
            if (!((Boolean) toServiceMsg.getAttribute("shortConnection", false)).booleanValue() && this.F.remainingCapacity() > 0 && !this.H.get()) {
                if (this.k.a()) {
                    ToServiceMsg toServiceMsg2 = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "MSF");
                    toServiceMsg2.setAppId(j.a().h());
                    toServiceMsg2.setTimeout(10000);
                    toServiceMsg2.setMsfCommand(MsfCommand.qal_Hello);
                    toServiceMsg2.setRequestSsoSeq(j.b());
                    toServiceMsg2.setNeedCallback(true);
                    toServiceMsg2.putWupBuffer(new byte[]{0, 0, 0, 21, 1, 51, 82, 57, 0, 0, 0, 0, 4, 77, 83, 70, 5, 0, 0, 0, 0});
                    QLog.d("MSF.C.NetConnTag", 1, "ping pkg sent, buffer size: " + toServiceMsg2.getWupBuffer().length);
                    b(toServiceMsg2);
                    this.H.set(true);
                    this.G.set(toServiceMsg2.getRequestSsoSeq());
                } else if (QLog.isDevelopLevel()) {
                    QLog.i("MSF.C.NetConnTag", 1, "conn is closed. no need to send ping msg");
                }
            }
            return c(toServiceMsg);
        }
    }

    private int c(ToServiceMsg toServiceMsg) {
        if (toServiceMsg.isNeedCallback()) {
            this.B.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), toServiceMsg);
            toServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(q.incrementAndGet()));
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(10000);
            }
            toServiceMsg.addAttribute("to_timeoutCallbacker", this.n.o.a(toServiceMsg, toServiceMsg.getTimeout()));
        }
        boolean z2 = false;
        try {
            if (toServiceMsg.getMsfCommand() == MsfCommand._msf_RegPush) {
                this.F.addFirst(toServiceMsg);
                z2 = true;
            } else {
                z2 = this.F.offer(toServiceMsg);
            }
        } catch (IllegalStateException unused) {
        }
        if (!z2) {
            QLog.d("MSF.C.NetConnTag", 1, "error, add " + toServiceMsg + " to send queue is full! size: " + this.F.size());
            FromServiceMsg a2 = k.a(toServiceMsg);
            a2.setBusinessFail(1008, "send queue is full!");
            this.n.a(toServiceMsg, a2);
        } else {
            if (this.C.contains(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
                this.C.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.NetConnTag", 4, "add " + toServiceMsg + " to sendQueue");
            }
        }
        if (!j.get() && e.f32178b) {
            j.set(true);
            i = toServiceMsg.getRequestSsoSeq();
        }
        if (!h.get()) {
            h.set(true);
            r = toServiceMsg.getRequestSsoSeq();
        }
        return toServiceMsg.getRequestSsoSeq();
    }

    public final ToServiceMsg b(int i2) {
        ToServiceMsg toServiceMsg = this.B.get(Integer.valueOf(i2));
        if (toServiceMsg != null) {
            Runnable runnable = (Runnable) toServiceMsg.getAttributes().remove("to_timeoutCallbacker");
            if (!toServiceMsg.isHttpReq()) {
                this.B.remove(Integer.valueOf(i2));
                if (this.n.o.b() != null) {
                    this.n.o.b().removeCallbacks(runnable);
                }
            }
        }
        return toServiceMsg;
    }

    public final ConcurrentHashMap<Integer, ToServiceMsg> f() {
        return this.B;
    }

    public final void a(f fVar, byte[] bArr) {
        a aVar;
        if (this.D.containsKey(fVar)) {
            aVar = this.D.get(fVar);
        } else {
            a aVar2 = new a();
            aVar2.init(this.A, false);
            this.D.put(fVar, aVar2);
            aVar = aVar2;
        }
        aVar.onReceData(bArr);
    }

    public final int g() {
        return this.K;
    }

    public final void a(HashMap<String, ArrayList<byte[]>> hashMap) {
        this.z.add(hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.z.size());
        }
    }

    public final void h() {
        Iterator<Map.Entry<Integer, ToServiceMsg>> it = this.B.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (next != null) {
                ToServiceMsg toServiceMsg = (ToServiceMsg) next.getValue();
                if (toServiceMsg != null && !this.F.contains(toServiceMsg)) {
                    boolean z2 = true;
                    if (!toServiceMsg.isFastResendEnabled()) {
                        String[] strArr = com.tencent.qalsdk.base.a.f32150d;
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z2 = false;
                                break;
                            }
                            if (toServiceMsg.getServiceCmd().equals(strArr[i2])) {
                                break;
                            }
                            i2++;
                        }
                    }
                    if (z2) {
                        FromServiceMsg constructResponse = MsfSdkUtils.constructResponse(toServiceMsg, 2901, "", (Object) null);
                        constructResponse.setBusinessFail(2901);
                        this.n.a(toServiceMsg, constructResponse);
                        it.remove();
                    }
                }
            }
        }
    }

    class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private long f32217a = 0;

        b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: int} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v39, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x02f9 A[Catch:{ Exception -> 0x033e, Throwable -> 0x03af }] */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x030f A[Catch:{ Exception -> 0x033e, Throwable -> 0x03af }] */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x035f A[Catch:{ Exception -> 0x033e, Throwable -> 0x03af }] */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x03bd A[Catch:{ Throwable -> 0x0475, Throwable -> 0x0480 }] */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x03e2 A[SYNTHETIC, Splitter:B:136:0x03e2] */
        /* JADX WARNING: Removed duplicated region for block: B:157:0x045b A[Catch:{ Throwable -> 0x0475, Throwable -> 0x0480 }] */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x0472 A[Catch:{ Throwable -> 0x0475, Throwable -> 0x0480 }] */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x048a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r32 = this;
                r1 = r32
                java.lang.String r2 = "_tag_localsocket"
                java.lang.String r3 = "_tag_socket"
                java.lang.String r4 = "__timestamp_msf2net_boot"
                java.lang.String r5 = "__timestamp_msf2net"
                java.lang.String r6 = "_attr_kickTitle"
                java.lang.String r7 = "_attr_kickInfo"
                java.lang.String r8 = "_attr_sameDevice"
                java.lang.String r9 = "MSF.C.NetConnTag"
                android.os.Looper.prepare()
            L_0x0015:
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x0482 }
                java.util.concurrent.LinkedBlockingDeque r0 = r0.F     // Catch:{ Throwable -> 0x0482 }
                java.lang.Object r0 = r0.take()     // Catch:{ Throwable -> 0x0482 }
                r11 = r0
                com.tencent.qalsdk.base.remote.ToServiceMsg r11 = (com.tencent.qalsdk.base.remote.ToServiceMsg) r11     // Catch:{ Throwable -> 0x0482 }
                if (r11 == 0) goto L_0x0479
                r13 = 0
                java.lang.String r0 = r11.getServiceCmd()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r14 = "#"
                int r14 = r0.indexOf(r14)     // Catch:{ Throwable -> 0x03b4 }
                r15 = -1
                if (r14 == r15) goto L_0x0053
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03b4 }
                r12.<init>()     // Catch:{ Throwable -> 0x03b4 }
                int r15 = r14 + 1
                int r10 = r0.length()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r10 = r0.substring(r15, r10)     // Catch:{ Throwable -> 0x03b4 }
                r12.append(r10)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r10 = "_new"
                r12.append(r10)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r12 = r12.toString()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r0 = r0.substring(r13, r14)     // Catch:{ Throwable -> 0x03b4 }
                r10 = r0
                goto L_0x0055
            L_0x0053:
                r10 = r0
                r12 = 0
            L_0x0055:
                java.lang.String r0 = "__timestamp_addSendQueue"
                r14 = 0
                java.lang.Long r13 = java.lang.Long.valueOf(r14)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.Object r0 = r11.getAttribute(r0, r13)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Throwable -> 0x03b4 }
                long r30 = r0.longValue()     // Catch:{ Throwable -> 0x03b4 }
                long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.a r0 = r0.f32189e     // Catch:{ Throwable -> 0x03b4 }
                r0.a(r11, r14)     // Catch:{ Throwable -> 0x03b4 }
                byte[] r0 = r11.getWupBuffer()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x0128
                boolean r0 = com.tencent.qalsdk.core.m.d()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x0083
                r27 = 1
                goto L_0x00ea
            L_0x0083:
                boolean r0 = com.tencent.qalsdk.core.m.e()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x00b1
                int r0 = com.tencent.qalsdk.core.m.g()     // Catch:{ Throwable -> 0x03b4 }
                int r0 = r0 + 100
                r14 = 254(0xfe, float:3.56E-43)
                if (r0 <= r14) goto L_0x00ad
                boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x00ab
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r15 = "error,netWorkType is "
                r0.<init>(r15)     // Catch:{ Throwable -> 0x03b4 }
                r0.append(r14)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x03b4 }
                r15 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r15, r0)     // Catch:{ Throwable -> 0x03b4 }
            L_0x00ab:
                r0 = 254(0xfe, float:3.56E-43)
            L_0x00ad:
                byte r0 = (byte) r0     // Catch:{ Throwable -> 0x03b4 }
                r27 = r0
                goto L_0x00ea
            L_0x00b1:
                r16 = r14
                long r13 = r1.f32217a     // Catch:{ Throwable -> 0x03b4 }
                r18 = 0
                int r0 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
                if (r0 == 0) goto L_0x00c6
                long r13 = r1.f32217a     // Catch:{ Throwable -> 0x03b4 }
                long r13 = r16 - r13
                r18 = 60000(0xea60, double:2.9644E-319)
                int r0 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
                if (r0 <= 0) goto L_0x00e8
            L_0x00c6:
                r13 = r16
                r1.f32217a = r13     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.j r0 = com.tencent.qalsdk.core.j.a()     // Catch:{ Exception -> 0x00d5 }
                android.content.Context r0 = r0.k     // Catch:{ Exception -> 0x00d5 }
                r13 = 1
                com.tencent.qalsdk.core.NetConnInfoCenter.checkConnInfo(r0, r13)     // Catch:{ Exception -> 0x00d5 }
                goto L_0x00e8
            L_0x00d5:
                r0 = move-exception
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r14 = "checkConnInfo "
                r13.<init>(r14)     // Catch:{ Throwable -> 0x03b4 }
                r13.append(r0)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r0 = r13.toString()     // Catch:{ Throwable -> 0x03b4 }
                r13 = 1
                com.tencent.qalsdk.util.QLog.d(r9, r13, r0)     // Catch:{ Throwable -> 0x03b4 }
            L_0x00e8:
                r27 = 0
            L_0x00ea:
                java.lang.String r20 = ""
                com.tencent.qalsdk.sdk.MsfCommand r0 = r11.getMsfCommand()     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.sdk.MsfCommand r13 = com.tencent.qalsdk.sdk.MsfCommand.qal_Hello     // Catch:{ Throwable -> 0x03b4 }
                if (r0 != r13) goto L_0x00f9
                byte[] r0 = r11.getWupBuffer()     // Catch:{ Throwable -> 0x03b4 }
                goto L_0x012b
            L_0x00f9:
                int r16 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r17 = com.tencent.qalsdk.core.k.a()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r18 = com.tencent.qalsdk.core.k.c()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r19 = com.tencent.qalsdk.core.k.d()     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                byte[] r22 = r0.d()     // Catch:{ Throwable -> 0x03b4 }
                int r23 = r11.getAppId()     // Catch:{ Throwable -> 0x03b4 }
                int r24 = com.tencent.qalsdk.core.n.f32209a     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r25 = r11.getUin()     // Catch:{ Throwable -> 0x03b4 }
                byte r26 = r11.getUinType()     // Catch:{ Throwable -> 0x03b4 }
                byte[] r28 = r11.getWupBuffer()     // Catch:{ Throwable -> 0x03b4 }
                r21 = r10
                byte[] r0 = com.tencent.qalsdk.util.CodecWarpper.encodeRequest(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch:{ Throwable -> 0x03b4 }
                goto L_0x012b
            L_0x0128:
                r13 = 0
                byte[] r0 = new byte[r13]     // Catch:{ Throwable -> 0x03b4 }
            L_0x012b:
                r13 = r0
                if (r13 != 0) goto L_0x0139
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                int r10 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x03b4 }
                r0.b((int) r10)     // Catch:{ Throwable -> 0x03b4 }
                goto L_0x0015
            L_0x0139:
                r14 = 0
            L_0x013a:
                if (r14 != 0) goto L_0x03b1
                long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x03b4 }
                long r18 = r16 - r30
                long r20 = r11.getTimeout()     // Catch:{ Throwable -> 0x03b4 }
                int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
                if (r0 <= 0) goto L_0x0164
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03b4 }
                r0.<init>()     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r10 = r11.getServiceCmd()     // Catch:{ Throwable -> 0x03b4 }
                r0.append(r10)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r10 = " [is already sendTimeout,break.]"
                r0.append(r10)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.util.QLog.i(r9, r0)     // Catch:{ Throwable -> 0x03b4 }
                goto L_0x03b1
            L_0x0164:
                long r18 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                r20 = 0
                int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
                if (r0 == 0) goto L_0x01d6
                long r18 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                long r18 = r16 - r18
                int r0 = qalsdk.a.j()     // Catch:{ Throwable -> 0x03b4 }
                r25 = r14
                long r14 = (long) r0     // Catch:{ Throwable -> 0x03b4 }
                int r0 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
                if (r0 <= 0) goto L_0x01d8
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x03b4 }
                boolean r0 = r0.a()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x01d8
                long r14 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.j r0 = r0.h()     // Catch:{ Throwable -> 0x03b4 }
                long r18 = r0.b()     // Catch:{ Throwable -> 0x03b4 }
                int r0 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                if (r0 < 0) goto L_0x01d1
                r14 = 0
                com.tencent.qalsdk.core.n.f32215g = r14     // Catch:{ Throwable -> 0x03b4 }
                boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x01c7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r14 = "lastMessageTimeTooLong Close socket now. System.currentTimeMillis() - lastRecvSsoRespTime :"
                r0.<init>(r14)     // Catch:{ Throwable -> 0x03b4 }
                long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x03b4 }
                long r18 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                long r14 = r14 - r18
                r0.append(r14)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r14 = " getNetIdleTimeInterval()"
                r0.append(r14)     // Catch:{ Throwable -> 0x03b4 }
                int r14 = qalsdk.a.j()     // Catch:{ Throwable -> 0x03b4 }
                r0.append(r14)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x03b4 }
                r14 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r14, r0)     // Catch:{ Throwable -> 0x03b4 }
            L_0x01c7:
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.base.CloseConnReason r14 = com.tencent.qalsdk.base.CloseConnReason.lastMessageTimeTooLong     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x03b4 }
                r0.a((com.tencent.qalsdk.base.CloseConnReason) r14)     // Catch:{ Throwable -> 0x03b4 }
                goto L_0x01d8
            L_0x01d1:
                r14 = 0
                com.tencent.qalsdk.core.n.f32215g = r14     // Catch:{ Throwable -> 0x03b4 }
                goto L_0x01d8
            L_0x01d6:
                r25 = r14
            L_0x01d8:
                long r14 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                r18 = 0
                int r0 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                if (r0 == 0) goto L_0x0222
                long r14 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                long r16 = r16 - r14
                r14 = 360000(0x57e40, double:1.778636E-318)
                int r0 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
                if (r0 <= 0) goto L_0x0222
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x03b4 }
                boolean r0 = r0.a()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x0222
                long r14 = com.tencent.qalsdk.core.n.f32215g     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x03b4 }
                qalsdk.j r0 = r0.h()     // Catch:{ Throwable -> 0x03b4 }
                long r16 = r0.b()     // Catch:{ Throwable -> 0x03b4 }
                int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r0 < 0) goto L_0x0222
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.o     // Catch:{ Throwable -> 0x03b4 }
                boolean r0 = r0.get()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 != 0) goto L_0x0222
                boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x03b4 }
                if (r0 == 0) goto L_0x021d
                java.lang.String r0 = "no receive data for 5 minutes, start fast net detect now."
                r14 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r14, r0)     // Catch:{ Throwable -> 0x03b4 }
            L_0x021d:
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03b4 }
                com.tencent.qalsdk.core.n.b((com.tencent.qalsdk.core.n) r0)     // Catch:{ Throwable -> 0x03b4 }
            L_0x0222:
                java.lang.String r0 = "shortConnection"
                r14 = 0
                java.lang.Boolean r15 = java.lang.Boolean.valueOf(r14)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.Object r0 = r11.getAttribute(r0, r15)     // Catch:{ Throwable -> 0x03b4 }
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Throwable -> 0x03b4 }
                boolean r15 = r0.booleanValue()     // Catch:{ Throwable -> 0x03b4 }
                long r16 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x02ee }
                java.lang.Long r0 = java.lang.Long.valueOf(r16)     // Catch:{ Throwable -> 0x02ee }
                r11.addAttribute(r4, r0)     // Catch:{ Throwable -> 0x02ee }
                r26 = 0
                java.lang.Long r0 = java.lang.Long.valueOf(r26)     // Catch:{ Throwable -> 0x02ea }
                r11.addAttribute(r5, r0)     // Catch:{ Throwable -> 0x02ea }
                java.lang.String r0 = com.tencent.qalsdk.core.n.f32211c     // Catch:{ Throwable -> 0x02ea }
                r11.addAttribute(r3, r0)     // Catch:{ Throwable -> 0x02ea }
                java.lang.String r0 = com.tencent.qalsdk.core.n.f32212d     // Catch:{ Throwable -> 0x02ea }
                r11.addAttribute(r2, r0)     // Catch:{ Throwable -> 0x02ea }
                if (r15 != 0) goto L_0x027c
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x02ea }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x02ea }
                int r17 = r11.getAppId()     // Catch:{ Throwable -> 0x02ea }
                int r18 = r11.getAppSeq()     // Catch:{ Throwable -> 0x02ea }
                com.tencent.qalsdk.sdk.MsfCommand r21 = r11.getMsfCommand()     // Catch:{ Throwable -> 0x02ea }
                java.lang.String r22 = r11.getUin()     // Catch:{ Throwable -> 0x02ea }
                int r23 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x02ea }
                r16 = r0
                r19 = r10
                r20 = r12
                r24 = r13
                boolean r0 = r16.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Throwable -> 0x02ea }
                r14 = r0
                r28 = r6
                goto L_0x030d
            L_0x027c:
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x02ea }
                java.util.concurrent.ConcurrentHashMap r0 = r0.E     // Catch:{ Throwable -> 0x02ea }
                int r16 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x02ea }
                java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ Throwable -> 0x02ea }
                boolean r0 = r0.containsKey(r14)     // Catch:{ Throwable -> 0x02ea }
                if (r0 == 0) goto L_0x02a9
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x02ea }
                java.util.concurrent.ConcurrentHashMap r0 = r0.E     // Catch:{ Throwable -> 0x02ea }
                int r14 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x02ea }
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Throwable -> 0x02ea }
                java.lang.Object r0 = r0.get(r14)     // Catch:{ Throwable -> 0x02ea }
                qalsdk.k r0 = (qalsdk.k) r0     // Catch:{ Throwable -> 0x02ea }
                r16 = r0
                r28 = r6
                goto L_0x02c8
            L_0x02a9:
                qalsdk.k r0 = new qalsdk.k     // Catch:{ Throwable -> 0x02ea }
                com.tencent.qalsdk.core.n r14 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x02ea }
                com.tencent.qalsdk.core.j r14 = r14.n     // Catch:{ Throwable -> 0x02ea }
                r28 = r6
                r6 = 1
                r0.<init>(r14, r6)     // Catch:{ Throwable -> 0x02e8 }
                com.tencent.qalsdk.core.n r6 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x02e8 }
                java.util.concurrent.ConcurrentHashMap r6 = r6.E     // Catch:{ Throwable -> 0x02e8 }
                int r14 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x02e8 }
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Throwable -> 0x02e8 }
                r6.put(r14, r0)     // Catch:{ Throwable -> 0x02e8 }
                r16 = r0
            L_0x02c8:
                int r17 = r11.getAppId()     // Catch:{ Throwable -> 0x02e8 }
                int r18 = r11.getAppSeq()     // Catch:{ Throwable -> 0x02e8 }
                com.tencent.qalsdk.sdk.MsfCommand r21 = r11.getMsfCommand()     // Catch:{ Throwable -> 0x02e8 }
                java.lang.String r22 = r11.getUin()     // Catch:{ Throwable -> 0x02e8 }
                int r23 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x02e8 }
                r19 = r10
                r20 = r12
                r24 = r13
                boolean r0 = r16.a(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ Throwable -> 0x02e8 }
                r14 = r0
                goto L_0x030d
            L_0x02e8:
                r0 = move-exception
                goto L_0x02f3
            L_0x02ea:
                r0 = move-exception
                r28 = r6
                goto L_0x02f3
            L_0x02ee:
                r0 = move-exception
                r28 = r6
                r26 = 0
            L_0x02f3:
                boolean r6 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x03af }
                if (r6 == 0) goto L_0x030b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03af }
                java.lang.String r14 = "send msg error "
                r6.<init>(r14)     // Catch:{ Throwable -> 0x03af }
                r6.append(r0)     // Catch:{ Throwable -> 0x03af }
                java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x03af }
                r14 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r14, r6, r0)     // Catch:{ Throwable -> 0x03af }
            L_0x030b:
                r14 = r25
            L_0x030d:
                if (r14 != 0) goto L_0x035f
                if (r15 != 0) goto L_0x034e
                java.util.HashMap r0 = r11.getAttributes()     // Catch:{ Throwable -> 0x03af }
                r0.remove(r4)     // Catch:{ Throwable -> 0x03af }
                java.util.HashMap r0 = r11.getAttributes()     // Catch:{ Throwable -> 0x03af }
                r0.remove(r5)     // Catch:{ Throwable -> 0x03af }
                java.util.HashMap r0 = r11.getAttributes()     // Catch:{ Throwable -> 0x03af }
                r0.remove(r3)     // Catch:{ Throwable -> 0x03af }
                java.util.HashMap r0 = r11.getAttributes()     // Catch:{ Throwable -> 0x03af }
                r0.remove(r2)     // Catch:{ Throwable -> 0x03af }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03af }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x03af }
                com.tencent.qalsdk.base.CloseConnReason r6 = com.tencent.qalsdk.base.CloseConnReason.writeError     // Catch:{ Throwable -> 0x03af }
                r0.a((com.tencent.qalsdk.base.CloseConnReason) r6)     // Catch:{ Throwable -> 0x03af }
                long r16 = com.tencent.qalsdk.base.a.f32148b     // Catch:{ Exception -> 0x033e }
                java.lang.Thread.sleep(r16)     // Catch:{ Exception -> 0x033e }
            L_0x033b:
                r6 = -1
            L_0x033c:
                r15 = 1
                goto L_0x03ab
            L_0x033e:
                r0 = move-exception
                boolean r6 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x03af }
                if (r6 == 0) goto L_0x033b
                java.lang.String r6 = r0.toString()     // Catch:{ Throwable -> 0x03af }
                r15 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r15, r6, r0)     // Catch:{ Throwable -> 0x03af }
                goto L_0x033b
            L_0x034e:
                java.lang.String r0 = "send failed for onetimeSocket."
                r6 = 1
                com.tencent.qalsdk.util.QLog.e(r9, r6, r0)     // Catch:{ Throwable -> 0x03af }
                java.lang.String r0 = "noAvailableShortConnIP"
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ Throwable -> 0x03af }
                r11.addAttribute(r0, r6)     // Catch:{ Throwable -> 0x03af }
                goto L_0x03da
            L_0x035f:
                long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x03af }
                java.lang.Long r0 = java.lang.Long.valueOf(r16)     // Catch:{ Throwable -> 0x03af }
                r11.addAttribute(r5, r0)     // Catch:{ Throwable -> 0x03af }
                java.lang.String r0 = r11.getServiceCmd()     // Catch:{ Throwable -> 0x03af }
                java.lang.String r6 = "SharpSvr.c2s"
                boolean r0 = r0.startsWith(r6)     // Catch:{ Throwable -> 0x03af }
                if (r0 == 0) goto L_0x037c
                long r16 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x03af }
                com.tencent.qalsdk.core.n.f32214f = r16     // Catch:{ Throwable -> 0x03af }
            L_0x037c:
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03af }
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.m     // Catch:{ Throwable -> 0x03af }
                boolean r0 = r0.get()     // Catch:{ Throwable -> 0x03af }
                if (r0 == 0) goto L_0x033b
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03af }
                int r0 = r0.l     // Catch:{ Throwable -> 0x03af }
                r6 = -1
                if (r0 != r6) goto L_0x033c
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03af }
                int r15 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x03af }
                r0.l = r15     // Catch:{ Throwable -> 0x03af }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03af }
                java.lang.String r15 = "set afterReloadD2SendSeq "
                r0.<init>(r15)     // Catch:{ Throwable -> 0x03af }
                com.tencent.qalsdk.core.n r15 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x03af }
                int r15 = r15.l     // Catch:{ Throwable -> 0x03af }
                r0.append(r15)     // Catch:{ Throwable -> 0x03af }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x03af }
                r15 = 1
                com.tencent.qalsdk.util.QLog.d(r9, r15, r0)     // Catch:{ Throwable -> 0x03af }
            L_0x03ab:
                r6 = r28
                goto L_0x013a
            L_0x03af:
                r0 = move-exception
                goto L_0x03b7
            L_0x03b1:
                r28 = r6
                goto L_0x03da
            L_0x03b4:
                r0 = move-exception
                r28 = r6
            L_0x03b7:
                boolean r6 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x0475 }
                if (r6 == 0) goto L_0x03c5
                java.lang.String r6 = r0.toString()     // Catch:{ Throwable -> 0x0475 }
                r10 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r10, r6, r0)     // Catch:{ Throwable -> 0x0475 }
            L_0x03c5:
                r0.toString()     // Catch:{ Throwable -> 0x0475 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x0475 }
                int r6 = r11.getRequestSsoSeq()     // Catch:{ Throwable -> 0x0475 }
                r0.b((int) r6)     // Catch:{ Throwable -> 0x0475 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x0475 }
                java.util.concurrent.LinkedBlockingDeque r0 = r0.F     // Catch:{ Throwable -> 0x0475 }
                r0.remove(r11)     // Catch:{ Throwable -> 0x0475 }
            L_0x03da:
                com.tencent.qalsdk.sdk.MsfCommand r0 = r11.getMsfCommand()     // Catch:{ Throwable -> 0x0475 }
                com.tencent.qalsdk.sdk.MsfCommand r6 = com.tencent.qalsdk.sdk.MsfCommand._msf_kickedAndCleanTokenResp     // Catch:{ Throwable -> 0x0475 }
                if (r0 != r6) goto L_0x0472
                java.lang.String r0 = r11.getServiceCmd()     // Catch:{ Exception -> 0x0452 }
                java.lang.Object r0 = r11.getAttribute(r0)     // Catch:{ Exception -> 0x0452 }
                com.tencent.qalsdk.base.remote.FromServiceMsg r0 = (com.tencent.qalsdk.base.remote.FromServiceMsg) r0     // Catch:{ Exception -> 0x0452 }
                r6 = 2012(0x7dc, float:2.82E-42)
                java.lang.String r10 = r0.getBusinessFailMsg()     // Catch:{ Exception -> 0x0452 }
                r0.setBusinessFail(r6, r10)     // Catch:{ Exception -> 0x0452 }
                java.util.HashMap r6 = r11.getAttributes()     // Catch:{ Exception -> 0x0452 }
                boolean r6 = r6.containsKey(r8)     // Catch:{ Exception -> 0x0452 }
                if (r6 == 0) goto L_0x040c
                java.lang.Object r6 = r11.getAttribute(r8)     // Catch:{ Exception -> 0x0452 }
                java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x0452 }
                boolean r13 = r6.booleanValue()     // Catch:{ Exception -> 0x0452 }
                r29 = r13
                goto L_0x040e
            L_0x040c:
                r29 = 0
            L_0x040e:
                java.util.HashMap r6 = r11.getAttributes()     // Catch:{ Exception -> 0x0452 }
                boolean r6 = r6.containsKey(r7)     // Catch:{ Exception -> 0x0452 }
                if (r6 == 0) goto L_0x041f
                java.lang.Object r6 = r11.getAttribute(r7)     // Catch:{ Exception -> 0x0452 }
                r0.addAttribute(r7, r6)     // Catch:{ Exception -> 0x0452 }
            L_0x041f:
                java.util.HashMap r6 = r11.getAttributes()     // Catch:{ Exception -> 0x0452 }
                r10 = r28
                boolean r6 = r6.containsKey(r10)     // Catch:{ Exception -> 0x0450 }
                if (r6 == 0) goto L_0x0432
                java.lang.Object r6 = r11.getAttribute(r10)     // Catch:{ Exception -> 0x0450 }
                r0.addAttribute(r10, r6)     // Catch:{ Exception -> 0x0450 }
            L_0x0432:
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r29)     // Catch:{ Exception -> 0x0450 }
                r0.addAttribute(r8, r6)     // Catch:{ Exception -> 0x0450 }
                java.lang.String r6 = "*"
                com.tencent.qalsdk.sdk.MsfSdkUtils.addFromMsgProcessName(r6, r0)     // Catch:{ Exception -> 0x0450 }
                com.tencent.qalsdk.core.n r6 = com.tencent.qalsdk.core.n.this     // Catch:{ Exception -> 0x0450 }
                com.tencent.qalsdk.core.j r6 = r6.n     // Catch:{ Exception -> 0x0450 }
                r11 = 0
                r6.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r11, (com.tencent.qalsdk.base.remote.FromServiceMsg) r0)     // Catch:{ Exception -> 0x0450 }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Exception -> 0x0450 }
                qalsdk.k r0 = r0.k     // Catch:{ Exception -> 0x0450 }
                com.tencent.qalsdk.base.CloseConnReason r6 = com.tencent.qalsdk.base.CloseConnReason.appCall     // Catch:{ Exception -> 0x0450 }
                r0.a((com.tencent.qalsdk.base.CloseConnReason) r6)     // Catch:{ Exception -> 0x0450 }
                goto L_0x0492
            L_0x0450:
                r0 = move-exception
                goto L_0x0455
            L_0x0452:
                r0 = move-exception
                r10 = r28
            L_0x0455:
                boolean r6 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x0480 }
                if (r6 == 0) goto L_0x0492
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0480 }
                java.lang.String r11 = "send offlineMsg to app error "
                r6.<init>(r11)     // Catch:{ Throwable -> 0x0480 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0480 }
                r6.append(r0)     // Catch:{ Throwable -> 0x0480 }
                java.lang.String r0 = r6.toString()     // Catch:{ Throwable -> 0x0480 }
                r6 = 2
                com.tencent.qalsdk.util.QLog.e(r9, r6, r0)     // Catch:{ Throwable -> 0x0480 }
                goto L_0x0492
            L_0x0472:
                r10 = r28
                goto L_0x0492
            L_0x0475:
                r0 = move-exception
                r10 = r28
                goto L_0x0484
            L_0x0479:
                r10 = r6
                r11 = 10
                java.lang.Thread.sleep(r11)     // Catch:{ Throwable -> 0x0480 }
                goto L_0x0492
            L_0x0480:
                r0 = move-exception
                goto L_0x0484
            L_0x0482:
                r0 = move-exception
                r10 = r6
            L_0x0484:
                boolean r6 = com.tencent.qalsdk.util.QLog.isColorLevel()
                if (r6 == 0) goto L_0x0492
                java.lang.String r6 = r0.toString()
                r11 = 2
                com.tencent.qalsdk.util.QLog.d(r9, r11, r6, r0)
            L_0x0492:
                r6 = r10
                goto L_0x0015
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.n.b.run():void");
        }
    }

    class a extends CodecWarpper {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0184, code lost:
            if (r13 > 2147483647L) goto L_0x0186;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onResponse(int r18, java.lang.Object r19, int r20) {
            /*
                r17 = this;
                r1 = r17
                r2 = r19
                r0 = r20
                java.lang.String r3 = "_attr_msg_has_resend_by_10008"
                java.lang.String r4 = "|"
                java.lang.String r5 = "__timestamp_net2msf"
                if (r2 == 0) goto L_0x04d4
                r6 = 2
                int r7 = com.tencent.qalsdk.core.n.i     // Catch:{ Throwable -> 0x04ab }
                r8 = -1
                if (r7 == r8) goto L_0x0016
                com.tencent.qalsdk.core.n.i = r8     // Catch:{ Throwable -> 0x04ab }
            L_0x0016:
                com.tencent.qalsdk.core.n r7 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x04ab }
                r7.p = r8     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r7 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                long r7 = r7.p     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n.f32215g = r7     // Catch:{ Throwable -> 0x04ab }
                r7 = r2
                com.tencent.qalsdk.base.remote.FromServiceMsg r7 = (com.tencent.qalsdk.base.remote.FromServiceMsg) r7     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r8 = r7.getServiceCmd()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r9 = "MSF"
                boolean r8 = r8.equals(r9)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r9 = "MSF.C.NetConnTag"
                r10 = 0
                r11 = 1
                if (r8 == 0) goto L_0x006e
                java.lang.String r8 = "ping pkg ack received"
                com.tencent.qalsdk.util.QLog.d(r9, r11, r8)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r8 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicBoolean r8 = r8.H     // Catch:{ Throwable -> 0x04ab }
                r8.set(r10)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r8 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicBoolean r8 = r8.I     // Catch:{ Throwable -> 0x04ab }
                r8.set(r10)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r8 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicInteger r8 = r8.G     // Catch:{ Throwable -> 0x04ab }
                int r8 = r8.get()     // Catch:{ Throwable -> 0x04ab }
                r7.setRequestSsoSeq(r8)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r8 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicInteger r8 = r8.G     // Catch:{ Throwable -> 0x04ab }
                int r8 = r8.get()     // Catch:{ Throwable -> 0x04ab }
                r7.setAppSeq(r8)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.sdk.MsfCommand r8 = com.tencent.qalsdk.sdk.MsfCommand.qal_Hello     // Catch:{ Throwable -> 0x04ab }
                r7.setMsfCommand(r8)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x0077
            L_0x006e:
                com.tencent.qalsdk.core.n r8 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicBoolean r8 = r8.J     // Catch:{ Throwable -> 0x04ab }
                r8.set(r10)     // Catch:{ Throwable -> 0x04ab }
            L_0x0077:
                int r8 = r7.getFlag()     // Catch:{ Throwable -> 0x04ab }
                r8 = r8 & r11
                if (r8 == 0) goto L_0x00f2
                byte[] r8 = r7.getWupBuffer()     // Catch:{ Throwable -> 0x04ab }
                int r12 = r8.length     // Catch:{ Throwable -> 0x04ab }
                r13 = 4
                if (r12 <= r13) goto L_0x00ec
                byte r12 = r8[r10]     // Catch:{ Exception -> 0x00d2 }
                r12 = r12 & 255(0xff, float:3.57E-43)
                int r12 = r12 << 24
                r12 = r12 | r10
                byte r14 = r8[r11]     // Catch:{ Exception -> 0x00d2 }
                r14 = r14 & 255(0xff, float:3.57E-43)
                int r14 = r14 << 16
                r12 = r12 | r14
                byte r14 = r8[r6]     // Catch:{ Exception -> 0x00d2 }
                r14 = r14 & 255(0xff, float:3.57E-43)
                int r14 = r14 << 8
                r12 = r12 | r14
                r14 = 3
                byte r14 = r8[r14]     // Catch:{ Exception -> 0x00d2 }
                r14 = r14 & 255(0xff, float:3.57E-43)
                r12 = r12 | r14
                byte[] r14 = new byte[r12]     // Catch:{ Exception -> 0x00d2 }
                int r12 = r12 - r13
                java.lang.System.arraycopy(r8, r13, r14, r10, r12)     // Catch:{ Exception -> 0x00d2 }
                byte[] r12 = com.tencent.qalsdk.util.ZLibUtils.decompress((byte[]) r14)     // Catch:{ Exception -> 0x00d2 }
                int r14 = r12.length     // Catch:{ Exception -> 0x00d2 }
                int r14 = r14 + r13
                byte[] r14 = new byte[r14]     // Catch:{ Exception -> 0x00d2 }
                int r15 = r12.length     // Catch:{ Exception -> 0x00d2 }
                int r15 = r15 + r13
                int r15 = r15 >>> 24
                byte r15 = (byte) r15     // Catch:{ Exception -> 0x00d2 }
                r14[r10] = r15     // Catch:{ Exception -> 0x00d2 }
                int r15 = r12.length     // Catch:{ Exception -> 0x00d2 }
                int r15 = r15 + r13
                int r15 = r15 >> 16
                byte r15 = (byte) r15     // Catch:{ Exception -> 0x00d2 }
                r14[r11] = r15     // Catch:{ Exception -> 0x00d2 }
                int r15 = r12.length     // Catch:{ Exception -> 0x00d2 }
                int r15 = r15 + r13
                int r15 = r15 >> 8
                byte r15 = (byte) r15     // Catch:{ Exception -> 0x00d2 }
                r14[r6] = r15     // Catch:{ Exception -> 0x00d2 }
                r15 = 3
                int r11 = r12.length     // Catch:{ Exception -> 0x00d2 }
                int r11 = r11 + r13
                byte r11 = (byte) r11     // Catch:{ Exception -> 0x00d2 }
                r14[r15] = r11     // Catch:{ Exception -> 0x00d2 }
                int r11 = r12.length     // Catch:{ Exception -> 0x00d2 }
                java.lang.System.arraycopy(r12, r10, r14, r13, r11)     // Catch:{ Exception -> 0x00d2 }
                r7.putWupBuffer(r14)     // Catch:{ Exception -> 0x00d2 }
                goto L_0x00f2
            L_0x00d2:
                r0 = move-exception
                java.lang.String r3 = tag     // Catch:{ Throwable -> 0x04ab }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r5 = "uncompress data failed "
                r4.<init>(r5)     // Catch:{ Throwable -> 0x04ab }
                r4.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r4.toString()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.util.QLog.e(r3, r6, r0)     // Catch:{ Throwable -> 0x04ab }
                r0 = -7
                int r3 = r8.length     // Catch:{ Throwable -> 0x04ab }
                r1.onInvalidData(r0, r3)     // Catch:{ Throwable -> 0x04ab }
                return
            L_0x00ec:
                r0 = -6
                int r3 = r8.length     // Catch:{ Throwable -> 0x04ab }
                r1.onInvalidData(r0, r3)     // Catch:{ Throwable -> 0x04ab }
                return
            L_0x00f2:
                long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ Throwable -> 0x04ab }
                r7.addAttribute(r5, r8)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r8 = "__timestamp_net2msf_boot"
                long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Throwable -> 0x04ab }
                r7.addAttribute(r8, r11)     // Catch:{ Throwable -> 0x04ab }
                byte[] r8 = r7.getMsgCookie()     // Catch:{ Throwable -> 0x04ab }
                if (r8 == 0) goto L_0x011c
                int r11 = r8.length     // Catch:{ Throwable -> 0x04ab }
                if (r11 <= 0) goto L_0x011c
                com.tencent.qalsdk.core.n r11 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r11 = r11.n     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r11 = r11.f32187c     // Catch:{ Throwable -> 0x04ab }
                r11.b((byte[]) r8)     // Catch:{ Throwable -> 0x04ab }
            L_0x011c:
                boolean r8 = r7.isSuccess()     // Catch:{ Throwable -> 0x04ab }
                if (r8 != 0) goto L_0x0131
                int r8 = r7.getBusinessFailCode()     // Catch:{ Throwable -> 0x04ab }
                r11 = -10008(0xffffffffffffd8e8, float:NaN)
                if (r8 != r11) goto L_0x0131
                java.lang.String r8 = r7.getUin()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n.a((java.lang.String) r8, (boolean) r10)     // Catch:{ Throwable -> 0x04ab }
            L_0x0131:
                int r8 = r7.getAppSeq()     // Catch:{ Throwable -> 0x04ab }
                r7.setRequestSsoSeq(r8)     // Catch:{ Throwable -> 0x04ab }
                boolean r8 = com.tencent.qalsdk.core.m.h()     // Catch:{ Throwable -> 0x04ab }
                if (r8 == 0) goto L_0x0141
                com.tencent.qalsdk.core.m.b((boolean) r10)     // Catch:{ Throwable -> 0x04ab }
            L_0x0141:
                com.tencent.qalsdk.core.n r8 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r8 = r8.n     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r8 = r8.f32187c     // Catch:{ Throwable -> 0x04ab }
                int r11 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.base.remote.ToServiceMsg r8 = r8.b((int) r11)     // Catch:{ Throwable -> 0x04ab }
                r11 = 0
                if (r8 == 0) goto L_0x0186
                java.lang.String r13 = "__timestamp_msf2net"
                java.lang.Object r13 = r8.getAttribute(r13)     // Catch:{ Throwable -> 0x04ab }
                if (r13 == 0) goto L_0x0186
                if (r7 == 0) goto L_0x0186
                java.lang.Object r13 = r7.getAttribute(r5)     // Catch:{ Throwable -> 0x04ab }
                if (r13 == 0) goto L_0x0186
                java.lang.Object r5 = r7.getAttribute(r5)     // Catch:{ Throwable -> 0x04ab }
                java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ Throwable -> 0x04ab }
                long r13 = r5.longValue()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r5 = "__timestamp_msf2net"
                java.lang.Object r5 = r8.getAttribute(r5)     // Catch:{ Throwable -> 0x04ab }
                java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ Throwable -> 0x04ab }
                long r15 = r5.longValue()     // Catch:{ Throwable -> 0x04ab }
                long r13 = r13 - r15
                int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r5 >= 0) goto L_0x017f
                r13 = r11
            L_0x017f:
                r15 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r5 <= 0) goto L_0x0187
            L_0x0186:
                r13 = r11
            L_0x0187:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                r5.<init>()     // Catch:{ Throwable -> 0x04ab }
                boolean r15 = com.tencent.qalsdk.util.QLog.isDevelopLevel()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r6 = " cmd:"
                java.lang.String r10 = " uin:"
                java.lang.String r2 = "netRecv ssoSeq:"
                if (r15 == 0) goto L_0x024c
                int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r15 != 0) goto L_0x01a1
                java.lang.String r11 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x01b4
            L_0x01a1:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                r11.<init>()     // Catch:{ Throwable -> 0x04ab }
                r11.append(r13)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r12 = com.tencent.qalsdk.core.NetConnInfoCenter.getSignalStrengthsLog()     // Catch:{ Throwable -> 0x04ab }
                r11.append(r12)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r11 = r11.toString()     // Catch:{ Throwable -> 0x04ab }
            L_0x01b4:
                int r12 = r7.getResultCode()     // Catch:{ Throwable -> 0x04ab }
                r13 = 1000(0x3e8, float:1.401E-42)
                if (r12 == r13) goto L_0x0210
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                int r2 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r10)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getUin()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = com.tencent.qalsdk.sdk.MsfSdkUtils.getShortUin(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r6)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getServiceCmd()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = " len:"
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = " cost time:"
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r11)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = " code:"
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                int r0 = r7.getResultCode()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = " failMsg:"
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r7.getBusinessFailMsg()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r5.toString()     // Catch:{ Throwable -> 0x04ab }
                r2 = 1
                com.tencent.qalsdk.util.QLog.e(r9, r2, r0)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x02ed
            L_0x0210:
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                int r2 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r10)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getUin()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = com.tencent.qalsdk.sdk.MsfSdkUtils.getShortUin(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r6)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getServiceCmd()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = " len:"
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = " cost time:"
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r11)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r5.toString()     // Catch:{ Throwable -> 0x04ab }
                r2 = 1
                com.tencent.qalsdk.util.QLog.i(r9, r2, r0)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x02ed
            L_0x024c:
                int r11 = r7.getResultCode()     // Catch:{ Throwable -> 0x04ab }
                r12 = 1000(0x3e8, float:1.401E-42)
                if (r11 == r12) goto L_0x02ad
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                int r2 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r10)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getUin()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = com.tencent.qalsdk.sdk.MsfSdkUtils.getShortUin(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r6)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getServiceCmd()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r6 = " "
                r2.<init>(r6)     // Catch:{ Throwable -> 0x04ab }
                int r6 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                int r6 = r6 + r0
                r2.append(r6)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r2.toString()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = " code:"
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                int r0 = r7.getResultCode()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = " failMsg:"
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r7.getBusinessFailMsg()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r5.toString()     // Catch:{ Throwable -> 0x04ab }
                r2 = 1
                com.tencent.qalsdk.util.QLog.e(r9, r2, r0)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x02ed
            L_0x02ad:
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                int r2 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r10)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getUin()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = com.tencent.qalsdk.sdk.MsfSdkUtils.getShortUin(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                r5.append(r6)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r7.getServiceCmd()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r6 = " "
                r2.<init>(r6)     // Catch:{ Throwable -> 0x04ab }
                int r6 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                int r6 = r6 + r0
                r2.append(r6)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r2.toString()     // Catch:{ Throwable -> 0x04ab }
                r5.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = r5.toString()     // Catch:{ Throwable -> 0x04ab }
                r2 = 1
                com.tencent.qalsdk.util.QLog.i(r9, r2, r0)     // Catch:{ Throwable -> 0x04ab }
            L_0x02ed:
                java.lang.String r0 = "_tag_LOGSTR"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                r2.<init>()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r5 = com.tencent.qalsdk.core.n.f32211c     // Catch:{ Throwable -> 0x04ab }
                r2.append(r5)     // Catch:{ Throwable -> 0x04ab }
                r2.append(r4)     // Catch:{ Throwable -> 0x04ab }
                int r5 = r7.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                r2.append(r5)     // Catch:{ Throwable -> 0x04ab }
                r2.append(r4)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r5 = r7.getServiceCmd()     // Catch:{ Throwable -> 0x04ab }
                r2.append(r5)     // Catch:{ Throwable -> 0x04ab }
                r2.append(r4)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x04ab }
                r7.addAttribute(r0, r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = "_tag_socket"
                java.lang.String r2 = com.tencent.qalsdk.core.n.f32211c     // Catch:{ Throwable -> 0x04ab }
                r7.addAttribute(r0, r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = "_tag_localsocket"
                java.lang.String r2 = com.tencent.qalsdk.core.n.f32212d     // Catch:{ Throwable -> 0x04ab }
                r7.addAttribute(r0, r2)     // Catch:{ Throwable -> 0x04ab }
                if (r8 == 0) goto L_0x034b
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Exception -> 0x032f }
                qalsdk.k r0 = r0.k     // Catch:{ Exception -> 0x032f }
                r0.a(r7, r8)     // Catch:{ Exception -> 0x032f }
                goto L_0x034b
            L_0x032f:
                r0 = move-exception
                com.tencent.qalsdk.core.n r2 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                qalsdk.k r2 = r2.k     // Catch:{ Throwable -> 0x04ab }
                r2.d()     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = tag     // Catch:{ Throwable -> 0x04ab }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r5 = "call firstResponseGetted error "
                r4.<init>(r5)     // Catch:{ Throwable -> 0x04ab }
                r4.append(r0)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x04ab }
                r5 = 1
                com.tencent.qalsdk.util.QLog.d(r2, r5, r4, r0)     // Catch:{ Throwable -> 0x04ab }
            L_0x034b:
                if (r8 == 0) goto L_0x03a6
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.ConcurrentHashMap r0 = r0.E     // Catch:{ Throwable -> 0x04ab }
                int r2 = r8.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x04ab }
                boolean r0 = r0.containsKey(r2)     // Catch:{ Throwable -> 0x04ab }
                if (r0 == 0) goto L_0x03a6
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.ConcurrentHashMap r0 = r0.E     // Catch:{ Throwable -> 0x04ab }
                int r2 = r8.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.Object r0 = r0.get(r2)     // Catch:{ Throwable -> 0x04ab }
                qalsdk.k r0 = (qalsdk.k) r0     // Catch:{ Throwable -> 0x04ab }
                qalsdk.j r2 = r0.h()     // Catch:{ Throwable -> 0x04ab }
                qalsdk.f r2 = r2.c()     // Catch:{ Throwable -> 0x04ab }
                if (r2 == 0) goto L_0x0388
                com.tencent.qalsdk.core.n r4 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.ConcurrentHashMap r4 = r4.D     // Catch:{ Throwable -> 0x04ab }
                r4.remove(r2)     // Catch:{ Throwable -> 0x04ab }
            L_0x0388:
                com.tencent.qalsdk.base.CloseConnReason r2 = com.tencent.qalsdk.base.CloseConnReason.closeByOnetimeSocket     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.CloseConnReason) r2)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.ConcurrentHashMap r0 = r0.E     // Catch:{ Throwable -> 0x04ab }
                int r2 = r8.getRequestSsoSeq()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Throwable -> 0x04ab }
                r0.remove(r2)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r0 = tag     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = "remove codecWrappers & socket in hashmap"
                r4 = 1
                com.tencent.qalsdk.util.QLog.i(r0, r4, r2)     // Catch:{ Throwable -> 0x04ab }
            L_0x03a6:
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f32191g     // Catch:{ Throwable -> 0x04ab }
                boolean r0 = r0.get()     // Catch:{ Throwable -> 0x04ab }
                if (r0 == 0) goto L_0x03d5
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Throwable -> 0x04ab }
                boolean r0 = r0.c()     // Catch:{ Throwable -> 0x04ab }
                if (r0 == 0) goto L_0x03d5
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x04ab }
                qalsdk.j r0 = r0.h()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.base.CloseConnReason r2 = com.tencent.qalsdk.base.CloseConnReason.pushNeedReConn     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.CloseConnReason) r2)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x04ab }
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f32191g     // Catch:{ Throwable -> 0x04ab }
                r2 = 0
                r0.set(r2)     // Catch:{ Throwable -> 0x04ab }
            L_0x03d5:
                if (r8 == 0) goto L_0x045a
                int r0 = r8.getAppSeq()     // Catch:{ Throwable -> 0x04ab }
                r7.setAppSeq(r0)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.sdk.MsfCommand r0 = r8.getMsfCommand()     // Catch:{ Throwable -> 0x04ab }
                r7.setMsfCommand(r0)     // Catch:{ Throwable -> 0x04ab }
                int r0 = r8.getAppId()     // Catch:{ Throwable -> 0x04ab }
                r7.setAppId(r0)     // Catch:{ Throwable -> 0x04ab }
                boolean r0 = r7.isSuccess()     // Catch:{ Throwable -> 0x04ab }
                if (r0 != 0) goto L_0x045a
                int r0 = r7.getBusinessFailCode()     // Catch:{ Throwable -> 0x04ab }
                r2 = 302(0x12e, float:4.23E-43)
                r4 = -302(0xfffffffffffffed2, float:NaN)
                if (r0 != r2) goto L_0x0401
                r7.setBusinessFail(r4)     // Catch:{ Throwable -> 0x04ab }
                r0 = -302(0xfffffffffffffed2, float:NaN)
            L_0x0401:
                if (r0 != r4) goto L_0x041b
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                qalsdk.k r0 = r0.k     // Catch:{ Throwable -> 0x04ab }
                qalsdk.j r0 = r0.h()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.base.CloseConnReason r2 = com.tencent.qalsdk.base.CloseConnReason.connFull     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.CloseConnReason) r2)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x04d4
            L_0x041b:
                r2 = -10008(0xffffffffffffd8e8, float:NaN)
                if (r0 != r2) goto L_0x045a
                java.util.HashMap r0 = r8.getAttributes()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ Throwable -> 0x04ab }
                if (r0 == 0) goto L_0x0438
                java.util.HashMap r0 = r8.getAttributes()     // Catch:{ Throwable -> 0x04ab }
                java.lang.Object r0 = r0.get(r3)     // Catch:{ Throwable -> 0x04ab }
                java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Throwable -> 0x04ab }
                boolean r10 = r0.booleanValue()     // Catch:{ Throwable -> 0x04ab }
                goto L_0x0439
            L_0x0438:
                r10 = 0
            L_0x0439:
                if (r10 != 0) goto L_0x0452
                java.util.HashMap r0 = r8.getAttributes()     // Catch:{ Throwable -> 0x04ab }
                r2 = 1
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Throwable -> 0x04ab }
                r0.put(r3, r2)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x04d4
            L_0x0452:
                java.lang.String r0 = tag     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = "This msg has already resend by -10008, won't resend again!"
                r3 = 1
                com.tencent.qalsdk.util.QLog.d(r0, r3, r2)     // Catch:{ Throwable -> 0x04ab }
            L_0x045a:
                java.util.concurrent.atomic.AtomicBoolean r0 = com.tencent.qalsdk.core.n.v     // Catch:{ Throwable -> 0x04ab }
                boolean r0 = r0.get()     // Catch:{ Throwable -> 0x04ab }
                if (r0 == 0) goto L_0x047e
                java.lang.String r0 = tag     // Catch:{ Throwable -> 0x04ab }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r3 = "invalidSign, "
                r2.<init>(r3)     // Catch:{ Throwable -> 0x04ab }
                r2.append(r7)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r3 = " is droped."
                r2.append(r3)     // Catch:{ Throwable -> 0x04ab }
                java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x04ab }
                r3 = 1
                com.tencent.qalsdk.util.QLog.e(r0, r3, r2)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x04a5
            L_0x047e:
                com.tencent.qalsdk.sdk.MsfCommand r0 = r7.getMsfCommand()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.sdk.MsfCommand r2 = com.tencent.qalsdk.sdk.MsfCommand._msf_HeartbeatAlive     // Catch:{ Throwable -> 0x04ab }
                if (r0 != r2) goto L_0x048c
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.remote.FromServiceMsg) r7, (com.tencent.qalsdk.base.remote.ToServiceMsg) r8)     // Catch:{ Throwable -> 0x04ab }
                goto L_0x04a5
            L_0x048c:
                com.tencent.qalsdk.sdk.MsfCommand r0 = r7.getMsfCommand()     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.sdk.MsfCommand r2 = com.tencent.qalsdk.sdk.MsfCommand.qal_Hello     // Catch:{ Throwable -> 0x04ab }
                if (r0 == r2) goto L_0x04a5
                java.util.concurrent.atomic.AtomicInteger r0 = com.tencent.qalsdk.core.n.f32210b     // Catch:{ Throwable -> 0x04ab }
                r2 = 0
                r0.set(r2)     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.n r0 = com.tencent.qalsdk.core.n.this     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.j r0 = r0.n     // Catch:{ Throwable -> 0x04ab }
                com.tencent.qalsdk.core.p r0 = r0.f()     // Catch:{ Throwable -> 0x04ab }
                r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r8, (com.tencent.qalsdk.base.remote.FromServiceMsg) r7)     // Catch:{ Throwable -> 0x04ab }
            L_0x04a5:
                com.tencent.qalsdk.core.m r0 = com.tencent.qalsdk.core.NetConnInfoCenter.impl     // Catch:{ Throwable -> 0x04ab }
                r0.n()     // Catch:{ Throwable -> 0x04ab }
                goto L_0x04d4
            L_0x04ab:
                r0 = move-exception
                boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()
                if (r2 == 0) goto L_0x04d4
                java.lang.String r2 = tag
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "handleSsoResp "
                r3.<init>(r4)
                r4 = r19
                r3.append(r4)
                java.lang.String r4 = " error "
                r3.append(r4)
                java.lang.String r4 = r0.toString()
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r4 = 2
                com.tencent.qalsdk.util.QLog.d(r2, r4, r3, r0)
            L_0x04d4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.n.a.onResponse(int, java.lang.Object, int):void");
        }

        public final void onInvalidSign() {
            QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
            FromServiceMsg fromServiceMsg = new FromServiceMsg(n.this.n.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_InvalidSign");
            fromServiceMsg.setBusinessFail(2014, "onInvalidSign");
            fromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            n.this.n.a((ToServiceMsg) null, fromServiceMsg);
            n.v.set(true);
        }

        public final void onInvalidData(int i, int i2) {
            CloseConnReason closeConnReason;
            String str = tag;
            QLog.d(str, 1, "MSF.C.CodecWarpper onInvalidData " + i + " size is " + i2 + ", try to closeConn");
            j h = n.this.k.h();
            switch (i) {
                case -8:
                    closeConnReason = CloseConnReason.closeByPbUnpackFailInLoginMerge;
                    break;
                case -7:
                    closeConnReason = CloseConnReason.closeByZlibUncompressException;
                    break;
                case -6:
                    closeConnReason = CloseConnReason.closeByZlibDataLengthTooShort;
                    break;
                case -5:
                    closeConnReason = CloseConnReason.invalidData;
                    break;
                case -4:
                    closeConnReason = CloseConnReason.closeByDecryptFailEmpty;
                    break;
                case -3:
                    closeConnReason = CloseConnReason.closeByDecryptFailTwice;
                    break;
                case -2:
                    closeConnReason = CloseConnReason.closeByDecryptFailOnce;
                    break;
                default:
                    closeConnReason = CloseConnReason.closeForOtherReason;
                    break;
            }
            h.a(closeConnReason);
            try {
                n.this.k.f();
            } catch (Exception e2) {
                String str2 = tag;
                QLog.d(str2, 1, "call findResponseDataError error " + e2);
            }
        }
    }

    static /* synthetic */ void b(n nVar) {
        if (nVar.k.a()) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "Heartbeat.Alive");
            toServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
            toServiceMsg.setRequestSsoSeq(j.b());
            toServiceMsg.setAppId(nVar.n.h());
            toServiceMsg.putWupBuffer(new byte[]{0, 0, 0, 4});
            toServiceMsg.setTimeout(10000);
            nVar.b(toServiceMsg);
            nVar.x = qalsdk.a.d();
            QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok " + toServiceMsg.getRequestSsoSeq());
            nVar.y = System.currentTimeMillis();
            nVar.o.set(true);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
        }
        nVar.x = 0;
        nVar.o.set(false);
    }
}
