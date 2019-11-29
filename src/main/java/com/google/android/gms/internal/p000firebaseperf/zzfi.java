package com.google.android.gms.internal.p000firebaseperf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfi  reason: invalid package */
public final class zzfi extends zzdk<String> implements zzfh, RandomAccess {
    private static final zzfi zzsf;
    private static final zzfh zzsg = zzsf;
    private final List<Object> zzsh;

    public zzfi() {
        this(10);
    }

    public zzfi(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzfi(ArrayList<Object> arrayList) {
        this.zzsh = arrayList;
    }

    public final int size() {
        return this.zzsh.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzgg();
        if (collection instanceof zzfh) {
            collection = ((zzfh) collection).zzhx();
        }
        boolean addAll = this.zzsh.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzgg();
        this.zzsh.clear();
        this.modCount++;
    }

    public final void zzc(zzdl zzdl) {
        zzgg();
        this.zzsh.add(zzdl);
        this.modCount++;
    }

    public final Object getRaw(int i) {
        return this.zzsh.get(i);
    }

    private static String zzg(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdl) {
            return ((zzdl) obj).zzgh();
        }
        return zzer.zze((byte[]) obj);
    }

    public final List<?> zzhx() {
        return Collections.unmodifiableList(this.zzsh);
    }

    public final zzfh zzhy() {
        return zzge() ? new zzhk(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzgg();
        return zzg(this.zzsh.set(i, (String) obj));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgg();
        Object remove = this.zzsh.remove(i);
        this.modCount++;
        return zzg(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzge() {
        return super.zzge();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzgg();
        this.zzsh.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzex zzao(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzsh);
            return new zzfi((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzsh.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdl) {
            zzdl zzdl = (zzdl) obj;
            String zzgh = zzdl.zzgh();
            if (zzdl.zzgi()) {
                this.zzsh.set(i, zzgh);
            }
            return zzgh;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzer.zze(bArr);
        if (zzer.zzd(bArr)) {
            this.zzsh.set(i, zze);
        }
        return zze;
    }

    static {
        zzfi zzfi = new zzfi();
        zzsf = zzfi;
        zzfi.zzgf();
    }
}
