package com.google.android.gms.internal.firebase_remote_config;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzec {
    private final ConcurrentHashMap<zzef, List<Throwable>> zziu = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zziv = new ReferenceQueue<>();

    zzec() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zziv.poll();
        while (poll != null) {
            this.zziu.remove(poll);
            poll = this.zziv.poll();
        }
        List<Throwable> list = this.zziu.get(new zzef(th, (ReferenceQueue<Throwable>) null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zziu.putIfAbsent(new zzef(th, this.zziv), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
