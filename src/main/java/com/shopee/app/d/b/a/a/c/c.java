package com.shopee.app.d.b.a.a.c;

import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class c extends a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16032d;

    public c(ReturnItem returnItem) {
        super(returnItem);
        this.f16032d = returnItem;
    }

    public String b() {
        return a((int) R.string.action_buyer_return_cancelled_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                new ak(c.this.a(view)).a(c.this.f16032d.isSelling(), c.this.f16032d.getReturnId());
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_request_cancelled);
    }
}
