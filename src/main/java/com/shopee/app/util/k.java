package com.shopee.app.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.a.ah;

public final class k implements ah {

    /* renamed from: a  reason: collision with root package name */
    private final int f26383a;

    public k(int i) {
        this.f26383a = i;
    }

    public String a() {
        return "transform_" + this.f26383a;
    }

    public Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        canvas.drawColor(this.f26383a, PorterDuff.Mode.SRC_ATOP);
        bitmap.recycle();
        return createBitmap;
    }
}
