package com.google.android.gms.internal.p000firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdz  reason: invalid package */
final class zzdz extends zzdx {
    private final byte[] buffer;
    private final boolean immutable;
    private int limit;
    private int pos;
    private int zzne;
    private int zznf;
    private int zzng;

    private zzdz(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzng = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zznf = this.pos;
        this.immutable = z;
    }

    public final int zzt(int i) throws zzfa {
        if (i >= 0) {
            int zzgn = i + zzgn();
            int i2 = this.zzng;
            if (zzgn <= i2) {
                this.zzng = zzgn;
                this.limit += this.zzne;
                int i3 = this.limit;
                int i4 = i3 - this.zznf;
                int i5 = this.zzng;
                if (i4 > i5) {
                    this.zzne = i4 - i5;
                    this.limit = i3 - this.zzne;
                } else {
                    this.zzne = 0;
                }
                return i2;
            }
            throw new zzfa("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzfa("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zzgn() {
        return this.pos - this.zznf;
    }
}
