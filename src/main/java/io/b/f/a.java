package io.b.f;

import io.b.b.b;
import io.b.e.h.g;
import io.b.o;

public final class a<T> implements b, o<T> {

    /* renamed from: a  reason: collision with root package name */
    final o<? super T> f33566a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f33567b;

    /* renamed from: c  reason: collision with root package name */
    b f33568c;

    /* renamed from: d  reason: collision with root package name */
    boolean f33569d;

    /* renamed from: e  reason: collision with root package name */
    io.b.e.h.a<Object> f33570e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f33571f;

    public a(o<? super T> oVar) {
        this(oVar, false);
    }

    public a(o<? super T> oVar, boolean z) {
        this.f33566a = oVar;
        this.f33567b = z;
    }

    public void a(b bVar) {
        if (io.b.e.a.b.validate(this.f33568c, bVar)) {
            this.f33568c = bVar;
            this.f33566a.a((b) this);
        }
    }

    public void dispose() {
        this.f33568c.dispose();
    }

    public boolean isDisposed() {
        return this.f33568c.isDisposed();
    }

    public void a(T t) {
        if (!this.f33571f) {
            if (t == null) {
                this.f33568c.dispose();
                a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f33571f) {
                    if (this.f33569d) {
                        io.b.e.h.a<Object> aVar = this.f33570e;
                        if (aVar == null) {
                            aVar = new io.b.e.h.a<>(4);
                            this.f33570e = aVar;
                        }
                        aVar.a(g.next(t));
                        return;
                    }
                    this.f33569d = true;
                    this.f33566a.a(t);
                    b();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        io.b.g.a.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f33566a.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f33571f
            if (r0 == 0) goto L_0x0008
            io.b.g.a.a((java.lang.Throwable) r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f33571f     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f33569d     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f33571f = r1     // Catch:{ all -> 0x0044 }
            io.b.e.h.a<java.lang.Object> r0 = r2.f33570e     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.b.e.h.a r0 = new io.b.e.h.a     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f33570e = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.b.e.h.g.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f33567b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.a(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.b(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f33571f = r1     // Catch:{ all -> 0x0044 }
            r2.f33569d = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            io.b.g.a.a((java.lang.Throwable) r3)
            return
        L_0x003e:
            io.b.o<? super T> r0 = r2.f33566a
            r0.a((java.lang.Throwable) r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.b.f.a.a(java.lang.Throwable):void");
    }

    public void a() {
        if (!this.f33571f) {
            synchronized (this) {
                if (!this.f33571f) {
                    if (this.f33569d) {
                        io.b.e.h.a<Object> aVar = this.f33570e;
                        if (aVar == null) {
                            aVar = new io.b.e.h.a<>(4);
                            this.f33570e = aVar;
                        }
                        aVar.a(g.complete());
                        return;
                    }
                    this.f33571f = true;
                    this.f33569d = true;
                    this.f33566a.a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        io.b.e.h.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f33570e;
                if (aVar == null) {
                    this.f33569d = false;
                    return;
                }
                this.f33570e = null;
            }
        } while (!aVar.a((o<? super U>) this.f33566a));
    }
}
