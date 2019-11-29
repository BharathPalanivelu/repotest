package com.google.android.gms.internal.p000firebaseperf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgs  reason: invalid package */
class zzgs<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zznu;
    private final int zzuc;
    /* access modifiers changed from: private */
    public List<zzgx> zzud;
    /* access modifiers changed from: private */
    public Map<K, V> zzue;
    private volatile zzgz zzuf;
    /* access modifiers changed from: private */
    public Map<K, V> zzug;
    private volatile zzgt zzuh;

    static <FieldDescriptorType extends zzem<FieldDescriptorType>> zzgs<FieldDescriptorType, Object> zzat(int i) {
        return new zzgr(i);
    }

    private zzgs(int i) {
        this.zzuc = i;
        this.zzud = Collections.emptyList();
        this.zzue = Collections.emptyMap();
        this.zzug = Collections.emptyMap();
    }

    public void zzgf() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zznu) {
            if (this.zzue.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzue);
            }
            this.zzue = map;
            if (this.zzug.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzug);
            }
            this.zzug = map2;
            this.zznu = true;
        }
    }

    public final boolean isImmutable() {
        return this.zznu;
    }

    public final int zziz() {
        return this.zzud.size();
    }

    public final Map.Entry<K, V> zzau(int i) {
        return this.zzud.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzja() {
        if (this.zzue.isEmpty()) {
            return zzgw.zzjf();
        }
        return this.zzue.entrySet();
    }

    public int size() {
        return this.zzud.size() + this.zzue.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzue.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzud.get(zza).getValue();
        }
        return this.zzue.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzjc();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzud.get(zza).setValue(v);
        }
        zzjc();
        if (this.zzud.isEmpty() && !(this.zzud instanceof ArrayList)) {
            this.zzud = new ArrayList(this.zzuc);
        }
        int i = -(zza + 1);
        if (i >= this.zzuc) {
            return zzjd().put(k, v);
        }
        int size = this.zzud.size();
        int i2 = this.zzuc;
        if (size == i2) {
            zzgx remove = this.zzud.remove(i2 - 1);
            zzjd().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzud.add(i, new zzgx(this, k, v));
        return null;
    }

    public void clear() {
        zzjc();
        if (!this.zzud.isEmpty()) {
            this.zzud.clear();
        }
        if (!this.zzue.isEmpty()) {
            this.zzue.clear();
        }
    }

    public V remove(Object obj) {
        zzjc();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzav(zza);
        }
        if (this.zzue.isEmpty()) {
            return null;
        }
        return this.zzue.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzav(int i) {
        zzjc();
        V value = this.zzud.remove(i).getValue();
        if (!this.zzue.isEmpty()) {
            Iterator it = zzjd().entrySet().iterator();
            this.zzud.add(new zzgx(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzud.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzud.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzud.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzuf == null) {
            this.zzuf = new zzgz(this, (zzgr) null);
        }
        return this.zzuf;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzjb() {
        if (this.zzuh == null) {
            this.zzuh = new zzgt(this, (zzgr) null);
        }
        return this.zzuh;
    }

    /* access modifiers changed from: private */
    public final void zzjc() {
        if (this.zznu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzjd() {
        zzjc();
        if (this.zzue.isEmpty() && !(this.zzue instanceof TreeMap)) {
            this.zzue = new TreeMap();
            this.zzug = ((TreeMap) this.zzue).descendingMap();
        }
        return (SortedMap) this.zzue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return super.equals(obj);
        }
        zzgs zzgs = (zzgs) obj;
        int size = size();
        if (size != zzgs.size()) {
            return false;
        }
        int zziz = zziz();
        if (zziz != zzgs.zziz()) {
            return entrySet().equals(zzgs.entrySet());
        }
        for (int i = 0; i < zziz; i++) {
            if (!zzau(i).equals(zzgs.zzau(i))) {
                return false;
            }
        }
        if (zziz != size) {
            return this.zzue.equals(zzgs.zzue);
        }
        return true;
    }

    public int hashCode() {
        int zziz = zziz();
        int i = 0;
        for (int i2 = 0; i2 < zziz; i2++) {
            i += this.zzud.get(i2).hashCode();
        }
        return this.zzue.size() > 0 ? i + this.zzue.hashCode() : i;
    }

    /* synthetic */ zzgs(int i, zzgr zzgr) {
        this(i);
    }
}
