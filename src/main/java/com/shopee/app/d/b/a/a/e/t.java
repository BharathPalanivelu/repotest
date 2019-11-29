package com.shopee.app.d.b.a.a.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class t extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16126c;

    public t(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16126c = orderDetail;
    }

    public long a() {
        return this.f16126c.getOrderId();
    }

    public String b() {
        if (this.f16126c.getShipByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_will_ship_by_date, com.garena.android.appkit.tools.a.a.c(this.f16126c.getShipByDate(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
            public void onClick(View view) {
                t.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(t.this.f16126c));
            }
        });
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().c(this.f16126c, this.f15981b);
    }

    public a.C0251a f() {
        return ar.f().e().orderLogicProcessor().d(this.f16126c, this.f15981b);
    }

    public a.C0251a g() {
        return ar.f().e().orderLogicProcessor().e(this.f16126c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        if (this.f16126c.getShipByDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_wait_ship_and_cod, com.garena.android.appkit.tools.a.a.c(this.f16126c.getShipByDate(), "ID"));
    }
}
