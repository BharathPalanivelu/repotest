package com.shopee.app.d.b.a.a.d;

import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16055c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16055c = orderDetail;
    }

    public long a() {
        return this.f16055c.getOrderId();
    }

    public String b() {
        return com.garena.android.appkit.tools.b.e(R.string.action_buyer_offline_not_shipped_summary_text);
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_to_receive);
    }

    public String k() {
        return a((int) R.string.sp_buyer_confirm_info);
    }
}
