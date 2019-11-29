package com.google.android.gms.internal.gtm;

import java.util.Iterator;

final class zzob implements Iterator<zzoa<?>> {
    private final /* synthetic */ Iterator zzaue;

    zzob(zzoa zzoa, Iterator it) {
        this.zzaue = it;
    }

    public final boolean hasNext() {
        return this.zzaue.hasNext();
    }

    public final void remove() {
        this.zzaue.remove();
    }

    public final /* synthetic */ Object next() {
        return new zzom((String) this.zzaue.next());
    }
}
