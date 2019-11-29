package com.google.zxing.d.a.a.a;

final class o extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f14545a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14546b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14547c;

    o(int i, String str) {
        super(i);
        this.f14545a = str;
        this.f14547c = false;
        this.f14546b = 0;
    }

    o(int i, String str, int i2) {
        super(i);
        this.f14547c = true;
        this.f14546b = i2;
        this.f14545a = str;
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f14545a;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f14547c;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f14546b;
    }
}
