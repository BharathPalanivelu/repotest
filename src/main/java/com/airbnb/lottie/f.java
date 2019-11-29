package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.b.b;
import com.airbnb.lottie.e.s;
import com.airbnb.lottie.f.c;
import com.airbnb.lottie.f.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: c  reason: collision with root package name */
    private static final String f3686c = "f";

    /* renamed from: a  reason: collision with root package name */
    a f3687a;

    /* renamed from: b  reason: collision with root package name */
    p f3688b;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f3689d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    private d f3690e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f3691f = new c();

    /* renamed from: g  reason: collision with root package name */
    private float f3692g = 1.0f;
    private final Set<Object> h = new HashSet();
    private final ArrayList<a> i = new ArrayList<>();
    private b j;
    private String k;
    private b l;
    private com.airbnb.lottie.b.a m;
    private boolean n;
    /* access modifiers changed from: private */
    public com.airbnb.lottie.c.c.b o;
    private int p = 255;
    private boolean q;

    private interface a {
        void a(d dVar);
    }

    public int getOpacity() {
        return -3;
    }

    public f() {
        this.f3691f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.o != null) {
                    f.this.o.a(f.this.f3691f.d());
                }
            }
        });
    }

    public boolean a() {
        return this.n;
    }

    public void a(boolean z) {
        if (this.n != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(f3686c, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.n = z;
            if (this.f3690e != null) {
                u();
            }
        }
    }

    public void a(String str) {
        this.k = str;
    }

    public String b() {
        return this.k;
    }

    public void c() {
        b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean a(d dVar) {
        if (this.f3690e == dVar) {
            return false;
        }
        e();
        this.f3690e = dVar;
        u();
        this.f3691f.a(dVar);
        d(this.f3691f.getAnimatedFraction());
        e(this.f3692g);
        v();
        Iterator it = new ArrayList(this.i).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(dVar);
            it.remove();
        }
        this.i.clear();
        dVar.a(this.q);
        return true;
    }

    public void b(boolean z) {
        this.q = z;
        d dVar = this.f3690e;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public m d() {
        d dVar = this.f3690e;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    private void u() {
        this.o = new com.airbnb.lottie.c.c.b(this, s.a(this.f3690e), this.f3690e.g(), this.f3690e);
    }

    public void e() {
        c();
        if (this.f3691f.isRunning()) {
            this.f3691f.cancel();
        }
        this.f3690e = null;
        this.o = null;
        this.j = null;
        this.f3691f.f();
        invalidateSelf();
    }

    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void setAlpha(int i2) {
        this.p = i2;
    }

    public int getAlpha() {
        return this.p;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void draw(Canvas canvas) {
        float f2;
        c.c("Drawable#draw");
        if (this.o != null) {
            float f3 = this.f3692g;
            float a2 = a(canvas);
            if (f3 > a2) {
                f2 = this.f3692g / a2;
            } else {
                a2 = f3;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                canvas.save();
                float width = ((float) this.f3690e.b().width()) / 2.0f;
                float height = ((float) this.f3690e.b().height()) / 2.0f;
                float f4 = width * a2;
                float f5 = height * a2;
                canvas.translate((q() * width) - f4, (q() * height) - f5);
                canvas.scale(f2, f2, f4, f5);
            }
            this.f3689d.reset();
            this.f3689d.preScale(a2, a2);
            this.o.a(canvas, this.f3689d, this.p);
            c.d("Drawable#draw");
            if (f2 > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void start() {
        f();
    }

    public void stop() {
        g();
    }

    public boolean isRunning() {
        return n();
    }

    public void f() {
        if (this.o == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.f();
                }
            });
        } else {
            this.f3691f.i();
        }
    }

    public void g() {
        this.i.clear();
        this.f3691f.j();
    }

    public void a(final int i2) {
        if (this.f3690e == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.a(i2);
                }
            });
        } else {
            this.f3691f.b(i2);
        }
    }

    public float h() {
        return this.f3691f.k();
    }

    public void a(final float f2) {
        d dVar = this.f3690e;
        if (dVar == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.a(f2);
                }
            });
        } else {
            a((int) e.a(dVar.d(), this.f3690e.e(), f2));
        }
    }

    public void b(final int i2) {
        if (this.f3690e == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.b(i2);
                }
            });
        } else {
            this.f3691f.c(i2);
        }
    }

    public float i() {
        return this.f3691f.l();
    }

    public void b(final float f2) {
        d dVar = this.f3690e;
        if (dVar == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.b(f2);
                }
            });
        } else {
            b((int) e.a(dVar.d(), this.f3690e.e(), f2));
        }
    }

    public void c(float f2) {
        this.f3691f.a(f2);
    }

    public float j() {
        return this.f3691f.h();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3691f.addUpdateListener(animatorUpdateListener);
    }

    public void c(final int i2) {
        if (this.f3690e == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.c(i2);
                }
            });
        } else {
            this.f3691f.a(i2);
        }
    }

    public int k() {
        return (int) this.f3691f.e();
    }

    public void d(final float f2) {
        d dVar = this.f3690e;
        if (dVar == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.d(f2);
                }
            });
        } else {
            c((int) e.a(dVar.d(), this.f3690e.e(), f2));
        }
    }

    public void d(int i2) {
        this.f3691f.setRepeatMode(i2);
    }

    public int l() {
        return this.f3691f.getRepeatMode();
    }

    public void e(int i2) {
        this.f3691f.setRepeatCount(i2);
    }

    public int m() {
        return this.f3691f.getRepeatCount();
    }

    public boolean n() {
        return this.f3691f.isRunning();
    }

    public void e(float f2) {
        this.f3692g = f2;
        v();
    }

    public void a(b bVar) {
        this.l = bVar;
        b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void a(a aVar) {
        this.f3687a = aVar;
        com.airbnb.lottie.b.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void a(p pVar) {
        this.f3688b = pVar;
    }

    public p o() {
        return this.f3688b;
    }

    public boolean p() {
        return this.f3688b == null && this.f3690e.h().b() > 0;
    }

    public float q() {
        return this.f3692g;
    }

    public d r() {
        return this.f3690e;
    }

    private void v() {
        if (this.f3690e != null) {
            float q2 = q();
            setBounds(0, 0, (int) (((float) this.f3690e.b().width()) * q2), (int) (((float) this.f3690e.b().height()) * q2));
        }
    }

    public void s() {
        this.i.clear();
        this.f3691f.cancel();
    }

    public float t() {
        return this.f3691f.d();
    }

    public int getIntrinsicWidth() {
        d dVar = this.f3690e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.b().width()) * q());
    }

    public int getIntrinsicHeight() {
        d dVar = this.f3690e;
        if (dVar == null) {
            return -1;
        }
        return (int) (((float) dVar.b().height()) * q());
    }

    public List<com.airbnb.lottie.c.e> a(com.airbnb.lottie.c.e eVar) {
        if (this.o == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.o.a(eVar, 0, (List<com.airbnb.lottie.c.e>) arrayList, new com.airbnb.lottie.c.e(new String[0]));
        return arrayList;
    }

    public <T> void a(final com.airbnb.lottie.c.e eVar, final T t, final com.airbnb.lottie.g.c<T> cVar) {
        if (this.o == null) {
            this.i.add(new a() {
                public void a(d dVar) {
                    f.this.a(eVar, t, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (eVar.a() != null) {
            eVar.a().a(t, cVar);
        } else {
            List<com.airbnb.lottie.c.e> a2 = a(eVar);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a2.get(i2).a().a(t, cVar);
            }
            z = true ^ a2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == j.w) {
                d(t());
            }
        }
    }

    public Bitmap b(String str) {
        b w = w();
        if (w != null) {
            return w.a(str);
        }
        return null;
    }

    private b w() {
        if (getCallback() == null) {
            return null;
        }
        b bVar = this.j;
        if (bVar != null && !bVar.a(y())) {
            this.j.a();
            this.j = null;
        }
        if (this.j == null) {
            this.j = new b(getCallback(), this.k, this.l, this.f3690e.j());
        }
        return this.j;
    }

    public Typeface a(String str, String str2) {
        com.airbnb.lottie.b.a x = x();
        if (x != null) {
            return x.a(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m == null) {
            this.m = new com.airbnb.lottie.b.a(getCallback(), this.f3687a);
        }
        return this.m;
    }

    private Context y() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private float a(Canvas canvas) {
        return Math.min(((float) canvas.getWidth()) / ((float) this.f3690e.b().width()), ((float) canvas.getHeight()) / ((float) this.f3690e.b().height()));
    }
}
