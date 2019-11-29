package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.util.ad;
import java.util.HashMap;
import java.util.Map;

public class x extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<Map<Integer, Integer>> f17332a = new ad<>(this.mPref, "customer_order_count", ServiceLogger.PLACEHOLDER, new a<Map<Integer, Integer>>() {
    });

    /* renamed from: b  reason: collision with root package name */
    private ad<Map<Integer, Integer>> f17333b = new ad<>(this.mPref, "customer_offer_count", ServiceLogger.PLACEHOLDER, new a<Map<Integer, Integer>>() {
    });

    public x(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public Map<Integer, Integer> a() {
        Map<Integer, Integer> a2 = this.f17332a.a();
        return a2 == null ? new HashMap() : a2;
    }

    public void a(Map<Integer, Integer> map) {
        this.f17332a.a(map);
    }

    public void a(int i, int i2) {
        Map a2 = this.f17333b.a();
        a2.put(Integer.valueOf(i), Integer.valueOf(i2));
        this.f17333b.a(a2);
    }

    public int a(int i) {
        Map a2 = this.f17333b.a();
        if (a2.containsKey(Integer.valueOf(i))) {
            return ((Integer) a2.get(Integer.valueOf(i))).intValue();
        }
        return 0;
    }
}
