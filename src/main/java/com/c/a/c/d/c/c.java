package com.c.a.c.d.c;

import android.graphics.drawable.Drawable;
import com.c.a.c.b.s;

final class c extends b<Drawable> {
    public void e() {
    }

    public static s<Drawable> a(Drawable drawable) {
        return new c(drawable);
    }

    private c(Drawable drawable) {
        super(drawable);
    }

    public Class<Drawable> b() {
        return this.f6058a.getClass();
    }

    public int d() {
        return Math.max(1, this.f6058a.getIntrinsicWidth() * this.f6058a.getIntrinsicHeight() * 4);
    }
}
