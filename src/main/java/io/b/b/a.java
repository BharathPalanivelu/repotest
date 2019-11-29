package io.b.b;

import io.b.e.b.b;
import io.b.e.h.f;
import io.b.e.h.h;
import java.util.ArrayList;

public final class a implements b, io.b.e.a.a {

    /* renamed from: a  reason: collision with root package name */
    h<b> f33321a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f33322b;

    public void dispose() {
        if (!this.f33322b) {
            synchronized (this) {
                if (!this.f33322b) {
                    this.f33322b = true;
                    h<b> hVar = this.f33321a;
                    this.f33321a = null;
                    a(hVar);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f33322b;
    }

    public boolean a(b bVar) {
        b.a(bVar, "d is null");
        if (!this.f33322b) {
            synchronized (this) {
                if (!this.f33322b) {
                    h<b> hVar = this.f33321a;
                    if (hVar == null) {
                        hVar = new h<>();
                        this.f33321a = hVar;
                    }
                    hVar.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public boolean b(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(io.b.b.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "Disposable item is null"
            io.b.e.b.b.a(r3, (java.lang.String) r0)
            boolean r0 = r2.f33322b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f33322b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            io.b.e.h.h<io.b.b.b> r0 = r2.f33321a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.b(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.b.b.a.c(io.b.b.b):boolean");
    }

    /* access modifiers changed from: package-private */
    public void a(h<b> hVar) {
        if (hVar != null) {
            ArrayList arrayList = null;
            for (Object obj : hVar.b()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th) {
                        io.b.c.b.b(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw f.a((Throwable) arrayList.get(0));
            }
            throw new io.b.c.a((Iterable<? extends Throwable>) arrayList);
        }
    }
}
