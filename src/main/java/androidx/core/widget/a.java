package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public abstract class a implements View.OnTouchListener {
    private static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    final C0038a f1894a = new C0038a();

    /* renamed from: b  reason: collision with root package name */
    final View f1895b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1896c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1897d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1898e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f1899f = new AccelerateInterpolator();

    /* renamed from: g  reason: collision with root package name */
    private Runnable f1900g;
    private float[] h = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    private float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    private int j;
    private int k;
    private float[] l = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    private float[] m = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    private float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean o;
    private boolean p;
    private boolean q;

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public abstract void a(int i2, int i3);

    public abstract boolean e(int i2);

    public abstract boolean f(int i2);

    public a(View view) {
        this.f1895b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f2 = (float) ((int) ((displayMetrics.density * 1575.0f) + 0.5f));
        a(f2, f2);
        float f3 = (float) ((int) ((displayMetrics.density * 315.0f) + 0.5f));
        b(f3, f3);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(r);
        c(500);
        d(500);
    }

    public a a(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public a a(float f2, float f3) {
        float[] fArr = this.n;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a b(float f2, float f3) {
        float[] fArr = this.m;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a c(float f2, float f3) {
        float[] fArr = this.l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a a(int i2) {
        this.j = i2;
        return this;
    }

    public a d(float f2, float f3) {
        float[] fArr = this.h;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.i;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a b(int i2) {
        this.k = i2;
        return this;
    }

    public a c(int i2) {
        this.f1894a.a(i2);
        return this;
    }

    public a d(int i2) {
        this.f1894a.b(i2);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.d()
            goto L_0x0058
        L_0x001a:
            r5.f1897d = r2
            r5.o = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1895b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a((int) r1, (float) r0, (float) r3, (float) r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1895b
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a((int) r2, (float) r7, (float) r6, (float) r3)
            androidx.core.widget.a$a r7 = r5.f1894a
            r7.a(r0, r6)
            boolean r6 = r5.f1898e
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.a()
            if (r6 == 0) goto L_0x0058
            r5.c()
        L_0x0058:
            boolean r6 = r5.q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f1898e
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        C0038a aVar = this.f1894a;
        int f2 = aVar.f();
        int e2 = aVar.e();
        return (f2 != 0 && f(f2)) || (e2 != 0 && e(e2));
    }

    private void c() {
        if (this.f1900g == null) {
            this.f1900g = new b();
        }
        this.f1898e = true;
        this.f1896c = true;
        if (!this.o) {
            int i2 = this.k;
            if (i2 > 0) {
                w.a(this.f1895b, this.f1900g, (long) i2);
                this.o = true;
            }
        }
        this.f1900g.run();
        this.o = true;
    }

    private void d() {
        if (this.f1896c) {
            this.f1898e = false;
        } else {
            this.f1894a.b();
        }
    }

    private float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.h[i2], f3, this.i[i2], f2);
        if (a2 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f5 = this.l[i2];
        float f6 = this.m[i2];
        float f7 = this.n[i2];
        float f8 = f5 * f4;
        if (a2 > BitmapDescriptorFactory.HUE_RED) {
            return a(a2 * f8, f6, f7);
        }
        return -a((-a2) * f8, f6, f7);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6;
        float a2 = a(f2 * f3, (float) BitmapDescriptorFactory.HUE_RED, f4);
        float f7 = f(f3 - f5, a2) - f(f5, a2);
        if (f7 < BitmapDescriptorFactory.HUE_RED) {
            f6 = -this.f1899f.getInterpolation(-f7);
        } else if (f7 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        } else {
            f6 = this.f1899f.getInterpolation(f7);
        }
        return a(f6, -1.0f, 1.0f);
    }

    private float f(float f2, float f3) {
        if (f3 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i2 = this.j;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= BitmapDescriptorFactory.HUE_RED) {
                    return 1.0f - (f2 / f3);
                }
                if (!this.f1898e || this.j != 1) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                return 1.0f;
            }
        } else if (i2 == 2 && f2 < BitmapDescriptorFactory.HUE_RED) {
            return f2 / (-f3);
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1895b.onTouchEvent(obtain);
        obtain.recycle();
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            if (a.this.f1898e) {
                if (a.this.f1896c) {
                    a aVar = a.this;
                    aVar.f1896c = false;
                    aVar.f1894a.a();
                }
                C0038a aVar2 = a.this.f1894a;
                if (aVar2.c() || !a.this.a()) {
                    a.this.f1898e = false;
                    return;
                }
                if (a.this.f1897d) {
                    a aVar3 = a.this;
                    aVar3.f1897d = false;
                    aVar3.b();
                }
                aVar2.d();
                a.this.a(aVar2.g(), aVar2.h());
                w.a(a.this.f1895b, (Runnable) this);
            }
        }
    }

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    private static class C0038a {

        /* renamed from: a  reason: collision with root package name */
        private int f1901a;

        /* renamed from: b  reason: collision with root package name */
        private int f1902b;

        /* renamed from: c  reason: collision with root package name */
        private float f1903c;

        /* renamed from: d  reason: collision with root package name */
        private float f1904d;

        /* renamed from: e  reason: collision with root package name */
        private long f1905e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f1906f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f1907g = 0;
        private int h = 0;
        private long i = -1;
        private float j;
        private int k;

        private float a(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        C0038a() {
        }

        public void a(int i2) {
            this.f1901a = i2;
        }

        public void b(int i2) {
            this.f1902b = i2;
        }

        public void a() {
            this.f1905e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1;
            this.f1906f = this.f1905e;
            this.j = 0.5f;
            this.f1907g = 0;
            this.h = 0;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (currentAnimationTimeMillis - this.f1905e), 0, this.f1902b);
            this.j = a(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public boolean c() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        private float a(long j2) {
            if (j2 < this.f1905e) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            long j3 = this.i;
            if (j3 < 0 || j2 < j3) {
                return a.a(((float) (j2 - this.f1905e)) / ((float) this.f1901a), (float) BitmapDescriptorFactory.HUE_RED, 1.0f) * 0.5f;
            }
            long j4 = j2 - j3;
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.a(((float) j4) / ((float) this.k), (float) BitmapDescriptorFactory.HUE_RED, 1.0f));
        }

        public void d() {
            if (this.f1906f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                this.f1906f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f1906f)) * a2;
                this.f1907g = (int) (this.f1903c * f2);
                this.h = (int) (f2 * this.f1904d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f2, float f3) {
            this.f1903c = f2;
            this.f1904d = f3;
        }

        public int e() {
            float f2 = this.f1903c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f1904d;
            return (int) (f2 / Math.abs(f2));
        }

        public int g() {
            return this.f1907g;
        }

        public int h() {
            return this.h;
        }
    }
}
