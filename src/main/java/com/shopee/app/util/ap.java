package com.shopee.app.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.a.ah;

public class ap implements ah {

    /* renamed from: a  reason: collision with root package name */
    private int f26160a;

    public String a() {
        return "overlayTransform";
    }

    public ap(int i) {
        this.f26160a = i;
    }

    public Bitmap a(Bitmap bitmap) {
        return b(bitmap);
    }

    private Bitmap b(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Bitmap h = b.h(this.f26160a);
        if (h == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), (Paint) null);
        float height = (float) (bitmap.getHeight() - h.getHeight());
        Paint paint = new Paint();
        paint.setColor(-7829368);
        paint.setAlpha(128);
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) (bitmap.getHeight() - h.getHeight()), (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint);
        canvas.drawBitmap(h, BitmapDescriptorFactory.HUE_RED, height, (Paint) null);
        bitmap.recycle();
        return createBitmap;
    }
}
