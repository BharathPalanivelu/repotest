package com.shopee.app.d.b.a.b.f;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16316c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16316c = orderDetail;
    }

    public String b() {
        return a((int) R.string.sp_label_payment_via_cod);
    }

    public String k() {
        return a((int) R.string.sp_cod_seller_info);
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_unpaid);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_payment_pending_review), 1, (View.OnClickListener) null);
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().g(this.f16316c, this.f15981b);
    }

    public long a() {
        return this.f16316c.getOrderId();
    }
}
