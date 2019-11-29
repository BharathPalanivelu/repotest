package com.google.android.gms.internal.places;

final class zzak extends zzai {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzet;
    private int zzeu;
    private int zzev;
    private int zzew;

    private zzak(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzew = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzev = this.pos;
        this.zzet = z;
    }

    public final int zzl(int i) throws zzbk {
        if (i >= 0) {
            int zzaj = i + zzaj();
            int i2 = this.zzew;
            if (zzaj <= i2) {
                this.zzew = zzaj;
                this.limit += this.zzeu;
                int i3 = this.limit;
                int i4 = i3 - this.zzev;
                int i5 = this.zzew;
                if (i4 > i5) {
                    this.zzeu = i4 - i5;
                    this.limit = i3 - this.zzeu;
                } else {
                    this.zzeu = 0;
                }
                return i2;
            }
            throw zzbk.zzbp();
        }
        throw zzbk.zzbq();
    }

    public final int zzaj() {
        return this.pos - this.zzev;
    }
}
