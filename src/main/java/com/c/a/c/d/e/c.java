package com.c.a.c.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.c.a.c.b.a.e;
import com.c.a.c.d.e.g;
import com.c.a.c.m;
import com.c.a.i.h;
import java.nio.ByteBuffer;

public class c extends Drawable implements Animatable, g.b {

    /* renamed from: a  reason: collision with root package name */
    private final a f6070a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6071b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6072c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6073d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6074e;

    /* renamed from: f  reason: collision with root package name */
    private int f6075f;

    /* renamed from: g  reason: collision with root package name */
    private int f6076g;
    private boolean h;
    private Paint i;
    private Rect j;

    public int getOpacity() {
        return -2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(Context context, com.c.a.b.a aVar, e eVar, m<Bitmap> mVar, int i2, int i3, Bitmap bitmap) {
        this(new a(eVar, new g(com.c.a.c.a(context), aVar, i2, i3, mVar, bitmap)));
        e eVar2 = eVar;
    }

    c(a aVar) {
        this.f6074e = true;
        this.f6076g = -1;
        this.f6070a = (a) h.a(aVar);
    }

    public int a() {
        return this.f6070a.f6078b.d();
    }

    public Bitmap b() {
        return this.f6070a.f6078b.a();
    }

    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        this.f6070a.f6078b.a(mVar, bitmap);
    }

    public ByteBuffer c() {
        return this.f6070a.f6078b.f();
    }

    public int d() {
        return this.f6070a.f6078b.g();
    }

    public int e() {
        return this.f6070a.f6078b.e();
    }

    private void h() {
        this.f6075f = 0;
    }

    public void start() {
        this.f6072c = true;
        h();
        if (this.f6074e) {
            i();
        }
    }

    public void stop() {
        this.f6072c = false;
        j();
    }

    private void i() {
        h.a(!this.f6073d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f6070a.f6078b.g() == 1) {
            invalidateSelf();
        } else if (!this.f6071b) {
            this.f6071b = true;
            this.f6070a.f6078b.a((g.b) this);
            invalidateSelf();
        }
    }

    private void j() {
        this.f6071b = false;
        this.f6070a.f6078b.b(this);
    }

    public boolean setVisible(boolean z, boolean z2) {
        h.a(!this.f6073d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f6074e = z;
        if (!z) {
            j();
        } else if (this.f6072c) {
            i();
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        return this.f6070a.f6078b.b();
    }

    public int getIntrinsicHeight() {
        return this.f6070a.f6078b.c();
    }

    public boolean isRunning() {
        return this.f6071b;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    public void draw(Canvas canvas) {
        if (!this.f6073d) {
            if (this.h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
                this.h = false;
            }
            canvas.drawBitmap(this.f6070a.f6078b.i(), (Rect) null, k(), l());
        }
    }

    public void setAlpha(int i2) {
        l().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    private Rect k() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint l() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    public void f() {
        if (getCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f6075f++;
        }
        int i2 = this.f6076g;
        if (i2 != -1 && this.f6075f >= i2) {
            stop();
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f6070a;
    }

    public void g() {
        this.f6073d = true;
        this.f6070a.f6078b.h();
    }

    static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final e f6077a;

        /* renamed from: b  reason: collision with root package name */
        final g f6078b;

        public int getChangingConfigurations() {
            return 0;
        }

        public a(e eVar, g gVar) {
            this.f6077a = eVar;
            this.f6078b = gVar;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new c(this);
        }
    }
}
