package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.p;
import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;

public class o implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3584a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3585b;

    /* renamed from: c  reason: collision with root package name */
    private final h f3586c;

    public o(String str, int i, h hVar) {
        this.f3584a = str;
        this.f3585b = i;
        this.f3586c = hVar;
    }

    public String a() {
        return this.f3584a;
    }

    public h b() {
        return this.f3586c;
    }

    public b a(f fVar, a aVar) {
        return new p(fVar, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.f3584a + ", index=" + this.f3585b + '}';
    }
}
