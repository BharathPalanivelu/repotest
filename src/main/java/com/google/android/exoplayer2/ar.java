package com.google.android.exoplayer2;

public abstract class ar {

    /* renamed from: a  reason: collision with root package name */
    public static final ar f9122a = new ar() {
        public int a() {
            return 0;
        }

        public int a(Object obj) {
            return -1;
        }

        public int b() {
            return 0;
        }

        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract int a();

    public abstract int a(Object obj);

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, boolean z, long j);

    public abstract int b();

    public final boolean c() {
        return b() == 0;
    }

    public final b a(int i, b bVar) {
        return a(i, bVar, false);
    }

    public b a(int i, b bVar, boolean z) {
        return a(i, bVar, z, 0);
    }

    public final a a(int i, a aVar) {
        return a(i, aVar, false);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f9129a;

        /* renamed from: b  reason: collision with root package name */
        public long f9130b;

        /* renamed from: c  reason: collision with root package name */
        public long f9131c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9132d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9133e;

        /* renamed from: f  reason: collision with root package name */
        public int f9134f;

        /* renamed from: g  reason: collision with root package name */
        public int f9135g;
        public long h;
        public long i;
        public long j;

        public b a(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, int i3, long j6) {
            this.f9129a = obj;
            this.f9130b = j2;
            this.f9131c = j3;
            this.f9132d = z;
            this.f9133e = z2;
            this.h = j4;
            this.i = j5;
            this.f9134f = i2;
            this.f9135g = i3;
            this.j = j6;
            return this;
        }

        public long a() {
            return this.h;
        }

        public long b() {
            return z.a(this.i);
        }

        public long c() {
            return this.j;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f9123a;

        /* renamed from: b  reason: collision with root package name */
        public Object f9124b;

        /* renamed from: c  reason: collision with root package name */
        public int f9125c;

        /* renamed from: d  reason: collision with root package name */
        public long f9126d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9127e;

        /* renamed from: f  reason: collision with root package name */
        private long f9128f;

        public a a(Object obj, Object obj2, int i, long j, long j2, boolean z) {
            this.f9123a = obj;
            this.f9124b = obj2;
            this.f9125c = i;
            this.f9126d = j;
            this.f9128f = j2;
            this.f9127e = z;
            return this;
        }

        public long a() {
            return z.a(this.f9126d);
        }

        public long b() {
            return this.f9126d;
        }

        public long c() {
            return z.a(this.f9128f);
        }
    }
}
