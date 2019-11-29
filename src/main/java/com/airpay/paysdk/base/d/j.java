package com.airpay.paysdk.base.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Pair;
import com.airpay.paysdk.c;
import com.airpay.paysdk.common.c.b;
import com.google.zxing.ac;
import com.google.zxing.c;
import com.google.zxing.e.a.f;
import com.google.zxing.l;
import com.google.zxing.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class j {

    public interface b {
        void a(String str, String str2, Bitmap bitmap, boolean z);
    }

    public static void a(Activity activity, String str, boolean z, b bVar) {
        final String a2 = a(str);
        final WeakReference weakReference = new WeakReference(bVar);
        final Activity activity2 = activity;
        final String str2 = str;
        final boolean z2 = z;
        com.airpay.paysdk.common.c.b.a(b.c.CACHE).execute(new Runnable() {
            public void run() {
                final Bitmap a2 = j.b(activity2, str2, a2, z2);
                com.airpay.paysdk.common.c.a.a().a(new Runnable() {
                    public void run() {
                        b bVar = (b) weakReference.get();
                        if (bVar != null) {
                            bVar.a(str2, a2, a2, false);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static Bitmap b(Activity activity, String str, String str2, boolean z) {
        p pVar = new p();
        int length = str.length() * 11 * l.a(activity, 2.0f);
        int a2 = l.a(activity, 2.0f) * 11 * 3;
        HashMap hashMap = new HashMap();
        hashMap.put(l.CHARACTER_SET, "UTF-8");
        try {
            return a(pVar.a(str, c.CODE_128, length, a2, hashMap));
        } catch (Exception e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            com.airpay.paysdk.base.b.a.a().a((Context) activity, c.i.com_garena_beepay_error_generating_barcode);
            return null;
        }
    }

    public static void a(Activity activity, String str, Bitmap bitmap, boolean z, b bVar) {
        final WeakReference weakReference = new WeakReference(bVar);
        final String str2 = str;
        final Bitmap bitmap2 = bitmap;
        final Activity activity2 = activity;
        final boolean z2 = z;
        com.airpay.paysdk.common.c.b.a(b.c.CACHE).execute(new Runnable() {
            public void run() {
                String a2 = j.a(str2, bitmap2);
                final Pair pair = new Pair(j.b(activity2, str2, a2, bitmap2, z2), a2);
                com.airpay.paysdk.common.c.a.a().a(new Runnable() {
                    public void run() {
                        b bVar = (b) weakReference.get();
                        if (bVar != null) {
                            bVar.a(str2, (String) pair.second, (Bitmap) pair.first, true);
                        }
                    }
                });
            }
        });
    }

    private static Bitmap a(com.google.zxing.c.b bVar) {
        int c2 = bVar.c();
        int d2 = bVar.d();
        int i = c2 - 1;
        int i2 = 0;
        boolean z = false;
        for (int i3 = 0; i3 < c2; i3++) {
            if (bVar.a(i3, 0)) {
                if (!z) {
                    i2 = i3;
                    z = true;
                }
                i = i3;
            }
        }
        int i4 = (i - i2) + 1;
        Bitmap createBitmap = Bitmap.createBitmap(i4, d2, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[(i4 * d2)];
        for (int i5 = 0; i5 < d2; i5++) {
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[(i5 * i4) + i6] = bVar.a(i6 + i2, i5) ? -16777216 : -1;
            }
        }
        createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, d2);
        return createBitmap;
    }

    private static void a(Bitmap bitmap, com.google.zxing.c.b bVar) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                iArr[(i * width) + i2] = bVar.a(i2, i) ? -16777216 : -1;
            }
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final boolean f3822a;

        /* renamed from: b  reason: collision with root package name */
        final com.google.zxing.c.b f3823b;

        /* renamed from: c  reason: collision with root package name */
        final Bitmap f3824c;

        public a(boolean z, com.google.zxing.c.b bVar, Bitmap bitmap) {
            this.f3822a = z;
            this.f3823b = bVar;
            this.f3824c = bitmap;
        }
    }

    private static a a(p pVar, String str, Map<l, Object> map, int i) {
        int i2 = 1;
        while (i2 < 4) {
            int i3 = i / i2;
            try {
                return new a(true, pVar.a(str, com.google.zxing.c.QR_CODE, i3, i3, map), Bitmap.createBitmap(i3, i3, i2 <= 1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ARGB_4444));
            } catch (ac | OutOfMemoryError e2) {
                com.airpay.paysdk.common.b.a.a(e2);
                i2++;
            }
        }
        return new a(false, (com.google.zxing.c.b) null, (Bitmap) null);
    }

    /* access modifiers changed from: private */
    public static Bitmap b(Activity activity, String str, String str2, Bitmap bitmap, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.airpay.paysdk.base.b.a.a().a((Context) activity, c.i.com_garena_beepay_error_invalid_qr_code);
            return null;
        }
        p pVar = new p();
        int a2 = l.a(activity, 180.0f);
        HashMap hashMap = new HashMap();
        hashMap.put(l.ERROR_CORRECTION, bitmap == null ? f.M : f.H);
        hashMap.put(l.MARGIN, 0);
        a a3 = a(pVar, str, (Map<l, Object>) hashMap, a2);
        if (!a3.f3822a || a3.f3824c == null || a3.f3823b == null) {
            com.airpay.paysdk.base.b.a.a().a((Context) activity, c.i.com_garena_beepay_error_generating_qr_code);
            return null;
        }
        com.google.zxing.c.b bVar = a3.f3823b;
        Bitmap bitmap2 = a3.f3824c;
        a(bitmap2, bVar);
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap2);
            float width = (((float) bitmap2.getWidth()) - (((float) bitmap2.getWidth()) * 0.3f)) / 2.0f;
            float height = (((float) bitmap2.getHeight()) - (((float) bitmap2.getHeight()) * 0.3f)) / 2.0f;
            RectF rectF = new RectF(width, height, ((float) bitmap2.getWidth()) - width, ((float) bitmap2.getHeight()) - height);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-1);
            paint.setStrokeWidth((float) l.a(activity, 4.0f));
            canvas.drawRoundRect(rectF, (float) l.a(activity, 10.0f), (float) l.a(activity, 10.0f), paint);
        }
        return bitmap2;
    }

    public static String a(String str, Bitmap bitmap) {
        return a.a("qrcode_" + str + "_" + a.a(bitmap));
    }

    private static String a(String str) {
        return a.a("barcode_" + str);
    }
}
