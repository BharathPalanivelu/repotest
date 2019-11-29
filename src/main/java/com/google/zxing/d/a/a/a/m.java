package com.google.zxing.d.a.a.a;

final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f14542a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f14543b = a.NUMERIC;

    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f14542a;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f14542a = i;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.f14542a += i;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f14543b == a.ALPHA;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f14543b == a.ISO_IEC_646;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f14543b = a.NUMERIC;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f14543b = a.ALPHA;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f14543b = a.ISO_IEC_646;
    }
}
