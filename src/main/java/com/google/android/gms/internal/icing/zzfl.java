package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;

final class zzfl implements zzev {
    private final int flags;
    private final String info;
    private final zzex zzme;
    private final Object[] zzml;

    zzfl(zzex zzex, String str, Object[] objArr) {
        this.zzme = zzex;
        this.info = str;
        this.zzml = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c2 | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzcx() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzcy() {
        return this.zzml;
    }

    public final zzex zzcq() {
        return this.zzme;
    }

    public final int zzco() {
        return (this.flags & 1) == 1 ? zzdo.zzc.zzki : zzdo.zzc.zzkj;
    }

    public final boolean zzcp() {
        return (this.flags & 2) == 2;
    }
}
