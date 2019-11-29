package com.shopee.app.d.b.a.b.e;

import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class d extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16251c;

    public d(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16251c = orderDetail;
    }

    public String b() {
        if (this.f16251c.getShipByDate() <= 0) {
            return "";
        }
        String b2 = ar.f().e().orderLogicProcessor().b(this.f16251c);
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return b.a(R.string.sp_ship_by_date, a.c(this.f16251c.getShipByDate(), "ID"));
    }

    public boolean s() {
        return ar.f().e().orderLogicProcessor().c(this.f16251c);
    }

    public a.C0251a d() {
        return new a.C0251a(ar.f().e().orderLogicProcessor().a(this.f16251c), 0, new View.OnClickListener() {
            public void onClick(View view) {
                d.this.f15981b.a("GOTO_SHIP_PAGE", new com.garena.android.appkit.b.a(d.this.f16251c));
            }
        });
    }

    public a.C0251a i() {
        return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
            public void onClick(View view) {
                d.this.f15981b.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(d.this.f16251c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_to_ship);
    }

    public String k() {
        return a((int) R.string.sp_generating_track_id_info);
    }
}
