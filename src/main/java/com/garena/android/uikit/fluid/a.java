package com.garena.android.uikit.fluid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f7727a;

    /* renamed from: b  reason: collision with root package name */
    private int f7728b;

    /* renamed from: c  reason: collision with root package name */
    private int f7729c;

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int resolveSize = resolveSize(this.f7729c, i);
        int i3 = paddingLeft;
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), childAt.getLayoutParams().width), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i4 = Math.max(measuredHeight, i4);
                if (measuredWidth + i3 + getPaddingRight() > resolveSize) {
                    i3 = getPaddingLeft();
                    paddingTop += this.f7727a + i4;
                    i4 = measuredHeight;
                }
                i3 += measuredWidth + this.f7728b;
            }
        }
        setMeasuredDimension(resolveSize, resolveSize(0 + paddingTop + i4 + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingTop = getPaddingTop();
        int i6 = paddingLeft;
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i7 = Math.max(measuredHeight, i7);
                if (measuredWidth + i6 + getPaddingRight() > i5) {
                    i6 = getPaddingLeft();
                    paddingTop += this.f7727a + i7;
                    i7 = measuredHeight;
                }
                childAt.layout(i6, paddingTop, i6 + measuredWidth, measuredHeight + paddingTop);
                i6 += measuredWidth + this.f7728b;
            }
        }
    }

    public void setMinWidth(int i) {
        this.f7729c = i;
    }

    public void setLineMargin(int i) {
        this.f7727a = i;
    }

    public void setChildPadding(int i) {
        this.f7728b = i;
    }
}
