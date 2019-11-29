package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzx  reason: invalid package */
public abstract class zzx<E> extends zzq<E> implements Set<E> {
    @NullableDecl
    private transient zzr<E> zzy;

    zzx() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzag.zza(this, obj);
    }

    public int hashCode() {
        return zzag.zza(this);
    }

    public zzr<E> zzf() {
        zzr<E> zzr = this.zzy;
        if (zzr != null) {
            return zzr;
        }
        zzr<E> zzo = zzo();
        this.zzy = zzo;
        return zzo;
    }

    /* access modifiers changed from: package-private */
    public zzr<E> zzo() {
        return zzr.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
