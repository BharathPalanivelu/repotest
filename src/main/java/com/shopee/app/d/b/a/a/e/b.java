package com.shopee.app.d.b.a.a.e;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class b extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16090c;

    public b(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16090c = orderDetail;
    }

    public long a() {
        return this.f16090c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(b.this.f16090c));
            }
        });
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().e(this.f16090c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }
}
