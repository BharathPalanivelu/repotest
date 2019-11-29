package com.google.android.gms.internal.p000firebaseperf;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzah  reason: invalid package */
public final class zzah {
    public static int zza(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return j < -2147483648L ? RNCartPanelDataEntity.NULL_VALUE : (int) j;
    }
}
