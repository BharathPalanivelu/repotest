package com.shopee.app.d.b.a.b.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.e;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class c extends a {
    public c(ReturnItem returnItem) {
        super(returnItem);
    }

    public String b() {
        return a((int) R.string.action_seller_return_cancelled_summary_text);
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = c.this.a(view);
                if (a2 != null) {
                    ar.f().e().actionTracker().a(((e) a2).A(), c.this.f16206c);
                    new ak(a2).a(c.this.f16206c.isSelling(), c.this.f16206c.getReturnId());
                }
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_request_cancelled);
    }

    public String k() {
        return a((int) R.string.action_seller_return_cancelled_detail_text);
    }
}
