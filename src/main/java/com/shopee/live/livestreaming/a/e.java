package com.shopee.live.livestreaming.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

public abstract class e extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected View f28755a;

    /* access modifiers changed from: protected */
    public abstract int a();

    public e(Context context) {
        this(context, (AttributeSet) null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28755a = LayoutInflater.from(context).inflate(a(), this, true);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T a(int i) {
        return findViewById(i);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T a(int i, View.OnClickListener onClickListener) {
        T findViewById = this.f28755a.findViewById(i);
        findViewById.setOnClickListener(onClickListener);
        return findViewById;
    }
}
