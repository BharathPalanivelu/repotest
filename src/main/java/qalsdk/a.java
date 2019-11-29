package qalsdk;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qalsdk.core.c;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.l;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.im_open.mobroute;
import com.tencent.qalsdk.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34048a = true;

    /* renamed from: b  reason: collision with root package name */
    public static long f34049b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static long f34050c = 0;

    /* renamed from: d  reason: collision with root package name */
    static long f34051d = 0;

    /* renamed from: e  reason: collision with root package name */
    static long f34052e = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f34053g = {-16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17};
    private static ConcurrentHashMap<String, String> h = new ConcurrentHashMap<>();
    private static AtomicBoolean i = new AtomicBoolean();
    private static long j = 0;
    private static long k = 0;

    /* renamed from: f  reason: collision with root package name */
    j f34054f;

    public static int d() {
        return 1;
    }

    public a(j jVar) {
        this.f34054f = jVar;
    }

    public static String a() {
        return h.containsKey("msf_locallogtime") ? h.get("msf_locallogtime") : "3";
    }

    public static String b() {
        return h.containsKey("msf_checkSsoIntervtime") ? h.get("msf_checkSsoIntervtime") : "300000";
    }

    public static long c() {
        try {
            if (h.containsKey("msf_heartBeatTimeout")) {
                return (long) Integer.parseInt(h.get("msf_heartBeatTimeout"));
            }
            return 10000;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return 10000;
            }
            QLog.d("MSF.C.ConfigManager", 2, "getHeartBeatTimeout error" + e2);
            return 10000;
        }
    }

    public static int e() {
        try {
            if (h.containsKey("msf_busPacketTimeoutMaxNum")) {
                return Integer.parseInt(h.get("msf_busPacketTimeoutMaxNum"));
            }
            return 10;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return 10;
            }
            QLog.d("MSF.C.ConfigManager", 2, "getBusPacketTimeoutMaxNum error" + e2);
            return 10;
        }
    }

    public static long f() {
        try {
            if (h.containsKey("msf_busCheckServerTimeInterval")) {
                return Long.parseLong(h.get("msf_busCheckServerTimeInterval"));
            }
            return 5000;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return 5000;
            }
            QLog.d("MSF.C.ConfigManager", 2, "getBusPacketTimeoutMaxNum error" + e2);
            return 5000;
        }
    }

    public static long g() {
        try {
            if (h.containsKey("msf_checkUpdateServerTimeInterval")) {
                return Long.parseLong(h.get("msf_checkUpdateServerTimeInterval"));
            }
            return 72000000;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return 72000000;
            }
            QLog.d("MSF.C.ConfigManager", 2, "getUpdateServerTimePacketTimeoutMaxNum error" + e2);
            return 72000000;
        }
    }

    public static long h() {
        try {
            if (h.containsKey("msf_checkUpdateServerTimeExtraInterval")) {
                return Long.parseLong(h.get("msf_checkUpdateServerTimeExtraInterval"));
            }
            return 7200000;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return 7200000;
            }
            QLog.d("MSF.C.ConfigManager", 2, "getUpdateServerTimePacketTimeoutExtraInterval error" + e2);
            return 7200000;
        }
    }

    public static long i() {
        try {
            if (h.containsKey("msf_checkServerTimeCompareInterval")) {
                return Long.parseLong(h.get("msf_checkServerTimeCompareInterval"));
            }
            return 7200000;
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return 7200000;
            }
            QLog.d("MSF.C.ConfigManager", 2, "getCheckServerTimeCompareInterval error" + e2);
            return 7200000;
        }
    }

    public static int j() {
        try {
            if (!h.containsKey("msf_netIdleTimeInterval")) {
                return 1680000;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.ConfigManager", 2, "msf_netIdleTimeInterval = " + h.get("msf_netIdleTimeInterval"));
            }
            return Integer.parseInt(h.get("msf_netIdleTimeInterval")) * 60 * 1000;
        } catch (Exception e2) {
            if (!QLog.isDevelopLevel()) {
                return 1680000;
            }
            QLog.d("MSF.C.ConfigManager", 4, "getNetIdleTimeInterval error" + e2);
            return 1680000;
        }
    }

    public static int k() {
        try {
            if (!h.containsKey("msf_netWeakTimeInterval")) {
                return 180000;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakTimeInterval = " + h.get("msf_netWeakTimeInterval"));
            }
            return Integer.parseInt(h.get("msf_netWeakTimeInterval")) * 60 * 1000;
        } catch (Exception e2) {
            if (!QLog.isDevelopLevel()) {
                return 180000;
            }
            QLog.d("MSF.C.ConfigManager", 4, "getNetWeakTimeInterval error" + e2);
            return 180000;
        }
    }

    public static int l() {
        try {
            if (!h.containsKey("msf_netWeakExceptionCount")) {
                return 3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.ConfigManager", 2, "msf_netWeakExceptionCount = " + h.get("msf_netWeakExceptionCount"));
            }
            return Integer.parseInt(h.get("msf_netWeakExceptionCount"));
        } catch (Exception e2) {
            if (!QLog.isDevelopLevel()) {
                return 3;
            }
            QLog.d("MSF.C.ConfigManager", 4, "getNetWeakExceptionCount error" + e2);
            return 3;
        }
    }

    public static boolean a(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = h;
        if (!concurrentHashMap.containsKey(str + "_isAutoBoot")) {
            return true;
        }
        try {
            ConcurrentHashMap<String, String> concurrentHashMap2 = h;
            return Boolean.parseBoolean(concurrentHashMap2.get(str + "_isAutoBoot").trim());
        } catch (Exception e2) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("MSF.C.ConfigManager", 2, str + " set isAutoBoot error " + e2);
            return false;
        }
    }

    public static boolean m() {
        return i.get();
    }

    public static synchronized void a(boolean z) {
        synchronized (a.class) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.ConfigManager", 2, "msfCore setAutoStaring " + z);
            }
            i.set(z);
            try {
                if (l.a() != null) {
                    l.a().setConfig("_msf_isBootingKey", String.valueOf(z));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.ConfigManager", 2, "storeAutoStaring " + z);
                }
            } catch (UnsatisfiedLinkError e2) {
                QLog.e("MSF.C.ConfigManager", "setAutoStaring exception:" + e2.getMessage());
            }
        }
    }

    public static boolean a(byte[] bArr) {
        boolean d2 = m.d();
        if (bArr.length < 14) {
            QLog.e("MSF.C.ConfigManager", 1, "invalid rsp pkg.len");
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.get();
        int i2 = wrap.getInt();
        if (i2 != bArr.length) {
            QLog.e("MSF.C.ConfigManager", 1, "invalid rsp pkg.len");
            return false;
        }
        byte[] bArr2 = new byte[(i2 - 14)];
        wrap.getShort();
        wrap.getShort();
        wrap.getInt();
        wrap.get(bArr2);
        wrap.get();
        mobroute.MobRouteSSOList mobRouteSSOList = new mobroute.MobRouteSSOList();
        try {
            mobRouteSSOList.mergeFrom(bArr2);
            if (mobRouteSSOList.vec_tcplist.get() != null && mobRouteSSOList.vec_tcplist.get().size() > 0) {
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                if (!d2) {
                    for (mobroute.MobRouteSSOListInfo next : mobRouteSSOList.vec_tcplist.get()) {
                        com.tencent.qalsdk.config.a aVar = new com.tencent.qalsdk.config.a();
                        aVar.f32161d = 0;
                        aVar.f32162e = mobRouteSSOList.uint32_timeout.get();
                        aVar.f32158a = next.string_ip.get();
                        aVar.f32159b = next.uint32_port.get();
                        aVar.f32164g = (byte) next.uint32_type.get();
                        c a2 = c.a(aVar, 1);
                        arrayList.add(a2);
                        stringBuffer.append(a2.toString() + ";");
                    }
                    QLog.d("MSF.C.ConfigManager", 1, "recv xg sso list " + stringBuffer.toString());
                    j.a().g().a((ArrayList<c>) arrayList, false);
                } else {
                    for (mobroute.MobRouteSSOListInfo next2 : mobRouteSSOList.vec_tcplist.get()) {
                        com.tencent.qalsdk.config.a aVar2 = new com.tencent.qalsdk.config.a();
                        aVar2.f32161d = 0;
                        aVar2.f32162e = mobRouteSSOList.uint32_timeout.get();
                        aVar2.f32158a = next2.string_ip.get();
                        aVar2.f32159b = next2.uint32_port.get();
                        aVar2.f32164g = (byte) next2.uint32_type.get();
                        c a3 = c.a(aVar2, 0);
                        a3.f32171c = "00000";
                        arrayList.add(a3);
                        stringBuffer.append(a3.toString() + ";");
                    }
                    QLog.d("MSF.C.ConfigManager", 1, "recv wifi sso list " + stringBuffer.toString());
                    j.a().g().a((ArrayList<c>) arrayList);
                }
            }
            return true;
        } catch (InvalidProtocolBufferMicroException e2) {
            QLog.e("MSF.C.ConfigManager", 1, "ssolist pb parsing failed");
            e2.printStackTrace();
            return false;
        }
    }

    private static void r() {
        if (h.containsKey("msf_AnyPacketAsPushHB")) {
            try {
                String str = h.get("msf_AnyPacketAsPushHB");
                f34048a = !str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.ConfigManager", 2, "config useAnyPacketAsPushHB " + str);
                }
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.ConfigManager", 2, "set msf_noReportRdmEvent error " + e2);
                }
            }
        }
    }

    public final void o() {
        l.a().n_setConfig("__loginSdk_mobilessotime", String.valueOf(f34051d));
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "save next get mobile sso time is " + this.f34054f.h.format(Long.valueOf(f34051d)));
        }
    }

    public final void p() {
        l.a().n_setConfig("__loginSdk_wifissotime", String.valueOf(f34052e));
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.ConfigManager", 2, "save next get Wifi sso time is " + this.f34054f.h.format(Long.valueOf(f34052e)));
        }
    }

    public final void a(String str, boolean z, String str2) {
        b bVar = new b(this, str, z, str2);
        bVar.setName("checkSsoByHttpThread");
        bVar.start();
    }

    public final void n() {
        String config = l.a().getConfig("__loginSdk_checkmobilessotime");
        if (config == null || config.length() == 0) {
            config = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        j = Long.parseLong(config);
        String config2 = l.a().getConfig("__loginSdk_checkwifissotime");
        if (config2 == null || config2.length() == 0) {
            config2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        k = Long.parseLong(config2);
        String config3 = l.a().getConfig("__loginSdk_mobilessotime");
        if (config3 == null || config3.length() == 0) {
            config3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        f34051d = Long.parseLong(config3);
        String config4 = l.a().getConfig("__loginSdk_wifissotime");
        if (config4 == null || config4.length() == 0) {
            config4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        f34052e = Long.parseLong(config4);
        String config5 = l.a().getConfig("_msf_isBootingKey");
        if (config5 == null || config5.length() == 0) {
            config5 = "false";
        }
        a(Boolean.parseBoolean(config5));
        r();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.qalsdk.base.remote.ToServiceMsg r14, long r15) {
        /*
            r13 = this;
            long r0 = java.lang.System.currentTimeMillis()
            boolean r2 = com.tencent.qalsdk.core.m.e()
            r3 = 43200000(0x2932e00, double:2.1343636E-316)
            r5 = 0
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0029
            long r9 = j
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0018
            goto L_0x0048
        L_0x0018:
            long r11 = f34051d
            int r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0024
            long r0 = r0 - r9
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0047
            goto L_0x0048
        L_0x0024:
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x0047
            goto L_0x0048
        L_0x0029:
            boolean r2 = com.tencent.qalsdk.core.m.d()
            if (r2 == 0) goto L_0x0047
            long r9 = k
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0036
            goto L_0x0048
        L_0x0036:
            long r11 = f34052e
            int r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0042
            long r0 = r0 - r9
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0047
            goto L_0x0048
        L_0x0042:
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r8 = 0
        L_0x0048:
            if (r8 == 0) goto L_0x00bd
            boolean r0 = com.tencent.qalsdk.core.m.e()
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            if (r0 == 0) goto L_0x006d
            j = r15
            com.tencent.qalsdk.config.NativeConfigStore r0 = com.tencent.qalsdk.core.l.a()
            long r3 = j
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "__loginSdk_checkmobilessotime"
            r0.n_setConfig(r4, r3)
            long r3 = j
            long r3 = r3 + r1
            f34051d = r3
            r13.o()
            goto L_0x008c
        L_0x006d:
            boolean r0 = com.tencent.qalsdk.core.m.d()
            if (r0 == 0) goto L_0x008c
            k = r15
            com.tencent.qalsdk.config.NativeConfigStore r0 = com.tencent.qalsdk.core.l.a()
            long r3 = k
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "__loginSdk_checkwifissotime"
            r0.n_setConfig(r4, r3)
            long r3 = k
            long r3 = r3 + r1
            f34052e = r3
            r13.p()
        L_0x008c:
            r14.getAppId()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r0 = r14.getUin()     // Catch:{ Exception -> 0x00aa }
            boolean r1 = com.tencent.qalsdk.core.m.d()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r2 = ""
            qalsdk.b r3 = new qalsdk.b     // Catch:{ Exception -> 0x00aa }
            r4 = r13
            r3.<init>(r13, r0, r1, r2)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r0 = "checkSsoByHttpThread"
            r3.setName(r0)     // Catch:{ Exception -> 0x00a8 }
            r3.start()     // Catch:{ Exception -> 0x00a8 }
            return
        L_0x00a8:
            r0 = move-exception
            goto L_0x00ac
        L_0x00aa:
            r0 = move-exception
            r4 = r13
        L_0x00ac:
            boolean r1 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r1 == 0) goto L_0x00be
            r1 = 2
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "MSF.C.ConfigManager"
            com.tencent.qalsdk.util.QLog.d(r3, r1, r2, r0)
            goto L_0x00be
        L_0x00bd:
            r4 = r13
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.a.a(com.tencent.qalsdk.base.remote.ToServiceMsg, long):void");
    }
}
