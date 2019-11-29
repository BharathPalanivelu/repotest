package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.g.w;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import com.google.android.material.a.g;
import com.google.android.material.a.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import java.util.ArrayList;
import java.util.Iterator;

class a {

    /* renamed from: a  reason: collision with root package name */
    static final TimeInterpolator f13292a = com.google.android.material.a.a.f13100c;
    static final int[] p = {16842919, 16842910};
    static final int[] q = {16843623, 16842908, 16842910};
    static final int[] r = {16842908, 16842910};
    static final int[] s = {16843623, 16842910};
    static final int[] t = {16842910};
    static final int[] u = new int[0];
    private float A;
    private ArrayList<Animator.AnimatorListener> B;
    private ArrayList<Animator.AnimatorListener> C;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private ViewTreeObserver.OnPreDrawListener H;

    /* renamed from: b  reason: collision with root package name */
    int f13293b = 0;

    /* renamed from: c  reason: collision with root package name */
    Animator f13294c;

    /* renamed from: d  reason: collision with root package name */
    h f13295d;

    /* renamed from: e  reason: collision with root package name */
    h f13296e;

    /* renamed from: f  reason: collision with root package name */
    com.google.android.material.h.a f13297f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f13298g;
    Drawable h;
    com.google.android.material.internal.a i;
    Drawable j;
    float k;
    float l;
    float m;
    int n;
    float o = 1.0f;
    final n v;
    final com.google.android.material.h.b w;
    private h x;
    private h y;
    private final k z;

    interface d {
        void a();

        void b();
    }

    /* access modifiers changed from: package-private */
    public void b(Rect rect) {
    }

    /* access modifiers changed from: package-private */
    public void i() {
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return true;
    }

    a(n nVar, com.google.android.material.h.b bVar) {
        this.v = nVar;
        this.w = bVar;
        this.z = new k();
        this.z.a(p, a((f) new c()));
        this.z.a(q, a((f) new b()));
        this.z.a(r, a((f) new b()));
        this.z.a(s, a((f) new b()));
        this.z.a(t, a((f) new e()));
        this.z.a(u, a((f) new C0217a()));
        this.A = this.v.getRotation();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable[] drawableArr;
        this.f13298g = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.f13298g, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.f13298g, mode);
        }
        this.h = androidx.core.graphics.drawable.a.g(p());
        androidx.core.graphics.drawable.a.a(this.h, com.google.android.material.g.a.a(colorStateList2));
        if (i2 > 0) {
            this.i = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.i, this.f13298g, this.h};
        } else {
            this.i = null;
            drawableArr = new Drawable[]{this.f13298g, this.h};
        }
        this.j = new LayerDrawable(drawableArr);
        Context context = this.v.getContext();
        Drawable drawable = this.j;
        float a2 = this.w.a();
        float f2 = this.k;
        this.f13297f = new com.google.android.material.h.a(context, drawable, a2, f2, f2 + this.m);
        this.f13297f.a(false);
        this.w.a(this.f13297f);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.f13298g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        com.google.android.material.internal.a aVar = this.i;
        if (aVar != null) {
            aVar.a(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.f13298g;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, com.google.android.material.g.a.a(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            a(this.k, this.l, this.m);
        }
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.l != f2) {
            this.l = f2;
            a(this.k, this.l, this.m);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(float f2) {
        if (this.m != f2) {
            this.m = f2;
            a(this.k, this.l, this.m);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.n != i2) {
            this.n = i2;
            d();
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        d(this.o);
    }

    /* access modifiers changed from: package-private */
    public final void d(float f2) {
        this.o = f2;
        Matrix matrix = this.G;
        a(f2, matrix);
        this.v.setImageMatrix(matrix);
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.v.getDrawable();
        if (drawable != null && this.n != 0) {
            RectF rectF = this.E;
            RectF rectF2 = this.F;
            rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.n;
            rectF2.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.n;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final h e() {
        return this.f13295d;
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar) {
        this.f13295d = hVar;
    }

    /* access modifiers changed from: package-private */
    public final h f() {
        return this.f13296e;
    }

    /* access modifiers changed from: package-private */
    public final void b(h hVar) {
        this.f13296e = hVar;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        com.google.android.material.h.a aVar = this.f13297f;
        if (aVar != null) {
            aVar.a(f2, this.m + f2);
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.z.a(iArr);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.z.a();
    }

    /* access modifiers changed from: package-private */
    public void a(Animator.AnimatorListener animatorListener) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.B;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.C;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final d dVar, final boolean z2) {
        if (!s()) {
            Animator animator = this.f13294c;
            if (animator != null) {
                animator.cancel();
            }
            if (w()) {
                h hVar = this.f13296e;
                if (hVar == null) {
                    hVar = u();
                }
                AnimatorSet a2 = a(hVar, (float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
                a2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: d  reason: collision with root package name */
                    private boolean f13302d;

                    public void onAnimationStart(Animator animator) {
                        a.this.v.a(0, z2);
                        a aVar = a.this;
                        aVar.f13293b = 1;
                        aVar.f13294c = animator;
                        this.f13302d = false;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.f13302d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        a aVar = a.this;
                        aVar.f13293b = 0;
                        aVar.f13294c = null;
                        if (!this.f13302d) {
                            aVar.v.a(z2 ? 8 : 4, z2);
                            d dVar = dVar;
                            if (dVar != null) {
                                dVar.b();
                            }
                        }
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.C;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.v.a(z2 ? 8 : 4, z2);
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(final d dVar, final boolean z2) {
        if (!r()) {
            Animator animator = this.f13294c;
            if (animator != null) {
                animator.cancel();
            }
            if (w()) {
                if (this.v.getVisibility() != 0) {
                    this.v.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    this.v.setScaleY(BitmapDescriptorFactory.HUE_RED);
                    this.v.setScaleX(BitmapDescriptorFactory.HUE_RED);
                    d((float) BitmapDescriptorFactory.HUE_RED);
                }
                h hVar = this.f13295d;
                if (hVar == null) {
                    hVar = t();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        a.this.v.a(0, z2);
                        a aVar = a.this;
                        aVar.f13293b = 2;
                        aVar.f13294c = animator;
                    }

                    public void onAnimationEnd(Animator animator) {
                        a aVar = a.this;
                        aVar.f13293b = 0;
                        aVar.f13294c = null;
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.a();
                        }
                    }
                });
                ArrayList<Animator.AnimatorListener> arrayList = this.B;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.v.a(0, z2);
            this.v.setAlpha(1.0f);
            this.v.setScaleY(1.0f);
            this.v.setScaleX(1.0f);
            d(1.0f);
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private h t() {
        if (this.x == null) {
            this.x = h.a(this.v.getContext(), a.C0214a.design_fab_show_motion_spec);
        }
        return this.x;
    }

    private h u() {
        if (this.y == null) {
            this.y = h.a(this.v.getContext(), a.C0214a.design_fab_hide_motion_spec);
        }
        return this.y;
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, View.ALPHA, new float[]{f2});
        hVar.b(ViewProps.OPACITY).a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.v, View.SCALE_X, new float[]{f3});
        hVar.b("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.v, View.SCALE_Y, new float[]{f3});
        hVar.b("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.v, new com.google.android.material.a.f(), new g(), new Matrix[]{new Matrix(this.G)});
        hVar.b("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public final Drawable h() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        this.f13297f.getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (m()) {
            v();
            this.v.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (this.H != null) {
            this.v.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    /* access modifiers changed from: package-private */
    public com.google.android.material.internal.a a(int i2, ColorStateList colorStateList) {
        Context context = this.v.getContext();
        com.google.android.material.internal.a n2 = n();
        n2.a(androidx.core.content.b.c(context, a.c.design_fab_stroke_top_outer_color), androidx.core.content.b.c(context, a.c.design_fab_stroke_top_inner_color), androidx.core.content.b.c(context, a.c.design_fab_stroke_end_inner_color), androidx.core.content.b.c(context, a.c.design_fab_stroke_end_outer_color));
        n2.a((float) i2);
        n2.a(colorStateList);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public com.google.android.material.internal.a n() {
        return new com.google.android.material.internal.a();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        float rotation = this.v.getRotation();
        if (this.A != rotation) {
            this.A = rotation;
            x();
        }
    }

    private void v() {
        if (this.H == null) {
            this.H = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    a.this.o();
                    return true;
                }
            };
        }
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable p() {
        GradientDrawable q2 = q();
        q2.setShape(1);
        q2.setColor(-1);
        return q2;
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable q() {
        return new GradientDrawable();
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        if (this.v.getVisibility() != 0) {
            if (this.f13293b == 2) {
                return true;
            }
            return false;
        } else if (this.f13293b != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        if (this.v.getVisibility() == 0) {
            if (this.f13293b == 1) {
                return true;
            }
            return false;
        } else if (this.f13293b != 2) {
            return true;
        } else {
            return false;
        }
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f13292a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        return valueAnimator;
    }

    private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13311a;

        /* renamed from: c  reason: collision with root package name */
        private float f13313c;

        /* renamed from: d  reason: collision with root package name */
        private float f13314d;

        /* access modifiers changed from: protected */
        public abstract float a();

        private f() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f13311a) {
                this.f13313c = a.this.f13297f.b();
                this.f13314d = a();
                this.f13311a = true;
            }
            com.google.android.material.h.a aVar = a.this.f13297f;
            float f2 = this.f13313c;
            aVar.a(f2 + ((this.f13314d - f2) * valueAnimator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f13297f.a(this.f13314d);
            this.f13311a = false;
        }
    }

    private class e extends f {
        e() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return a.this.k;
        }
    }

    private class b extends f {
        b() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return a.this.k + a.this.l;
        }
    }

    private class c extends f {
        c() {
            super();
        }

        /* access modifiers changed from: protected */
        public float a() {
            return a.this.k + a.this.m;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.a$a  reason: collision with other inner class name */
    private class C0217a extends f {
        /* access modifiers changed from: protected */
        public float a() {
            return BitmapDescriptorFactory.HUE_RED;
        }

        C0217a() {
            super();
        }
    }

    private boolean w() {
        return w.A(this.v) && !this.v.isInEditMode();
    }

    private void x() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.A % 90.0f != BitmapDescriptorFactory.HUE_RED) {
                if (this.v.getLayerType() != 1) {
                    this.v.setLayerType(1, (Paint) null);
                }
            } else if (this.v.getLayerType() != 0) {
                this.v.setLayerType(0, (Paint) null);
            }
        }
        com.google.android.material.h.a aVar = this.f13297f;
        if (aVar != null) {
            aVar.b(-this.A);
        }
        com.google.android.material.internal.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.b(-this.A);
        }
    }
}
