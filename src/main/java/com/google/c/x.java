package com.google.c;

public class x {

    /* renamed from: b  reason: collision with root package name */
    private static final p f14066b = p.e();

    /* renamed from: a  reason: collision with root package name */
    protected volatile ad f14067a;

    /* renamed from: c  reason: collision with root package name */
    private f f14068c;

    /* renamed from: d  reason: collision with root package name */
    private p f14069d;

    /* renamed from: e  reason: collision with root package name */
    private volatile f f14070e;

    public int hashCode() {
        return 1;
    }

    public x(p pVar, f fVar) {
        a(pVar, fVar);
        this.f14069d = pVar;
        this.f14068c = fVar;
    }

    public x() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        ad adVar = this.f14067a;
        ad adVar2 = xVar.f14067a;
        if (adVar == null && adVar2 == null) {
            return c().equals(xVar.c());
        }
        if (adVar != null && adVar2 != null) {
            return adVar.equals(adVar2);
        }
        if (adVar != null) {
            return adVar.equals(xVar.a(adVar.K()));
        }
        return a(adVar2.K()).equals(adVar2);
    }

    public ad a(ad adVar) {
        c(adVar);
        return this.f14067a;
    }

    public ad b(ad adVar) {
        ad adVar2 = this.f14067a;
        this.f14068c = null;
        this.f14070e = null;
        this.f14067a = adVar;
        return adVar2;
    }

    public int b() {
        if (this.f14070e != null) {
            return this.f14070e.b();
        }
        f fVar = this.f14068c;
        if (fVar != null) {
            return fVar.b();
        }
        if (this.f14067a != null) {
            return this.f14067a.b();
        }
        return 0;
    }

    public f c() {
        if (this.f14070e != null) {
            return this.f14070e;
        }
        f fVar = this.f14068c;
        if (fVar != null) {
            return fVar;
        }
        synchronized (this) {
            if (this.f14070e != null) {
                f fVar2 = this.f14070e;
                return fVar2;
            }
            if (this.f14067a == null) {
                this.f14070e = f.f13707a;
            } else {
                this.f14070e = this.f14067a.d();
            }
            f fVar3 = this.f14070e;
            return fVar3;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f14067a = r4;
        r3.f14070e = com.google.c.f.f13707a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.google.c.ad r4) {
        /*
            r3 = this;
            com.google.c.ad r0 = r3.f14067a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.c.ad r0 = r3.f14067a     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.c.f r0 = r3.f14068c     // Catch:{ v -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.c.aj r0 = r4.F()     // Catch:{ v -> 0x002c }
            com.google.c.f r1 = r3.f14068c     // Catch:{ v -> 0x002c }
            com.google.c.p r2 = r3.f14069d     // Catch:{ v -> 0x002c }
            java.lang.Object r0 = r0.c((com.google.c.f) r1, (com.google.c.p) r2)     // Catch:{ v -> 0x002c }
            com.google.c.ad r0 = (com.google.c.ad) r0     // Catch:{ v -> 0x002c }
            r3.f14067a = r0     // Catch:{ v -> 0x002c }
            com.google.c.f r0 = r3.f14068c     // Catch:{ v -> 0x002c }
            r3.f14070e = r0     // Catch:{ v -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f14067a = r4     // Catch:{ v -> 0x002c }
            com.google.c.f r0 = com.google.c.f.f13707a     // Catch:{ v -> 0x002c }
            r3.f14070e = r0     // Catch:{ v -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f14067a = r4     // Catch:{ all -> 0x0034 }
            com.google.c.f r4 = com.google.c.f.f13707a     // Catch:{ all -> 0x0034 }
            r3.f14070e = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.x.c(com.google.c.ad):void");
    }

    private static void a(p pVar, f fVar) {
        if (pVar == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (fVar == null) {
            throw new NullPointerException("found null ByteString");
        }
    }
}
