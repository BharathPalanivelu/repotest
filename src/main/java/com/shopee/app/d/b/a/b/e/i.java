package com.shopee.app.d.b.a.b.e;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class i extends aa {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16265c;

    public i(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16265c = orderDetail;
    }

    public long a() {
        return this.f16265c.getOrderId();
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16265c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                i.this.f15981b.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(i.this.f16265c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                i.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(i.this.f16265c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_pickup_failed);
    }

    public String k() {
        return b.a(R.string.sp_last_pickup_fail_info, this.f16265c.getPickupFailReason());
    }
}
