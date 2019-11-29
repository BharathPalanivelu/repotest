package io.b.e.a;

import io.b.b.b;
import io.b.c.a;
import io.b.e.h.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d implements b, a {

    /* renamed from: a  reason: collision with root package name */
    List<b> f33325a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f33326b;

    public void dispose() {
        if (!this.f33326b) {
            synchronized (this) {
                if (!this.f33326b) {
                    this.f33326b = true;
                    List<b> list = this.f33325a;
                    this.f33325a = null;
                    a(list);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f33326b;
    }

    public boolean a(b bVar) {
        io.b.e.b.b.a(bVar, "d is null");
        if (!this.f33326b) {
            synchronized (this) {
                if (!this.f33326b) {
                    List list = this.f33325a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f33325a = list;
                    }
                    list.add(bVar);
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
            boolean r0 = r2.f33326b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f33326b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<io.b.b.b> r0 = r2.f33325a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.b.e.a.d.c(io.b.b.b):boolean");
    }

    /* access modifiers changed from: package-private */
    public void a(List<b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (b dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th) {
                    io.b.c.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw f.a((Throwable) arrayList.get(0));
            }
            throw new a((Iterable<? extends Throwable>) arrayList);
        }
    }
}
