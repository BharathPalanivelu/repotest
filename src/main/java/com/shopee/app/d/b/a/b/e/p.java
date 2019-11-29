package com.shopee.app.d.b.a.b.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class p extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16282c;

    public String m() {
        return "#3301";
    }

    public p(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16282c = orderDetail;
    }

    public long a() {
        return this.f16282c.getOrderId();
    }

    public String b() {
        return b.e(R.string.sp_return_refund_need_response);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                p.this.f15981b.a("GOTO_ORDER_RETURN_DETAIL", new com.garena.android.appkit.b.a(p.this.f16282c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_refund_n_return_requested);
    }

    public String k() {
        if (this.f16282c.getSellerDueDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_shipped_refund_info, com.garena.android.appkit.tools.a.a.c(this.f16282c.getSellerDueDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.action_seller_escrow_with_return_tooltip_text);
    }
}
