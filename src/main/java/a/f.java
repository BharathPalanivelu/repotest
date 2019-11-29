package a;

import java.io.Closeable;

public class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f363a;

    /* renamed from: b  reason: collision with root package name */
    private g f364b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f365c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f366d;

    public void close() {
        synchronized (this.f363a) {
            if (!this.f366d) {
                this.f366d = true;
                this.f364b.a(this);
                this.f364b = null;
                this.f365c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f363a) {
            b();
            this.f365c.run();
            close();
        }
    }

    private void b() {
        if (this.f366d) {
            throw new IllegalStateException("Object already closed");
        }
    }
}
