package io.b.e.e.d;

import io.b.b.b;
import io.b.m;
import io.b.o;
import io.b.q;
import io.b.s;
import java.util.NoSuchElementException;

public final class f<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final m<T> f33394a;

    /* renamed from: b  reason: collision with root package name */
    final long f33395b;

    /* renamed from: c  reason: collision with root package name */
    final T f33396c;

    public f(m<T> mVar, long j, T t) {
        this.f33394a = mVar;
        this.f33395b = j;
        this.f33396c = t;
    }

    public void b(s<? super T> sVar) {
        this.f33394a.a(new a(sVar, this.f33395b, this.f33396c));
    }

    static final class a<T> implements b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        final s<? super T> f33397a;

        /* renamed from: b  reason: collision with root package name */
        final long f33398b;

        /* renamed from: c  reason: collision with root package name */
        final T f33399c;

        /* renamed from: d  reason: collision with root package name */
        b f33400d;

        /* renamed from: e  reason: collision with root package name */
        long f33401e;

        /* renamed from: f  reason: collision with root package name */
        boolean f33402f;

        a(s<? super T> sVar, long j, T t) {
            this.f33397a = sVar;
            this.f33398b = j;
            this.f33399c = t;
        }

        public void a(b bVar) {
            if (io.b.e.a.b.validate(this.f33400d, bVar)) {
                this.f33400d = bVar;
                this.f33397a.a((b) this);
            }
        }

        public void dispose() {
            this.f33400d.dispose();
        }

        public boolean isDisposed() {
            return this.f33400d.isDisposed();
        }

        public void a(T t) {
            if (!this.f33402f) {
                long j = this.f33401e;
                if (j == this.f33398b) {
                    this.f33402f = true;
                    this.f33400d.dispose();
                    this.f33397a.a(t);
                    return;
                }
                this.f33401e = j + 1;
            }
        }

        public void a(Throwable th) {
            if (this.f33402f) {
                io.b.g.a.a(th);
                return;
            }
            this.f33402f = true;
            this.f33397a.a(th);
        }

        public void a() {
            if (!this.f33402f) {
                this.f33402f = true;
                T t = this.f33399c;
                if (t != null) {
                    this.f33397a.a(t);
                } else {
                    this.f33397a.a((Throwable) new NoSuchElementException());
                }
            }
        }
    }
}
