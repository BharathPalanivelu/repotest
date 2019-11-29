package com.airpay.paysdk.pay.c.a.a;

import android.content.Context;
import android.text.Spanned;
import com.airpay.paysdk.base.bean.BPTopupAmountInfo;
import com.airpay.paysdk.base.bean.BPTopupChannelWithEvents;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.b;
import com.airpay.paysdk.pay.c.a.a.a;
import com.airpay.paysdk.qrcode.model.BankAccountFullInfo;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private BPTopupChannelWithEvents f4185b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4186c;

    /* renamed from: d  reason: collision with root package name */
    private long f4187d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4188e = true;

    public int b() {
        return 1;
    }

    public c(BPTopupChannelWithEvents bPTopupChannelWithEvents, boolean z, int i, int i2, boolean z2, long j) {
        super(z, i, i2);
        this.f4185b = bPTopupChannelWithEvents;
        this.f4163a = z;
        this.f4186c = z2;
        this.f4187d = j;
    }

    /* access modifiers changed from: protected */
    public a.C0082a a(Context context) {
        int i;
        String str;
        String str2;
        Spanned spanned;
        String str3;
        String str4;
        String str5;
        String str6;
        Context context2 = context;
        BankAccountFullInfo bankAccountInfo = this.f4185b.getBankAccountInfo();
        if (bankAccountInfo.f()) {
            if (bankAccountInfo.g()) {
                String g2 = com.airpay.paysdk.pay.b.a.g(bankAccountInfo.d().l);
                char c2 = 65535;
                switch (g2.hashCode()) {
                    case 47665:
                        if (g2.equals("001")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 47666:
                        if (g2.equals("002")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 47671:
                        if (g2.equals("007")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                i = c2 != 0 ? c2 != 1 ? c2 != 2 ? this.f4188e ? c.d.com_garena_beepay_logo_payment_unknown : c.d.com_garena_beepay_logo_payment_unknown_grey : this.f4188e ? c.d.com_garena_beepay_logo_payment_jcb : c.d.com_garena_beepay_logo_payment_jcb_grey : this.f4188e ? c.d.com_garena_beepay_logo_payment_master : c.d.com_garena_beepay_logo_payment_master_grey : this.f4188e ? c.d.com_garena_beepay_logo_payment_visa : c.d.com_garena_beepay_logo_payment_visa_grey;
            } else {
                i = this.f4188e ? f.a(bankAccountInfo.a()) : f.b(bankAccountInfo.a());
            }
        } else if (bankAccountInfo.e() == null) {
            i = this.f4188e ? c.d.com_garena_beepay_logo_payment_unknown : c.d.com_garena_beepay_logo_payment_unknown_grey;
        } else if (bankAccountInfo.e().b() != 101) {
            i = this.f4188e ? c.d.com_garena_beepay_logo_payment_unknown : c.d.com_garena_beepay_logo_payment_unknown_grey;
        } else {
            i = this.f4188e ? c.d.com_garena_beepay_logo_payment_711 : c.d.com_garena_beepay_logo_payment_711_grey;
        }
        int i2 = i;
        if (bankAccountInfo.e() == null || bankAccountInfo.e().b() != 101 || !this.f4188e) {
            str = "";
        } else {
            str = context2.getString(c.i.com_garena_beepay_label_pay_seven_eleven);
        }
        String a2 = f.a(bankAccountInfo.d() == null ? -1 : bankAccountInfo.d().f4355a, bankAccountInfo.a(), true, true);
        BPTopupAmountInfo topupAmountInfo = this.f4185b.getTopupAmountInfo();
        if (topupAmountInfo == null || !this.f4188e) {
            str5 = "";
            str4 = str5;
            str3 = str4;
            spanned = str3;
            str2 = spanned;
        } else {
            long j = topupAmountInfo.fee;
            long j2 = topupAmountInfo.newFee;
            long j3 = topupAmountInfo.discount;
            if (bankAccountInfo.e() == null) {
                str6 = b.b();
            } else {
                str6 = bankAccountInfo.e().c();
            }
            String str7 = str6;
            Spanned a3 = f.a(context, j, j2, str7, true);
            str5 = f.a(context2, j3, str7);
            str4 = f.a(context2, this.f4185b.getRebateText());
            String a4 = f.a(context2, this.f4185b.getEvent());
            long j4 = topupAmountInfo.topupPayment;
            if (this.f4186c) {
                j4 = topupAmountInfo.topupPayment - this.f4187d;
                if (j4 < 0) {
                    j4 = 0;
                }
            }
            spanned = a3;
            str2 = a4;
            str3 = b.b((double) j4);
        }
        BPTopupChannelWithEvents bPTopupChannelWithEvents = this.f4185b;
        return new a.C0082a(a2, str, i2, str3, spanned, str5, str4, str2, c.d.com_garena_beepay_circular_checkbox_selector, bPTopupChannelWithEvents == null || bPTopupChannelWithEvents.isAvailable());
    }

    public BPTopupChannelWithEvents a() {
        return this.f4185b;
    }

    public boolean c() {
        return this.f4188e;
    }
}
