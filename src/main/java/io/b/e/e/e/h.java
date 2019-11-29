package io.b.e.e.e;

import io.b.b.b;
import io.b.e.a.e;
import io.b.p;
import io.b.q;
import io.b.s;
import io.b.u;
import java.util.concurrent.atomic.AtomicReference;

public final class h<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f33475a;

    /* renamed from: b  reason: collision with root package name */
    final p f33476b;

    public h(u<? extends T> uVar, p pVar) {
        this.f33475a = uVar;
        this.f33476b = pVar;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super T> sVar) {
        a aVar = new a(sVar, this.f33475a);
        sVar.a((b) aVar);
        aVar.task.a(this.f33476b.a(aVar));
    }

    static final class a<T> extends AtomicReference<b> implements b, s<T>, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final s<? super T> actual;
        final u<? extends T> source;
        final e task = new e();

        a(s<? super T> sVar, u<? extends T> uVar) {
            this.actual = sVar;
            this.source = uVar;
        }

        public void a(b bVar) {
            io.b.e.a.b.setOnce(this, bVar);
        }

        public void a(T t) {
            this.actual.a(t);
        }

        public void a(Throwable th) {
            this.actual.a(th);
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((b) get());
        }

        public void run() {
            this.source.a(this);
        }
    }
}
