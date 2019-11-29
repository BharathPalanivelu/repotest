package com.google.zxing.d.a.a;

import com.google.zxing.d.a.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14559a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.zxing.d.a.b f14560b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.zxing.d.a.b f14561c;

    /* renamed from: d  reason: collision with root package name */
    private final c f14562d;

    b(com.google.zxing.d.a.b bVar, com.google.zxing.d.a.b bVar2, c cVar, boolean z) {
        this.f14560b = bVar;
        this.f14561c = bVar2;
        this.f14562d = cVar;
        this.f14559a = z;
    }

    /* access modifiers changed from: package-private */
    public com.google.zxing.d.a.b a() {
        return this.f14560b;
    }

    /* access modifiers changed from: package-private */
    public com.google.zxing.d.a.b b() {
        return this.f14561c;
    }

    /* access modifiers changed from: package-private */
    public c c() {
        return this.f14562d;
    }

    public boolean d() {
        return this.f14561c == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f14560b);
        sb.append(" , ");
        sb.append(this.f14561c);
        sb.append(" : ");
        c cVar = this.f14562d;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.a()));
        sb.append(" ]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!a(this.f14560b, bVar.f14560b) || !a(this.f14561c, bVar.f14561c) || !a(this.f14562d, bVar.f14562d)) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        return (a(this.f14560b) ^ a(this.f14561c)) ^ a(this.f14562d);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
