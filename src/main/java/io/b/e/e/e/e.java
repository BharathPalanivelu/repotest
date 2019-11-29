package io.b.e.e.e;

import io.b.b.b;
import io.b.d.g;
import io.b.q;
import io.b.s;
import io.b.u;

public final class e<T, R> extends q<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f33467a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends R> f33468b;

    public e(u<? extends T> uVar, g<? super T, ? extends R> gVar) {
        this.f33467a = uVar;
        this.f33468b = gVar;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super R> sVar) {
        this.f33467a.a(new a(sVar, this.f33468b));
    }

    static final class a<T, R> implements s<T> {

        /* renamed from: a  reason: collision with root package name */
        final s<? super R> f33469a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T, ? extends R> f33470b;

        a(s<? super R> sVar, g<? super T, ? extends R> gVar) {
            this.f33469a = sVar;
            this.f33470b = gVar;
        }

        public void a(b bVar) {
            this.f33469a.a(bVar);
        }

        public void a(T t) {
            try {
                this.f33469a.a(io.b.e.b.b.a(this.f33470b.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.b.c.b.b(th);
                a(th);
            }
        }

        public void a(Throwable th) {
            this.f33469a.a(th);
        }
    }
}
