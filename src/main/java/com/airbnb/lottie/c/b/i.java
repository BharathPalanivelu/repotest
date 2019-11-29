package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.f;

public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3559a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3560b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3561c;

    /* renamed from: d  reason: collision with root package name */
    private final m<PointF, PointF> f3562d;

    /* renamed from: e  reason: collision with root package name */
    private final b f3563e;

    /* renamed from: f  reason: collision with root package name */
    private final b f3564f;

    /* renamed from: g  reason: collision with root package name */
    private final b f3565g;
    private final b h;
    private final b i;

    public enum a {
        Star(1),
        Polygon(2);
        
        private final int value;

        private a(int i) {
            this.value = i;
        }

        public static a forValue(int i) {
            for (a aVar : values()) {
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6) {
        this.f3559a = str;
        this.f3560b = aVar;
        this.f3561c = bVar;
        this.f3562d = mVar;
        this.f3563e = bVar2;
        this.f3564f = bVar3;
        this.f3565g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
    }

    public String a() {
        return this.f3559a;
    }

    public a b() {
        return this.f3560b;
    }

    public b c() {
        return this.f3561c;
    }

    public m<PointF, PointF> d() {
        return this.f3562d;
    }

    public b e() {
        return this.f3563e;
    }

    public b f() {
        return this.f3564f;
    }

    public b g() {
        return this.f3565g;
    }

    public b h() {
        return this.h;
    }

    public b i() {
        return this.i;
    }

    public com.airbnb.lottie.a.a.b a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new com.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
