package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zziw<T> implements zzjf<T> {
    private final zziq zzvv;
    private final boolean zzvw;
    private final zzjx<?, ?> zzwf;
    private final zzgz<?> zzwg;

    private zziw(zzjx<?, ?> zzjx, zzgz<?> zzgz, zziq zziq) {
        this.zzwf = zzjx;
        this.zzvw = zzgz.zze(zziq);
        this.zzwg = zzgz;
        this.zzvv = zziq;
    }

    static <T> zziw<T> zza(zzjx<?, ?> zzjx, zzgz<?> zzgz, zziq zziq) {
        return new zziw<>(zzjx, zzgz, zziq);
    }

    public final T newInstance() {
        return this.zzvv.zzgv().zzha();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzwf.zzaa(t).equals(this.zzwf.zzaa(t2))) {
            return false;
        }
        if (this.zzvw) {
            return this.zzwg.zzk(t).equals(this.zzwg.zzk(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzwf.zzaa(t).hashCode();
        return this.zzvw ? (hashCode * 53) + this.zzwg.zzk(t).hashCode() : hashCode;
    }

    public final void zze(T t, T t2) {
        zzjh.zza(this.zzwf, t, t2);
        if (this.zzvw) {
            zzjh.zza(this.zzwg, t, t2);
        }
    }

    public final void zza(T t, zzku zzku) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzwg.zzk(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzhc zzhc = (zzhc) next.getKey();
            if (zzhc.zzgp() != zzkr.MESSAGE || zzhc.zzgq() || zzhc.zzgr()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzht) {
                zzku.zza(zzhc.zzgn(), (Object) ((zzht) next).zzhp().zzep());
            } else {
                zzku.zza(zzhc.zzgn(), next.getValue());
            }
        }
        zzjx<?, ?> zzjx = this.zzwf;
        zzjx.zzc(zzjx.zzaa(t), zzku);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.firebase_remote_config.zzhi$zzc} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.firebase_remote_config.zzfw r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.firebase_remote_config.zzhi r0 = (com.google.android.gms.internal.firebase_remote_config.zzhi) r0
            com.google.android.gms.internal.firebase_remote_config.zzka r1 = r0.zztc
            com.google.android.gms.internal.firebase_remote_config.zzka r2 = com.google.android.gms.internal.firebase_remote_config.zzka.zzja()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.firebase_remote_config.zzka r1 = com.google.android.gms.internal.firebase_remote_config.zzka.zzjb()
            r0.zztc = r1
        L_0x0011:
            com.google.android.gms.internal.firebase_remote_config.zzhi$zzd r10 = (com.google.android.gms.internal.firebase_remote_config.zzhi.zzd) r10
            r10.zzhc()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.firebase_remote_config.zzft.zza(r11, r12, r14)
            int r2 = r14.zzor
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.firebase_remote_config.zzgz<?> r12 = r9.zzwg
            com.google.android.gms.internal.firebase_remote_config.zzgx r0 = r14.zzou
            com.google.android.gms.internal.firebase_remote_config.zziq r3 = r9.zzvv
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.firebase_remote_config.zzhi$zzc r0 = (com.google.android.gms.internal.firebase_remote_config.zzhi.zzc) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.firebase_remote_config.zzft.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.firebase_remote_config.zzka) r6, (com.google.android.gms.internal.firebase_remote_config.zzfw) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.firebase_remote_config.zzjb.zzii()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.firebase_remote_config.zzft.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.firebase_remote_config.zzfw) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.firebase_remote_config.zzft.zza(r11, r4, r14)
            int r5 = r14.zzor
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.firebase_remote_config.zzft.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzot
            com.google.android.gms.internal.firebase_remote_config.zzfx r2 = (com.google.android.gms.internal.firebase_remote_config.zzfx) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.firebase_remote_config.zzjb.zzii()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.firebase_remote_config.zzft.zza(r11, r4, r14)
            int r12 = r14.zzor
            com.google.android.gms.internal.firebase_remote_config.zzgz<?> r0 = r9.zzwg
            com.google.android.gms.internal.firebase_remote_config.zzgx r5 = r14.zzou
            com.google.android.gms.internal.firebase_remote_config.zziq r6 = r9.zzvv
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.firebase_remote_config.zzhi$zzc r0 = (com.google.android.gms.internal.firebase_remote_config.zzhi.zzc) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.firebase_remote_config.zzft.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.firebase_remote_config.zzfw) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzb((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.firebase_remote_config.zzhq r10 = com.google.android.gms.internal.firebase_remote_config.zzhq.zzhl()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zziw.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase_remote_config.zzfw):void");
    }

    public final void zza(T t, zzjg zzjg, zzgx zzgx) throws IOException {
        boolean z;
        zzjx<?, ?> zzjx = this.zzwf;
        zzgz<?> zzgz = this.zzwg;
        Object zzab = zzjx.zzab(t);
        zzha<?> zzl = zzgz.zzl(t);
        do {
            try {
                if (zzjg.zzfz() == Integer.MAX_VALUE) {
                    zzjx.zzh(t, zzab);
                    return;
                }
                int tag = zzjg.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzfx zzfx = null;
                    while (zzjg.zzfz() != Integer.MAX_VALUE) {
                        int tag2 = zzjg.getTag();
                        if (tag2 == 16) {
                            i = zzjg.zzfk();
                            obj = zzgz.zza(zzgx, this.zzvv, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzgz.zza(zzjg, obj, zzgx, zzl);
                            } else {
                                zzfx = zzjg.zzfj();
                            }
                        } else if (!zzjg.zzga()) {
                            break;
                        }
                    }
                    if (zzjg.getTag() != 12) {
                        throw zzhq.zzhi();
                    } else if (zzfx != null) {
                        if (obj != null) {
                            zzgz.zza(zzfx, obj, zzgx, zzl);
                        } else {
                            zzjx.zza(zzab, i, zzfx);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzgz.zza(zzgx, this.zzvv, tag >>> 3);
                    if (zza != null) {
                        zzgz.zza(zzjg, zza, zzgx, zzl);
                    } else {
                        z = zzjx.zza(zzab, zzjg);
                        continue;
                    }
                } else {
                    z = zzjg.zzga();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzjx.zzh(t, zzab);
            }
        } while (z);
    }

    public final void zzm(T t) {
        this.zzwf.zzm(t);
        this.zzwg.zzm(t);
    }

    public final boolean zzy(T t) {
        return this.zzwg.zzk(t).isInitialized();
    }

    public final int zzw(T t) {
        zzjx<?, ?> zzjx = this.zzwf;
        int zzac = zzjx.zzac(zzjx.zzaa(t)) + 0;
        return this.zzvw ? zzac + this.zzwg.zzk(t).zzgj() : zzac;
    }
}
