package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class aq extends ai {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1148a;

    public aq(Context context, Resources resources) {
        super(resources);
        this.f1148a = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1148a.get();
        if (!(drawable == null || context == null)) {
            ah.a().a(context, i, drawable);
        }
        return drawable;
    }
}
