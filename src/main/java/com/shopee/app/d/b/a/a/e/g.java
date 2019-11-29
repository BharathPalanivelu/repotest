package com.shopee.app.d.b.a.a.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class g extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16100c;

    public g(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16100c = orderDetail;
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.order_list_cancellation_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("ORDER_GOTO_REQUESTED_CANCEL_DETAIL", new com.garena.android.appkit.b.a(g.this.f16100c));
            }
        });
    }

    public String b() {
        return b.e(R.string.to_ship_cancel_requested);
    }

    public String j() {
        return a((int) R.string.order_list_cancellation_requested);
    }
}
