package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.j;
import com.google.zxing.q;
import com.google.zxing.v;
import com.google.zxing.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class p extends q {

    /* renamed from: a  reason: collision with root package name */
    private final x[] f14617a;

    public p(Map<j, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(j.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(c.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(c.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(c.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(c.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.f14617a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    public w a(int i, a aVar, Map<j, ?> map) throws q {
        Collection collection;
        int[] a2 = x.a(aVar);
        x[] xVarArr = this.f14617a;
        boolean z = false;
        int i2 = 0;
        while (i2 < xVarArr.length) {
            try {
                w a3 = xVarArr[i2].a(i, aVar, a2, map);
                boolean z2 = a3.d() == c.EAN_13 && a3.a().charAt(0) == '0';
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(j.POSSIBLE_FORMATS);
                }
                if (collection == null || collection.contains(c.UPC_A)) {
                    z = true;
                }
                if (!z2 || !z) {
                    return a3;
                }
                w wVar = new w(a3.a().substring(1), a3.b(), a3.c(), c.UPC_A);
                wVar.a(a3.e());
                return wVar;
            } catch (v unused) {
                i2++;
            }
        }
        throw q.a();
    }

    public void a() {
        for (x a2 : this.f14617a) {
            a2.a();
        }
    }
}
