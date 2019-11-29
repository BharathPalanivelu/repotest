package com.google.android.gms.internal.icing;

import android.database.ContentObserver;
import android.os.Handler;

final class zzbe extends ContentObserver {
    private final /* synthetic */ zzbc zzcp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbe(zzbc zzbc, Handler handler) {
        super((Handler) null);
        this.zzcp = zzbc;
    }

    public final void onChange(boolean z) {
        this.zzcp.zzn();
    }
}
