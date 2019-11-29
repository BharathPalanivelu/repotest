package io.b.e.e.e;

import io.b.b.b;
import io.b.q;
import io.b.r;
import io.b.s;
import io.b.t;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final t<T> f33460a;

    public a(t<T> tVar) {
        this.f33460a = tVar;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super T> sVar) {
        C0519a aVar = new C0519a(sVar);
        sVar.a((b) aVar);
        try {
            this.f33460a.subscribe(aVar);
        } catch (Throwable th) {
            io.b.c.b.b(th);
            aVar.a(th);
        }
    }

    /* renamed from: io.b.e.e.e.a$a  reason: collision with other inner class name */
    static final class C0519a<T> extends AtomicReference<b> implements b, r<T> {
        private static final long serialVersionUID = -2467358622224974244L;
        final s<? super T> actual;

        C0519a(s<? super T> sVar) {
            this.actual = sVar;
        }

        public void a(T t) {
            if (get() != io.b.e.a.b.DISPOSED) {
                b bVar = (b) getAndSet(io.b.e.a.b.DISPOSED);
                if (bVar != io.b.e.a.b.DISPOSED) {
                    if (t == null) {
                        try {
                            this.actual.a((Throwable) new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } catch (Throwable th) {
                            if (bVar != null) {
                                bVar.dispose();
                            }
                            throw th;
                        }
                    } else {
                        this.actual.a(t);
                    }
                    if (bVar != null) {
                        bVar.dispose();
                    }
                }
            }
        }

        public void a(Throwable th) {
            if (!b(th)) {
                io.b.g.a.a(th);
            }
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() == io.b.e.a.b.DISPOSED) {
                return false;
            }
            b bVar = (b) getAndSet(io.b.e.a.b.DISPOSED);
            if (bVar == io.b.e.a.b.DISPOSED) {
                return false;
            }
            try {
                this.actual.a(th);
            } finally {
                if (bVar != null) {
                    bVar.dispose();
                }
            }
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((b) get());
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }
}
