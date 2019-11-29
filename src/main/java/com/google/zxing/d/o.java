package com.google.zxing.d;

import com.google.zxing.c;
import com.google.zxing.c.a;
import com.google.zxing.d.a.a.d;
import com.google.zxing.d.a.e;
import com.google.zxing.j;
import com.google.zxing.q;
import com.google.zxing.v;
import com.google.zxing.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class o extends q {

    /* renamed from: a  reason: collision with root package name */
    private final q[] f14616a;

    public o(Map<j, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(j.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(j.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(c.EAN_13) || collection.contains(c.UPC_A) || collection.contains(c.EAN_8) || collection.contains(c.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(c.CODE_39)) {
                arrayList.add(new e(z));
            }
            if (collection.contains(c.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(c.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(c.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(c.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(c.RSS_14)) {
                arrayList.add(new e());
            }
            if (collection.contains(c.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new e());
            arrayList.add(new d());
        }
        this.f14616a = (q[]) arrayList.toArray(new q[arrayList.size()]);
    }

    public w a(int i, a aVar, Map<j, ?> map) throws q {
        q[] qVarArr = this.f14616a;
        int i2 = 0;
        while (i2 < qVarArr.length) {
            try {
                return qVarArr[i2].a(i, aVar, map);
            } catch (v unused) {
                i2++;
            }
        }
        throw q.a();
    }

    public void a() {
        for (q a2 : this.f14616a) {
            a2.a();
        }
    }
}
