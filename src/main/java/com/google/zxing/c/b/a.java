package com.google.zxing.c.b;

import tencent.tls.tools.I18nMsg;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f14483a = new a(4201, 4096, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f14484b = new a(I18nMsg.EN_US, 1024, 1);

    /* renamed from: c  reason: collision with root package name */
    public static final a f14485c = new a(67, 64, 1);

    /* renamed from: d  reason: collision with root package name */
    public static final a f14486d = new a(19, 16, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final a f14487e = new a(285, 256, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final a f14488f = new a(301, 256, 1);

    /* renamed from: g  reason: collision with root package name */
    public static final a f14489g = f14488f;
    public static final a h = f14485c;
    private final int[] i;
    private final int[] j;
    private final b k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    static int b(int i2, int i3) {
        return i2 ^ i3;
    }

    public a(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.i = new int[i3];
        this.j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.i[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.j[this.i[i7]] = i7;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    public b a() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public b b() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.k;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new b(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return this.i[i2];
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        if (i2 != 0) {
            return this.j[i2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        if (i2 != 0) {
            return this.i[(this.m - this.j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.m - 1)];
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
