package com.shopee.app.d.b.a.a.f;

import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;
import java.util.List;

public class j extends a {

    /* renamed from: c  reason: collision with root package name */
    CheckoutItem f16163c;

    public j(CheckoutItem checkoutItem) {
        super(checkoutItem);
        this.f16163c = checkoutItem;
    }

    public long a() {
        return this.f16163c.getCheckoutId();
    }

    public String b() {
        return a((int) R.string.action_buyer_offline_unpaid_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_seller), 0, new View.OnClickListener() {
            public void onClick(View view) {
                List<OrderDetail> orderDetailList = j.this.f16163c.getOrderDetailList();
                if (orderDetailList != null && !orderDetailList.isEmpty()) {
                    j.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(orderDetailList.get(0)));
                }
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                j.this.f15981b.a("CANCEL_CHECKOUT_ACTION", new com.garena.android.appkit.b.a(j.this.f16163c));
            }
        });
    }

    public a.C0251a f() {
        return ar.f().e().orderLogicProcessor().a(this.f16163c, this.f15981b);
    }

    public a.C0251a g() {
        return ar.f().e().orderLogicProcessor().b(this.f16163c, this.f15981b);
    }

    public String j() {
        return a((int) R.string.sp_label_to_pay);
    }

    public String k() {
        return a((int) R.string.action_buyer_offline_unpaid_detail_text);
    }
}
