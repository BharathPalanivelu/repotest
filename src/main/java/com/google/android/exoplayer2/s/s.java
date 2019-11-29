package com.google.android.exoplayer2.s;

import com.facebook.common.time.Clock;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private long f11446a;

    /* renamed from: b  reason: collision with root package name */
    private long f11447b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f11448c = -9223372036854775807L;

    public s(long j) {
        a(j);
    }

    public synchronized void a(long j) {
        a.b(this.f11448c == -9223372036854775807L);
        this.f11446a = j;
    }

    public long a() {
        return this.f11446a;
    }

    public long b() {
        if (this.f11448c != -9223372036854775807L) {
            return this.f11448c;
        }
        long j = this.f11446a;
        if (j != Clock.MAX_TIME) {
            return j;
        }
        return -9223372036854775807L;
    }

    public long c() {
        if (this.f11446a == Clock.MAX_TIME) {
            return 0;
        }
        if (this.f11448c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f11447b;
    }

    public void d() {
        this.f11448c = -9223372036854775807L;
    }

    public long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f11448c != -9223372036854775807L) {
            long e2 = e(this.f11448c);
            long j2 = (IjkMediaMeta.AV_CH_WIDE_RIGHT + e2) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            long j3 = ((j2 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j;
            j += j2 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            if (Math.abs(j3 - e2) < Math.abs(j - e2)) {
                j = j3;
            }
        }
        return c(d(j));
    }

    public long c(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f11448c != -9223372036854775807L) {
            this.f11448c = j;
        } else {
            long j2 = this.f11446a;
            if (j2 != Clock.MAX_TIME) {
                this.f11447b = j2 - j;
            }
            synchronized (this) {
                this.f11448c = j;
                notifyAll();
            }
        }
        return j + this.f11447b;
    }

    public synchronized void e() throws InterruptedException {
        while (this.f11448c == -9223372036854775807L) {
            wait();
        }
    }

    public static long d(long j) {
        return (j * JobManager.NS_PER_MS) / 90000;
    }

    public static long e(long j) {
        return (j * 90000) / JobManager.NS_PER_MS;
    }
}
