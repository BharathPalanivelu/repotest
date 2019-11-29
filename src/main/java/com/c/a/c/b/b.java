package com.c.a.c.b;

import com.c.a.c.h;
import java.security.MessageDigest;

final class b implements h {

    /* renamed from: b  reason: collision with root package name */
    private final h f5723b;

    /* renamed from: c  reason: collision with root package name */
    private final h f5724c;

    public b(h hVar, h hVar2) {
        this.f5723b = hVar;
        this.f5724c = hVar2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f5723b.equals(bVar.f5723b) || !this.f5724c.equals(bVar.f5724c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f5723b.hashCode() * 31) + this.f5724c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f5723b + ", signature=" + this.f5724c + '}';
    }

    public void a(MessageDigest messageDigest) {
        this.f5723b.a(messageDigest);
        this.f5724c.a(messageDigest);
    }
}
