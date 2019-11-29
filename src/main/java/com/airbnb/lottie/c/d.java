package com.airbnb.lottie.c;

import com.airbnb.lottie.c.b.n;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f3639a;

    /* renamed from: b  reason: collision with root package name */
    private final char f3640b;

    /* renamed from: c  reason: collision with root package name */
    private final double f3641c;

    /* renamed from: d  reason: collision with root package name */
    private final double f3642d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3643e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3644f;

    public static int a(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f3639a = list;
        this.f3640b = c2;
        this.f3641c = d2;
        this.f3642d = d3;
        this.f3643e = str;
        this.f3644f = str2;
    }

    public List<n> a() {
        return this.f3639a;
    }

    public double b() {
        return this.f3642d;
    }

    public int hashCode() {
        return a(this.f3640b, this.f3644f, this.f3643e);
    }
}
