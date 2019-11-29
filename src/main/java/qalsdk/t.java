package qalsdk;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.l;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import qalsdk.n;

public final class t extends x {

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f34191c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile int f34192d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f34193e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f34194f;

    /* renamed from: g  reason: collision with root package name */
    private String f34195g;
    private HashMap<String, w> h = new HashMap<>();
    private n.a i = new u(this);
    private Handler j = new v(this);

    static /* synthetic */ int a(t tVar, int i2) {
        if (i2 != -3) {
            return (i2 == -2 || i2 == -1 || i2 != 0) ? -1 : 0;
        }
        return -2;
    }

    public t(j jVar) {
        boolean z = false;
        f();
        if (m.d()) {
            String f2 = m.f();
            if (!TextUtils.isEmpty(f2) && f2.equals(m.f())) {
                z = true;
            }
            if (z) {
                a(m.f());
            }
        }
    }

    public final void a(String str) {
        QLog.d("WifiDetector", 1, "WIFI detect onWifiConnected!");
        w wVar = this.h.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (wVar == null) {
            w wVar2 = this.h.get(str);
            if (wVar2 != null) {
                a(str, wVar2.f34199b, false);
            }
            c(str);
        } else if (!wVar.f34200c) {
            c(str);
        } else if (currentTimeMillis - wVar.f34199b >= 7200000) {
            c(str);
        } else {
            a(str, 7200000 - (currentTimeMillis - wVar.f34199b));
        }
    }

    public final void a() {
        QLog.d("WifiDetector", 1, "WIFI detect onWifiDisconnected!");
        this.j.removeMessages(1000);
    }

    public final void b() {
        QLog.d("WifiDetector", 1, "WIFI detect onWifiAllConnFailed!");
        c(m.f());
    }

    public final void c() {
        QLog.d("WifiDetector", 1, "WIFI detect onWifiConnFake!");
        c(m.f());
    }

    public final void b(String str) {
        f34201a.set(false);
        QLog.d("WifiDetector", 1, "WIFI detect onWifiConnSucc!");
        w wVar = this.h.get(str);
        if (wVar != null) {
            a(str, wVar.f34199b, true);
        }
    }

    public final void d() {
        int i2 = this.f34193e;
        if (!m.d()) {
            QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NONE");
        } else if (i2 == 0) {
            QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OK");
            f34201a.set(false);
        } else {
            QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NEED_AUTH");
            FromServiceMsg fromServiceMsg = new FromServiceMsg(m.f32200a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_netNeedSignon");
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.setMsfCommand(MsfCommand.onNetNeedSignon);
            fromServiceMsg.addAttribute("signonurl", this.f34195g);
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            f34201a.set(true);
            m.f32200a.a((ToServiceMsg) null, fromServiceMsg);
        }
        this.f34191c.set(false);
        this.f34192d = 0;
        this.f34193e = -1;
        this.f34194f = null;
        this.f34195g = "";
    }

    private void a(String str, long j2) {
        this.j.removeMessages(1000);
        Message obtainMessage = this.j.obtainMessage();
        obtainMessage.obj = str;
        this.j.sendMessageDelayed(obtainMessage, j2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: qalsdk.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: qalsdk.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: qalsdk.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: qalsdk.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: qalsdk.p} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(java.lang.String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = com.tencent.qalsdk.core.m.d()     // Catch:{ all -> 0x00c3 }
            r1 = 1
            if (r0 != 0) goto L_0x0011
            java.lang.String r13 = "WifiDetector"
            java.lang.String r0 = "WIFI detect start failed, wifi is not connected!"
            com.tencent.qalsdk.util.QLog.d(r13, r1, r0)     // Catch:{ all -> 0x00c3 }
            monitor-exit(r12)
            return
        L_0x0011:
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x00c3 }
            r2 = 0
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = com.tencent.qalsdk.core.m.f()     // Catch:{ all -> 0x00c3 }
            boolean r0 = r13.equals(r0)     // Catch:{ all -> 0x00c3 }
            if (r0 != 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 != 0) goto L_0x0031
            java.lang.String r13 = "WifiDetector"
            java.lang.String r0 = "WIFI detect start failed, ssid is invalid!"
            com.tencent.qalsdk.util.QLog.d(r13, r1, r0)     // Catch:{ all -> 0x00c3 }
            monitor-exit(r12)
            return
        L_0x0031:
            java.util.concurrent.atomic.AtomicBoolean r0 = r12.f34191c     // Catch:{ all -> 0x00c3 }
            boolean r0 = r0.compareAndSet(r2, r1)     // Catch:{ all -> 0x00c3 }
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = "WifiDetector"
            java.lang.String r2 = "WIFI detect start failed, there is detect running!"
            com.tencent.qalsdk.util.QLog.d(r0, r1, r2)     // Catch:{ all -> 0x00c3 }
            r0 = 60000(0xea60, double:2.9644E-319)
            r12.a((java.lang.String) r13, (long) r0)     // Catch:{ all -> 0x00c3 }
            monitor-exit(r12)
            return
        L_0x0048:
            java.lang.String r0 = "WifiDetector"
            java.lang.String r3 = "WIFI detect started!"
            com.tencent.qalsdk.util.QLog.d(r0, r1, r3)     // Catch:{ all -> 0x00c3 }
            r12.f34195g = r13     // Catch:{ all -> 0x00c3 }
            java.lang.String r0 = r12.f34195g     // Catch:{ all -> 0x00c3 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c3 }
            java.util.HashMap<java.lang.String, qalsdk.w> r5 = r12.h     // Catch:{ all -> 0x00c3 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x00c3 }
            qalsdk.w r5 = (qalsdk.w) r5     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x0067
            boolean r5 = r5.f34200c     // Catch:{ all -> 0x00c3 }
            r12.a((java.lang.String) r0, (long) r3, (boolean) r5)     // Catch:{ all -> 0x00c3 }
            goto L_0x006a
        L_0x0067:
            r12.a((java.lang.String) r0, (long) r3, (boolean) r2)     // Catch:{ all -> 0x00c3 }
        L_0x006a:
            r3 = 7200000(0x6ddd00, double:3.5572727E-317)
            r12.a((java.lang.String) r13, (long) r3)     // Catch:{ all -> 0x00c3 }
        L_0x0070:
            qalsdk.q[] r13 = r12.f34202b     // Catch:{ all -> 0x00c3 }
            int r13 = r13.length     // Catch:{ all -> 0x00c3 }
            if (r2 >= r13) goto L_0x00c1
            int r13 = r12.f34192d     // Catch:{ all -> 0x00c3 }
            int r0 = r1 << r2
            r13 = r13 | r0
            r12.f34192d = r13     // Catch:{ all -> 0x00c3 }
            qalsdk.q[] r13 = r12.f34202b     // Catch:{ all -> 0x00c3 }
            r13 = r13[r2]     // Catch:{ all -> 0x00c3 }
            qalsdk.n$a r11 = r12.i     // Catch:{ all -> 0x00c3 }
            r0 = 0
            int r3 = r13.f34186a     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x009e
            r4 = 2
            if (r3 == r4) goto L_0x008b
            goto L_0x00af
        L_0x008b:
            r0 = r13
            qalsdk.r r0 = (qalsdk.r) r0     // Catch:{ all -> 0x00c3 }
            qalsdk.o r3 = new qalsdk.o     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = r0.f34188c     // Catch:{ all -> 0x00c3 }
            java.lang.String r8 = r13.f34187b     // Catch:{ all -> 0x00c3 }
            r9 = 10000(0x2710, float:1.4013E-41)
            r5 = r3
            r6 = r2
            r10 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00c3 }
            r0 = r3
            goto L_0x00af
        L_0x009e:
            qalsdk.s r13 = (qalsdk.s) r13     // Catch:{ all -> 0x00c3 }
            qalsdk.p r0 = new qalsdk.p     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = r13.f34189c     // Catch:{ all -> 0x00c3 }
            int r8 = r13.f34190d     // Catch:{ all -> 0x00c3 }
            java.lang.String r9 = r13.f34187b     // Catch:{ all -> 0x00c3 }
            r10 = 10000(0x2710, float:1.4013E-41)
            r5 = r0
            r6 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00c3 }
        L_0x00af:
            if (r0 == 0) goto L_0x00be
            java.lang.Thread r13 = new java.lang.Thread     // Catch:{ all -> 0x00c3 }
            r13.<init>(r0)     // Catch:{ all -> 0x00c3 }
            java.lang.String r0 = "WifiDetectEchoThread"
            r13.setName(r0)     // Catch:{ all -> 0x00c3 }
            r13.start()     // Catch:{ all -> 0x00c3 }
        L_0x00be:
            int r2 = r2 + 1
            goto L_0x0070
        L_0x00c1:
            monitor-exit(r12)
            return
        L_0x00c3:
            r13 = move-exception
            monitor-exit(r12)
            goto L_0x00c7
        L_0x00c6:
            throw r13
        L_0x00c7:
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.t.c(java.lang.String):void");
    }

    private void f() {
        String config = l.a().getConfig("_wifi_detect_history");
        if (config != null) {
            try {
                JSONArray jSONArray = new JSONArray(config);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    w a2 = w.a(jSONArray.getJSONObject(i2));
                    if (a2 != null) {
                        this.h.put(a2.f34198a, a2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(String str, long j2, boolean z) {
        this.h.put(str, new w(str, j2, z));
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry next : this.h.entrySet()) {
                String str2 = (String) next.getKey();
                w wVar = (w) next.getValue();
                if (wVar.f34198a.equals(str) || System.currentTimeMillis() - wVar.f34199b <= 86400000) {
                    JSONObject a2 = wVar.a();
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                } else {
                    this.h.remove(str2);
                }
            }
            QLog.d("WifiDetector", 4, "updatewifi:" + jSONArray.toString());
            l.a().setConfig("_wifi_detect_history", jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void a(t tVar, int i2, String str) {
        if (tVar.f34193e != -2 || i2 == 0) {
            tVar.f34193e = i2;
        }
        if (tVar.f34193e == -2) {
            tVar.f34194f = str;
        }
    }
}
