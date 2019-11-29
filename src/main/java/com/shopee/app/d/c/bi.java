package com.shopee.app.d.c;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.an;
import com.shopee.app.util.n;
import java.util.HashMap;
import java.util.List;

public class bi extends a {

    /* renamed from: c  reason: collision with root package name */
    private final at f16583c;

    /* renamed from: d  reason: collision with root package name */
    private int f16584d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetOrderBadgeInteractor";
    }

    protected bi(n nVar, at atVar) {
        super(nVar);
        this.f16583c = atVar;
    }

    public void a(int i) {
        this.f16584d = i;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<Integer> list = an.f26158a;
        HashMap hashMap = new HashMap();
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            hashMap.put(Integer.valueOf(intValue2), Integer.valueOf(this.f16583c.a(new OrderKey(this.f16584d, intValue2)).size()));
        }
        this.f16402a.a("ORDER_BADGE_LOAD", new a(new Pair(Integer.valueOf(this.f16584d), hashMap)));
    }
}
