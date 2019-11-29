package com.shopee.app.d.b.a.d;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class g extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16351c;

    public g(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16351c = orderDetail;
    }

    public long a() {
        return this.f16351c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_view_shop_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("ORDER_SELLER_VIEW_RATE", new com.garena.android.appkit.b.a(g.this.f16351c));
            }
        });
    }

    public a.C0251a e() {
        return new a.C0251a(a((int) R.string.sp_view_buyer_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("ORDER_BUYER_VIEW_RATE", new com.garena.android.appkit.b.a(g.this.f16351c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        return a((int) R.string.sp_thanks_4_rating);
    }
}
