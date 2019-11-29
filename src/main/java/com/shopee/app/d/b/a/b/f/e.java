package com.shopee.app.d.b.a.b.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16321c;

    public e(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16321c = orderDetail;
    }

    public long a() {
        return this.f16321c.getOrderId();
    }

    public String b() {
        if (this.f16321c.getPayByDay() <= 0) {
            return "";
        }
        return b.a(R.string.order_list_pay_by_seller, this.f16321c.getPaymentChannelName(), com.garena.android.appkit.tools.a.a.c(this.f16321c.getPayByDay(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_buyer), 0, new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(e.this.f16321c));
            }
        });
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().g(this.f16321c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_unpaid);
    }
}
