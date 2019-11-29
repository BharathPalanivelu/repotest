package com.google.android.libraries.places.internal;

import java.util.Comparator;

final class ke implements Comparator<kc> {
    ke() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        kc kcVar = (kc) obj;
        kc kcVar2 = (kc) obj2;
        ki kiVar = (ki) kcVar.iterator();
        ki kiVar2 = (ki) kcVar2.iterator();
        while (kiVar.hasNext() && kiVar2.hasNext()) {
            int compare = Integer.compare(kc.a(kiVar.a()), kc.a(kiVar2.a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(kcVar.a(), kcVar2.a());
    }
}
