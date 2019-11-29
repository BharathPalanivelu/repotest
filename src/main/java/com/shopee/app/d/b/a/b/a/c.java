package com.shopee.app.d.b.a.b.a;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16176c;

    public c(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16176c = orderDetail;
    }

    public long a() {
        return this.f16176c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_seller_cancelled_by_seller_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(c.this.f16176c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.action_seller_cancelled_by_seller_detail_text);
    }
}
