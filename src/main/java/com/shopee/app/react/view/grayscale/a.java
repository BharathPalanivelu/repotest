package com.shopee.app.react.view.grayscale;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class a extends FrameLayout {
    public a(Context context) {
        super(context);
    }

    public void a(boolean z) {
        if (z) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(BitmapDescriptorFactory.HUE_RED);
            Paint paint = new Paint();
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            setLayerType(2, paint);
            return;
        }
        setLayerType(0, (Paint) null);
    }
}
