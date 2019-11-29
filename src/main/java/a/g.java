package a;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f367a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f368b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f369c = d.b();

    /* renamed from: d  reason: collision with root package name */
    private ScheduledFuture<?> f370d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f371e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f372f;

    public boolean a() {
        boolean z;
        synchronized (this.f367a) {
            d();
            z = this.f371e;
        }
        return z;
    }

    public e b() {
        e eVar;
        synchronized (this.f367a) {
            d();
            eVar = new e(this);
        }
        return eVar;
    }

    public void c() {
        synchronized (this.f367a) {
            d();
            if (!this.f371e) {
                e();
                this.f371e = true;
                ArrayList arrayList = new ArrayList(this.f368b);
                a((List<f>) arrayList);
            }
        }
    }

    public void close() {
        synchronized (this.f367a) {
            if (!this.f372f) {
                e();
                for (f close : this.f368b) {
                    close.close();
                }
                this.f368b.clear();
                this.f372f = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        synchronized (this.f367a) {
            d();
            this.f368b.remove(fVar);
        }
    }

    private void a(List<f> list) {
        for (f a2 : list) {
            a2.a();
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a())});
    }

    private void d() {
        if (this.f372f) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void e() {
        ScheduledFuture<?> scheduledFuture = this.f370d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f370d = null;
        }
    }
}
