package com.shopee.app.ui.order.search;

import com.shopee.app.d.c.a;
import com.shopee.app.network.d.an;
import com.shopee.app.util.n;
import java.util.List;

public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f23804c;

    /* renamed from: d  reason: collision with root package name */
    private int f23805d;

    /* renamed from: e  reason: collision with root package name */
    private String f23806e;

    /* renamed from: f  reason: collision with root package name */
    private int f23807f;

    /* renamed from: g  reason: collision with root package name */
    private int f23808g;
    private int h;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetSearchShopCustomerInteractor";
    }

    protected d(n nVar) {
        super(nVar);
    }

    public void a(List<Integer> list, int i, String str, int i2, int i3, int i4) {
        this.f23804c = list;
        this.f23805d = i;
        this.f23806e = str;
        this.f23807f = i2;
        this.f23808g = i3;
        this.h = i4;
        c();
    }

    /* access modifiers changed from: protected */
    public void c() {
        new an(this.f23804c, this.f23805d, this.f23806e, this.f23807f, this.f23808g, this.h).g();
    }
}
