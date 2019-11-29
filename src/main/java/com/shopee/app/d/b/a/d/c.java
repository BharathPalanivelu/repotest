package com.shopee.app.d.b.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class c extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16343c;

    public c(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16343c = orderDetail;
    }

    public long a() {
        return this.f16343c.getOrderId();
    }

    public String b() {
        if (this.f16343c.getRateByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_rate_by_day, com.garena.android.appkit.tools.a.a.c(this.f16343c.getRateByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_label_rate), 0, new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f15981b.a("ORDER_BUYER_RATE", new com.garena.android.appkit.b.a(c.this.f16343c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_tab_seller_completed);
    }

    public String k() {
        if (this.f16343c.getRateByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_rate_product_by_day, com.garena.android.appkit.tools.a.a.c(this.f16343c.getRateByDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.sp_if_u_no_rate_product);
    }
}
