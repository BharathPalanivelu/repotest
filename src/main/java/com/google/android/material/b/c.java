package com.google.android.material.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.g.w;
import com.google.android.material.a;
import com.google.android.material.internal.m;

class c {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f13171a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private final a f13172b;

    /* renamed from: c  reason: collision with root package name */
    private int f13173c;

    /* renamed from: d  reason: collision with root package name */
    private int f13174d;

    /* renamed from: e  reason: collision with root package name */
    private int f13175e;

    /* renamed from: f  reason: collision with root package name */
    private int f13176f;

    /* renamed from: g  reason: collision with root package name */
    private int f13177g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private boolean w = false;

    public c(a aVar) {
        this.f13172b = aVar;
    }

    public void a(TypedArray typedArray) {
        int i2 = 0;
        this.f13173c = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetLeft, 0);
        this.f13174d = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetRight, 0);
        this.f13175e = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetTop, 0);
        this.f13176f = typedArray.getDimensionPixelOffset(a.k.MaterialButton_android_insetBottom, 0);
        this.f13177g = typedArray.getDimensionPixelSize(a.k.MaterialButton_cornerRadius, 0);
        this.h = typedArray.getDimensionPixelSize(a.k.MaterialButton_strokeWidth, 0);
        this.i = m.a(typedArray.getInt(a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = com.google.android.material.f.a.a(this.f13172b.getContext(), typedArray, a.k.MaterialButton_backgroundTint);
        this.k = com.google.android.material.f.a.a(this.f13172b.getContext(), typedArray, a.k.MaterialButton_strokeColor);
        this.l = com.google.android.material.f.a.a(this.f13172b.getContext(), typedArray, a.k.MaterialButton_rippleColor);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth((float) this.h);
        Paint paint = this.m;
        ColorStateList colorStateList = this.k;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(this.f13172b.getDrawableState(), 0);
        }
        paint.setColor(i2);
        int j2 = w.j(this.f13172b);
        int paddingTop = this.f13172b.getPaddingTop();
        int k2 = w.k(this.f13172b);
        int paddingBottom = this.f13172b.getPaddingBottom();
        this.f13172b.setInternalBackground(f13171a ? k() : i());
        w.b(this.f13172b, j2 + this.f13173c, paddingTop + this.f13175e, k2 + this.f13174d, paddingBottom + this.f13176f);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.w = true;
        this.f13172b.setSupportBackgroundTintList(this.j);
        this.f13172b.setSupportBackgroundTintMode(this.i);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (canvas != null && this.k != null && this.h > 0) {
            this.n.set(this.f13172b.getBackground().getBounds());
            this.o.set(((float) this.n.left) + (((float) this.h) / 2.0f) + ((float) this.f13173c), ((float) this.n.top) + (((float) this.h) / 2.0f) + ((float) this.f13175e), (((float) this.n.right) - (((float) this.h) / 2.0f)) - ((float) this.f13174d), (((float) this.n.bottom) - (((float) this.h) / 2.0f)) - ((float) this.f13176f));
            float f2 = ((float) this.f13177g) - (((float) this.h) / 2.0f);
            canvas.drawRoundRect(this.o, f2, f2, this.m);
        }
    }

    private Drawable i() {
        this.p = new GradientDrawable();
        this.p.setCornerRadius(((float) this.f13177g) + 1.0E-5f);
        this.p.setColor(-1);
        this.q = androidx.core.graphics.drawable.a.g(this.p);
        androidx.core.graphics.drawable.a.a(this.q, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.q, mode);
        }
        this.r = new GradientDrawable();
        this.r.setCornerRadius(((float) this.f13177g) + 1.0E-5f);
        this.r.setColor(-1);
        this.s = androidx.core.graphics.drawable.a.g(this.r);
        androidx.core.graphics.drawable.a.a(this.s, this.l);
        return a((Drawable) new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f13173c, this.f13175e, this.f13174d, this.f13176f);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (f13171a) {
                j();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, this.j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (f13171a) {
                j();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                PorterDuff.Mode mode2 = this.i;
                if (mode2 != null) {
                    androidx.core.graphics.drawable.a.a(drawable, mode2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.i;
    }

    private void j() {
        GradientDrawable gradientDrawable = this.t;
        if (gradientDrawable != null) {
            androidx.core.graphics.drawable.a.a((Drawable) gradientDrawable, this.j);
            PorterDuff.Mode mode = this.i;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a((Drawable) this.t, mode);
            }
        }
    }

    @TargetApi(21)
    private Drawable k() {
        this.t = new GradientDrawable();
        this.t.setCornerRadius(((float) this.f13177g) + 1.0E-5f);
        this.t.setColor(-1);
        j();
        this.u = new GradientDrawable();
        this.u.setCornerRadius(((float) this.f13177g) + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.h, this.k);
        InsetDrawable a2 = a((Drawable) new LayerDrawable(new Drawable[]{this.t, this.u}));
        this.v = new GradientDrawable();
        this.v.setCornerRadius(((float) this.f13177g) + 1.0E-5f);
        this.v.setColor(-1);
        return new b(com.google.android.material.g.a.a(this.l), a2, this.v);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f13173c, this.f13175e, i3 - this.f13174d, i2 - this.f13176f);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (f13171a) {
            GradientDrawable gradientDrawable = this.t;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(i2);
                return;
            }
        }
        if (!f13171a) {
            GradientDrawable gradientDrawable2 = this.p;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (f13171a && (this.f13172b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f13172b.getBackground()).setColor(colorStateList);
            } else if (!f13171a) {
                Drawable drawable = this.s;
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, colorStateList);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            Paint paint = this.m;
            int i2 = 0;
            if (colorStateList != null) {
                i2 = colorStateList.getColorForState(this.f13172b.getDrawableState(), 0);
            }
            paint.setColor(i2);
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (this.h != i2) {
            this.h = i2;
            this.m.setStrokeWidth((float) i2);
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.h;
    }

    private void l() {
        if (f13171a && this.u != null) {
            this.f13172b.setInternalBackground(k());
        } else if (!f13171a) {
            this.f13172b.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (this.f13177g != i2) {
            this.f13177g = i2;
            if (f13171a && this.t != null && this.u != null && this.v != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f2 = ((float) i2) + 1.0E-5f;
                    n().setCornerRadius(f2);
                    m().setCornerRadius(f2);
                }
                float f3 = ((float) i2) + 1.0E-5f;
                this.t.setCornerRadius(f3);
                this.u.setCornerRadius(f3);
                this.v.setCornerRadius(f3);
            } else if (!f13171a) {
                GradientDrawable gradientDrawable = this.p;
                if (gradientDrawable != null && this.r != null) {
                    float f4 = ((float) i2) + 1.0E-5f;
                    gradientDrawable.setCornerRadius(f4);
                    this.r.setCornerRadius(f4);
                    this.f13172b.invalidate();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f13177g;
    }

    private GradientDrawable m() {
        if (!f13171a || this.f13172b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f13172b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private GradientDrawable n() {
        if (!f13171a || this.f13172b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f13172b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }
}
