package com.google.zxing;

import com.google.zxing.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class o implements u {

    /* renamed from: a  reason: collision with root package name */
    private Map<j, ?> f14773a;

    /* renamed from: b  reason: collision with root package name */
    private u[] f14774b;

    public w a(e eVar, Map<j, ?> map) throws q {
        a(map);
        return b(eVar);
    }

    public w a(e eVar) throws q {
        if (this.f14774b == null) {
            a((Map<j, ?>) null);
        }
        return b(eVar);
    }

    public void a(Map<j, ?> map) {
        Collection collection;
        this.f14773a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(j.TRY_HARDER);
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(j.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(c.UPC_A) && !collection.contains(c.UPC_E) && !collection.contains(c.EAN_13) && !collection.contains(c.EAN_8) && !collection.contains(c.CODABAR) && !collection.contains(c.CODE_39) && !collection.contains(c.CODE_93) && !collection.contains(c.CODE_128) && !collection.contains(c.ITF) && !collection.contains(c.RSS_14) && !collection.contains(c.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new com.google.zxing.d.o(map));
            }
            if (collection.contains(c.QR_CODE)) {
                arrayList.add(new a());
            }
            if (z && z2) {
                arrayList.add(new com.google.zxing.d.o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new com.google.zxing.d.o(map));
            }
            arrayList.add(new a());
            if (z2) {
                arrayList.add(new com.google.zxing.d.o(map));
            }
        }
        this.f14774b = (u[]) arrayList.toArray(new u[arrayList.size()]);
    }

    public void a() {
        u[] uVarArr = this.f14774b;
        if (uVarArr != null) {
            for (u a2 : uVarArr) {
                a2.a();
            }
        }
    }

    private w b(e eVar) throws q {
        u[] uVarArr = this.f14774b;
        if (uVarArr != null) {
            int length = uVarArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return uVarArr[i].a(eVar, this.f14773a);
                } catch (v unused) {
                    i++;
                }
            }
        }
        throw q.a();
    }
}
