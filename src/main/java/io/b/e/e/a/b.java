package io.b.e.e.a;

import io.b.c;
import io.b.d;
import io.b.e.a.e;
import io.b.p;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends io.b.b {

    /* renamed from: a  reason: collision with root package name */
    final d f33350a;

    /* renamed from: b  reason: collision with root package name */
    final p f33351b;

    public b(d dVar, p pVar) {
        this.f33350a = dVar;
        this.f33351b = pVar;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        a aVar = new a(cVar, this.f33350a);
        cVar.a((io.b.b.b) aVar);
        aVar.task.a(this.f33351b.a(aVar));
    }

    static final class a extends AtomicReference<io.b.b.b> implements io.b.b.b, c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final c actual;
        final d source;
        final e task = new e();

        a(c cVar, d dVar) {
            this.actual = cVar;
            this.source = dVar;
        }

        public void run() {
            this.source.a(this);
        }

        public void a(io.b.b.b bVar) {
            io.b.e.a.b.setOnce(this, bVar);
        }

        public void a(Throwable th) {
            this.actual.a(th);
        }

        public void a() {
            this.actual.a();
        }

        public void dispose() {
            io.b.e.a.b.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return io.b.e.a.b.isDisposed((io.b.b.b) get());
        }
    }
}
