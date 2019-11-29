package io.b.e.e.d;

import io.b.b.b;
import io.b.e.a.c;
import io.b.j;
import io.b.o;
import java.util.Iterator;

public final class k<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends T> f33418a;

    public k(Iterable<? extends T> iterable) {
        this.f33418a = iterable;
    }

    public void b(o<? super T> oVar) {
        try {
            Iterator<? extends T> it = this.f33418a.iterator();
            try {
                if (!it.hasNext()) {
                    c.complete((o<?>) oVar);
                    return;
                }
                a aVar = new a(oVar, it);
                oVar.a((b) aVar);
                if (!aVar.f33422d) {
                    aVar.a();
                }
            } catch (Throwable th) {
                io.b.c.b.b(th);
                c.error(th, (o<?>) oVar);
            }
        } catch (Throwable th2) {
            io.b.c.b.b(th2);
            c.error(th2, (o<?>) oVar);
        }
    }

    static final class a<T> extends io.b.e.d.c<T> {

        /* renamed from: a  reason: collision with root package name */
        final o<? super T> f33419a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<? extends T> f33420b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f33421c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33422d;

        /* renamed from: e  reason: collision with root package name */
        boolean f33423e;

        /* renamed from: f  reason: collision with root package name */
        boolean f33424f;

        a(o<? super T> oVar, Iterator<? extends T> it) {
            this.f33419a = oVar;
            this.f33420b = it;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            while (!isDisposed()) {
                try {
                    this.f33419a.a(io.b.e.b.b.a(this.f33420b.next(), "The iterator returned a null value"));
                    if (!isDisposed()) {
                        try {
                            if (!this.f33420b.hasNext()) {
                                if (!isDisposed()) {
                                    this.f33419a.a();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            io.b.c.b.b(th);
                            this.f33419a.a(th);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    io.b.c.b.b(th2);
                    this.f33419a.a(th2);
                    return;
                }
            }
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f33422d = true;
            return 1;
        }

        public T poll() {
            if (this.f33423e) {
                return null;
            }
            if (!this.f33424f) {
                this.f33424f = true;
            } else if (!this.f33420b.hasNext()) {
                this.f33423e = true;
                return null;
            }
            return io.b.e.b.b.a(this.f33420b.next(), "The iterator returned a null value");
        }

        public boolean isEmpty() {
            return this.f33423e;
        }

        public void clear() {
            this.f33423e = true;
        }

        public void dispose() {
            this.f33421c = true;
        }

        public boolean isDisposed() {
            return this.f33421c;
        }
    }
}
