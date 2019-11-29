package io.b.e.e.d;

import io.b.b;
import io.b.c;
import io.b.o;

public final class m<T> extends b {

    /* renamed from: a  reason: collision with root package name */
    final io.b.m<T> f33426a;

    public m(io.b.m<T> mVar) {
        this.f33426a = mVar;
    }

    public void b(c cVar) {
        this.f33426a.a(new a(cVar));
    }

    static final class a<T> implements io.b.b.b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        final c f33427a;

        /* renamed from: b  reason: collision with root package name */
        io.b.b.b f33428b;

        public void a(T t) {
        }

        a(c cVar) {
            this.f33427a = cVar;
        }

        public void a(io.b.b.b bVar) {
            this.f33428b = bVar;
            this.f33427a.a((io.b.b.b) this);
        }

        public void a(Throwable th) {
            this.f33427a.a(th);
        }

        public void a() {
            this.f33427a.a();
        }

        public void dispose() {
            this.f33428b.dispose();
        }

        public boolean isDisposed() {
            return this.f33428b.isDisposed();
        }
    }
}
