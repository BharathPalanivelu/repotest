package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgo  reason: invalid package */
final class zzgo implements zzfy {
    private final int flags;
    private final String info;
    private final zzga zzsz;
    private final Object[] zztg;

    zzgo(zzga zzga, String str, Object[] objArr) {
        this.zzsz = zzga;
        this.info = str;
        this.zztg = objArr;
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
    public final String zzis() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzit() {
        return this.zztg;
    }

    public final zzga zzil() {
        return this.zzsz;
    }

    public final int zzij() {
        return (this.flags & 1) == 1 ? zzep.zzc.zzra : zzep.zzc.zzrb;
    }

    public final boolean zzik() {
        return (this.flags & 2) == 2;
    }
}
