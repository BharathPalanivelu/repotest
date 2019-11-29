package androidx.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class w implements x {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f2540a;

    w(ViewGroup viewGroup) {
        this.f2540a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f2540a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f2540a.remove(drawable);
    }

    public void a(View view) {
        this.f2540a.add(view);
    }

    public void b(View view) {
        this.f2540a.remove(view);
    }
}
