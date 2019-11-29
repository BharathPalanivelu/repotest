package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzee extends zzch<String> implements zzeh, RandomAccess {
    private static final zzee zzll;
    private static final zzeh zzlm = zzll;
    private final List<Object> zzln;

    public zzee() {
        this(10);
    }

    public zzee(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzee(ArrayList<Object> arrayList) {
        this.zzln = arrayList;
    }

    public final int size() {
        return this.zzln.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzai();
        if (collection instanceof zzeh) {
            collection = ((zzeh) collection).zzcd();
        }
        boolean addAll = this.zzln.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzai();
        this.zzln.clear();
        this.modCount++;
    }

    public final void zzc(zzcl zzcl) {
        zzai();
        this.zzln.add(zzcl);
        this.modCount++;
    }

    public final Object zzad(int i) {
        return this.zzln.get(i);
    }

    private static String zzh(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzcl) {
            return ((zzcl) obj).zzak();
        }
        return zzdq.zze((byte[]) obj);
    }

    public final List<?> zzcd() {
        return Collections.unmodifiableList(this.zzln);
    }

    public final zzeh zzce() {
        return zzag() ? new zzgh(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzai();
        return zzh(this.zzln.set(i, (String) obj));
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
        zzai();
        Object remove = this.zzln.remove(i);
        this.modCount++;
        return zzh(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzag() {
        return super.zzag();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzai();
        this.zzln.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzdx zzj(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzln);
            return new zzee((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzln.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzcl) {
            zzcl zzcl = (zzcl) obj;
            String zzak = zzcl.zzak();
            if (zzcl.zzal()) {
                this.zzln.set(i, zzak);
            }
            return zzak;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzdq.zze(bArr);
        if (zzdq.zzd(bArr)) {
            this.zzln.set(i, zze);
        }
        return zze;
    }

    static {
        zzee zzee = new zzee();
        zzll = zzee;
        zzee.zzah();
    }
}
