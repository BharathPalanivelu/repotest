package com.google.android.gms.internal.p000firebaseperf;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgl  reason: invalid package */
final class zzgl<E> extends zzdk<E> {
    private static final zzgl<Object> zztu;
    private final List<E> zzsh;

    public static <E> zzgl<E> zziq() {
        return zztu;
    }

    zzgl() {
        this(new ArrayList(10));
    }

    private zzgl(List<E> list) {
        this.zzsh = list;
    }

    public final void add(int i, E e2) {
        zzgg();
        this.zzsh.add(i, e2);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzsh.get(i);
    }

    public final E remove(int i) {
        zzgg();
        E remove = this.zzsh.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e2) {
        zzgg();
        E e3 = this.zzsh.set(i, e2);
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.zzsh.size();
    }

    public final /* synthetic */ zzex zzao(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzsh);
            return new zzgl(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzgl<Object> zzgl = new zzgl<>(new ArrayList(0));
        zztu = zzgl;
        zzgl.zzgf();
    }
}
