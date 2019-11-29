package com.tencent.qalsdk.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.g.a.a.f;
import com.google.android.gms.location.places.Place;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qalsdk.QALCallBack;
import com.tencent.qalsdk.QALConnListener;
import com.tencent.qalsdk.QALInitHelper;
import com.tencent.qalsdk.QALInitListener;
import com.tencent.qalsdk.QALPushListener;
import com.tencent.qalsdk.QALSDKManager;
import com.tencent.qalsdk.QALUserStatusListener;
import com.tencent.qalsdk.QALValueCallBack;
import com.tencent.qalsdk.QALValueWithSeqCallBack;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseActionListener;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.l;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.core.n;
import com.tencent.qalsdk.im_open.stat_reg;
import com.tencent.qalsdk.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import qalsdk.aa;
import qalsdk.af;
import qalsdk.ag;
import tencent.tls.platform.TLSLoginHelper;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static v f32231a = v.a();

    /* renamed from: b  reason: collision with root package name */
    private static String f32232b = null;

    /* renamed from: c  reason: collision with root package name */
    private static c f32233c = new c();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static Handler f32234d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f32235e = false;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f32236f;

    /* renamed from: g  reason: collision with root package name */
    private l f32237g;
    private String h;
    private ConcurrentHashMap<String, String> i;
    private ConcurrentHashMap<String, String> j;
    private ConcurrentHashMap<String, Integer> k;
    private String l;
    private String m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private String q;
    private String r;
    private int s;
    private int t;
    private ConcurrentHashMap<String, QALPushListener> u;
    private long v;
    private com.tencent.qalsdk.core.a w;
    private boolean x;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, IBaseActionListener> y;
    private ConcurrentHashMap<QALInitListener, Object> z;

    private c() {
        new Random();
        new AtomicInteger(1000);
        this.f32236f = false;
        this.i = new ConcurrentHashMap<>();
        this.j = new ConcurrentHashMap<>();
        this.k = new ConcurrentHashMap<>();
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = -1;
        this.t = 0;
        this.u = new ConcurrentHashMap<>();
        this.v = 10000;
        this.x = false;
        this.y = new ConcurrentHashMap<>();
        this.z = new ConcurrentHashMap<>();
    }

    public static c a() {
        return f32233c;
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

    public final synchronized void a(long j2) {
        this.v = j2;
    }

    public final synchronized int b() {
        return this.s;
    }

    public final void a(int i2) {
        if (f32231a.f32278a) {
            d(i2);
            return;
        }
        this.p = true;
        this.t = i2;
    }

    public final synchronized String c() {
        return this.l;
    }

    public final synchronized void a(String str) {
        this.l = str;
    }

    public final synchronized String d() {
        return this.m;
    }

    private synchronized void d(String str) {
    }

    public final synchronized ConcurrentHashMap<String, String> e() {
        return this.i;
    }

    public final synchronized String f() {
        return f32232b;
    }

    private synchronized void a(String str, String str2, String str3, int i2) {
        f32232b = str2;
    }

    public final synchronized void a(String str, QALPushListener qALPushListener) {
        Log.d("CoreWrapper", "add push" + str);
        this.u.put(str, qALPushListener);
    }

    /* access modifiers changed from: private */
    public boolean b(FromServiceMsg fromServiceMsg) {
        try {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            QLog.d("CoreWrapper", 1, "[CoreWrapper handlePushMsg] recv push cmd: " + serviceCmd + ":msf cmd:" + fromServiceMsg.getMsfCommand() + ":" + fromServiceMsg.getRequestSsoSeq());
            if (fromServiceMsg.getMsfCommand() == MsfCommand.onNetNeedSignon) {
                QLog.i("CoreWrapper", m.f() + " wifi need wath");
                String str = (String) fromServiceMsg.getAttribute("signonurl");
                for (QALConnListener next : QALSDKManager.getInstance().getConnectionListeners().keySet()) {
                    if (next != null) {
                        next.onWifiNeedAuth(str);
                    }
                }
                return true;
            }
            if (serviceCmd.equals("cmd_connOpened")) {
                for (QALConnListener next2 : QALSDKManager.getInstance().getConnectionListeners().keySet()) {
                    if (next2 != null) {
                        next2.onConnected();
                    }
                }
            } else {
                boolean z2 = false;
                if (serviceCmd.equals("cmd_connClosed")) {
                    for (QALConnListener next3 : QALSDKManager.getInstance().getConnectionListeners().keySet()) {
                        if (next3 != null) {
                            next3.onDisconnected(0, "");
                        }
                    }
                } else if (serviceCmd.equals("cmd_connInfo")) {
                    a((String) fromServiceMsg.getAttribute("to_conn_apn"), (String) fromServiceMsg.getAttribute("to_conn_gateIP"), (String) fromServiceMsg.getAttribute("to_conn_serverIP"), ((Integer) fromServiceMsg.getAttribute("to_conn_radioType")).intValue());
                } else if (serviceCmd.equals("qal.setServerEnv")) {
                    this.s = ((Integer) fromServiceMsg.getAttribute("sso_server_env")).intValue();
                    QLog.i("CoreWrapper", "recv service serverEnv:" + this.s);
                } else if (serviceCmd.equals("im_open_status.stat_forceoffline")) {
                    QALUserStatusListener userStatusListener = QALSDKManager.getInstance().getUserStatusListener();
                    if (userStatusListener != null) {
                        QLog.i("CoreWrapper", fromServiceMsg.getUin() + " forceoffline, getUserStatusListener cb");
                        userStatusListener.onForceOffline(this.j.get(fromServiceMsg.getUin()));
                    }
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.registerPush) {
                    a((ToServiceMsg) null, fromServiceMsg, (QALCallBack) null);
                } else if (this.u.containsKey(serviceCmd)) {
                    QALPushListener qALPushListener = this.u.get(serviceCmd);
                    if (!fromServiceMsg.isSuccess()) {
                        qALPushListener.onError(this.j.get(fromServiceMsg.getUin()), 1001, fromServiceMsg.getBusinessFailMsg());
                        z2 = true;
                    }
                    if (z2) {
                        return true;
                    }
                    qALPushListener.onSuccess(this.j.get(fromServiceMsg.getUin()), a(fromServiceMsg));
                } else {
                    QLog.d("CoreWrapper", 2, "push come,no callback:" + fromServiceMsg.getServiceCmd());
                }
            }
            return true;
        } catch (Exception e2) {
            QLog.d("CoreWrapper", 1, "handle push msg error " + e2, e2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf A[Catch:{ Exception -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0106 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.tencent.qalsdk.base.remote.ToServiceMsg r8, com.tencent.qalsdk.base.remote.FromServiceMsg r9) {
        /*
            r7 = this;
            java.lang.String r0 = "|"
            java.lang.String r1 = "CoreWrapper"
            r2 = 1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            java.lang.String r4 = "[CoreWrapper handleRespMsg] recv resp msg:"
            r3.<init>(r4)     // Catch:{ Exception -> 0x0107 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0107 }
            r3.append(r4)     // Catch:{ Exception -> 0x0107 }
            r3.append(r0)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r4 = r9.getServiceCmd()     // Catch:{ Exception -> 0x0107 }
            r3.append(r4)     // Catch:{ Exception -> 0x0107 }
            r3.append(r0)     // Catch:{ Exception -> 0x0107 }
            int r4 = r9.getRequestSsoSeq()     // Catch:{ Exception -> 0x0107 }
            r3.append(r4)     // Catch:{ Exception -> 0x0107 }
            r3.append(r0)     // Catch:{ Exception -> 0x0107 }
            int r0 = r8.getAppSeq()     // Catch:{ Exception -> 0x0107 }
            r3.append(r0)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0107 }
            r3 = 2
            com.tencent.qalsdk.util.QLog.i(r1, r3, r0)     // Catch:{ Exception -> 0x0107 }
            int r0 = r9.getBusinessFailCode()     // Catch:{ Exception -> 0x0107 }
            r4 = -10001(0xffffffffffffd8ef, float:NaN)
            if (r0 == r4) goto L_0x0049
            r5 = -10003(0xffffffffffffd8ed, float:NaN)
            if (r0 == r5) goto L_0x0049
            r5 = -10004(0xffffffffffffd8ec, float:NaN)
            if (r0 != r5) goto L_0x009c
        L_0x0049:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r5 = r7.j     // Catch:{ Exception -> 0x0107 }
            java.lang.String r6 = r8.getUin()     // Catch:{ Exception -> 0x0107 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0107 }
            if (r5 == 0) goto L_0x009c
            java.lang.String r6 = r7.l     // Catch:{ Exception -> 0x0107 }
            if (r6 == 0) goto L_0x009c
            java.lang.String r6 = r7.l     // Catch:{ Exception -> 0x0107 }
            boolean r6 = r5.equals(r6)     // Catch:{ Exception -> 0x0107 }
            if (r6 == 0) goto L_0x009c
            r8 = 0
            if (r0 != r4) goto L_0x0081
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            java.lang.String r0 = "handleRespMsg CODE_D2Expired:"
            r9.<init>(r0)     // Catch:{ Exception -> 0x0107 }
            r9.append(r5)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.util.QLog.i(r1, r9)     // Catch:{ Exception -> 0x0107 }
            r7.m = r8     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.util.GuestHelper r8 = com.tencent.qalsdk.util.GuestHelper.getInstance()     // Catch:{ Exception -> 0x0107 }
            r8.tlsRefreshID(r5, r2)     // Catch:{ Exception -> 0x0107 }
            return r2
        L_0x0081:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            java.lang.String r0 = "handleRespMsg CODE_D2 invalid:"
            r9.<init>(r0)     // Catch:{ Exception -> 0x0107 }
            r9.append(r5)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.util.QLog.i(r1, r9)     // Catch:{ Exception -> 0x0107 }
            r7.m = r8     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.util.GuestHelper r8 = com.tencent.qalsdk.util.GuestHelper.getInstance()     // Catch:{ Exception -> 0x0107 }
            r8.generateAndLoginGuest()     // Catch:{ Exception -> 0x0107 }
            return r2
        L_0x009c:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r9.getMsfCommand()     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.sdk.MsfCommand r4 = com.tencent.qalsdk.sdk.MsfCommand.registerPush     // Catch:{ Exception -> 0x0107 }
            r5 = 0
            if (r0 != r4) goto L_0x00ab
            java.lang.String r0 = "handle server msg [register push] "
            com.tencent.qalsdk.util.QLog.d(r1, r3, r0)     // Catch:{ Exception -> 0x0107 }
            goto L_0x00cc
        L_0x00ab:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r9.getMsfCommand()     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.sdk.MsfCommand r4 = com.tencent.qalsdk.sdk.MsfCommand.unRegisterPush     // Catch:{ Exception -> 0x0107 }
            if (r0 != r4) goto L_0x00b9
            java.lang.String r0 = "handle server msg [unregister push] "
            com.tencent.qalsdk.util.QLog.d(r1, r3, r0)     // Catch:{ Exception -> 0x0107 }
            goto L_0x00cc
        L_0x00b9:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r9.getMsfCommand()     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.sdk.MsfCommand r3 = com.tencent.qalsdk.sdk.MsfCommand.registerCmdCallback     // Catch:{ Exception -> 0x0107 }
            if (r0 != r3) goto L_0x00c3
        L_0x00c1:
            r0 = 1
            goto L_0x00cd
        L_0x00c3:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r9.getMsfCommand()     // Catch:{ Exception -> 0x0107 }
            com.tencent.qalsdk.sdk.MsfCommand r3 = com.tencent.qalsdk.sdk.MsfCommand.resetCmdCallback     // Catch:{ Exception -> 0x0107 }
            if (r0 != r3) goto L_0x00cc
            goto L_0x00c1
        L_0x00cc:
            r0 = 0
        L_0x00cd:
            if (r0 != 0) goto L_0x0106
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.qalsdk.base.remote.IBaseActionListener> r0 = r7.y     // Catch:{ Exception -> 0x0107 }
            int r3 = r8.getAppSeq()     // Catch:{ Exception -> 0x0107 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0107 }
            boolean r0 = r0.containsKey(r3)     // Catch:{ Exception -> 0x0107 }
            if (r0 == 0) goto L_0x0105
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.qalsdk.base.remote.IBaseActionListener> r0 = r7.y     // Catch:{ RemoteException -> 0x00f3 }
            int r3 = r8.getAppSeq()     // Catch:{ RemoteException -> 0x00f3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ RemoteException -> 0x00f3 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ RemoteException -> 0x00f3 }
            com.tencent.qalsdk.base.remote.IBaseActionListener r0 = (com.tencent.qalsdk.base.remote.IBaseActionListener) r0     // Catch:{ RemoteException -> 0x00f3 }
            r0.onResponse(r8, r9)     // Catch:{ RemoteException -> 0x00f3 }
            goto L_0x00f7
        L_0x00f3:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ Exception -> 0x0107 }
        L_0x00f7:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.qalsdk.base.remote.IBaseActionListener> r9 = r7.y     // Catch:{ Exception -> 0x0107 }
            int r8 = r8.getAppSeq()     // Catch:{ Exception -> 0x0107 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0107 }
            r9.remove(r8)     // Catch:{ Exception -> 0x0107 }
            return r2
        L_0x0105:
            return r5
        L_0x0106:
            return r2
        L_0x0107:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "handle resp msg error "
            r9.<init>(r0)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.tencent.qalsdk.util.QLog.d(r1, r2, r9, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.sdk.c.a(com.tencent.qalsdk.base.remote.ToServiceMsg, com.tencent.qalsdk.base.remote.FromServiceMsg):boolean");
    }

    public final synchronized void a(Context context) {
        this.h = MsfSdkUtils.getProcessName(context);
        d dVar = new d(this);
        dVar.setName("handlerRespMsgThread");
        dVar.start();
        f32231a.a(537050853, "com.tencent.qalsdk.broadcast.qal", "com.tencent.qalsdk.service.QalService", this.h);
        v vVar = f32231a;
        vVar.f32279b.a();
        vVar.f32279b.b();
        if (this.n) {
            m();
            this.n = false;
        }
        if (this.o) {
            l();
            this.o = false;
        }
        if (this.p) {
            d(this.t);
            this.p = false;
        }
        try {
            this.f32237g = new l();
            if (!this.f32237g.a(context)) {
                QLog.e("CoreWrapper", 1, "MsfStore init fail");
            } else {
                this.x = true;
            }
        } catch (Exception e2) {
            QLog.e("CoreWrapper", 1, "MsfStore init error: " + e2);
        }
        this.w = new com.tencent.qalsdk.core.a();
        if (this.x) {
            this.w.a();
            for (String next : this.w.c().keySet()) {
                String str = this.w.c().get(next).f32223a;
                QLog.i("CoreWrapper", "store accout:" + next + ":" + str);
                this.j.put(next, str);
                this.i.put(str, next);
            }
        }
    }

    public static boolean a(FromServiceMsg fromServiceMsg, QALValueCallBack qALValueCallBack) {
        if (fromServiceMsg.isSuccess()) {
            return false;
        }
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        if (qALValueCallBack != null) {
            qALValueCallBack.onError(fromServiceMsg.getResultCode(), businessFailMsg);
        } else {
            QLog.e("CoreWrapper", 1, "checkError cb null:" + fromServiceMsg.getServiceCmd() + ":" + fromServiceMsg.getResultCode());
        }
        return true;
    }

    public final void a(String str, String str2, byte[] bArr, QALValueCallBack qALValueCallBack, long j2, boolean z2) {
        String str3;
        String str4 = str2;
        QALValueCallBack qALValueCallBack2 = qALValueCallBack;
        if (str != null) {
            if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                str3 = this.i.get(str);
                if (str3 == null || str3.length() == 0) {
                    if (qALValueCallBack2 != null) {
                        qALValueCallBack.onError(-10108, "invalid account:" + str);
                        return;
                    }
                    return;
                }
            } else {
                str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (!str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || str2.startsWith("wtlogin") || str2.equals("imopen_passthrough.callback_emp") || str2.equals("openim.im_push_report")) {
                if (qALValueCallBack2 != null) {
                    a(str3, str2, bArr, new f(this, qALValueCallBack), j2, false, false);
                    return;
                }
                a(str3, str2, bArr, (IBaseActionListener) null, j2, false, false);
            } else if (qALValueCallBack2 != null) {
                qALValueCallBack.onError(-10109, "id 0,but cmd:" + str2);
            }
        } else if (qALValueCallBack2 != null) {
            qALValueCallBack.onError(-10108, "account null");
        }
    }

    public final int a(String str, String str2, byte[] bArr, QALValueWithSeqCallBack qALValueWithSeqCallBack, long j2, boolean z2) {
        String str3;
        String str4 = str2;
        QALValueWithSeqCallBack qALValueWithSeqCallBack2 = qALValueWithSeqCallBack;
        if (str == null) {
            if (qALValueWithSeqCallBack2 != null) {
                qALValueWithSeqCallBack.onError(-10108, "account null", -1);
            }
            return -1;
        }
        if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            str3 = this.i.get(str);
            if (str3 == null || str3.length() == 0) {
                if (qALValueWithSeqCallBack2 != null) {
                    qALValueWithSeqCallBack.onError(-10108, "invalid account:" + str, -1);
                }
                return -1;
            }
        } else {
            str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !str2.startsWith("wtlogin") && !str2.equals("imopen_passthrough.callback_emp")) {
            if (qALValueWithSeqCallBack2 != null) {
                qALValueWithSeqCallBack.onError(-10109, "id 0,but cmd:" + str2, -1);
            }
            return -1;
        } else if (qALValueWithSeqCallBack2 == null) {
            return a(str3, str2, bArr, (IBaseActionListener) null, j2, false, z2);
        } else {
            return a(str3, str2, bArr, new g(this, qALValueWithSeqCallBack), j2, false, z2);
        }
    }

    public final int a(String str, String str2, byte[] bArr, IBaseActionListener iBaseActionListener, long j2, boolean z2, boolean z3) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", str, str2);
        toServiceMsg.putWupBuffer(n.a(bArr));
        toServiceMsg.setUinType(20);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        if (iBaseActionListener != null) {
            this.y.put(Integer.valueOf(toServiceMsg.getAppSeq()), iBaseActionListener);
        } else {
            toServiceMsg.setNeedCallback(false);
        }
        if (z2) {
            toServiceMsg.setIsHttpReq();
        }
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(j2);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        if (z3) {
            toServiceMsg.addAttribute("shortConnection", true);
        }
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        v.a().a(toServiceMsg);
        return toServiceMsg.getAppSeq();
    }

    private void a(QALCallBack qALCallBack, a aVar) {
        af afVar = new af();
        afVar.f34082d = 0;
        afVar.f34083e = 0;
        afVar.f34081c = 11;
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        afVar.f34080b = arrayList;
        afVar.f34084f = System.currentTimeMillis() / 1000;
        afVar.f34079a = aVar.f32224b;
        ToServiceMsg toServiceMsg = new ToServiceMsg("", afVar.f34079a, "im_open_status.stat_reg");
        toServiceMsg.setMsfCommand(MsfCommand.registerPush);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        if (qALCallBack != null) {
            this.y.put(Integer.valueOf(toServiceMsg.getAppSeq()), new h(this, aVar, qALCallBack));
        } else {
            toServiceMsg.setNeedCallback(false);
        }
        f fVar = new f();
        afVar.writeTo(fVar);
        toServiceMsg.addAttribute("to_push_pushRegisterInfo", fVar.a());
        f fVar2 = new f();
        aVar.writeTo(fVar2);
        toServiceMsg.addAttribute("to_set_accountInfo", fVar2.a());
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        QLog.i("CoreWrapper", "regPushNew |" + aVar.f32223a + ":" + toServiceMsg.getAppSeq());
        v.a().a(toServiceMsg);
        if (aVar.f32223a.equals(this.l)) {
            QALInitHelper.instance().sendMsg();
        }
    }

    public final void a(String str, QALCallBack qALCallBack) {
        String str2 = this.i.get(str);
        if (str2 != null && str2.length() != 0) {
            af afVar = new af();
            afVar.f34082d = 0;
            afVar.f34083e = 0;
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(1L);
            afVar.f34080b = arrayList;
            afVar.f34084f = 0;
            afVar.f34079a = str2;
            ToServiceMsg toServiceMsg = new ToServiceMsg("", afVar.f34079a, "im_open_status.stat_reg");
            toServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
            toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
            if (qALCallBack != null) {
                this.y.put(Integer.valueOf(toServiceMsg.getAppSeq()), new i(this, str, qALCallBack));
            } else {
                toServiceMsg.setNeedCallback(false);
            }
            f fVar = new f();
            afVar.writeTo(fVar);
            toServiceMsg.addAttribute("to_push_pushRegisterInfo", fVar.a());
            toServiceMsg.setAppId(537050853);
            toServiceMsg.setTimeout(this.v);
            toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
            MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
            v.a().a(toServiceMsg);
        } else if (qALCallBack != null) {
            qALCallBack.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "invalid account");
        }
    }

    public final synchronized void a(String str, String str2) {
        this.q = str;
        this.r = str2;
        if (f32231a.f32278a) {
            l();
        } else {
            this.o = true;
        }
    }

    public final void g() {
        for (String str : this.i.keySet()) {
            String str2 = this.i.get(str);
            if (str2 != null && str2.length() != 0) {
                af afVar = new af();
                afVar.f34082d = 0;
                afVar.f34083e = 0;
                afVar.f34081c = 95;
                ArrayList<Long> arrayList = new ArrayList<>();
                arrayList.add(1L);
                afVar.f34080b = arrayList;
                afVar.f34084f = System.currentTimeMillis() / 1000;
                afVar.f34079a = str2;
                ToServiceMsg toServiceMsg = new ToServiceMsg("", afVar.f34079a, "im_open_status.stat_reg");
                toServiceMsg.setMsfCommand(MsfCommand.qal_setAppStatus);
                toServiceMsg.setNeedCallback(false);
                f fVar = new f();
                afVar.writeTo(fVar);
                toServiceMsg.addAttribute("to_push_pushRegisterInfo", fVar.a());
                toServiceMsg.setAppId(537050853);
                toServiceMsg.setTimeout(this.v);
                toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
                MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
                toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
                v.a().a(toServiceMsg);
            } else {
                return;
            }
        }
    }

    private void l() {
        if (this.q != null && this.r != null) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.setAppEnv");
            toServiceMsg.setMsfCommand(MsfCommand.qal_setAppEnv);
            toServiceMsg.setNeedCallback(false);
            toServiceMsg.addAttribute("appVersion", this.q);
            toServiceMsg.addAttribute("appChannel", this.r);
            toServiceMsg.setAppId(537050853);
            toServiceMsg.setTimeout(this.v);
            toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
            MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
            toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
            v.a().a(toServiceMsg);
        }
    }

    public final void b(int i2) {
        QLog.setOutputLogLevel(i2);
        if (f32231a.f32278a) {
            m();
        } else {
            this.n = true;
        }
    }

    private void d(int i2) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.setServerEnv");
        toServiceMsg.setMsfCommand(MsfCommand.qal_setServerEnv);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.addAttribute("serverEnv", Integer.valueOf(i2));
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        v.a().a(toServiceMsg);
        this.s = i2;
    }

    private void m() {
        QLog.d("CoreWrapper", "set service loglevel:" + QLog.getOutputLogLevel());
        ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.setLogLevel");
        toServiceMsg.setMsfCommand(MsfCommand.qal_setLogLevel);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.addAttribute("logLevel", Integer.valueOf(QLog.getOutputLogLevel()));
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        v.a().a(toServiceMsg);
    }

    public final void h() {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "CliLogSvc.QalUpload");
        toServiceMsg.setMsfCommand(MsfCommand.qal_reportEvent);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        v.a().a(toServiceMsg);
    }

    /* access modifiers changed from: private */
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, QALCallBack qALCallBack) {
        String str = toServiceMsg != null ? (String) toServiceMsg.getAttribute("regPushReason") : null;
        QLog.d("CoreWrapper", 4, "pushReason:" + str + "cmd:" + fromServiceMsg.getMsfCommand() + ":" + fromServiceMsg.getServiceCmd());
        if (str != null && str.equals(ag.appRegister.toString()) && qALCallBack != null && !fromServiceMsg.isSuccess()) {
            if (fromServiceMsg.getResultCode() == 1002 && this.k.containsKey(fromServiceMsg.getUin())) {
                int intValue = this.k.get(fromServiceMsg.getUin()).intValue() + 1;
                if (intValue <= 2) {
                    String str2 = this.j.get(fromServiceMsg.getUin());
                    QLog.i("CoreWrapper", " retry register:" + str2 + ":" + intValue);
                    a e2 = e(str2);
                    if (e2 != null && !e2.f32224b.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        this.k.put(fromServiceMsg.getUin(), Integer.valueOf(intValue));
                        a(qALCallBack, e2);
                        return;
                    }
                }
            }
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            QLog.e("CoreWrapper", fromServiceMsg.getServiceCmd() + " failed:" + fromServiceMsg.getResultCode() + ":" + businessFailMsg + ":" + fromServiceMsg.getRequestSsoSeq());
            qALCallBack.onError(fromServiceMsg.getResultCode(), businessFailMsg);
        } else if (!fromServiceMsg.isSuccess()) {
            QLog.e("CoreWrapper", "regsiter error:" + fromServiceMsg.getResultCode());
        } else {
            byte[] a2 = a(fromServiceMsg);
            stat_reg.RspBody rspBody = new stat_reg.RspBody();
            if (a2 == null) {
                try {
                    QLog.i("CoreWrapper", "regsiter rspbody null,is already online. app cb ret ok ");
                    if (qALCallBack != null) {
                        qALCallBack.onSuccess();
                    }
                } catch (InvalidProtocolBufferMicroException e3) {
                    e3.printStackTrace();
                    if (qALCallBack != null) {
                        QLog.e("CoreWrapper", fromServiceMsg.getServiceCmd() + " failed:6001" + ": parse rspbody failed");
                        qALCallBack.onError(BaseConstants.ERR_PARSE_RESPONSE_FAILED, "reg push: parse rspbody failed");
                    }
                }
            } else {
                rspBody.mergeFrom(a2);
                if (fromServiceMsg.getMsfCommand().equals(MsfCommand.registerPush)) {
                    QLog.d("CoreWrapper", 4, "setRegisterStatus:" + a.REGISTERD);
                    a((String) fromServiceMsg.getAttribute("to_conn_apn"), (String) fromServiceMsg.getAttribute("to_conn_gateIP"), (String) fromServiceMsg.getAttribute("to_conn_serverIP"), ((Integer) fromServiceMsg.getAttribute("to_conn_radioType")).intValue());
                } else {
                    fromServiceMsg.getMsfCommand();
                    MsfCommand msfCommand = MsfCommand.unRegisterPush;
                }
                if (rspBody.enum_cmd_error_code.uint32_code.get() != 0) {
                    int i2 = rspBody.enum_cmd_error_code.uint32_code.get();
                    if (fromServiceMsg.getMsfCommand().equals(MsfCommand.registerPush) && i2 == 1002) {
                        i2 = 2103;
                        f32233c.a(fromServiceMsg.getUin(), (QALCallBack) new j(this));
                    }
                    if (qALCallBack != null) {
                        QLog.e("CoreWrapper", fromServiceMsg.getServiceCmd() + " failed. result:" + i2);
                        qALCallBack.onError(i2, rspBody.enum_cmd_error_code.bytes_err_msg.get().toStringUtf8());
                    } else if (toServiceMsg == null) {
                        QALUserStatusListener userStatusListener = QALSDKManager.getInstance().getUserStatusListener();
                        if (userStatusListener != null) {
                            userStatusListener.onRegisterFail(this.j.get(fromServiceMsg.getUin()), i2, rspBody.enum_cmd_error_code.bytes_err_msg.get().toStringUtf8());
                        }
                        QLog.e("CoreWrapper", fromServiceMsg.getServiceCmd() + "failed. getUserStatusListener. result:" + i2);
                    }
                } else if (qALCallBack != null) {
                    QLog.i("CoreWrapper", fromServiceMsg.getServiceCmd() + " succ,app cb return. " + fromServiceMsg.getMsfCommand());
                    qALCallBack.onSuccess();
                } else {
                    QALUserStatusListener userStatusListener2 = QALSDKManager.getInstance().getUserStatusListener();
                    if (userStatusListener2 != null) {
                        String str3 = this.j.get(fromServiceMsg.getUin());
                        if (str3 != null) {
                            QLog.i("CoreWrapper", 4, "getUserStatusListener.onRegisterSucc: " + str3);
                            userStatusListener2.onRegisterSucc(str3);
                        }
                    }
                }
            }
        }
    }

    private a e(String str) {
        QLog.d("CoreWrapper", 4, "getTicket:" + str);
        byte[] bArr = null;
        if (TLSLoginHelper.getInstance() == null) {
            QLog.e("CoreWrapper", 1, "tls sdk not init");
            return null;
        }
        Map<String, Object> sSOTicket = TLSLoginHelper.getInstance().getSSOTicket(str);
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        for (String next : sSOTicket.keySet()) {
            if ("tinyID".equals(next) || "identifier".equals(next)) {
                if ("tinyID".equals(next)) {
                    str2 = sSOTicket.get(next).toString();
                    QLog.i("CoreWrapper", 4, "user:" + str + String.format(" bind id:%s: %s", new Object[]{next, sSOTicket.get(next)}));
                }
            } else if ("A2".equals(next)) {
                bArr = (byte[]) sSOTicket.get(next);
            } else if ("D2".equals(next)) {
                bArr2 = (byte[]) sSOTicket.get(next);
            } else if ("D2Key".equals(next)) {
                bArr3 = (byte[]) sSOTicket.get(next);
            }
        }
        if (str.equals(this.l)) {
            this.m = str2;
        }
        this.j.put(str2, str);
        this.i.put(str, str2);
        d(str);
        a aVar = new a();
        aVar.f32223a = str;
        aVar.f32224b = str2;
        aVar.f32225c = bArr;
        aVar.f32226d = bArr2;
        aVar.f32227e = bArr3;
        aVar.f32228f = QALSDKManager.getInstance().getSdkAppId();
        return aVar;
    }

    public final void b(String str, QALCallBack qALCallBack) {
        a e2 = e(str);
        if (e2 == null || e2.f32224b.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            int i2 = Place.TYPE_POSTAL_TOWN;
            if (e2 == null) {
                i2 = Place.TYPE_POSTAL_CODE_PREFIX;
            }
            QLog.e("CoreWrapper", "tls sdk not init or no user:" + str + ":" + i2);
            qALCallBack.onError(i2, "tls sdk not init or no user");
            return;
        }
        this.k.put(e2.f32224b, 0);
        a(qALCallBack, e2);
    }

    public static void i() {
        try {
            v vVar = f32231a;
            vVar.f32279b.e();
            vVar.f32279b.f();
            f32231a.f32279b.c();
        } catch (Exception e2) {
            QLog.i("CoreWrapper", "stop error:" + e2.getMessage());
        }
    }

    public static long c(int i2) {
        if (i2 <= 13600) {
            return 10000;
        }
        double d2 = (double) (i2 / 13600);
        Double.isNaN(d2);
        return (long) ((d2 * 1.5d) + 10000.0d);
    }

    public final void a(String str, String[] strArr) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.setProxyList");
        toServiceMsg.setMsfCommand(MsfCommand.qal_setProxyList);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        toServiceMsg.addAttribute("sig", str);
        toServiceMsg.addAttribute("proxyList", TextUtils.join(";", strArr));
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        v.a().a(toServiceMsg);
    }

    public final void b(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.cancelProxyList");
        toServiceMsg.setMsfCommand(MsfCommand.qal_cancelProxyList);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        toServiceMsg.addAttribute("sig", str);
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        v.a().a(toServiceMsg);
    }

    public final void c(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("", AppEventsConstants.EVENT_PARAM_VALUE_NO, "qal.setDefineVersion");
        toServiceMsg.setMsfCommand(MsfCommand.qal_setDefineVersion);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        toServiceMsg.addAttribute("defineVersion", str);
        toServiceMsg.setAppId(537050853);
        toServiceMsg.setTimeout(this.v);
        toServiceMsg.setServiceName("com.tencent.qalsdk.service.QalService");
        MsfSdkUtils.addToMsgProcessName(this.h, toServiceMsg);
        v.a().a(toServiceMsg);
    }

    public final synchronized void a(QALInitListener qALInitListener) {
        this.z.putIfAbsent(qALInitListener, new Object());
    }

    public final synchronized ConcurrentHashMap<QALInitListener, Object> j() {
        return this.z;
    }

    public enum a {
        UNREGISTER,
        REGISTING,
        REGISTERD;

        static {
            UNREGISTER = new a("UNREGISTER", 0);
            REGISTING = new a("REGISTING", 1);
            REGISTERD = new a("REGISTERD", 2);
            a[] aVarArr = {UNREGISTER, REGISTING, REGISTERD};
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        aa aaVar = new aa();
        aaVar.f34057a = str;
        ArrayList<String> arrayList = new ArrayList<>();
        for (String add : cVar.u.keySet()) {
            arrayList.add(add);
        }
        arrayList.add("im_open_status.stat_forceoffline");
        aaVar.f34058b = arrayList;
        v.a().a(v.a().a(aaVar));
    }
}
