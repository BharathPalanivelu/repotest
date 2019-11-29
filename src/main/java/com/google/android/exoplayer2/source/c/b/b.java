package com.google.android.exoplayer2.source.c.b;

import java.util.Collections;
import java.util.List;

public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public final int f11644a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11645b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11646c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11647d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11648e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11649f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11650g;
    public final long h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final a l;
    public final List<a> m;
    public final long n;

    public static final class a implements Comparable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final String f11651a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11652b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11653c;

        /* renamed from: d  reason: collision with root package name */
        public final long f11654d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11655e;

        /* renamed from: f  reason: collision with root package name */
        public final String f11656f;

        /* renamed from: g  reason: collision with root package name */
        public final String f11657g;
        public final long h;
        public final long i;

        public a(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, false, (String) null, (String) null, j, j2);
        }

        public a(String str, long j, int i2, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.f11651a = str;
            this.f11652b = j;
            this.f11653c = i2;
            this.f11654d = j2;
            this.f11655e = z;
            this.f11656f = str2;
            this.f11657g = str3;
            this.h = j3;
            this.i = j4;
        }

        /* renamed from: a */
        public int compareTo(Long l) {
            if (this.f11654d > l.longValue()) {
                return 1;
            }
            return this.f11654d < l.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, List<String> list, long j2, long j3, boolean z, int i3, int i4, int i5, long j4, boolean z2, boolean z3, boolean z4, a aVar, List<a> list2) {
        super(str, list);
        String str2 = str;
        List<String> list3 = list;
        this.f11644a = i2;
        this.f11646c = j3;
        this.f11647d = z;
        this.f11648e = i3;
        this.f11649f = i4;
        this.f11650g = i5;
        this.h = j4;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = aVar;
        this.m = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            a aVar2 = list2.get(list2.size() - 1);
            this.n = aVar2.f11654d + aVar2.f11652b;
        } else {
            this.n = 0;
        }
        this.f11645b = j2 == -9223372036854775807L ? -9223372036854775807L : j2 >= 0 ? j2 : this.n + j2;
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        int i2 = this.f11649f;
        int i3 = bVar.f11649f;
        if (i2 > i3) {
            return true;
        }
        if (i2 < i3) {
            return false;
        }
        int size = this.m.size();
        int size2 = bVar.m.size();
        if (size > size2) {
            return true;
        }
        if (size != size2 || !this.j || bVar.j) {
            return false;
        }
        return true;
    }

    public long a() {
        return this.f11646c + this.n;
    }

    public b a(long j2, int i2) {
        return new b(this.f11644a, this.o, this.p, this.f11645b, j2, true, i2, this.f11649f, this.f11650g, this.h, this.i, this.j, this.k, this.l, this.m);
    }

    public b b() {
        if (this.j) {
            return this;
        }
        b bVar = r2;
        b bVar2 = new b(this.f11644a, this.o, this.p, this.f11645b, this.f11646c, this.f11647d, this.f11648e, this.f11649f, this.f11650g, this.h, this.i, true, this.k, this.l, this.m);
        return bVar;
    }
}
