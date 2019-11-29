package io.b.i;

import io.b.b.b;
import io.b.e.h.a;
import io.b.e.h.f;
import io.b.e.h.g;
import io.b.o;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a<T> extends c<T> {

    /* renamed from: c  reason: collision with root package name */
    static final C0525a[] f33588c = new C0525a[0];

    /* renamed from: d  reason: collision with root package name */
    static final C0525a[] f33589d = new C0525a[0];
    private static final Object[] j = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<Object> f33590a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C0525a<T>[]> f33591b = new AtomicReference<>(f33588c);

    /* renamed from: e  reason: collision with root package name */
    final ReadWriteLock f33592e = new ReentrantReadWriteLock();

    /* renamed from: f  reason: collision with root package name */
    final Lock f33593f = this.f33592e.readLock();

    /* renamed from: g  reason: collision with root package name */
    final Lock f33594g = this.f33592e.writeLock();
    final AtomicReference<Throwable> h = new AtomicReference<>();
    long i;

    public static <T> a<T> j() {
        return new a<>();
    }

    a() {
    }

    /* access modifiers changed from: protected */
    public void b(o<? super T> oVar) {
        C0525a aVar = new C0525a(oVar, this);
        oVar.a((b) aVar);
        if (!a(aVar)) {
            Throwable th = this.h.get();
            if (th == f.f33557a) {
                oVar.a();
            } else {
                oVar.a(th);
            }
        } else if (aVar.f33601g) {
            b(aVar);
        } else {
            aVar.a();
        }
    }

    public void a(b bVar) {
        if (this.h.get() != null) {
            bVar.dispose();
        }
    }

    public void a(T t) {
        io.b.e.b.b.a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.h.get() == null) {
            Object next = g.next(t);
            d(next);
            for (C0525a a2 : (C0525a[]) this.f33591b.get()) {
                a2.a(next, this.i);
            }
        }
    }

    public void a(Throwable th) {
        io.b.e.b.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.h.compareAndSet((Object) null, th)) {
            io.b.g.a.a(th);
            return;
        }
        Object error = g.error(th);
        for (C0525a a2 : c(error)) {
            a2.a(error, this.i);
        }
    }

    public void a() {
        if (this.h.compareAndSet((Object) null, f.f33557a)) {
            Object complete = g.complete();
            for (C0525a a2 : c(complete)) {
                a2.a(complete, this.i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(C0525a<T> aVar) {
        C0525a[] aVarArr;
        C0525a[] aVarArr2;
        do {
            aVarArr = (C0525a[]) this.f33591b.get();
            if (aVarArr == f33589d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0525a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f33591b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(C0525a<T> aVar) {
        C0525a<T>[] aVarArr;
        C0525a[] aVarArr2;
        do {
            aVarArr = (C0525a[]) this.f33591b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f33588c;
                    } else {
                        C0525a[] aVarArr3 = new C0525a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f33591b.compareAndSet(aVarArr, aVarArr2));
    }

    /* access modifiers changed from: package-private */
    public C0525a<T>[] c(Object obj) {
        C0525a<T>[] aVarArr = (C0525a[]) this.f33591b.getAndSet(f33589d);
        if (aVarArr != f33589d) {
            d(obj);
        }
        return aVarArr;
    }

    /* access modifiers changed from: package-private */
    public void d(Object obj) {
        this.f33594g.lock();
        this.i++;
        this.f33590a.lazySet(obj);
        this.f33594g.unlock();
    }

    /* renamed from: io.b.i.a$a  reason: collision with other inner class name */
    static final class C0525a<T> implements b, a.C0523a<Object> {

        /* renamed from: a  reason: collision with root package name */
        final o<? super T> f33595a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f33596b;

        /* renamed from: c  reason: collision with root package name */
        boolean f33597c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33598d;

        /* renamed from: e  reason: collision with root package name */
        io.b.e.h.a<Object> f33599e;

        /* renamed from: f  reason: collision with root package name */
        boolean f33600f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f33601g;
        long h;

        C0525a(o<? super T> oVar, a<T> aVar) {
            this.f33595a = oVar;
            this.f33596b = aVar;
        }

        public void dispose() {
            if (!this.f33601g) {
                this.f33601g = true;
                this.f33596b.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f33601g;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (a(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f33601g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f33601g     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f33597c     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.b.i.a<T> r0 = r4.f33596b     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f33593f     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.i     // Catch:{ all -> 0x003e }
                r4.h = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f33590a     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = 1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f33598d = r2     // Catch:{ all -> 0x003e }
                r4.f33597c = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.a(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.b()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.i.a.C0525a.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r3.f33600f = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.f33601g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.f33600f
                if (r0 != 0) goto L_0x0037
                monitor-enter(r3)
                boolean r0 = r3.f33601g     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r3.h     // Catch:{ all -> 0x0034 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x0018
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r5 = r3.f33598d     // Catch:{ all -> 0x0034 }
                if (r5 == 0) goto L_0x002d
                io.b.e.h.a<java.lang.Object> r5 = r3.f33599e     // Catch:{ all -> 0x0034 }
                if (r5 != 0) goto L_0x0028
                io.b.e.h.a r5 = new io.b.e.h.a     // Catch:{ all -> 0x0034 }
                r6 = 4
                r5.<init>(r6)     // Catch:{ all -> 0x0034 }
                r3.f33599e = r5     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r5.a(r4)     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r5 = 1
                r3.f33597c = r5     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                r3.f33600f = r5
                goto L_0x0037
            L_0x0034:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                throw r4
            L_0x0037:
                r3.a(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.i.a.C0525a.a(java.lang.Object, long):void");
        }

        public boolean a(Object obj) {
            return this.f33601g || g.accept(obj, this.f33595a);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.a((io.b.e.h.a.C0523a<? super java.lang.Object>) r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f33601g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.b.e.h.a<java.lang.Object> r0 = r2.f33599e     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f33598d = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f33599e = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.a(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                goto L_0x001b
            L_0x001a:
                throw r0
            L_0x001b:
                goto L_0x001a
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.i.a.C0525a.b():void");
        }
    }
}
