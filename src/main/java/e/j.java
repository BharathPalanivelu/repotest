package e;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class j extends w {

    /* renamed from: a  reason: collision with root package name */
    private w f32742a;

    public j(w wVar) {
        if (wVar != null) {
            this.f32742a = wVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final w a() {
        return this.f32742a;
    }

    public final j a(w wVar) {
        if (wVar != null) {
            this.f32742a = wVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public w timeout(long j, TimeUnit timeUnit) {
        return this.f32742a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f32742a.timeoutNanos();
    }

    public boolean hasDeadline() {
        return this.f32742a.hasDeadline();
    }

    public long deadlineNanoTime() {
        return this.f32742a.deadlineNanoTime();
    }

    public w deadlineNanoTime(long j) {
        return this.f32742a.deadlineNanoTime(j);
    }

    public w clearTimeout() {
        return this.f32742a.clearTimeout();
    }

    public w clearDeadline() {
        return this.f32742a.clearDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f32742a.throwIfReached();
    }
}
