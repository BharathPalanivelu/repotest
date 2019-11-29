package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhk  reason: invalid package */
public final class zzhk extends AbstractList<String> implements zzfh, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfh zzuv;

    public zzhk(zzfh zzfh) {
        this.zzuv = zzfh;
    }

    public final zzfh zzhy() {
        return this;
    }

    public final Object getRaw(int i) {
        return this.zzuv.getRaw(i);
    }

    public final int size() {
        return this.zzuv.size();
    }

    public final void zzc(zzdl zzdl) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzhj(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzhm(this);
    }

    public final List<?> zzhx() {
        return this.zzuv.zzhx();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzuv.get(i);
    }
}
