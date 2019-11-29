package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;
import java.util.Arrays;
import java.util.List;

public class n implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3582a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f3583b;

    public n(String str, List<b> list) {
        this.f3582a = str;
        this.f3583b = list;
    }

    public String a() {
        return this.f3582a;
    }

    public List<b> b() {
        return this.f3583b;
    }

    public b a(f fVar, a aVar) {
        return new c(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f3582a + "' Shapes: " + Arrays.toString(this.f3583b.toArray()) + '}';
    }
}
