package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.base.ui.weidget.c;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.b;

public class a extends c {

    /* renamed from: g  reason: collision with root package name */
    private TextView f4499g;
    private View h;

    /* access modifiers changed from: protected */
    public void b() {
    }

    public a(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_beepay_cashback_popup;
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        super.a(context);
        d.a(this.f3918a, c.f.com_garena_beepay_btn_cancel, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        this.f4499g = (TextView) this.f3918a.findViewById(c.f.com_garena_beepay_tv_cash_rebate_amount);
        this.h = this.f3918a.findViewById(c.f.com_garena_beepay_border);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f3919b.a();
    }

    public void a(double d2) {
        this.f4499g.setText(b.a(d2));
    }

    public void a(boolean z) {
        this.h.setVisibility(0);
        this.f3920c.setVisibility(0);
    }
}
