package com.google.android.exoplayer2.n;

import com.facebook.common.time.Clock;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private long f10972a;

    /* renamed from: b  reason: collision with root package name */
    private long f10973b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f10974c = -9223372036854775807L;

    public q(long j) {
        a(j);
    }

    public synchronized void a(long j) {
        a.b(this.f10974c == -9223372036854775807L);
        this.f10972a = j;
    }

    public long a() {
        return this.f10972a;
    }

    public long b() {
        if (this.f10974c != -9223372036854775807L) {
            return this.f10974c;
        }
        long j = this.f10972a;
        if (j != Clock.MAX_TIME) {
            return j;
        }
        return -9223372036854775807L;
    }

    public long c() {
        if (this.f10972a == Clock.MAX_TIME) {
            return 0;
        }
        if (this.f10974c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f10973b;
    }

    public void d() {
        this.f10974c = -9223372036854775807L;
    }

    public long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f10974c != -9223372036854775807L) {
            long e2 = e(this.f10974c);
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
        if (this.f10974c != -9223372036854775807L) {
            this.f10974c = j;
        } else {
            long j2 = this.f10972a;
            if (j2 != Clock.MAX_TIME) {
                this.f10973b = j2 - j;
            }
            synchronized (this) {
                this.f10974c = j;
                notifyAll();
            }
        }
        return j + this.f10973b;
    }

    public synchronized void e() throws InterruptedException {
        while (this.f10974c == -9223372036854775807L) {
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
