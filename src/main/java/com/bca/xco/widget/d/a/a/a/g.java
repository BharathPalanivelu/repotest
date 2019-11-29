package com.bca.xco.widget.d.a.a.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.a.f.a;
import com.bca.xco.widget.d.a.a.g.n;
import com.bca.xco.widget.d.a.ab;
import com.bca.xco.widget.d.a.h;
import com.bca.xco.widget.d.a.m;
import com.bca.xco.widget.d.a.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f4764b = (!g.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public final h f4765a;

    /* renamed from: c  reason: collision with root package name */
    private ab f4766c;

    /* renamed from: d  reason: collision with root package name */
    private final m f4767d;

    /* renamed from: e  reason: collision with root package name */
    private final f f4768e;

    /* renamed from: f  reason: collision with root package name */
    private int f4769f;

    /* renamed from: g  reason: collision with root package name */
    private c f4770g;
    private boolean h;
    private boolean i;
    private a j;

    public g(m mVar, h hVar) {
        this.f4767d = mVar;
        this.f4765a = hVar;
        this.f4768e = new f(hVar, f());
    }

    public a a(s sVar, boolean z) {
        a aVar;
        int a2 = sVar.a();
        int b2 = sVar.b();
        int c2 = sVar.c();
        try {
            c a3 = a(a2, b2, c2, sVar.r(), z);
            if (a3.f4748b != null) {
                aVar = new com.bca.xco.widget.d.a.a.g.g(sVar, this, a3.f4748b);
            } else {
                a3.b().setSoTimeout(b2);
                a3.f4750d.a().a((long) b2, TimeUnit.MILLISECONDS);
                a3.f4751e.a().a((long) c2, TimeUnit.MILLISECONDS);
                aVar = new com.bca.xco.widget.d.a.a.b.a(sVar, this, a3.f4750d, a3.f4751e);
            }
            synchronized (this.f4767d) {
                this.j = aVar;
            }
            return aVar;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.a(r8) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bca.xco.widget.d.a.a.a.c a(int r4, int r5, int r6, boolean r7, boolean r8) {
        /*
            r3 = this;
        L_0x0000:
            com.bca.xco.widget.d.a.a.a.c r0 = r3.a(r4, r5, r6, r7)
            com.bca.xco.widget.d.a.m r1 = r3.f4767d
            monitor-enter(r1)
            int r2 = r0.f4749c     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.a((boolean) r8)
            if (r1 != 0) goto L_0x0018
            r3.d()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x001c:
            throw r4
        L_0x001d:
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.a.g.a(int, int, int, boolean, boolean):com.bca.xco.widget.d.a.a.a.c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        if (r1 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r1 = r8.f4768e.b();
        r0 = r8.f4767d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r8.f4766c = r1;
        r8.f4769f = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003c, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0041, code lost:
        r0 = new com.bca.xco.widget.d.a.a.a.c(r1);
        r1 = r8.f4767d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        a(r0);
        com.bca.xco.widget.d.a.a.a.f4741a.a(r8.f4767d, r0);
        r8.f4770g = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        if (r8.i != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0059, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
        r0.a(r9, r10, r11, r8.f4765a.f(), r12);
        f().b(r0.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0073, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007b, code lost:
        throw new java.io.IOException(com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage.EVENT_TYPE_CANCELLED);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bca.xco.widget.d.a.a.a.c a(int r9, int r10, int r11, boolean r12) {
        /*
            r8 = this;
            com.bca.xco.widget.d.a.m r0 = r8.f4767d
            monitor-enter(r0)
            boolean r1 = r8.h     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x008f
            com.bca.xco.widget.d.a.a.f.a r1 = r8.j     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0087
            boolean r1 = r8.i     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x007f
            com.bca.xco.widget.d.a.a.a.c r1 = r8.f4770g     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.h     // Catch:{ all -> 0x0097 }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return r1
        L_0x0019:
            com.bca.xco.widget.d.a.a.a r1 = com.bca.xco.widget.d.a.a.a.f4741a     // Catch:{ all -> 0x0097 }
            com.bca.xco.widget.d.a.m r2 = r8.f4767d     // Catch:{ all -> 0x0097 }
            com.bca.xco.widget.d.a.h r3 = r8.f4765a     // Catch:{ all -> 0x0097 }
            com.bca.xco.widget.d.a.a.a.c r1 = r1.a((com.bca.xco.widget.d.a.m) r2, (com.bca.xco.widget.d.a.h) r3, (com.bca.xco.widget.d.a.a.a.g) r8)     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0029
            r8.f4770g = r1     // Catch:{ all -> 0x0097 }
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return r1
        L_0x0029:
            com.bca.xco.widget.d.a.ab r1 = r8.f4766c     // Catch:{ all -> 0x0097 }
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0041
            com.bca.xco.widget.d.a.a.a.f r0 = r8.f4768e
            com.bca.xco.widget.d.a.ab r1 = r0.b()
            com.bca.xco.widget.d.a.m r0 = r8.f4767d
            monitor-enter(r0)
            r8.f4766c = r1     // Catch:{ all -> 0x003e }
            r2 = 0
            r8.f4769f = r2     // Catch:{ all -> 0x003e }
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            goto L_0x0041
        L_0x003e:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r9
        L_0x0041:
            com.bca.xco.widget.d.a.a.a.c r0 = new com.bca.xco.widget.d.a.a.a.c
            r0.<init>(r1)
            com.bca.xco.widget.d.a.m r1 = r8.f4767d
            monitor-enter(r1)
            r8.a((com.bca.xco.widget.d.a.a.a.c) r0)     // Catch:{ all -> 0x007c }
            com.bca.xco.widget.d.a.a.a r2 = com.bca.xco.widget.d.a.a.a.f4741a     // Catch:{ all -> 0x007c }
            com.bca.xco.widget.d.a.m r3 = r8.f4767d     // Catch:{ all -> 0x007c }
            r2.a((com.bca.xco.widget.d.a.m) r3, (com.bca.xco.widget.d.a.a.a.c) r0)     // Catch:{ all -> 0x007c }
            r8.f4770g = r0     // Catch:{ all -> 0x007c }
            boolean r2 = r8.i     // Catch:{ all -> 0x007c }
            if (r2 != 0) goto L_0x0074
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            com.bca.xco.widget.d.a.h r1 = r8.f4765a
            java.util.List r6 = r1.f()
            r2 = r0
            r3 = r9
            r4 = r10
            r5 = r11
            r7 = r12
            r2.a(r3, r4, r5, r6, r7)
            com.bca.xco.widget.d.a.a.a.d r9 = r8.f()
            com.bca.xco.widget.d.a.ab r10 = r0.a()
            r9.b(r10)
            return r0
        L_0x0074:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x007c }
            java.lang.String r10 = "Canceled"
            r9.<init>(r10)     // Catch:{ all -> 0x007c }
            throw r9     // Catch:{ all -> 0x007c }
        L_0x007c:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            throw r9
        L_0x007f:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = "Canceled"
            r9.<init>(r10)     // Catch:{ all -> 0x0097 }
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x0087:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = "codec != null"
            r9.<init>(r10)     // Catch:{ all -> 0x0097 }
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x008f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0097 }
            java.lang.String r10 = "released"
            r9.<init>(r10)     // Catch:{ all -> 0x0097 }
            throw r9     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.a.g.a(int, int, int, boolean):com.bca.xco.widget.d.a.a.a.c");
    }

    public void a(boolean z, a aVar) {
        synchronized (this.f4767d) {
            if (aVar != null) {
                if (aVar == this.j) {
                    if (!z) {
                        this.f4770g.f4749c++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.j + " but was " + aVar);
        }
        a(z, false, true);
    }

    public a a() {
        a aVar;
        synchronized (this.f4767d) {
            aVar = this.j;
        }
        return aVar;
    }

    private d f() {
        return com.bca.xco.widget.d.a.a.a.f4741a.a(this.f4767d);
    }

    public synchronized c b() {
        return this.f4770g;
    }

    public void c() {
        a(false, true, false);
    }

    public void d() {
        a(true, false, false);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        c cVar;
        synchronized (this.f4767d) {
            if (z3) {
                try {
                    this.j = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z2) {
                this.h = true;
            }
            if (this.f4770g != null) {
                if (z) {
                    this.f4770g.h = true;
                }
                if (this.j == null && (this.h || this.f4770g.h)) {
                    b(this.f4770g);
                    if (this.f4770g.f4753g.isEmpty()) {
                        this.f4770g.i = System.nanoTime();
                        if (com.bca.xco.widget.d.a.a.a.f4741a.b(this.f4767d, this.f4770g)) {
                            cVar = this.f4770g;
                            this.f4770g = null;
                        }
                    }
                    cVar = null;
                    this.f4770g = null;
                }
            }
            cVar = null;
        }
        if (cVar != null) {
            c.a(cVar.b());
        }
    }

    public void a(IOException iOException) {
        boolean z;
        synchronized (this.f4767d) {
            if (iOException instanceof n) {
                n nVar = (n) iOException;
                if (nVar.f5031a == com.bca.xco.widget.d.a.a.g.c.REFUSED_STREAM) {
                    this.f4769f++;
                }
                if (nVar.f5031a != com.bca.xco.widget.d.a.a.g.c.REFUSED_STREAM || this.f4769f > 1) {
                    this.f4766c = null;
                }
                z = false;
            } else {
                if (this.f4770g != null && !this.f4770g.d()) {
                    if (this.f4770g.f4749c == 0) {
                        if (!(this.f4766c == null || iOException == null)) {
                            this.f4768e.a(this.f4766c, iOException);
                        }
                        this.f4766c = null;
                    }
                }
                z = false;
            }
            z = true;
        }
        a(z, false, true);
    }

    public void a(c cVar) {
        if (f4764b || Thread.holdsLock(this.f4767d)) {
            cVar.f4753g.add(new WeakReference(this));
            return;
        }
        throw new AssertionError();
    }

    private void b(c cVar) {
        int size = cVar.f4753g.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.f4753g.get(i2).get() == this) {
                cVar.f4753g.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public boolean e() {
        return this.f4766c != null || this.f4768e.a();
    }

    public String toString() {
        return this.f4765a.toString();
    }
}
