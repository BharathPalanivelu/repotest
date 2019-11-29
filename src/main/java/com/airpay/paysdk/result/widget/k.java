package com.airpay.paysdk.result.widget;

import android.content.Context;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

public class k extends m {

    /* renamed from: a  reason: collision with root package name */
    private a f4526a;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    public k(Context context, a aVar) {
        super(context);
        this.f4526a = aVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
        Context context = getContext();
        addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_create_time), (CharSequence) com.airpay.paysdk.base.d.c.a(((long) this.f4526a.q().getCreateTime()) * 1000), c.b.txt_color_dark_less));
        int t = this.f4526a.t();
        if ((t == 0 || t == 6) && this.f4526a.q().getTopupCompletionTime() > 0) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_payment_time), (CharSequence) com.airpay.paysdk.base.d.c.a(((long) this.f4526a.q().getTopupCompletionTime()) * 1000), c.b.txt_color_dark_less));
        }
    }
}
