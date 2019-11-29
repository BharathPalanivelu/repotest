package com.shopee.app.d.b.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class n extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16391c;

    public n(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16391c = orderDetail;
    }

    public long a() {
        return this.f16391c.getOrderId();
    }

    public String b() {
        return a((int) R.string.sp_wait_buyer_rate);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_view_buyer_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                n.this.f15981b.a("ORDER_BUYER_VIEW_RATE", new com.garena.android.appkit.b.a(n.this.f16391c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        if (this.f16391c.getRateByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_buyer_will_rate_by_day, com.garena.android.appkit.tools.a.a.c(this.f16391c.getRateByDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.sp_if_buyer_no_rate);
    }
}
