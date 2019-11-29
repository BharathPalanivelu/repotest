package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzac  reason: invalid package */
final class zzac<K, V> extends zzx<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzv<K, V> zzag;
    private final transient int zzah = 0;
    /* access modifiers changed from: private */
    public final transient Object[] zzz;

    zzac(zzv<K, V> zzv, Object[] objArr, int i, int i2) {
        this.zzag = zzv;
        this.zzz = objArr;
        this.size = i2;
    }

    public final zzaf<Map.Entry<K, V>> zzb() {
        return (zzaf) zzf().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzf().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzr<Map.Entry<K, V>> zzo() {
        return new zzab(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzag.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
