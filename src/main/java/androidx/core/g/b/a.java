package androidx.core.g.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1773a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1774b;

    a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f1773a = new float[i];
        this.f1774b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, (float[]) null);
            this.f1773a[i2] = fArr[0];
            this.f1774b[i2] = fArr[1];
        }
    }

    a(float f2, float f3, float f4, float f5) {
        this(a(f2, f3, f4, f5));
    }

    public float getInterpolation(float f2) {
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f1773a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.f1773a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f1773a;
        float f3 = fArr[length] - fArr[i];
        if (f3 == BitmapDescriptorFactory.HUE_RED) {
            return this.f1774b[i];
        }
        float[] fArr2 = this.f1774b;
        float f4 = fArr2[i];
        return f4 + (((f2 - fArr[i]) / f3) * (fArr2[length] - f4));
    }

    private static Path a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        return path;
    }
}
