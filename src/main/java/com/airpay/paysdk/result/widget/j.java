package com.airpay.paysdk.result.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.a;

@SuppressLint({"ViewConstructor"})
public class j extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f4521a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4522b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f4523c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f4524d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f4525e;

    public j(Context context, a aVar, boolean z, boolean z2) {
        super(context);
        this.f4521a = aVar;
        this.f4522b = z;
        a(context);
    }

    private void a(Context context) {
        inflate(context, c.h.com_garena_beepay_transaction_status, this);
        this.f4523c = (ImageView) findViewById(c.f.bp_status_icon);
        this.f4524d = (TextView) findViewById(c.f.bp_status_title);
        this.f4525e = (TextView) findViewById(c.f.bp_status_sub_title);
    }

    public void a() {
        int i;
        this.f4524d.setText(this.f4521a.n());
        String l = this.f4522b ? this.f4521a.l() : this.f4521a.m();
        if (TextUtils.isEmpty(l)) {
            this.f4525e.setVisibility(8);
        } else {
            this.f4525e.setVisibility(0);
            this.f4525e.setText(l);
        }
        int t = this.f4521a.t();
        if (!this.f4522b) {
            switch (t) {
                case 0:
                    this.f4524d.setTextColor(getResources().getColor(c.b.color_green));
                    i = c.d.com_garena_beepay_icon_payment_complete_page;
                    break;
                case 1:
                case 3:
                case 8:
                    this.f4524d.setTextColor(getResources().getColor(c.b.color_yellow));
                    i = c.d.com_garena_beepay_icon_payment_pending_page;
                    break;
                case 2:
                case 4:
                case 9:
                    this.f4524d.setTextColor(getResources().getColor(c.b.color_red));
                    i = c.d.com_garena_beepay_icon_payment_failed_page;
                    break;
                case 5:
                    this.f4524d.setTextColor(getResources().getColor(c.b.color_red));
                    i = c.d.com_garena_beepay_icon_payment_failed_page;
                    break;
                case 6:
                    i = c.d.com_garena_beepay_icon_payment_refund;
                    this.f4524d.setTextColor(getResources().getColor(c.b.color_green));
                    break;
                default:
                    this.f4524d.setTextColor(getResources().getColor(c.b.color_red));
                    i = c.d.com_garena_beepay_icon_payment_failed_page;
                    break;
            }
        } else if (t == 0) {
            this.f4524d.setTextColor(getResources().getColor(c.b.color_green));
            i = c.d.com_garena_beepay_icon_payment_complete_page;
        } else {
            i = 0;
        }
        this.f4523c.setImageResource(i);
        ((LinearLayout.LayoutParams) this.f4524d.getLayoutParams()).setMargins(0, l.a(getContext(), 30.0f), 0, 0);
        requestLayout();
    }
}
