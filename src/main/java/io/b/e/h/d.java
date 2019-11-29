package io.b.e.h;

import io.b.e.g.f;
import io.b.g.a;

public final class d {
    public static void a() {
        if (!a.a()) {
            return;
        }
        if ((Thread.currentThread() instanceof f) || a.b()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
