package com.shopee.app.d.b.a.b.e;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class w extends aa {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16302c;

    public w(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16302c = orderDetail;
    }

    public long a() {
        return this.f16302c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16302c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                w.this.f15981b.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(w.this.f16302c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                w.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(w.this.f16302c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        return a((int) R.string.sp_buyer_wait_ship);
    }
}
