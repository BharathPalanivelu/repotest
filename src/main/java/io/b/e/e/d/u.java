package io.b.e.e.d;

import io.b.b.b;
import io.b.e.a.c;
import io.b.j;
import io.b.o;
import io.b.p;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class u extends j<Long> {

    /* renamed from: a  reason: collision with root package name */
    final p f33452a;

    /* renamed from: b  reason: collision with root package name */
    final long f33453b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f33454c;

    public u(long j, TimeUnit timeUnit, p pVar) {
        this.f33453b = j;
        this.f33454c = timeUnit;
        this.f33452a = pVar;
    }

    public void b(o<? super Long> oVar) {
        a aVar = new a(oVar);
        oVar.a((b) aVar);
        aVar.a(this.f33452a.a(aVar, this.f33453b, this.f33454c));
    }

    static final class a extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final o<? super Long> actual;

        a(o<? super Long> oVar) {
            this.actual = oVar;
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
        }

        public boolean isDisposed() {
            return get() == io.b.e.a.b.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.actual.a(0L);
                lazySet(c.INSTANCE);
                this.actual.a();
            }
        }

        public void a(b bVar) {
            io.b.e.a.b.trySet(this, bVar);
        }
    }
}
