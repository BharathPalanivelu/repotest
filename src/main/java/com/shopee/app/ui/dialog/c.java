package com.shopee.app.ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.d.a;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.application.ar;
import com.shopee.app.g.e;
import com.shopee.app.ui.common.d;
import com.shopee.app.util.au;
import java.math.BigDecimal;

public class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f21538a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21539b;

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f21540c;

    /* renamed from: d  reason: collision with root package name */
    private long f21541d;

    /* renamed from: e  reason: collision with root package name */
    private String f21542e;

    public c(Context context) {
        super(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21539b.setText(au.a(this.f21541d, this.f21542e));
        au.a((EditText) this.f21538a);
        e.a((EditText) this.f21538a);
        e.a((EditText) this.f21538a, ar.f().e().settingConfigStore());
    }

    public long getPrice() {
        String c2 = e.c(this.f21538a.getText().toString());
        try {
            if (TextUtils.isEmpty(c2) || c2.equals(".")) {
                c2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            return new BigDecimal(c2).multiply(d.f7008b).longValue();
        } catch (Exception e2) {
            a.a(e2);
            return 0;
        }
    }

    public void setPrice(long j) {
        this.f21541d = j;
    }

    public void setCurrency(String str) {
        this.f21542e = str;
    }

    public void a(String str, long j) {
        this.f21538a.setText(e.a(j, "IDR", true));
        this.f21539b.setText(str);
    }

    public void setEditable(boolean z) {
        this.f21538a.setEnabled(z);
    }
}
