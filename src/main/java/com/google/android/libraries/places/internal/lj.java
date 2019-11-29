package com.google.android.libraries.places.internal;

public class lj {

    /* renamed from: a  reason: collision with root package name */
    public kc f12932a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ma f12933b;

    /* renamed from: c  reason: collision with root package name */
    public volatile kc f12934c;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lj)) {
            return false;
        }
        lj ljVar = (lj) obj;
        ma maVar = this.f12933b;
        ma maVar2 = ljVar.f12933b;
        if (maVar == null && maVar2 == null) {
            return b().equals(ljVar.b());
        }
        if (maVar != null && maVar2 != null) {
            return maVar.equals(maVar2);
        }
        if (maVar != null) {
            return maVar.equals(ljVar.a(maVar.k()));
        }
        return a(maVar2.k()).equals(maVar2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.libraries.places.internal.ma a(com.google.android.libraries.places.internal.ma r2) {
        /*
            r1 = this;
            com.google.android.libraries.places.internal.ma r0 = r1.f12933b
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.libraries.places.internal.ma r0 = r1.f12933b     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.f12933b = r2     // Catch:{ ld -> 0x0012 }
            com.google.android.libraries.places.internal.kc r0 = com.google.android.libraries.places.internal.kc.f12862a     // Catch:{ ld -> 0x0012 }
            r1.f12934c = r0     // Catch:{ ld -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.f12933b = r2     // Catch:{ all -> 0x001a }
            com.google.android.libraries.places.internal.kc r2 = com.google.android.libraries.places.internal.kc.f12862a     // Catch:{ all -> 0x001a }
            r1.f12934c = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.libraries.places.internal.ma r2 = r1.f12933b
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.lj.a(com.google.android.libraries.places.internal.ma):com.google.android.libraries.places.internal.ma");
    }

    public final kc b() {
        if (this.f12934c != null) {
            return this.f12934c;
        }
        synchronized (this) {
            if (this.f12934c != null) {
                kc kcVar = this.f12934c;
                return kcVar;
            }
            if (this.f12933b == null) {
                this.f12934c = kc.f12862a;
            } else {
                this.f12934c = this.f12933b.b();
            }
            kc kcVar2 = this.f12934c;
            return kcVar2;
        }
    }

    static {
        km.a();
    }
}
