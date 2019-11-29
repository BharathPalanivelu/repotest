package com.shopee.sdk.e;

import android.content.SharedPreferences;
import java.util.Map;

public class a<T> extends b {
    private com.shopee.sdk.e.a.a<String, T> cache;

    public a(SharedPreferences sharedPreferences, int i, Class<T> cls) {
        super(sharedPreferences);
        this.cache = new com.shopee.sdk.e.a.a(sharedPreferences, i, "cache", String.class, cls);
    }

    public void put(String str, T t) {
        this.cache.a(str, t);
    }

    public T get(String str) {
        return this.cache.a(str);
    }

    public Map<String, T> snapshot() {
        return this.cache.b();
    }
}
