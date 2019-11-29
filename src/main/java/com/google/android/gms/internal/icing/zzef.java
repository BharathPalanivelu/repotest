package com.google.android.gms.internal.icing;

public class zzef {
    private static final zzdf zzfr = zzdf.zzaz();
    private zzcl zzlo;
    private volatile zzex zzlp;
    private volatile zzcl zzlq;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzef)) {
            return false;
        }
        zzef zzef = (zzef) obj;
        zzex zzex = this.zzlp;
        zzex zzex2 = zzef.zzlp;
        if (zzex == null && zzex2 == null) {
            return zzab().equals(zzef.zzab());
        }
        if (zzex != null && zzex2 != null) {
            return zzex.equals(zzex2);
        }
        if (zzex != null) {
            return zzex.equals(zzef.zzg(zzex.zzbr()));
        }
        return zzg(zzex2.zzbr()).equals(zzex2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.icing.zzex zzg(com.google.android.gms.internal.icing.zzex r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.icing.zzex r0 = r1.zzlp
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.icing.zzex r0 = r1.zzlp     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzlp = r2     // Catch:{ zzdw -> 0x0012 }
            com.google.android.gms.internal.icing.zzcl r0 = com.google.android.gms.internal.icing.zzcl.zzfy     // Catch:{ zzdw -> 0x0012 }
            r1.zzlq = r0     // Catch:{ zzdw -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzlp = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.icing.zzcl r2 = com.google.android.gms.internal.icing.zzcl.zzfy     // Catch:{ all -> 0x001a }
            r1.zzlq = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.icing.zzex r2 = r1.zzlp
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzef.zzg(com.google.android.gms.internal.icing.zzex):com.google.android.gms.internal.icing.zzex");
    }

    public final zzex zzh(zzex zzex) {
        zzex zzex2 = this.zzlp;
        this.zzlo = null;
        this.zzlq = null;
        this.zzlp = zzex;
        return zzex2;
    }

    public final int zzbl() {
        if (this.zzlq != null) {
            return this.zzlq.size();
        }
        if (this.zzlp != null) {
            return this.zzlp.zzbl();
        }
        return 0;
    }

    public final zzcl zzab() {
        if (this.zzlq != null) {
            return this.zzlq;
        }
        synchronized (this) {
            if (this.zzlq != null) {
                zzcl zzcl = this.zzlq;
                return zzcl;
            }
            if (this.zzlp == null) {
                this.zzlq = zzcl.zzfy;
            } else {
                this.zzlq = this.zzlp.zzab();
            }
            zzcl zzcl2 = this.zzlq;
            return zzcl2;
        }
    }
}
