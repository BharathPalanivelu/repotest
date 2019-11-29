package com.shopee.app.d.b.a.b.c;

import android.app.Activity;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.e;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class h extends a {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ReturnItem f16210e;

    public a.C0251a i() {
        return null;
    }

    public String m() {
        return "3301";
    }

    public h(ReturnItem returnItem) {
        super(returnItem);
        this.f16210e = returnItem;
    }

    public String b() {
        if (this.f16210e.isNonReceipt() || this.f16210e.isInComplete()) {
            return b.a(R.string.sp_response_by_date, v());
        } else if (this.f16210e.getMTime() <= 0) {
            return "";
        } else {
            return b.a(R.string.sp_response_by_date, v());
        }
    }

    public a.C0251a d() {
        if (this.f16210e.isNonReceipt() || (!s() && !t())) {
            return new a.C0251a(a((int) R.string.sp_label_respond), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    Activity a2 = h.this.a(view);
                    if (a2 != null) {
                        ar.f().e().actionTracker().a(((e) a2).A(), h.this.f16210e);
                        new ak(a2).a(h.this.f16210e.isSelling(), h.this.f16210e.getReturnId());
                    }
                }
            });
        }
        return super.d();
    }

    public String j() {
        return a((int) R.string.sp_request_pending);
    }

    public String k() {
        if (this.f16210e.getMTime() <= 0) {
            return "";
        }
        return b.a(R.string.action_seller_return_pending_detail_text, v());
    }

    public String l() {
        return a((int) R.string.action_seller_return_pending_tooltip_text);
    }
}
