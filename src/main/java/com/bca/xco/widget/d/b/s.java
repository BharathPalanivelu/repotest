package com.bca.xco.widget.d.b;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class s {

    /* renamed from: b  reason: collision with root package name */
    public static final s f5255b = new s() {
        public s a(long j) {
            return this;
        }

        public s a(long j, TimeUnit timeUnit) {
            return this;
        }

        public void g() {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f5256a;

    /* renamed from: c  reason: collision with root package name */
    private long f5257c;

    /* renamed from: d  reason: collision with root package name */
    private long f5258d;

    public s a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit != null) {
            this.f5258d = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long c_() {
        return this.f5258d;
    }

    public boolean d_() {
        return this.f5256a;
    }

    public long e_() {
        if (this.f5256a) {
            return this.f5257c;
        }
        throw new IllegalStateException("No deadline");
    }

    public s a(long j) {
        this.f5256a = true;
        this.f5257c = j;
        return this;
    }

    public s e() {
        this.f5258d = 0;
        return this;
    }

    public s f() {
        this.f5256a = false;
        return this;
    }

    public void g() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f5256a && this.f5257c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
