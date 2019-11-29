package io.b.e.e.c;

import io.b.b.b;
import io.b.h;
import io.b.i;
import io.b.p;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p f33361b;

    public d(i<T> iVar, p pVar) {
        super(iVar);
        this.f33361b = pVar;
    }

    /* access modifiers changed from: protected */
    public void b(h<? super T> hVar) {
        this.f33359a.a(new a(hVar, this.f33361b));
    }

    static final class a<T> extends AtomicReference<b> implements b, h<T>, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final h<? super T> actual;
        Throwable error;
        final p scheduler;
        T value;

        a(h<? super T> hVar, p pVar) {
            this.actual = hVar;
            this.scheduler = pVar;
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((b) get());
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

        public void a() {
            io.b.e.a.b.replace(this, this.scheduler.a(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.a(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.value = null;
                this.actual.a(t);
                return;
            }
            this.actual.a();
        }
    }
}
