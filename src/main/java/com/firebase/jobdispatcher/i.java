package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.firebase.jobdispatcher.u;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private final p f7202a = new p("com.firebase.jobdispatcher.");

    private static int a(int i) {
        return i != 2 ? 0 : 1;
    }

    private static int b(int i) {
        int i2 = 2;
        if ((i & 2) == 2) {
            i2 = 0;
        }
        if ((i & 1) == 1) {
            return 1;
        }
        return i2;
    }

    i() {
    }

    private static void a(r rVar, Bundle bundle, u.b bVar) {
        bundle.putInt("trigger_type", 1);
        if (rVar.h()) {
            bundle.putLong("period", (long) bVar.b());
            bundle.putLong("period_flex", (long) (bVar.b() - bVar.a()));
            return;
        }
        bundle.putLong("window_start", (long) bVar.a());
        bundle.putLong("window_end", (long) bVar.b());
    }

    private static void a(Bundle bundle) {
        bundle.putInt("trigger_type", 2);
        bundle.putLong("window_start", 0);
        bundle.putLong("window_end", 1);
    }

    private static void a(Bundle bundle, u.a aVar) {
        bundle.putInt("trigger_type", 3);
        int size = aVar.a().size();
        int[] iArr = new int[size];
        Uri[] uriArr = new Uri[size];
        for (int i = 0; i < size; i++) {
            w wVar = aVar.a().get(i);
            iArr[i] = wVar.b();
            uriArr[i] = wVar.a();
        }
        bundle.putIntArray("content_uri_flags_array", iArr);
        bundle.putParcelableArray("content_uri_array", uriArr);
    }

    public Bundle a(r rVar, Bundle bundle) {
        bundle.putString("tag", rVar.e());
        bundle.putBoolean("update_current", rVar.d());
        bundle.putBoolean("persisted", rVar.g() == 2);
        bundle.putString("service", GooglePlayReceiver.class.getName());
        c(rVar, bundle);
        d(rVar, bundle);
        b(rVar, bundle);
        Bundle b2 = rVar.b();
        if (b2 == null) {
            b2 = new Bundle();
        }
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, this.f7202a.a(rVar, b2));
        return bundle;
    }

    private static void b(r rVar, Bundle bundle) {
        x c2 = rVar.c();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("retry_policy", a(c2.a()));
        bundle2.putInt("initial_backoff_seconds", c2.b());
        bundle2.putInt("maximum_backoff_seconds", c2.c());
        bundle.putBundle("retryStrategy", bundle2);
    }

    private static void c(r rVar, Bundle bundle) {
        u f2 = rVar.f();
        if (f2 == y.f7265a) {
            a(bundle);
        } else if (f2 instanceof u.b) {
            a(rVar, bundle, (u.b) f2);
        } else if (f2 instanceof u.a) {
            a(bundle, (u.a) f2);
        } else {
            throw new IllegalArgumentException("Unknown trigger: " + f2.getClass());
        }
    }

    private static void d(r rVar, Bundle bundle) {
        int a2 = a.a(rVar.a());
        boolean z = true;
        bundle.putBoolean("requiresCharging", (a2 & 4) == 4);
        if ((a2 & 8) != 8) {
            z = false;
        }
        bundle.putBoolean("requiresIdle", z);
        bundle.putInt("requiredNetwork", b(a2));
    }
}
