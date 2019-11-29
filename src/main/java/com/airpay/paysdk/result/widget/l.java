package com.airpay.paysdk.result.widget;

import android.content.Context;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

public class l extends m {

    /* renamed from: a  reason: collision with root package name */
    private a f4527a;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    public l(Context context, a aVar) {
        super(context);
        this.f4527a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
        m.c cVar = new m.c(getContext(), getResources().getString(c.i.com_garena_beepay_total_amount), this.f4527a.b());
        cVar.a(20, getResources().getColor(c.b.txt_color_dark));
        addView(cVar);
    }
}
