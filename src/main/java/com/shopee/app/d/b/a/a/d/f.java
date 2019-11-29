package com.shopee.app.d.b.a.a.d;

import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class f extends g {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16065c;

    public f(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16065c = orderDetail;
    }

    public String b() {
        int r = r();
        if (r <= 0) {
            return "";
        }
        return b.a(R.string.sp_collect_product_by_day, a.c(r, "ID"));
    }
}
