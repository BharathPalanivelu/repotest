package com.shopee.app.d.b.a.a.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class i extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16104c;

    public i(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16104c = orderDetail;
    }

    public long a() {
        return this.f16104c.getOrderId();
    }

    public String b() {
        if (this.f16104c.getShipByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_will_ship_by_date, com.garena.android.appkit.tools.a.a.c(this.f16104c.getShipByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
            public void onClick(View view) {
                i.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(i.this.f16104c));
            }
        });
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().c(this.f16104c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        if (this.f16104c.getShipByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_product_will_ship_soon_pay_cod, com.garena.android.appkit.tools.a.a.c(this.f16104c.getShipByDate(), "ID"));
    }
}
