package com.google.android.exoplayer2.source.dash.a;

import com.google.android.exoplayer2.n.t;
import com.path.android.jobqueue.JobManager;
import java.util.List;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    final e f11877a;

    /* renamed from: b  reason: collision with root package name */
    final long f11878b;

    /* renamed from: c  reason: collision with root package name */
    final long f11879c;

    public h(e eVar, long j, long j2) {
        this.f11877a = eVar;
        this.f11878b = j;
        this.f11879c = j2;
    }

    public e a(f fVar) {
        return this.f11877a;
    }

    public long a() {
        return t.a(this.f11879c, (long) JobManager.NS_PER_MS, this.f11878b);
    }

    public static class e extends h {

        /* renamed from: d  reason: collision with root package name */
        final long f11887d;

        /* renamed from: e  reason: collision with root package name */
        final long f11888e;

        public e(e eVar, long j, long j2, long j3, long j4) {
            super(eVar, j, j2);
            this.f11887d = j3;
            this.f11888e = j4;
        }

        public e() {
            this((e) null, 1, 0, 0, 0);
        }

        public e b() {
            long j = this.f11888e;
            if (j <= 0) {
                return null;
            }
            return new e((String) null, this.f11887d, j);
        }
    }

    public static abstract class a extends h {

        /* renamed from: d  reason: collision with root package name */
        final int f11880d;

        /* renamed from: e  reason: collision with root package name */
        final long f11881e;

        /* renamed from: f  reason: collision with root package name */
        final List<d> f11882f;

        public abstract int a(long j);

        public abstract e a(f fVar, int i);

        public a(e eVar, long j, long j2, int i, long j3, List<d> list) {
            super(eVar, j, j2);
            this.f11880d = i;
            this.f11881e = j3;
            this.f11882f = list;
        }

        public int a(long j, long j2) {
            int b2 = b();
            int a2 = a(j2);
            if (a2 == 0) {
                return b2;
            }
            if (this.f11882f == null) {
                int i = this.f11880d + ((int) (j / ((this.f11881e * JobManager.NS_PER_MS) / this.f11878b)));
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
            List<d> list = this.f11882f;
            if (list != null) {
                return (list.get(i - this.f11880d).f11886b * JobManager.NS_PER_MS) / this.f11878b;
            }
            int a2 = a(j);
            return (a2 == -1 || i != (b() + a2) + -1) ? (this.f11881e * JobManager.NS_PER_MS) / this.f11878b : j - a(i);
        }

        public final long a(int i) {
            long j;
            List<d> list = this.f11882f;
            if (list != null) {
                j = list.get(i - this.f11880d).f11885a - this.f11879c;
            } else {
                j = ((long) (i - this.f11880d)) * this.f11881e;
            }
            return t.a(j, (long) JobManager.NS_PER_MS, this.f11878b);
        }

        public int b() {
            return this.f11880d;
        }

        public boolean c() {
            return this.f11882f != null;
        }
    }

    public static class b extends a {

        /* renamed from: g  reason: collision with root package name */
        final List<e> f11883g;

        public boolean c() {
            return true;
        }

        public b(e eVar, long j, long j2, int i, long j3, List<d> list, List<e> list2) {
            super(eVar, j, j2, i, j3, list);
            this.f11883g = list2;
        }

        public e a(f fVar, int i) {
            return this.f11883g.get(i - this.f11880d);
        }

        public int a(long j) {
            return this.f11883g.size();
        }
    }

    public static class c extends a {

        /* renamed from: g  reason: collision with root package name */
        final j f11884g;
        final j h;

        public c(e eVar, long j, long j2, int i, long j3, List<d> list, j jVar, j jVar2) {
            super(eVar, j, j2, i, j3, list);
            this.f11884g = jVar;
            this.h = jVar2;
        }

        public e a(f fVar) {
            j jVar = this.f11884g;
            if (jVar != null) {
                return new e(jVar.a(fVar.f11868c.f10422a, 0, fVar.f11868c.f10423b, 0), 0, -1);
            }
            return super.a(fVar);
        }

        public e a(f fVar, int i) {
            long j;
            if (this.f11882f != null) {
                j = ((d) this.f11882f.get(i - this.f11880d)).f11885a;
            } else {
                j = ((long) (i - this.f11880d)) * this.f11881e;
            }
            long j2 = j;
            return new e(this.h.a(fVar.f11868c.f10422a, i, fVar.f11868c.f10423b, j2), 0, -1);
        }

        public int a(long j) {
            if (this.f11882f != null) {
                return this.f11882f.size();
            }
            if (j != -9223372036854775807L) {
                return (int) t.a(j, (this.f11881e * JobManager.NS_PER_MS) / this.f11878b);
            }
            return -1;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final long f11885a;

        /* renamed from: b  reason: collision with root package name */
        final long f11886b;

        public d(long j, long j2) {
            this.f11885a = j;
            this.f11886b = j2;
        }
    }
}
