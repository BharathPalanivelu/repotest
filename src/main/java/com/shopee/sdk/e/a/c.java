package com.shopee.sdk.e.a;

import android.content.SharedPreferences;
import com.shopee.sdk.f.a;
import java.util.Map;

public class c<K, T> extends d<Map<K, T>> {
    public c(SharedPreferences sharedPreferences, String str, Class<K> cls, Class<T> cls2) {
        super(sharedPreferences, str, a.f30358b, (com.google.a.c.a) com.google.a.c.a.getParameterized(Map.class, cls, cls2));
    }

    public T a(K k) {
        return ((Map) super.c()).get(k);
    }

    public void a(K k, T t) {
        Map map = (Map) super.c();
        map.put(k, t);
        super.b(map);
    }
}
