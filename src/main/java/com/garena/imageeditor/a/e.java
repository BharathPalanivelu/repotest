package com.garena.imageeditor.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.squareup.a.ah;

public class e implements ah {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8093a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8094b = false;

    public e(boolean z, boolean z2) {
        this.f8093a = z;
        this.f8094b = z2;
    }

    public Bitmap a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        float f2 = -1.0f;
        float f3 = this.f8093a ? -1.0f : 1.0f;
        if (!this.f8094b) {
            f2 = 1.0f;
        }
        matrix.preScale(f3, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        createBitmap.setDensity(160);
        bitmap.recycle();
        return createBitmap;
    }

    public String a() {
        return "flip" + this.f8093a + this.f8094b;
    }
}
