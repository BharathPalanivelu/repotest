package com.google.android.gms.internal.p000firebaseperf;

import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.BaseConstants;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzba  reason: invalid package */
public enum zzba {
    TERABYTES(1099511627776L),
    GIGABYTES(IjkMediaMeta.AV_CH_STEREO_RIGHT),
    MEGABYTES(BaseConstants.MEGA),
    KILOBYTES(IjkMediaMeta.AV_CH_SIDE_RIGHT),
    BYTES(1);
    
    private long zzhu;

    private zzba(long j) {
        this.zzhu = j;
    }

    public final long zzp(long j) {
        return (j * this.zzhu) / KILOBYTES.zzhu;
    }
}
