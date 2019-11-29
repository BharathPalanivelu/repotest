package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.text.TextUtils;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

public class g extends m {

    /* renamed from: a  reason: collision with root package name */
    private final a f4503a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4504b;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    private g(Context context, a aVar, boolean z) {
        super(context);
        this.f4503a = aVar;
        this.f4504b = z;
    }

    public static g a(Context context, a aVar, boolean z) {
        if (aVar.F() == 6) {
            return null;
        }
        boolean z2 = aVar.s().intValue() == 11080 || aVar.r() == 21070 || aVar.r() == 21072;
        if (z2) {
            if (z) {
                return null;
            }
        } else if (!z) {
            return null;
        }
        int r = aVar.r();
        if (r == 21000 || r == 21020 || r == 21035 || r == 21031 || r == 21032 || aVar.t() == 4 || aVar.t() == 1 || com.airpay.paysdk.pay.b.a.l(aVar.q().getExtraData()) == 155) {
            return null;
        }
        return new g(context, aVar, z2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        CharSequence a2 = this.f4503a.a("");
        Context context = getContext();
        if (!TextUtils.isEmpty(a2)) {
            addView(new m.c(context, (CharSequence) context.getString(this.f4504b ? c.i.airpay_label_merchant_fee : c.i.com_garena_beepay_label_transaction_fee), a2, c.b.txt_color_dark_less));
        }
        CharSequence v = this.f4503a.v();
        if (!TextUtils.isEmpty(v) && this.f4503a.r() != 21081) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_discount), v, c.b.txt_color_dark_less));
        }
        CharSequence w = this.f4503a.w();
        if (!TextUtils.isEmpty(w)) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_paid_via_cash), w, c.b.txt_color_dark_less));
        }
        if (this.f4503a.q().getRefund_order_id() > -1 && this.f4503a.q().getCash_amount() > 0) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_refunded_to_cash), f.a(this.f4503a.q().getCash_amount(), this.f4503a.q().getCurrency()), c.b.txt_color_dark_less));
        }
        CharSequence x = this.f4503a.x();
        if (!TextUtils.isEmpty(x)) {
            addView(new m.c(context, (CharSequence) this.f4503a.y(), x, c.b.txt_color_dark_less));
        }
        if (this.f4503a.q().getRefund_order_id() > -1 && this.f4503a.q().getChannel_amount() > 0) {
            addView(new m.c(context, (CharSequence) this.f4503a.z(), f.a(this.f4503a.q().getChannel_amount(), this.f4503a.q().getCurrency()), c.b.txt_color_dark_less));
        }
    }
}
