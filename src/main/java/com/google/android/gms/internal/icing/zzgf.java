package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;
import java.io.IOException;
import java.util.Arrays;

public final class zzgf {
    private static final zzgf zznv = new zzgf(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzfu;
    private int zzju;
    private Object[] zzml;
    private int[] zznw;

    public static zzgf zzdm() {
        return zznv;
    }

    static zzgf zza(zzgf zzgf, zzgf zzgf2) {
        int i = zzgf.count + zzgf2.count;
        int[] copyOf = Arrays.copyOf(zzgf.zznw, i);
        System.arraycopy(zzgf2.zznw, 0, copyOf, zzgf.count, zzgf2.count);
        Object[] copyOf2 = Arrays.copyOf(zzgf.zzml, i);
        System.arraycopy(zzgf2.zzml, 0, copyOf2, zzgf.count, zzgf2.count);
        return new zzgf(i, copyOf, copyOf2, true);
    }

    private zzgf() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgf(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzju = -1;
        this.count = i;
        this.zznw = iArr;
        this.zzml = objArr;
        this.zzfu = z;
    }

    public final void zzah() {
        this.zzfu = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgw zzgw) throws IOException {
        if (zzgw.zzau() == zzdo.zzc.zzkm) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzgw.zza(this.zznw[i] >>> 3, this.zzml[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgw.zza(this.zznw[i2] >>> 3, this.zzml[i2]);
        }
    }

    public final void zzb(zzgw zzgw) throws IOException {
        if (this.count != 0) {
            if (zzgw.zzau() == zzdo.zzc.zzkl) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zznw[i], this.zzml[i], zzgw);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zznw[i2], this.zzml[i2], zzgw);
            }
        }
    }

    private static void zzb(int i, Object obj, zzgw zzgw) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzgw.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzgw.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzgw.zza(i2, (zzcl) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzgw.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzdw.zzbz());
        } else if (zzgw.zzau() == zzdo.zzc.zzkl) {
            zzgw.zzab(i2);
            ((zzgf) obj).zzb(zzgw);
            zzgw.zzac(i2);
        } else {
            zzgw.zzac(i2);
            ((zzgf) obj).zzb(zzgw);
            zzgw.zzab(i2);
        }
    }

    public final int zzdn() {
        int i = this.zzju;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzcy.zzd(this.zznw[i3] >>> 3, (zzcl) this.zzml[i3]);
        }
        this.zzju = i2;
        return i2;
    }

    public final int zzbl() {
        int i;
        int i2 = this.zzju;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zznw[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzcy.zze(i6, ((Long) this.zzml[i4]).longValue());
            } else if (i7 == 1) {
                i = zzcy.zzg(i6, ((Long) this.zzml[i4]).longValue());
            } else if (i7 == 2) {
                i = zzcy.zzc(i6, (zzcl) this.zzml[i4]);
            } else if (i7 == 3) {
                i = (zzcy.zzs(i6) << 1) + ((zzgf) this.zzml[i4]).zzbl();
            } else if (i7 == 5) {
                i = zzcy.zzj(i6, ((Integer) this.zzml[i4]).intValue());
            } else {
                throw new IllegalStateException(zzdw.zzbz());
            }
            i3 += i;
        }
        this.zzju = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgf)) {
            return false;
        }
        zzgf zzgf = (zzgf) obj;
        int i = this.count;
        if (i == zzgf.count) {
            int[] iArr = this.zznw;
            int[] iArr2 = zzgf.zznw;
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
                Object[] objArr = this.zzml;
                Object[] objArr2 = zzgf.zzml;
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
        int[] iArr = this.zznw;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzml;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzey.zza(sb, i, String.valueOf(this.zznw[i2] >>> 3), this.zzml[i2]);
        }
    }
}
