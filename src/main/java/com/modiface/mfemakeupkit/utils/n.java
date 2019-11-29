package com.modiface.mfemakeupkit.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.PrintWriter;
import java.io.StringWriter;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15384a = "MFEGeneralUtil";

    public static boolean a() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public static void a(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static Bitmap a(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            Log.w(f15384a, "Bitmap config is null. Setting it to default ARGB_8888");
            config = Bitmap.Config.ARGB_8888;
        }
        if (i <= 0) {
            throw new IllegalArgumentException("width must be > 0: given " + i);
        } else if (i2 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
            if (createBitmap != null) {
                return createBitmap;
            }
            throw new OutOfMemoryError("Echoing silent out of memory error");
        } else {
            throw new IllegalArgumentException("height must be > 0: given " + i2);
        }
    }

    public static int a(Context context, int i) {
        return Math.round(((float) i) * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public static RectF a(float f2, float f3, float f4, float f5) {
        if (Math.round(f2) <= 0 || Math.round(f3) <= 0 || Math.round(f4) <= 0 || Math.round(f5) <= 0) {
            return new RectF();
        }
        float f6 = f4 / f5;
        if (f2 / f3 >= f6) {
            float f7 = f6 * f3;
            float f8 = (f2 - f7) / 2.0f;
            return new RectF(f8, BitmapDescriptorFactory.HUE_RED, f7 + f8, f3);
        }
        float f9 = f2 / f6;
        float f10 = (f3 - f9) / 2.0f;
        return new RectF(BitmapDescriptorFactory.HUE_RED, f10, f2, f9 + f10);
    }

    public static Rect a(int i, int i2, int i3, int i4) {
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0) {
            return new Rect();
        }
        float f2 = ((float) i) / ((float) i2);
        float f3 = (float) i3;
        float f4 = (float) i4;
        if (f2 >= f3 / f4) {
            int round = Math.round(f3 / f2);
            int i5 = (i4 - round) / 2;
            return new Rect(0, i5, i3, round + i5);
        }
        int round2 = Math.round(f4 * f2);
        int i6 = (i3 - round2) / 2;
        return new Rect(i6, 0, round2 + i6, i4);
    }

    public static float[] a(RectF rectF, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Cannot convert rect to texture coordinate when the width or height is less than or equal to zero");
        }
        float f2 = (float) i;
        float f3 = rectF.left / f2;
        float f4 = (float) i2;
        float f5 = rectF.top / f4;
        float f6 = rectF.right / f2;
        float f7 = rectF.bottom / f4;
        return new float[]{f3, f7, f6, f7, f3, f5, f6, f5};
    }

    public static float[] a(Rect rect, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Cannot convert rect to vertices when the width or height is less than or equal to zero");
        }
        float f2 = (float) i;
        float f3 = ((((float) rect.left) / f2) * 2.0f) - 1.0f;
        float f4 = (float) i2;
        float f5 = ((((float) rect.top) / f4) * 2.0f) - 1.0f;
        float f6 = ((((float) rect.right) / f2) * 2.0f) - 1.0f;
        float f7 = ((((float) rect.bottom) / f4) * 2.0f) - 1.0f;
        return new float[]{f3, f5, f6, f5, f3, f7, f6, f7};
    }

    public static String a(Exception exc) {
        String str = "";
        if (exc == null) {
            return str;
        }
        try {
            String exc2 = exc.toString();
            if (exc2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(exc2);
                sb.append("\n");
                str = sb.toString();
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exc.printStackTrace(printWriter);
            printWriter.flush();
            String str2 = str + stringWriter.toString();
            printWriter.close();
            return str2;
        } catch (Exception unused) {
            return str;
        }
    }
}
