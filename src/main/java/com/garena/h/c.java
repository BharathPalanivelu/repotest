package com.garena.h;

import com.garena.h.a.d;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.garena.h.b.a f8012a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8013b;

    /* renamed from: c  reason: collision with root package name */
    private d f8014c;

    /* renamed from: d  reason: collision with root package name */
    private f f8015d;

    /* renamed from: e  reason: collision with root package name */
    private b f8016e;

    /* renamed from: f  reason: collision with root package name */
    private a f8017f;

    private c(a aVar) {
        this.f8013b = false;
        this.f8014c = aVar.f8018a;
        this.f8015d = aVar.f8019b;
        this.f8016e = aVar.f8020c;
    }

    public boolean a() {
        com.garena.h.b.a aVar = this.f8012a;
        return aVar != null && aVar.e();
    }

    public boolean b() {
        return this.f8012a != null && this.f8013b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.a()     // Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x0035
            boolean r0 = r3.b()     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0035
        L_0x000e:
            r3.e()     // Catch:{ all -> 0x0037 }
            r0 = 1
            r3.f8013b = r0     // Catch:{ all -> 0x0037 }
            com.garena.h.d r0 = r3.f8014c     // Catch:{ all -> 0x0037 }
            com.garena.h.b.a r0 = r0.b()     // Catch:{ all -> 0x0037 }
            r3.f8012a = r0     // Catch:{ all -> 0x0037 }
            com.garena.h.c.b r0 = new com.garena.h.c.b     // Catch:{ all -> 0x0037 }
            com.garena.h.b.a r1 = r3.f8012a     // Catch:{ all -> 0x0037 }
            com.garena.h.f r2 = r3.f8015d     // Catch:{ all -> 0x0037 }
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x0037 }
            r0.start()     // Catch:{ all -> 0x0037 }
            com.garena.h.a r0 = r0.a()     // Catch:{ all -> 0x0037 }
            r3.f8017f = r0     // Catch:{ all -> 0x0037 }
            com.garena.h.a r0 = r3.f8017f     // Catch:{ all -> 0x0037 }
            r0.a()     // Catch:{ all -> 0x0037 }
            monitor-exit(r3)
            return
        L_0x0035:
            monitor-exit(r3)
            return
        L_0x0037:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.h.c.c():void");
    }

    public synchronized void c(e eVar) {
        if (this.f8017f == null || !a()) {
            this.f8016e.a(eVar);
        } else {
            this.f8017f.a(eVar);
        }
    }

    public synchronized void d() {
        e();
    }

    private synchronized void e() {
        this.f8013b = false;
        if (this.f8017f != null) {
            this.f8017f.b();
            this.f8017f = null;
        }
    }

    public void a(String str, d dVar) {
        e();
        this.f8016e.a(str, dVar);
    }

    public void a(e eVar) {
        e();
        this.f8016e.a(eVar);
    }

    public void b(e eVar) {
        this.f8016e.b(eVar);
    }

    public void a(String str) {
        e();
        this.f8016e.a(str);
    }

    public void b(String str) {
        this.f8013b = false;
        this.f8016e.b(str);
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public d f8018a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public f f8019b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public b f8020c;

        public a a(d dVar) {
            this.f8018a = dVar;
            return this;
        }

        public a a(f fVar) {
            this.f8019b = fVar;
            return this;
        }

        public a a(b bVar) {
            this.f8020c = bVar;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
