package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.text.TextUtils;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.result.bean.a;
import com.airpay.paysdk.result.widget.m;

public class c extends m {

    /* renamed from: a  reason: collision with root package name */
    private a f4500a;

    /* access modifiers changed from: protected */
    public int getBottomDividerStatus() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getTopDividerStatus() {
        return 0;
    }

    private c(Context context, a aVar) {
        super(context);
        this.f4500a = aVar;
    }

    public static c a(Context context, a aVar) {
        ChannelInfo a2 = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(aVar.r()));
        if (a2 == null || a2.b() != 10013) {
            return null;
        }
        return new c(context, aVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        Context context = getContext();
        if (!TextUtils.isEmpty(this.f4500a.B())) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_donor_name_hint), (CharSequence) this.f4500a.B(), c.b.txt_color_dark_less));
        }
        if (!TextUtils.isEmpty(this.f4500a.C())) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_donor_id), (CharSequence) f.b(this.f4500a.C(), 4, false), c.b.txt_color_dark_less));
        }
        if (!TextUtils.isEmpty(this.f4500a.D())) {
            addView(new m.c(context, (CharSequence) context.getString(c.i.com_garena_beepay_label_donor_address_hint), (CharSequence) f.a(this.f4500a.D(), 0.5f, false), c.b.txt_color_dark_less));
        }
    }
}
