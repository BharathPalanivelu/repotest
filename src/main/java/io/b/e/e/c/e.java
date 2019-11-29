package io.b.e.e.c;

import io.b.b.b;
import io.b.d.f;
import io.b.e.a.c;
import io.b.h;
import io.b.i;

public final class e<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final f<? super b> f33362b;

    /* renamed from: c  reason: collision with root package name */
    final f<? super T> f33363c;

    /* renamed from: d  reason: collision with root package name */
    final f<? super Throwable> f33364d;

    /* renamed from: e  reason: collision with root package name */
    final io.b.d.a f33365e;

    /* renamed from: f  reason: collision with root package name */
    final io.b.d.a f33366f;

    /* renamed from: g  reason: collision with root package name */
    final io.b.d.a f33367g;

    public e(i<T> iVar, f<? super b> fVar, f<? super T> fVar2, f<? super Throwable> fVar3, io.b.d.a aVar, io.b.d.a aVar2, io.b.d.a aVar3) {
        super(iVar);
        this.f33362b = fVar;
        this.f33363c = fVar2;
        this.f33364d = fVar3;
        this.f33365e = aVar;
        this.f33366f = aVar2;
        this.f33367g = aVar3;
    }

    /* access modifiers changed from: protected */
    public void b(h<? super T> hVar) {
        this.f33359a.a(new a(hVar, this));
    }

    static final class a<T> implements b, h<T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f33368a;

        /* renamed from: b  reason: collision with root package name */
        final e<T> f33369b;

        /* renamed from: c  reason: collision with root package name */
        b f33370c;

        a(h<? super T> hVar, e<T> eVar) {
            this.f33368a = hVar;
            this.f33369b = eVar;
        }

        public void dispose() {
            try {
                this.f33369b.f33367g.a();
            } catch (Throwable th) {
                io.b.c.b.b(th);
                io.b.g.a.a(th);
            }
            this.f33370c.dispose();
            this.f33370c = io.b.e.a.b.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f33370c.isDisposed();
        }

        public void a(b bVar) {
            if (io.b.e.a.b.validate(this.f33370c, bVar)) {
                try {
                    this.f33369b.f33362b.accept(bVar);
                    this.f33370c = bVar;
                    this.f33368a.a((b) this);
                } catch (Throwable th) {
                    io.b.c.b.b(th);
                    bVar.dispose();
                    this.f33370c = io.b.e.a.b.DISPOSED;
                    c.error(th, (h<?>) this.f33368a);
                }
            }
        }

        public void a(T t) {
            if (this.f33370c != io.b.e.a.b.DISPOSED) {
                try {
                    this.f33369b.f33363c.accept(t);
                    this.f33370c = io.b.e.a.b.DISPOSED;
                    this.f33368a.a(t);
                    b();
                } catch (Throwable th) {
                    io.b.c.b.b(th);
                    b(th);
                }
            }
        }

        public void a(Throwable th) {
            if (this.f33370c == io.b.e.a.b.DISPOSED) {
                io.b.g.a.a(th);
            } else {
                b(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            try {
                this.f33369b.f33364d.accept(th);
            } catch (Throwable th2) {
                io.b.c.b.b(th2);
                th = new io.b.c.a(th, th2);
            }
            this.f33370c = io.b.e.a.b.DISPOSED;
            this.f33368a.a(th);
            b();
        }

        public void a() {
            if (this.f33370c != io.b.e.a.b.DISPOSED) {
                try {
                    this.f33369b.f33365e.a();
                    this.f33370c = io.b.e.a.b.DISPOSED;
                    this.f33368a.a();
                    b();
                } catch (Throwable th) {
                    io.b.c.b.b(th);
                    b(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            try {
                this.f33369b.f33366f.a();
            } catch (Throwable th) {
                io.b.c.b.b(th);
                io.b.g.a.a(th);
            }
        }
    }
}
