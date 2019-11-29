package io.b.e.e.d;

import io.b.d.g;
import io.b.e.h.c;
import io.b.e.h.e;
import io.b.m;
import io.b.o;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends m<? extends U>> f33389b;

    /* renamed from: c  reason: collision with root package name */
    final int f33390c;

    /* renamed from: d  reason: collision with root package name */
    final e f33391d;

    public d(m<T> mVar, g<? super T, ? extends m<? extends U>> gVar, int i, e eVar) {
        super(mVar);
        this.f33389b = gVar;
        this.f33391d = eVar;
        this.f33390c = Math.max(8, i);
    }

    public void b(o<? super U> oVar) {
        if (!q.a(this.f33374a, oVar, this.f33389b)) {
            if (this.f33391d == e.IMMEDIATE) {
                this.f33374a.a(new b(new io.b.f.a(oVar), this.f33389b, this.f33390c));
            } else {
                this.f33374a.a(new a(oVar, this.f33389b, this.f33390c, this.f33391d == e.END));
            }
        }
    }

    static final class b<T, U> extends AtomicInteger implements io.b.b.b, o<T> {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final o<? super U> actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        int fusionMode;
        final a<U> inner;
        final g<? super T, ? extends m<? extends U>> mapper;
        io.b.e.c.e<T> queue;
        io.b.b.b s;

        b(o<? super U> oVar, g<? super T, ? extends m<? extends U>> gVar, int i) {
            this.actual = oVar;
            this.mapper = gVar;
            this.bufferSize = i;
            this.inner = new a<>(oVar, this);
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.s, bVar)) {
                this.s = bVar;
                if (bVar instanceof io.b.e.c.a) {
                    io.b.e.c.a aVar = (io.b.e.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = aVar;
                        this.done = true;
                        this.actual.a((io.b.b.b) this);
                        c();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = aVar;
                        this.actual.a((io.b.b.b) this);
                        return;
                    }
                }
                this.queue = new io.b.e.f.b(this.bufferSize);
                this.actual.a((io.b.b.b) this);
            }
        }

        public void a(T t) {
            if (!this.done) {
                if (this.fusionMode == 0) {
                    this.queue.offer(t);
                }
                c();
            }
        }

        public void a(Throwable th) {
            if (this.done) {
                io.b.g.a.a(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.a(th);
        }

        public void a() {
            if (!this.done) {
                this.done = true;
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.active = false;
            c();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void dispose() {
            this.disposed = true;
            this.inner.b();
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.disposed = true;
                                this.actual.a();
                                return;
                            } else if (!z2) {
                                try {
                                    m mVar = (m) io.b.e.b.b.a(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    this.active = true;
                                    mVar.a(this.inner);
                                } catch (Throwable th) {
                                    io.b.c.b.b(th);
                                    dispose();
                                    this.queue.clear();
                                    this.actual.a(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            io.b.c.b.b(th2);
                            dispose();
                            this.queue.clear();
                            this.actual.a(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        static final class a<U> extends AtomicReference<io.b.b.b> implements o<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final o<? super U> actual;
            final b<?, ?> parent;

            a(o<? super U> oVar, b<?, ?> bVar) {
                this.actual = oVar;
                this.parent = bVar;
            }

            public void a(io.b.b.b bVar) {
                io.b.e.a.b.set(this, bVar);
            }

            public void a(U u) {
                this.actual.a(u);
            }

            public void a(Throwable th) {
                this.parent.dispose();
                this.actual.a(th);
            }

            public void a() {
                this.parent.b();
            }

            /* access modifiers changed from: package-private */
            public void b() {
                io.b.e.a.b.dispose(this);
            }
        }
    }

    static final class a<T, R> extends AtomicInteger implements io.b.b.b, o<T> {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final o<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;

        /* renamed from: d  reason: collision with root package name */
        io.b.b.b f33392d;
        volatile boolean done;
        final c error = new c();
        final g<? super T, ? extends m<? extends R>> mapper;
        final C0518a<R> observer;
        io.b.e.c.e<T> queue;
        int sourceMode;
        final boolean tillTheEnd;

        a(o<? super R> oVar, g<? super T, ? extends m<? extends R>> gVar, int i, boolean z) {
            this.actual = oVar;
            this.mapper = gVar;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new C0518a<>(oVar, this);
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.f33392d, bVar)) {
                this.f33392d = bVar;
                if (bVar instanceof io.b.e.c.a) {
                    io.b.e.c.a aVar = (io.b.e.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = aVar;
                        this.done = true;
                        this.actual.a((io.b.b.b) this);
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = aVar;
                        this.actual.a((io.b.b.b) this);
                        return;
                    }
                }
                this.queue = new io.b.e.f.b(this.bufferSize);
                this.actual.a((io.b.b.b) this);
            }
        }

        public void a(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            b();
        }

        public void a(Throwable th) {
            if (this.error.a(th)) {
                this.done = true;
                b();
                return;
            }
            io.b.g.a.a(th);
        }

        public void a() {
            this.done = true;
            b();
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        public void dispose() {
            this.cancelled = true;
            this.f33392d.dispose();
            this.observer.b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                o<? super R> oVar = this.actual;
                io.b.e.c.e<T> eVar = this.queue;
                c cVar = this.error;
                while (true) {
                    if (!this.active) {
                        if (this.cancelled) {
                            eVar.clear();
                            return;
                        } else if (this.tillTheEnd || ((Throwable) cVar.get()) == null) {
                            boolean z = this.done;
                            try {
                                T poll = eVar.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.cancelled = true;
                                    Throwable a2 = cVar.a();
                                    if (a2 != null) {
                                        oVar.a(a2);
                                        return;
                                    } else {
                                        oVar.a();
                                        return;
                                    }
                                } else if (!z2) {
                                    try {
                                        m mVar = (m) io.b.e.b.b.a(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                        if (mVar instanceof Callable) {
                                            try {
                                                Object call = ((Callable) mVar).call();
                                                if (call != null && !this.cancelled) {
                                                    oVar.a(call);
                                                }
                                            } catch (Throwable th) {
                                                io.b.c.b.b(th);
                                                cVar.a(th);
                                            }
                                        } else {
                                            this.active = true;
                                            mVar.a(this.observer);
                                        }
                                    } catch (Throwable th2) {
                                        io.b.c.b.b(th2);
                                        this.cancelled = true;
                                        this.f33392d.dispose();
                                        eVar.clear();
                                        cVar.a(th2);
                                        oVar.a(cVar.a());
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                io.b.c.b.b(th3);
                                this.cancelled = true;
                                this.f33392d.dispose();
                                cVar.a(th3);
                                oVar.a(cVar.a());
                                return;
                            }
                        } else {
                            eVar.clear();
                            this.cancelled = true;
                            oVar.a(cVar.a());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: io.b.e.e.d.d$a$a  reason: collision with other inner class name */
        static final class C0518a<R> extends AtomicReference<io.b.b.b> implements o<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final o<? super R> actual;
            final a<?, R> parent;

            C0518a(o<? super R> oVar, a<?, R> aVar) {
                this.actual = oVar;
                this.parent = aVar;
            }

            public void a(io.b.b.b bVar) {
                io.b.e.a.b.replace(this, bVar);
            }

            public void a(R r) {
                this.actual.a(r);
            }

            public void a(Throwable th) {
                a<?, R> aVar = this.parent;
                if (aVar.error.a(th)) {
                    if (!aVar.tillTheEnd) {
                        aVar.f33392d.dispose();
                    }
                    aVar.active = false;
                    aVar.b();
                    return;
                }
                io.b.g.a.a(th);
            }

            public void a() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.b();
            }

            /* access modifiers changed from: package-private */
            public void b() {
                io.b.e.a.b.dispose(this);
            }
        }
    }
}
