package com.google.android.gms.internal.icing;

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

class zzfp<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzhc;
    private final int zznh;
    /* access modifiers changed from: private */
    public List<zzfu> zzni;
    /* access modifiers changed from: private */
    public Map<K, V> zznj;
    private volatile zzfw zznk;
    /* access modifiers changed from: private */
    public Map<K, V> zznl;
    private volatile zzfq zznm;

    static <FieldDescriptorType extends zzdl<FieldDescriptorType>> zzfp<FieldDescriptorType, Object> zzai(int i) {
        return new zzfo(i);
    }

    private zzfp(int i) {
        this.zznh = i;
        this.zzni = Collections.emptyList();
        this.zznj = Collections.emptyMap();
        this.zznl = Collections.emptyMap();
    }

    public void zzah() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzhc) {
            if (this.zznj.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zznj);
            }
            this.zznj = map;
            if (this.zznl.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zznl);
            }
            this.zznl = map2;
            this.zzhc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzhc;
    }

    public final int zzde() {
        return this.zzni.size();
    }

    public final Map.Entry<K, V> zzaj(int i) {
        return this.zzni.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzdf() {
        if (this.zznj.isEmpty()) {
            return zzft.zzdk();
        }
        return this.zznj.entrySet();
    }

    public int size() {
        return this.zzni.size() + this.zznj.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zznj.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return this.zzni.get(zza).getValue();
        }
        return this.zznj.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzdh();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzni.get(zza).setValue(v);
        }
        zzdh();
        if (this.zzni.isEmpty() && !(this.zzni instanceof ArrayList)) {
            this.zzni = new ArrayList(this.zznh);
        }
        int i = -(zza + 1);
        if (i >= this.zznh) {
            return zzdi().put(k, v);
        }
        int size = this.zzni.size();
        int i2 = this.zznh;
        if (size == i2) {
            zzfu remove = this.zzni.remove(i2 - 1);
            zzdi().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzni.add(i, new zzfu(this, k, v));
        return null;
    }

    public void clear() {
        zzdh();
        if (!this.zzni.isEmpty()) {
            this.zzni.clear();
        }
        if (!this.zznj.isEmpty()) {
            this.zznj.clear();
        }
    }

    public V remove(Object obj) {
        zzdh();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzak(zza);
        }
        if (this.zznj.isEmpty()) {
            return null;
        }
        return this.zznj.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzak(int i) {
        zzdh();
        V value = this.zzni.remove(i).getValue();
        if (!this.zznj.isEmpty()) {
            Iterator it = zzdi().entrySet().iterator();
            this.zzni.add(new zzfu(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzni.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzni.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.zzni.get(i2).getKey());
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
        if (this.zznk == null) {
            this.zznk = new zzfw(this, (zzfo) null);
        }
        return this.zznk;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzdg() {
        if (this.zznm == null) {
            this.zznm = new zzfq(this, (zzfo) null);
        }
        return this.zznm;
    }

    /* access modifiers changed from: private */
    public final void zzdh() {
        if (this.zzhc) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzdi() {
        zzdh();
        if (this.zznj.isEmpty() && !(this.zznj instanceof TreeMap)) {
            this.zznj = new TreeMap();
            this.zznl = ((TreeMap) this.zznj).descendingMap();
        }
        return (SortedMap) this.zznj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return super.equals(obj);
        }
        zzfp zzfp = (zzfp) obj;
        int size = size();
        if (size != zzfp.size()) {
            return false;
        }
        int zzde = zzde();
        if (zzde != zzfp.zzde()) {
            return entrySet().equals(zzfp.entrySet());
        }
        for (int i = 0; i < zzde; i++) {
            if (!zzaj(i).equals(zzfp.zzaj(i))) {
                return false;
            }
        }
        if (zzde != size) {
            return this.zznj.equals(zzfp.zznj);
        }
        return true;
    }

    public int hashCode() {
        int zzde = zzde();
        int i = 0;
        for (int i2 = 0; i2 < zzde; i2++) {
            i += this.zzni.get(i2).hashCode();
        }
        return this.zznj.size() > 0 ? i + this.zznj.hashCode() : i;
    }

    /* synthetic */ zzfp(int i, zzfo zzfo) {
        this(i);
    }
}
