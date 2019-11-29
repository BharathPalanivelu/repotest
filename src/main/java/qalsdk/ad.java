package qalsdk;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.g.a.a.f;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.imsdk.BaseConstants;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.config.NativeConfigStore;
import com.tencent.qalsdk.core.b;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.l;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.core.n;
import com.tencent.qalsdk.im_open.stat_hello;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.sdk.k;
import com.tencent.qalsdk.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class ad extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    static SimpleDateFormat f34069a = new SimpleDateFormat("dd HH:mm:ss");
    private static final int[] h = {1, 1, 1, 5, 5, 10, 10, 30, 30, 60, 60, IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR, IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR};
    private static int i = 0;
    private static AtomicInteger j = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, z> f34070b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Boolean> f34071c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    j f34072d;

    /* renamed from: e  reason: collision with root package name */
    String f34073e = "";

    /* renamed from: f  reason: collision with root package name */
    volatile Object f34074f = new Object();

    /* renamed from: g  reason: collision with root package name */
    long f34075g = 0;
    private ac k;
    private String l = "";
    private AlarmManager m;
    private a n = new a();
    private boolean o = false;
    private ConcurrentHashMap<String, PendingIntent> p = new ConcurrentHashMap<>();
    private Context q = null;
    /* access modifiers changed from: private */
    public String r = null;
    private Handler s = new ae(this);

    public ad(j jVar) {
        this.f34072d = jVar;
        this.k = new ac(this);
        this.n.setName("MsfCorePushManager");
    }

    public final void a(Context context, boolean z) {
        this.q = context;
        this.f34073e = Build.MODEL + "|" + Build.VERSION.RELEASE;
        this.l = MsfSdkUtils.getProcessName(context) + "_" + getClass().hashCode();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.l);
        context.registerReceiver(this, intentFilter);
        this.m = (AlarmManager) context.getSystemService("alarm");
        a(z);
    }

    public final synchronized void a() {
        if (!this.o) {
            this.n.start();
            this.o = true;
        }
    }

    public final boolean b() {
        for (String str : this.f34070b.keySet()) {
            z zVar = this.f34070b.get(str);
            if (zVar != null && zVar.f34212g != null && zVar.f34208c != 0) {
                return true;
            }
        }
        return false;
    }

    public final void a(ToServiceMsg toServiceMsg) {
        String str = com.tencent.qalsdk.config.a.d(toServiceMsg) + toServiceMsg.getUin();
        if (this.f34070b.containsKey(str)) {
            this.k.a(this.f34070b.get(str), toServiceMsg, false, ag.setAppQuit);
        }
    }

    public final void a(ToServiceMsg toServiceMsg, ag agVar) {
        if (this.s.hasMessages(1)) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "remove message handler mLoadPushInfoHandler");
            }
            this.s.removeMessages(1);
        }
        String d2 = com.tencent.qalsdk.config.a.d(toServiceMsg);
        String str = d2 + toServiceMsg.getUin();
        if (!this.f34070b.containsKey(str)) {
            this.f34070b.putIfAbsent(str, new z(d2));
        }
        QLog.d("MSF.C.PushManager", "recv regPush:" + d2 + ":" + str);
        af b2 = com.tencent.qalsdk.config.a.b(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "recv processName:" + str + " recv regPush ");
        }
        z zVar = this.f34070b.get(str);
        if (zVar == null || zVar.f34212g == null || zVar.f34208c == 0 || !zVar.f34212g.f34079a.equals(b2.f34079a) || zVar.f34212g.f34081c != b2.f34081c || zVar.f34212g.f34082d != b2.f34082d || zVar.f34212g.f34083e != b2.f34083e || zVar.f34212g.f34084f != b2.f34084f) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "handlerPush not found the same register Push  iStatus:" + b2.f34081c);
            }
            zVar.f34212g = b2;
            zVar.f34206a = toServiceMsg.getAppId();
            Iterator<Long> it = b2.f34080b.iterator();
            while (it.hasNext()) {
                zVar.f34208c = it.next().longValue() | zVar.f34208c;
            }
            c(str);
            this.k.a(zVar, toServiceMsg, false, agVar);
            return;
        }
        QLog.i("MSF.C.PushManager", 2, "handlerPush also register Push iStatus:" + b2.f34081c);
        FromServiceMsg c2 = com.tencent.qalsdk.config.a.c(toServiceMsg);
        c2.setMsgSuccess();
        this.f34072d.a(toServiceMsg, c2);
    }

    public final synchronized void a(String str) {
        String packageName = this.q.getPackageName();
        String str2 = packageName + str;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "recv processName:" + packageName + " recv KickedMsg ");
        }
        z zVar = this.f34070b.get(str2);
        if (!(zVar == null || zVar.f34212g == null || !zVar.f34212g.f34079a.equals(str))) {
            zVar.f34208c = 0;
            zVar.f34212g = null;
            c(str2);
        }
    }

    public final synchronized void a(af afVar, ToServiceMsg toServiceMsg) {
        String d2 = com.tencent.qalsdk.config.a.d(toServiceMsg);
        String str = d2 + toServiceMsg.getUin();
        QLog.d("MSF.C.PushManager", "recv unRegisterPush:" + d2 + ":" + str);
        if (!this.f34070b.containsKey(str)) {
            this.f34070b.putIfAbsent(str, new z(d2));
        }
        this.f34070b.get(str).f34212g = afVar;
        this.f34070b.get(str).f34206a = toServiceMsg.getAppId();
        this.f34070b.get(str).f34208c = 0;
        this.k.a(this.f34070b.get(str), toServiceMsg, true, ag.appRegister);
        if (this.f34070b.get(str).f34208c == 0) {
            this.f34070b.get(str).f34212g = null;
        }
        if (str != null && str.length() > 0) {
            l.a().removeConfig("app_push_info_" + str);
            QLog.i("MSF.C.PushManager", "remove AppPushInfo:" + str);
        }
    }

    public final synchronized void a(aa aaVar, ToServiceMsg toServiceMsg) {
        String d2 = com.tencent.qalsdk.config.a.d(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "recv processName:" + d2 + " appCmdCallbacker " + aaVar);
        }
        String str = d2 + toServiceMsg.getUin();
        if (!this.f34070b.containsKey(str)) {
            this.f34070b.putIfAbsent(str, new z(d2));
        }
        this.f34070b.get(str).h = aaVar;
        FromServiceMsg c2 = com.tencent.qalsdk.config.a.c(toServiceMsg);
        c2.setMsgSuccess();
        this.f34072d.a(toServiceMsg, c2);
        c(str);
    }

    public final synchronized void b(aa aaVar, ToServiceMsg toServiceMsg) {
        String d2 = com.tencent.qalsdk.config.a.d(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "recv processName:" + d2 + " recv unRegisterCmdCall ");
        }
        String str = d2 + toServiceMsg.getUin();
        if (!this.f34070b.containsKey(str)) {
            this.f34070b.putIfAbsent(str, new z(d2));
        }
        this.f34070b.get(str).h = aaVar;
        FromServiceMsg c2 = com.tencent.qalsdk.config.a.c(toServiceMsg);
        c2.setMsgSuccess();
        this.f34072d.a(toServiceMsg, c2);
        c(str);
    }

    private void c(String str) {
        z zVar = this.f34070b.get(str);
        zVar.i = String.valueOf(b.b(this.q));
        f fVar = new f();
        zVar.writeTo(fVar);
        try {
            NativeConfigStore a2 = l.a();
            a2.setConfig("app_push_info_" + str, com.g.a.a.a.a(fVar.a()));
        } catch (UnsatisfiedLinkError e2) {
            QLog.e("MSF.C.PushManager", "saveAppPushInfo exception,setConfig not find:" + e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0212  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "MSF.C.PushManager"
            com.tencent.qalsdk.config.NativeConfigStore r0 = com.tencent.qalsdk.core.l.a()     // Catch:{ Exception -> 0x0011 }
            java.lang.String r5 = "app_push_info_"
            java.lang.String[] r0 = r0.getConfigList(r5)     // Catch:{ Exception -> 0x0011 }
            goto L_0x0028
        L_0x0011:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "removeAccount exception:"
            r5.<init>(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.tencent.qalsdk.util.QLog.e(r3, r0)
            r0 = 0
        L_0x0028:
            r5 = 2
            r6 = 1
            if (r6 != r2) goto L_0x0077
            if (r0 != 0) goto L_0x0077
            int r7 = i
            r8 = 13
            if (r7 >= r8) goto L_0x0077
            boolean r7 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r7 == 0) goto L_0x0056
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "loop to loadAppPushInfo with time "
            r7.<init>(r8)
            int[] r8 = h
            int r9 = i
            r8 = r8[r9]
            r7.append(r8)
            java.lang.String r8 = " seconds"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.tencent.qalsdk.util.QLog.d(r3, r5, r7)
        L_0x0056:
            android.os.Handler r7 = r1.s
            android.os.Message r7 = r7.obtainMessage()
            r7.what = r6
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r20)
            r7.obj = r8
            android.os.Handler r8 = r1.s
            int[] r9 = h
            int r10 = i
            r9 = r9[r10]
            int r9 = r9 * 1000
            long r9 = (long) r9
            r8.sendMessageDelayed(r7, r9)
            int r7 = i
            int r7 = r7 + r6
            i = r7
        L_0x0077:
            android.content.Context r7 = r1.q
            int r7 = com.tencent.qalsdk.core.b.b(r7)
            int r8 = r0.length
            r9 = 0
            r10 = 0
        L_0x0080:
            if (r10 >= r8) goto L_0x022c
            r11 = r0[r10]
            byte[] r11 = com.g.a.a.a.a((java.lang.String) r11)
            qalsdk.z r12 = new qalsdk.z
            r12.<init>()
            com.g.a.a.e r13 = new com.g.a.a.e
            r13.<init>(r11)
            r12.readFrom(r13)
            r12.j = r9
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r13 = "load AppPushInfo:"
            r11.<init>(r13)
            java.lang.String r14 = r12.f34207b
            r11.append(r14)
            java.lang.String r14 = ":"
            r11.append(r14)
            qalsdk.af r15 = r12.f34212g
            r11.append(r15)
            r11.append(r14)
            r11.append(r7)
            java.lang.String r11 = r11.toString()
            com.tencent.qalsdk.util.QLog.d(r3, r11)
            qalsdk.af r11 = r12.f34212g
            if (r11 == 0) goto L_0x021c
            r15 = r10
            long r9 = r12.f34208c
            r16 = r12
            r11 = 0
            int r17 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r17 <= 0) goto L_0x0219
            r9 = -1
            java.lang.String r10 = " sendMsgPushRegister now"
            if (r7 != r9) goto L_0x00f0
            boolean r9 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r9 == 0) goto L_0x00e8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r6 = "nVersionCode:"
            r9.<init>(r6)
            r9.append(r7)
            r9.append(r10)
            java.lang.String r6 = r9.toString()
            com.tencent.qalsdk.util.QLog.d(r3, r5, r6)
        L_0x00e8:
            r18 = r0
            r9 = r16
        L_0x00ec:
            r0 = 1
            r4 = 2
            goto L_0x01c5
        L_0x00f0:
            java.lang.String r6 = java.lang.String.valueOf(r7)
            r9 = r16
            java.lang.String r11 = r9.i
            java.lang.String r12 = " no need sendMsgPushRegister"
            java.lang.String r4 = " bBoot:"
            java.lang.String r5 = "info.installVersion :"
            if (r11 == 0) goto L_0x017a
            java.lang.String r11 = r9.i
            boolean r11 = r11.equals(r6)
            r18 = r0
            java.lang.String r0 = " strVersionCode:"
            if (r11 == 0) goto L_0x012e
            boolean r4 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r4 == 0) goto L_0x00ec
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r5)
            java.lang.String r5 = r9.i
            r4.append(r5)
            r4.append(r0)
            r4.append(r6)
            r4.append(r10)
            java.lang.String r0 = r4.toString()
            r4 = 2
            com.tencent.qalsdk.util.QLog.d(r3, r4, r0)
            goto L_0x00ec
        L_0x012e:
            if (r2 == 0) goto L_0x0158
            boolean r11 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r11 == 0) goto L_0x00ec
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r5)
            java.lang.String r5 = r9.i
            r11.append(r5)
            r11.append(r4)
            r11.append(r2)
            r11.append(r0)
            r11.append(r6)
            r11.append(r10)
            java.lang.String r0 = r11.toString()
            r4 = 2
            com.tencent.qalsdk.util.QLog.d(r3, r4, r0)
            goto L_0x00ec
        L_0x0158:
            boolean r4 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r4 == 0) goto L_0x01c3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r5)
            java.lang.String r5 = r9.i
            r4.append(r5)
            r4.append(r0)
            r4.append(r6)
            r4.append(r12)
            java.lang.String r0 = r4.toString()
            r4 = 2
            com.tencent.qalsdk.util.QLog.d(r3, r4, r0)
            goto L_0x01c4
        L_0x017a:
            r18 = r0
            if (r2 == 0) goto L_0x01a1
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x00ec
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.lang.String r5 = r9.i
            r0.append(r5)
            r0.append(r4)
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r4 = 2
            com.tencent.qalsdk.util.QLog.d(r3, r4, r0)
            goto L_0x00ec
        L_0x01a1:
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r0 == 0) goto L_0x01c3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.lang.String r5 = r9.i
            r0.append(r5)
            r0.append(r4)
            r0.append(r2)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            r4 = 2
            com.tencent.qalsdk.util.QLog.d(r3, r4, r0)
            goto L_0x01c4
        L_0x01c3:
            r4 = 2
        L_0x01c4:
            r0 = 0
        L_0x01c5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r13)
            java.lang.String r6 = r9.f34207b
            r5.append(r6)
            r5.append(r14)
            qalsdk.af r6 = r9.f34212g
            java.lang.String r6 = r6.f34079a
            r5.append(r6)
            r5.append(r14)
            r5.append(r2)
            r5.append(r14)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.tencent.qalsdk.util.QLog.i(r3, r5)
            if (r0 == 0) goto L_0x0212
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qalsdk.z> r0 = r1.f34070b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r9.f34207b
            r5.append(r6)
            qalsdk.af r6 = r9.f34212g
            java.lang.String r6 = r6.f34079a
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.put(r5, r9)
            qalsdk.ac r0 = r1.k
            qalsdk.ag r5 = qalsdk.ag.msfBoot
            r6 = 0
            r10 = 0
            r0.a(r9, r6, r10, r5)
            goto L_0x0222
        L_0x0212:
            r6 = 0
            r10 = 0
            r11 = 0
            r9.f34208c = r11
            goto L_0x0222
        L_0x0219:
            r18 = r0
            goto L_0x021f
        L_0x021c:
            r18 = r0
            r15 = r10
        L_0x021f:
            r4 = 2
            r6 = 0
            r10 = 0
        L_0x0222:
            int r0 = r15 + 1
            r10 = r0
            r0 = r18
            r5 = 2
            r6 = 1
            r9 = 0
            goto L_0x0080
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.ad.a(boolean):void");
    }

    public final void c() {
        QLog.i("MSF.C.PushManager", "onConnResumed doQueryMsgPush");
        b((String) null);
    }

    private void f() {
        for (String put : this.f34071c.keySet()) {
            this.f34071c.put(put, false);
        }
    }

    public final void a(CloseConnReason closeConnReason) {
        QLog.i("MSF.C.PushManager", "onConnClosed send open conn,net is ok: " + m.b());
        f();
        this.f34075g = 0;
        if (closeConnReason == CloseConnReason.unRegisterPush) {
            QLog.i("MSF.C.PushManager", "onConnClosed by" + closeConnReason + ",no need auto retry conn");
        } else if (closeConnReason != CloseConnReason.readError || !m.d() || !t.f34201a.get()) {
            QLog.i("MSF.C.PushManager", "onConnClosed send open conn,net is ok: " + m.b());
            if (m.b()) {
                QLog.i("MSF.C.PushManager", "onConnClosed send open conn");
                if (this.f34072d.l == null) {
                    QLog.i("MSF.C.PushManager", "no conn,send open conn");
                    ToServiceMsg a2 = com.tencent.qalsdk.config.a.a("");
                    MsfSdkUtils.addToMsgProcessName("", a2);
                    j jVar = this.f34072d;
                    if (a2 != null) {
                        jVar.f32187c.a(a2);
                        a2.getRequestSsoSeq();
                    }
                }
            }
        } else {
            QLog.i("MSF.C.PushManager", "onConnClosed by " + closeConnReason + " need wifi auth,no need auto retry conn");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|7|8|9|(1:13)|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r3, android.content.Intent r4) {
        /*
            r2 = this;
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r3 == 0) goto L_0x0020
            r3 = 2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "alarm receive: "
            r0.<init>(r1)
            java.lang.String r1 = "appInfoKey"
            java.lang.String r1 = r4.getStringExtra(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "MSF.C.PushManager"
            com.tencent.qalsdk.util.QLog.d(r1, r3, r0)
        L_0x0020:
            java.lang.Object r3 = r2.f34074f
            monitor-enter(r3)
            java.lang.String r0 = "appInfoKey"
            java.lang.String r4 = r4.getStringExtra(r0)     // Catch:{ all -> 0x005c }
            r2.r = r4     // Catch:{ all -> 0x005c }
            java.lang.String r4 = r2.r     // Catch:{ Exception -> 0x0055 }
            if (r4 == 0) goto L_0x0055
            java.util.concurrent.ConcurrentHashMap<java.lang.String, android.app.PendingIntent> r4 = r2.p     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = r2.r     // Catch:{ Exception -> 0x0055 }
            boolean r4 = r4.containsKey(r0)     // Catch:{ Exception -> 0x0055 }
            if (r4 == 0) goto L_0x0055
            java.util.concurrent.ConcurrentHashMap<java.lang.String, android.app.PendingIntent> r4 = r2.p     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = r2.r     // Catch:{ Exception -> 0x0055 }
            r4.remove(r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r4 = "alarm"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0055 }
            java.lang.String r1 = "remove alarm in map:"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r1 = r2.r     // Catch:{ Exception -> 0x0055 }
            r0.append(r1)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0055 }
            com.tencent.qalsdk.util.QLog.d(r4, r0)     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            java.lang.Object r4 = r2.f34074f     // Catch:{ all -> 0x005c }
            r4.notify()     // Catch:{ all -> 0x005c }
            monitor-exit(r3)     // Catch:{ all -> 0x005c }
            return
        L_0x005c:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.ad.onReceive(android.content.Context, android.content.Intent):void");
    }

    public final void a(long j2, String str) {
        if (this.p.containsKey(str)) {
            QLog.e("alarm", "doRegistertAlarm hello repeat:" + str);
            return;
        }
        if (j2 < BaseConstants.DEFAULT_MSG_TIMEOUT) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime less than 30000,change to 30000.");
            }
            j2 = 30000;
        } else if (j2 > 3600000) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "queryPushIntervTime greater than 600000 ,change to 600000.");
            }
            j2 = 3600000;
        }
        Intent intent = new Intent(this.l);
        intent.setAction(this.l);
        intent.putExtra("appInfoKey", str);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.q, j.incrementAndGet(), intent, 0);
        this.p.put(str, broadcast);
        QLog.d("alarm", "put alarm in map:" + str);
        this.m = (AlarmManager) this.q.getSystemService("alarm");
        this.m.set(1, System.currentTimeMillis() + j2, broadcast);
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.PushManager", 2, "register " + str + ":" + this.l + " alarm alive send at " + f34069a.format(Long.valueOf(System.currentTimeMillis() + j2)));
        }
    }

    public final void a(FromServiceMsg fromServiceMsg) {
        boolean z;
        if (fromServiceMsg.getServiceCmd().equals("qalsdk.logUpload")) {
            new k().a(fromServiceMsg);
            return;
        }
        boolean z2 = false;
        for (String str : this.f34070b.keySet()) {
            z zVar = this.f34070b.get(str);
            if (zVar != null) {
                if (fromServiceMsg.getServiceCmd().equals("im_open_status.stat_queryhb")) {
                    if (a.f34048a) {
                        zVar.f34211f = this.f34072d.l;
                        zVar.f34210e = System.currentTimeMillis();
                        a(zVar, ag.serverPush);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.PushManager", 2, "recv push im_open_status.stat_queryhb, but do not support useAnyPacketAsPushHB ");
                    }
                } else if (fromServiceMsg.isSuccess()) {
                    if (zVar.h == null || !zVar.h.f34057a.equals(fromServiceMsg.getUin())) {
                        z = false;
                    } else {
                        Iterator<String> it = zVar.h.f34058b.iterator();
                        z = false;
                        while (it.hasNext()) {
                            if (it.next().equals(fromServiceMsg.getServiceCmd())) {
                                fromServiceMsg.addAttribute("resp_needBootApp", 1);
                                MsfSdkUtils.addFromMsgProcessName(zVar.f34207b, fromServiceMsg);
                                fromServiceMsg.setMsfCommand(MsfCommand.onRecvPushMsg);
                                this.f34072d.a((ToServiceMsg) null, fromServiceMsg);
                                QLog.d("MSF.C.PushManager", 2, "recv push " + zVar.f34207b + SQLBuilder.BLANK + fromServiceMsg);
                                z = true;
                            }
                        }
                    }
                    if (!z) {
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.PushManager", 2, "recv error onRecvPushMsg FromServiceMsg  " + fromServiceMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && QLog.isColorLevel()) {
            QLog.w("MSF.C.PushManager", 2, "found not handle push msg " + fromServiceMsg);
        }
    }

    public final long e() {
        long j2 = this.f34075g;
        if (j2 == 0) {
            return 270000;
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[SYNTHETIC, Splitter:B:17:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0224 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x023e A[Catch:{ Exception -> 0x0244 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r19, qalsdk.z r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            java.lang.String r3 = "MSF.C.PushManager"
            java.lang.String r4 = "|"
            if (r2 == 0) goto L_0x0252
            qalsdk.af r5 = r2.f34212g
            if (r5 == 0) goto L_0x0252
            long r5 = r2.f34208c
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0252
            r5 = 2
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r6 = r1.f34071c     // Catch:{ Exception -> 0x0244 }
            if (r6 == 0) goto L_0x0031
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r6 = r1.f34071c     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r10 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r10 = r10.f34079a     // Catch:{ Exception -> 0x0244 }
            java.lang.Object r6 = r6.get(r10)     // Catch:{ Exception -> 0x0244 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x0244 }
            if (r6 != 0) goto L_0x002c
            goto L_0x0031
        L_0x002c:
            boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x0244 }
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            java.lang.String r10 = ""
            if (r6 == 0) goto L_0x021d
            java.lang.String r6 = r2.f34211f     // Catch:{ Exception -> 0x0244 }
            if (r6 == 0) goto L_0x021d
            com.tencent.qalsdk.core.j r6 = r1.f34072d     // Catch:{ Exception -> 0x0244 }
            java.lang.String r6 = r6.l     // Catch:{ Exception -> 0x0244 }
            if (r6 == 0) goto L_0x021d
            java.lang.String r6 = r2.f34211f     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.core.j r11 = r1.f34072d     // Catch:{ Exception -> 0x0244 }
            java.lang.String r11 = r11.l     // Catch:{ Exception -> 0x0244 }
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0244 }
            if (r6 == 0) goto L_0x021d
            qalsdk.ac r6 = r1.k     // Catch:{ Exception -> 0x0244 }
            boolean r11 = qalsdk.a.f34048a     // Catch:{ Exception -> 0x0244 }
            java.lang.String r12 = "MSF.C.PushManager:PushCoder"
            if (r11 == 0) goto L_0x00bf
            qalsdk.ad r11 = r6.f34067b     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r13 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r13 = r13.f34079a     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.core.j r11 = r11.f34072d     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.core.a r11 = r11.c()     // Catch:{ Exception -> 0x0244 }
            long r13 = r11.b((java.lang.String) r13)     // Catch:{ Exception -> 0x0244 }
            qalsdk.ad r11 = r6.f34067b     // Catch:{ Exception -> 0x0244 }
            r15 = r10
            long r9 = r11.f34075g     // Catch:{ Exception -> 0x0244 }
            int r16 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r16 != 0) goto L_0x0071
            r9 = 270000(0x41eb0, double:1.333977E-318)
            goto L_0x0073
        L_0x0071:
            long r9 = r11.f34075g     // Catch:{ Exception -> 0x0244 }
        L_0x0073:
            long r13 = r13 + r9
            boolean r9 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0244 }
            if (r9 == 0) goto L_0x00ab
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            java.lang.String r10 = "sendMsgPushQuery, check time now="
            r9.<init>(r10)     // Catch:{ Exception -> 0x0244 }
            java.text.SimpleDateFormat r10 = f34069a     // Catch:{ Exception -> 0x0244 }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0244 }
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r10 = r10.format(r11)     // Catch:{ Exception -> 0x0244 }
            r9.append(r10)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r10 = ", shouldSendQueryTime="
            r9.append(r10)     // Catch:{ Exception -> 0x0244 }
            java.text.SimpleDateFormat r10 = f34069a     // Catch:{ Exception -> 0x0244 }
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r10 = r10.format(r11)     // Catch:{ Exception -> 0x0244 }
            r9.append(r10)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.util.QLog.d(r12, r5, r9)     // Catch:{ Exception -> 0x0244 }
        L_0x00ab:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0244 }
            int r11 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x00c0
            qalsdk.ad r2 = r6.f34067b     // Catch:{ Exception -> 0x0244 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0244 }
            long r13 = r13 - r6
            r2.a((long) r13, (java.lang.String) r0)     // Catch:{ Exception -> 0x0244 }
            goto L_0x0243
        L_0x00bf:
            r15 = r10
        L_0x00c0:
            qalsdk.af r9 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            if (r9 == 0) goto L_0x0252
            java.lang.String r9 = "hellotest"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            r10.<init>()     // Catch:{ Exception -> 0x0244 }
            r10.append(r0)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = ":"
            r10.append(r0)     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r0 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r0.f34079a     // Catch:{ Exception -> 0x0244 }
            r10.append(r0)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = ":false"
            r10.append(r0)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.util.QLog.i(r9, r0)     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r0 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r0.f34079a     // Catch:{ Exception -> 0x0244 }
            if (r0 == 0) goto L_0x01f2
            long r9 = r2.f34208c     // Catch:{ Exception -> 0x0244 }
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x01f2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            r0.<init>()     // Catch:{ Exception -> 0x0244 }
            qalsdk.ad r7 = r6.f34067b     // Catch:{ Exception -> 0x0244 }
            java.lang.String r7 = r7.f34073e     // Catch:{ Exception -> 0x0244 }
            r0.append(r7)     // Catch:{ Exception -> 0x0244 }
            r0.append(r4)     // Catch:{ Exception -> 0x0244 }
            int r7 = com.tencent.qalsdk.core.m.j()     // Catch:{ Exception -> 0x0244 }
            r0.append(r7)     // Catch:{ Exception -> 0x0244 }
            r0.append(r4)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r7 = com.tencent.qalsdk.core.m.i()     // Catch:{ Exception -> 0x0244 }
            r0.append(r7)     // Catch:{ Exception -> 0x0244 }
            r0.append(r4)     // Catch:{ Exception -> 0x0244 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0244 }
            long r9 = r6.f34068c     // Catch:{ Exception -> 0x0244 }
            long r7 = r7 - r9
            r0.append(r7)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.im_open.stat_hello$ReqBody r0 = new com.tencent.qalsdk.im_open.stat_hello$ReqBody     // Catch:{ Exception -> 0x0244 }
            r0.<init>()     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBUInt32Field r7 = r0.uint32_status     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r8 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            int r8 = r8.f34081c     // Catch:{ Exception -> 0x0244 }
            r7.set(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBBytesField r7 = r0.bytes_guid     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.core.j.a()     // Catch:{ Exception -> 0x0244 }
            byte[] r8 = com.tencent.qalsdk.core.j.d()     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.ByteStringMicro r8 = com.tencent.mobileqq.pb.ByteStringMicro.copyFrom(r8)     // Catch:{ Exception -> 0x0244 }
            r7.set(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBStringField r7 = r0.str_dev_name     // Catch:{ Exception -> 0x0244 }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0244 }
            r7.set(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBStringField r7 = r0.str_dev_type     // Catch:{ Exception -> 0x0244 }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0244 }
            r7.set(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBStringField r7 = r0.str_os_ver     // Catch:{ Exception -> 0x0244 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0244 }
            r7.set(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBStringField r7 = r0.str_firmware_ver     // Catch:{ Exception -> 0x0244 }
            r8 = r15
            r7.set(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.mobileqq.pb.PBUInt32Field r7 = r0.vender_appid     // Catch:{ Exception -> 0x0244 }
            r9 = 0
            r7.set(r9)     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.config.NativeConfigStore r7 = com.tencent.qalsdk.core.l.a()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r9 = "IMOPEN_STAT_DEFINE_VERSION"
            java.lang.String r7 = r7.getConfig(r9)     // Catch:{ Exception -> 0x0244 }
            if (r7 == 0) goto L_0x0173
            com.tencent.mobileqq.pb.PBStringField r9 = r0.str_define_version     // Catch:{ Exception -> 0x0244 }
            r9.set(r7)     // Catch:{ Exception -> 0x0244 }
        L_0x0173:
            com.tencent.qalsdk.base.remote.ToServiceMsg r7 = new com.tencent.qalsdk.base.remote.ToServiceMsg     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r9 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r9 = r9.f34079a     // Catch:{ Exception -> 0x0244 }
            java.lang.String r10 = qalsdk.ac.f34065a     // Catch:{ Exception -> 0x0244 }
            r7.<init>(r8, r9, r10)     // Catch:{ Exception -> 0x0244 }
            byte[] r0 = r0.toByteArray()     // Catch:{ Exception -> 0x0244 }
            int r8 = r2.f34206a     // Catch:{ Exception -> 0x0244 }
            r7.setAppId(r8)     // Catch:{ Exception -> 0x0244 }
            r8 = 10000(0x2710, double:4.9407E-320)
            r7.setTimeout(r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.sdk.MsfCommand r8 = com.tencent.qalsdk.sdk.MsfCommand._msf_queryPush     // Catch:{ Exception -> 0x0244 }
            r7.setMsfCommand(r8)     // Catch:{ Exception -> 0x0244 }
            int r8 = com.tencent.qalsdk.core.j.b()     // Catch:{ Exception -> 0x0244 }
            r7.setRequestSsoSeq(r8)     // Catch:{ Exception -> 0x0244 }
            byte[] r0 = com.tencent.qalsdk.core.n.a((byte[]) r0)     // Catch:{ Exception -> 0x0244 }
            r7.putWupBuffer(r0)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r2.f34207b     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.sdk.MsfSdkUtils.addToMsgProcessName(r0, r7)     // Catch:{ Exception -> 0x0244 }
            qalsdk.ad r0 = r6.f34067b     // Catch:{ Exception -> 0x01b1 }
            com.tencent.qalsdk.core.j r0 = r0.f34072d     // Catch:{ Exception -> 0x01b1 }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ Exception -> 0x01b1 }
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r7)     // Catch:{ Exception -> 0x01b1 }
            r7.getRequestSsoSeq()     // Catch:{ Exception -> 0x01b1 }
            goto L_0x01c4
        L_0x01b1:
            r0 = move-exception
            r6 = 1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            java.lang.String r8 = "query push error "
            r7.<init>(r8)     // Catch:{ Exception -> 0x0244 }
            r7.append(r0)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.util.QLog.w(r12, r6, r7, r0)     // Catch:{ Exception -> 0x0244 }
        L_0x01c4:
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0244 }
            if (r0 == 0) goto L_0x0243
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            java.lang.String r6 = "send "
            r0.<init>(r6)     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r6 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r6 = r6.f34079a     // Catch:{ Exception -> 0x0244 }
            r0.append(r6)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r6 = " query push id "
            r0.append(r6)     // Catch:{ Exception -> 0x0244 }
            long r6 = r2.f34208c     // Catch:{ Exception -> 0x0244 }
            r0.append(r6)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r2 = " model:"
            r0.append(r2)     // Catch:{ Exception -> 0x0244 }
            r0.append(r4)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.util.QLog.d(r12, r5, r0)     // Catch:{ Exception -> 0x0244 }
            goto L_0x0243
        L_0x01f2:
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Exception -> 0x0244 }
            if (r0 == 0) goto L_0x0252
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            java.lang.String r4 = "pushUin is "
            r0.<init>(r4)     // Catch:{ Exception -> 0x0244 }
            qalsdk.af r4 = r2.f34212g     // Catch:{ Exception -> 0x0244 }
            java.lang.String r4 = r4.f34079a     // Catch:{ Exception -> 0x0244 }
            r0.append(r4)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r4 = ", queryPushId is "
            r0.append(r4)     // Catch:{ Exception -> 0x0244 }
            long r6 = r2.f34208c     // Catch:{ Exception -> 0x0244 }
            r0.append(r6)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r2 = ". no query"
            r0.append(r2)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.util.QLog.d(r12, r5, r0)     // Catch:{ Exception -> 0x0244 }
            goto L_0x0252
        L_0x021d:
            r8 = r10
            com.tencent.qalsdk.core.j r0 = r1.f34072d     // Catch:{ Exception -> 0x0244 }
            java.lang.String r0 = r0.l     // Catch:{ Exception -> 0x0244 }
            if (r0 != 0) goto L_0x023e
            java.lang.String r0 = "doQueryMsgPush no conn,send open conn"
            com.tencent.qalsdk.util.QLog.i(r3, r0)     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.base.remote.ToServiceMsg r0 = com.tencent.qalsdk.config.a.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.sdk.MsfSdkUtils.addToMsgProcessName(r8, r0)     // Catch:{ Exception -> 0x0244 }
            com.tencent.qalsdk.core.j r2 = r1.f34072d     // Catch:{ Exception -> 0x0244 }
            if (r0 != 0) goto L_0x0235
            goto L_0x0252
        L_0x0235:
            com.tencent.qalsdk.core.n r2 = r2.f32187c     // Catch:{ Exception -> 0x0244 }
            r2.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r0)     // Catch:{ Exception -> 0x0244 }
            r0.getRequestSsoSeq()     // Catch:{ Exception -> 0x0244 }
            goto L_0x0252
        L_0x023e:
            qalsdk.ag r0 = qalsdk.ag.msfByNetChange     // Catch:{ Exception -> 0x0244 }
            r1.a((qalsdk.z) r2, (qalsdk.ag) r0)     // Catch:{ Exception -> 0x0244 }
        L_0x0243:
            return
        L_0x0244:
            r0 = move-exception
            boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r2 == 0) goto L_0x0252
            java.lang.String r2 = r0.toString()
            com.tencent.qalsdk.util.QLog.w(r3, r5, r2, r0)
        L_0x0252:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.ad.a(java.lang.String, qalsdk.z):void");
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) {
        if (str == null) {
            for (String next : this.f34070b.keySet()) {
                a(next, this.f34070b.get(next));
            }
            return;
        }
        z zVar = this.f34070b.get(str);
        if (zVar != null) {
            a(str, zVar);
        }
    }

    private void a(z zVar, ag agVar) {
        if (zVar.f34208c > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.PushManager", 2, "send " + zVar.f34207b + " push register, pushId is " + zVar.f34208c);
            }
            this.k.a(zVar, (ToServiceMsg) null, false, agVar);
            return;
        }
        QLog.d("MSF.C.PushManager", 2, zVar.f34207b + " queryPushId is " + zVar.f34208c + " ,skip register.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x033e A[Catch:{ Throwable -> 0x0362 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0352 A[Catch:{ Throwable -> 0x0362 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013d A[Catch:{ Throwable -> 0x0362 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0150 A[Catch:{ Throwable -> 0x0362 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0165 A[SYNTHETIC, Splitter:B:56:0x0165] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02d1 A[Catch:{ Throwable -> 0x0362 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02e9 A[Catch:{ Throwable -> 0x0362 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0321 A[Catch:{ Throwable -> 0x0362 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.qalsdk.base.remote.ToServiceMsg r19, com.tencent.qalsdk.base.remote.FromServiceMsg r20) {
        /*
            r18 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = ":"
            java.lang.String r4 = "hellotest"
            java.lang.String r5 = "regPushReason"
            r6 = r18
            qalsdk.ac r7 = r6.k
            java.lang.String r0 = "__timestamp_app2msf"
            java.lang.Object r0 = r1.getAttribute(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            r0.longValue()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = com.tencent.qalsdk.config.a.d(r19)
            r0.append(r8)
            java.lang.String r8 = r19.getUin()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            boolean r0 = r20.isSuccess()     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r12 = "MSF.C.PushManager:PushCoder"
            r15 = 0
            if (r0 != 0) goto L_0x0040
            r0 = -1
            r9 = -1
            r11 = 0
            r13 = -1
            goto L_0x014e
        L_0x0040:
            byte[] r0 = r20.getWupBuffer()     // Catch:{ Throwable -> 0x0362 }
            if (r0 == 0) goto L_0x0148
            byte[] r0 = r20.getWupBuffer()     // Catch:{ Throwable -> 0x0362 }
            int r0 = r0.length     // Catch:{ Throwable -> 0x0362 }
            r9 = 5
            if (r0 >= r9) goto L_0x0050
            goto L_0x0148
        L_0x0050:
            com.tencent.qalsdk.im_open.stat_reg$RspBody r9 = new com.tencent.qalsdk.im_open.stat_reg$RspBody     // Catch:{ Throwable -> 0x0362 }
            r9.<init>()     // Catch:{ Throwable -> 0x0362 }
            byte[] r0 = r20.getWupBuffer()     // Catch:{ Exception -> 0x0131 }
            int r13 = r0.length     // Catch:{ Exception -> 0x0131 }
            r14 = 4
            int r13 = r13 - r14
            byte[] r13 = new byte[r13]     // Catch:{ Exception -> 0x0131 }
            int r10 = r0.length     // Catch:{ Exception -> 0x0131 }
            int r10 = r10 - r14
            java.lang.System.arraycopy(r0, r14, r13, r15, r10)     // Catch:{ Exception -> 0x0131 }
            r9.mergeFrom((byte[]) r13)     // Catch:{ Exception -> 0x0131 }
            com.tencent.mobileqq.pb.PBStringField r0 = r9.str_client_ip     // Catch:{ Exception -> 0x0131 }
            java.lang.String r0 = r0.get()     // Catch:{ Exception -> 0x0131 }
            com.tencent.qalsdk.core.n.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0131 }
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r9.uint32_client_port     // Catch:{ Exception -> 0x0131 }
            int r0 = r0.get()     // Catch:{ Exception -> 0x0131 }
            com.tencent.qalsdk.core.n.a((int) r0)     // Catch:{ Exception -> 0x0131 }
            com.tencent.mobileqq.pb.PBStringField r0 = r9.str_client_ip     // Catch:{ Exception -> 0x0131 }
            java.lang.String r0 = r0.get()     // Catch:{ Exception -> 0x0131 }
            com.tencent.qalsdk.core.j.f32186b = r0     // Catch:{ Exception -> 0x0131 }
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r9.uint32_update_flag     // Catch:{ Exception -> 0x0131 }
            int r0 = r0.get()     // Catch:{ Exception -> 0x0131 }
            byte r10 = (byte) r0
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r9.uint32_timestamp     // Catch:{ Exception -> 0x012a }
            int r0 = r0.get()     // Catch:{ Exception -> 0x012a }
            long r14 = (long) r0
            com.tencent.qalsdk.im_open.common$CmdErrorCode r0 = r9.enum_cmd_error_code     // Catch:{ Exception -> 0x0125 }
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r0.uint32_code     // Catch:{ Exception -> 0x0125 }
            int r0 = r0.get()     // Catch:{ Exception -> 0x0125 }
            byte r13 = (byte) r0
            if (r13 == 0) goto L_0x00cf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0121 }
            java.lang.String r11 = "register pushresp error code: "
            r0.<init>(r11)     // Catch:{ Exception -> 0x0121 }
            com.tencent.qalsdk.im_open.common$CmdErrorCode r11 = r9.enum_cmd_error_code     // Catch:{ Exception -> 0x0121 }
            com.tencent.mobileqq.pb.PBUInt32Field r11 = r11.uint32_code     // Catch:{ Exception -> 0x0121 }
            int r11 = r11.get()     // Catch:{ Exception -> 0x0121 }
            r0.append(r11)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r11 = "msg:"
            r0.append(r11)     // Catch:{ Exception -> 0x0121 }
            com.tencent.mobileqq.pb.PBStringField r11 = r9.str_errmsg     // Catch:{ Exception -> 0x0121 }
            java.lang.String r11 = r11.get()     // Catch:{ Exception -> 0x0121 }
            r0.append(r11)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r11 = "sso seq:"
            r0.append(r11)     // Catch:{ Exception -> 0x0121 }
            int r11 = r20.getRequestSsoSeq()     // Catch:{ Exception -> 0x0121 }
            r0.append(r11)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0121 }
            r11 = 1
            com.tencent.qalsdk.util.QLog.e(r12, r11, r0)     // Catch:{ Exception -> 0x0121 }
            r0 = 0
            goto L_0x00d0
        L_0x00cf:
            r0 = 1
        L_0x00d0:
            com.tencent.mobileqq.pb.PBUInt32Field r11 = r9.uint32_server_time     // Catch:{ Exception -> 0x0121 }
            int r11 = r11.get()     // Catch:{ Exception -> 0x0121 }
            r17 = r10
            long r10 = (long) r11
            com.tencent.qalsdk.core.NetConnInfoCenter.handleGetServerTimeResp(r10)     // Catch:{ Exception -> 0x011f }
            boolean r10 = com.tencent.qalsdk.util.QLog.isDevelopLevel()     // Catch:{ Exception -> 0x011f }
            if (r10 == 0) goto L_0x0116
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f }
            java.lang.String r11 = "pushresp servertime is "
            r10.<init>(r11)     // Catch:{ Exception -> 0x011f }
            com.tencent.mobileqq.pb.PBUInt32Field r11 = r9.uint32_server_time     // Catch:{ Exception -> 0x011f }
            int r11 = r11.get()     // Catch:{ Exception -> 0x011f }
            r10.append(r11)     // Catch:{ Exception -> 0x011f }
            qalsdk.ad r11 = r7.f34067b     // Catch:{ Exception -> 0x011f }
            com.tencent.qalsdk.core.j r11 = r11.f34072d     // Catch:{ Exception -> 0x011f }
            java.text.SimpleDateFormat r11 = r11.h     // Catch:{ Exception -> 0x011f }
            r16 = r0
            com.tencent.mobileqq.pb.PBUInt32Field r0 = r9.uint32_server_time     // Catch:{ Exception -> 0x011f }
            int r0 = r0.get()     // Catch:{ Exception -> 0x011f }
            int r0 = r0 * 1000
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x011f }
            java.lang.String r0 = r11.format(r0)     // Catch:{ Exception -> 0x011f }
            r10.append(r0)     // Catch:{ Exception -> 0x011f }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x011f }
            r10 = 4
            com.tencent.qalsdk.util.QLog.d(r12, r10, r0)     // Catch:{ Exception -> 0x011f }
            goto L_0x0118
        L_0x0116:
            r16 = r0
        L_0x0118:
            r11 = r9
            r9 = r14
            r15 = r16
            r0 = r17
            goto L_0x014e
        L_0x011f:
            r0 = move-exception
            goto L_0x0137
        L_0x0121:
            r0 = move-exception
            r17 = r10
            goto L_0x0137
        L_0x0125:
            r0 = move-exception
            r17 = r10
            r13 = -1
            goto L_0x0137
        L_0x012a:
            r0 = move-exception
            r17 = r10
            r13 = -1
            r14 = -1
            goto L_0x0137
        L_0x0131:
            r0 = move-exception
            r13 = -1
            r14 = -1
            r17 = -1
        L_0x0137:
            boolean r10 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x0362 }
            if (r10 == 0) goto L_0x0143
            java.lang.String r10 = "decodeRegisterPushResp error"
            r11 = 2
            com.tencent.qalsdk.util.QLog.d(r12, r11, r10, r0)     // Catch:{ Throwable -> 0x0362 }
        L_0x0143:
            r11 = r9
            r9 = r14
            r0 = r17
            goto L_0x014d
        L_0x0148:
            r0 = -1
            r9 = -1
            r11 = 0
            r13 = -1
        L_0x014d:
            r15 = 0
        L_0x014e:
            if (r1 == 0) goto L_0x0161
            java.util.HashMap r14 = r19.getAttributes()     // Catch:{ Throwable -> 0x0362 }
            boolean r14 = r14.containsKey(r5)     // Catch:{ Throwable -> 0x0362 }
            if (r14 == 0) goto L_0x0161
            java.lang.Object r5 = r1.getAttribute(r5)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Throwable -> 0x0362 }
            goto L_0x0163
        L_0x0161:
            java.lang.String r5 = "unknown"
        L_0x0163:
            if (r15 == 0) goto L_0x02d1
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0362 }
            r7.f34068c = r14     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfCommand r14 = r19.getMsfCommand()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfCommand r15 = com.tencent.qalsdk.sdk.MsfCommand._msf_UnRegPush     // Catch:{ Throwable -> 0x0362 }
            if (r14 != r15) goto L_0x017a
            java.lang.String r0 = "handlerPush unregister push succ"
            r9 = 1
            com.tencent.qalsdk.util.QLog.d(r12, r9, r0)     // Catch:{ Throwable -> 0x0362 }
            goto L_0x019c
        L_0x017a:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r15 = "handlerPush register push succ  bUpdateFlag:"
            r14.<init>(r15)     // Catch:{ Throwable -> 0x0362 }
            r14.append(r0)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = " timeStamp:"
            r14.append(r0)     // Catch:{ Throwable -> 0x0362 }
            r14.append(r9)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = " cReplyCode:"
            r14.append(r0)     // Catch:{ Throwable -> 0x0362 }
            r14.append(r13)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = r14.toString()     // Catch:{ Throwable -> 0x0362 }
            r9 = 1
            com.tencent.qalsdk.util.QLog.d(r12, r9, r0)     // Catch:{ Throwable -> 0x0362 }
        L_0x019c:
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qalsdk.z> r0 = r0.f34070b     // Catch:{ Throwable -> 0x0362 }
            boolean r0 = r0.containsKey(r8)     // Catch:{ Throwable -> 0x0362 }
            if (r0 != 0) goto L_0x01b8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r1 = "onRecePushRegisterResp no key:"
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0362 }
            r0.append(r8)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.util.QLog.e(r12, r0)     // Catch:{ Throwable -> 0x0362 }
            return
        L_0x01b8:
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qalsdk.z> r0 = r0.f34070b     // Catch:{ Throwable -> 0x0362 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ Throwable -> 0x0362 }
            qalsdk.z r0 = (qalsdk.z) r0     // Catch:{ Throwable -> 0x0362 }
            if (r0 == 0) goto L_0x02c0
            r9 = 0
            r0.j = r9     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r9 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.core.j r9 = r9.f34072d     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r9 = r9.l     // Catch:{ Throwable -> 0x0362 }
            r0.f34211f = r9     // Catch:{ Throwable -> 0x0362 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0362 }
            r0.f34210e = r9     // Catch:{ Throwable -> 0x0362 }
            if (r11 == 0) goto L_0x0283
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r10 = "recv register push resp.iInterval="
            r9.<init>(r10)     // Catch:{ Throwable -> 0x0362 }
            com.tencent.mobileqq.pb.PBUInt32Field r10 = r11.uint32_hello_interval     // Catch:{ Throwable -> 0x0362 }
            int r10 = r10.get()     // Catch:{ Throwable -> 0x0362 }
            r9.append(r10)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r10 = ", queryIntervTime="
            r9.append(r10)     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r10 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            long r12 = r10.f34075g     // Catch:{ Throwable -> 0x0362 }
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x01fa
            r12 = 270000(0x41eb0, double:1.333977E-318)
            goto L_0x01fc
        L_0x01fa:
            long r12 = r10.f34075g     // Catch:{ Throwable -> 0x0362 }
        L_0x01fc:
            r9.append(r12)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r10 = ", next query time is "
            r9.append(r10)     // Catch:{ Throwable -> 0x0362 }
            java.text.SimpleDateFormat r10 = f34069a     // Catch:{ Throwable -> 0x0362 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.mobileqq.pb.PBUInt32Field r14 = r11.uint32_hello_interval     // Catch:{ Throwable -> 0x0362 }
            int r14 = r14.get()     // Catch:{ Throwable -> 0x0362 }
            int r14 = r14 * 1000
            long r14 = (long) r14     // Catch:{ Throwable -> 0x0362 }
            long r12 = r12 + r14
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r10 = r10.format(r12)     // Catch:{ Throwable -> 0x0362 }
            r9.append(r10)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x0362 }
            r10 = 2
            com.tencent.qalsdk.util.QLog.i(r4, r10, r9)     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r9 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            com.tencent.mobileqq.pb.PBUInt32Field r10 = r11.uint32_hello_interval     // Catch:{ Throwable -> 0x0362 }
            int r10 = r10.get()     // Catch:{ Throwable -> 0x0362 }
            int r10 = r10 * 1000
            long r10 = (long) r10     // Catch:{ Throwable -> 0x0362 }
            r9.f34075g = r10     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfCommand r9 = r19.getMsfCommand()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfCommand r10 = com.tencent.qalsdk.sdk.MsfCommand._msf_RegPush     // Catch:{ Throwable -> 0x0362 }
            if (r9 != r10) goto L_0x02c0
            qalsdk.af r9 = r0.f34212g     // Catch:{ Throwable -> 0x0362 }
            if (r9 == 0) goto L_0x02c0
            qalsdk.ad r9 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r9 = r9.f34071c     // Catch:{ Throwable -> 0x0362 }
            qalsdk.af r10 = r0.f34212g     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r10 = r10.f34079a     // Catch:{ Throwable -> 0x0362 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ Throwable -> 0x0362 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ Throwable -> 0x0362 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0362 }
            r10.<init>()     // Catch:{ Throwable -> 0x0362 }
            qalsdk.af r0 = r0.f34212g     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = r0.f34079a     // Catch:{ Throwable -> 0x0362 }
            r10.append(r0)     // Catch:{ Throwable -> 0x0362 }
            r10.append(r3)     // Catch:{ Throwable -> 0x0362 }
            r10.append(r9)     // Catch:{ Throwable -> 0x0362 }
            r10.append(r3)     // Catch:{ Throwable -> 0x0362 }
            r10.append(r8)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = r10.toString()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.util.QLog.i(r4, r0)     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r3 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            long r9 = r3.f34075g     // Catch:{ Throwable -> 0x0362 }
            r11 = 0
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x027d
            r11 = 270000(0x41eb0, double:1.333977E-318)
            goto L_0x027f
        L_0x027d:
            long r11 = r3.f34075g     // Catch:{ Throwable -> 0x0362 }
        L_0x027f:
            r0.a((long) r11, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0362 }
            goto L_0x02c0
        L_0x0283:
            boolean r0 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ Throwable -> 0x0362 }
            if (r0 == 0) goto L_0x02ab
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r3 = "recv null register push resp, use default intervTime "
            r0.<init>(r3)     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r3 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            long r9 = r3.f34075g     // Catch:{ Throwable -> 0x0362 }
            r13 = 0
            int r4 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x029e
            r3 = 270000(0x41eb0, double:1.333977E-318)
            goto L_0x02a0
        L_0x029e:
            long r3 = r3.f34075g     // Catch:{ Throwable -> 0x0362 }
        L_0x02a0:
            r0.append(r3)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0362 }
            r3 = 2
            com.tencent.qalsdk.util.QLog.i(r12, r3, r0)     // Catch:{ Throwable -> 0x0362 }
        L_0x02ab:
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r3 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            long r9 = r3.f34075g     // Catch:{ Throwable -> 0x0362 }
            r11 = 0
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x02bb
            r11 = 270000(0x41eb0, double:1.333977E-318)
            goto L_0x02bd
        L_0x02bb:
            long r11 = r3.f34075g     // Catch:{ Throwable -> 0x0362 }
        L_0x02bd:
            r0.a((long) r11, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0362 }
        L_0x02c0:
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r0 = r0.f34071c     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r3 = r19.getUin()     // Catch:{ Throwable -> 0x0362 }
            r4 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Throwable -> 0x0362 }
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x0362 }
            goto L_0x02e1
        L_0x02d1:
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r0 = r0.f34071c     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r3 = r19.getUin()     // Catch:{ Throwable -> 0x0362 }
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Throwable -> 0x0362 }
            r0.put(r3, r4)     // Catch:{ Throwable -> 0x0362 }
        L_0x02e1:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r19.getMsfCommand()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfCommand r3 = com.tencent.qalsdk.sdk.MsfCommand._msf_RegPush     // Catch:{ Throwable -> 0x0362 }
            if (r0 != r3) goto L_0x0321
            com.tencent.qalsdk.sdk.MsfCommand r0 = com.tencent.qalsdk.sdk.MsfCommand.registerPush     // Catch:{ Throwable -> 0x0362 }
            r2.setMsfCommand(r0)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = "to_conn_apn"
            java.lang.String r3 = qalsdk.c.a()     // Catch:{ Throwable -> 0x0362 }
            r2.addAttribute(r0, r3)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = "to_conn_radioType"
            int r3 = qalsdk.c.b()     // Catch:{ Throwable -> 0x0362 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Throwable -> 0x0362 }
            r2.addAttribute(r0, r3)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = "to_conn_serverIP"
            qalsdk.ad r3 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.core.j r3 = r3.f34072d     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.core.n r3 = r3.f32187c     // Catch:{ Throwable -> 0x0362 }
            qalsdk.k r3 = r3.k     // Catch:{ Throwable -> 0x0362 }
            qalsdk.j r3 = r3.h()     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r3 = r3.a()     // Catch:{ Throwable -> 0x0362 }
            r2.addAttribute(r0, r3)     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r0 = "to_conn_gateIP"
            java.lang.String r3 = com.tencent.qalsdk.core.j.f32186b     // Catch:{ Throwable -> 0x0362 }
            r2.addAttribute(r0, r3)     // Catch:{ Throwable -> 0x0362 }
            goto L_0x0336
        L_0x0321:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r19.getMsfCommand()     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfCommand r3 = com.tencent.qalsdk.sdk.MsfCommand._msf_UnRegPush     // Catch:{ Throwable -> 0x0362 }
            if (r0 != r3) goto L_0x032f
            com.tencent.qalsdk.sdk.MsfCommand r0 = com.tencent.qalsdk.sdk.MsfCommand.unRegisterPush     // Catch:{ Throwable -> 0x0362 }
            r2.setMsfCommand(r0)     // Catch:{ Throwable -> 0x0362 }
            goto L_0x0336
        L_0x032f:
            com.tencent.qalsdk.sdk.MsfCommand r0 = r19.getMsfCommand()     // Catch:{ Throwable -> 0x0362 }
            r2.setMsfCommand(r0)     // Catch:{ Throwable -> 0x0362 }
        L_0x0336:
            java.lang.String r0 = "appRegister"
            boolean r0 = r5.equals(r0)     // Catch:{ Throwable -> 0x0362 }
            if (r0 == 0) goto L_0x0352
            java.util.HashMap r0 = r19.getAttributes()     // Catch:{ Throwable -> 0x0362 }
            java.lang.String r3 = "to_srcCmd"
            boolean r0 = r0.containsKey(r3)     // Catch:{ Throwable -> 0x0362 }
            if (r0 == 0) goto L_0x0361
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.core.j r0 = r0.f34072d     // Catch:{ Throwable -> 0x0362 }
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r1, (com.tencent.qalsdk.base.remote.FromServiceMsg) r2)     // Catch:{ Throwable -> 0x0362 }
            goto L_0x0378
        L_0x0352:
            java.lang.String r0 = com.tencent.qalsdk.config.a.d(r19)     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.sdk.MsfSdkUtils.addFromMsgProcessName(r0, r2)     // Catch:{ Throwable -> 0x0362 }
            qalsdk.ad r0 = r7.f34067b     // Catch:{ Throwable -> 0x0362 }
            com.tencent.qalsdk.core.j r0 = r0.f34072d     // Catch:{ Throwable -> 0x0362 }
            r1 = 0
            r0.a((com.tencent.qalsdk.base.remote.ToServiceMsg) r1, (com.tencent.qalsdk.base.remote.FromServiceMsg) r2)     // Catch:{ Throwable -> 0x0362 }
        L_0x0361:
            return
        L_0x0362:
            r0 = move-exception
            qalsdk.ad r1 = r7.f34067b
            qalsdk.ad r2 = r7.f34067b
            long r11 = r2.f34075g
            r2 = 0
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0372
            r11 = 270000(0x41eb0, double:1.333977E-318)
        L_0x0372:
            r1.a((long) r11, (java.lang.String) r8)
            r0.printStackTrace()
        L_0x0378:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.ad.a(com.tencent.qalsdk.base.remote.ToServiceMsg, com.tencent.qalsdk.base.remote.FromServiceMsg):void");
    }

    public final void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j2;
        long j3;
        ac acVar = this.k;
        String str = com.tencent.qalsdk.config.a.d(toServiceMsg) + toServiceMsg.getUin();
        if (!acVar.f34067b.f34070b.containsKey(str)) {
            QLog.e("MSF.C.PushManager:PushCoder", "onQueryPushResp no key:" + str);
        } else if (acVar.f34067b.f34070b.get(str) != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    stat_hello.RspBody rspBody = new stat_hello.RspBody();
                    byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                    byte[] bArr = new byte[(wupBuffer.length - 4)];
                    System.arraycopy(wupBuffer, 4, bArr, 0, wupBuffer.length - 4);
                    rspBody.mergeFrom(bArr);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb = new StringBuilder("recv query push resp.iInterval=");
                        sb.append(rspBody.uint32_hello_interval.get());
                        sb.append(", queryIntervTime=");
                        ad adVar = acVar.f34067b;
                        if (adVar.f34075g == 0) {
                            j3 = 270000;
                        } else {
                            j3 = adVar.f34075g;
                        }
                        sb.append(j3);
                        sb.append(", next query time is ");
                        sb.append(f34069a.format(Long.valueOf(System.currentTimeMillis() + ((long) (rspBody.uint32_hello_interval.get() * 1000)))));
                        QLog.d("MSF.C.PushManager:PushCoder", 2, sb.toString());
                    }
                    acVar.f34067b.f34075g = (long) (rspBody.uint32_hello_interval.get() * 1000);
                    ad adVar2 = acVar.f34067b;
                    ad adVar3 = acVar.f34067b;
                    if (adVar3.f34075g == 0) {
                        j2 = 270000;
                    } else {
                        j2 = adVar3.f34075g;
                    }
                    adVar2.a(j2, str);
                    n.a(rspBody.str_client_ip.get());
                    return;
                }
                acVar.f34067b.a(180000, str);
            } catch (Throwable th) {
                th.printStackTrace();
                ad adVar4 = acVar.f34067b;
                long j4 = acVar.f34067b.f34075g;
                if (j4 == 0) {
                    j4 = 270000;
                }
                adVar4.a(j4, str);
            }
        }
    }

    public final void a(String str, long j2) {
        this.f34072d.c().a(str, j2);
    }

    class a extends Thread {
        a() {
        }

        public final void run() {
            while (true) {
                synchronized (ad.this.f34074f) {
                    try {
                        ad.this.f34074f.wait();
                        ad.this.b(ad.this.r);
                    } catch (InterruptedException e2) {
                        if (QLog.isColorLevel()) {
                            QLog.e("MSF.C.PushManager", 2, e2.toString(), e2);
                        }
                    }
                }
            }
        }
    }

    public final void d() {
        for (String next : this.p.keySet()) {
            PendingIntent pendingIntent = this.p.get(next);
            if (pendingIntent != null) {
                this.m.cancel(pendingIntent);
                QLog.e("alarm", "conn reopen,cancel alarm in map:" + next);
            }
            this.p.remove(next);
        }
        f();
        QLog.i("MSF.C.PushManager", "onConnOpened doQueryMsgPush");
        b((String) null);
    }
}
