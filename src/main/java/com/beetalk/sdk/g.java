package com.beetalk.sdk;

import android.app.Activity;
import android.content.Intent;
import com.beetalk.sdk.data.DataModel;
import com.beetalk.sdk.f;
import com.beetalk.sdk.g.a;
import com.beetalk.sdk.ndk.GGPlatformSupport;
import com.beetalk.sdk.ndk.LoginRet;
import com.beetalk.sdk.ndk.ShareRet;
import com.facebook.appevents.AppEventsConstants;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static com.beetalk.sdk.a.b f5431a;

    /* renamed from: b  reason: collision with root package name */
    private static Integer f5432b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static String f5433c = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    /* renamed from: d  reason: collision with root package name */
    private static String f5434d;

    /* renamed from: e  reason: collision with root package name */
    private static f.a f5435e = new f.a() {
        public void a(f fVar, Exception exc) {
            if (exc != null) {
                return;
            }
            if (fVar != null) {
                switch (AnonymousClass9.f5438a[fVar.e().ordinal()]) {
                    case 3:
                        GGPlatformSupport.OnLoginNotify(com.beetalk.sdk.ndk.a.a(fVar));
                        return;
                    case 4:
                    case 5:
                    case 6:
                        LoginRet loginRet = new LoginRet();
                        loginRet.f5473a = fVar.i();
                        com.beetalk.sdk.e.a.a("ndk_login_auth_callback error %d flag %d", fVar.l(), Integer.valueOf(loginRet.f5473a));
                        GGPlatformSupport.OnLoginNotify(loginRet);
                        return;
                    case 7:
                        LoginRet loginRet2 = new LoginRet();
                        if (com.beetalk.sdk.e.f.a(com.beetalk.sdk.a.d.a().d())) {
                            loginRet2.f5473a = com.garena.pay.android.a.GUEST_ACCOUNT_INVALID.getCode().intValue();
                        } else {
                            loginRet2.f5473a = com.garena.pay.android.a.BIND_FAILED.getCode().intValue();
                        }
                        com.beetalk.sdk.e.a.a("ndk_bind_fail_error %d flag %d", fVar.l(), Integer.valueOf(loginRet2.f5473a));
                        return;
                    default:
                        return;
                }
            } else {
                GGPlatformSupport.OnLoginNotify(com.beetalk.sdk.ndk.a.a((f) null));
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static f.a f5436f = new f.a() {
        public void a(f fVar, Exception exc) {
            if (exc != null) {
                return;
            }
            if (fVar != null) {
                switch (AnonymousClass9.f5438a[fVar.e().ordinal()]) {
                    case 3:
                        GGPlatformSupport.OnBindNotify(com.beetalk.sdk.ndk.a.b(fVar));
                        return;
                    case 4:
                    case 5:
                    case 6:
                        LoginRet loginRet = new LoginRet();
                        loginRet.f5473a = fVar.i();
                        com.beetalk.sdk.e.a.a("ndk_bind_auth_callback error %d flag %d", fVar.l(), Integer.valueOf(loginRet.f5473a));
                        GGPlatformSupport.OnBindNotify(loginRet);
                        return;
                    case 7:
                        LoginRet loginRet2 = new LoginRet();
                        if (com.beetalk.sdk.e.f.a(com.beetalk.sdk.a.d.a().d())) {
                            loginRet2.f5473a = com.garena.pay.android.a.GUEST_ACCOUNT_INVALID.getCode().intValue();
                        } else {
                            loginRet2.f5473a = com.garena.pay.android.a.BIND_FAILED.getCode().intValue();
                        }
                        com.beetalk.sdk.e.a.a("ndk_bind_fail_error %d flag %d", fVar.l(), Integer.valueOf(loginRet2.f5473a));
                        GGPlatformSupport.OnBindNotify(loginRet2);
                        return;
                    default:
                        return;
                }
            } else {
                GGPlatformSupport.OnBindNotify(com.beetalk.sdk.ndk.a.b((f) null));
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static f.a f5437g = new f.a() {
        public void a(f fVar, Exception exc) {
            if (exc != null) {
                return;
            }
            if (fVar != null) {
                switch (AnonymousClass9.f5438a[fVar.e().ordinal()]) {
                    case 3:
                        GGPlatformSupport.OnGetPlatformSessionNotify(com.beetalk.sdk.ndk.a.b(fVar));
                        return;
                    case 4:
                    case 5:
                    case 6:
                        LoginRet loginRet = new LoginRet();
                        loginRet.f5473a = fVar.i();
                        com.beetalk.sdk.e.a.a("ndk_get_platform_session_callback error %d flag %d", fVar.l(), Integer.valueOf(loginRet.f5473a));
                        GGPlatformSupport.OnGetPlatformSessionNotify(loginRet);
                        return;
                    case 7:
                        LoginRet loginRet2 = new LoginRet();
                        if (com.beetalk.sdk.e.f.a(com.beetalk.sdk.a.d.a().d())) {
                            loginRet2.f5473a = com.garena.pay.android.a.GUEST_ACCOUNT_INVALID.getCode().intValue();
                        } else {
                            loginRet2.f5473a = com.garena.pay.android.a.BIND_FAILED.getCode().intValue();
                        }
                        com.beetalk.sdk.e.a.a("ndk_get_platform_session_fail_error %d flag %d", fVar.l(), Integer.valueOf(loginRet2.f5473a));
                        GGPlatformSupport.OnGetPlatformSessionNotify(loginRet2);
                        return;
                    default:
                        return;
                }
            } else {
                GGPlatformSupport.OnGetPlatformSessionNotify(com.beetalk.sdk.ndk.a.b((f) null));
            }
        }
    };
    private static com.beetalk.sdk.d.a h = new com.beetalk.sdk.d.a() {
    };
    private static e i = new e() {
    };
    private static d j = new d() {
    };
    private static e k = new e() {
    };
    private static b l = new b() {
    };
    private static a m = new a() {
    };
    private static a n = new a() {
    };
    private static c o = new c() {
    };
    private static a p = new a<Object>() {
    };
    private static a q = new a<Object>() {
    };
    private static com.garena.android.a r = new com.garena.android.a() {
    };

    public interface a extends com.beetalk.sdk.g.a<DataModel.FriendGroupsRet> {
    }

    public interface b extends a<DataModel.FriendsInfoRet> {
    }

    public interface c extends a<DataModel.GroupFriendsInfoRet> {
    }

    public interface d extends a<ShareRet> {
    }

    public interface e extends a<DataModel.FriendIDsRet> {
    }

    public static String c() {
        return "2.8.3";
    }

    public static com.beetalk.sdk.a.b a() {
        return f5431a;
    }

    public static Integer b() {
        if (f.b() != null) {
            return f.b().f();
        }
        throw new com.beetalk.sdk.b.a("Please initialize the session before continuing");
    }

    public static void a(Activity activity, int i2, int i3, Intent intent) {
        if (i2 == l.f5468f.intValue()) {
            if (f.c() != null) {
                f.c().a(activity, i2, i3, intent);
            }
        } else if (f.b() != null) {
            f.b().a(activity, i2, i3, intent);
        }
    }

    /* renamed from: com.beetalk.sdk.g$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5438a = new int[m.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5439b = new int[com.beetalk.sdk.data.d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0090 */
        static {
            /*
                com.beetalk.sdk.data.d[] r0 = com.beetalk.sdk.data.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5439b = r0
                r0 = 1
                int[] r1 = f5439b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.beetalk.sdk.data.d r2 = com.beetalk.sdk.data.d.BEETALK_NATIVE_ANDROID     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f5439b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.beetalk.sdk.data.d r3 = com.beetalk.sdk.data.d.BEETALK_OTHERS_ANDROID     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f5439b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.beetalk.sdk.data.d r4 = com.beetalk.sdk.data.d.FACEBOOK     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f5439b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.beetalk.sdk.data.d r5 = com.beetalk.sdk.data.d.GARENA_WEB_ANDROID     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f5439b     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.beetalk.sdk.data.d r6 = com.beetalk.sdk.data.d.GARENA_NATIVE_ANDROID     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                r5 = 6
                int[] r6 = f5439b     // Catch:{ NoSuchFieldError -> 0x004b }
                com.beetalk.sdk.data.d r7 = com.beetalk.sdk.data.d.GUEST     // Catch:{ NoSuchFieldError -> 0x004b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                com.beetalk.sdk.m[] r6 = com.beetalk.sdk.m.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f5438a = r6
                int[] r6 = f5438a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.beetalk.sdk.m r7 = com.beetalk.sdk.m.CREATED     // Catch:{ NoSuchFieldError -> 0x005e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f5438a     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.beetalk.sdk.m r6 = com.beetalk.sdk.m.OPENING     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f5438a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.beetalk.sdk.m r1 = com.beetalk.sdk.m.TOKEN_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f5438a     // Catch:{ NoSuchFieldError -> 0x007c }
                com.beetalk.sdk.m r1 = com.beetalk.sdk.m.CLOSED     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f5438a     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.beetalk.sdk.m r1 = com.beetalk.sdk.m.CLOSED_WITH_ERROR     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = f5438a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.beetalk.sdk.m r1 = com.beetalk.sdk.m.INSPECTION_WITH_ERROR     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f5438a     // Catch:{ NoSuchFieldError -> 0x009b }
                com.beetalk.sdk.m r1 = com.beetalk.sdk.m.CLOSED_WITH_BIND_FAIL     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.beetalk.sdk.g.AnonymousClass9.<clinit>():void");
        }
    }

    public static String d() {
        return f5434d;
    }
}
