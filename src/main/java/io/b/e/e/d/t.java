package io.b.e.e.d;

import io.b.m;
import io.b.o;
import io.b.p;
import java.util.concurrent.atomic.AtomicReference;

public final class t<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p f33449b;

    public t(m<T> mVar, p pVar) {
        super(mVar);
        this.f33449b = pVar;
    }

    public void b(o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.a((io.b.b.b) aVar);
        aVar.b(this.f33449b.a(new b(aVar)));
    }

    static final class a<T> extends AtomicReference<io.b.b.b> implements io.b.b.b, o<T> {
        private static final long serialVersionUID = 8094547886072529208L;
        final o<? super T> actual;
        final AtomicReference<io.b.b.b> s = new AtomicReference<>();

        a(o<? super T> oVar) {
            this.actual = oVar;
        }

        public void a(io.b.b.b bVar) {
            io.b.e.a.b.setOnce(this.s, bVar);
        }

        public void a(T t) {
            this.actual.a(t);
        }

        public void a(Throwable th) {
            this.actual.a(th);
        }

        public void a() {
            this.actual.a();
        }

        public void dispose() {
            io.b.e.a.b.dispose(this.s);
            io.b.e.a.b.dispose(this);
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((io.b.b.b) get());
        }

        /* access modifiers changed from: package-private */
        public void b(io.b.b.b bVar) {
            io.b.e.a.b.setOnce(this, bVar);
        }
    }

    final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final a<T> f33451b;

        b(a<T> aVar) {
            this.f33451b = aVar;
        }

        public void run() {
            t.this.f33374a.a(this.f33451b);
        }
    }
}
