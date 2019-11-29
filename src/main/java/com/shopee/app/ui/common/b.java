package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.auth.AuthTabActivity_;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f21224a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21225b;

    /* renamed from: c  reason: collision with root package name */
    Button f21226c;

    public b(Context context) {
        super(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(int i, int i2) {
        this.f21224a.setText(i);
        this.f21225b.setImageResource(i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AuthTabActivity_.a(getContext()).b(0).a(1);
    }
}
