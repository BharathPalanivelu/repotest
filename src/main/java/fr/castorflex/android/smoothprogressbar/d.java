package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import fr.castorflex.android.smoothprogressbar.b;

public class d extends Drawable implements Animatable {
    private int[] A;
    private float[] B;
    /* access modifiers changed from: private */
    public final Runnable C;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f33012a;

    /* renamed from: b  reason: collision with root package name */
    private b f33013b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f33014c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f33015d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f33016e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f33017f;

    /* renamed from: g  reason: collision with root package name */
    private int f33018g;
    private boolean h;
    /* access modifiers changed from: private */
    public float i;
    /* access modifiers changed from: private */
    public float j;
    private int k;
    private int l;
    /* access modifiers changed from: private */
    public float m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public float o;
    private boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    private boolean r;
    /* access modifiers changed from: private */
    public float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private float x;
    private Drawable y;
    private boolean z;

    public interface b {
        void a();

        void b();
    }

    public int getOpacity() {
        return -2;
    }

    private d(Interpolator interpolator, int i2, int i3, int[] iArr, float f2, float f3, float f4, float f5, boolean z2, boolean z3, b bVar, boolean z4, Drawable drawable, boolean z5) {
        this.f33012a = new Rect();
        this.C = new Runnable() {
            public void run() {
                if (d.this.c()) {
                    d dVar = d.this;
                    float unused = dVar.j = dVar.j + (d.this.o * 0.01f);
                    d dVar2 = d.this;
                    float unused2 = dVar2.i = dVar2.i + (d.this.o * 0.01f);
                    if (d.this.j >= 1.0f) {
                        d.this.stop();
                    }
                } else if (d.this.b()) {
                    d dVar3 = d.this;
                    float unused3 = dVar3.i = dVar3.i + (d.this.n * 0.01f);
                } else {
                    d dVar4 = d.this;
                    float unused4 = dVar4.i = dVar4.i + (d.this.m * 0.01f);
                }
                if (d.this.i >= d.this.s) {
                    boolean unused5 = d.this.q = true;
                    d dVar5 = d.this;
                    float unused6 = dVar5.i = dVar5.i - d.this.s;
                }
                if (d.this.isRunning()) {
                    d dVar6 = d.this;
                    dVar6.scheduleSelf(dVar6.C, SystemClock.uptimeMillis() + 16);
                }
                d.this.invalidateSelf();
            }
        };
        this.h = false;
        this.f33014c = interpolator;
        this.l = i2;
        this.v = 0;
        int i4 = this.l;
        this.w = i4;
        this.k = i3;
        this.m = f3;
        this.n = f4;
        this.o = f5;
        this.p = z2;
        this.f33017f = iArr;
        this.f33018g = 0;
        this.r = z3;
        this.t = false;
        this.y = drawable;
        this.x = f2;
        this.s = 1.0f / ((float) i4);
        this.f33016e = new Paint();
        this.f33016e.setStrokeWidth(f2);
        this.f33016e.setStyle(Paint.Style.STROKE);
        this.f33016e.setDither(false);
        this.f33016e.setAntiAlias(false);
        this.u = z4;
        this.f33013b = bVar;
        this.z = z5;
        a();
    }

    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f33014c = interpolator;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Interpolator cannot be null");
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
        this.f33018g = 0;
        this.f33017f = iArr;
        a();
        invalidateSelf();
    }

    public void a(int i2) {
        a(new int[]{i2});
    }

    public void a(float f2) {
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            this.m = f2;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Speed must be >= 0");
    }

    public void b(float f2) {
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            this.n = f2;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
    }

    public void c(float f2) {
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            this.o = f2;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
    }

    public void b(int i2) {
        if (i2 > 0) {
            this.l = i2;
            this.s = 1.0f / ((float) this.l);
            this.i %= this.s;
            a();
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("SectionsCount must be > 0");
    }

    public void c(int i2) {
        if (i2 >= 0) {
            this.k = i2;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("SeparatorLength must be >= 0");
    }

    public void d(float f2) {
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            this.f33016e.setStrokeWidth(f2);
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("The strokeWidth must be >= 0");
    }

    public void a(boolean z2) {
        if (this.p != z2) {
            this.p = z2;
            invalidateSelf();
        }
    }

    public void b(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            invalidateSelf();
        }
    }

    public void a(Drawable drawable) {
        if (this.y != drawable) {
            this.y = drawable;
            invalidateSelf();
        }
    }

    public void c(boolean z2) {
        this.u = z2;
    }

    public void d(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            a();
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.z) {
            int i2 = this.l;
            this.A = new int[(i2 + 2)];
            this.B = new float[(i2 + 2)];
            return;
        }
        this.f33016e.setShader((Shader) null);
        this.A = null;
        this.B = null;
    }

    public void draw(Canvas canvas) {
        this.f33015d = getBounds();
        canvas.clipRect(this.f33015d);
        if (this.q) {
            this.f33018g = e(this.f33018g);
            this.q = false;
            if (c()) {
                this.v++;
                if (this.v > this.l) {
                    stop();
                    return;
                }
            }
            int i2 = this.w;
            if (i2 < this.l) {
                this.w = i2 + 1;
            }
        }
        if (this.z) {
            a(canvas);
        }
        b(canvas);
    }

    private void a(Canvas canvas) {
        float f2 = 1.0f / ((float) this.l);
        int i2 = this.f33018g;
        float[] fArr = this.B;
        int i3 = 0;
        fArr[0] = 0.0f;
        fArr[fArr.length - 1] = 1.0f;
        int i4 = i2 - 1;
        if (i4 < 0) {
            i4 += this.f33017f.length;
        }
        this.A[0] = this.f33017f[i4];
        while (i3 < this.l) {
            float interpolation = this.f33014c.getInterpolation((((float) i3) * f2) + this.i);
            i3++;
            this.B[i3] = interpolation;
            int[] iArr = this.A;
            int[] iArr2 = this.f33017f;
            iArr[i3] = iArr2[i2];
            i2 = (i2 + 1) % iArr2.length;
        }
        int[] iArr3 = this.A;
        iArr3[iArr3.length - 1] = this.f33017f[i2];
        this.f33016e.setShader(new LinearGradient((float) ((!this.p || !this.r) ? this.f33015d.left : Math.abs(this.f33015d.left - this.f33015d.right) / 2), ((float) this.f33015d.centerY()) - (this.x / 2.0f), (float) (this.r ? this.p ? this.f33015d.left : Math.abs(this.f33015d.left - this.f33015d.right) / 2 : this.f33015d.right), (this.x / 2.0f) + ((float) this.f33015d.centerY()), this.A, this.B, this.r ? Shader.TileMode.MIRROR : Shader.TileMode.CLAMP));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.graphics.Canvas r24) {
        /*
            r23 = this;
            r8 = r23
            r9 = r24
            boolean r0 = r8.p
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            if (r0 == 0) goto L_0x001a
            android.graphics.Rect r0 = r8.f33015d
            int r0 = r0.width()
            float r0 = (float) r0
            r9.translate(r0, r11)
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9.scale(r0, r10)
        L_0x001a:
            android.graphics.Rect r0 = r8.f33015d
            int r0 = r0.width()
            boolean r1 = r8.r
            if (r1 == 0) goto L_0x0026
            int r0 = r0 / 2
        L_0x0026:
            r12 = r0
            int r0 = r8.k
            int r0 = r0 + r12
            int r1 = r8.l
            int r13 = r0 + r1
            android.graphics.Rect r0 = r8.f33015d
            int r14 = r0.centerY()
            int r0 = r8.l
            float r1 = (float) r0
            float r15 = r10 / r1
            int r1 = r8.f33018g
            int r2 = r8.v
            int r3 = r8.w
            if (r2 != r3) goto L_0x0049
            if (r3 != r0) goto L_0x0049
            int r0 = r24.getWidth()
            float r0 = (float) r0
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            r2 = 0
            r6 = r0
            r3 = r1
            r4 = 0
            r5 = 0
            r7 = 0
        L_0x0050:
            int r0 = r8.w
            if (r7 > r0) goto L_0x0112
            float r0 = (float) r7
            float r0 = r0 * r15
            float r1 = r8.i
            float r0 = r0 + r1
            float r1 = r0 - r15
            float r1 = java.lang.Math.max(r11, r1)
            android.view.animation.Interpolator r2 = r8.f33014c
            float r2 = r2.getInterpolation(r1)
            android.view.animation.Interpolator r11 = r8.f33014c
            float r0 = java.lang.Math.min(r0, r10)
            float r0 = r11.getInterpolation(r0)
            float r2 = r2 - r0
            float r0 = java.lang.Math.abs(r2)
            float r2 = (float) r13
            float r0 = r0 * r2
            int r0 = (int) r0
            float r11 = (float) r0
            float r1 = r1 + r11
            int r0 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0089
            int r0 = r8.k
            float r0 = (float) r0
            float r0 = java.lang.Math.min(r11, r0)
            r16 = r0
            goto L_0x008b
        L_0x0089:
            r16 = 0
        L_0x008b:
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x0092
            float r0 = r11 - r16
            goto L_0x0093
        L_0x0092:
            r0 = 0
        L_0x0093:
            float r1 = r4 + r0
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e8
            int r0 = r8.v
            if (r7 < r0) goto L_0x00e8
            android.view.animation.Interpolator r0 = r8.f33014c
            r17 = r3
            float r3 = r8.j
            float r3 = java.lang.Math.min(r3, r10)
            float r0 = r0.getInterpolation(r3)
            float r0 = r0 * r2
            float r2 = (float) r12
            float r3 = java.lang.Math.min(r2, r4)
            float r18 = java.lang.Math.max(r0, r3)
            float r19 = java.lang.Math.min(r2, r1)
            float r3 = (float) r14
            r0 = r23
            r20 = r1
            r1 = r24
            r2 = r12
            r21 = r17
            r17 = r3
            r3 = r18
            r22 = r4
            r4 = r17
            r10 = r5
            r5 = r19
            r19 = r12
            r12 = r6
            r6 = r17
            r17 = r13
            r13 = r7
            r7 = r21
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r8.v
            if (r13 != r0) goto L_0x00f5
            int r0 = r8.k
            float r0 = (float) r0
            float r18 = r18 - r0
            r6 = r18
            goto L_0x00f6
        L_0x00e8:
            r20 = r1
            r21 = r3
            r22 = r4
            r10 = r5
            r19 = r12
            r17 = r13
            r12 = r6
            r13 = r7
        L_0x00f5:
            r6 = r12
        L_0x00f6:
            int r0 = r8.w
            if (r13 != r0) goto L_0x00fe
            float r4 = r22 + r11
            r5 = r4
            goto L_0x00ff
        L_0x00fe:
            r5 = r10
        L_0x00ff:
            float r4 = r20 + r16
            r1 = r21
            int r3 = r8.d((int) r1)
            int r7 = r13 + 1
            r13 = r17
            r12 = r19
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            goto L_0x0050
        L_0x0112:
            r10 = r5
            r12 = r6
            r8.a(r9, r12, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.castorflex.android.smoothprogressbar.d.b(android.graphics.Canvas):void");
    }

    private void a(Canvas canvas, int i2, float f2, float f3, float f4, float f5, int i3) {
        int i4 = i2;
        this.f33016e.setColor(this.f33017f[i3]);
        if (!this.r) {
            canvas.drawLine(f2, f3, f4, f5, this.f33016e);
        } else if (this.p) {
            float f6 = (float) i4;
            canvas.drawLine(f6 + f2, f3, f6 + f4, f5, this.f33016e);
            canvas.drawLine(f6 - f2, f3, f6 - f4, f5, this.f33016e);
        } else {
            Canvas canvas2 = canvas;
            float f7 = f3;
            float f8 = f5;
            canvas2.drawLine(f2, f7, f4, f8, this.f33016e);
            float f9 = (float) (i4 * 2);
            canvas2.drawLine(f9 - f2, f7, f9 - f4, f8, this.f33016e);
        }
    }

    private void a(Canvas canvas, float f2, float f3) {
        if (this.y != null) {
            this.f33012a.top = (int) ((((float) canvas.getHeight()) - this.x) / 2.0f);
            this.f33012a.bottom = (int) ((((float) canvas.getHeight()) + this.x) / 2.0f);
            Rect rect = this.f33012a;
            rect.left = 0;
            rect.right = this.r ? canvas.getWidth() / 2 : canvas.getWidth();
            this.y.setBounds(this.f33012a);
            if (!isRunning()) {
                if (this.r) {
                    canvas.save();
                    canvas.translate((float) (canvas.getWidth() / 2), BitmapDescriptorFactory.HUE_RED);
                    b(canvas, BitmapDescriptorFactory.HUE_RED, (float) this.f33012a.width());
                    canvas.scale(-1.0f, 1.0f);
                    b(canvas, BitmapDescriptorFactory.HUE_RED, (float) this.f33012a.width());
                    canvas.restore();
                    return;
                }
                b(canvas, BitmapDescriptorFactory.HUE_RED, (float) this.f33012a.width());
            } else if (c() || b()) {
                if (f2 > f3) {
                    float f4 = f3;
                    f3 = f2;
                    f2 = f4;
                }
                if (f2 > BitmapDescriptorFactory.HUE_RED) {
                    if (this.r) {
                        canvas.save();
                        canvas.translate((float) (canvas.getWidth() / 2), BitmapDescriptorFactory.HUE_RED);
                        if (this.p) {
                            b(canvas, BitmapDescriptorFactory.HUE_RED, f2);
                            canvas.scale(-1.0f, 1.0f);
                            b(canvas, BitmapDescriptorFactory.HUE_RED, f2);
                        } else {
                            b(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                            canvas.scale(-1.0f, 1.0f);
                            b(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                        }
                        canvas.restore();
                    } else {
                        b(canvas, BitmapDescriptorFactory.HUE_RED, f2);
                    }
                }
                if (f3 > ((float) canvas.getWidth())) {
                    return;
                }
                if (this.r) {
                    canvas.save();
                    canvas.translate((float) (canvas.getWidth() / 2), BitmapDescriptorFactory.HUE_RED);
                    if (this.p) {
                        b(canvas, f3, (float) (canvas.getWidth() / 2));
                        canvas.scale(-1.0f, 1.0f);
                        b(canvas, f3, (float) (canvas.getWidth() / 2));
                    } else {
                        b(canvas, BitmapDescriptorFactory.HUE_RED, ((float) (canvas.getWidth() / 2)) - f3);
                        canvas.scale(-1.0f, 1.0f);
                        b(canvas, BitmapDescriptorFactory.HUE_RED, ((float) (canvas.getWidth() / 2)) - f3);
                    }
                    canvas.restore();
                    return;
                }
                b(canvas, f3, (float) canvas.getWidth());
            }
        }
    }

    private void b(Canvas canvas, float f2, float f3) {
        int save = canvas.save();
        canvas.clipRect(f2, (float) ((int) ((((float) canvas.getHeight()) - this.x) / 2.0f)), f3, (float) ((int) ((((float) canvas.getHeight()) + this.x) / 2.0f)));
        this.y.draw(canvas);
        canvas.restoreToCount(save);
    }

    private int d(int i2) {
        int i3 = i2 + 1;
        if (i3 >= this.f33017f.length) {
            return 0;
        }
        return i3;
    }

    private int e(int i2) {
        int i3 = i2 - 1;
        return i3 < 0 ? this.f33017f.length - 1 : i3;
    }

    private void f(int i2) {
        g(i2);
        this.i = BitmapDescriptorFactory.HUE_RED;
        this.t = false;
        this.j = BitmapDescriptorFactory.HUE_RED;
        this.v = 0;
        this.w = 0;
        this.f33018g = i2;
    }

    public void setAlpha(int i2) {
        this.f33016e.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f33016e.setColorFilter(colorFilter);
    }

    public void start() {
        if (this.u) {
            f(0);
        }
        if (!isRunning()) {
            b bVar = this.f33013b;
            if (bVar != null) {
                bVar.b();
            }
            scheduleSelf(this.C, SystemClock.uptimeMillis() + 16);
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning()) {
            b bVar = this.f33013b;
            if (bVar != null) {
                bVar.a();
            }
            this.h = false;
            unscheduleSelf(this.C);
        }
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        this.h = true;
        super.scheduleSelf(runnable, j2);
    }

    public boolean isRunning() {
        return this.h;
    }

    public boolean b() {
        return this.w < this.l;
    }

    public boolean c() {
        return this.t;
    }

    public void a(b bVar) {
        this.f33013b = bVar;
    }

    private void g(int i2) {
        if (i2 < 0 || i2 >= this.f33017f.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", new Object[]{Integer.valueOf(i2)}));
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Interpolator f33020a;

        /* renamed from: b  reason: collision with root package name */
        private int f33021b;

        /* renamed from: c  reason: collision with root package name */
        private int[] f33022c;

        /* renamed from: d  reason: collision with root package name */
        private float f33023d;

        /* renamed from: e  reason: collision with root package name */
        private float f33024e;

        /* renamed from: f  reason: collision with root package name */
        private float f33025f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f33026g;
        private boolean h;
        private float i;
        private int j;
        private boolean k;
        private boolean l;
        private boolean m;
        private Drawable n;
        private b o;

        public a(Context context) {
            this(context, false);
        }

        public a(Context context, boolean z) {
            a(context, z);
        }

        public d a() {
            if (this.l) {
                this.n = c.a(this.f33022c, this.i);
            }
            return new d(this.f33020a, this.f33021b, this.j, this.f33022c, this.i, this.f33023d, this.f33024e, this.f33025f, this.f33026g, this.h, this.o, this.k, this.n, this.m);
        }

        private void a(Context context, boolean z) {
            Resources resources = context.getResources();
            this.f33020a = new AccelerateInterpolator();
            if (!z) {
                this.f33021b = resources.getInteger(b.e.spb_default_sections_count);
                this.f33023d = Float.parseFloat(resources.getString(b.f.spb_default_speed));
                this.f33026g = resources.getBoolean(b.C0508b.spb_default_reversed);
                this.k = resources.getBoolean(b.C0508b.spb_default_progressiveStart_activated);
                this.f33022c = new int[]{resources.getColor(b.c.spb_default_color)};
                this.j = resources.getDimensionPixelSize(b.d.spb_default_stroke_separator_length);
                this.i = (float) resources.getDimensionPixelOffset(b.d.spb_default_stroke_width);
            } else {
                this.f33021b = 4;
                this.f33023d = 1.0f;
                this.f33026g = false;
                this.k = false;
                this.f33022c = new int[]{-13388315};
                this.j = 4;
                this.i = 4.0f;
            }
            float f2 = this.f33023d;
            this.f33024e = f2;
            this.f33025f = f2;
            this.m = false;
        }

        public a a(Interpolator interpolator) {
            c.a((Object) interpolator, "Interpolator");
            this.f33020a = interpolator;
            return this;
        }

        public a a(int i2) {
            c.a(i2, "Sections count");
            this.f33021b = i2;
            return this;
        }

        public a b(int i2) {
            c.a((float) i2, "Separator length");
            this.j = i2;
            return this;
        }

        public a c(int i2) {
            this.f33022c = new int[]{i2};
            return this;
        }

        public a a(int[] iArr) {
            c.a(iArr);
            this.f33022c = iArr;
            return this;
        }

        public a a(float f2) {
            c.a(f2, "Width");
            this.i = f2;
            return this;
        }

        public a b(float f2) {
            c.a(f2);
            this.f33023d = f2;
            return this;
        }

        public a c(float f2) {
            c.a(f2);
            this.f33024e = f2;
            return this;
        }

        public a d(float f2) {
            c.a(f2);
            this.f33025f = f2;
            return this;
        }

        public a a(boolean z) {
            this.f33026g = z;
            return this;
        }

        public a b(boolean z) {
            this.h = z;
            return this;
        }

        public a c(boolean z) {
            this.k = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.n = drawable;
            return this;
        }

        public a b() {
            this.l = true;
            return this;
        }

        public a d(boolean z) {
            this.m = z;
            return this;
        }
    }
}
