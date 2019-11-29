package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.s.v;
import com.path.android.jobqueue.JobManager;
import java.util.List;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    final f f12033a;

    /* renamed from: b  reason: collision with root package name */
    final long f12034b;

    /* renamed from: c  reason: collision with root package name */
    final long f12035c;

    public h(f fVar, long j, long j2) {
        this.f12033a = fVar;
        this.f12034b = j;
        this.f12035c = j2;
    }

    public f a(g gVar) {
        return this.f12033a;
    }

    public long a() {
        return v.b(this.f12035c, JobManager.NS_PER_MS, this.f12034b);
    }

    public static class e extends h {

        /* renamed from: d  reason: collision with root package name */
        final long f12043d;

        /* renamed from: e  reason: collision with root package name */
        final long f12044e;

        public e(f fVar, long j, long j2, long j3, long j4) {
            super(fVar, j, j2);
            this.f12043d = j3;
            this.f12044e = j4;
        }

        public e() {
            this((f) null, 1, 0, 0, 0);
        }

        public f b() {
            long j = this.f12044e;
            if (j <= 0) {
                return null;
            }
            return new f((String) null, this.f12043d, j);
        }
    }

    public static abstract class a extends h {

        /* renamed from: d  reason: collision with root package name */
        final int f12036d;

        /* renamed from: e  reason: collision with root package name */
        final long f12037e;

        /* renamed from: f  reason: collision with root package name */
        final List<d> f12038f;

        public abstract int a(long j);

        public abstract f a(g gVar, int i);

        public a(f fVar, long j, long j2, int i, long j3, List<d> list) {
            super(fVar, j, j2);
            this.f12036d = i;
            this.f12037e = j3;
            this.f12038f = list;
        }

        public int a(long j, long j2) {
            int b2 = b();
            int a2 = a(j2);
            if (a2 == 0) {
                return b2;
            }
            if (this.f12038f == null) {
                int i = this.f12036d + ((int) (j / ((this.f12037e * JobManager.NS_PER_MS) / this.f12034b)));
                if (i < b2) {
                    return b2;
                }
                if (a2 == -1) {
                    return i;
                }
                return Math.min(i, (b2 + a2) - 1);
            }
            int i2 = (a2 + b2) - 1;
            int i3 = b2;
            while (i3 <= i2) {
                int i4 = ((i2 - i3) / 2) + i3;
                long a3 = a(i4);
                if (a3 < j) {
                    i3 = i4 + 1;
                } else if (a3 <= j) {
                    return i4;
                } else {
                    i2 = i4 - 1;
                }
            }
            return i3 == b2 ? i3 : i2;
        }

        public final long a(int i, long j) {
            List<d> list = this.f12038f;
            if (list != null) {
                return (list.get(i - this.f12036d).f12042b * JobManager.NS_PER_MS) / this.f12034b;
            }
            int a2 = a(j);
            return (a2 == -1 || i != (b() + a2) + -1) ? (this.f12037e * JobManager.NS_PER_MS) / this.f12034b : j - a(i);
        }

        public final long a(int i) {
            long j;
            List<d> list = this.f12038f;
            if (list != null) {
                j = list.get(i - this.f12036d).f12041a - this.f12035c;
            } else {
                j = ((long) (i - this.f12036d)) * this.f12037e;
            }
            return v.b(j, JobManager.NS_PER_MS, this.f12034b);
        }

        public int b() {
            return this.f12036d;
        }

        public boolean c() {
            return this.f12038f != null;
        }
    }

    public static class b extends a {

        /* renamed from: g  reason: collision with root package name */
        final List<f> f12039g;

        public boolean c() {
            return true;
        }

        public b(f fVar, long j, long j2, int i, long j3, List<d> list, List<f> list2) {
            super(fVar, j, j2, i, j3, list);
            this.f12039g = list2;
        }

        public f a(g gVar, int i) {
            return this.f12039g.get(i - this.f12036d);
        }

        public int a(long j) {
            return this.f12039g.size();
        }
    }

    public static class c extends a {

        /* renamed from: g  reason: collision with root package name */
        final j f12040g;
        final j h;

        public c(f fVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(fVar, j, j2, i, j3, list);
            this.f12040g = jVar;
            this.h = jVar2;
        }

        public f a(g gVar) {
            j jVar = this.f12040g;
            if (jVar != null) {
                return new f(jVar.a(gVar.f12026c.f8953a, 0, gVar.f12026c.f8954b, 0), 0, -1);
            }
            return super.a(gVar);
        }

        public f a(g gVar, int i) {
            long j;
            if (this.f12038f != null) {
                j = ((d) this.f12038f.get(i - this.f12036d)).f12041a;
            } else {
                j = ((long) (i - this.f12036d)) * this.f12037e;
            }
            long j2 = j;
            return new f(this.h.a(gVar.f12026c.f8953a, i, gVar.f12026c.f8954b, j2), 0, -1);
        }

        public int a(long j) {
            if (this.f12038f != null) {
                return this.f12038f.size();
            }
            if (j != -9223372036854775807L) {
                return (int) v.a(j, (this.f12037e * JobManager.NS_PER_MS) / this.f12034b);
            }
            return -1;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final long f12041a;

        /* renamed from: b  reason: collision with root package name */
        final long f12042b;

        public d(long j, long j2) {
            this.f12041a = j;
            this.f12042b = j2;
        }
    }
}
