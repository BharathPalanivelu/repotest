package io.b.e.e.d;

import io.b.b.b;
import io.b.j;
import io.b.k;
import io.b.l;
import io.b.o;
import java.util.concurrent.atomic.AtomicReference;

public final class e<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    final l<T> f33393a;

    public e(l<T> lVar) {
        this.f33393a = lVar;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.a((b) aVar);
        try {
            this.f33393a.a(aVar);
        } catch (Throwable th) {
            io.b.c.b.b(th);
            aVar.a(th);
        }
    }

    static final class a<T> extends AtomicReference<b> implements b, k<T> {
        private static final long serialVersionUID = -3434801548987643227L;
        final o<? super T> observer;

        a(o<? super T> oVar) {
            this.observer = oVar;
        }

        public void a(T t) {
            if (t == null) {
                a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.observer.a(t);
            }
        }

        public void a(Throwable th) {
            if (!b(th)) {
                io.b.g.a.a(th);
            }
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.a(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
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
