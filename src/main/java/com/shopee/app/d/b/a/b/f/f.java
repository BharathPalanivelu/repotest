package com.shopee.app.d.b.a.b.f;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.order.j;
import com.shopee.id.R;

public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16323c;

    public int o() {
        return R.string.action_seller_offline_unpaid_popup_text;
    }

    public f(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16323c = orderDetail;
    }

    public long a() {
        return this.f16323c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_label_payment_received), 0, new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f15981b.a("ORDER_PAYMENT_RECEIVED", (com.garena.android.appkit.b.a) new j(f.this.f16323c, f.this.o()));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(f.this.f16323c));
            }
        });
    }

    public String b() {
        return a((int) R.string.action_seller_offline_unpaid_summary_text);
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_unpaid);
    }

    public String k() {
        return a((int) R.string.action_seller_offline_unpaid_detail_text);
    }
}
