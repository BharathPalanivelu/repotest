package d.a;

import com.facebook.share.internal.ShareConstants;
import d.j;
import d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class ac extends ab {
    public static final <K, V> Map<K, V> a() {
        w wVar = w.f32652a;
        if (wVar != null) {
            return wVar;
        }
        throw new m("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <K, V> Map<K, V> a(j<? extends K, ? extends V>... jVarArr) {
        d.d.b.j.b(jVarArr, "pairs");
        return jVarArr.length > 0 ? z.a(jVarArr, new LinkedHashMap(z.a(jVarArr.length))) : z.a();
    }

    public static final <K, V> Map<K, V> b(j<? extends K, ? extends V>... jVarArr) {
        d.d.b.j.b(jVarArr, "pairs");
        Map<K, V> linkedHashMap = new LinkedHashMap<>(z.a(jVarArr.length));
        z.a(linkedHashMap, jVarArr);
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> c(j<? extends K, ? extends V>... jVarArr) {
        d.d.b.j.b(jVarArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(z.a(jVarArr.length));
        z.a(hashMap, jVarArr);
        return hashMap;
    }

    public static final int a(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return i + (i / 3);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, j<? extends K, ? extends V>[] jVarArr) {
        d.d.b.j.b(map, "$this$putAll");
        d.d.b.j.b(jVarArr, "pairs");
        for (j<? extends K, ? extends V> jVar : jVarArr) {
            map.put(jVar.c(), jVar.d());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(j<? extends K, ? extends V>[] jVarArr, M m) {
        d.d.b.j.b(jVarArr, "$this$toMap");
        d.d.b.j.b(m, ShareConstants.DESTINATION);
        z.a(m, jVarArr);
        return m;
    }
}
