package com.shopee.app.d.b.a.d;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class o extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16393c;

    public o(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16393c = orderDetail;
    }

    public long a() {
        return this.f16393c.getOrderId();
    }

    public String b() {
        return a((int) R.string.sp_no_rating);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_view_buyer_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                o.this.f15981b.a("ORDER_BUYER_VIEW_RATE", new com.garena.android.appkit.b.a(o.this.f16393c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_tab_seller_completed);
    }

    public String k() {
        return a((int) R.string.sp_order_completed);
    }
}
