package com.shopee.livequiz.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.a.aa;
import com.squareup.a.ah;
import com.squareup.a.w;
import java.io.ByteArrayOutputStream;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f29835a;

    public static void a() {
        f29835a = null;
    }

    public static void a(String str, ImageView imageView, int i) {
        if (str != null && !"".equals(str)) {
            w.a(com.shopee.livequiz.b.a().c()).a(str).a(i).a(imageView);
        }
    }

    public static void b(String str, ImageView imageView, int i) {
        if (str != null && !"".equals(str)) {
            w.a(com.shopee.livequiz.b.a().c()).a(str).a().a(i).a(imageView);
        }
    }

    public static void a(String str, ImageView imageView, int i, int i2, int i3) {
        if (str != null && !"".equals(str)) {
            w.a(com.shopee.livequiz.b.a().c()).a(str).a(i, i2).b(i3).a(imageView);
        }
    }

    public static void b(String str, ImageView imageView, int i, int i2, int i3) {
        if (str != null && !"".equals(str)) {
            aa a2 = w.a(com.shopee.livequiz.b.a().c()).a(str).a(i, i2).a(i3);
            if (f29835a == null) {
                f29835a = new a();
            }
            a2.a((ah) f29835a).a(imageView);
        }
    }

    public static void a(int i, int i2, int i3, ImageView imageView) {
        aa a2 = w.a(com.shopee.livequiz.b.a().c()).a(i).a(i2, i3);
        if (f29835a == null) {
            f29835a = new a();
        }
        a2.a((ah) f29835a).a(imageView);
    }

    public static Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        return "data:image/jpeg;base64," + encodeToString;
    }

    public static class a implements ah {
        public String a() {
            return "circleImageTransformation";
        }

        public Bitmap a(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-((bitmap.getWidth() - min) / 2)), (float) (-((bitmap.getHeight() - min) / 2)));
            bitmapShader.setLocalMatrix(matrix);
            Paint paint = new Paint(1);
            paint.setShader(bitmapShader);
            Bitmap createBitmap = Bitmap.createBitmap(min, min, bitmap.getConfig());
            float f2 = (float) min;
            new Canvas(createBitmap).drawOval(new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f2, f2), paint);
            bitmap.recycle();
            return createBitmap;
        }
    }
}
