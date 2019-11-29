package com.google.android.gms.internal.vision;

public class zzde {
    private static final zzcf zzgk = zzcf.zzbg();
    private zzbo zzmi;
    private volatile zzdx zzmj;
    private volatile zzbo zzmk;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.vision.zzdx zzh(com.google.android.gms.internal.vision.zzdx r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.vision.zzdx r0 = r1.zzmj
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.vision.zzdx r0 = r1.zzmj     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzmj = r2     // Catch:{ zzcx -> 0x0012 }
            com.google.android.gms.internal.vision.zzbo r0 = com.google.android.gms.internal.vision.zzbo.zzgt     // Catch:{ zzcx -> 0x0012 }
            r1.zzmk = r0     // Catch:{ zzcx -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzmj = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.vision.zzbo r2 = com.google.android.gms.internal.vision.zzbo.zzgt     // Catch:{ all -> 0x0019 }
            r1.zzmk = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.vision.zzdx r2 = r1.zzmj
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzde.zzh(com.google.android.gms.internal.vision.zzdx):com.google.android.gms.internal.vision.zzdx");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzde)) {
            return false;
        }
        zzde zzde = (zzde) obj;
        zzdx zzdx = this.zzmj;
        zzdx zzdx2 = zzde.zzmj;
        return (zzdx == null && zzdx2 == null) ? zzak().equals(zzde.zzak()) : (zzdx == null || zzdx2 == null) ? zzdx != null ? zzdx.equals(zzde.zzh(zzdx.zzbw())) : zzh(zzdx2.zzbw()).equals(zzdx2) : zzdx.equals(zzdx2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzbo zzak() {
        if (this.zzmk != null) {
            return this.zzmk;
        }
        synchronized (this) {
            if (this.zzmk != null) {
                zzbo zzbo = this.zzmk;
                return zzbo;
            }
            this.zzmk = this.zzmj == null ? zzbo.zzgt : this.zzmj.zzak();
            zzbo zzbo2 = this.zzmk;
            return zzbo2;
        }
    }

    public final int zzbl() {
        if (this.zzmk != null) {
            return this.zzmk.size();
        }
        if (this.zzmj != null) {
            return this.zzmj.zzbl();
        }
        return 0;
    }

    public final zzdx zzi(zzdx zzdx) {
        zzdx zzdx2 = this.zzmj;
        this.zzmi = null;
        this.zzmk = null;
        this.zzmj = zzdx;
        return zzdx2;
    }
}
