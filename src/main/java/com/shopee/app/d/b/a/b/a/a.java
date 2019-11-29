package com.shopee.app.d.b.a.b.a;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16172c;

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16172c = orderDetail;
    }

    public long a() {
        return this.f16172c.getOrderId();
    }

    public String b() {
        if (this.f16172c.getShipByDate() <= 0) {
            return "";
        }
        return b.a(R.string.order_list_response_cancellation, 123456);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(a.this.f16172c));
            }
        });
    }

    public String j() {
        return a((int) R.string.order_list_cancellation_requested);
    }
}
