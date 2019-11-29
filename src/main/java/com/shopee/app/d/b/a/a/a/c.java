package com.shopee.app.d.b.a.a.a;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class c extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f15992c;

    public c(OrderDetail orderDetail) {
        super(orderDetail);
        this.f15992c = orderDetail;
    }

    public long a() {
        return this.f15992c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_buyer_cancelled_by_seller_summary_text);
    }

    public a.C0251a d() {
        return ar.f().e().orderLogicProcessor().f(this.f15992c, this.f15981b);
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_label_buy_again), 0, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f15981b.a("ORDER_CANCELLED_BUY", new com.garena.android.appkit.b.a(c.this.f15992c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.action_buyer_cancelled_by_seller_detail_text);
    }
}
