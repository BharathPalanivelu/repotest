package com.google.android.libraries.places.internal;

public class nc implements ly {

    /* renamed from: a  reason: collision with root package name */
    public int f13006a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f13007b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f13008c;

    /* renamed from: d  reason: collision with root package name */
    public int f13009d;

    /* renamed from: e  reason: collision with root package name */
    public int f13010e;

    /* renamed from: f  reason: collision with root package name */
    public int f13011f;

    /* renamed from: g  reason: collision with root package name */
    public int f13012g;
    public int h;

    public final ml a() {
        throw new NoSuchMethodError();
    }

    public final boolean b() {
        throw new NoSuchMethodError();
    }

    public final ma c() {
        throw new NoSuchMethodError();
    }

    public static nc a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static nc a(byte[] bArr, int i, int i2) {
        return a(bArr, 0, i2, false);
    }

    static nc a(byte[] bArr, int i, int i2, boolean z) {
        nc ncVar = new nc(bArr, i, i2, z, (byte) 0);
        try {
            ncVar.a(i2);
            return ncVar;
        } catch (ld e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    nc() {
        this.f13006a = 100;
    }

    public int a(int i) throws ld {
        if (i >= 0) {
            int d2 = i + d();
            int i2 = this.h;
            if (d2 <= i2) {
                this.h = d2;
                e();
                return i2;
            }
            throw ld.a();
        }
        throw ld.b();
    }

    public int d() {
        return this.f13011f - this.f13012g;
    }

    nc(byte[] bArr, int i, int i2, boolean z) {
        this();
        this.h = Integer.MAX_VALUE;
        this.f13007b = bArr;
        this.f13009d = i2 + i;
        this.f13011f = i;
        this.f13012g = this.f13011f;
        this.f13008c = z;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f13009d += this.f13010e;
        int i = this.f13009d;
        int i2 = i - this.f13012g;
        int i3 = this.h;
        if (i2 > i3) {
            this.f13010e = i2 - i3;
            this.f13009d = i - this.f13010e;
            return;
        }
        this.f13010e = 0;
    }

    /* synthetic */ nc(byte[] bArr, int i, int i2, boolean z, byte b2) {
        this(bArr, i, i2, z);
    }
}
