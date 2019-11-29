package com.google.android.material.c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.c.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13262a;

    /* renamed from: b  reason: collision with root package name */
    private final a f13263b;

    /* renamed from: c  reason: collision with root package name */
    private final View f13264c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f13265d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f13266e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f13267f;

    /* renamed from: g  reason: collision with root package name */
    private d.C0216d f13268g;
    private Drawable h;
    private boolean i;
    private boolean j;

    interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f13262a = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            f13262a = 1;
        } else {
            f13262a = 0;
        }
    }

    public void a() {
        if (f13262a == 0) {
            this.i = true;
            this.j = false;
            this.f13264c.buildDrawingCache();
            Bitmap drawingCache = this.f13264c.getDrawingCache();
            if (!(drawingCache != null || this.f13264c.getWidth() == 0 || this.f13264c.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.f13264c.getWidth(), this.f13264c.getHeight(), Bitmap.Config.ARGB_8888);
                this.f13264c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.f13266e.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (f13262a == 0) {
            this.j = false;
            this.f13264c.destroyDrawingCache();
            this.f13266e.setShader((Shader) null);
            this.f13264c.invalidate();
        }
    }

    public void a(d.C0216d dVar) {
        if (dVar == null) {
            this.f13268g = null;
        } else {
            d.C0216d dVar2 = this.f13268g;
            if (dVar2 == null) {
                this.f13268g = new d.C0216d(dVar);
            } else {
                dVar2.a(dVar);
            }
            if (com.google.android.material.e.a.b(dVar.f13275c, b(dVar), 1.0E-4f)) {
                this.f13268g.f13275c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public d.C0216d c() {
        d.C0216d dVar = this.f13268g;
        if (dVar == null) {
            return null;
        }
        d.C0216d dVar2 = new d.C0216d(dVar);
        if (dVar2.a()) {
            dVar2.f13275c = b(dVar2);
        }
        return dVar2;
    }

    public void a(int i2) {
        this.f13267f.setColor(i2);
        this.f13264c.invalidate();
    }

    public int d() {
        return this.f13267f.getColor();
    }

    public Drawable e() {
        return this.h;
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.f13264c.invalidate();
    }

    private void g() {
        if (f13262a == 1) {
            this.f13265d.rewind();
            d.C0216d dVar = this.f13268g;
            if (dVar != null) {
                this.f13265d.addCircle(dVar.f13273a, this.f13268g.f13274b, this.f13268g.f13275c, Path.Direction.CW);
            }
        }
        this.f13264c.invalidate();
    }

    private float b(d.C0216d dVar) {
        return com.google.android.material.e.a.a(dVar.f13273a, dVar.f13274b, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f13264c.getWidth(), (float) this.f13264c.getHeight());
    }

    public void a(Canvas canvas) {
        if (h()) {
            int i2 = f13262a;
            if (i2 == 0) {
                canvas.drawCircle(this.f13268g.f13273a, this.f13268g.f13274b, this.f13268g.f13275c, this.f13266e);
                if (i()) {
                    canvas.drawCircle(this.f13268g.f13273a, this.f13268g.f13274b, this.f13268g.f13275c, this.f13267f);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.f13265d);
                this.f13263b.a(canvas);
                if (i()) {
                    canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f13264c.getWidth(), (float) this.f13264c.getHeight(), this.f13267f);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.f13263b.a(canvas);
                if (i()) {
                    canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f13264c.getWidth(), (float) this.f13264c.getHeight(), this.f13267f);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + f13262a);
            }
        } else {
            this.f13263b.a(canvas);
            if (i()) {
                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.f13264c.getWidth(), (float) this.f13264c.getHeight(), this.f13267f);
            }
        }
        b(canvas);
    }

    private void b(Canvas canvas) {
        if (j()) {
            Rect bounds = this.h.getBounds();
            float width = this.f13268g.f13273a - (((float) bounds.width()) / 2.0f);
            float height = this.f13268g.f13274b - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.h.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public boolean f() {
        return this.f13263b.c() && !h();
    }

    private boolean h() {
        d.C0216d dVar = this.f13268g;
        boolean z = dVar == null || dVar.a();
        if (f13262a != 0) {
            return !z;
        }
        if (z || !this.j) {
            return false;
        }
        return true;
    }

    private boolean i() {
        return !this.i && Color.alpha(this.f13267f.getColor()) != 0;
    }

    private boolean j() {
        return (this.i || this.h == null || this.f13268g == null) ? false : true;
    }
}
