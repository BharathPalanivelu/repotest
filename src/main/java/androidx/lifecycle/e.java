package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    AtomicReference<Object> f2575a = new AtomicReference<>();

    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public abstract b a();

    public abstract void a(g gVar);

    public abstract void b(g gVar);

    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
