package com.google.android.gms.internal.p000firebaseperf;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhj  reason: invalid package */
final class zzhj implements ListIterator<String> {
    private ListIterator<String> zzus = this.zzuu.zzuv.listIterator(this.zzut);
    private final /* synthetic */ int zzut;
    private final /* synthetic */ zzhk zzuu;

    zzhj(zzhk zzhk, int i) {
        this.zzuu = zzhk;
        this.zzut = i;
    }

    public final boolean hasNext() {
        return this.zzus.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzus.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzus.nextIndex();
    }

    public final int previousIndex() {
        return this.zzus.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzus.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzus.next();
    }
}
