package com.shopee.app.d.b.a.b.e;

import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class ac extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16239c;

    public ac(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16239c = orderDetail;
    }

    public long a() {
        return this.f16239c.getOrderId();
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.f16239c.getPickupTime();
    }

    public String b() {
        if (TextUtils.isEmpty(this.f16239c.getPickupTimeString())) {
            return "";
        }
        String b2 = ar.f().e().orderLogicProcessor().b(this.f16239c);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return b.a(R.string.sp_parcel_pickup_on_day, this.f16239c.getPickupTimeString());
    }

    public boolean s() {
        return ar.f().e().orderLogicProcessor().c(this.f16239c);
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16239c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                ac.this.f15981b.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(ac.this.f16239c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                ac.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(ac.this.f16239c));
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
