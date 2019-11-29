package com.shopee.app.d.b.a.b.e;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16234c;

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16234c = orderDetail;
    }

    public long a() {
        return this.f16234c.getOrderId();
    }

    public String b() {
        return a((int) R.string.sp_prompt_arrange_logistics);
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16234c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("ORDER_SHIPPED", new com.garena.android.appkit.b.a(a.this.f16234c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        return a((int) R.string.sp_pay_confirmed_buyer_wait_ship);
    }
}
