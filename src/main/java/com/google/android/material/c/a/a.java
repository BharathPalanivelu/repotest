package com.google.android.material.c.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;
import com.google.android.material.c.c;
import com.google.android.material.c.d;

public class a extends CardView implements d {

    /* renamed from: e  reason: collision with root package name */
    private final c f13260e;

    public void a() {
        this.f13260e.a();
    }

    public void b() {
        this.f13260e.b();
    }

    public void setRevealInfo(d.C0216d dVar) {
        this.f13260e.a(dVar);
    }

    public d.C0216d getRevealInfo() {
        return this.f13260e.c();
    }

    public void setCircularRevealScrimColor(int i) {
        this.f13260e.a(i);
    }

    public int getCircularRevealScrimColor() {
        return this.f13260e.d();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f13260e.e();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f13260e.a(drawable);
    }

    public void draw(Canvas canvas) {
        c cVar = this.f13260e;
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
        c cVar = this.f13260e;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public boolean c() {
        return super.isOpaque();
    }
}
