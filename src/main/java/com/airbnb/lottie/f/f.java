package com.airbnb.lottie.f;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.Closeable;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final PathMeasure f3722a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private static final Path f3723b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private static final Path f3724c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private static final float[] f3725d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    private static final float f3726e = ((float) Math.sqrt(2.0d));

    /* renamed from: f  reason: collision with root package name */
    private static float f3727f = -1.0f;

    public static int a(float f2, float f3, float f4, float f5) {
        int i = f2 != BitmapDescriptorFactory.HUE_RED ? (int) (((float) 527) * f2) : 17;
        if (f3 != BitmapDescriptorFactory.HUE_RED) {
            i = (int) (((float) (i * 31)) * f3);
        }
        if (f4 != BitmapDescriptorFactory.HUE_RED) {
            i = (int) (((float) (i * 31)) * f4);
        }
        return f5 != BitmapDescriptorFactory.HUE_RED ? (int) (((float) (i * 31)) * f5) : i;
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == BitmapDescriptorFactory.HUE_RED && pointF4.length() == BitmapDescriptorFactory.HUE_RED)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float a(Matrix matrix) {
        float[] fArr = f3725d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f3726e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = f3725d;
        return ((float) Math.hypot((double) (fArr2[2] - fArr2[0]), (double) (fArr2[3] - fArr2[1]))) / 2.0f;
    }

    public static void a(Path path, r rVar) {
        if (rVar != null) {
            a(path, rVar.d().e().floatValue() / 100.0f, rVar.e().e().floatValue() / 100.0f, rVar.f().e().floatValue() / 360.0f);
        }
    }

    public static void a(Path path, float f2, float f3, float f4) {
        c.c("applyTrimPathIfNeeded");
        f3722a.setPath(path, false);
        float length = f3722a.getLength();
        if (f2 == 1.0f && f3 == BitmapDescriptorFactory.HUE_RED) {
            c.d("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f3 - f2) - 1.0f)) < 0.01d) {
            c.d("applyTrimPathIfNeeded");
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = (float) e.a(min, length);
                max = (float) e.a(max, length);
            }
            if (min < BitmapDescriptorFactory.HUE_RED) {
                min = (float) e.a(min, length);
            }
            if (max < BitmapDescriptorFactory.HUE_RED) {
                max = (float) e.a(max, length);
            }
            if (min == max) {
                path.reset();
                c.d("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            f3723b.reset();
            f3722a.getSegment(min, max, f3723b, true);
            if (max > length) {
                f3724c.reset();
                f3722a.getSegment(BitmapDescriptorFactory.HUE_RED, max % length, f3724c, true);
                f3723b.addPath(f3724c);
            } else if (min < BitmapDescriptorFactory.HUE_RED) {
                f3724c.reset();
                f3722a.getSegment(min + length, length, f3724c, true);
                f3723b.addPath(f3724c);
            }
            path.set(f3723b);
            c.d("applyTrimPathIfNeeded");
        }
    }

    public static float a() {
        if (f3727f == -1.0f) {
            f3727f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f3727f;
    }
}
