package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzff  reason: invalid package */
public class zzff {
    private static final zzeg zzmp = zzeg.zzgv();
    private zzdl zzsb;
    private volatile zzga zzsc;
    private volatile zzdl zzsd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzff)) {
            return false;
        }
        zzff zzff = (zzff) obj;
        zzga zzga = this.zzsc;
        zzga zzga2 = zzff.zzsc;
        if (zzga == null && zzga2 == null) {
            return zzfz().equals(zzff.zzfz());
        }
        if (zzga != null && zzga2 != null) {
            return zzga.equals(zzga2);
        }
        if (zzga != null) {
            return zzga.equals(zzff.zzg(zzga.zzhl()));
        }
        return zzg(zzga2.zzhl()).equals(zzga2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.p000firebaseperf.zzga zzg(com.google.android.gms.internal.p000firebaseperf.zzga r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-perf.zzga r0 = r1.zzsc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-perf.zzga r0 = r1.zzsc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzsc = r2     // Catch:{ zzfa -> 0x0012 }
            com.google.android.gms.internal.firebase-perf.zzdl r0 = com.google.android.gms.internal.p000firebaseperf.zzdl.zzmt     // Catch:{ zzfa -> 0x0012 }
            r1.zzsd = r0     // Catch:{ zzfa -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzsc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase-perf.zzdl r2 = com.google.android.gms.internal.p000firebaseperf.zzdl.zzmt     // Catch:{ all -> 0x001a }
            r1.zzsd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase-perf.zzga r2 = r1.zzsc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.zzff.zzg(com.google.android.gms.internal.firebase-perf.zzga):com.google.android.gms.internal.firebase-perf.zzga");
    }

    public final zzga zzh(zzga zzga) {
        zzga zzga2 = this.zzsc;
        this.zzsb = null;
        this.zzsd = null;
        this.zzsc = zzga;
        return zzga2;
    }

    public final int zzhh() {
        if (this.zzsd != null) {
            return this.zzsd.size();
        }
        if (this.zzsc != null) {
            return this.zzsc.zzhh();
        }
        return 0;
    }

    public final zzdl zzfz() {
        if (this.zzsd != null) {
            return this.zzsd;
        }
        synchronized (this) {
            if (this.zzsd != null) {
                zzdl zzdl = this.zzsd;
                return zzdl;
            }
            if (this.zzsc == null) {
                this.zzsd = zzdl.zzmt;
            } else {
                this.zzsd = this.zzsc.zzfz();
            }
            zzdl zzdl2 = this.zzsd;
            return zzdl2;
        }
    }
}
