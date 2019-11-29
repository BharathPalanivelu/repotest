package com.airpay.paysdk.qrcode.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.airpay.paysdk.base.ui.a.a;
import com.airpay.paysdk.c;
import com.squareup.a.r;
import com.squareup.a.w;

public class PaymentCodeHelpActivity extends a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f4403b;

    public static void a(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, PaymentCodeHelpActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.activity_payment_code_help_layout;
    }

    /* access modifiers changed from: protected */
    public void b() {
        setTitle(c.i.payment_code_help_page_title);
        this.f4403b = (ImageView) findViewById(c.f.iv_payment_code_help);
        w.a((Context) this).a(com.airpay.paysdk.base.different.a.a().c()).a(Bitmap.Config.RGB_565).a(r.NO_CACHE, r.NO_STORE).a(this.f4403b);
    }
}
