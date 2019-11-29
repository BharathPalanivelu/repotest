package io.b.e.e.d;

import io.b.b.b;
import io.b.m;
import io.b.o;
import io.b.q;
import java.util.NoSuchElementException;

public final class s<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final m<? extends T> f33442a;

    /* renamed from: b  reason: collision with root package name */
    final T f33443b;

    public s(m<? extends T> mVar, T t) {
        this.f33442a = mVar;
        this.f33443b = t;
    }

    public void b(io.b.s<? super T> sVar) {
        this.f33442a.a(new a(sVar, this.f33443b));
    }

    static final class a<T> implements b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        final io.b.s<? super T> f33444a;

        /* renamed from: b  reason: collision with root package name */
        final T f33445b;

        /* renamed from: c  reason: collision with root package name */
        b f33446c;

        /* renamed from: d  reason: collision with root package name */
        T f33447d;

        /* renamed from: e  reason: collision with root package name */
        boolean f33448e;

        a(io.b.s<? super T> sVar, T t) {
            this.f33444a = sVar;
            this.f33445b = t;
        }

        public void a(b bVar) {
            if (io.b.e.a.b.validate(this.f33446c, bVar)) {
                this.f33446c = bVar;
                this.f33444a.a((b) this);
            }
        }

        public void dispose() {
            this.f33446c.dispose();
        }

        public boolean isDisposed() {
            return this.f33446c.isDisposed();
        }

        public void a(T t) {
            if (!this.f33448e) {
                if (this.f33447d != null) {
                    this.f33448e = true;
                    this.f33446c.dispose();
                    this.f33444a.a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f33447d = t;
            }
        }

        public void a(Throwable th) {
            if (this.f33448e) {
                io.b.g.a.a(th);
                return;
            }
            this.f33448e = true;
            this.f33444a.a(th);
        }

        public void a() {
            if (!this.f33448e) {
                this.f33448e = true;
                T t = this.f33447d;
                this.f33447d = null;
                if (t == null) {
                    t = this.f33445b;
                }
                if (t != null) {
                    this.f33444a.a(t);
                } else {
                    this.f33444a.a((Throwable) new NoSuchElementException());
                }
            }
        }
    }
}
