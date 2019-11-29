package com.shopee.app.util;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    public float f26161a;

    /* renamed from: b  reason: collision with root package name */
    public float f26162b;

    /* renamed from: c  reason: collision with root package name */
    float f26163c;

    /* renamed from: d  reason: collision with root package name */
    float f26164d;

    /* renamed from: e  reason: collision with root package name */
    float f26165e;

    /* renamed from: f  reason: collision with root package name */
    float f26166f;

    /* renamed from: g  reason: collision with root package name */
    int f26167g;

    private ar(int i, float f2, float f3) {
        this.f26167g = i;
        this.f26161a = f2;
        this.f26162b = f3;
    }

    private ar(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f26163c = f2;
        this.f26164d = f3;
        this.f26165e = f4;
        this.f26166f = f5;
        this.f26161a = f6;
        this.f26162b = f7;
        this.f26167g = 2;
    }

    public static ar a(float f2, float f3, float f4, float f5, float f6, float f7) {
        return new ar(f2, f3, f4, f5, f6, f7);
    }

    public static ar a(float f2, float f3) {
        return new ar(0, f2, f3);
    }
}
