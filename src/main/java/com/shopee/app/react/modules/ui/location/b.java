package com.shopee.app.react.modules.ui.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.facebook.react.bridge.Promise;
import com.garena.android.appkit.f.f;
import com.garena.c.a.i;
import com.garena.c.a.j;
import com.google.a.o;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.g.d;
import com.shopee.app.react.c;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;

public class b extends com.shopee.app.react.modules.base.b {

    /* renamed from: b  reason: collision with root package name */
    private static String[] f18871b = {"android.permission.ACCESS_FINE_LOCATION"};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static boolean f18872c = false;

    /* renamed from: d  reason: collision with root package name */
    private static long f18873d = 0;

    /* renamed from: a  reason: collision with root package name */
    SettingConfigStore f18874a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18875e = false;

    /* renamed from: f  reason: collision with root package name */
    private Promise f18876f;

    public b(c cVar) {
        cVar.c().a(this);
    }

    /* access modifiers changed from: package-private */
    public void a(final Activity activity, String str, Promise promise) {
        boolean z;
        this.f18876f = promise;
        this.f18875e = false;
        try {
            o oVar = (o) WebRegister.GSON.a(str, o.class);
            z = oVar.b("noPopUp") ? oVar.c("noPopUp").h() : false;
            try {
                if (oVar.b("noLocationServiceHint")) {
                    this.f18875e = oVar.c("noLocationServiceHint").h();
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            z = false;
        }
        d.a(activity, f18871b, 228, 0, z ? 0 : R.string.msg_permission_location_nearby, R.string.sp_no_location_access, R.string.sp_to_allow_location_hint, new d.a() {
            public void a() {
                b.this.a(activity);
            }

            public void b() {
                b.this.a(4101);
            }

            public void c() {
                f.a().a(new Runnable() {
                    public void run() {
                        if (androidx.core.content.b.b((Context) activity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            b.this.a(activity);
                        } else {
                            b.this.a(4101);
                        }
                    }
                }, 10000);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final Activity activity) {
        i.a().a(false);
        i.a().b(false);
        i.a().a((j) new j() {
            public void a(Location location) {
                b.this.a(location);
            }

            public void a(int i) {
                a aVar = new a(i);
                Location b2 = i.a().b();
                if (b2 != null) {
                    b.this.a(b2);
                } else if (aVar.c()) {
                    b.this.a(activity, aVar);
                } else {
                    b.this.a(aVar.b());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Location location) {
        o oVar = new o();
        oVar.a("status", (Number) 1);
        oVar.a("latitude", (Number) Double.valueOf(location.getLatitude()));
        oVar.a("longitude", (Number) Double.valueOf(location.getLongitude()));
        this.f18876f.resolve(oVar.toString());
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        o oVar = new o();
        oVar.a("status", (Number) 0);
        oVar.a("errorCode", (Number) Integer.valueOf(i));
        this.f18876f.resolve(oVar.toString());
    }

    /* access modifiers changed from: private */
    public void a(final Activity activity, final a aVar) {
        if (activity.isFinishing() || !a()) {
            a(aVar.b());
            return;
        }
        a.a((Context) activity, (int) R.string.sp_tips, aVar.a(), (int) R.string.sp_ignore, (int) R.string.sp_settings, (a.C0318a) new a.C0318a() {
            public void onPositive() {
                b.this.a(aVar.b());
                activity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }

            public void onNegative() {
                boolean unused = b.f18872c = true;
                b.this.a(aVar.b());
            }
        });
        f18873d = System.currentTimeMillis();
    }

    private boolean a() {
        return !f18872c && !this.f18875e && System.currentTimeMillis() - f18873d > ((long) this.f18874a.locationDialogDismissIntervalMillis());
    }
}
