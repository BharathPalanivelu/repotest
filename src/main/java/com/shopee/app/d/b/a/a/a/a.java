package com.shopee.app.d.b.a.a.a;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f15986c;

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f15986c = orderDetail;
    }

    public long a() {
        return this.f15986c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_buyer_cancelled_by_buyer_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(a.this.f15986c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_label_buy_again), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("ORDER_CANCELLED_BUY", new com.garena.android.appkit.b.a(a.this.f15986c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.action_buyer_cancelled_by_buyer_detail_text);
    }
}
