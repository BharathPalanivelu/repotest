package com.shopee.app.d.b.a.b.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class d extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16222c;

    public String m() {
        return "#pending";
    }

    public d(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16222c = orderDetail;
    }

    public long a() {
        return this.f16222c.getOrderId();
    }

    public a.C0251a d() {
        if (!ar.f().e().settingConfigStore().hideOrderReceived() || !this.f16222c.isOfficialShop()) {
            return new a.C0251a(a((int) R.string.sp_remind_buyer_receive), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(d.this.f16222c));
                }
            });
        }
        return new a.C0251a(a((int) R.string.sp_contact_buyer), 0, new View.OnClickListener() {
            public void onClick(View view) {
                d.this.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(d.this.f16222c));
            }
        });
    }

    public String l() {
        return b.e(R.string.action_seller_escrow_ext_not_shipped_tooltip_text);
    }
}
