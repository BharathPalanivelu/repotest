package com.google.firebase.perf.metrics;

import com.google.android.gms.internal.p000firebaseperf.zzcr;
import com.google.android.gms.internal.p000firebaseperf.zzda;
import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.google.firebase.perf.internal.zzq;
import java.util.Arrays;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Trace f14304a;

    c(Trace trace) {
        this.f14304a = trace;
    }

    /* access modifiers changed from: package-private */
    public final zzda a() {
        zzda.zzb zzal = zzda.zzfu().zzae(this.f14304a.a()).zzak(this.f14304a.c().zzcr()).zzal(this.f14304a.c().zza(this.f14304a.d()));
        for (zza next : this.f14304a.b().values()) {
            zzal.zzd(next.a(), next.b());
        }
        List<Trace> e2 = this.f14304a.e();
        if (!e2.isEmpty()) {
            for (Trace cVar : e2) {
                zzal.zzg(new c(cVar).a());
            }
        }
        zzal.zzf(this.f14304a.getAttributes());
        zzcr[] a2 = zzq.a(this.f14304a.f());
        if (a2 != null) {
            zzal.zzf((Iterable<? extends zzcr>) Arrays.asList(a2));
        }
        return (zzda) ((zzep) zzal.zzhr());
    }
}
