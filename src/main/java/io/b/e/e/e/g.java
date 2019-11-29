package io.b.e.e.e;

import io.b.b.b;
import io.b.e.d.i;
import io.b.q;
import io.b.s;
import io.b.u;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f33473a;

    /* renamed from: b  reason: collision with root package name */
    final io.b.d.g<? super Throwable, ? extends u<? extends T>> f33474b;

    public g(u<? extends T> uVar, io.b.d.g<? super Throwable, ? extends u<? extends T>> gVar) {
        this.f33473a = uVar;
        this.f33474b = gVar;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super T> sVar) {
        this.f33473a.a(new a(sVar, this.f33474b));
    }

    static final class a<T> extends AtomicReference<b> implements b, s<T> {
        private static final long serialVersionUID = -5314538511045349925L;
        final s<? super T> actual;
        final io.b.d.g<? super Throwable, ? extends u<? extends T>> nextFunction;

        a(s<? super T> sVar, io.b.d.g<? super Throwable, ? extends u<? extends T>> gVar) {
            this.actual = sVar;
            this.nextFunction = gVar;
        }

        public void a(b bVar) {
            if (io.b.e.a.b.setOnce(this, bVar)) {
                this.actual.a((b) this);
            }
        }

        public void a(T t) {
            this.actual.a(t);
        }

        public void a(Throwable th) {
            try {
                ((u) io.b.e.b.b.a(this.nextFunction.apply(th), "The nextFunction returned a null SingleSource.")).a(new i(this, this.actual));
            } catch (Throwable th2) {
                io.b.c.b.b(th2);
                this.actual.a((Throwable) new io.b.c.a(th, th2));
            }
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((b) get());
        }
    }
}
