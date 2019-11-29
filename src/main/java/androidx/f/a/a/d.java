package androidx.f.a.a;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f2117a;

    /* renamed from: b  reason: collision with root package name */
    private final float f2118b = (1.0f / ((float) (this.f2117a.length - 1)));

    protected d(float[] fArr) {
        this.f2117a = fArr;
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float[] fArr = this.f2117a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f2), fArr.length - 2);
        float f3 = this.f2118b;
        float f4 = (f2 - (((float) min) * f3)) / f3;
        float[] fArr2 = this.f2117a;
        return fArr2[min] + (f4 * (fArr2[min + 1] - fArr2[min]));
    }
}
