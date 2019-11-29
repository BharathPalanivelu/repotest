package com.airpay.paysdk.pay.password;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.airpay.paysdk.base.proto.PaymentOrderInitRequestProto;
import com.airpay.paysdk.pay.ui.PaymentProcessingActivity;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private PaymentOrderInitRequestProto f4256a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4257b;

    /* renamed from: c  reason: collision with root package name */
    private String f4258c;

    /* renamed from: d  reason: collision with root package name */
    private String f4259d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4260e;

    /* renamed from: f  reason: collision with root package name */
    private int f4261f;

    /* renamed from: g  reason: collision with root package name */
    private String f4262g;
    private int h;
    private Class<? extends PaymentProcessingActivity> i;
    private Activity j;
    private int k = -1;

    public static d a(PaymentOrderInitRequestProto paymentOrderInitRequestProto, Class<? extends PaymentProcessingActivity> cls) {
        d dVar = new d();
        dVar.f4256a = paymentOrderInitRequestProto;
        dVar.i = cls;
        return dVar;
    }

    public d a(boolean z) {
        this.f4257b = z;
        return this;
    }

    public d a(String str) {
        this.f4259d = str;
        return this;
    }

    public d a(int i2) {
        this.h = i2;
        return this;
    }

    private d b(int i2) {
        this.f4261f = i2;
        return this;
    }

    public void a(Activity activity, Bundle bundle) {
        a(activity, -1, bundle);
    }

    private void a(Activity activity, int i2, Bundle bundle) {
        this.j = activity;
        this.k = i2;
        if (a()) {
            b(1);
        }
        a(bundle);
    }

    private void a(Bundle bundle) {
        Intent a2 = a((Context) this.j);
        a2.putExtras(bundle);
        int i2 = this.k;
        if (i2 == -1) {
            this.j.startActivity(a2);
        } else {
            this.j.startActivityForResult(a2, i2);
        }
    }

    private Intent a(Context context) {
        Intent intent = new Intent(context, this.i);
        intent.putExtra("processing_info", new BPPaymentProcessingInfo(this.f4256a, this.f4257b, this.f4258c, this.f4259d, this.f4260e, this.f4261f, this.f4262g));
        return intent;
    }

    private boolean a() {
        return this.f4257b && this.h > 0;
    }
}
