package com.shopee.app.ui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.a;
import d.a.d;
import d.d.b.j;

public final class RotatingViewGroup extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final int f22726a;

    public RotatingViewGroup(Context context) {
        this(context, (AttributeSet) null, 2, (g) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RotatingViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.b(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.b.RotatingViewGroup, 0, 0);
        try {
            this.f22726a = obtainStyledAttributes.getInt(0, 0);
            if (!d.a((T[]) new Integer[]{0, 90, 180, 270}, Integer.valueOf(this.f22726a))) {
                throw new IllegalArgumentException("rotation must be 0, 90, 180 or 270");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RotatingViewGroup(Context context, AttributeSet attributeSet, int i, g gVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View childAt = getChildAt(0);
        j.a((Object) childAt, "child");
        if (childAt.getVisibility() != 8) {
            int i3 = this.f22726a;
            if (i3 != 0) {
                if (i3 != 90) {
                    if (i3 != 180) {
                        if (i3 != 270) {
                            return;
                        }
                    }
                }
                measureChild(childAt, i2, i);
                setMeasuredDimension(childAt.getMeasuredHeightAndState(), childAt.getMeasuredWidthAndState());
                return;
            }
            measureChild(childAt, i, i2);
            setMeasuredDimension(childAt.getMeasuredWidthAndState(), childAt.getMeasuredHeightAndState());
            return;
        }
        setMeasuredDimension(View.resolveSizeAndState(0, i, 0), View.resolveSizeAndState(0, i2, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        j.a((Object) childAt, "child");
        if (childAt.getVisibility() != 8) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            int i7 = this.f22726a;
            if (i7 == 0) {
                childAt.layout(0, 0, i5, i6);
            } else if (i7 == 90) {
                childAt.setPivotX(BitmapDescriptorFactory.HUE_RED);
                childAt.setPivotY(BitmapDescriptorFactory.HUE_RED);
                childAt.setRotation(90.0f);
                childAt.layout(i5, 0, i6 + i5, i5);
            } else if (i7 == 180) {
                childAt.setPivotX(BitmapDescriptorFactory.HUE_RED);
                childAt.setPivotY(BitmapDescriptorFactory.HUE_RED);
                childAt.setRotation(180.0f);
                childAt.layout(i5, i6, i5 * 2, i6 * 2);
            } else if (i7 == 270) {
                childAt.setPivotX(BitmapDescriptorFactory.HUE_RED);
                childAt.setPivotY(BitmapDescriptorFactory.HUE_RED);
                childAt.setRotation(-90.0f);
                childAt.layout(0, i6, i6, i5 + i6);
            }
        }
    }
}
