package androidx.lifecycle;

import androidx.lifecycle.e;

class FullLifecycleObserverAdapter implements f {

    /* renamed from: a  reason: collision with root package name */
    private final b f2547a;

    /* renamed from: b  reason: collision with root package name */
    private final f f2548b;

    FullLifecycleObserverAdapter(b bVar, f fVar) {
        this.f2547a = bVar;
        this.f2548b = fVar;
    }

    public void onStateChanged(h hVar, e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f2547a.a(hVar);
                break;
            case ON_START:
                this.f2547a.b(hVar);
                break;
            case ON_RESUME:
                this.f2547a.c(hVar);
                break;
            case ON_PAUSE:
                this.f2547a.d(hVar);
                break;
            case ON_STOP:
                this.f2547a.e(hVar);
                break;
            case ON_DESTROY:
                this.f2547a.f(hVar);
                break;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        f fVar = this.f2548b;
        if (fVar != null) {
            fVar.onStateChanged(hVar, aVar);
        }
    }
}
