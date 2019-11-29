package com.shopee.app.ui.image.bound;

import android.util.Log;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.TIMGroupManager;
import java.lang.reflect.Method;

public class a {
    private static Method A = null;
    private static Method B = null;
    private static Method C = null;
    private static Method D = null;
    private static int E = 6;
    private static int F = 8;
    private static final float[] G = new float[2];
    private static final float[] H = new float[2];
    private static final float[] I = new float[2];
    private static final int[] J = new int[2];

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f22744b;
    private static Method w;
    private static Method x;
    private static Method y;
    private static Method z;

    /* renamed from: a  reason: collision with root package name */
    C0355a f22745a;

    /* renamed from: c  reason: collision with root package name */
    private b f22746c;

    /* renamed from: d  reason: collision with root package name */
    private b f22747d;

    /* renamed from: e  reason: collision with root package name */
    private float f22748e;

    /* renamed from: f  reason: collision with root package name */
    private float f22749f;

    /* renamed from: g  reason: collision with root package name */
    private float f22750g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private b l;
    private c m;
    private long n;
    private long o;
    private double p;
    private double q;
    private double r;
    private double s;
    private double t;
    private double u;
    private int v;

    /* renamed from: com.shopee.app.ui.image.bound.a$a  reason: collision with other inner class name */
    public interface C0355a {
        b a(b bVar);

        void a(b bVar, b bVar2);

        void a(b bVar, c cVar);

        boolean a(b bVar, c cVar, b bVar2);
    }

    private void a() {
        this.f22748e = this.f22746c.g();
        this.f22749f = this.f22746c.h();
        boolean a2 = this.m.f22764g;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        this.f22750g = Math.max(21.3f, !a2 ? BitmapDescriptorFactory.HUE_RED : this.f22746c.e());
        this.h = Math.max(30.0f, !this.m.h ? BitmapDescriptorFactory.HUE_RED : this.f22746c.b());
        this.i = Math.max(30.0f, !this.m.h ? BitmapDescriptorFactory.HUE_RED : this.f22746c.c());
        if (this.m.i) {
            f2 = this.f22746c.f();
        }
        this.j = f2;
    }

    public a(C0355a aVar) {
        this(aVar, true);
    }

    public a(C0355a aVar, boolean z2) {
        this.l = null;
        this.m = new c();
        this.v = 0;
        this.f22746c = new b();
        this.f22747d = new b();
        this.k = z2;
        this.f22745a = aVar;
    }

    static {
        boolean z2 = true;
        try {
            w = MotionEvent.class.getMethod("getPointerCount", new Class[0]);
            x = MotionEvent.class.getMethod("getPointerId", new Class[]{Integer.TYPE});
            y = MotionEvent.class.getMethod("getPressure", new Class[]{Integer.TYPE});
            z = MotionEvent.class.getMethod("getHistoricalX", new Class[]{Integer.TYPE, Integer.TYPE});
            A = MotionEvent.class.getMethod("getHistoricalY", new Class[]{Integer.TYPE, Integer.TYPE});
            B = MotionEvent.class.getMethod("getHistoricalPressure", new Class[]{Integer.TYPE, Integer.TYPE});
            C = MotionEvent.class.getMethod("getX", new Class[]{Integer.TYPE});
            D = MotionEvent.class.getMethod("getY", new Class[]{Integer.TYPE});
        } catch (Exception e2) {
            Log.e("MultiTouchController", "static initializer failed", e2);
            z2 = false;
        }
        f22744b = z2;
        if (f22744b) {
            try {
                E = MotionEvent.class.getField("ACTION_POINTER_UP").getInt((Object) null);
                F = MotionEvent.class.getField("ACTION_POINTER_INDEX_SHIFT").getInt((Object) null);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x012e A[Catch:{ Exception -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0130 A[Catch:{ Exception -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0133 A[Catch:{ Exception -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a A[Catch:{ Exception -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014f A[Catch:{ Exception -> 0x0174 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r21) {
        /*
            r20 = this;
            r11 = r20
            r0 = r21
            r12 = 0
            boolean r1 = f22744b     // Catch:{ Exception -> 0x0174 }
            r13 = 1
            if (r1 == 0) goto L_0x001a
            java.lang.reflect.Method r1 = w     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r1 = r1.invoke(r0, r2)     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0174 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0174 }
            r14 = r1
            goto L_0x001b
        L_0x001a:
            r14 = 1
        L_0x001b:
            int r1 = r11.v     // Catch:{ Exception -> 0x0174 }
            if (r1 != 0) goto L_0x0026
            boolean r1 = r11.k     // Catch:{ Exception -> 0x0174 }
            if (r1 != 0) goto L_0x0026
            if (r14 != r13) goto L_0x0026
            return r12
        L_0x0026:
            int r15 = r21.getAction()     // Catch:{ Exception -> 0x0174 }
            int r1 = r21.getHistorySize()     // Catch:{ Exception -> 0x0174 }
            int r9 = r1 / r14
            r10 = 0
        L_0x0031:
            if (r10 > r9) goto L_0x016e
            if (r10 >= r9) goto L_0x0037
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            boolean r2 = f22744b     // Catch:{ Exception -> 0x0174 }
            r3 = 2
            if (r2 == 0) goto L_0x00f7
            if (r14 != r13) goto L_0x0041
            goto L_0x00f7
        L_0x0041:
            int r2 = java.lang.Math.min(r14, r3)     // Catch:{ Exception -> 0x0174 }
            r4 = 0
        L_0x0046:
            if (r4 >= r2) goto L_0x0124
            java.lang.reflect.Method r5 = x     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r6 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r6[r12] = r7     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r5 = r5.invoke(r0, r6)     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x0174 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0174 }
            int[] r6 = J     // Catch:{ Exception -> 0x0174 }
            r6[r4] = r5     // Catch:{ Exception -> 0x0174 }
            float[] r5 = G     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x0079
            java.lang.reflect.Method r6 = z     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r7[r12] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0174 }
            r7[r13] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0174 }
            goto L_0x0087
        L_0x0079:
            java.lang.reflect.Method r6 = C     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r7 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r7[r12] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0174 }
        L_0x0087:
            java.lang.Float r6 = (java.lang.Float) r6     // Catch:{ Exception -> 0x0174 }
            java.lang.Float r6 = (java.lang.Float) r6     // Catch:{ Exception -> 0x0174 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0174 }
            r5[r4] = r6     // Catch:{ Exception -> 0x0174 }
            float[] r5 = H     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x00aa
            java.lang.reflect.Method r6 = A     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r7[r12] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0174 }
            r7[r13] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0174 }
            goto L_0x00b8
        L_0x00aa:
            java.lang.reflect.Method r6 = D     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r7 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r7[r12] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0174 }
        L_0x00b8:
            java.lang.Float r6 = (java.lang.Float) r6     // Catch:{ Exception -> 0x0174 }
            java.lang.Float r6 = (java.lang.Float) r6     // Catch:{ Exception -> 0x0174 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0174 }
            r5[r4] = r6     // Catch:{ Exception -> 0x0174 }
            float[] r5 = I     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x00db
            java.lang.reflect.Method r6 = B     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r7[r12] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0174 }
            r7[r13] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0174 }
            goto L_0x00e9
        L_0x00db:
            java.lang.reflect.Method r6 = y     // Catch:{ Exception -> 0x0174 }
            java.lang.Object[] r7 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0174 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0174 }
            r7[r12] = r8     // Catch:{ Exception -> 0x0174 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ Exception -> 0x0174 }
        L_0x00e9:
            java.lang.Float r6 = (java.lang.Float) r6     // Catch:{ Exception -> 0x0174 }
            java.lang.Float r6 = (java.lang.Float) r6     // Catch:{ Exception -> 0x0174 }
            float r6 = r6.floatValue()     // Catch:{ Exception -> 0x0174 }
            r5[r4] = r6     // Catch:{ Exception -> 0x0174 }
            int r4 = r4 + 1
            goto L_0x0046
        L_0x00f7:
            float[] r2 = G     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x0100
            float r4 = r0.getHistoricalX(r10)     // Catch:{ Exception -> 0x0174 }
            goto L_0x0104
        L_0x0100:
            float r4 = r21.getX()     // Catch:{ Exception -> 0x0174 }
        L_0x0104:
            r2[r12] = r4     // Catch:{ Exception -> 0x0174 }
            float[] r2 = H     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x010f
            float r4 = r0.getHistoricalY(r10)     // Catch:{ Exception -> 0x0174 }
            goto L_0x0113
        L_0x010f:
            float r4 = r21.getY()     // Catch:{ Exception -> 0x0174 }
        L_0x0113:
            r2[r12] = r4     // Catch:{ Exception -> 0x0174 }
            float[] r2 = I     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x011e
            float r4 = r0.getHistoricalPressure(r10)     // Catch:{ Exception -> 0x0174 }
            goto L_0x0122
        L_0x011e:
            float r4 = r21.getPressure()     // Catch:{ Exception -> 0x0174 }
        L_0x0122:
            r2[r12] = r4     // Catch:{ Exception -> 0x0174 }
        L_0x0124:
            float[] r4 = G     // Catch:{ Exception -> 0x0174 }
            float[] r5 = H     // Catch:{ Exception -> 0x0174 }
            float[] r6 = I     // Catch:{ Exception -> 0x0174 }
            int[] r7 = J     // Catch:{ Exception -> 0x0174 }
            if (r1 == 0) goto L_0x0130
            r8 = 2
            goto L_0x0131
        L_0x0130:
            r8 = r15
        L_0x0131:
            if (r1 != 0) goto L_0x0146
            if (r15 == r13) goto L_0x0143
            int r2 = F     // Catch:{ Exception -> 0x0174 }
            int r2 = r13 << r2
            int r2 = r2 - r13
            r2 = r2 & r15
            int r3 = E     // Catch:{ Exception -> 0x0174 }
            if (r2 == r3) goto L_0x0143
            r2 = 3
            if (r15 == r2) goto L_0x0143
            goto L_0x0146
        L_0x0143:
            r16 = 0
            goto L_0x0148
        L_0x0146:
            r16 = 1
        L_0x0148:
            if (r1 == 0) goto L_0x014f
            long r1 = r0.getHistoricalEventTime(r10)     // Catch:{ Exception -> 0x0174 }
            goto L_0x0153
        L_0x014f:
            long r1 = r21.getEventTime()     // Catch:{ Exception -> 0x0174 }
        L_0x0153:
            r17 = r1
            r1 = r20
            r2 = r14
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r16 = r9
            r19 = r10
            r9 = r17
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0174 }
            int r10 = r19 + 1
            r9 = r16
            goto L_0x0031
        L_0x016e:
            com.shopee.app.ui.image.bound.b r0 = r11.l     // Catch:{ Exception -> 0x0174 }
            if (r0 == 0) goto L_0x0173
            r12 = 1
        L_0x0173:
            return r12
        L_0x0174:
            r0 = move-exception
            java.lang.String r1 = "MultiTouchController"
            java.lang.String r2 = "onTouchEvent() failed"
            android.util.Log.e(r1, r2, r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.bound.a.a(android.view.MotionEvent):boolean");
    }

    private void a(int i2, float[] fArr, float[] fArr2, float[] fArr3, int[] iArr, int i3, boolean z2, long j2) {
        b bVar = this.f22747d;
        this.f22747d = this.f22746c;
        this.f22746c = bVar;
        this.f22746c.a(i2, fArr, fArr2, fArr3, iArr, i3, z2, j2);
        d();
    }

    private void b() {
        b bVar = this.l;
        if (bVar != null) {
            this.f22745a.a(bVar, this.m);
            double d2 = 1.0d / ((this.m.f22764g && this.m.f22760c != 0.0d) ? this.m.f22760c : 1.0d);
            a();
            double d3 = (double) this.f22748e;
            double e2 = this.m.f22758a;
            Double.isNaN(d3);
            this.p = (d3 - e2) * d2;
            double d4 = (double) this.f22749f;
            double f2 = this.m.f22759b;
            Double.isNaN(d4);
            this.q = (d4 - f2) * d2;
            double d5 = this.m.f22760c;
            double d6 = (double) this.f22750g;
            Double.isNaN(d6);
            this.r = d5 / d6;
            double g2 = this.m.f22761d;
            double d7 = (double) this.h;
            Double.isNaN(d7);
            this.t = g2 / d7;
            double h2 = this.m.f22762e;
            double d8 = (double) this.i;
            Double.isNaN(d8);
            this.u = h2 / d8;
            double i2 = this.m.f22763f;
            double d9 = (double) this.j;
            Double.isNaN(d9);
            this.s = i2 - d9;
        }
    }

    private void c() {
        if (this.l != null) {
            double d2 = 1.0d;
            if (this.m.f22764g && this.m.f22760c != 0.0d) {
                d2 = this.m.f22760c;
            }
            a();
            double d3 = (double) this.f22748e;
            Double.isNaN(d3);
            double d4 = d3 - (this.p * d2);
            double d5 = (double) this.f22749f;
            Double.isNaN(d5);
            double d6 = this.r;
            double d7 = (double) this.f22750g;
            Double.isNaN(d7);
            double d8 = d6 * d7;
            double d9 = this.t;
            double d10 = (double) this.h;
            Double.isNaN(d10);
            double d11 = d9 * d10;
            double d12 = this.u;
            double d13 = (double) this.i;
            Double.isNaN(d13);
            double d14 = d12 * d13;
            double d15 = this.s;
            double d16 = (double) this.j;
            Double.isNaN(d16);
            this.m.a(d4, d5 - (this.q * d2), d8, d11, d14, d15 + d16);
            this.f22745a.a(this.l, this.m, this.f22746c);
        }
    }

    private void d() {
        int i2 = this.v;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (!this.f22746c.a() || !this.f22746c.i()) {
                        if (!this.f22746c.i()) {
                            this.v = 0;
                            C0355a aVar = this.f22745a;
                            this.l = null;
                            aVar.a((b) null, this.f22746c);
                            return;
                        }
                        this.v = 1;
                        b();
                        this.n = this.f22746c.j();
                        this.o = this.n + 20;
                    } else if (Math.abs(this.f22746c.g() - this.f22747d.g()) > 30.0f || Math.abs(this.f22746c.h() - this.f22747d.h()) > 30.0f || Math.abs(this.f22746c.b() - this.f22747d.b()) * 0.5f > 40.0f || Math.abs(this.f22746c.c() - this.f22747d.c()) * 0.5f > 40.0f) {
                        b();
                        this.n = this.f22746c.j();
                        this.o = this.n + 20;
                    } else if (this.f22746c.t < this.o) {
                        b();
                    } else {
                        c();
                    }
                }
            } else if (!this.f22746c.i()) {
                this.v = 0;
                C0355a aVar2 = this.f22745a;
                this.l = null;
                aVar2.a((b) null, this.f22746c);
            } else if (this.f22746c.a()) {
                this.v = 2;
                b();
                this.n = this.f22746c.j();
                this.o = this.n + 20;
            } else if (this.f22746c.j() < this.o) {
                b();
            } else {
                c();
            }
        } else if (this.f22746c.i()) {
            this.l = this.f22745a.a(this.f22746c);
            b bVar = this.l;
            if (bVar != null) {
                this.v = 1;
                this.f22745a.a(bVar, this.f22746c);
                b();
                long j2 = this.f22746c.j();
                this.o = j2;
                this.n = j2;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f22751a;

        /* renamed from: b  reason: collision with root package name */
        private float[] f22752b = new float[2];

        /* renamed from: c  reason: collision with root package name */
        private float[] f22753c = new float[2];

        /* renamed from: d  reason: collision with root package name */
        private float[] f22754d = new float[2];

        /* renamed from: e  reason: collision with root package name */
        private int[] f22755e = new int[2];

        /* renamed from: f  reason: collision with root package name */
        private float f22756f;

        /* renamed from: g  reason: collision with root package name */
        private float f22757g;
        private float h;
        private float i;
        private float j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private int s;
        /* access modifiers changed from: private */
        public long t;

        private int a(int i2) {
            int i3 = 0;
            int i4 = TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG;
            int i5 = 15;
            while (true) {
                int i6 = i5 - 1;
                int i7 = ((i3 << 1) + i4) << i5;
                if (i2 >= i7) {
                    i3 += i4;
                    i2 -= i7;
                }
                i4 >>= 1;
                if (i4 <= 0) {
                    return i3;
                }
                i5 = i6;
            }
        }

        /* access modifiers changed from: private */
        public void a(int i2, float[] fArr, float[] fArr2, float[] fArr3, int[] iArr, int i3, boolean z, long j2) {
            this.t = j2;
            this.s = i3;
            this.f22751a = i2;
            for (int i4 = 0; i4 < i2; i4++) {
                this.f22752b[i4] = fArr[i4];
                this.f22753c[i4] = fArr2[i4];
                this.f22754d[i4] = fArr3[i4];
                this.f22755e[i4] = iArr[i4];
            }
            this.n = z;
            this.o = i2 >= 2;
            if (this.o) {
                this.f22756f = (fArr[0] + fArr[1]) * 0.5f;
                this.f22757g = (fArr2[0] + fArr2[1]) * 0.5f;
                this.h = (fArr3[0] + fArr3[1]) * 0.5f;
                this.i = Math.abs(fArr[1] - fArr[0]);
                this.j = Math.abs(fArr2[1] - fArr2[0]);
            } else {
                this.f22756f = fArr[0];
                this.f22757g = fArr2[0];
                this.h = fArr3[0];
                this.j = BitmapDescriptorFactory.HUE_RED;
                this.i = BitmapDescriptorFactory.HUE_RED;
            }
            this.r = false;
            this.q = false;
            this.p = false;
        }

        public boolean a() {
            return this.o;
        }

        public float b() {
            return this.o ? this.i : BitmapDescriptorFactory.HUE_RED;
        }

        public float c() {
            return this.o ? this.j : BitmapDescriptorFactory.HUE_RED;
        }

        public float d() {
            float f2;
            if (!this.p) {
                if (this.o) {
                    float f3 = this.i;
                    float f4 = this.j;
                    f2 = (f3 * f3) + (f4 * f4);
                } else {
                    f2 = BitmapDescriptorFactory.HUE_RED;
                }
                this.l = f2;
                this.p = true;
            }
            return this.l;
        }

        public float e() {
            if (!this.q) {
                boolean z = this.o;
                float f2 = BitmapDescriptorFactory.HUE_RED;
                if (!z) {
                    this.k = BitmapDescriptorFactory.HUE_RED;
                } else {
                    float d2 = d();
                    if (d2 != BitmapDescriptorFactory.HUE_RED) {
                        f2 = ((float) a((int) (d2 * 256.0f))) / 16.0f;
                    }
                    this.k = f2;
                    float f3 = this.k;
                    float f4 = this.i;
                    if (f3 < f4) {
                        this.k = f4;
                    }
                    float f5 = this.k;
                    float f6 = this.j;
                    if (f5 < f6) {
                        this.k = f6;
                    }
                }
                this.q = true;
            }
            return this.k;
        }

        public float f() {
            if (!this.r) {
                if (!this.o) {
                    this.m = BitmapDescriptorFactory.HUE_RED;
                } else {
                    float[] fArr = this.f22753c;
                    float[] fArr2 = this.f22752b;
                    this.m = (float) Math.atan2((double) (fArr[1] - fArr[0]), (double) (fArr2[1] - fArr2[0]));
                }
                this.r = true;
            }
            return this.m;
        }

        public float g() {
            return this.f22756f;
        }

        public float h() {
            return this.f22757g;
        }

        public boolean i() {
            return this.n;
        }

        public long j() {
            return this.t;
        }
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public double f22758a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public double f22759b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public double f22760c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public double f22761d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public double f22762e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public double f22763f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f22764g;
        /* access modifiers changed from: private */
        public boolean h;
        /* access modifiers changed from: private */
        public boolean i;

        public void a(double d2, double d3, boolean z, double d4, boolean z2, double d5, double d6, boolean z3, double d7) {
            this.f22758a = d2;
            this.f22759b = d3;
            this.f22764g = z;
            double d8 = 1.0d;
            if (d4 == 0.0d) {
                d4 = 1.0d;
            }
            this.f22760c = d4;
            this.h = z2;
            if (d5 == 0.0d) {
                d5 = 1.0d;
            }
            this.f22761d = d5;
            if (d6 != 0.0d) {
                d8 = d6;
            }
            this.f22762e = d8;
            this.i = z3;
            this.f22763f = d7;
        }

        /* access modifiers changed from: protected */
        public void a(double d2, double d3, double d4, double d5, double d6, double d7) {
            this.f22758a = d2;
            this.f22759b = d3;
            double d8 = 1.0d;
            if (d4 == 0.0d) {
                d4 = 1.0d;
            }
            this.f22760c = d4;
            if (d5 == 0.0d) {
                d5 = 1.0d;
            }
            this.f22761d = d5;
            if (d6 != 0.0d) {
                d8 = d6;
            }
            this.f22762e = d8;
            this.f22763f = d7;
        }

        public double a() {
            return this.f22758a;
        }

        public double b() {
            return this.f22759b;
        }

        public double c() {
            if (!this.f22764g) {
                return 1.0d;
            }
            return this.f22760c;
        }

        public double d() {
            if (!this.h) {
                return 1.0d;
            }
            return this.f22761d;
        }

        public double e() {
            if (!this.h) {
                return 1.0d;
            }
            return this.f22762e;
        }

        public double f() {
            if (!this.i) {
                return 0.0d;
            }
            return this.f22763f;
        }
    }
}
