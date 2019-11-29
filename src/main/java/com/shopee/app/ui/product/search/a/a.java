package com.shopee.app.ui.product.search.a;

import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.tracking.ImpressionObserver;
import com.shopee.app.ui.a.v;
import com.shopee.app.ui.product.search.n;
import java.util.List;

public class a extends v<SearchProductItem> {

    /* renamed from: b  reason: collision with root package name */
    private int f24785b;

    public a(n nVar, ImpressionObserver impressionObserver) {
        super(nVar, impressionObserver);
    }

    public List<SearchProductItem> a() {
        return this.f19176a;
    }

    public void a(List<SearchProductItem> list) {
        super.a(list);
        c();
    }

    public int b() {
        return this.f24785b;
    }

    private void c() {
        this.f24785b = 0;
        if (this.f19176a != null && this.f19176a.size() != 0) {
            for (int i = 0; i < this.f19176a.size(); i++) {
                if (10 == ((SearchProductItem) this.f19176a.get(i)).getType()) {
                    this.f24785b = i;
                    return;
                }
            }
        }
    }
}
