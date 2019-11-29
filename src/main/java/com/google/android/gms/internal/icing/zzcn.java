package com.google.android.gms.internal.icing;

import java.util.Comparator;

final class zzcn implements Comparator<zzcl> {
    zzcn() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzcl zzcl = (zzcl) obj;
        zzcl zzcl2 = (zzcl) obj2;
        zzcq zzcq = (zzcq) zzcl.iterator();
        zzcq zzcq2 = (zzcq) zzcl2.iterator();
        while (zzcq.hasNext() && zzcq2.hasNext()) {
            int compare = Integer.compare(zzcl.zza(zzcq.nextByte()), zzcl.zza(zzcq2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzcl.size(), zzcl2.size());
    }
}
