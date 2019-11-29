package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.e;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3534a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f3535b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3536c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3537d;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z) {
        this.f3534a = str;
        this.f3535b = mVar;
        this.f3536c = fVar;
        this.f3537d = z;
    }

    public b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new e(fVar, aVar, this);
    }

    public String a() {
        return this.f3534a;
    }

    public m<PointF, PointF> b() {
        return this.f3535b;
    }

    public f c() {
        return this.f3536c;
    }

    public boolean d() {
        return this.f3537d;
    }
}
