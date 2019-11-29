package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzgh extends AbstractList<String> implements zzeh, RandomAccess {
    /* access modifiers changed from: private */
    public final zzeh zzoa;

    public zzgh(zzeh zzeh) {
        this.zzoa = zzeh;
    }

    public final zzeh zzce() {
        return this;
    }

    public final Object zzad(int i) {
        return this.zzoa.zzad(i);
    }

    public final int size() {
        return this.zzoa.size();
    }

    public final void zzc(zzcl zzcl) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzgg(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzgj(this);
    }

    public final List<?> zzcd() {
        return this.zzoa.zzcd();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzoa.get(i);
    }
}
