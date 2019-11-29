package com.shopee.app.react;

import android.app.Application;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.shopee.app.application.ar;
import com.shopee.app.react.b.b;
import com.shopee.app.react.b.d;
import com.shopee.app.react.b.e;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f18673a;

    /* renamed from: b  reason: collision with root package name */
    private static g f18674b;

    /* renamed from: c  reason: collision with root package name */
    private d f18675c = b.a().a(ar.f().e()).a(new e(this)).a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f18676d;

    /* renamed from: e  reason: collision with root package name */
    private int f18677e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f18678f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f18679g = null;
    private String h = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f18674b == null) {
                f18674b = new g();
            }
            gVar = f18674b;
        }
        return gVar;
    }

    private g() {
    }

    public boolean b() {
        return this.f18676d;
    }

    public void c() {
        this.f18676d = true;
        if (this.f18678f <= 0) {
            this.f18678f = i();
        }
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(ar.a());
        instance.a("RNVersion", l());
        instance.a("RNVersionNew", m());
    }

    public Application d() {
        return ar.f();
    }

    public d e() {
        return this.f18675c;
    }

    public void f() {
        this.f18677e++;
    }

    public void g() {
        this.f18677e--;
    }

    public void h() {
        e().f().a((com.garena.reactpush.d.e) null);
    }

    public void a(com.garena.reactpush.d.e eVar) {
        e().f().a(eVar);
    }

    public long i() {
        long j = this.f18678f;
        if (j > 0) {
            return j;
        }
        return e().g().a().getManifestVersion();
    }

    private String l() {
        String str = this.f18679g;
        if (str != null) {
            return str;
        }
        String version = e().g().a().getVersion();
        if (version == null) {
            version = String.valueOf(i());
        }
        this.f18679g = version;
        return this.f18679g;
    }

    private String m() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        String[] split = l().split("\\.");
        if (split.length == 3) {
            try {
                return String.valueOf((Integer.valueOf(split[0]).intValue() * 10000) + (Integer.valueOf(split[1]).intValue() * 100) + Integer.valueOf(split[2]).intValue());
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public String toString() {
        return "ReactApplication {\n\tmIsRunning=" + this.f18676d + "\n\tmActiveScreenCount=" + this.f18677e + "\n" + '}';
    }

    public synchronized void j() {
        f18674b = null;
    }

    public static void a(String str) {
        f18673a = str;
    }

    public static String k() {
        String str = f18673a;
        f18673a = null;
        return str;
    }
}
