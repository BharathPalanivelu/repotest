package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f2990a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2991b = new a();

    private b(c cVar) {
        this.f2990a = cVar;
    }

    public a a() {
        return this.f2991b;
    }

    public void a(Bundle bundle) {
        e lifecycle = this.f2990a.getLifecycle();
        if (lifecycle.a() == e.b.INITIALIZED) {
            lifecycle.a(new Recreator(this.f2990a));
            this.f2991b.a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        this.f2991b.a(bundle);
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}
