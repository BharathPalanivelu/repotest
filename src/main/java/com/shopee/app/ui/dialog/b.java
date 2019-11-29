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

public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f21532a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21533b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21534c;

    /* renamed from: d  reason: collision with root package name */
    RelativeLayout f21535d;

    /* renamed from: e  reason: collision with root package name */
    private long f21536e;

    /* renamed from: f  reason: collision with root package name */
    private String f21537f;

    public b(Context context) {
        super(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21533b.setText(au.a(this.f21536e, this.f21537f));
        au.a((EditText) this.f21532a);
        e.a((EditText) this.f21532a);
    }

    public long getPrice() {
        String c2 = e.c(this.f21532a.getText().toString());
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
        this.f21536e = j;
    }

    public void setCurrency(String str) {
        this.f21537f = str;
    }

    public void a(String str, String str2, long j, int i) {
        if (TextUtils.isEmpty(str)) {
            this.f21534c.setVisibility(8);
        } else {
            this.f21534c.setVisibility(0);
            this.f21534c.setText(str);
        }
        this.f21532a.setText(e.a(j, "IDR", true));
        this.f21533b.setText(str2);
        this.f21535d.setBackgroundColor(com.garena.android.appkit.tools.b.a(i));
    }

    public void b(String str, String str2, long j, int i) {
        a(str, str2, j, i);
        e.a((EditText) this.f21532a, ar.f().e().settingConfigStore());
    }
}
