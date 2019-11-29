package com.shopee.app.d.b.a.a.a;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class m extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16019c;

    public m(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16019c = orderDetail;
    }

    public long a() {
        return this.f16019c.getOrderId();
    }

    public String b() {
        return a((int) R.string.action_seller_cancelled_by_system_underpaid_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                m.this.f15981b.a("ORDER_GOTO_CANCEL_DETAIL", new com.garena.android.appkit.b.a(m.this.f16019c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_label_buy_again), 0, new View.OnClickListener() {
            public void onClick(View view) {
                m.this.f15981b.a("ORDER_CANCELLED_BUY", new com.garena.android.appkit.b.a(m.this.f16019c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_canceled);
    }

    public String k() {
        return a((int) R.string.sp_cancell_fail_ship);
    }
}
