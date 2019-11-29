package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class g extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f3941a;

    public g(Context context) {
        super(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setRequestHash(String str) {
        this.f3941a = str;
    }
}
