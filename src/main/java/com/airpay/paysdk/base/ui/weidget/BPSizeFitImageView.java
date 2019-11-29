package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.airpay.paysdk.c;

public class BPSizeFitImageView extends g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3882a = true;

    public BPSizeFitImageView(Context context) {
        super(context);
    }

    public BPSizeFitImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public BPSizeFitImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BPSizeFitImageView);
            this.f3882a = obtainStyledAttributes.getBoolean(c.k.BPSizeFitImageView_fixed_width, this.f3882a);
            obtainStyledAttributes.recycle();
        }
    }

    public void setIsWidthFixed(boolean z) {
        this.f3882a = z;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
            if (this.f3882a) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i)) / intrinsicWidth), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i2)) * intrinsicWidth), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }
}
