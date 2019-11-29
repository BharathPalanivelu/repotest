package com.shopee.app.d.b.a.a.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;

public class f extends a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ReturnItem f16037d;

    public f(ReturnItem returnItem) {
        super(returnItem);
        this.f16037d = returnItem;
    }

    public a.C0251a d() {
        return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = f.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(f.this.f16037d.isSelling(), f.this.f16037d.getReturnId());
                }
            }
        });
    }

    public String j() {
        return a((int) R.string.sp_label_dispute_pending);
    }
}
