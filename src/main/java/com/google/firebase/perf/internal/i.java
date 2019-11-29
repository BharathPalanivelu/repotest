package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzcd;

final class i extends q {

    /* renamed from: a  reason: collision with root package name */
    private final zzcd f14252a;

    i(zzcd zzcd) {
        this.f14252a = zzcd;
    }

    public final boolean a() {
        if (!this.f14252a.zzdr()) {
            return false;
        }
        if (this.f14252a.zzdv() > 0 || this.f14252a.zzdw() > 0) {
            return true;
        }
        return this.f14252a.zzdt() && this.f14252a.zzdu().zzdn();
    }
}
