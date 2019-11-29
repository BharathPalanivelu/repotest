package com.google.android.gms.internal.icing;

final class zzcz extends zzcx {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzgl;
    private int zzgm;
    private int zzgn;
    private int zzgo;

    private zzcz(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzgo = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzgn = this.pos;
        this.zzgl = z;
    }

    public final int zzn(int i) throws zzdw {
        if (i >= 0) {
            int zzaq = i + zzaq();
            int i2 = this.zzgo;
            if (zzaq <= i2) {
                this.zzgo = zzaq;
                this.limit += this.zzgm;
                int i3 = this.limit;
                int i4 = i3 - this.zzgn;
                int i5 = this.zzgo;
                if (i4 > i5) {
                    this.zzgm = i4 - i5;
                    this.limit = i3 - this.zzgm;
                } else {
                    this.zzgm = 0;
                }
                return i2;
            }
            throw new zzdw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzdw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zzaq() {
        return this.pos - this.zzgn;
    }
}
