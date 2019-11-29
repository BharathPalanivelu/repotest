package com.shopee.app.d.b.a.a.a;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f15997c;

    public e(OrderDetail orderDetail) {
        super(orderDetail);
        this.f15997c = orderDetail;
    }

    public long a() {
        return this.f15997c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_buyer_cancelled_by_system_rejected_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(e.this.f15997c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_label_buy_again), 0, new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f15981b.a("ORDER_CANCELLED_BUY", new com.garena.android.appkit.b.a(e.this.f15997c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.action_buyer_cancelled_by_system_rejected_detail_text);
    }
}
