package com.google.android.libraries.places.internal;

public final class nv<T> implements ny<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f13053a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile ny<T> f13054b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f13055c = f13053a;

    private nv(ny<T> nyVar) {
        this.f13054b = nyVar;
    }

    public final T b() {
        T t = this.f13055c;
        if (t == f13053a) {
            synchronized (this) {
                t = this.f13055c;
                if (t == f13053a) {
                    t = this.f13054b.b();
                    T t2 = this.f13055c;
                    if (t2 != f13053a && !(t2 instanceof nx)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f13055c = t;
                    this.f13054b = null;
                }
            }
        }
        return t;
    }

    public static <P extends ny<T>, T> ny<T> a(P p) {
        lt.b(p);
        if (p instanceof nv) {
            return p;
        }
        return new nv(p);
    }
}
