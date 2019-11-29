package com.shopee.live.livestreaming.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class b extends ConstraintLayout {

    /* renamed from: g  reason: collision with root package name */
    protected View f28749g;

    /* access modifiers changed from: protected */
    public abstract int b();

    public b(Context context) {
        super(context);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28749g = LayoutInflater.from(context).inflate(b(), this, true);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T b(int i) {
        return this.f28749g.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T a(int i, View.OnClickListener onClickListener) {
        T findViewById = this.f28749g.findViewById(i);
        findViewById.setOnClickListener(onClickListener);
        return findViewById;
    }
}
