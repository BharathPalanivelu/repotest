package io.b.e.e.e;

import io.b.d.g;
import io.b.q;
import io.b.s;
import io.b.u;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T, R> extends q<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f33461a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends u<? extends R>> f33462b;

    public b(u<? extends T> uVar, g<? super T, ? extends u<? extends R>> gVar) {
        this.f33462b = gVar;
        this.f33461a = uVar;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super R> sVar) {
        this.f33461a.a(new a(sVar, this.f33462b));
    }

    static final class a<T, R> extends AtomicReference<io.b.b.b> implements io.b.b.b, s<T> {
        private static final long serialVersionUID = 3258103020495908596L;
        final s<? super R> actual;
        final g<? super T, ? extends u<? extends R>> mapper;

        a(s<? super R> sVar, g<? super T, ? extends u<? extends R>> gVar) {
            this.actual = sVar;
            this.mapper = gVar;
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((io.b.b.b) get());
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.setOnce(this, bVar)) {
                this.actual.a((io.b.b.b) this);
            }
        }

        public void a(T t) {
            try {
                u uVar = (u) io.b.e.b.b.a(this.mapper.apply(t), "The single returned by the mapper is null");
                if (!isDisposed()) {
                    uVar.a(new C0520a(this, this.actual));
                }
            } catch (Throwable th) {
                io.b.c.b.b(th);
                this.actual.a(th);
            }
        }

        public void a(Throwable th) {
            this.actual.a(th);
        }

        /* renamed from: io.b.e.e.e.b$a$a  reason: collision with other inner class name */
        static final class C0520a<R> implements s<R> {

            /* renamed from: a  reason: collision with root package name */
            final AtomicReference<io.b.b.b> f33463a;

            /* renamed from: b  reason: collision with root package name */
            final s<? super R> f33464b;

            C0520a(AtomicReference<io.b.b.b> atomicReference, s<? super R> sVar) {
                this.f33463a = atomicReference;
                this.f33464b = sVar;
            }

            public void a(io.b.b.b bVar) {
                io.b.e.a.b.replace(this.f33463a, bVar);
            }

            public void a(R r) {
                this.f33464b.a(r);
            }

            public void a(Throwable th) {
                this.f33464b.a(th);
            }
        }
    }
}
