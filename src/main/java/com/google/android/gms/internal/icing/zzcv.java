package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.nio.charset.Charset;

class zzcv extends zzcs {
    protected final byte[] zzgf;

    zzcv(byte[] bArr) {
        if (bArr != null) {
            this.zzgf = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzan() {
        return 0;
    }

    public byte zzk(int i) {
        return this.zzgf[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzl(int i) {
        return this.zzgf[i];
    }

    public int size() {
        return this.zzgf.length;
    }

    public final zzcl zza(int i, int i2) {
        int zzb = zzb(0, i2, size());
        if (zzb == 0) {
            return zzcl.zzfy;
        }
        return new zzco(this.zzgf, zzan(), zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzci zzci) throws IOException {
        zzci.zza(this.zzgf, zzan(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzgf, zzan(), size(), charset);
    }

    public final boolean zzal() {
        int zzan = zzan();
        return zzgl.zzc(this.zzgf, zzan, size() + zzan);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcl) || size() != ((zzcl) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzcv)) {
            return obj.equals(this);
        }
        zzcv zzcv = (zzcv) obj;
        int zzam = zzam();
        int zzam2 = zzcv.zzam();
        if (zzam == 0 || zzam2 == 0 || zzam == zzam2) {
            return zza(zzcv, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzcl zzcl, int i, int i2) {
        if (i2 > zzcl.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzcl.size()) {
            int size2 = zzcl.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzcl instanceof zzcv)) {
            return zzcl.zza(0, i2).equals(zza(0, i2));
        } else {
            zzcv zzcv = (zzcv) zzcl;
            byte[] bArr = this.zzgf;
            byte[] bArr2 = zzcv.zzgf;
            int zzan = zzan() + i2;
            int zzan2 = zzan();
            int zzan3 = zzcv.zzan();
            while (zzan2 < zzan) {
                if (bArr[zzan2] != bArr2[zzan3]) {
                    return false;
                }
                zzan2++;
                zzan3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzdq.zza(i, this.zzgf, zzan(), i3);
    }
}
