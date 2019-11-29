package com.airbnb.lottie.f;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f3720a;

    /* renamed from: b  reason: collision with root package name */
    private int f3721b;

    public void a(float f2) {
        this.f3720a += f2;
        this.f3721b++;
        int i = this.f3721b;
        if (i == Integer.MAX_VALUE) {
            this.f3720a /= 2.0f;
            this.f3721b = i / 2;
        }
    }
}
