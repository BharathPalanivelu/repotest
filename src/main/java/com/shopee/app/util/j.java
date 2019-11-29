package com.shopee.app.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.garena.android.appkit.tools.b;
import com.shopee.id.R;
import com.squareup.a.ah;

public class j implements ah {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26379a = false;

    public String a() {
        return "circle()";
    }

    public j(boolean z) {
        this.f26379a = z;
    }

    public Bitmap a(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-65536);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        if (this.f26379a) {
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            Rect rect2 = new Rect(0, (int) (height * 0.667d), bitmap.getWidth(), bitmap.getHeight());
            paint.setColor(b.a(R.color.black54));
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            canvas.drawRect(rect2, paint);
            String e2 = b.e(R.string.sp_edit);
            Paint paint2 = new Paint();
            paint2.setFlags(1);
            paint2.setColor(-1);
            paint2.setTextSize((float) b.d(R.dimen.sp12));
            canvas.drawText(e2, (((float) bitmap.getWidth()) - paint2.measureText(e2, 0, e2.length())) / 2.0f, ((float) bitmap.getHeight()) * 0.9f, paint2);
        }
        return createBitmap;
    }
}
