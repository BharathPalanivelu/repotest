package androidx.core.graphics;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f1820a = new ThreadLocal<>();

    private static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int d2 = d(alpha2, alpha);
        return Color.argb(d2, a(Color.red(i), alpha2, Color.red(i2), alpha, d2), a(Color.green(i), alpha2, Color.green(i2), alpha, d2), a(Color.blue(i), alpha2, Color.blue(i2), alpha, d2));
    }

    private static int d(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static double a(int i) {
        double[] a2 = a();
        a(i, a2);
        return a2[1] / 100.0d;
    }

    public static double b(int i, int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = a(i, i2);
            }
            double a2 = a(i) + 0.05d;
            double a3 = a(i2) + 0.05d;
            return Math.max(a2, a3) / Math.min(a2, a3);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    public static int a(int i, int i2, float f2) {
        int i3 = 255;
        if (Color.alpha(i2) == 255) {
            double d2 = (double) f2;
            if (b(c(i, 255), i2) < d2) {
                return -1;
            }
            int i4 = 0;
            for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
                int i6 = (i4 + i3) / 2;
                if (b(c(i, i6), i2) < d2) {
                    i4 = i6;
                } else {
                    i3 = i6;
                }
            }
            return i3;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    public static void a(int i, int i2, int i3, float[] fArr) {
        float f2;
        float f3;
        float f4 = ((float) i) / 255.0f;
        float f5 = ((float) i2) / 255.0f;
        float f6 = ((float) i3) / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = (max + min) / 2.0f;
        if (max == min) {
            f3 = BitmapDescriptorFactory.HUE_RED;
            f2 = BitmapDescriptorFactory.HUE_RED;
        } else {
            f3 = max == f4 ? ((f5 - f6) / f7) % 6.0f : max == f5 ? ((f6 - f4) / f7) + 2.0f : ((f4 - f5) / f7) + 4.0f;
            f2 = f7 / (1.0f - Math.abs((2.0f * f8) - 1.0f));
        }
        float f9 = (f3 * 60.0f) % 360.0f;
        if (f9 < BitmapDescriptorFactory.HUE_RED) {
            f9 += 360.0f;
        }
        fArr[0] = a(f9, (float) BitmapDescriptorFactory.HUE_RED, 360.0f);
        fArr[1] = a(f2, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
        fArr[2] = a(f8, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
    }

    public static void a(int i, float[] fArr) {
        a(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static int c(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & 16777215) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static void a(int i, double[] dArr) {
        a(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void a(int i, int i2, int i3, double[] dArr) {
        double d2;
        double d3;
        double d4;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d5 = (double) i;
            Double.isNaN(d5);
            double d6 = d5 / 255.0d;
            if (d6 < 0.04045d) {
                d2 = d6 / 12.92d;
            } else {
                d2 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            }
            double d7 = d2;
            double d8 = (double) i2;
            Double.isNaN(d8);
            double d9 = d8 / 255.0d;
            if (d9 < 0.04045d) {
                d3 = d9 / 12.92d;
            } else {
                d3 = Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
            }
            double d10 = d3;
            double d11 = (double) i3;
            Double.isNaN(d11);
            double d12 = d11 / 255.0d;
            if (d12 < 0.04045d) {
                d4 = d12 / 12.92d;
            } else {
                d4 = Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * d7) + (0.3576d * d10) + (0.1805d * d4)) * 100.0d;
            dArr2[1] = ((0.2126d * d7) + (0.7152d * d10) + (0.0722d * d4)) * 100.0d;
            dArr2[2] = ((d7 * 0.0193d) + (d10 * 0.1192d) + (d4 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    private static double[] a() {
        double[] dArr = f1820a.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        f1820a.set(dArr2);
        return dArr2;
    }
}
