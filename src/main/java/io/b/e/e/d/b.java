package io.b.e.e.d;

import io.b.e.a.c;
import io.b.m;
import io.b.o;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final int f33375b;

    /* renamed from: c  reason: collision with root package name */
    final int f33376c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<U> f33377d;

    public b(m<T> mVar, int i, int i2, Callable<U> callable) {
        super(mVar);
        this.f33375b = i;
        this.f33376c = i2;
        this.f33377d = callable;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super U> oVar) {
        int i = this.f33376c;
        int i2 = this.f33375b;
        if (i == i2) {
            a aVar = new a(oVar, i2, this.f33377d);
            if (aVar.b()) {
                this.f33374a.a(aVar);
                return;
            }
            return;
        }
        this.f33374a.a(new C0517b(oVar, this.f33375b, this.f33376c, this.f33377d));
    }

    static final class a<T, U extends Collection<? super T>> implements io.b.b.b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        final o<? super U> f33378a;

        /* renamed from: b  reason: collision with root package name */
        final int f33379b;

        /* renamed from: c  reason: collision with root package name */
        final Callable<U> f33380c;

        /* renamed from: d  reason: collision with root package name */
        U f33381d;

        /* renamed from: e  reason: collision with root package name */
        int f33382e;

        /* renamed from: f  reason: collision with root package name */
        io.b.b.b f33383f;

        a(o<? super U> oVar, int i, Callable<U> callable) {
            this.f33378a = oVar;
            this.f33379b = i;
            this.f33380c = callable;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            try {
                this.f33381d = (Collection) io.b.e.b.b.a(this.f33380c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                io.b.c.b.b(th);
                this.f33381d = null;
                io.b.b.b bVar = this.f33383f;
                if (bVar == null) {
                    c.error(th, (o<?>) this.f33378a);
                    return false;
                }
                bVar.dispose();
                this.f33378a.a(th);
                return false;
            }
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.f33383f, bVar)) {
                this.f33383f = bVar;
                this.f33378a.a((io.b.b.b) this);
            }
        }

        public void dispose() {
            this.f33383f.dispose();
        }

        public boolean isDisposed() {
            return this.f33383f.isDisposed();
        }

        public void a(T t) {
            U u = this.f33381d;
            if (u != null) {
                u.add(t);
                int i = this.f33382e + 1;
                this.f33382e = i;
                if (i >= this.f33379b) {
                    this.f33378a.a(u);
                    this.f33382e = 0;
                    b();
                }
            }
        }

        public void a(Throwable th) {
            this.f33381d = null;
            this.f33378a.a(th);
        }

        public void a() {
            U u = this.f33381d;
            if (u != null) {
                this.f33381d = null;
                if (!u.isEmpty()) {
                    this.f33378a.a(u);
                }
                this.f33378a.a();
            }
        }
    }

    /* renamed from: io.b.e.e.d.b$b  reason: collision with other inner class name */
    static final class C0517b<T, U extends Collection<? super T>> extends AtomicBoolean implements io.b.b.b, o<T> {
        private static final long serialVersionUID = -8223395059921494546L;
        final o<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;
        io.b.b.b s;
        final int skip;

        C0517b(o<? super U> oVar, int i, int i2, Callable<U> callable) {
            this.actual = oVar;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.a((io.b.b.b) this);
            }
        }

        public void dispose() {
            this.s.dispose();
        }

        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        public void a(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % ((long) this.skip) == 0) {
                try {
                    this.buffers.offer((Collection) io.b.e.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.s.dispose();
                    this.actual.a(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(t);
                if (this.count <= collection.size()) {
                    it.remove();
                    this.actual.a(collection);
                }
            }
        }

        public void a(Throwable th) {
            this.buffers.clear();
            this.actual.a(th);
        }

        public void a() {
            while (!this.buffers.isEmpty()) {
                this.actual.a(this.buffers.poll());
            }
            this.actual.a();
        }
    }
}
