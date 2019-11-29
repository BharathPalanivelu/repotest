package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.x;

final class o {

    /* renamed from: a  reason: collision with root package name */
    private final x.a f10983a = new x.a();

    /* renamed from: b  reason: collision with root package name */
    private final x.b f10984b = new x.b();

    /* renamed from: c  reason: collision with root package name */
    private x f10985c;

    /* renamed from: d  reason: collision with root package name */
    private int f10986d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final i.b f10987a;

        /* renamed from: b  reason: collision with root package name */
        public final long f10988b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10989c;

        /* renamed from: d  reason: collision with root package name */
        public final long f10990d;

        /* renamed from: e  reason: collision with root package name */
        public final long f10991e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f10992f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f10993g;

        private a(i.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.f10987a = bVar;
            this.f10988b = j;
            this.f10989c = j2;
            this.f10990d = j3;
            this.f10991e = j4;
            this.f10992f = z;
            this.f10993g = z2;
        }

        public a a(int i) {
            return new a(this.f10987a.a(i), this.f10988b, this.f10989c, this.f10990d, this.f10991e, this.f10992f, this.f10993g);
        }

        public a a(long j) {
            return new a(this.f10987a, j, this.f10989c, this.f10990d, this.f10991e, this.f10992f, this.f10993g);
        }
    }

    public void a(x xVar) {
        this.f10985c = xVar;
    }

    public void a(int i) {
        this.f10986d = i;
    }

    public a a(i.b bVar) {
        return a(bVar.f9964a, bVar.f9966c, bVar.f9965b);
    }

    public a a(a aVar, long j, long j2) {
        long j3;
        a aVar2 = aVar;
        if (aVar2.f10992f) {
            int a2 = this.f10985c.a(aVar2.f10987a.f12083b, this.f10983a, this.f10984b, this.f10986d);
            if (a2 == -1) {
                return null;
            }
            int i = this.f10985c.a(a2, this.f10983a).f12296c;
            long j4 = 0;
            if (this.f10985c.a(i, this.f10984b).f12306f == a2) {
                Pair<Integer, Long> a3 = this.f10985c.a(this.f10984b, this.f10983a, i, -9223372036854775807L, Math.max(0, (j + aVar2.f10991e) - j2));
                if (a3 == null) {
                    return null;
                }
                a2 = ((Integer) a3.first).intValue();
                j4 = ((Long) a3.second).longValue();
            }
            return a(a(a2, j4), j4, j4);
        }
        i.b bVar = aVar2.f10987a;
        if (bVar.a()) {
            int i2 = bVar.f12084c;
            this.f10985c.a(bVar.f12083b, this.f10983a);
            int d2 = this.f10983a.d(i2);
            if (d2 == -1) {
                return null;
            }
            int i3 = bVar.f12085d + 1;
            if (i3 >= d2) {
                int b2 = this.f10983a.b(aVar2.f10990d);
                if (b2 == -1) {
                    j3 = Long.MIN_VALUE;
                } else {
                    j3 = this.f10983a.a(b2);
                }
                return a(bVar.f12083b, aVar2.f10990d, j3);
            } else if (!this.f10983a.a(i2, i3)) {
                return null;
            } else {
                return a(bVar.f12083b, i2, i3, aVar2.f10990d);
            }
        } else if (aVar2.f10989c != Long.MIN_VALUE) {
            int a4 = this.f10983a.a(aVar2.f10989c);
            if (!this.f10983a.a(a4, 0)) {
                return null;
            }
            return a(bVar.f12083b, a4, 0, aVar2.f10989c);
        } else {
            int c2 = this.f10983a.c();
            if (c2 != 0) {
                int i4 = c2 - 1;
                if (this.f10983a.a(i4) == Long.MIN_VALUE && !this.f10983a.c(i4) && this.f10983a.a(i4, 0)) {
                    return a(bVar.f12083b, i4, 0, this.f10983a.a());
                }
            }
            return null;
        }
    }

    public i.b a(int i, long j) {
        this.f10985c.a(i, this.f10983a);
        int a2 = this.f10983a.a(j);
        if (a2 == -1) {
            return new i.b(i);
        }
        return new i.b(i, a2, this.f10983a.b(a2));
    }

    public a a(a aVar) {
        return a(aVar, aVar.f10987a);
    }

    public a a(a aVar, int i) {
        return a(aVar, aVar.f10987a.a(i));
    }

    private a a(a aVar, i.b bVar) {
        long j;
        long a2;
        a aVar2 = aVar;
        i.b bVar2 = bVar;
        long j2 = aVar2.f10988b;
        long j3 = aVar2.f10989c;
        boolean a3 = a(bVar2, j3);
        boolean a4 = a(bVar2, a3);
        this.f10985c.a(bVar2.f12083b, this.f10983a);
        if (bVar.a()) {
            a2 = this.f10983a.b(bVar2.f12084c, bVar2.f12085d);
        } else if (j3 == Long.MIN_VALUE) {
            a2 = this.f10983a.a();
        } else {
            j = j3;
            return new a(bVar, j2, j3, aVar2.f10990d, j, a3, a4);
        }
        j = a2;
        return new a(bVar, j2, j3, aVar2.f10990d, j, a3, a4);
    }

    private a a(i.b bVar, long j, long j2) {
        long j3;
        this.f10985c.a(bVar.f12083b, this.f10983a);
        if (!bVar.a()) {
            int b2 = this.f10983a.b(j2);
            if (b2 == -1) {
                j3 = Long.MIN_VALUE;
            } else {
                j3 = this.f10983a.a(b2);
            }
            return a(bVar.f12083b, j2, j3);
        } else if (!this.f10983a.a(bVar.f12084c, bVar.f12085d)) {
            return null;
        } else {
            return a(bVar.f12083b, bVar.f12084c, bVar.f12085d, j);
        }
    }

    private a a(int i, int i2, int i3, long j) {
        int i4 = i2;
        int i5 = i3;
        i.b bVar = new i.b(i, i4, i5);
        boolean a2 = a(bVar, Long.MIN_VALUE);
        boolean a3 = a(bVar, a2);
        return new a(bVar, i5 == this.f10983a.b(i4) ? this.f10983a.d() : 0, Long.MIN_VALUE, j, this.f10985c.a(bVar.f12083b, this.f10983a).b(bVar.f12084c, bVar.f12085d), a2, a3);
    }

    private a a(int i, long j, long j2) {
        long j3 = j2;
        i.b bVar = new i.b(i);
        boolean a2 = a(bVar, j3);
        boolean a3 = a(bVar, a2);
        this.f10985c.a(bVar.f12083b, this.f10983a);
        return new a(bVar, j, j2, -9223372036854775807L, j3 == Long.MIN_VALUE ? this.f10983a.a() : j3, a2, a3);
    }

    private boolean a(i.b bVar, long j) {
        int c2 = this.f10985c.a(bVar.f12083b, this.f10983a).c();
        if (c2 == 0) {
            return true;
        }
        int i = c2 - 1;
        boolean a2 = bVar.a();
        if (this.f10983a.a(i) == Long.MIN_VALUE) {
            int d2 = this.f10983a.d(i);
            if (d2 == -1) {
                return false;
            }
            if (a2 && bVar.f12084c == i && bVar.f12085d == d2 + -1) {
                return true;
            }
            if (a2 || this.f10983a.b(i) != d2) {
                return false;
            }
            return true;
        } else if (a2 || j != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(i.b bVar, boolean z) {
        return !this.f10985c.a(this.f10985c.a(bVar.f12083b, this.f10983a).f12296c, this.f10984b).f12305e && this.f10985c.b(bVar.f12083b, this.f10983a, this.f10984b, this.f10986d) && z;
    }
}
