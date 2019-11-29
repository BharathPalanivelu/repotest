package com.shopee.app.d.b.a.a.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16080c;

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16080c = orderDetail;
    }

    public long a() {
        return this.f16080c.getOrderId();
    }

    public String b() {
        return b.e(R.string.action_buyer_offline_unpaid_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(a.this.f16080c));
            }
        });
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().e(this.f16080c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        return a((int) R.string.sp_get_paid_wait_ship);
    }
}
