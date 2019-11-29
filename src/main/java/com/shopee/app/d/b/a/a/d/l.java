package com.shopee.app.d.b.a.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class l extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16077c;

    public String m() {
        return "#1301";
    }

    public l(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16077c = orderDetail;
    }

    public long a() {
        return this.f16077c.getOrderId();
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_request_return_refund), 0, new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f15981b.a("ORDER_REQUEST_RETURN_N_REFUND", new com.garena.android.appkit.b.a(l.this.f16077c));
            }
        });
    }

    public String k() {
        if (this.f16077c.getReleaseTime() <= 0) {
            return "";
        }
        return b.a(R.string.sp_shipped_shopee_guarantee, com.garena.android.appkit.tools.a.a.c(this.f16077c.getReleaseTime(), "ID"));
    }

    public String l() {
        return a((int) R.string.action_buyer_escrow_ext_shipped_tooltip_text);
    }
}
