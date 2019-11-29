package com.shopee.app.d.c;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.an;
import com.shopee.app.util.n;
import java.util.HashMap;
import java.util.List;

public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    private final at f17039c;

    /* renamed from: d  reason: collision with root package name */
    private OrderKey f17040d;

    /* access modifiers changed from: protected */
    public String d() {
        return "ClearOrderBadgeInteractor";
    }

    protected h(n nVar, at atVar) {
        super(nVar);
        this.f17039c = atVar;
    }

    public void a(OrderKey orderKey) {
        this.f17040d = orderKey;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<Long> a2 = this.f17039c.a(this.f17040d);
        a2.clear();
        this.f17039c.a(this.f17040d, a2);
        List<Integer> list = an.f26158a;
        HashMap hashMap = new HashMap();
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            hashMap.put(Integer.valueOf(intValue2), Integer.valueOf(this.f17039c.a(new OrderKey(this.f17040d.uType, intValue2)).size()));
        }
        b.a("ORDER_UPDATE_NOTIFICATION", new a(new Pair(Integer.valueOf(this.f17040d.uType), hashMap)), b.a.NETWORK_BUS);
    }
}
