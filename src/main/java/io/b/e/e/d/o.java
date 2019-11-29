package io.b.e.e.d;

import io.b.d.g;
import io.b.e.b.b;
import io.b.m;

public final class o<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends U> f33430b;

    public o(m<T> mVar, g<? super T, ? extends U> gVar) {
        super(mVar);
        this.f33430b = gVar;
    }

    public void b(io.b.o<? super U> oVar) {
        this.f33374a.a(new a(oVar, this.f33430b));
    }

    static final class a<T, U> extends io.b.e.d.a<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final g<? super T, ? extends U> f33431f;

        a(io.b.o<? super U> oVar, g<? super T, ? extends U> gVar) {
            super(oVar);
            this.f33431f = gVar;
        }

        public void a(T t) {
            if (!this.f33341d) {
                if (this.f33342e != 0) {
                    this.f33338a.a(null);
                    return;
                }
                try {
                    this.f33338a.a(b.a(this.f33431f.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    b(th);
                }
            }
        }

        public int requestFusion(int i) {
            return a(i);
        }

        public U poll() throws Exception {
            Object poll = this.f33340c.poll();
            if (poll != null) {
                return b.a(this.f33431f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
