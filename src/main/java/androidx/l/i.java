package androidx.l;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class i<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f2496a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f2497b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2498c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f2499d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f2500e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private float f2501f;

    i(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2496a = property;
        this.f2497b = new PathMeasure(path, false);
        this.f2498c = this.f2497b.getLength();
    }

    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f2501f);
    }

    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f2501f = f2.floatValue();
        this.f2497b.getPosTan(this.f2498c * f2.floatValue(), this.f2499d, (float[]) null);
        PointF pointF = this.f2500e;
        float[] fArr = this.f2499d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f2496a.set(t, pointF);
    }
}
