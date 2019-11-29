package androidx.j.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f2398a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final c f2399b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final c f2400c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final c f2401d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final c f2402e = new c();

    /* renamed from: f  reason: collision with root package name */
    public static final c f2403f = new c();

    /* renamed from: g  reason: collision with root package name */
    final float[] f2404g = new float[3];
    final float[] h = new float[3];
    final float[] i = new float[3];
    boolean j = true;

    static {
        c(f2398a);
        d(f2398a);
        b(f2399b);
        d(f2399b);
        a(f2400c);
        d(f2400c);
        c(f2401d);
        e(f2401d);
        b(f2402e);
        e(f2402e);
        a(f2403f);
        e(f2403f);
    }

    c() {
        a(this.f2404g);
        a(this.h);
        l();
    }

    public float a() {
        return this.f2404g[0];
    }

    public float b() {
        return this.f2404g[1];
    }

    public float c() {
        return this.f2404g[2];
    }

    public float d() {
        return this.h[0];
    }

    public float e() {
        return this.h[1];
    }

    public float f() {
        return this.h[2];
    }

    public float g() {
        return this.i[0];
    }

    public float h() {
        return this.i[1];
    }

    public float i() {
        return this.i[2];
    }

    public boolean j() {
        return this.j;
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    private void l() {
        float[] fArr = this.i;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (float f3 : this.i) {
            if (f3 > BitmapDescriptorFactory.HUE_RED) {
                f2 += f3;
            }
        }
        if (f2 != BitmapDescriptorFactory.HUE_RED) {
            int length = this.i.length;
            for (int i2 = 0; i2 < length; i2++) {
                float[] fArr = this.i;
                if (fArr[i2] > BitmapDescriptorFactory.HUE_RED) {
                    fArr[i2] = fArr[i2] / f2;
                }
            }
        }
    }

    private static void a(c cVar) {
        float[] fArr = cVar.h;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void b(c cVar) {
        float[] fArr = cVar.h;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void c(c cVar) {
        float[] fArr = cVar.h;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void d(c cVar) {
        float[] fArr = cVar.f2404g;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private static void e(c cVar) {
        float[] fArr = cVar.f2404g;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }
}
