package com.shopee.live.livestreaming.util;

import a.k;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.a.l;
import com.google.a.o;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.live.livestreaming.util.e;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.app.a.a;
import java.util.List;
import okhttp3.Cookie;

public class classX {
    public static String a() {
        String str;
        a i = i();
        if (i == null) {
            str = "ID";
        } else {
            str = i.d();
        }
        if (TextUtils.isEmpty(str)) {
            return "ID";
        }
        return str;
    }

    public static String b() {
        String str;
        a i = i();
        if (i == null) {
            str = "live";
        } else {
            str = i.c();
        }
        if (TextUtils.isEmpty(str)) {
            return "live";
        }
        return str;
    }

    public static String c() {
        String str;
        a i = i();
        if (i == null) {
            str = "";
        } else {
            str = i.b();
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static boolean d() {
        return Country.COUNTRY_TW.equals(a());
    }

    private static a i() {
        com.shopee.sdk.modules.a a2 = b.a();
        if (a2 == null) {
            return null;
        }
        com.shopee.sdk.modules.app.a.b a3 = a2.a();
        if (a3 != null) {
            return a3.a();
        }
        return null;
    }

    public static com.shopee.sdk.modules.app.e.a e() {
        com.shopee.sdk.modules.a a2 = b.a();
        if (a2 == null) {
            return null;
        }
        com.shopee.sdk.modules.app.e.b d2 = a2.d();
        if (d2 != null) {
            return d2.a();
        }
        return null;
    }

    public static int f() {
        com.shopee.sdk.modules.app.e.a e2 = e();
        if (e2 == null) {
            return 0;
        }
        return e2.a();
    }

    public static void g() {
        a("SPC_RNBV", new com.shopee.sdk.f.b<String>() {
            public void a(int i, String str) {
            }

            public void a(String str) {
                com.shopee.e.a.a.a("LiveStreaming: ", "rn_bundle_version: " + str);
                f.a().f(str);
            }
        });
        e.a("rnv1568272209276.json", new e.a() {
            public void a(o oVar) {
                o e2 = oVar.e("android");
                String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                if (e2 != null) {
                    String lowerCase = x.a().toLowerCase();
                    l c2 = e2.c(lowerCase + "_livestreaming_add_to_cart_min_rn_version");
                    if (c2 != null) {
                        String c3 = c2.c();
                        if (!TextUtils.isEmpty(c3)) {
                            str = c3;
                        }
                    }
                }
                f.a().g(str);
            }

            public void a() {
                f.a().g(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
        });
    }

    public static void a(final String str, final com.shopee.sdk.f.b<String> bVar) {
        com.shopee.sdk.modules.app.c.a g2 = b.a().g();
        g2.a("https://" + p.f() + p.a(), new com.shopee.sdk.f.b<List<Cookie>>() {
            public void a(List<Cookie> list) {
                if (list != null && !list.isEmpty()) {
                    for (Cookie next : list) {
                        if (str.equals(next.name())) {
                            bVar.a(next.value());
                            return;
                        }
                    }
                }
                bVar.a(-99, "no found");
            }

            public void a(int i, String str) {
                bVar.a(i, str);
            }
        });
    }

    public static void h() {
        k.a($$Lambda$x$4O9gQvgH6fneI1_LkgL0HuUioKo.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static void j() {
        com.shopee.sdk.modules.app.c.a g2 = b.a().g();
        if (g2 != null) {
            String b2 = p.b();
            String authority = Uri.parse(b2).getAuthority();
            if (authority != null) {
                AnonymousClass4 r3 = new com.shopee.sdk.f.b<Integer>() {
                    public void a(Integer num) {
                    }

                    public void a(int i, String str) {
                        com.shopee.e.a.a.b("set base cookie failed.", new Object[0]);
                    }
                };
                g2.a(b2, new Cookie.Builder().domain(authority).name("sz_os").value("2").build(), r3);
                g2.a(b2, new Cookie.Builder().domain(authority).name("sz_os_version").value(String.valueOf(Build.VERSION.SDK_INT)).build(), r3);
                a i = i();
                if (i != null && !TextUtils.isEmpty(i.a())) {
                    g2.a(b2, new Cookie.Builder().domain(authority).name("sz_app_version").value(i.a()).build(), r3);
                }
            }
        }
    }
}
