package com.google.zxing.c;

import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14500a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14501b;

    /* renamed from: c  reason: collision with root package name */
    private final List<byte[]> f14502c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14503d;

    /* renamed from: e  reason: collision with root package name */
    private Object f14504e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14505f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14506g;

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f14500a = bArr;
        this.f14501b = str;
        this.f14502c = list;
        this.f14503d = str2;
        this.f14505f = i2;
        this.f14506g = i;
    }

    public byte[] a() {
        return this.f14500a;
    }

    public String b() {
        return this.f14501b;
    }

    public List<byte[]> c() {
        return this.f14502c;
    }

    public String d() {
        return this.f14503d;
    }

    public Object e() {
        return this.f14504e;
    }

    public void a(Object obj) {
        this.f14504e = obj;
    }

    public boolean f() {
        return this.f14505f >= 0 && this.f14506g >= 0;
    }

    public int g() {
        return this.f14505f;
    }

    public int h() {
        return this.f14506g;
    }
}
