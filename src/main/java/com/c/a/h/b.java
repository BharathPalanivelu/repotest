package com.c.a.h;

import com.c.a.c.h;
import java.security.MessageDigest;

public final class b implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Object f6220b;

    public b(Object obj) {
        this.f6220b = com.c.a.i.h.a(obj);
    }

    public String toString() {
        return "ObjectKey{object=" + this.f6220b + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f6220b.equals(((b) obj).f6220b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6220b.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f6220b.toString().getBytes(f6107a));
    }
}
