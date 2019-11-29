package io.b.e.e.d;

import io.b.d.g;
import io.b.j;
import io.b.m;
import io.b.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class c<T, R> extends j<R> {

    /* renamed from: a  reason: collision with root package name */
    final m<? extends T>[] f33384a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends m<? extends T>> f33385b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super Object[], ? extends R> f33386c;

    /* renamed from: d  reason: collision with root package name */
    final int f33387d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f33388e;

    public c(m<? extends T>[] mVarArr, Iterable<? extends m<? extends T>> iterable, g<? super Object[], ? extends R> gVar, int i, boolean z) {
        this.f33384a = mVarArr;
        this.f33385b = iterable;
        this.f33386c = gVar;
        this.f33387d = i;
        this.f33388e = z;
    }

    public void b(o<? super R> oVar) {
        int i;
        m<? extends T>[] mVarArr = this.f33384a;
        if (mVarArr == null) {
            mVarArr = new j[8];
            i = 0;
            for (m<? extends T> mVar : this.f33385b) {
                if (i == mVarArr.length) {
                    m<? extends T>[] mVarArr2 = new m[((i >> 2) + i)];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, i);
                    mVarArr = mVarArr2;
                }
                mVarArr[i] = mVar;
                i++;
            }
        } else {
            i = mVarArr.length;
        }
        int i2 = i;
        if (i2 == 0) {
            io.b.e.a.c.complete((o<?>) oVar);
            return;
        }
        new b(oVar, this.f33386c, i2, this.f33387d, this.f33388e).a(mVarArr);
    }

    static final class b<T, R> extends AtomicInteger implements io.b.b.b {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final o<? super R> actual;
        volatile boolean cancelled;
        final g<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final io.b.e.h.c errors = new io.b.e.h.c();
        Object[] latest;
        final a<T, R>[] observers;
        final io.b.e.f.b<Object[]> queue;

        b(o<? super R> oVar, g<? super Object[], ? extends R> gVar, int i, int i2, boolean z) {
            this.actual = oVar;
            this.combiner = gVar;
            this.delayError = z;
            this.latest = new Object[i];
            a<T, R>[] aVarArr = new a[i];
            for (int i3 = 0; i3 < i; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.observers = aVarArr;
            this.queue = new io.b.e.f.b<>(i2);
        }

        public void a(m<? extends T>[] mVarArr) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            this.actual.a((io.b.b.b) this);
            for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
                mVarArr[i].a(aVarArr[i]);
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                a();
                if (getAndIncrement() == 0) {
                    a((io.b.e.f.b<?>) this.queue);
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (a<T, R> b2 : this.observers) {
                b2.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(io.b.e.f.b<?> bVar) {
            synchronized (this) {
                this.latest = null;
            }
            bVar.clear();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                io.b.e.f.b<Object[]> bVar = this.queue;
                o<? super R> oVar = this.actual;
                boolean z = this.delayError;
                int i = 1;
                while (!this.cancelled) {
                    if (z || this.errors.get() == null) {
                        boolean z2 = this.done;
                        Object[] poll = bVar.poll();
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            a((io.b.e.f.b<?>) bVar);
                            Throwable a2 = this.errors.a();
                            if (a2 == null) {
                                oVar.a();
                                return;
                            } else {
                                oVar.a(a2);
                                return;
                            }
                        } else if (z3) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else {
                            try {
                                oVar.a(io.b.e.b.b.a(this.combiner.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th) {
                                io.b.c.b.b(th);
                                this.errors.a(th);
                                a();
                                a((io.b.e.f.b<?>) bVar);
                                oVar.a(this.errors.a());
                                return;
                            }
                        }
                    } else {
                        a();
                        a((io.b.e.f.b<?>) bVar);
                        oVar.a(this.errors.a());
                        return;
                    }
                }
                a((io.b.e.f.b<?>) bVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                return
            L_0x0007:
                r1 = r0[r4]     // Catch:{ all -> 0x0029 }
                int r2 = r3.active     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0011
                int r2 = r2 + 1
                r3.active = r2     // Catch:{ all -> 0x0029 }
            L_0x0011:
                r0[r4] = r5     // Catch:{ all -> 0x0029 }
                int r4 = r0.length     // Catch:{ all -> 0x0029 }
                if (r2 != r4) goto L_0x0021
                io.b.e.f.b<java.lang.Object[]> r4 = r3.queue     // Catch:{ all -> 0x0029 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0029 }
                r4.offer(r5)     // Catch:{ all -> 0x0029 }
                r4 = 1
                goto L_0x0022
            L_0x0021:
                r4 = 0
            L_0x0022:
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                if (r4 == 0) goto L_0x0028
                r3.b()
            L_0x0028:
                return
            L_0x0029:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.e.e.d.c.b.a(int, java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r1 == r4.length) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.b.e.h.c r0 = r2.errors
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L_0x0036
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L_0x002c
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch:{ all -> 0x0029 }
                if (r4 != 0) goto L_0x0014
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                return
            L_0x0014:
                r3 = r4[r3]     // Catch:{ all -> 0x0029 }
                if (r3 != 0) goto L_0x001a
                r3 = 1
                goto L_0x001b
            L_0x001a:
                r3 = 0
            L_0x001b:
                if (r3 != 0) goto L_0x0025
                int r1 = r2.complete     // Catch:{ all -> 0x0029 }
                int r1 = r1 + r0
                r2.complete = r1     // Catch:{ all -> 0x0029 }
                int r4 = r4.length     // Catch:{ all -> 0x0029 }
                if (r1 != r4) goto L_0x0027
            L_0x0025:
                r2.done = r0     // Catch:{ all -> 0x0029 }
            L_0x0027:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x002d
            L_0x0029:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                throw r3
            L_0x002c:
                r3 = 1
            L_0x002d:
                if (r3 == 0) goto L_0x0032
                r2.a()
            L_0x0032:
                r2.b()
                goto L_0x0039
            L_0x0036:
                io.b.g.a.a((java.lang.Throwable) r4)
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.e.e.d.c.b.a(int, java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r2 == r0.length) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
            if (r4 == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0025 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                return
            L_0x0007:
                r4 = r0[r4]     // Catch:{ all -> 0x0025 }
                r1 = 1
                if (r4 != 0) goto L_0x000e
                r4 = 1
                goto L_0x000f
            L_0x000e:
                r4 = 0
            L_0x000f:
                if (r4 != 0) goto L_0x0019
                int r2 = r3.complete     // Catch:{ all -> 0x0025 }
                int r2 = r2 + r1
                r3.complete = r2     // Catch:{ all -> 0x0025 }
                int r0 = r0.length     // Catch:{ all -> 0x0025 }
                if (r2 != r0) goto L_0x001b
            L_0x0019:
                r3.done = r1     // Catch:{ all -> 0x0025 }
            L_0x001b:
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0021
                r3.a()
            L_0x0021:
                r3.b()
                return
            L_0x0025:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.e.e.d.c.b.a(int):void");
        }
    }

    static final class a<T, R> extends AtomicReference<io.b.b.b> implements o<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final b<T, R> parent;

        a(b<T, R> bVar, int i) {
            this.parent = bVar;
            this.index = i;
        }

        public void a(io.b.b.b bVar) {
            io.b.e.a.b.setOnce(this, bVar);
        }

        public void a(T t) {
            this.parent.a(this.index, t);
        }

        public void a(Throwable th) {
            this.parent.a(this.index, th);
        }

        public void a() {
            this.parent.a(this.index);
        }

        public void b() {
            io.b.e.a.b.dispose(this);
        }
    }
}
