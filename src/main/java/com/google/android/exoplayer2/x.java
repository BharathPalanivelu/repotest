package com.google.android.exoplayer2;

import android.util.Pair;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f12293a = new x() {
        public int a(Object obj) {
            return -1;
        }

        public int b() {
            return 0;
        }

        public int c() {
            return 0;
        }

        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int a(Object obj);

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, boolean z, long j);

    public abstract int b();

    public abstract int c();

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f12301a;

        /* renamed from: b  reason: collision with root package name */
        public long f12302b;

        /* renamed from: c  reason: collision with root package name */
        public long f12303c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f12304d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12305e;

        /* renamed from: f  reason: collision with root package name */
        public int f12306f;

        /* renamed from: g  reason: collision with root package name */
        public int f12307g;
        public long h;
        public long i;
        public long j;

        public b a(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, int i3, long j6) {
            this.f12301a = obj;
            this.f12302b = j2;
            this.f12303c = j3;
            this.f12304d = z;
            this.f12305e = z2;
            this.h = j4;
            this.i = j5;
            this.f12306f = i2;
            this.f12307g = i3;
            this.j = j6;
            return this;
        }

        public long a() {
            return this.h;
        }

        public long b() {
            return b.a(this.i);
        }

        public long c() {
            return this.j;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f12294a;

        /* renamed from: b  reason: collision with root package name */
        public Object f12295b;

        /* renamed from: c  reason: collision with root package name */
        public int f12296c;

        /* renamed from: d  reason: collision with root package name */
        public long f12297d;

        /* renamed from: e  reason: collision with root package name */
        private long f12298e;

        /* renamed from: f  reason: collision with root package name */
        private long[] f12299f;

        /* renamed from: g  reason: collision with root package name */
        private int[] f12300g;
        private int[] h;
        private int[] i;
        private long[][] j;
        private long k;

        public a a(Object obj, Object obj2, int i2, long j2, long j3) {
            return a(obj, obj2, i2, j2, j3, (long[]) null, (int[]) null, (int[]) null, (int[]) null, (long[][]) null, -9223372036854775807L);
        }

        public a a(Object obj, Object obj2, int i2, long j2, long j3, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j4) {
            this.f12294a = obj;
            this.f12295b = obj2;
            this.f12296c = i2;
            this.f12297d = j2;
            this.f12298e = j3;
            this.f12299f = jArr;
            this.f12300g = iArr;
            this.h = iArr2;
            this.i = iArr3;
            this.j = jArr2;
            this.k = j4;
            return this;
        }

        public long a() {
            return this.f12297d;
        }

        public long b() {
            return b.a(this.f12298e);
        }

        public int c() {
            long[] jArr = this.f12299f;
            if (jArr == null) {
                return 0;
            }
            return jArr.length;
        }

        public long a(int i2) {
            return this.f12299f[i2];
        }

        public int b(int i2) {
            return this.i[i2];
        }

        public boolean c(int i2) {
            int[] iArr = this.f12300g;
            return iArr[i2] != -1 && this.i[i2] == iArr[i2];
        }

        public int a(long j2) {
            long[] jArr = this.f12299f;
            if (jArr == null) {
                return -1;
            }
            int length = jArr.length - 1;
            while (length >= 0) {
                long[] jArr2 = this.f12299f;
                if (jArr2[length] != Long.MIN_VALUE && jArr2[length] <= j2) {
                    break;
                }
                length--;
            }
            if (length < 0 || c(length)) {
                return -1;
            }
            return length;
        }

        public int b(long j2) {
            if (this.f12299f == null) {
                return -1;
            }
            int i2 = 0;
            while (true) {
                long[] jArr = this.f12299f;
                if (i2 < jArr.length && jArr[i2] != Long.MIN_VALUE && (j2 >= jArr[i2] || c(i2))) {
                    i2++;
                }
            }
            if (i2 < this.f12299f.length) {
                return i2;
            }
            return -1;
        }

        public int d(int i2) {
            return this.f12300g[i2];
        }

        public boolean a(int i2, int i3) {
            return i3 < this.h[i2];
        }

        public long b(int i2, int i3) {
            long[][] jArr = this.j;
            if (i3 >= jArr[i2].length) {
                return -9223372036854775807L;
            }
            return jArr[i2][i3];
        }

        public long d() {
            return this.k;
        }
    }

    public final boolean a() {
        return b() == 0;
    }

    public int a(int i, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 != 2) {
                throw new IllegalStateException();
            } else if (i == b() - 1) {
                return 0;
            } else {
                return i + 1;
            }
        } else if (i == b() - 1) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public final b a(int i, b bVar) {
        return a(i, bVar, false);
    }

    public b a(int i, b bVar, boolean z) {
        return a(i, bVar, z, 0);
    }

    public final int a(int i, a aVar, b bVar, int i2) {
        int i3 = a(i, aVar).f12296c;
        if (a(i3, bVar).f12307g != i) {
            return i + 1;
        }
        int a2 = a(i3, i2);
        if (a2 == -1) {
            return -1;
        }
        return a(a2, bVar).f12306f;
    }

    public final boolean b(int i, a aVar, b bVar, int i2) {
        return a(i, aVar, bVar, i2) == -1;
    }

    public final a a(int i, a aVar) {
        return a(i, aVar, false);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j, long j2) {
        com.google.android.exoplayer2.s.a.a(i, 0, b());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.a();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.f12306f;
        long c2 = bVar.c() + j;
        long a2 = a(i2, aVar).a();
        while (a2 != -9223372036854775807L && c2 >= a2 && i2 < bVar.f12307g) {
            c2 -= a2;
            i2++;
            a2 = a(i2, aVar).a();
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(c2));
    }
}
