package com.shopee.app.d.b.a.a.c;

import android.app.Activity;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.c.c;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class h extends a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16041d;

    public a.C0251a i() {
        return null;
    }

    public String m() {
        return "#1301";
    }

    public h(ReturnItem returnItem) {
        super(returnItem);
        this.f16041d = returnItem;
    }

    public String b() {
        if (this.f16041d.getMTime() <= 0) {
            return "";
        }
        String str = (String) com.shopee.app.d.b.a.c.a.f16328a.b(this.f16041d, c.SHORT_TEXT);
        if (str != null) {
            return str;
        }
        if (!this.f16041d.isNonReceipt() && !this.f16041d.isInComplete() && (r() || s() || t())) {
            return b.e(R.string.order_list_processing_return_refund_request);
        }
        return b.a(R.string.action_buyer_return_pending_summary_text, v());
    }

    public a.C0251a d() {
        return r() ? new a.C0251a(a((int) R.string.order_list_cancel_return_refund), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = h.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(h.this.f16041d.isSelling(), h.this.f16041d.getReturnId());
                }
            }
        }) : new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = h.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(h.this.f16041d.isSelling(), h.this.f16041d.getReturnId());
                }
            }
        });
    }

    public String j() {
        if (r()) {
            return b.e(R.string.order_list_return_request_submitted);
        }
        return a((int) R.string.sp_request_pending);
    }

    public String l() {
        return a((int) R.string.action_buyer_return_pending_tooltip_text);
    }
}
