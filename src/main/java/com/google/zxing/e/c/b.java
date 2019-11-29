package com.google.zxing.e.c;

import java.lang.reflect.Array;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f14689a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14690b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14691c;

    public b(int i, int i2) {
        this.f14689a = (byte[][]) Array.newInstance(byte.class, new int[]{i2, i});
        this.f14690b = i;
        this.f14691c = i2;
    }

    public int a() {
        return this.f14691c;
    }

    public int b() {
        return this.f14690b;
    }

    public byte a(int i, int i2) {
        return this.f14689a[i2][i];
    }

    public byte[][] c() {
        return this.f14689a;
    }

    public void a(int i, int i2, int i3) {
        this.f14689a[i2][i] = (byte) i3;
    }

    public void a(int i, int i2, boolean z) {
        this.f14689a[i2][i] = z ? (byte) 1 : 0;
    }

    public void a(byte b2) {
        for (int i = 0; i < this.f14691c; i++) {
            for (int i2 = 0; i2 < this.f14690b; i2++) {
                this.f14689a[i][i2] = b2;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f14690b * 2 * this.f14691c) + 2);
        for (int i = 0; i < this.f14691c; i++) {
            for (int i2 = 0; i2 < this.f14690b; i2++) {
                byte b2 = this.f14689a[i][i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
