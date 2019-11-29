package com.shopee.app.d.b.a.b.e;

import android.view.View;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class g extends b {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public OrderDetail f16260c;

    public g(OrderDetail orderDetail) {
        super(orderDetail);
        this.f16260c = orderDetail;
    }

    public String b() {
        if (this.f16260c.getShipByDate() <= 0) {
            return "";
        }
        return b.a(R.string.order_list_response_cancellation, a.c(this.f16260c.getCancelDueDate() + (ar.f().e().settingConfigStore().getCancellationDueDateOffSet() * 86400), "ID"));
    }

    public boolean s() {
        return a.a() > (this.f16260c.getCancelDueDate() + (ar.f().e().settingConfigStore().getCancellationDueDateOffSet() * 86400)) - 86400;
    }

    public a.C0251a d() {
        return new a.C0251a(b.e(R.string.sp_label_respond), 0, new View.OnClickListener() {
            public void onClick(View view) {
                g.this.f15981b.a("ORDER_GOTO_RESPONSE_CANCEL", new com.garena.android.appkit.b.a(g.this.f16260c));
            }
        });
    }

    public String j() {
        return a((int) R.string.order_list_cancellation_requested);
    }
}
