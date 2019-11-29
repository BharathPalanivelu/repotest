package androidx.core.g;

import android.os.Build;
import android.view.WindowInsets;

public class ae {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1769a;

    private ae(Object obj) {
        this.f1769a = obj;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1769a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1769a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1769a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f1769a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f1769a).isConsumed();
        }
        return false;
    }

    public ae a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ae(((WindowInsets) this.f1769a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ae aeVar = (ae) obj;
        Object obj2 = this.f1769a;
        if (obj2 != null) {
            return obj2.equals(aeVar.f1769a);
        }
        if (aeVar.f1769a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f1769a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    static ae a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ae(obj);
    }

    static Object a(ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return aeVar.f1769a;
    }
}
