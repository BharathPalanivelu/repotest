package com.shopee.app.d.b.a.d;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class r extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16399c;

    public r(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16399c = orderDetail;
    }

    public long a() {
        return this.f16399c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_view_buyer_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                r.this.f15981b.a("ORDER_BUYER_VIEW_RATE", new com.garena.android.appkit.b.a(r.this.f16399c));
            }
        });
    }

    public a.C0251a e() {
        return new a.C0251a(a((int) R.string.sp_view_shop_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                r.this.f15981b.a("ORDER_SELLER_VIEW_RATE", new com.garena.android.appkit.b.a(r.this.f16399c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        return a((int) R.string.sp_order_completed);
    }
}
