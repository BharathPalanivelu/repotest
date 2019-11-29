package com.shopee.app.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.garena.android.appkit.tools.b;
import com.squareup.a.ah;

public class ao implements ah {

    /* renamed from: a  reason: collision with root package name */
    private int f26159a;

    public String a() {
        return "OverlayCenterTransformation";
    }

    public ao(int i) {
        this.f26159a = i;
    }

    public Bitmap a(Bitmap bitmap) {
        return b(bitmap);
    }

    private Bitmap b(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Bitmap h = b.h(this.f26159a);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), (Paint) null);
        double width = (double) (bitmap.getWidth() - h.getWidth());
        Double.isNaN(width);
        float f2 = (float) (width / 2.0d);
        double height = (double) (bitmap.getHeight() - h.getHeight());
        Double.isNaN(height);
        bitmap.recycle();
        canvas.drawBitmap(h, f2, (float) (height / 2.0d), (Paint) null);
        return createBitmap;
    }
}
