package com.shopee.app.ui.sharing.sms;

import android.app.Activity;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.app.ui.sharing.base.helper.c;
import d.d.b.j;

public final class a extends com.shopee.app.ui.sharing.base.a<SmsData> {
    public boolean a(Activity activity) {
        j.b(activity, "activity");
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Activity activity, b bVar) {
        super(SmsData.class, activity, bVar);
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
    }

    /* renamed from: a */
    public boolean b(SmsData smsData) {
        j.b(smsData, "shareData");
        CharSequence text = smsData.getText();
        return !(text == null || text.length() == 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void c(SmsData smsData) {
        j.b(smsData, "shareData");
        Activity b2 = b();
        if (b2 != null) {
            a(c.a(b2, smsData.getText()));
        }
    }
}
