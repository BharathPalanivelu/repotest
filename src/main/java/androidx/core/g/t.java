package androidx.core.g;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private Object f1801a;

    private t(Object obj) {
        this.f1801a = obj;
    }

    public Object a() {
        return this.f1801a;
    }

    public static t a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new t(PointerIcon.getSystemIcon(context, i));
        }
        return new t((Object) null);
    }
}
