package com.shopee.app.ui.order.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class e extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f23878a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23879b;

    /* renamed from: c  reason: collision with root package name */
    TextView f23880c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23881d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23882e;

    /* renamed from: f  reason: collision with root package name */
    TextView f23883f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23884g;
    TextView h;
    TextView i;
    TextView j;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public e(Context context) {
        super(context);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOrderNumber(String str) {
        this.f23878a.setText(str);
    }

    public void setOrderTime(String str) {
        this.f23879b.setText(str);
    }

    public void setOrderPaymentTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23881d.setVisibility(0);
            this.f23880c.setVisibility(0);
            this.f23880c.setText(str);
            return;
        }
        this.f23881d.setVisibility(8);
        this.f23880c.setVisibility(8);
    }

    public void setOrderDeliverTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23882e.setVisibility(0);
            this.f23883f.setVisibility(0);
            this.f23882e.setText(str);
            return;
        }
        this.f23882e.setVisibility(8);
        this.f23883f.setVisibility(8);
    }

    public void setOrderCompleteTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f23884g.setVisibility(0);
            this.h.setVisibility(0);
            this.f23884g.setText(str);
            return;
        }
        this.f23884g.setVisibility(8);
        this.h.setVisibility(8);
    }

    public void setOrderCancelTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.i.setText(str);
            return;
        }
        this.i.setVisibility(8);
        this.j.setVisibility(8);
    }
}
