package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;

class ReflectiveGenericLifecycleObserver implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2565a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0060a f2566b = a.f2568a.b(this.f2565a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2565a = obj;
    }

    public void onStateChanged(h hVar, e.a aVar) {
        this.f2566b.a(hVar, aVar, this.f2565a);
    }
}
