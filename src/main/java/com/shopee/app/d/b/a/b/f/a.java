package com.shopee.app.d.b.a.b.f;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class a extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    OrderDetail f16314c;

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16314c = orderDetail;
    }

    public long a() {
        return this.f16314c.getOrderId();
    }

    public String b() {
        if (this.f16314c.getPayByDay() <= 0) {
            return "";
        }
        return b.a(R.string.action_seller_bank_transfer_unpaid_summary_text, com.garena.android.appkit.tools.a.a.c(this.f16314c.getPayByDay(), "ID"));
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_buyer), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(a.this.f16314c));
            }
        });
    }

    public a.C0251a i() {
        return ar.f().e().orderLogicProcessor().g(this.f16314c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_order_status_unpaid);
    }

    public String k() {
        if (this.f16314c.getPayByDay() <= 0) {
            return "";
        }
        return b.a(R.string.action_seller_bank_transfer_unpaid_detail_text, com.garena.android.appkit.tools.a.a.c(this.f16314c.getPayByDay(), "ID"));
    }

    public String l() {
        return b.e(R.string.action_seller_bank_transfer_unpaid_tooltip_text);
    }
}
