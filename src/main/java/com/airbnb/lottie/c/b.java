package com.airbnb.lottie.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f3527a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3528b;

    /* renamed from: c  reason: collision with root package name */
    public final double f3529c;

    /* renamed from: d  reason: collision with root package name */
    final int f3530d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3531e;

    /* renamed from: f  reason: collision with root package name */
    final double f3532f;

    /* renamed from: g  reason: collision with root package name */
    public final double f3533g;
    public final int h;
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i2, int i3, double d3, double d4, int i4, int i5, double d5, boolean z) {
        this.f3527a = str;
        this.f3528b = str2;
        this.f3529c = d2;
        this.f3530d = i2;
        this.f3531e = i3;
        this.f3532f = d3;
        this.f3533g = d4;
        this.h = i4;
        this.i = i5;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        double hashCode = (double) (((this.f3527a.hashCode() * 31) + this.f3528b.hashCode()) * 31);
        double d2 = this.f3529c;
        Double.isNaN(hashCode);
        int i2 = (((((int) (hashCode + d2)) * 31) + this.f3530d) * 31) + this.f3531e;
        long doubleToLongBits = Double.doubleToLongBits(this.f3532f);
        return (((i2 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.h;
    }
}
