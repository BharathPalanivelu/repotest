package com.shopee.app.d.b.a.a.b;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16025c;

    public String b() {
        return null;
    }

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16025c = orderDetail;
    }

    public long a() {
        return this.f16025c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_label_rate), 0, new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f15981b.a("ORDER_BUYER_RATE", new com.garena.android.appkit.b.a(b.this.f16025c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_completed);
    }

    public String k() {
        return a((int) R.string.action_buyer_not_rated_logic_detail_text);
    }
}
