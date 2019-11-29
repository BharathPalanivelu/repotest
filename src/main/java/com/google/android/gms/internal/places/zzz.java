package com.google.android.gms.internal.places;

final class zzz extends zzag {
    private final int zzek;
    private final int zzel;

    zzz(byte[] bArr, int i, int i2) {
        super(bArr);
        zzc(i, i + i2, bArr.length);
        this.zzek = i;
        this.zzel = i2;
    }

    public final byte zzi(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzen[this.zzek + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzj(int i) {
        return this.zzen[this.zzek + i];
    }

    public final int size() {
        return this.zzel;
    }

    /* access modifiers changed from: protected */
    public final int zzag() {
        return this.zzek;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzen, zzag(), bArr, 0, i3);
    }
}
