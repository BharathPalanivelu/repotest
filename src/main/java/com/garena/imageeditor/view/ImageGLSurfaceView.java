package com.garena.imageeditor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import jp.co.cyberagent.android.gpuimage.a;

public class ImageGLSurfaceView extends a {

    /* renamed from: a  reason: collision with root package name */
    private float f8119a;

    public ImageGLSurfaceView(Context context) {
        super(context);
    }

    public ImageGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f8119a != BitmapDescriptorFactory.HUE_RED) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            float f2 = (float) size;
            float f3 = this.f8119a;
            float f4 = (float) size2;
            if (f2 / f3 < f4) {
                size2 = Math.round(f2 / f3);
            } else {
                size = Math.round(f4 * f3);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(float f2) {
        this.f8119a = f2;
    }

    public float getRatio() {
        return this.f8119a;
    }
}
