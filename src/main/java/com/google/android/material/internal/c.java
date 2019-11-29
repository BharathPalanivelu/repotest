package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.a;
import androidx.appcompat.widget.ar;
import androidx.core.g.d;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f13375a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f13376b = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private final TextPaint J;
    private final TextPaint K;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private int U;

    /* renamed from: c  reason: collision with root package name */
    private final View f13377c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13378d;

    /* renamed from: e  reason: collision with root package name */
    private float f13379e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f13380f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f13381g;
    private final RectF h;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    static {
        Paint paint = f13376b;
        if (paint != null) {
            paint.setAntiAlias(true);
            f13376b.setColor(-65281);
        }
    }

    public c(View view) {
        this.f13377c = view;
        this.J = new TextPaint(129);
        this.K = new TextPaint(this.J);
        this.f13381g = new Rect();
        this.f13380f = new Rect();
        this.h = new RectF();
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        g();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.L = timeInterpolator;
        g();
    }

    public void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            g();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            g();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            g();
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (!a(this.f13380f, i2, i3, i4, i5)) {
            this.f13380f.set(i2, i3, i4, i5);
            this.I = true;
            c();
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (!a(this.f13381g, i2, i3, i4, i5)) {
            this.f13381g.set(i2, i3, i4, i5);
            this.I = true;
            c();
        }
    }

    public float a() {
        if (this.x == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        a(this.K);
        TextPaint textPaint = this.K;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public float b() {
        a(this.K);
        return -this.K.ascent();
    }

    public void a(RectF rectF) {
        float f2;
        boolean b2 = b(this.x);
        if (!b2) {
            f2 = (float) this.f13381g.left;
        } else {
            f2 = ((float) this.f13381g.right) - a();
        }
        rectF.left = f2;
        rectF.top = (float) this.f13381g.top;
        rectF.right = !b2 ? rectF.left + a() : (float) this.f13381g.right;
        rectF.bottom = ((float) this.f13381g.top) + b();
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.l);
        textPaint.setTypeface(this.u);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f13378d = this.f13381g.width() > 0 && this.f13381g.height() > 0 && this.f13380f.width() > 0 && this.f13380f.height() > 0;
    }

    public void a(int i2) {
        if (this.i != i2) {
            this.i = i2;
            g();
        }
    }

    public void b(int i2) {
        if (this.j != i2) {
            this.j = i2;
            g();
        }
    }

    public void c(int i2) {
        ar a2 = ar.a(this.f13377c.getContext(), i2, a.j.TextAppearance);
        if (a2.g(a.j.TextAppearance_android_textColor)) {
            this.n = a2.e(a.j.TextAppearance_android_textColor);
        }
        if (a2.g(a.j.TextAppearance_android_textSize)) {
            this.l = (float) a2.e(a.j.TextAppearance_android_textSize, (int) this.l);
        }
        this.Q = a2.a(a.j.TextAppearance_android_shadowColor, 0);
        this.O = a2.a(a.j.TextAppearance_android_shadowDx, (float) BitmapDescriptorFactory.HUE_RED);
        this.P = a2.a(a.j.TextAppearance_android_shadowDy, (float) BitmapDescriptorFactory.HUE_RED);
        this.N = a2.a(a.j.TextAppearance_android_shadowRadius, (float) BitmapDescriptorFactory.HUE_RED);
        a2.a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = d(i2);
        }
        g();
    }

    private Typeface d(int i2) {
        TypedArray obtainStyledAttributes = this.f13377c.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void a(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        g();
    }

    public void b(float f2) {
        float a2 = androidx.core.b.a.a(f2, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
        if (a2 != this.f13379e) {
            this.f13379e = a2;
            i();
        }
    }

    public final boolean a(int[] iArr) {
        this.H = iArr;
        if (!d()) {
            return false;
        }
        g();
        return true;
    }

    public final boolean d() {
        ColorStateList colorStateList = this.n;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.m;
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                return false;
            }
        }
        return true;
    }

    public float e() {
        return this.f13379e;
    }

    private void i() {
        c(this.f13379e);
    }

    private void c(float f2) {
        d(f2);
        this.s = a(this.q, this.r, f2, this.L);
        this.t = a(this.o, this.p, f2, this.L);
        e(a(this.k, this.l, f2, this.M));
        if (this.n != this.m) {
            this.J.setColor(a(j(), f(), f2));
        } else {
            this.J.setColor(f());
        }
        this.J.setShadowLayer(a(this.R, this.N, f2, (TimeInterpolator) null), a(this.S, this.O, f2, (TimeInterpolator) null), a(this.T, this.P, f2, (TimeInterpolator) null), a(this.U, this.Q, f2));
        w.e(this.f13377c);
    }

    private int j() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.m.getColorForState(iArr, 0);
        }
        return this.m.getDefaultColor();
    }

    public int f() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.n.getColorForState(iArr, 0);
        }
        return this.n.getDefaultColor();
    }

    private void k() {
        float f2 = this.G;
        f(this.l);
        CharSequence charSequence = this.y;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float measureText = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : BitmapDescriptorFactory.HUE_RED;
        int a2 = d.a(this.j, this.z ? 1 : 0);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.p = ((float) this.f13381g.top) - this.J.ascent();
        } else if (i2 != 80) {
            this.p = ((float) this.f13381g.centerY()) + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.p = (float) this.f13381g.bottom;
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.r = ((float) this.f13381g.centerX()) - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.r = (float) this.f13381g.left;
        } else {
            this.r = ((float) this.f13381g.right) - measureText;
        }
        f(this.k);
        CharSequence charSequence2 = this.y;
        if (charSequence2 != null) {
            f3 = this.J.measureText(charSequence2, 0, charSequence2.length());
        }
        int a3 = d.a(this.i, this.z ? 1 : 0);
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.o = ((float) this.f13380f.top) - this.J.ascent();
        } else if (i4 != 80) {
            this.o = ((float) this.f13380f.centerY()) + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.o = (float) this.f13380f.bottom;
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.q = ((float) this.f13380f.centerX()) - (f3 / 2.0f);
        } else if (i5 != 5) {
            this.q = (float) this.f13380f.left;
        } else {
            this.q = ((float) this.f13380f.right) - f3;
        }
        m();
        e(f2);
    }

    private void d(float f2) {
        this.h.left = a((float) this.f13380f.left, (float) this.f13381g.left, f2, this.L);
        this.h.top = a(this.o, this.p, f2, this.L);
        this.h.right = a((float) this.f13380f.right, (float) this.f13381g.right, f2, this.L);
        this.h.bottom = a((float) this.f13380f.bottom, (float) this.f13381g.bottom, f2, this.L);
    }

    public void a(Canvas canvas) {
        float f2;
        int save = canvas.save();
        if (this.y != null && this.f13378d) {
            float f3 = this.s;
            float f4 = this.t;
            boolean z2 = this.A && this.B != null;
            if (z2) {
                f2 = this.D * this.F;
                float f5 = this.E;
            } else {
                f2 = this.J.ascent() * this.F;
                this.J.descent();
                float f6 = this.F;
            }
            if (z2) {
                f4 += f2;
            }
            float f7 = f4;
            float f8 = this.F;
            if (f8 != 1.0f) {
                canvas.scale(f8, f8, f3, f7);
            }
            if (z2) {
                canvas.drawBitmap(this.B, f3, f7, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f3, f7, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean b(CharSequence charSequence) {
        boolean z2 = true;
        if (w.g(this.f13377c) != 1) {
            z2 = false;
        }
        return (z2 ? androidx.core.f.d.f1724d : androidx.core.f.d.f1723c).a(charSequence, 0, charSequence.length());
    }

    private void e(float f2) {
        f(f2);
        this.A = f13375a && this.F != 1.0f;
        if (this.A) {
            l();
        }
        w.e(this.f13377c);
    }

    private void f(float f2) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.x != null) {
            float width = (float) this.f13381g.width();
            float width2 = (float) this.f13380f.width();
            boolean z4 = true;
            if (a(f2, this.l)) {
                float f4 = this.l;
                this.F = 1.0f;
                Typeface typeface = this.w;
                Typeface typeface2 = this.u;
                if (typeface != typeface2) {
                    this.w = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f3 = f4;
                z2 = z3;
            } else {
                f3 = this.k;
                Typeface typeface3 = this.w;
                Typeface typeface4 = this.v;
                if (typeface3 != typeface4) {
                    this.w = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f2, this.k)) {
                    this.F = 1.0f;
                } else {
                    this.F = f2 / this.k;
                }
                float f5 = this.l / this.k;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            }
            if (width > BitmapDescriptorFactory.HUE_RED) {
                z2 = this.G != f3 || this.I || z2;
                this.G = f3;
                this.I = false;
            }
            if (this.y == null || z2) {
                this.J.setTextSize(this.G);
                this.J.setTypeface(this.w);
                TextPaint textPaint = this.J;
                if (this.F == 1.0f) {
                    z4 = false;
                }
                textPaint.setLinearText(z4);
                CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.y)) {
                    this.y = ellipsize;
                    this.z = b(this.y);
                }
            }
        }
    }

    private void l() {
        if (this.B == null && !this.f13380f.isEmpty() && !TextUtils.isEmpty(this.y)) {
            c((float) BitmapDescriptorFactory.HUE_RED);
            this.D = this.J.ascent();
            this.E = this.J.descent();
            TextPaint textPaint = this.J;
            CharSequence charSequence = this.y;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.E - this.D);
            if (round > 0 && round2 > 0) {
                this.B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.B);
                CharSequence charSequence2 = this.y;
                canvas.drawText(charSequence2, 0, charSequence2.length(), BitmapDescriptorFactory.HUE_RED, ((float) round2) - this.J.descent(), this.J);
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
    }

    public void g() {
        if (this.f13377c.getHeight() > 0 && this.f13377c.getWidth() > 0) {
            k();
            i();
        }
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            m();
            g();
        }
    }

    private void m() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    public ColorStateList h() {
        return this.n;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.a.a.a(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
