package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.l;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.path.android.jobqueue.JobManager;
import java.io.IOException;

abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private d f9543a;

    /* renamed from: b  reason: collision with root package name */
    private n f9544b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.exoplayer2.e.h f9545c;

    /* renamed from: d  reason: collision with root package name */
    private f f9546d;

    /* renamed from: e  reason: collision with root package name */
    private long f9547e;

    /* renamed from: f  reason: collision with root package name */
    private long f9548f;

    /* renamed from: g  reason: collision with root package name */
    private long f9549g;
    private int h;
    private int i;
    private a j;
    private long k;
    private boolean l;
    private boolean m;

    /* access modifiers changed from: protected */
    public abstract boolean a(k kVar, long j2, a aVar) throws IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract long b(k kVar);

    h() {
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        j f9550a;

        /* renamed from: b  reason: collision with root package name */
        f f9551b;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.google.android.exoplayer2.e.h hVar, n nVar) {
        this.f9545c = hVar;
        this.f9544b = nVar;
        this.f9543a = new d();
        a(true);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        if (z) {
            this.j = new a();
            this.f9548f = 0;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.f9547e = -1;
        this.f9549g = 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, long j3) {
        this.f9543a.a();
        if (j2 == 0) {
            a(!this.l);
        } else if (this.h != 0) {
            this.f9547e = this.f9546d.a(j3);
            this.h = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(g gVar, l lVar) throws IOException, InterruptedException {
        int i2 = this.h;
        if (i2 == 0) {
            return a(gVar);
        }
        if (i2 == 1) {
            gVar.b((int) this.f9548f);
            this.h = 2;
            return 0;
        } else if (i2 == 2) {
            return b(gVar, lVar);
        } else {
            throw new IllegalStateException();
        }
    }

    private int a(g gVar) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (!this.f9543a.a(gVar)) {
                this.h = 3;
                return -1;
            }
            this.k = gVar.c() - this.f9548f;
            z = a(this.f9543a.c(), this.f9548f, this.j);
            if (z) {
                this.f9548f = gVar.c();
            }
        }
        this.i = this.j.f9550a.s;
        if (!this.m) {
            this.f9544b.a(this.j.f9550a);
            this.m = true;
        }
        if (this.j.f9551b != null) {
            this.f9546d = this.j.f9551b;
        } else if (gVar.d() == -1) {
            this.f9546d = new b();
        } else {
            e b2 = this.f9543a.b();
            this.f9546d = new a(this.f9548f, gVar.d(), this, b2.h + b2.i, b2.f9535c);
        }
        this.j = null;
        this.h = 2;
        this.f9543a.d();
        return 0;
    }

    private int b(g gVar, l lVar) throws IOException, InterruptedException {
        g gVar2 = gVar;
        long a2 = this.f9546d.a(gVar2);
        if (a2 >= 0) {
            lVar.f9779a = a2;
            return 1;
        }
        if (a2 < -1) {
            c(-(a2 + 2));
        }
        if (!this.l) {
            this.f9545c.a(this.f9546d.c());
            this.l = true;
        }
        if (this.k > 0 || this.f9543a.a(gVar2)) {
            this.k = 0;
            k c2 = this.f9543a.c();
            long b2 = b(c2);
            if (b2 >= 0) {
                long j2 = this.f9549g;
                if (j2 + b2 >= this.f9547e) {
                    long a3 = a(j2);
                    this.f9544b.a(c2, c2.c());
                    this.f9544b.a(a3, 1, c2.c(), 0, (byte[]) null);
                    this.f9547e = -1;
                }
            }
            this.f9549g += b2;
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
        this.f9549g = j2;
    }

    private static final class b implements f {
        public long a(long j) {
            return 0;
        }

        public long a(g gVar) throws IOException, InterruptedException {
            return -1;
        }

        private b() {
        }

        public m c() {
            return new m.a(-9223372036854775807L);
        }
    }
}
