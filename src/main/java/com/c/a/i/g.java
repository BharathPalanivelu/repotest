package com.c.a.i;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f6254a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f6255b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f6256c;

    public g() {
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public g(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(Class<?> cls, Class<?> cls2) {
        a(cls, cls2, (Class<?>) null);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f6254a = cls;
        this.f6255b = cls2;
        this.f6256c = cls3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f6254a + ", second=" + this.f6255b + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f6254a.equals(gVar.f6254a) && this.f6255b.equals(gVar.f6255b) && i.a((Object) this.f6256c, (Object) gVar.f6256c);
    }

    public int hashCode() {
        int hashCode = ((this.f6254a.hashCode() * 31) + this.f6255b.hashCode()) * 31;
        Class<?> cls = this.f6256c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }
}
