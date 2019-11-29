package io.b.e.e.d;

import io.b.e.a.c;
import io.b.e.b.b;
import io.b.m;
import io.b.o;
import io.b.q;
import io.b.s;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class v<T, U extends Collection<? super T>> extends q<U> {

    /* renamed from: a  reason: collision with root package name */
    final m<T> f33455a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f33456b;

    public v(m<T> mVar, int i) {
        this.f33455a = mVar;
        this.f33456b = io.b.e.b.a.a(i);
    }

    public void b(s<? super U> sVar) {
        try {
            this.f33455a.a(new a(sVar, (Collection) b.a(this.f33456b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.b.c.b.b(th);
            c.error(th, (s<?>) sVar);
        }
    }

    static final class a<T, U extends Collection<? super T>> implements io.b.b.b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        final s<? super U> f33457a;

        /* renamed from: b  reason: collision with root package name */
        U f33458b;

        /* renamed from: c  reason: collision with root package name */
        io.b.b.b f33459c;

        a(s<? super U> sVar, U u) {
            this.f33457a = sVar;
            this.f33458b = u;
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.f33459c, bVar)) {
                this.f33459c = bVar;
                this.f33457a.a((io.b.b.b) this);
            }
        }

        public void dispose() {
            this.f33459c.dispose();
        }

        public boolean isDisposed() {
            return this.f33459c.isDisposed();
        }

        public void a(T t) {
            this.f33458b.add(t);
        }

        public void a(Throwable th) {
            this.f33458b = null;
            this.f33457a.a(th);
        }

        public void a() {
            U u = this.f33458b;
            this.f33458b = null;
            this.f33457a.a(u);
        }
    }
}
