package com.shopee.app.d.b.a.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class j extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16072c;

    public String m() {
        return "#1301";
    }

    public j(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16072c = orderDetail;
    }

    public long a() {
        return this.f16072c.getOrderId();
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_request_return_refund), 0, new View.OnClickListener() {
            public void onClick(View view) {
                j.this.f15981b.a("ORDER_REQUEST_RETURN_N_REFUND", new com.garena.android.appkit.b.a(j.this.f16072c));
            }
        });
    }

    public String k() {
        return a((int) R.string.action_buyer_escrow_ext_shipped_detail_text);
    }

    public String l() {
        return b.e(R.string.action_buyer_escrow_ext_not_shipped_tooltip_text);
    }
}
