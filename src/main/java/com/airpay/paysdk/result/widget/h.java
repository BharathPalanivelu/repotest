package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.text.TextUtils;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.BPShowTicketOrderDetail;
import com.airpay.paysdk.result.widget.m;

public class h extends m {

    /* renamed from: a  reason: collision with root package name */
    private b f4505a;

    /* renamed from: b  reason: collision with root package name */
    private a f4506b;

    /* renamed from: c  reason: collision with root package name */
    private int f4507c;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    private h(Context context, b bVar, a aVar, int i) {
        super(context);
        this.f4505a = bVar;
        this.f4506b = aVar;
        this.f4507c = i;
    }

    public static h a(Context context, com.airpay.paysdk.result.bean.a aVar) {
        b bVar = new b(context, aVar);
        a aVar2 = new a(aVar);
        int t = aVar.t();
        if (!bVar.a() || !aVar2.a()) {
            return new h(context, bVar, aVar2, t);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void a() {
        String str;
        Context context = getContext();
        if (!TextUtils.isEmpty(this.f4505a.f4515a)) {
            addView(new m.c(context, context.getString(c.i.com_garena_beepay_cash_back), this.f4505a.f4515a));
        }
        if (!TextUtils.isEmpty(this.f4505a.f4516b)) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_refund_amount), this.f4505a.f4516b, c.b.color_green));
        }
        if (!TextUtils.isEmpty(this.f4505a.f4517c)) {
            addView(new m.c(context, context.getString(c.i.com_garena_beepay_label_refund_charge), this.f4505a.f4517c));
        }
        if (!TextUtils.isEmpty(this.f4505a.f4518d) && this.f4507c == 0) {
            addView(new m.a(context, context.getString(c.i.com_garena_beepay_label_promotion), this.f4505a.f4518d));
        }
        if (!TextUtils.isEmpty(this.f4506b.f4508a)) {
            addView(new m.c(context, context.getString(c.i.com_garena_beepay_label_transaction_ref), this.f4506b.f4508a));
        }
        if (!TextUtils.isEmpty(this.f4506b.f4509b)) {
            addView(new m.c(context, this.f4506b.f4510c, this.f4506b.f4509b));
        }
        if (!TextUtils.isEmpty(this.f4506b.f4511d)) {
            addView(new m.c(context, this.f4506b.f4512e, this.f4506b.f4511d));
        }
        if (this.f4506b.f4513f != null) {
            if (TextUtils.isEmpty(this.f4506b.h)) {
                str = context.getString(c.i.com_garena_beepay_label_booking_id);
            } else {
                str = context.getString(c.i.com_garena_beepay_show_booking_id, new Object[]{this.f4506b.h});
            }
            addView(new m.c(context, str, String.valueOf(this.f4506b.f4513f.f4449b)));
        }
        if (!TextUtils.isEmpty(this.f4506b.i)) {
            addView(new m.c(context, context.getString(c.i.com_garena_beepay_loan_id_no_colon), this.f4506b.i));
        }
        if (this.f4506b.j != null) {
            addView(new m.c(context, context.getString(c.i.com_garena_beepay_label_booking_id), String.valueOf(this.f4506b.j.f4485b)));
        }
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f4515a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f4516b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f4517c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f4518d;

        public b(Context context, com.airpay.paysdk.result.bean.a aVar) {
            this.f4515a = aVar.c();
            this.f4516b = aVar.d();
            this.f4517c = aVar.e();
            this.f4518d = aVar.a(context);
        }

        public boolean a() {
            return TextUtils.isEmpty(this.f4515a) && TextUtils.isEmpty(this.f4516b) && TextUtils.isEmpty(this.f4518d);
        }
    }

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f4508a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f4509b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f4510c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f4511d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f4512e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public BPShowTicketOrderDetail f4513f;

        /* renamed from: g  reason: collision with root package name */
        private int f4514g;
        /* access modifiers changed from: private */
        public String h = null;
        /* access modifiers changed from: private */
        public String i;
        /* access modifiers changed from: private */
        public com.airpay.paysdk.result.bean.c j;

        public a(com.airpay.paysdk.result.bean.a aVar) {
            int t = aVar.t();
            this.f4508a = aVar.f();
            this.f4510c = aVar.i();
            if (com.airpay.paysdk.pay.b.a.u(aVar.q().getExtraData()) == 1) {
                this.f4510c = com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_payment_transaction_id);
            }
            this.f4511d = aVar.q().getTopupChannelTxnId();
            this.f4512e = aVar.g();
            this.f4513f = aVar.h();
            this.f4514g = aVar.r();
            int i2 = this.f4514g;
            if (i2 == 21020) {
                this.i = aVar.q().getTopupAccountId();
            } else if (i2 != 21021) {
                this.i = null;
            } else {
                this.i = aVar.A();
            }
            this.j = aVar.E();
            if (!(t == 4 || this.f4514g == 21007)) {
                this.f4509b = aVar.j();
            }
            if (aVar.o() != null) {
                this.h = aVar.o().h();
            }
        }

        public boolean a() {
            return TextUtils.isEmpty(this.f4508a) && TextUtils.isEmpty(this.f4509b) && TextUtils.isEmpty(this.f4511d) && this.f4513f == null && TextUtils.isEmpty(this.i) && this.j == null;
        }
    }
}
