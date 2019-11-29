package io.b.e.e.e;

import io.b.b.b;
import io.b.p;
import io.b.q;
import io.b.s;
import io.b.u;
import java.util.concurrent.atomic.AtomicReference;

public final class f<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f33471a;

    /* renamed from: b  reason: collision with root package name */
    final p f33472b;

    public f(u<T> uVar, p pVar) {
        this.f33471a = uVar;
        this.f33472b = pVar;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super T> sVar) {
        this.f33471a.a(new a(sVar, this.f33472b));
    }

    static final class a<T> extends AtomicReference<b> implements b, s<T>, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final s<? super T> actual;
        Throwable error;
        final p scheduler;
        T value;

        a(s<? super T> sVar, p pVar) {
            this.actual = sVar;
            this.scheduler = pVar;
        }

        public void a(b bVar) {
            if (io.b.e.a.b.setOnce(this, bVar)) {
                this.actual.a((b) this);
            }
        }

        public void a(T t) {
            this.value = t;
            io.b.e.a.b.replace(this, this.scheduler.a(this));
        }

        public void a(Throwable th) {
            this.error = th;
            io.b.e.a.b.replace(this, this.scheduler.a(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.a(th);
            } else {
                this.actual.a(this.value);
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
