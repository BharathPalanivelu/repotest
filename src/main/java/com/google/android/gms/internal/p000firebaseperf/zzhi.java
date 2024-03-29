package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhi  reason: invalid package */
public final class zzhi {
    private static final zzhi zzuq = new zzhi(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzms;
    private int zzqm;
    private Object[] zztg;
    private int[] zzur;

    public static zzhi zzjh() {
        return zzuq;
    }

    static zzhi zza(zzhi zzhi, zzhi zzhi2) {
        int i = zzhi.count + zzhi2.count;
        int[] copyOf = Arrays.copyOf(zzhi.zzur, i);
        System.arraycopy(zzhi2.zzur, 0, copyOf, zzhi.count, zzhi2.count);
        Object[] copyOf2 = Arrays.copyOf(zzhi.zztg, i);
        System.arraycopy(zzhi2.zztg, 0, copyOf2, zzhi.count, zzhi2.count);
        return new zzhi(i, copyOf, copyOf2, true);
    }

    private zzhi() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhi(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzqm = -1;
        this.count = i;
        this.zzur = iArr;
        this.zztg = objArr;
        this.zzms = z;
    }

    public final void zzgf() {
        this.zzms = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhz zzhz) throws IOException {
        if (zzhz.zzgt() == zzep.zzc.zzre) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzhz.zza(this.zzur[i] >>> 3, this.zztg[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhz.zza(this.zzur[i2] >>> 3, this.zztg[i2]);
        }
    }

    public final void zzb(zzhz zzhz) throws IOException {
        if (this.count != 0) {
            if (zzhz.zzgt() == zzep.zzc.zzrd) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzur[i], this.zztg[i], zzhz);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzur[i2], this.zztg[i2], zzhz);
            }
        }
    }

    private static void zzb(int i, Object obj, zzhz zzhz) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzhz.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzhz.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzhz.zza(i2, (zzdl) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzhz.zzj(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfa.zzht());
        } else if (zzhz.zzgt() == zzep.zzc.zzrd) {
            zzhz.zzai(i2);
            ((zzhi) obj).zzb(zzhz);
            zzhz.zzaj(i2);
        } else {
            zzhz.zzaj(i2);
            ((zzhi) obj).zzb(zzhz);
            zzhz.zzai(i2);
        }
    }

    public final int zzji() {
        int i = this.zzqm;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzec.zzd(this.zzur[i3] >>> 3, (zzdl) this.zztg[i3]);
        }
        this.zzqm = i2;
        return i2;
    }

    public final int zzhh() {
        int i;
        int i2 = this.zzqm;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzur[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzec.zze(i6, ((Long) this.zztg[i4]).longValue());
            } else if (i7 == 1) {
                i = zzec.zzg(i6, ((Long) this.zztg[i4]).longValue());
            } else if (i7 == 2) {
                i = zzec.zzc(i6, (zzdl) this.zztg[i4]);
            } else if (i7 == 3) {
                i = (zzec.zzy(i6) << 1) + ((zzhi) this.zztg[i4]).zzhh();
            } else if (i7 == 5) {
                i = zzec.zzn(i6, ((Integer) this.zztg[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfa.zzht());
            }
            i3 += i;
        }
        this.zzqm = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhi)) {
            return false;
        }
        zzhi zzhi = (zzhi) obj;
        int i = this.count;
        if (i == zzhi.count) {
            int[] iArr = this.zzur;
            int[] iArr2 = zzhi.zzur;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zztg;
                Object[] objArr2 = zzhi.zztg;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzur;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zztg;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgb.zza(sb, i, String.valueOf(this.zzur[i2] >>> 3), this.zztg[i2]);
        }
    }
}
