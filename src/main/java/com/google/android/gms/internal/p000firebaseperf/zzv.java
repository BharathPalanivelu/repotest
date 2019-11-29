package com.google.android.gms.internal.p000firebaseperf;

import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzv  reason: invalid package */
public abstract class zzv<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzt = new Map.Entry[0];
    private transient zzx<Map.Entry<K, V>> zzu;
    private transient zzx<K> zzv;
    private transient zzq<V> zzw;

    public static <K, V> zzv<K, V> zzj() {
        return zzz.zzab;
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzx<Map.Entry<K, V>> zzk();

    /* access modifiers changed from: package-private */
    public abstract zzx<K> zzl();

    /* access modifiers changed from: package-private */
    public abstract zzq<V> zzm();

    /* access modifiers changed from: package-private */
    public abstract boolean zzn();

    public static <K, V> zzv<K, V> zza(Map<? extends K, ? extends V> map) {
        if (!(map instanceof zzv) || (map instanceof SortedMap)) {
            Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            zzy zzy = new zzy(entrySet instanceof Collection ? entrySet.size() : 4);
            zzy.zza(entrySet);
            return zzy.zzp();
        }
        zzv<K, V> zzv2 = (zzv) map;
        zzv2.zzn();
        return zzv2;
    }

    zzv() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzq) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzag.zza((zzx) entrySet());
    }

    public String toString() {
        int size = size();
        zzo.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, IjkMediaMeta.AV_CH_STEREO_RIGHT));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ Set entrySet() {
        zzx<Map.Entry<K, V>> zzx = this.zzu;
        if (zzx != null) {
            return zzx;
        }
        zzx<Map.Entry<K, V>> zzk = zzk();
        this.zzu = zzk;
        return zzk;
    }

    public /* synthetic */ Collection values() {
        zzq<V> zzq = this.zzw;
        if (zzq != null) {
            return zzq;
        }
        zzq<V> zzm = zzm();
        this.zzw = zzm;
        return zzm;
    }

    public /* synthetic */ Set keySet() {
        zzx<K> zzx = this.zzv;
        if (zzx != null) {
            return zzx;
        }
        zzx<K> zzl = zzl();
        this.zzv = zzl;
        return zzl;
    }
}
