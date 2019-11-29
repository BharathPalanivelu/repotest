package com.shopee.app.d.b.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class e extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16347c;

    public e(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16347c = orderDetail;
    }

    public long a() {
        return this.f16347c.getOrderId();
    }

    public String b() {
        return a((int) R.string.sp_wait_seller_rate_u);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_view_shop_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f15981b.a("ORDER_SELLER_VIEW_RATE", new com.garena.android.appkit.b.a(e.this.f16347c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        if (this.f16347c.getRateByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_ask_seller_2_rate, com.garena.android.appkit.tools.a.a.c(this.f16347c.getRateByDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.sp_if_seller_no_rate);
    }
}
