package com.shopee.app.d.b.a.b.f;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;
import d.d.b.j;

public final class d extends com.shopee.app.d.b.a.a {

    /* renamed from: c  reason: collision with root package name */
    private final OrderDetail f16319c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(OrderDetail orderDetail) {
        super(orderDetail);
        j.b(orderDetail, "orderDetail");
        this.f16319c = orderDetail;
    }

    public final OrderDetail r() {
        return this.f16319c;
    }

    public long a() {
        return this.f16319c.getOrderId();
    }

    public String j() {
        String a2 = a((int) R.string.sp_label_order_status_unpaid);
        j.a((Object) a2, "string(R.string.sp_label_order_status_unpaid)");
        return a2;
    }

    public String b() {
        String a2 = a((int) R.string.sp_label_order_ibanking_review);
        j.a((Object) a2, "string(R.string.sp_label_order_ibanking_review)");
        return a2;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f16320a;

        a(d dVar) {
            this.f16320a = dVar;
        }

        public final void onClick(View view) {
            this.f16320a.f15981b.a("ORDER_GOTO_CHAT", new com.garena.android.appkit.b.a(this.f16320a.r()));
        }
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_contact_buyer), 0, new a(this));
    }
}
