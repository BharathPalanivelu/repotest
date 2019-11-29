package com.shopee.app.d.b.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class p extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16395c;

    public p(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16395c = orderDetail;
    }

    public long a() {
        return this.f16395c.getOrderId();
    }

    public String b() {
        if (this.f16395c.getRateByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_rate_buyer_by_day, com.garena.android.appkit.tools.a.a.c(this.f16395c.getRateByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_label_rate), 0, new View.OnClickListener() {
            public void onClick(View view) {
                p.this.f15981b.a("ORDER_SELLER_RATE", new com.garena.android.appkit.b.a(p.this.f16395c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_tab_seller_completed);
    }

    public String k() {
        if (this.f16395c.getRateByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_rated_seller_2_rate_buyer, com.garena.android.appkit.tools.a.a.c(this.f16395c.getRateByDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.sp_if_u_no_rate_buyer);
    }
}
