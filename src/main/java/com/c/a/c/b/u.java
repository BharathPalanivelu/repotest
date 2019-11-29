package com.c.a.c.b;

import com.c.a.c.h;
import com.c.a.c.j;
import com.c.a.c.m;
import com.c.a.i.e;
import com.c.a.i.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class u implements h {

    /* renamed from: b  reason: collision with root package name */
    private static final e<Class<?>, byte[]> f5875b = new e<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final h f5876c;

    /* renamed from: d  reason: collision with root package name */
    private final h f5877d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5878e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5879f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f5880g;
    private final j h;
    private final m<?> i;

    public u(h hVar, h hVar2, int i2, int i3, m<?> mVar, Class<?> cls, j jVar) {
        this.f5876c = hVar;
        this.f5877d = hVar2;
        this.f5878e = i2;
        this.f5879f = i3;
        this.i = mVar;
        this.f5880g = cls;
        this.h = jVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f5879f != uVar.f5879f || this.f5878e != uVar.f5878e || !i.a((Object) this.i, (Object) uVar.i) || !this.f5880g.equals(uVar.f5880g) || !this.f5876c.equals(uVar.f5876c) || !this.f5877d.equals(uVar.f5877d) || !this.h.equals(uVar.h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((this.f5876c.hashCode() * 31) + this.f5877d.hashCode()) * 31) + this.f5878e) * 31) + this.f5879f;
        m<?> mVar = this.i;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return (((hashCode * 31) + this.f5880g.hashCode()) * 31) + this.h.hashCode();
    }

    public void a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f5878e).putInt(this.f5879f).array();
        this.f5877d.a(messageDigest);
        this.f5876c.a(messageDigest);
        messageDigest.update(array);
        m<?> mVar = this.i;
        if (mVar != null) {
            mVar.a(messageDigest);
        }
        this.h.a(messageDigest);
        messageDigest.update(a());
    }

    private byte[] a() {
        byte[] b2 = f5875b.b(this.f5880g);
        if (b2 != null) {
            return b2;
        }
        byte[] bytes = this.f5880g.getName().getBytes(f6107a);
        f5875b.b(this.f5880g, bytes);
        return bytes;
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f5876c + ", signature=" + this.f5877d + ", width=" + this.f5878e + ", height=" + this.f5879f + ", decodedResourceClass=" + this.f5880g + ", transformation='" + this.i + '\'' + ", options=" + this.h + '}';
    }
}
