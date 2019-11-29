package com.shopee.app.util.j;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.util.ad;
import java.util.Map;

public class c<K, T> extends ad<Map<K, T>> {
    public c(SharedPreferences sharedPreferences, String str, a aVar) {
        super(sharedPreferences, str, ServiceLogger.PLACEHOLDER, aVar);
    }

    public T b(K k) {
        return ((Map) super.a()).get(k);
    }

    public void a(K k, T t) {
        Map map = (Map) super.a();
        map.put(k, t);
        super.a(map);
    }
}
