package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.n;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.c.a;

public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3566a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f3567b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3568c;

    /* renamed from: d  reason: collision with root package name */
    private final b f3569d;

    public j(String str, m<PointF, PointF> mVar, f fVar, b bVar) {
        this.f3566a = str;
        this.f3567b = mVar;
        this.f3568c = fVar;
        this.f3569d = bVar;
    }

    public String a() {
        return this.f3566a;
    }

    public b b() {
        return this.f3569d;
    }

    public f c() {
        return this.f3568c;
    }

    public m<PointF, PointF> d() {
        return this.f3567b;
    }

    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f3567b + ", size=" + this.f3568c + '}';
    }
}
