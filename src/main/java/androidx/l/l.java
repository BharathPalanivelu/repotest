package androidx.l;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class l implements TypeEvaluator<Rect> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f2502a;

    l() {
    }

    l(Rect rect) {
        this.f2502a = rect;
    }

    /* renamed from: a */
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i = rect.left + ((int) (((float) (rect2.left - rect.left)) * f2));
        int i2 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f2));
        int i3 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f2));
        int i4 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f2));
        Rect rect3 = this.f2502a;
        if (rect3 == null) {
            return new Rect(i, i2, i3, i4);
        }
        rect3.set(i, i2, i3, i4);
        return this.f2502a;
    }
}
