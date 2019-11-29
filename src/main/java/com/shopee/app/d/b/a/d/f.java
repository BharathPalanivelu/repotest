package com.shopee.app.d.b.a.d;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class f extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16349c;

    public f(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16349c = orderDetail;
    }

    public long a() {
        return this.f16349c.getOrderId();
    }

    public String b() {
        return a((int) R.string.sp_no_rating);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_view_shop_rating), 0, new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f15981b.a("ORDER_SELLER_VIEW_RATE", new com.garena.android.appkit.b.a(f.this.f16349c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_rated);
    }

    public String k() {
        return a((int) R.string.sp_thanks_4_rating);
    }
}
