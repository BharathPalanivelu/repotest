package com.google.android.gms.internal.icing;

import java.util.ArrayList;
import java.util.List;

final class zzfi<E> extends zzch<E> {
    private static final zzfi<Object> zzmz;
    private final List<E> zzln;

    public static <E> zzfi<E> zzcv() {
        return zzmz;
    }

    zzfi() {
        this(new ArrayList(10));
    }

    private zzfi(List<E> list) {
        this.zzln = list;
    }

    public final void add(int i, E e2) {
        zzai();
        this.zzln.add(i, e2);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzln.get(i);
    }

    public final E remove(int i) {
        zzai();
        E remove = this.zzln.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e2) {
        zzai();
        E e3 = this.zzln.set(i, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.zzln.size();
    }

    public final /* synthetic */ zzdx zzj(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzln);
            return new zzfi(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzfi<Object> zzfi = new zzfi<>(new ArrayList(0));
        zzmz = zzfi;
        zzfi.zzah();
    }
}
