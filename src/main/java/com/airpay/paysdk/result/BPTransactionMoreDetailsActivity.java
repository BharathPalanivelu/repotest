package com.airpay.paysdk.result;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.widget.b;
import com.airpay.paysdk.result.widget.g;
import com.airpay.paysdk.result.widget.k;

public class BPTransactionMoreDetailsActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    protected LinearLayout f4431b;

    /* renamed from: c  reason: collision with root package name */
    protected LinearLayout f4432c;

    /* renamed from: d  reason: collision with root package name */
    private com.airpay.paysdk.result.bean.a f4433d;

    /* renamed from: e  reason: collision with root package name */
    private NestedScrollView f4434e;

    public static void a(Context context, BPOrderInfo bPOrderInfo) {
        Intent intent = new Intent(context, BPTransactionMoreDetailsActivity.class);
        intent.putExtra("order", bPOrderInfo);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_beepay_view_auto_align;
    }

    /* access modifiers changed from: protected */
    public void b() {
        BPOrderInfo bPOrderInfo;
        setTitle(c.i.com_garena_beepay_label_more_detail);
        try {
            bPOrderInfo = (BPOrderInfo) getIntent().getParcelableExtra("order");
        } catch (Exception unused) {
            bPOrderInfo = null;
        }
        if (bPOrderInfo == null) {
            com.airpay.paysdk.base.b.a.a().a((Context) this, c.i.com_garena_beepay_unknown_error);
            finish();
            return;
        }
        this.f4433d = new com.airpay.paysdk.result.bean.a(bPOrderInfo);
        this.f4431b = (LinearLayout) findViewById(c.f.com_garena_beepay_upper_container);
        this.f4432c = (LinearLayout) findViewById(c.f.com_garena_beepay_lower_container);
        this.f4434e = (NestedScrollView) findViewById(c.f.com_garena_beepay_detail_scroll_view);
        this.f4434e.setBackgroundResource(c.b.bg_color_white);
        com.airpay.paysdk.result.widget.c a2 = com.airpay.paysdk.result.widget.c.a(this, this.f4433d);
        if (a2 != null) {
            a2.b();
            this.f4431b.addView(a2);
        }
        g a3 = g.a(this, this.f4433d, true);
        if (a3 != null) {
            a3.b();
            this.f4431b.addView(a3);
        }
        k kVar = new k(this, this.f4433d);
        kVar.b();
        this.f4431b.addView(kVar);
        this.f4432c.addView(new b(this, this.f4433d));
    }
}
