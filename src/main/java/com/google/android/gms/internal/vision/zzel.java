package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.List;

final class zzel<E> extends zzbi<E> {
    private static final zzel<Object> zzoa;
    private final List<E> zzmn;

    static {
        zzel<Object> zzel = new zzel<>();
        zzoa = zzel;
        zzel.zzao();
    }

    zzel() {
        this(new ArrayList(10));
    }

    private zzel(List<E> list) {
        this.zzmn = list;
    }

    public static <E> zzel<E> zzdd() {
        return zzoa;
    }

    public final void add(int i, E e2) {
        zzap();
        this.zzmn.add(i, e2);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzmn.get(i);
    }

    public final E remove(int i) {
        zzap();
        E remove = this.zzmn.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e2) {
        zzap();
        E e3 = this.zzmn.set(i, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.zzmn.size();
    }

    public final /* synthetic */ zzcw zzk(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzmn);
            return new zzel(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
