package com.airbnb.lottie.c.b;

import android.graphics.Path;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.f;

public class m implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3577a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f3578b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3579c;

    /* renamed from: d  reason: collision with root package name */
    private final a f3580d;

    /* renamed from: e  reason: collision with root package name */
    private final d f3581e;

    public m(String str, boolean z, Path.FillType fillType, a aVar, d dVar) {
        this.f3579c = str;
        this.f3577a = z;
        this.f3578b = fillType;
        this.f3580d = aVar;
        this.f3581e = dVar;
    }

    public String a() {
        return this.f3579c;
    }

    public a b() {
        return this.f3580d;
    }

    public d c() {
        return this.f3581e;
    }

    public Path.FillType d() {
        return this.f3578b;
    }

    public b a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new com.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f3577a + '}';
    }
}
