package com.airpay.paysdk.result.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.d;
import com.airpay.paysdk.result.b;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

@SuppressLint({"ViewConstructor"})
public class i extends m {

    /* renamed from: a  reason: collision with root package name */
    private String f4519a;

    /* renamed from: b  reason: collision with root package name */
    private String f4520b;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    public i(Context context, a aVar) {
        super(context);
        d C = com.airpay.paysdk.pay.b.a.C(aVar.q().getExtraData());
        if (C == null || C.a() == null || C.a().a() == null) {
            this.f4519a = aVar.k();
        } else {
            this.f4519a = C.a().a().a().a(context);
        }
        try {
            if (aVar.r() == 21070 || aVar.r() == 21072) {
                this.f4520b = com.airpay.paysdk.pay.b.a.D(aVar.q().getExtraData()).b();
            }
        } catch (RuntimeException unused) {
        }
        if (TextUtils.isEmpty(this.f4520b)) {
            b F = com.airpay.paysdk.pay.b.a.F(aVar.q().getExtraData());
            if (F != null) {
                this.f4520b = F.a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        m.a aVar = new m.a(getContext(), getResources().getString(c.i.com_garena_beepay_label_product), this.f4519a);
        aVar.a(15, getResources().getColor(c.b.txt_color_dark));
        addView(aVar);
        if (!TextUtils.isEmpty(this.f4520b)) {
            m.a aVar2 = new m.a(getContext(), getResources().getString(c.i.com_garena_beepay_label_home_shop), this.f4520b);
            aVar2.a(15, getResources().getColor(c.b.txt_color_dark));
            addView(aVar2);
        }
    }
}
