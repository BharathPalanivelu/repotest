package com.shopee.app.d.b.a.b.d;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16219c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16219c = orderDetail;
    }

    public long a() {
        return this.f16219c.getOrderId();
    }

    public String b() {
        return com.garena.android.appkit.tools.b.e(R.string.sp_prompt_arrange_logistics);
    }

    public String k() {
        if (this.f16219c.getSellerDueDate() <= 0) {
            return "";
        }
        return com.garena.android.appkit.tools.b.a(R.string.sp_wait_buyer_action, a.c(this.f16219c.getSellerDueDate(), "ID"));
    }
}
