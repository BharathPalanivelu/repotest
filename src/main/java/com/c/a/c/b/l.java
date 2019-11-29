package com.c.a.c.b;

import com.c.a.c.h;
import com.c.a.c.j;
import com.c.a.c.m;
import java.security.MessageDigest;
import java.util.Map;

class l implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Object f5844b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5845c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5846d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f5847e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f5848f;

    /* renamed from: g  reason: collision with root package name */
    private final h f5849g;
    private final Map<Class<?>, m<?>> h;
    private final j i;
    private int j;

    public l(Object obj, h hVar, int i2, int i3, Map<Class<?>, m<?>> map, Class<?> cls, Class<?> cls2, j jVar) {
        this.f5844b = com.c.a.i.h.a(obj);
        this.f5849g = (h) com.c.a.i.h.a(hVar, "Signature must not be null");
        this.f5845c = i2;
        this.f5846d = i3;
        this.h = (Map) com.c.a.i.h.a(map);
        this.f5847e = (Class) com.c.a.i.h.a(cls, "Resource class must not be null");
        this.f5848f = (Class) com.c.a.i.h.a(cls2, "Transcode class must not be null");
        this.i = (j) com.c.a.i.h.a(jVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (!this.f5844b.equals(lVar.f5844b) || !this.f5849g.equals(lVar.f5849g) || this.f5846d != lVar.f5846d || this.f5845c != lVar.f5845c || !this.h.equals(lVar.h) || !this.f5847e.equals(lVar.f5847e) || !this.f5848f.equals(lVar.f5848f) || !this.i.equals(lVar.i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.j == 0) {
            this.j = this.f5844b.hashCode();
            this.j = (this.j * 31) + this.f5849g.hashCode();
            this.j = (this.j * 31) + this.f5845c;
            this.j = (this.j * 31) + this.f5846d;
            this.j = (this.j * 31) + this.h.hashCode();
            this.j = (this.j * 31) + this.f5847e.hashCode();
            this.j = (this.j * 31) + this.f5848f.hashCode();
            this.j = (this.j * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f5844b + ", width=" + this.f5845c + ", height=" + this.f5846d + ", resourceClass=" + this.f5847e + ", transcodeClass=" + this.f5848f + ", signature=" + this.f5849g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }

    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
