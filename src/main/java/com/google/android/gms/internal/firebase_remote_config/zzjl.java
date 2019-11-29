package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map;

final class zzjl extends zzjr {
    private final /* synthetic */ zzjk zzwy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzjl(zzjk zzjk) {
        super(zzjk, (zzjj) null);
        this.zzwy = zzjk;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzjm(this.zzwy, (zzjj) null);
    }

    /* synthetic */ zzjl(zzjk zzjk, zzjj zzjj) {
        this(zzjk);
    }
}
