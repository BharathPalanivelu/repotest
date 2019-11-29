package androidx.fragment.app;

import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.i;

class p implements h {

    /* renamed from: a  reason: collision with root package name */
    private i f2295a = null;

    p() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f2295a == null) {
            this.f2295a = new i(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f2295a != null;
    }

    public e getLifecycle() {
        a();
        return this.f2295a;
    }

    /* access modifiers changed from: package-private */
    public void a(e.a aVar) {
        this.f2295a.a(aVar);
    }
}
