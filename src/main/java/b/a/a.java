package b.a;

import javax.inject.Provider;

public final class a<T> implements b.a<T>, Provider<T> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3067a = (!a.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3068b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private volatile Provider<T> f3069c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f3070d = f3068b;

    private a(Provider<T> provider) {
        if (f3067a || provider != null) {
            this.f3069c = provider;
            return;
        }
        throw new AssertionError();
    }

    public T get() {
        T t = this.f3070d;
        if (t == f3068b) {
            synchronized (this) {
                t = this.f3070d;
                if (t == f3068b) {
                    t = this.f3069c.get();
                    T t2 = this.f3070d;
                    if (t2 != f3068b) {
                        if (t2 != t) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + t2 + " & " + t + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.f3070d = t;
                    this.f3069c = null;
                }
            }
        }
        return t;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p) {
        c.a(p);
        if (p instanceof a) {
            return p;
        }
        return new a(p);
    }

    public static <P extends Provider<T>, T> b.a<T> b(P p) {
        if (p instanceof b.a) {
            return (b.a) p;
        }
        return new a((Provider) c.a(p));
    }
}
