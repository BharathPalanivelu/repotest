package com.shopee.live.livestreaming.util;

import com.garena.android.appkit.d.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f29438a;

    /* renamed from: b  reason: collision with root package name */
    private String f29439b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f29440c;

    /* renamed from: d  reason: collision with root package name */
    private int f29441d;

    /* renamed from: e  reason: collision with root package name */
    private String f29442e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f29443f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f29444g = "";
    private int h;
    private String i = "";
    private long j;
    private int k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private String p;
    private String q;
    private int r;
    private String s;

    private f() {
    }

    public static f a() {
        if (f29438a == null) {
            f29438a = new f();
        }
        return f29438a;
    }

    public boolean b() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public int c() {
        return this.k;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public String d() {
        String str = this.i;
        return str == null ? "" : str;
    }

    public void a(String str) {
        this.i = str;
    }

    public String e() {
        String str = this.f29439b;
        return str == null ? "" : str;
    }

    public void b(String str) {
        this.f29439b = str;
    }

    public int f() {
        return this.f29440c;
    }

    public void b(int i2) {
        this.f29440c = i2;
    }

    public int g() {
        return this.f29441d;
    }

    public void c(int i2) {
        this.f29441d = i2;
    }

    public String h() {
        String str = this.f29442e;
        return str == null ? "" : str;
    }

    public void c(String str) {
        this.f29442e = str;
    }

    public String i() {
        String str = this.f29443f;
        return str == null ? "" : str;
    }

    public void d(String str) {
        this.f29443f = str;
    }

    public String j() {
        String str = this.f29444g;
        return str == null ? "" : str;
    }

    public void e(String str) {
        this.f29444g = str;
    }

    public int k() {
        return this.h;
    }

    public void d(int i2) {
        this.h = i2;
    }

    public long l() {
        return this.j;
    }

    public void a(long j2) {
        this.j = j2;
    }

    public int m() {
        if (this.m <= 0) {
            this.m = 30;
        }
        return this.m;
    }

    public void e(int i2) {
        this.m = i2;
    }

    public boolean n() {
        return this.n;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public boolean o() {
        return this.o;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public String p() {
        return this.p;
    }

    public void f(String str) {
        this.p = str;
        this.r = -1;
    }

    public String q() {
        return this.q;
    }

    public void g(String str) {
        this.q = str;
        this.r = -1;
    }

    public boolean r() {
        if (this.r == -1) {
            int e2 = ab.e(a().p());
            int e3 = ab.e(a().q());
            a.b("LiveStreaming: bundle version " + e2 + ", add-to-cart min version " + e3, new Object[0]);
            this.r = (e3 <= 0 || e2 < e3) ? 0 : 1;
        }
        if (this.r == 1) {
            return true;
        }
        return false;
    }

    public String s() {
        return this.s;
    }

    public void h(String str) {
        this.s = str;
    }
}
