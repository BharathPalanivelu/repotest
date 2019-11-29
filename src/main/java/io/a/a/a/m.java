package io.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.a.a.a.a.b.g;
import io.a.a.a.a.b.i;
import io.a.a.a.a.b.l;
import io.a.a.a.a.e.b;
import io.a.a.a.a.e.e;
import io.a.a.a.a.g.d;
import io.a.a.a.a.g.h;
import io.a.a.a.a.g.n;
import io.a.a.a.a.g.q;
import io.a.a.a.a.g.t;
import io.a.a.a.a.g.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class m extends i<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final e f33307a = new b();

    /* renamed from: b  reason: collision with root package name */
    private PackageManager f33308b;

    /* renamed from: c  reason: collision with root package name */
    private String f33309c;

    /* renamed from: d  reason: collision with root package name */
    private PackageInfo f33310d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, k>> p;
    private final Collection<i> q;

    public String a() {
        return "1.4.1.19";
    }

    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    public m(Future<Map<String, k>> future, Collection<i> collection) {
        this.p = future;
        this.q = collection;
    }

    /* access modifiers changed from: protected */
    public boolean h_() {
        try {
            this.m = q().i();
            this.f33308b = r().getPackageManager();
            this.f33309c = r().getPackageName();
            this.f33310d = this.f33308b.getPackageInfo(this.f33309c, 0);
            this.k = Integer.toString(this.f33310d.versionCode);
            this.l = this.f33310d.versionName == null ? "0.0" : this.f33310d.versionName;
            this.n = this.f33308b.getApplicationLabel(r().getApplicationInfo()).toString();
            this.o = Integer.toString(r().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            c.h().e("Fabric", "Failed init", e2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Boolean f() {
        boolean z;
        Map map;
        String k2 = i.k(r());
        t g2 = g();
        if (g2 != null) {
            try {
                if (this.p != null) {
                    map = this.p.get();
                } else {
                    map = new HashMap();
                }
                z = a(k2, g2.f33262a, a((Map<String, k>) map, this.q).values());
            } catch (Exception e2) {
                c.h().e("Fabric", "Error performing auto configuration.", e2);
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    private t g() {
        try {
            q.a().a(this, this.i, this.f33307a, this.k, this.l, e()).c();
            return q.a().b();
        } catch (Exception e2) {
            c.h().e("Fabric", "Error dealing with settings", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, k> a(Map<String, k> map, Collection<i> collection) {
        for (i next : collection) {
            if (!map.containsKey(next.b())) {
                map.put(next.b(), new k(next.b(), next.a(), "binary"));
            }
        }
        return map;
    }

    private boolean a(String str, io.a.a.a.a.g.e eVar, Collection<k> collection) {
        if ("new".equals(eVar.f33219b)) {
            if (b(str, eVar, collection)) {
                return q.a().d();
            }
            c.h().e("Fabric", "Failed to create app with Crashlytics service.", (Throwable) null);
            return false;
        } else if ("configured".equals(eVar.f33219b)) {
            return q.a().d();
        } else {
            if (eVar.f33223f) {
                c.h().a("Fabric", "Server says an update is required - forcing a full App update.");
                c(str, eVar, collection);
            }
            return true;
        }
    }

    private boolean b(String str, io.a.a.a.a.g.e eVar, Collection<k> collection) {
        return new h(this, e(), eVar.f33220c, this.f33307a).a(a(n.a(r(), str), collection));
    }

    private boolean c(String str, io.a.a.a.a.g.e eVar, Collection<k> collection) {
        return a(eVar, n.a(r(), str), collection);
    }

    private boolean a(io.a.a.a.a.g.e eVar, n nVar, Collection<k> collection) {
        return new y(this, e(), eVar.f33220c, this.f33307a).a(a(nVar, collection));
    }

    private d a(n nVar, Collection<k> collection) {
        Context r = r();
        return new d(new g().a(r), q().c(), this.l, this.k, i.a(i.m(r)), this.n, l.determineFrom(this.m).getId(), this.o, AppEventsConstants.EVENT_PARAM_VALUE_NO, nVar, collection);
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return i.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
