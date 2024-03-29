package com.google.maps.android.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class a<K> extends HashMap<K, Object> {
    private final Map<Object, K> mValuesToKeys = new HashMap();

    public void putAll(Map<? extends K, ?> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Object put(K k, Object obj) {
        this.mValuesToKeys.put(obj, k);
        return super.put(k, obj);
    }

    public Object remove(Object obj) {
        Object remove = super.remove(obj);
        if (remove instanceof Collection) {
            for (Object remove2 : (Collection) remove) {
                this.mValuesToKeys.remove(remove2);
            }
        } else {
            this.mValuesToKeys.remove(remove);
        }
        return remove;
    }

    public void clear() {
        super.clear();
        this.mValuesToKeys.clear();
    }

    /* renamed from: a */
    public a<K> clone() {
        a<K> aVar = new a<>();
        aVar.putAll((Map) super.clone());
        return aVar;
    }
}
