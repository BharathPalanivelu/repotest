package com.google.android.gms.internal.p000firebaseperf;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzam  reason: invalid package */
final class zzam {
    private final ConcurrentHashMap<zzal, List<Throwable>> zzam = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzan = new ReferenceQueue<>();

    zzam() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzan.poll();
        while (poll != null) {
            this.zzam.remove(poll);
            poll = this.zzan.poll();
        }
        List<Throwable> list = this.zzam.get(new zzal(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzam.putIfAbsent(new zzal(th, this.zzan), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
