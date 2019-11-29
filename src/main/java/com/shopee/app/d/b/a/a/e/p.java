package com.shopee.app.d.b.a.a.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class p extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16118c;

    public String m() {
        return "#1301";
    }

    public p(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16118c = orderDetail;
    }

    public long a() {
        return this.f16118c.getOrderId();
    }

    public String b() {
        return b.e(R.string.action_buyer_escrow_with_return_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                p.this.f15981b.a("GOTO_ORDER_RETURN_DETAIL", new com.garena.android.appkit.b.a(p.this.f16118c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_refund_n_return_requested);
    }

    public String k() {
        if (this.f16118c.getSellerDueDate() <= 0) {
            return "";
        }
        return b.a(R.string.action_buyer_escrow_with_return_detail_text, com.garena.android.appkit.tools.a.a.c(this.f16118c.getSellerDueDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.action_buyer_escrow_with_return_tooltip_text);
    }
}
