package io.b.e.e.d;

import io.b.d.g;
import io.b.e.c.d;
import io.b.e.c.e;
import io.b.e.h.c;
import io.b.e.h.f;
import io.b.m;
import io.b.o;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class i<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends m<? extends U>> f33406b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f33407c;

    /* renamed from: d  reason: collision with root package name */
    final int f33408d;

    /* renamed from: e  reason: collision with root package name */
    final int f33409e;

    public i(m<T> mVar, g<? super T, ? extends m<? extends U>> gVar, boolean z, int i, int i2) {
        super(mVar);
        this.f33406b = gVar;
        this.f33407c = z;
        this.f33408d = i;
        this.f33409e = i2;
    }

    public void b(o<? super U> oVar) {
        if (!q.a(this.f33374a, oVar, this.f33406b)) {
            this.f33374a.a(new b(oVar, this.f33406b, this.f33407c, this.f33408d, this.f33409e));
        }
    }

    static final class b<T, U> extends AtomicInteger implements io.b.b.b, o<T> {

        /* renamed from: a  reason: collision with root package name */
        static final a<?, ?>[] f33410a = new a[0];

        /* renamed from: b  reason: collision with root package name */
        static final a<?, ?>[] f33411b = new a[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final o<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final c errors = new c();
        long lastId;
        int lastIndex;
        final g<? super T, ? extends m<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<?, ?>[]> observers;
        volatile d<U> queue;
        io.b.b.b s;
        Queue<m<? extends U>> sources;
        long uniqueId;
        int wip;

        b(o<? super U> oVar, g<? super T, ? extends m<? extends U>> gVar, boolean z, int i, int i2) {
            this.actual = oVar;
            this.mapper = gVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(f33410a);
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.a((io.b.b.b) this);
            }
        }

        public void a(T t) {
            if (!this.done) {
                try {
                    m mVar = (m) io.b.e.b.b.a(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            if (this.wip == this.maxConcurrency) {
                                this.sources.offer(mVar);
                                return;
                            }
                            this.wip++;
                        }
                    }
                    a(mVar);
                } catch (Throwable th) {
                    io.b.c.b.b(th);
                    this.s.dispose();
                    a(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(m<? extends U> mVar) {
            m<? extends U> poll;
            while (mVar instanceof Callable) {
                if (a((Callable) mVar) && this.maxConcurrency != Integer.MAX_VALUE) {
                    boolean z = false;
                    synchronized (this) {
                        poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                            z = true;
                        }
                    }
                    if (z) {
                        b();
                        return;
                    }
                    mVar = poll;
                } else {
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            a aVar = new a(this, j);
            if (a(aVar)) {
                mVar.a(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.observers.get();
                if (aVarArr == f33411b) {
                    aVar.b();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void b(a<T, U> aVar) {
            a<T, U>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = (a[]) this.observers.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (aVarArr[i2] == aVar) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            aVarArr2 = f33410a;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
        }

        /* access modifiers changed from: package-private */
        public boolean a(Callable<? extends U> callable) {
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    d<U> dVar = this.queue;
                    if (dVar == null) {
                        int i = this.maxConcurrency;
                        if (i == Integer.MAX_VALUE) {
                            dVar = new io.b.e.f.b<>(this.bufferSize);
                        } else {
                            dVar = new io.b.e.f.a<>(i);
                        }
                        this.queue = dVar;
                    }
                    if (!dVar.offer(call)) {
                        a((Throwable) new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.actual.a(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                c();
                return true;
            } catch (Throwable th) {
                io.b.c.b.b(th);
                this.errors.a(th);
                b();
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(U u, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                e eVar = aVar.queue;
                if (eVar == null) {
                    eVar = new io.b.e.f.b(this.bufferSize);
                    aVar.queue = eVar;
                }
                eVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.actual.a(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            c();
        }

        public void a(Throwable th) {
            if (this.done) {
                io.b.g.a.a(th);
            } else if (this.errors.a(th)) {
                this.done = true;
                b();
            } else {
                io.b.g.a.a(th);
            }
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
                if (e()) {
                    Throwable a2 = this.errors.a();
                    if (a2 != null && a2 != f.f33557a) {
                        io.b.g.a.a(a2);
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00b7, code lost:
            if (r12 != null) goto L_0x00a5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r14 = this;
                io.b.o<? super U> r0 = r14.actual
                r1 = 1
                r2 = 1
            L_0x0004:
                boolean r3 = r14.d()
                if (r3 == 0) goto L_0x000b
                return
            L_0x000b:
                io.b.e.c.d<U> r3 = r14.queue
                if (r3 == 0) goto L_0x0023
            L_0x000f:
                boolean r4 = r14.d()
                if (r4 == 0) goto L_0x0016
                return
            L_0x0016:
                java.lang.Object r4 = r3.poll()
                if (r4 != 0) goto L_0x001f
                if (r4 != 0) goto L_0x000f
                goto L_0x0023
            L_0x001f:
                r0.a(r4)
                goto L_0x000f
            L_0x0023:
                boolean r3 = r14.done
                io.b.e.c.d<U> r4 = r14.queue
                java.util.concurrent.atomic.AtomicReference<io.b.e.e.d.i$a<?, ?>[]> r5 = r14.observers
                java.lang.Object r5 = r5.get()
                io.b.e.e.d.i$a[] r5 = (io.b.e.e.d.i.a[]) r5
                int r6 = r5.length
                int r7 = r14.maxConcurrency
                r8 = 2147483647(0x7fffffff, float:NaN)
                r9 = 0
                if (r7 == r8) goto L_0x0044
                monitor-enter(r14)
                java.util.Queue<io.b.m<? extends U>> r7 = r14.sources     // Catch:{ all -> 0x0041 }
                int r7 = r7.size()     // Catch:{ all -> 0x0041 }
                monitor-exit(r14)     // Catch:{ all -> 0x0041 }
                goto L_0x0045
            L_0x0041:
                r0 = move-exception
                monitor-exit(r14)     // Catch:{ all -> 0x0041 }
                throw r0
            L_0x0044:
                r7 = 0
            L_0x0045:
                if (r3 == 0) goto L_0x0067
                if (r4 == 0) goto L_0x004f
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L_0x0067
            L_0x004f:
                if (r6 != 0) goto L_0x0067
                if (r7 != 0) goto L_0x0067
                io.b.e.h.c r1 = r14.errors
                java.lang.Throwable r1 = r1.a()
                java.lang.Throwable r2 = io.b.e.h.f.f33557a
                if (r1 == r2) goto L_0x0066
                if (r1 != 0) goto L_0x0063
                r0.a()
                goto L_0x0066
            L_0x0063:
                r0.a((java.lang.Throwable) r1)
            L_0x0066:
                return
            L_0x0067:
                if (r6 == 0) goto L_0x0106
                long r3 = r14.lastId
                int r7 = r14.lastIndex
                if (r6 <= r7) goto L_0x0077
                r10 = r5[r7]
                long r10 = r10.id
                int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r12 == 0) goto L_0x0098
            L_0x0077:
                if (r6 > r7) goto L_0x007a
                r7 = 0
            L_0x007a:
                r10 = r7
                r7 = 0
            L_0x007c:
                if (r7 >= r6) goto L_0x008f
                r11 = r5[r10]
                long r11 = r11.id
                int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
                if (r13 != 0) goto L_0x0087
                goto L_0x008f
            L_0x0087:
                int r10 = r10 + 1
                if (r10 != r6) goto L_0x008c
                r10 = 0
            L_0x008c:
                int r7 = r7 + 1
                goto L_0x007c
            L_0x008f:
                r14.lastIndex = r10
                r3 = r5[r10]
                long r3 = r3.id
                r14.lastId = r3
                r7 = r10
            L_0x0098:
                r3 = 0
                r4 = 0
            L_0x009a:
                if (r3 >= r6) goto L_0x00fd
                boolean r10 = r14.d()
                if (r10 == 0) goto L_0x00a3
                return
            L_0x00a3:
                r10 = r5[r7]
            L_0x00a5:
                boolean r11 = r14.d()
                if (r11 == 0) goto L_0x00ac
                return
            L_0x00ac:
                io.b.e.c.e<U> r11 = r10.queue
                if (r11 != 0) goto L_0x00b1
                goto L_0x00b9
            L_0x00b1:
                java.lang.Object r12 = r11.poll()     // Catch:{ Throwable -> 0x00e2 }
                if (r12 != 0) goto L_0x00d8
                if (r12 != 0) goto L_0x00a5
            L_0x00b9:
                boolean r11 = r10.done
                io.b.e.c.e<U> r12 = r10.queue
                if (r11 == 0) goto L_0x00d2
                if (r12 == 0) goto L_0x00c7
                boolean r11 = r12.isEmpty()
                if (r11 == 0) goto L_0x00d2
            L_0x00c7:
                r14.b(r10)
                boolean r4 = r14.d()
                if (r4 == 0) goto L_0x00d1
                return
            L_0x00d1:
                r4 = 1
            L_0x00d2:
                int r7 = r7 + 1
                if (r7 != r6) goto L_0x00fb
                r7 = 0
                goto L_0x00fb
            L_0x00d8:
                r0.a(r12)
                boolean r12 = r14.d()
                if (r12 == 0) goto L_0x00b1
                return
            L_0x00e2:
                r4 = move-exception
                io.b.c.b.b(r4)
                r10.b()
                io.b.e.h.c r11 = r14.errors
                r11.a(r4)
                boolean r4 = r14.d()
                if (r4 == 0) goto L_0x00f5
                return
            L_0x00f5:
                r14.b(r10)
                int r3 = r3 + 1
                r4 = 1
            L_0x00fb:
                int r3 = r3 + r1
                goto L_0x009a
            L_0x00fd:
                r14.lastIndex = r7
                r3 = r5[r7]
                long r5 = r3.id
                r14.lastId = r5
                goto L_0x0107
            L_0x0106:
                r4 = 0
            L_0x0107:
                if (r4 == 0) goto L_0x0129
                int r3 = r14.maxConcurrency
                if (r3 == r8) goto L_0x0004
                monitor-enter(r14)
                java.util.Queue<io.b.m<? extends U>> r3 = r14.sources     // Catch:{ all -> 0x0126 }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0126 }
                io.b.m r3 = (io.b.m) r3     // Catch:{ all -> 0x0126 }
                if (r3 != 0) goto L_0x0120
                int r3 = r14.wip     // Catch:{ all -> 0x0126 }
                int r3 = r3 - r1
                r14.wip = r3     // Catch:{ all -> 0x0126 }
                monitor-exit(r14)     // Catch:{ all -> 0x0126 }
                goto L_0x0004
            L_0x0120:
                monitor-exit(r14)     // Catch:{ all -> 0x0126 }
                r14.a(r3)
                goto L_0x0004
            L_0x0126:
                r0 = move-exception
                monitor-exit(r14)     // Catch:{ all -> 0x0126 }
                throw r0
            L_0x0129:
                int r2 = -r2
                int r2 = r14.addAndGet(r2)
                if (r2 != 0) goto L_0x0004
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.e.e.d.i.b.c():void");
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = (Throwable) this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            e();
            Throwable a2 = this.errors.a();
            if (a2 != f.f33557a) {
                this.actual.a(a2);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            this.s.dispose();
            a<?, ?>[] aVarArr = (a[]) this.observers.get();
            a<?, ?>[] aVarArr2 = f33411b;
            if (aVarArr != aVarArr2) {
                a<?, ?>[] aVarArr3 = (a[]) this.observers.getAndSet(aVarArr2);
                if (aVarArr3 != f33411b) {
                    for (a<?, ?> b2 : aVarArr3) {
                        b2.b();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    static final class a<T, U> extends AtomicReference<io.b.b.b> implements o<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final b<T, U> parent;
        volatile e<U> queue;

        a(b<T, U> bVar, long j) {
            this.id = j;
            this.parent = bVar;
        }

        public void a(io.b.b.b bVar) {
            if (io.b.e.a.b.setOnce(this, bVar) && (bVar instanceof io.b.e.c.a)) {
                io.b.e.c.a aVar = (io.b.e.c.a) bVar;
                int requestFusion = aVar.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar;
                    this.done = true;
                    this.parent.b();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = aVar;
                }
            }
        }

        public void a(U u) {
            if (this.fusionMode == 0) {
                this.parent.a(u, this);
            } else {
                this.parent.b();
            }
        }

        public void a(Throwable th) {
            if (this.parent.errors.a(th)) {
                if (!this.parent.delayErrors) {
                    this.parent.e();
                }
                this.done = true;
                this.parent.b();
                return;
            }
            io.b.g.a.a(th);
        }

        public void a() {
            this.done = true;
            this.parent.b();
        }

        public void b() {
            io.b.e.a.b.dispose(this);
        }
    }
}
