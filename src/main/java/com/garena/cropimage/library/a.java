package com.garena.cropimage.library;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f7895a;

    /* renamed from: b  reason: collision with root package name */
    private String f7896b;

    /* renamed from: c  reason: collision with root package name */
    private int f7897c;

    /* renamed from: d  reason: collision with root package name */
    private int f7898d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7899e;

    /* renamed from: f  reason: collision with root package name */
    private int f7900f;

    /* renamed from: g  reason: collision with root package name */
    private int f7901g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private C0129a r;

    /* renamed from: com.garena.cropimage.library.a$a  reason: collision with other inner class name */
    public enum C0129a {
        NONE,
        CENTER_INSIDE,
        CENTER_CROP
    }

    public a() {
        this.f7899e = false;
        this.f7896b = "";
        this.f7895a = "";
        this.f7895a = "";
        this.f7896b = "";
        this.f7901g = 0;
        this.f7900f = 0;
        this.l = 0;
        this.k = 0;
        this.i = 1;
        this.h = 1;
        this.j = -1;
        this.f7897c = 0;
        this.m = false;
        this.n = 100;
    }

    public a a(String str) {
        this.f7895a = str;
        if (str == null) {
            this.f7895a = "";
        }
        return this;
    }

    public String a() {
        return this.f7895a;
    }

    public a b(String str) {
        this.f7896b = str;
        if (str == null) {
            this.f7896b = "";
        }
        return this;
    }

    public String b() {
        return this.f7896b;
    }

    public a a(int i2) {
        this.f7897c = i2;
        return this;
    }

    public a c() {
        this.f7899e = true;
        return this;
    }

    public boolean d() {
        return this.f7899e;
    }

    public a b(int i2) {
        this.f7898d = i2;
        return this;
    }

    public int e() {
        return this.f7898d;
    }

    public int f() {
        return this.f7897c;
    }

    public C0129a g() {
        return this.r;
    }

    public a a(C0129a aVar) {
        this.r = aVar;
        return this;
    }

    public a a(int i2, int i3) {
        this.f7900f = i2;
        this.f7901g = i3;
        return this;
    }

    public int h() {
        return this.f7900f;
    }

    public int i() {
        return this.f7901g;
    }

    public a a(int i2, int i3, int i4) {
        this.j = i4;
        this.i = i3;
        this.h = i2;
        return this;
    }

    public a b(int i2, int i3) {
        this.i = i3;
        this.h = i2;
        return this;
    }

    public int j() {
        return this.h;
    }

    public int k() {
        return this.i;
    }

    public int l() {
        return this.j;
    }

    public a c(int i2, int i3) {
        this.l = i3;
        this.k = i2;
        return this;
    }

    public int m() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    public a a(boolean z) {
        this.m = z;
        return this;
    }

    public boolean o() {
        return this.m;
    }

    public a c(int i2) {
        this.n = i2;
        return this;
    }

    public void d(int i2) {
        this.o = i2;
    }

    public int p() {
        return this.o;
    }

    public void a(boolean z, boolean z2) {
        this.p = z;
        this.q = z2;
    }

    public boolean q() {
        return this.q;
    }

    public boolean r() {
        return this.p;
    }
}
