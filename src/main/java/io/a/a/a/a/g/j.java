package io.a.a.a.a.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import io.a.a.a.a.b.k;
import io.a.a.a.a.f.c;
import io.a.a.a.a.f.d;
import io.a.a.a.i;
import io.a.a.a.l;
import org.json.JSONException;
import org.json.JSONObject;

class j implements s {

    /* renamed from: a  reason: collision with root package name */
    private final w f33228a;

    /* renamed from: b  reason: collision with root package name */
    private final v f33229b;

    /* renamed from: c  reason: collision with root package name */
    private final k f33230c;

    /* renamed from: d  reason: collision with root package name */
    private final g f33231d;

    /* renamed from: e  reason: collision with root package name */
    private final x f33232e;

    /* renamed from: f  reason: collision with root package name */
    private final i f33233f;

    /* renamed from: g  reason: collision with root package name */
    private final c f33234g = new d(this.f33233f);

    public j(i iVar, w wVar, k kVar, v vVar, g gVar, x xVar) {
        this.f33233f = iVar;
        this.f33228a = wVar;
        this.f33230c = kVar;
        this.f33229b = vVar;
        this.f33231d = gVar;
        this.f33232e = xVar;
    }

    public t a() {
        return a(r.USE_CACHE);
    }

    public t a(r rVar) {
        t tVar = null;
        try {
            if (!io.a.a.a.c.i() && !d()) {
                tVar = b(rVar);
            }
            if (tVar == null) {
                JSONObject a2 = this.f33232e.a(this.f33228a);
                if (a2 != null) {
                    tVar = this.f33229b.a(this.f33230c, a2);
                    this.f33231d.a(tVar.f33268g, a2);
                    a(a2, "Loaded settings: ");
                    a(b());
                }
            }
            if (tVar == null) {
                return b(r.IGNORE_CACHE_EXPIRATION);
            }
            return tVar;
        } catch (Exception e2) {
            io.a.a.a.c.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e2);
            return null;
        }
    }

    private t b(r rVar) {
        t tVar = null;
        try {
            if (r.SKIP_CACHE_LOOKUP.equals(rVar)) {
                return null;
            }
            JSONObject a2 = this.f33231d.a();
            if (a2 != null) {
                t a3 = this.f33229b.a(this.f33230c, a2);
                if (a3 != null) {
                    a(a2, "Loaded cached settings: ");
                    long a4 = this.f33230c.a();
                    if (!r.IGNORE_CACHE_EXPIRATION.equals(rVar)) {
                        if (a3.a(a4)) {
                            io.a.a.a.c.h().a("Fabric", "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        io.a.a.a.c.h().a("Fabric", "Returning cached settings.");
                        return a3;
                    } catch (Exception e2) {
                        e = e2;
                        tVar = a3;
                        io.a.a.a.c.h().e("Fabric", "Failed to get cached settings", e);
                        return tVar;
                    }
                } else {
                    io.a.a.a.c.h().e("Fabric", "Failed to transform cached settings data.", (Throwable) null);
                    return null;
                }
            } else {
                io.a.a.a.c.h().a("Fabric", "No cached settings data found.");
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            io.a.a.a.c.h().e("Fabric", "Failed to get cached settings", e);
            return tVar;
        }
    }

    private void a(JSONObject jSONObject, String str) throws JSONException {
        l h = io.a.a.a.c.h();
        h.a("Fabric", str + jSONObject.toString());
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return io.a.a.a.a.b.i.a(io.a.a.a.a.b.i.m(this.f33233f.r()));
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f33234g.a().getString("existing_instance_identifier", "");
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean a(String str) {
        SharedPreferences.Editor b2 = this.f33234g.b();
        b2.putString("existing_instance_identifier", str);
        return this.f33234g.a(b2);
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return !c().equals(b());
    }
}
