package io.b.e.e.d;

import io.b.d.j;
import io.b.m;
import io.b.o;

public final class h<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final j<? super T> f33404b;

    public h(m<T> mVar, j<? super T> jVar) {
        super(mVar);
        this.f33404b = jVar;
    }

    public void b(o<? super T> oVar) {
        this.f33374a.a(new a(oVar, this.f33404b));
    }

    static final class a<T> extends io.b.e.d.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final j<? super T> f33405f;

        a(o<? super T> oVar, j<? super T> jVar) {
            super(oVar);
            this.f33405f = jVar;
        }

        public void a(T t) {
            if (this.f33342e == 0) {
                try {
                    if (this.f33405f.a(t)) {
                        this.f33338a.a(t);
                    }
                } catch (Throwable th) {
                    b(th);
                }
            } else {
                this.f33338a.a(null);
            }
        }

        public int requestFusion(int i) {
            return a(i);
        }

        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f33340c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f33405f.a(poll));
            return poll;
        }
    }
}
