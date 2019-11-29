package com.shopee.app.d.b.a.b.e;

import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class v extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16299c;

    public v(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16299c = orderDetail;
    }

    public long a() {
        return this.f16299c.getOrderId();
    }

    public String b() {
        String b2 = ar.f().e().orderLogicProcessor().b(this.f16299c);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return b.e(R.string.sp_wait_courier);
    }

    public boolean s() {
        return ar.f().e().orderLogicProcessor().c(this.f16299c);
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16299c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                v.this.f15981b.a("GOTO_SHIP_PAGE", new com.garena.android.appkit.b.a(v.this.f16299c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                v.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(v.this.f16299c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        return a((int) R.string.sp_order_status_wait_courier);
    }
}
