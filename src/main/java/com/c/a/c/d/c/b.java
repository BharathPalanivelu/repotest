package com.c.a.c.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.c.a.c.b.p;
import com.c.a.c.b.s;
import com.c.a.c.d.e.c;
import com.c.a.i.h;

public abstract class b<T extends Drawable> implements p, s<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f6058a;

    public b(T t) {
        this.f6058a = (Drawable) h.a(t);
    }

    /* renamed from: f */
    public final T c() {
        return this.f6058a.getConstantState().newDrawable();
    }

    public void a() {
        T t = this.f6058a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof c) {
            ((c) t).b().prepareToDraw();
        }
    }
}
