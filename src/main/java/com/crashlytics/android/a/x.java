package com.crashlytics.android.a;

import com.path.android.jobqueue.JobManager;
import io.a.a.a.a.c.a.e;

class x {

    /* renamed from: a  reason: collision with root package name */
    long f6367a;

    /* renamed from: b  reason: collision with root package name */
    private e f6368b;

    public x(e eVar) {
        if (eVar != null) {
            this.f6368b = eVar;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    public boolean a(long j) {
        return j - this.f6367a >= this.f6368b.a() * JobManager.NS_PER_MS;
    }

    public void b(long j) {
        this.f6367a = j;
        this.f6368b = this.f6368b.b();
    }

    public void a() {
        this.f6367a = 0;
        this.f6368b = this.f6368b.c();
    }
}
