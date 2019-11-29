package com.shopee.app.d.b.a.b.e;

import android.text.TextUtils;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class aa extends b {

    /* renamed from: c  reason: collision with root package name */
    private OrderDetail f16236c;

    public aa(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16236c = orderDetail;
    }

    /* access modifiers changed from: protected */
    public int r() {
        return this.f16236c.getArrangePickupByDate();
    }

    public String b() {
        String b2 = ar.f().e().orderLogicProcessor().b(this.f16236c);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        int r = r();
        if (r <= 0) {
            return "";
        }
        return b.a(R.string.sp_arrange_pickup_by_day, a.c(r, "ID"));
    }

    public boolean s() {
        return ar.f().e().orderLogicProcessor().c(this.f16236c);
    }
}
