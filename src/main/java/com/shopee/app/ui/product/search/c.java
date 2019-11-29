package com.shopee.app.ui.product.search;

import com.garena.android.appkit.b.a;
import com.google.a.o;
import com.shopee.app.data.viewmodel.SearchProductItem;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f24819a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f24820b;

    /* renamed from: c  reason: collision with root package name */
    public int f24821c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final o f24822d;

    public c(int i, SearchProductItem searchProductItem, String str, o oVar) {
        this.f24820b = i;
        this.f24819a = str;
        this.f24822d = oVar;
        this.data = searchProductItem;
    }

    public c(int i, SearchProductItem searchProductItem, int i2, o oVar) {
        this.f24820b = i;
        this.f24821c = i2;
        this.f24822d = oVar;
        this.data = searchProductItem;
    }

    public String a() {
        o oVar = this.f24822d;
        return oVar != null ? oVar.toString() : "";
    }
}
