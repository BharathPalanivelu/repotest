package com.google.android.gms.internal.p000firebaseperf;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.firebase-perf.zze  reason: invalid package */
final class zze extends ContentObserver {
    zze(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzb.zze.set(true);
    }
}
