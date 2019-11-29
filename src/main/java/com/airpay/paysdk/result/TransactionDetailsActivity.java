package com.airpay.paysdk.result;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.airpay.paysdk.b;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.d.o;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.PayResult;
import com.airpay.paysdk.core.dispatch.DispatchActivity;
import com.airpay.paysdk.result.widget.BPFloatingLayerLayout;
import com.airpay.paysdk.result.widget.e;
import com.airpay.paysdk.result.widget.h;
import com.airpay.paysdk.result.widget.i;
import com.airpay.paysdk.result.widget.j;
import com.airpay.paysdk.result.widget.l;
import com.airpay.paysdk.result.widget.n;

public class TransactionDetailsActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    protected LinearLayout f4435b;

    /* renamed from: c  reason: collision with root package name */
    protected LinearLayout f4436c;

    /* renamed from: d  reason: collision with root package name */
    protected LinearLayout f4437d;

    /* renamed from: e  reason: collision with root package name */
    protected LinearLayout f4438e;

    /* renamed from: f  reason: collision with root package name */
    protected BPFloatingLayerLayout f4439f;

    /* renamed from: g  reason: collision with root package name */
    private com.airpay.paysdk.result.bean.a f4440g;
    private boolean h = false;
    private b i;

    public static void a(Context context, BPOrderInfo bPOrderInfo, b bVar) {
        Intent intent = new Intent(context, TransactionDetailsActivity.class);
        Bundle bundle = new Bundle();
        o.a(bundle, bVar);
        intent.putExtras(bundle);
        intent.putExtra("order_info", bPOrderInfo);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_transaction_details_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        Intent intent = getIntent();
        this.i = o.a(getIntent().getExtras());
        a(new com.airpay.paysdk.result.bean.a((BPOrderInfo) intent.getParcelableExtra("order_info")));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m();
    }

    public void onBackPressed() {
        l();
    }

    private void l() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.onResponse(PayResult.f4115c);
        }
        Intent intent = new Intent(this, DispatchActivity.class);
        intent.setFlags(67108864);
        intent.addFlags(536870912);
        startActivity(intent);
    }

    private void m() {
        long paymentCashAmount = this.f4440g.q().getPaymentCashAmount();
        if (!this.h && paymentCashAmount > 0) {
            double c2 = com.airpay.paysdk.pay.b.c((double) paymentCashAmount);
            this.h = true;
            com.airpay.paysdk.common.c.a.a().a(new Runnable(c2) {
                private final /* synthetic */ double f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    TransactionDetailsActivity.this.b(this.f$1);
                }
            }, 500);
        }
    }

    private void a(com.airpay.paysdk.result.bean.a aVar) {
        this.f4440g = aVar;
        this.f4439f = (BPFloatingLayerLayout) findViewById(c.f.com_garena_beepay_section_floating_layer);
        this.f4435b = (LinearLayout) findViewById(c.f.com_garena_beepay_section_top_container);
        this.f4436c = (LinearLayout) findViewById(c.f.com_garena_beepay_section_middle_container);
        this.f4438e = (LinearLayout) findViewById(c.f.com_garena_beepay_section_rating_container);
        this.f4437d = (LinearLayout) findViewById(c.f.com_garena_beepay_section_bottom_container);
        this.f4439f.setAnchor(c.f.com_garena_beepay_section_middle_container);
        ((NestedScrollView) findViewById(c.f.com_garena_beepay_detail_scroll_view)).setOnScrollChangeListener(new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                TransactionDetailsActivity.this.a(nestedScrollView, i, i2, i3, i4);
            }
        });
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
        this.f4439f.requestLayout();
    }

    public void h() {
        j();
        k();
        i();
        a((Context) this);
        b((Context) this);
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.f4435b.removeAllViews();
        this.f4436c.removeAllViews();
        this.f4438e.removeAllViews();
        this.f4437d.removeAllViews();
        this.f4439f.a();
        this.f4436c.setVisibility(0);
        this.f4438e.setVisibility(0);
        this.f4437d.setVisibility(0);
        this.f4439f.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        j jVar = new j(context, this.f4440g, false, false);
        jVar.a();
        this.f4435b.addView(jVar);
        l lVar = new l(context, this.f4440g);
        lVar.b();
        this.f4435b.addView(lVar);
        i iVar = new i(context, this.f4440g);
        iVar.b();
        this.f4435b.addView(iVar);
    }

    private void b(Context context) {
        h a2 = h.a(context, this.f4440g);
        if (a2 != null) {
            a2.b();
            this.f4436c.addView(a2);
        }
        n a3 = n.a(context, this.f4440g);
        if (a3 != null) {
            a3.b();
            this.f4436c.addView(a3);
        }
        e a4 = e.a(context, this.f4440g);
        if (a4 != null) {
            a4.b();
            this.f4436c.addView(a4);
        }
        this.f4437d.addView(new com.airpay.paysdk.result.widget.b(context, this.f4440g));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void b(double d2) {
        com.airpay.paysdk.result.widget.a aVar = new com.airpay.paysdk.result.widget.a(this);
        aVar.a(d2);
        aVar.a(false);
        aVar.a(d());
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.f4440g.t() == 1 && this.f4440g.p() != null && this.f4440g.p().b() == 101) {
            setTitle(c.i.com_garena_beepay_label_pay_at_counter);
        } else {
            setTitle(c.i.com_garena_beepay_label_transaction_detail);
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f3840a != null) {
            this.f3840a.b();
            this.f3840a.setHomeBtnVisibility(true);
            this.f3840a.setHomeBtnText(getString(c.i.com_garena_beepay_label_close));
            this.f3840a.setHomeAction(new View.OnClickListener() {
                public final void onClick(View view) {
                    TransactionDetailsActivity.this.a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }
}
