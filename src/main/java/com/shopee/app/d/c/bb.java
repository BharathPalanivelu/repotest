package com.shopee.app.d.c;

import com.garena.android.appkit.b.a;
import com.shopee.app.data.store.at;
import com.shopee.app.data.viewmodel.OrderKey;
import com.shopee.app.util.an;
import com.shopee.app.util.n;
import java.util.List;

public class bb extends a {

    /* renamed from: c  reason: collision with root package name */
    private final at f16551c;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetMeBadgeLoadInteractor";
    }

    public bb(n nVar, at atVar) {
        super(nVar);
        this.f16551c = atVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        List<Integer> list = an.f26158a;
        int[] iArr = new int[2];
        int i = 0;
        int i2 = 0;
        for (Integer intValue : list) {
            i2 += this.f16551c.a(new OrderKey(false, intValue.intValue())).size();
        }
        iArr[0] = i2;
        for (Integer intValue2 : list) {
            i += this.f16551c.a(new OrderKey(true, intValue2.intValue())).size();
        }
        iArr[1] = i;
        this.f16402a.a("ME_BADGE_LOAD", new a(iArr));
    }
}
