package com.shopee.livequiz.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@SuppressLint({"AppCompatCustomView"})
public class ScaleXImageView extends ImageView {
    public ScaleXImageView(Context context) {
        super(context);
    }

    public ScaleXImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScaleXImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (getScaleType() == ImageView.ScaleType.MATRIX) {
            a();
        }
        return frame;
    }

    private void a() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Matrix imageMatrix = getImageMatrix();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            float f2 = width / intrinsicWidth;
            float f3 = height / intrinsicHeight;
            float f4 = width / height;
            float f5 = intrinsicWidth / intrinsicHeight;
            if (width <= height ? f4 < f5 : f4 <= f5) {
                f2 = f3;
            }
            imageMatrix.setScale(f2, f2, (((intrinsicWidth * f2) - width) / 2.0f) / (f2 - 1.0f), BitmapDescriptorFactory.HUE_RED);
            setImageMatrix(imageMatrix);
        }
    }
}
