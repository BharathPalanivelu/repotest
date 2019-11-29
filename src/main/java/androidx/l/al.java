package androidx.l;

import android.view.View;
import android.view.WindowId;

class al implements am {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f2450a;

    al(View view) {
        this.f2450a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof al) && ((al) obj).f2450a.equals(this.f2450a);
    }

    public int hashCode() {
        return this.f2450a.hashCode();
    }
}
