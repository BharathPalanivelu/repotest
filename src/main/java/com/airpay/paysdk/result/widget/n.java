package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.text.TextUtils;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.c;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

public class n extends m {

    /* renamed from: a  reason: collision with root package name */
    private a f4538a;

    /* renamed from: b  reason: collision with root package name */
    private com.airpay.paysdk.result.a f4539b;

    /* renamed from: c  reason: collision with root package name */
    private String f4540c;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    private n(Context context, a aVar, com.airpay.paysdk.result.a aVar2, String str) {
        super(context);
        this.f4538a = aVar;
        this.f4539b = aVar2;
        this.f4540c = str;
    }

    public static n a(Context context, a aVar) {
        int r = aVar.r();
        if (r != 21001 && r != 21000) {
            return null;
        }
        com.airpay.paysdk.result.a a2 = a(aVar.q());
        String b2 = b(aVar.q());
        if (a2 != null || !TextUtils.isEmpty(b2)) {
            return new n(context, aVar, a2, b2);
        }
        return null;
    }

    private static com.airpay.paysdk.result.a a(BPOrderInfo bPOrderInfo) {
        return com.airpay.paysdk.pay.b.a.a(bPOrderInfo.getExtraData(), bPOrderInfo.getPaymentChannelId() == 21001);
    }

    private static String b(BPOrderInfo bPOrderInfo) {
        return com.airpay.paysdk.pay.b.a.c(bPOrderInfo.getExtraData(), bPOrderInfo.getPaymentChannelId() == 21001);
    }

    /* access modifiers changed from: protected */
    public void a() {
        int r = this.f4538a.r();
        if (r == 21001) {
            if (this.f4539b != null) {
                addView(new m.b(getContext(), getResources().getString(c.i.com_garena_beepay_label_recipient), "", this.f4539b.b(), this.f4539b.a()));
            }
            if (!TextUtils.isEmpty(this.f4540c)) {
                addView(new m.c(getContext(), getResources().getString(c.i.com_garena_beepay_label_whats_it_for), this.f4540c));
            }
        } else if (r == 21000) {
            if (this.f4539b != null) {
                Context context = getContext();
                String string = getResources().getString(c.i.com_garena_beepay_label_sender);
                addView(new m.c(context, string, this.f4539b.b() + this.f4539b.a()));
            }
            if (!TextUtils.isEmpty(this.f4540c)) {
                addView(new m.c(getContext(), getResources().getString(c.i.com_garena_beepay_label_whats_it_for), this.f4540c));
            }
        }
    }
}
