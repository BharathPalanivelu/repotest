package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.f;

public class q implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3596a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3597b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3598c;

    /* renamed from: d  reason: collision with root package name */
    private final b f3599d;

    /* renamed from: e  reason: collision with root package name */
    private final b f3600e;

    public enum a {
        Simultaneously,
        Individually;

        public static a forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public q(String str, a aVar, b bVar, b bVar2, b bVar3) {
        this.f3596a = str;
        this.f3597b = aVar;
        this.f3598c = bVar;
        this.f3599d = bVar2;
        this.f3600e = bVar3;
    }

    public String a() {
        return this.f3596a;
    }

    public a b() {
        return this.f3597b;
    }

    public b c() {
        return this.f3599d;
    }

    public b d() {
        return this.f3598c;
    }

    public b e() {
        return this.f3600e;
    }

    public com.airbnb.lottie.a.a.b a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f3598c + ", end: " + this.f3599d + ", offset: " + this.f3600e + "}";
    }
}
