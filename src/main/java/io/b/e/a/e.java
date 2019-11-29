package io.b.e.a;

import io.b.b.b;
import java.util.concurrent.atomic.AtomicReference;

public final class e extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public boolean a(b bVar) {
        return b.replace(this, bVar);
    }

    public void dispose() {
        b.dispose(this);
    }

    public boolean isDisposed() {
        return b.isDisposed((b) get());
    }
}
