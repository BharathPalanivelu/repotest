package com.google.android.exoplayer2.e.c;

import com.google.android.exoplayer2.e.c.b;
import com.path.android.jobqueue.JobManager;

final class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f9371a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9372b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9373c;

    public a(long j, int i, long j2) {
        long j3;
        this.f9371a = j;
        this.f9372b = i;
        if (j2 == -1) {
            j3 = -9223372036854775807L;
        } else {
            j3 = a(j2);
        }
        this.f9373c = j3;
    }

    public boolean a() {
        return this.f9373c != -9223372036854775807L;
    }

    public long b(long j) {
        if (this.f9373c == -9223372036854775807L) {
            return 0;
        }
        return ((j * ((long) this.f9372b)) / 8000000) + this.f9371a;
    }

    public long a(long j) {
        return ((Math.max(0, j - this.f9371a) * JobManager.NS_PER_MS) * 8) / ((long) this.f9372b);
    }

    public long b() {
        return this.f9373c;
    }
}
