package io.b.e.e.d;

import io.b.b.b;
import io.b.g;
import io.b.h;
import io.b.m;
import io.b.o;

public final class r<T> extends g<T> {

    /* renamed from: a  reason: collision with root package name */
    final m<T> f33437a;

    public r(m<T> mVar) {
        this.f33437a = mVar;
    }

    public void b(h<? super T> hVar) {
        this.f33437a.a(new a(hVar));
    }

    static final class a<T> implements b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f33438a;

        /* renamed from: b  reason: collision with root package name */
        b f33439b;

        /* renamed from: c  reason: collision with root package name */
        T f33440c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33441d;

        a(h<? super T> hVar) {
            this.f33438a = hVar;
        }

        public void a(b bVar) {
            if (io.b.e.a.b.validate(this.f33439b, bVar)) {
                this.f33439b = bVar;
                this.f33438a.a((b) this);
            }
        }

        public void dispose() {
            this.f33439b.dispose();
        }

        public boolean isDisposed() {
            return this.f33439b.isDisposed();
        }

        public void a(T t) {
            if (!this.f33441d) {
                if (this.f33440c != null) {
                    this.f33441d = true;
                    this.f33439b.dispose();
                    this.f33438a.a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f33440c = t;
            }
        }

        public void a(Throwable th) {
            if (this.f33441d) {
                io.b.g.a.a(th);
                return;
            }
            this.f33441d = true;
            this.f33438a.a(th);
        }

        public void a() {
            if (!this.f33441d) {
                this.f33441d = true;
                T t = this.f33440c;
                this.f33440c = null;
                if (t == null) {
                    this.f33438a.a();
                } else {
                    this.f33438a.a(t);
                }
            }
        }
    }
}
