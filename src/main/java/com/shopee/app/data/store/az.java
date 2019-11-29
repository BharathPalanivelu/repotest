package com.shopee.app.data.store;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.util.ad;
import com.shopee.app.util.j.b;
import com.shopee.protocol.action.ShopItemId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class az extends ay {

    /* renamed from: a  reason: collision with root package name */
    private final String f17209a = "recent_";

    /* renamed from: b  reason: collision with root package name */
    private final String f17210b = "shop_";

    /* renamed from: c  reason: collision with root package name */
    private final String f17211c = "incart_";

    /* renamed from: d  reason: collision with root package name */
    private ad<Map<String, List<ShopItemId>>> f17212d = new ad<>(this.mPref, "product_list_obj_store", ServiceLogger.PLACEHOLDER, new a<Map<String, List<ShopItemId>>>() {
    });

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.app.util.j.a<String, List<ShopItemId>> f17213e = new com.shopee.app.util.j.a<>(this.mPref, 60, "chat_list_obj_store", new a<Map<String, List<ShopItemId>>>() {
    });

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.util.j.a<String, List<Long>> f17214f = new com.shopee.app.util.j.a<>(this.mPref, 60, "offer_list_obj_store", new a<Map<String, List<Long>>>() {
    });

    /* renamed from: g  reason: collision with root package name */
    private b<Long> f17215g = new b<>(this.mPref, "offer_in_cart_list_obj_store", new a<List<Long>>() {
    });

    public az(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
    }

    public void a(int i, List<ShopItemId> list) {
        this.f17213e.a(String.valueOf(i), list);
    }

    public List<ShopItemId> a(int i) {
        List<ShopItemId> b2 = this.f17213e.b(String.valueOf(i));
        return b2 == null ? new ArrayList() : b2;
    }

    public void a(List<Long> list) {
        this.f17215g.a(list);
    }

    public List<Long> a() {
        List<Long> list = (List) this.f17215g.a();
        return list == null ? new ArrayList() : list;
    }

    public void a(int i, boolean z, List<Long> list) {
        com.shopee.app.util.j.a<String, List<Long>> aVar = this.f17214f;
        aVar.a(i + "" + z, list);
    }

    public List<Long> a(int i, boolean z) {
        com.shopee.app.util.j.a<String, List<Long>> aVar = this.f17214f;
        List<Long> b2 = aVar.b(i + "" + z);
        return b2 == null ? new ArrayList() : b2;
    }

    public void b(int i, List<ShopItemId> list) {
        Map a2 = this.f17212d.a();
        a2.put(a("shop_", i), new ArrayList(list));
        this.f17212d.a(a2);
    }

    public List<ShopItemId> b(int i) {
        List<ShopItemId> list = (List) this.f17212d.a().get(a("shop_", i));
        return list == null ? new ArrayList() : list;
    }

    public void c(int i, List<ShopItemId> list) {
        Map a2 = this.f17212d.a();
        a2.put(a("recent_", i), new ArrayList(list));
        this.f17212d.a(a2);
    }

    public List<ShopItemId> c(int i) {
        List<ShopItemId> list = (List) this.f17212d.a().get(a("recent_", i));
        return list == null ? new ArrayList() : list;
    }

    public void d(int i, List<ShopItemId> list) {
        Map a2 = this.f17212d.a();
        a2.put(a("incart_", i), new ArrayList(list));
        this.f17212d.a(a2);
    }

    private String a(String str, int i) {
        return str + i;
    }
}
