package com.shopee.app.d.b.a.b.a;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16174c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16174c = orderDetail;
    }

    public long a() {
        return this.f16174c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_seller_cancelled_by_buyer_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(b.this.f16174c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.action_seller_cancelled_by_buyer_detail_text);
    }
}
