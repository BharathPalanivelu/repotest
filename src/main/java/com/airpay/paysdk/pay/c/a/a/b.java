package com.airpay.paysdk.pay.c.a.a;

import android.content.Context;
import android.text.Spanned;
import com.airpay.paysdk.base.bean.BPTopupChannelWithEvents;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.c.a.a.a;

public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4180b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4181c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4182d;

    /* renamed from: e  reason: collision with root package name */
    private final BPTopupChannelWithEvents f4183e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4184f = true;

    public BPTopupChannelWithEvents a() {
        return null;
    }

    public int b() {
        return 0;
    }

    public b(long j, BPTopupChannelWithEvents bPTopupChannelWithEvents, boolean z, boolean z2, boolean z3, int i, int i2) {
        super(z3, i, i2);
        this.f4182d = j;
        this.f4180b = z;
        this.f4181c = z2;
        this.f4183e = bPTopupChannelWithEvents;
    }

    /* access modifiers changed from: protected */
    public a.C0082a a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        Context context2 = context;
        String string = context2.getString(c.i.com_garena_beepay_label_cash);
        int k = com.airpay.paysdk.base.different.a.a().k();
        if (!this.f4184f) {
            k = c.d.icon_payment_cash_page_gray_th;
        }
        int i = k;
        String b2 = com.airpay.paysdk.pay.b.b((double) this.f4182d);
        BPTopupChannelWithEvents bPTopupChannelWithEvents = this.f4183e;
        boolean z = bPTopupChannelWithEvents == null || bPTopupChannelWithEvents.isAvailable();
        BPTopupChannelWithEvents bPTopupChannelWithEvents2 = this.f4183e;
        if (bPTopupChannelWithEvents2 == null || bPTopupChannelWithEvents2.getTopupAmountInfo() == null || ((!this.f4180b && this.f4181c) || !this.f4184f)) {
            str4 = "";
            str3 = str4;
            str2 = str3;
            str = str2;
        } else {
            long j = this.f4183e.getTopupAmountInfo().fee;
            long j2 = this.f4183e.getTopupAmountInfo().newFee;
            long j3 = this.f4183e.getTopupAmountInfo().discount;
            String c2 = com.airpay.paysdk.base.b.c.a().c();
            Spanned a2 = f.a(context, j, j2, c2, true);
            String a3 = f.a(context2, j3, c2);
            String a4 = f.a(context2, this.f4183e.getRebateText());
            String a5 = f.a(context2, this.f4183e.getEvent());
            str3 = a2;
            str2 = a3;
            str4 = a4;
            str = a5;
        }
        return new a.C0082a(string, "", i, b2, str3, str2, str4, str, this.f4180b ? c.d.com_garena_beepay_circular_checkbox_selector : c.d.com_garena_beepay_square_checkbox_selector, z);
    }

    public boolean c() {
        return this.f4184f;
    }
}
