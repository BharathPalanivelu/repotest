package io.b.e.h;

import java.util.concurrent.atomic.AtomicReference;

public final class c extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean a(Throwable th) {
        return f.a(this, th);
    }

    public Throwable a() {
        return f.a((AtomicReference<Throwable>) this);
    }
}
