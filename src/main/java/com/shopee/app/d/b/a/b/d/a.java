package com.shopee.app.d.b.a.b.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.id.R;

public class a extends c {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16217c;

    public String m() {
        return "#3301";
    }

    public a(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16217c = orderDetail;
    }

    public long a() {
        return this.f16217c.getOrderId();
    }

    public String b() {
        DBReturnItem returnItem = this.f16217c.getReturnItem();
        if (this.f16217c.isOfficialShop()) {
            if (ar.f().e().settingConfigStore().hideReturnRefundText()) {
                return "";
            }
            char c2 = 65535;
            int hashCode = "ID".hashCode();
            if (hashCode == 2331) {
                c2 = 3;
            } else if (!(hashCode == 2476 || hashCode == 2644)) {
            }
            if (!((c2 != 0 && c2 != 1 && c2 != 2 && c2 != 3) || returnItem == null || returnItem.h() == 1)) {
                return a((int) R.string.sp_label_buyer_requested_return_refund);
            }
        }
        if (returnItem == null || returnItem.i() == 1) {
            return a((int) R.string.sp_return_refund_need_response);
        }
        return a((int) R.string.sp_label_buyer_requested_return_refund);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f15981b.a("GOTO_ORDER_RETURN_DETAIL", new com.garena.android.appkit.b.a(a.this.f16217c));
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_refund_n_return_requested);
    }

    public String k() {
        if (this.f16217c.getSellerDueDate() <= 0) {
            return "";
        }
        return b.a(R.string.sp_shipped_refund_info, com.garena.android.appkit.tools.a.a.c(this.f16217c.getSellerDueDate(), "ID"));
    }

    public String l() {
        return a((int) R.string.action_seller_return_pending_tooltip_text);
    }
}
