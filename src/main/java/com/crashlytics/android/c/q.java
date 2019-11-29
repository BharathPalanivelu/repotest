package com.crashlytics.android.c;

import io.a.a.a.c;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

class q implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final a f6587a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f6588b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f6589c = new AtomicBoolean(false);

    interface a {
        void a(Thread thread, Throwable th);
    }

    public q(a aVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f6587a = aVar;
        this.f6588b = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f6589c.set(true);
        try {
            this.f6587a.a(thread, th);
        } catch (Exception e2) {
            c.h().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e2);
        } catch (Throwable th2) {
            c.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f6588b.uncaughtException(thread, th);
            this.f6589c.set(false);
            throw th2;
        }
        c.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        this.f6588b.uncaughtException(thread, th);
        this.f6589c.set(false);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f6589c.get();
    }
}
