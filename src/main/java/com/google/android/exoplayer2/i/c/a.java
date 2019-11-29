package com.google.android.exoplayer2.i.c;

import com.google.android.exoplayer2.i.c.b;
import com.google.android.exoplayer2.s.v;
import com.path.android.jobqueue.JobManager;

final class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f10015a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10016b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10017c;

    public a(long j, int i, long j2) {
        long j3;
        this.f10015a = j;
        this.f10016b = i;
        if (j2 == -1) {
            j3 = -9223372036854775807L;
        } else {
            j3 = a(j2);
        }
        this.f10017c = j3;
    }

    public boolean a() {
        return this.f10017c != -9223372036854775807L;
    }

    public long b(long j) {
        long j2 = this.f10017c;
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        return this.f10015a + ((v.a(j, 0, j2) * ((long) this.f10016b)) / 8000000);
    }

    public long a(long j) {
        return ((Math.max(0, j - this.f10015a) * JobManager.NS_PER_MS) * 8) / ((long) this.f10016b);
    }

    public long b() {
        return this.f10017c;
    }
}
