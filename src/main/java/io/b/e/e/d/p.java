package io.b.e.e.d;

import io.b.e.c.e;
import io.b.e.d.b;
import io.b.e.g.l;
import io.b.m;
import io.b.o;
import io.b.p;

public final class p<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final io.b.p f33432b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f33433c;

    /* renamed from: d  reason: collision with root package name */
    final int f33434d;

    public p(m<T> mVar, io.b.p pVar, boolean z, int i) {
        super(mVar);
        this.f33432b = pVar;
        this.f33433c = z;
        this.f33434d = i;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super T> oVar) {
        io.b.p pVar = this.f33432b;
        if (pVar instanceof l) {
            this.f33374a.a(oVar);
            return;
        }
        this.f33374a.a(new a(oVar, pVar.a(), this.f33433c, this.f33434d));
    }

    static final class a<T> extends b<T> implements o<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final o<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        boolean outputFused;
        e<T> queue;
        io.b.b.b s;
        int sourceMode;
        final p.b worker;

        a(o<? super T> oVar, p.b bVar, boolean z, int i) {
            this.actual = oVar;
            this.worker = bVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.s, bVar)) {
                this.s = bVar;
                if (bVar instanceof io.b.e.c.a) {
                    io.b.e.c.a aVar = (io.b.e.c.a) bVar;
                    int requestFusion = aVar.requestFusion(7);
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
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                b();
            }
        }

        public void a(Throwable th) {
            if (this.done) {
                io.b.g.a.a(th);
                return;
            }
            this.error = th;
            this.done = true;
            b();
        }

        public void a() {
            if (!this.done) {
                this.done = true;
                b();
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                this.worker.a((Runnable) this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            e<T> eVar = this.queue;
            o<? super T> oVar = this.actual;
            int i = 1;
            while (!a(this.done, eVar.isEmpty(), oVar)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        T poll = eVar.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, oVar)) {
                            if (z2) {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            } else {
                                oVar.a(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.b.c.b.b(th);
                        this.s.dispose();
                        eVar.clear();
                        oVar.a(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (this.delayError || !z || th == null) {
                    this.actual.a(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.actual.a(th2);
                        } else {
                            this.actual.a();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    this.actual.a(th);
                    this.worker.dispose();
                    return;
                }
            }
        }

        public void run() {
            if (this.outputFused) {
                d();
            } else {
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z, boolean z2, o<? super T> oVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (this.delayError) {
                    if (!z2) {
                        return false;
                    }
                    if (th != null) {
                        oVar.a(th);
                    } else {
                        oVar.a();
                    }
                    this.worker.dispose();
                    return true;
                } else if (th != null) {
                    this.queue.clear();
                    oVar.a(th);
                    this.worker.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    oVar.a();
                    this.worker.dispose();
                    return true;
                }
            }
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }
}
