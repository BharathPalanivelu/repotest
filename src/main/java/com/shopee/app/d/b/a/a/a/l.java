package com.shopee.app.d.b.a.a.a;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class l extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16016c;

    public l(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16016c = orderDetail;
    }

    public long a() {
        return this.f16016c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_seller_cancelled_by_system_underpaid_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(l.this.f16016c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_label_buy_again), 0, new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f15981b.a("ORDER_CANCELLED_BUY", new com.garena.android.appkit.b.a(l.this.f16016c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.sp_cancel_fail_cod_buyer);
    }
}
