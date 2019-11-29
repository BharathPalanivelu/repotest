package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class e extends a {
    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i) {
    }

    e(f fVar, d dVar) {
        super(fVar, dVar);
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }
}
