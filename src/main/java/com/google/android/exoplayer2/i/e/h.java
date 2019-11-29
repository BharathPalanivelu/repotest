package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;
import com.path.android.jobqueue.JobManager;
import java.io.IOException;

abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private final d f10177a = new d();

    /* renamed from: b  reason: collision with root package name */
    private m f10178b;

    /* renamed from: c  reason: collision with root package name */
    private g f10179c;

    /* renamed from: d  reason: collision with root package name */
    private f f10180d;

    /* renamed from: e  reason: collision with root package name */
    private long f10181e;

    /* renamed from: f  reason: collision with root package name */
    private long f10182f;

    /* renamed from: g  reason: collision with root package name */
    private long f10183g;
    private int h;
    private int i;
    private a j;
    private long k;
    private boolean l;
    private boolean m;

    /* access modifiers changed from: protected */
    public abstract boolean a(l lVar, long j2, a aVar) throws IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract long b(l lVar);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Format f10184a;

        /* renamed from: b  reason: collision with root package name */
        f f10185b;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar, m mVar) {
        this.f10179c = gVar;
        this.f10178b = mVar;
        a(true);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        if (z) {
            this.j = new a();
            this.f10182f = 0;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.f10181e = -1;
        this.f10183g = 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, long j3) {
        this.f10177a.a();
        if (j2 == 0) {
            a(!this.l);
        } else if (this.h != 0) {
            this.f10181e = this.f10180d.a(j3);
            this.h = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(f fVar, k kVar) throws IOException, InterruptedException {
        int i2 = this.h;
        if (i2 == 0) {
            return a(fVar);
        }
        if (i2 == 1) {
            fVar.b((int) this.f10182f);
            this.h = 2;
            return 0;
        } else if (i2 == 2) {
            return b(fVar, kVar);
        } else {
            throw new IllegalStateException();
        }
    }

    private int a(f fVar) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (!this.f10177a.a(fVar)) {
                this.h = 3;
                return -1;
            }
            this.k = fVar.c() - this.f10182f;
            z = a(this.f10177a.c(), this.f10182f, this.j);
            if (z) {
                this.f10182f = fVar.c();
            }
        }
        this.i = this.j.f10184a.s;
        if (!this.m) {
            this.f10178b.a(this.j.f10184a);
            this.m = true;
        }
        if (this.j.f10185b != null) {
            this.f10180d = this.j.f10185b;
        } else if (fVar.d() == -1) {
            this.f10180d = new b();
        } else {
            e b2 = this.f10177a.b();
            this.f10180d = new a(this.f10182f, fVar.d(), this, b2.h + b2.i, b2.f10169c);
        }
        this.j = null;
        this.h = 2;
        this.f10177a.d();
        return 0;
    }

    private int b(f fVar, k kVar) throws IOException, InterruptedException {
        f fVar2 = fVar;
        long a2 = this.f10180d.a(fVar2);
        if (a2 >= 0) {
            kVar.f10416a = a2;
            return 1;
        }
        if (a2 < -1) {
            c(-(a2 + 2));
        }
        if (!this.l) {
            this.f10179c.a(this.f10180d.c());
            this.l = true;
        }
        if (this.k > 0 || this.f10177a.a(fVar2)) {
            this.k = 0;
            l c2 = this.f10177a.c();
            long b2 = b(c2);
            if (b2 >= 0) {
                long j2 = this.f10183g;
                if (j2 + b2 >= this.f10181e) {
                    long a3 = a(j2);
                    this.f10178b.a(c2, c2.c());
                    this.f10178b.a(a3, 1, c2.c(), 0, (m.a) null);
                    this.f10181e = -1;
                }
            }
            this.f10183g += b2;
            return 0;
        }
        this.h = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public long a(long j2) {
        return (j2 * JobManager.NS_PER_MS) / ((long) this.i);
    }

    /* access modifiers changed from: protected */
    public long b(long j2) {
        return (((long) this.i) * j2) / JobManager.NS_PER_MS;
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        this.f10183g = j2;
    }

    private static final class b implements f {
        public long a(long j) {
            return 0;
        }

        public long a(f fVar) throws IOException, InterruptedException {
            return -1;
        }

        private b() {
        }

        public com.google.android.exoplayer2.i.l c() {
            return new l.a(-9223372036854775807L);
        }
    }
}
