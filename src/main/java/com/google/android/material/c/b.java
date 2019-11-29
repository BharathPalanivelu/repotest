package com.google.android.material.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.google.android.material.c.d;

public class b extends FrameLayout implements d {

    /* renamed from: a  reason: collision with root package name */
    private final c f13261a;

    public void a() {
        this.f13261a.a();
    }

    public void b() {
        this.f13261a.b();
    }

    public d.C0216d getRevealInfo() {
        return this.f13261a.c();
    }

    public void setRevealInfo(d.C0216d dVar) {
        this.f13261a.a(dVar);
    }

    public int getCircularRevealScrimColor() {
        return this.f13261a.d();
    }

    public void setCircularRevealScrimColor(int i) {
        this.f13261a.a(i);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f13261a.e();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f13261a.a(drawable);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f13261a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean isOpaque() {
        c cVar = this.f13261a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public boolean c() {
        return super.isOpaque();
    }
}
