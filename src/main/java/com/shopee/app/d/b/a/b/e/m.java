package com.shopee.app.d.b.a.b.e;

import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class m extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16274c;

    public m(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16274c = orderDetail;
    }

    public long a() {
        return this.f16274c.getOrderId();
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.f16274c.getPickupTime();
    }

    public String b() {
        if (TextUtils.isEmpty(this.f16274c.getPickupTimeString())) {
            return "";
        }
        String b2 = ar.f().e().orderLogicProcessor().b(this.f16274c);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return b.a(R.string.sp_parcel_pickup_on_day, this.f16274c.getPickupTimeString());
    }

    public boolean s() {
        return ar.f().e().orderLogicProcessor().c(this.f16274c);
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16274c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                m.this.f15981b.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(m.this.f16274c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                m.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(m.this.f16274c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        return a((int) R.string.sp_recommend_wait_before_ship);
    }
}
