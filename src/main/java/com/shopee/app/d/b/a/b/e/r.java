package com.shopee.app.d.b.a.b.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class r extends aa {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16287c;

    public r(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16287c = orderDetail;
    }

    public long a() {
        return this.f16287c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16287c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                r.this.f15981b.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(r.this.f16287c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                r.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(r.this.f16287c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_pickup_failed);
    }

    public String k() {
        return b.a(R.string.sp_last_pickup_fail_info, this.f16287c.getPickupFailReason());
    }
}
