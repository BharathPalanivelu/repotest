package androidx.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ac implements ad {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f2418a;

    ac(View view) {
        this.f2418a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f2418a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f2418a.remove(drawable);
    }
}
