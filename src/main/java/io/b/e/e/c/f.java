package io.b.e.e.c;

import io.b.e.a.e;
import io.b.h;
import io.b.i;
import io.b.p;
import java.util.concurrent.atomic.AtomicReference;

public final class f<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p f33371b;

    public f(i<T> iVar, p pVar) {
        super(iVar);
        this.f33371b = pVar;
    }

    /* access modifiers changed from: protected */
    public void b(h<? super T> hVar) {
        a aVar = new a(hVar);
        hVar.a((io.b.b.b) aVar);
        aVar.task.a(this.f33371b.a(new b(aVar, this.f33359a)));
    }

    static final class b<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f33372a;

        /* renamed from: b  reason: collision with root package name */
        final i<T> f33373b;

        b(h<? super T> hVar, i<T> iVar) {
            this.f33372a = hVar;
            this.f33373b = iVar;
        }

        public void run() {
            this.f33373b.a(this.f33372a);
        }
    }

    static final class a<T> extends AtomicReference<io.b.b.b> implements io.b.b.b, h<T> {
        private static final long serialVersionUID = 8571289934935992137L;
        final h<? super T> actual;
        final e task = new e();

        a(h<? super T> hVar) {
            this.actual = hVar;
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((io.b.b.b) get());
        }

        public void a(io.b.b.b bVar) {
            io.b.e.a.b.setOnce(this, bVar);
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
    }
}
