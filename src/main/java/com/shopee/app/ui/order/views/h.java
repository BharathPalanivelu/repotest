package com.shopee.app.ui.order.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class h extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f23892a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23893b;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public h(Context context) {
        super(context);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLabel(String str) {
        this.f23892a.setText(str);
    }

    public void setRemark(CharSequence charSequence) {
        this.f23893b.setText(charSequence);
    }
}
