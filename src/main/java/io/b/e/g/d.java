package io.b.e.g;

import io.b.p;
import java.util.concurrent.ThreadFactory;

public final class d extends p {

    /* renamed from: c  reason: collision with root package name */
    private static final g f33518c = new g("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f33519b;

    public d() {
        this(f33518c);
    }

    public d(ThreadFactory threadFactory) {
        this.f33519b = threadFactory;
    }

    public p.b a() {
        return new e(this.f33519b);
    }
}
