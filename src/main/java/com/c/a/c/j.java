package com.c.a.c;

import androidx.b.a;
import java.security.MessageDigest;
import java.util.Map;

public final class j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final a<i<?>, Object> f6113b = new a<>();

    public void a(j jVar) {
        this.f6113b.a(jVar.f6113b);
    }

    public <T> j a(i<T> iVar, T t) {
        this.f6113b.put(iVar, t);
        return this;
    }

    public <T> T a(i<T> iVar) {
        return this.f6113b.containsKey(iVar) ? this.f6113b.get(iVar) : iVar.a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f6113b.equals(((j) obj).f6113b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6113b.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        for (Map.Entry next : this.f6113b.entrySet()) {
            a((i) next.getKey(), next.getValue(), messageDigest);
        }
    }

    public String toString() {
        return "Options{values=" + this.f6113b + '}';
    }

    private static <T> void a(i<T> iVar, Object obj, MessageDigest messageDigest) {
        iVar.a(obj, messageDigest);
    }
}
