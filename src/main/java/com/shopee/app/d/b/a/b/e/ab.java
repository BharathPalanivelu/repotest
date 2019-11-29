package com.shopee.app.d.b.a.b.e;

import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class ab extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16237c;

    public ab(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16237c = orderDetail;
    }

    public long a() {
        return this.f16237c.getOrderId();
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.f16237c.getPickupTime();
    }

    public String b() {
        if (TextUtils.isEmpty(this.f16237c.getPickupTimeString())) {
            return "";
        }
        String b2 = ar.f().e().orderLogicProcessor().b(this.f16237c);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return b.a(R.string.sp_parcel_pickup_on_day, this.f16237c.getPickupTimeString());
    }

    public boolean s() {
        return ar.f().e().orderLogicProcessor().c(this.f16237c);
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16237c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                ab.this.f15981b.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(ab.this.f16237c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        if (TextUtils.isEmpty(this.f16237c.getPickupTimeString())) {
            return "";
        }
        return b.a(R.string.sp_pick_up_by_day_info, this.f16237c.getPickupTimeString());
    }
}
