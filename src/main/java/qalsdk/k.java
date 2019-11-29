package qalsdk;

import android.os.SystemClock;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.base.a;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.NetConnInfoCenter;
import com.tencent.qalsdk.core.c;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static String f34157a = "";

    /* renamed from: b  reason: collision with root package name */
    public x f34158b;

    /* renamed from: c  reason: collision with root package name */
    public y f34159c = new y();

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f34160d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public int f34161e = 2;

    /* renamed from: f  reason: collision with root package name */
    long f34162f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f34163g = null;
    private j h;
    private String i = "";
    private long j = 0;
    private ArrayList<d> k = new ArrayList<>();
    private long l = 0;
    private long m = 0;
    private ArrayList<Object> n;
    private AtomicBoolean o;
    private boolean p;
    private boolean q;
    private j r;
    private boolean s;

    public k(j jVar, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.o = new AtomicBoolean(false);
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = z;
        this.h = jVar;
        this.r = new j(jVar, true, z);
        this.f34158b = new t(jVar);
    }

    public final boolean a() {
        return this.r.f34152e.get();
    }

    public final boolean b() {
        return this.r.f34153f.get();
    }

    public final boolean c() {
        return this.r.f34154g.get();
    }

    public final void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        if (this.l != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
            }
            long j2 = -1;
            long j3 = this.f34162f;
            long j4 = this.l;
            if (j3 >= j4) {
                j2 = j3 - j4;
            }
            long j5 = j2;
            if (fromServiceMsg.getAttribute("__timestamp_net2msf") == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
                }
                d();
                return;
            }
            ((Long) fromServiceMsg.getAttribute("__timestamp_net2msf")).longValue();
            if (toServiceMsg.getAttribute("__timestamp_msf2net") != null) {
                long longValue = ((Long) toServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                long longValue2 = ((Long) fromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - longValue;
                if ((longValue2 < 0 || longValue == 0) && QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag", 2, "nFirstPacketTimeElapse:" + longValue2 + " reset 0 now TIMESTAMP_NET2MSF:" + this.h.h.format(fromServiceMsg.getAttribute("__timestamp_net2msf")) + " TIMESTAMP_MSF2NET:" + this.h.h.format(toServiceMsg.getAttribute("__timestamp_msf2net")));
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
            }
            fromServiceMsg.getServiceCmd().equals("login.auth");
            if (this.k.size() > 0) {
                ArrayList<d> arrayList = this.k;
                arrayList.get(arrayList.size() - 1);
                this.h.i.a(1, j5, this.k, this.f34161e);
            }
            d();
            NetConnInfoCenter.onRecvFirstResp();
        }
    }

    public final void d() {
        this.m = 0;
        this.l = 0;
        this.f34162f = 0;
        this.k.clear();
        this.f34161e = 2;
        this.f34160d.set(false);
        try {
            if (!this.s) {
                this.h.i.c();
            }
            if (this.f34163g != null) {
                this.h.i().a(this.f34163g);
                this.f34163g = null;
            }
        } catch (Exception e2) {
            QLog.e("MSF.C.NetConnTag", 1, "resetConnAndRecvTimer: " + e2);
        }
    }

    public final void e() {
        if (this.l != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut Report now");
            }
            long j2 = -1;
            long j3 = this.f34162f;
            long j4 = this.l;
            if (j3 >= j4) {
                if (this.m == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
                    }
                    d();
                    return;
                }
                j2 = j3 - j4;
                this.h.f32187c.k.f34158b.c();
            }
            this.h.i.a(this.f34161e == 1 ? 2 : 3, j2, this.k, this.f34161e);
        } else if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut m_startConnectTime : " + this.l + "no need Report");
        }
        d();
    }

    public final void f() {
        if (this.k.size() > 0) {
            ArrayList<d> arrayList = this.k;
            d dVar = arrayList.get(arrayList.size() - 1);
            if (dVar != null) {
                dVar.f34129d = m.recvSsoDataError;
                dVar.f34128c = false;
            }
            g();
        }
    }

    private boolean k() throws Exception {
        boolean z;
        boolean z2 = false;
        if (this.i.length() > 0) {
            try {
                SystemClock.elapsedRealtime();
                this.l = System.currentTimeMillis();
                this.f34162f = this.l;
                d dVar = new d();
                dVar.f34127b = this.i;
                dVar.f34131f = m.j();
                dVar.i = 0;
                dVar.j = 0;
                a(c.a(this.i), true, dVar);
                new ArrayList().add(dVar);
                SystemClock.elapsedRealtime();
                return true;
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.i + " error " + e2, e2);
                }
                return false;
            }
        } else {
            SystemClock.elapsedRealtime();
            ArrayList arrayList = new ArrayList();
            this.l = System.currentTimeMillis();
            this.f34162f = this.l;
            if (!this.s) {
                this.h.i.b();
            }
            if (this.h.g().h().size() > 0 || this.h.g().i().size() > 0) {
                z2 = a(this.h.g().h(), this.h.g().i(), arrayList, false);
                SystemClock.elapsedRealtime();
                z = true;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag", 2, "sso list is null.");
                }
                z = false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d dVar2 = (d) it.next();
                if (dVar2.f34129d == m.connError_unreachable || dVar2.f34129d == m.connError_refused || dVar2.f34129d == m.connError_permission || dVar2.f34129d == m.connError_unresolved || dVar2.f34129d == m.connError_unknownhost || dVar2.f34129d == m.connError_noroute || dVar2.f34129d == m.recvSsoDataError) {
                    d();
                } else {
                    if (this.l == 0) {
                        this.l = dVar2.h;
                        this.f34162f = this.l;
                    }
                    if (this.f34163g == null) {
                        this.f34163g = this.h.i().a(this, 300000);
                    }
                    this.k.add(dVar2);
                }
            }
            if (!z2) {
                if (!this.s) {
                    if (m.c() && z) {
                        g();
                    }
                    NetConnInfoCenter.onOepnConnAllFailed();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (m.d() || (!m.c() && m.i() == null)) {
                        if (currentTimeMillis - a.f34049b < 60000) {
                            StringBuffer stringBuffer = new StringBuffer();
                            Iterator<c> it2 = this.h.g().h().iterator();
                            while (it2.hasNext()) {
                                c next = it2.next();
                                if (next != null) {
                                    stringBuffer.append(next.toString() + ";");
                                }
                            }
                            a.f34049b = 0;
                        }
                    } else if (currentTimeMillis - a.f34050c < 60000) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        Iterator<c> it3 = this.h.g().i().iterator();
                        while (it3.hasNext()) {
                            c next2 = it3.next();
                            if (next2 != null) {
                                stringBuffer2.append(next2.toString() + ";");
                            }
                        }
                        a.f34050c = 0;
                    }
                }
                return z2;
            }
            if (!this.s) {
                this.h.i.c();
                NetConnInfoCenter.checkConnInfo(this.h.k, true);
                if (!m.c()) {
                    m.a();
                }
            }
            return true;
        }
    }

    public final void g() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.j;
        if (j2 == 0 || elapsedRealtime - j2 > Long.parseLong(a.b())) {
            this.j = elapsedRealtime;
            StringBuffer stringBuffer = new StringBuffer();
            if (m.d()) {
                Iterator<c> it = this.h.g().h().iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    stringBuffer.append(next.b() + "//" + next.c() + ":" + next.d() + ",");
                }
            } else {
                Iterator<c> it2 = this.h.g().i().iterator();
                while (it2.hasNext()) {
                    c next2 = it2.next();
                    stringBuffer.append(next2.b() + "//" + next2.c() + ":" + next2.d() + ",");
                }
            }
            try {
                a aVar = this.h.f32189e;
                this.h.f32187c.g();
                aVar.a(this.h.f32190f, m.d(), stringBuffer.toString());
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag", 2, e2.toString(), e2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:205:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0283 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x00be A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x00cb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x016b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0176 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x028e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r12, java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r13, java.util.ArrayList<qalsdk.d> r14, boolean r15) {
        /*
            r11 = this;
            boolean r15 = com.tencent.qalsdk.util.QLog.isColorLevel()
            java.lang.String r0 = "MSF.C.NetConnTag"
            r1 = 2
            if (r15 == 0) goto L_0x000e
            java.lang.String r15 = "NetChanged selectAndConnect..."
            com.tencent.qalsdk.util.QLog.d(r0, r1, r15)
        L_0x000e:
            r15 = 1
            r2 = 0
        L_0x0010:
            r3 = 1
        L_0x0011:
            if (r3 == 0) goto L_0x02ad
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r3 == 0) goto L_0x001e
            java.lang.String r3 = "NetChanged start connect..."
            com.tencent.qalsdk.util.QLog.d(r0, r1, r3)
        L_0x001e:
            boolean r3 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x0291 }
            if (r3 != 0) goto L_0x0033
            boolean r3 = com.tencent.qalsdk.core.m.c()     // Catch:{ Exception -> 0x0291 }
            if (r3 != 0) goto L_0x0031
            java.lang.String r3 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x0291 }
            if (r3 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            java.lang.String r4 = "skip onetime socket unsupported endpoint: "
            if (r3 == 0) goto L_0x00d1
            r3 = 0
            r5 = 0
        L_0x003a:
            int r6 = r12.size()     // Catch:{ Exception -> 0x0291 }
            if (r3 >= r6) goto L_0x00ce
            java.lang.Object r6 = r12.get(r3)     // Catch:{ Exception -> 0x0291 }
            com.tencent.qalsdk.core.c r6 = (com.tencent.qalsdk.core.c) r6     // Catch:{ Exception -> 0x0291 }
            boolean r7 = r11.s     // Catch:{ Exception -> 0x0291 }
            if (r7 == 0) goto L_0x005f
            boolean r7 = r6.f32169a     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x005f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0291 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x0291 }
            r7.append(r6)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x0291 }
            com.tencent.qalsdk.util.QLog.w(r0, r15, r6)     // Catch:{ Exception -> 0x0291 }
            goto L_0x00cb
        L_0x005f:
            qalsdk.d r6 = r11.a((java.util.ArrayList<qalsdk.d>) r14, (boolean) r2, (com.tencent.qalsdk.core.c) r6)     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r7 = r6.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r8 = qalsdk.m.connSucc     // Catch:{ Exception -> 0x0291 }
            if (r7 != r8) goto L_0x0077
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            boolean r3 = r3.get()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x0076
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            r3.set(r2)     // Catch:{ Exception -> 0x0291 }
        L_0x0076:
            return r15
        L_0x0077:
            qalsdk.m r7 = r6.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r8 = qalsdk.m.connError_unreachable     // Catch:{ Exception -> 0x0291 }
            if (r7 != r8) goto L_0x0089
            int r3 = r3 + -1
            int r5 = r5 + 1
            if (r5 <= r1) goto L_0x009c
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            r3.set(r2)     // Catch:{ Exception -> 0x0291 }
            return r2
        L_0x0089:
            qalsdk.m r7 = r6.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r8 = qalsdk.m.connError_timeout     // Catch:{ Exception -> 0x0291 }
            if (r7 == r8) goto L_0x0095
            qalsdk.m r7 = r6.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r8 = qalsdk.m.connError_noroute     // Catch:{ Exception -> 0x0291 }
            if (r7 != r8) goto L_0x009c
        L_0x0095:
            if (r3 != 0) goto L_0x009c
            java.util.concurrent.atomic.AtomicBoolean r7 = r11.o     // Catch:{ Exception -> 0x0291 }
            r7.get()     // Catch:{ Exception -> 0x0291 }
        L_0x009c:
            int r7 = r6.f34132g     // Catch:{ Exception -> 0x0291 }
            if (r7 <= 0) goto L_0x00cb
            int r6 = r6.f34132g     // Catch:{ Exception -> 0x0291 }
            long r6 = (long) r6     // Catch:{ Exception -> 0x0291 }
            java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x0291 }
            boolean r6 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x0291 }
            if (r6 != 0) goto L_0x00bb
            boolean r6 = com.tencent.qalsdk.core.m.c()     // Catch:{ Exception -> 0x0291 }
            if (r6 != 0) goto L_0x00b9
            java.lang.String r6 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x0291 }
            if (r6 != 0) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            r6 = 0
            goto L_0x00bc
        L_0x00bb:
            r6 = 1
        L_0x00bc:
            if (r6 != 0) goto L_0x00cb
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x0010
            java.lang.String r3 = "NetChanged from wifi to mobile connect again"
            com.tencent.qalsdk.util.QLog.d(r0, r1, r3)     // Catch:{ Exception -> 0x0291 }
            goto L_0x0010
        L_0x00cb:
            int r3 = r3 + r15
            goto L_0x003a
        L_0x00ce:
            r3 = 0
            goto L_0x0011
        L_0x00d1:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0291 }
            r5 = 14
            if (r3 < r5) goto L_0x00de
            java.lang.String r3 = "http.proxyHost"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch:{ Exception -> 0x0291 }
            goto L_0x00e2
        L_0x00de:
            java.lang.String r3 = android.net.Proxy.getDefaultHost()     // Catch:{ Exception -> 0x0291 }
        L_0x00e2:
            java.lang.String r5 = "NetChanged from mobile to wifi connect again"
            if (r3 == 0) goto L_0x01fe
            r3 = 0
            r6 = 0
        L_0x00e8:
            int r7 = r13.size()     // Catch:{ Exception -> 0x0291 }
            if (r3 >= r7) goto L_0x0179
            java.lang.Object r7 = r13.get(r3)     // Catch:{ Exception -> 0x0291 }
            com.tencent.qalsdk.core.c r7 = (com.tencent.qalsdk.core.c) r7     // Catch:{ Exception -> 0x0291 }
            boolean r8 = r11.s     // Catch:{ Exception -> 0x0291 }
            if (r8 == 0) goto L_0x010d
            boolean r8 = r7.f32169a     // Catch:{ Exception -> 0x0291 }
            if (r8 != 0) goto L_0x010d
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0291 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x0291 }
            r8.append(r7)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x0291 }
            com.tencent.qalsdk.util.QLog.w(r0, r15, r7)     // Catch:{ Exception -> 0x0291 }
            goto L_0x0176
        L_0x010d:
            byte r8 = r7.f32170b     // Catch:{ Exception -> 0x0291 }
            if (r8 != r15) goto L_0x0176
            qalsdk.d r7 = r11.a((java.util.ArrayList<qalsdk.d>) r14, (boolean) r2, (com.tencent.qalsdk.core.c) r7)     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connSucc     // Catch:{ Exception -> 0x0291 }
            if (r8 != r9) goto L_0x0129
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            boolean r3 = r3.get()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x0128
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            r3.set(r2)     // Catch:{ Exception -> 0x0291 }
        L_0x0128:
            return r15
        L_0x0129:
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connError_unreachable     // Catch:{ Exception -> 0x0291 }
            if (r8 != r9) goto L_0x0136
            int r3 = r3 + -1
            int r6 = r6 + 1
            if (r6 <= r1) goto L_0x0149
            goto L_0x0179
        L_0x0136:
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connError_timeout     // Catch:{ Exception -> 0x0291 }
            if (r8 == r9) goto L_0x0142
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connError_noroute     // Catch:{ Exception -> 0x0291 }
            if (r8 != r9) goto L_0x0149
        L_0x0142:
            if (r3 != 0) goto L_0x0149
            java.util.concurrent.atomic.AtomicBoolean r8 = r11.o     // Catch:{ Exception -> 0x0291 }
            r8.get()     // Catch:{ Exception -> 0x0291 }
        L_0x0149:
            int r8 = r7.f34132g     // Catch:{ Exception -> 0x0291 }
            if (r8 <= 0) goto L_0x0176
            int r7 = r7.f34132g     // Catch:{ Exception -> 0x0291 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x0291 }
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x0291 }
            boolean r7 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x0168
            boolean r7 = com.tencent.qalsdk.core.m.c()     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x0166
            java.lang.String r7 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x0166
            goto L_0x0168
        L_0x0166:
            r7 = 0
            goto L_0x0169
        L_0x0168:
            r7 = 1
        L_0x0169:
            if (r7 == 0) goto L_0x0176
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x0174
            com.tencent.qalsdk.util.QLog.d(r0, r1, r5)     // Catch:{ Exception -> 0x0291 }
        L_0x0174:
            r3 = 1
            goto L_0x017a
        L_0x0176:
            int r3 = r3 + r15
            goto L_0x00e8
        L_0x0179:
            r3 = 0
        L_0x017a:
            r4 = 0
            r6 = 0
        L_0x017c:
            int r7 = r13.size()     // Catch:{ Exception -> 0x01f8 }
            if (r4 >= r7) goto L_0x0011
            java.lang.Object r7 = r13.get(r4)     // Catch:{ Exception -> 0x01f8 }
            com.tencent.qalsdk.core.c r7 = (com.tencent.qalsdk.core.c) r7     // Catch:{ Exception -> 0x01f8 }
            qalsdk.d r7 = r11.a((java.util.ArrayList<qalsdk.d>) r14, (boolean) r2, (com.tencent.qalsdk.core.c) r7)     // Catch:{ Exception -> 0x01f8 }
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x01f8 }
            qalsdk.m r9 = qalsdk.m.connSucc     // Catch:{ Exception -> 0x01f8 }
            if (r8 != r9) goto L_0x01a0
            java.util.concurrent.atomic.AtomicBoolean r4 = r11.o     // Catch:{ Exception -> 0x01f8 }
            boolean r4 = r4.get()     // Catch:{ Exception -> 0x01f8 }
            if (r4 == 0) goto L_0x019f
            java.util.concurrent.atomic.AtomicBoolean r4 = r11.o     // Catch:{ Exception -> 0x01f8 }
            r4.set(r2)     // Catch:{ Exception -> 0x01f8 }
        L_0x019f:
            return r15
        L_0x01a0:
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x01f8 }
            qalsdk.m r9 = qalsdk.m.connError_unreachable     // Catch:{ Exception -> 0x01f8 }
            if (r8 != r9) goto L_0x01b2
            int r4 = r4 + -1
            int r6 = r6 + 1
            if (r6 <= r1) goto L_0x01c5
            java.util.concurrent.atomic.AtomicBoolean r4 = r11.o     // Catch:{ Exception -> 0x01f8 }
            r4.set(r2)     // Catch:{ Exception -> 0x01f8 }
            return r2
        L_0x01b2:
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x01f8 }
            qalsdk.m r9 = qalsdk.m.connError_timeout     // Catch:{ Exception -> 0x01f8 }
            if (r8 == r9) goto L_0x01be
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x01f8 }
            qalsdk.m r9 = qalsdk.m.connError_noroute     // Catch:{ Exception -> 0x01f8 }
            if (r8 != r9) goto L_0x01c5
        L_0x01be:
            if (r4 != 0) goto L_0x01c5
            java.util.concurrent.atomic.AtomicBoolean r8 = r11.o     // Catch:{ Exception -> 0x01f8 }
            r8.get()     // Catch:{ Exception -> 0x01f8 }
        L_0x01c5:
            int r8 = r7.f34132g     // Catch:{ Exception -> 0x01f8 }
            if (r8 <= 0) goto L_0x01f6
            int r7 = r7.f34132g     // Catch:{ Exception -> 0x01f8 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x01f8 }
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x01f8 }
            boolean r7 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x01f8 }
            if (r7 != 0) goto L_0x01e4
            boolean r7 = com.tencent.qalsdk.core.m.c()     // Catch:{ Exception -> 0x01f8 }
            if (r7 != 0) goto L_0x01e2
            java.lang.String r7 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x01f8 }
            if (r7 != 0) goto L_0x01e2
            goto L_0x01e4
        L_0x01e2:
            r7 = 0
            goto L_0x01e5
        L_0x01e4:
            r7 = 1
        L_0x01e5:
            if (r7 == 0) goto L_0x01f6
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x01f2 }
            if (r3 == 0) goto L_0x0010
            com.tencent.qalsdk.util.QLog.d(r0, r1, r5)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x0010
        L_0x01f2:
            r3 = move-exception
            r4 = 1
            goto L_0x0293
        L_0x01f6:
            int r4 = r4 + r15
            goto L_0x017c
        L_0x01f8:
            r4 = move-exception
            r10 = r4
            r4 = r3
            r3 = r10
            goto L_0x0293
        L_0x01fe:
            r3 = 0
            r6 = 0
        L_0x0200:
            int r7 = r13.size()     // Catch:{ Exception -> 0x0291 }
            if (r3 >= r7) goto L_0x00ce
            java.lang.Object r7 = r13.get(r3)     // Catch:{ Exception -> 0x0291 }
            com.tencent.qalsdk.core.c r7 = (com.tencent.qalsdk.core.c) r7     // Catch:{ Exception -> 0x0291 }
            boolean r8 = r11.s     // Catch:{ Exception -> 0x0291 }
            if (r8 == 0) goto L_0x0224
            boolean r8 = r7.f32169a     // Catch:{ Exception -> 0x0291 }
            if (r8 != 0) goto L_0x0224
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0291 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x0291 }
            r8.append(r7)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x0291 }
            com.tencent.qalsdk.util.QLog.w(r0, r15, r7)     // Catch:{ Exception -> 0x0291 }
            goto L_0x028e
        L_0x0224:
            qalsdk.d r7 = r11.a((java.util.ArrayList<qalsdk.d>) r14, (boolean) r2, (com.tencent.qalsdk.core.c) r7)     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connSucc     // Catch:{ Exception -> 0x0291 }
            if (r8 != r9) goto L_0x023c
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            boolean r3 = r3.get()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x023b
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            r3.set(r2)     // Catch:{ Exception -> 0x0291 }
        L_0x023b:
            return r15
        L_0x023c:
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connError_unreachable     // Catch:{ Exception -> 0x0291 }
            if (r8 != r9) goto L_0x024e
            int r3 = r3 + -1
            int r6 = r6 + 1
            if (r6 <= r1) goto L_0x0261
            java.util.concurrent.atomic.AtomicBoolean r3 = r11.o     // Catch:{ Exception -> 0x0291 }
            r3.set(r2)     // Catch:{ Exception -> 0x0291 }
            return r2
        L_0x024e:
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connError_timeout     // Catch:{ Exception -> 0x0291 }
            if (r8 == r9) goto L_0x025a
            qalsdk.m r8 = r7.f34129d     // Catch:{ Exception -> 0x0291 }
            qalsdk.m r9 = qalsdk.m.connError_noroute     // Catch:{ Exception -> 0x0291 }
            if (r8 != r9) goto L_0x0261
        L_0x025a:
            if (r3 != 0) goto L_0x0261
            java.util.concurrent.atomic.AtomicBoolean r8 = r11.o     // Catch:{ Exception -> 0x0291 }
            r8.get()     // Catch:{ Exception -> 0x0291 }
        L_0x0261:
            int r8 = r7.f34132g     // Catch:{ Exception -> 0x0291 }
            if (r8 <= 0) goto L_0x028e
            int r7 = r7.f34132g     // Catch:{ Exception -> 0x0291 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x0291 }
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x0291 }
            boolean r7 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x0280
            boolean r7 = com.tencent.qalsdk.core.m.c()     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x027e
            java.lang.String r7 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x0291 }
            if (r7 != 0) goto L_0x027e
            goto L_0x0280
        L_0x027e:
            r7 = 0
            goto L_0x0281
        L_0x0280:
            r7 = 1
        L_0x0281:
            if (r7 == 0) goto L_0x028e
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x0010
            com.tencent.qalsdk.util.QLog.d(r0, r1, r5)     // Catch:{ Exception -> 0x0291 }
            goto L_0x0010
        L_0x028e:
            int r3 = r3 + r15
            goto L_0x0200
        L_0x0291:
            r3 = move-exception
            r4 = 0
        L_0x0293:
            boolean r5 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r5 == 0) goto L_0x02aa
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "selectAndConnect error "
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.tencent.qalsdk.util.QLog.d(r0, r1, r5, r3)
        L_0x02aa:
            r3 = r4
            goto L_0x0011
        L_0x02ad:
            java.util.concurrent.atomic.AtomicBoolean r12 = r11.o
            r12.get()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.k.a(java.util.concurrent.CopyOnWriteArrayList, java.util.concurrent.CopyOnWriteArrayList, java.util.ArrayList, boolean):boolean");
    }

    private d a(ArrayList<d> arrayList, boolean z, c cVar) {
        d dVar = new d();
        dVar.h = System.currentTimeMillis();
        dVar.f34127b = cVar.a();
        dVar.f34131f = m.j();
        dVar.i = 0;
        dVar.j = 0;
        a(cVar, z, dVar);
        arrayList.add(dVar);
        return dVar;
    }

    private void a(c cVar, boolean z, d dVar) {
        if (cVar.b().equalsIgnoreCase("http")) {
            this.r.a(cVar, 2048, 30000, new e(this.h), z, dVar);
        } else {
            this.r.a(cVar, 2048, 30000, new l(this.h), z, dVar);
        }
        f34157a = dVar.f34130e;
    }

    public final void a(CloseConnReason closeConnReason) {
        this.r.a(closeConnReason);
    }

    public final j h() {
        return this.r;
    }

    public final String i() {
        return this.i;
    }

    public final void a(String str) {
        if (str != null) {
            this.i = str;
            a.f32149c = true;
        }
    }

    public final void j() {
        this.i = "";
        a.f32149c = false;
    }

    public final boolean a(int i2, int i3, String str, String str2, MsfCommand msfCommand, String str3, int i4, byte[] bArr) throws Exception {
        if (!this.r.f34152e.get()) {
            k();
        }
        if (this.r.a(i2, i3, i4, str3, str, msfCommand, bArr) != -100) {
            if (!(this.m != 0 || this.l == 0 || this.f34162f == 0)) {
                this.m = System.currentTimeMillis();
            }
            return true;
        } else if (this.s) {
            return false;
        } else {
            k();
            if (this.r.a(i2, i3, i4, str3, str, msfCommand, bArr) == -100) {
                return false;
            }
            if (!(this.m != 0 || this.l == 0 || this.f34162f == 0)) {
                this.m = System.currentTimeMillis();
            }
            return true;
        }
    }
}
