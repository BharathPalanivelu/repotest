package com.airpay.paysdk.result.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class BPFloatingLayerLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f4495a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f4496b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f4497c = new int[2];

    /* renamed from: d  reason: collision with root package name */
    private int[] f4498d = new int[2];

    public BPFloatingLayerLayout(Context context) {
        super(context);
    }

    public BPFloatingLayerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAnchor(int i) {
        this.f4495a = findViewById(i);
        if (this.f4495a == null) {
            throw new RuntimeException("anchor view is not found");
        }
    }

    public void a() {
        LinearLayout linearLayout = this.f4496b;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4496b != null) {
            ViewGroup.LayoutParams layoutParams = this.f4495a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.f4496b.getMeasuredHeight();
            }
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b();
        super.onLayout(z, i, i2, i3, i4);
    }

    public void b() {
        View view = this.f4495a;
        if (view != null && this.f4496b != null) {
            view.getLocationOnScreen(this.f4498d);
            getLocationOnScreen(this.f4497c);
            int height = (this.f4497c[1] + getHeight()) - (this.f4498d[1] + this.f4495a.getHeight());
            int i = 0;
            if (height > this.f4496b.getHeight()) {
                i = height - this.f4496b.getHeight();
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4496b.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.f4496b.setLayoutParams(layoutParams);
        }
    }
}
