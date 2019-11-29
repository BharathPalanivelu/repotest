package com.google.android.exoplayer2.source.c.a;

import java.util.Collections;
import java.util.List;

public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public final int f11598a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11599b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11600c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11601d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11602e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11603f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11604g;
    public final long h;
    public final boolean i;
    public final boolean j;
    public final a k;
    public final List<a> l;
    public final List<String> m;
    public final long n;

    public static final class a implements Comparable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final String f11605a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11606b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11607c;

        /* renamed from: d  reason: collision with root package name */
        public final long f11608d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11609e;

        /* renamed from: f  reason: collision with root package name */
        public final String f11610f;

        /* renamed from: g  reason: collision with root package name */
        public final String f11611g;
        public final long h;
        public final long i;

        public a(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, false, (String) null, (String) null, j, j2);
        }

        public a(String str, long j, int i2, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.f11605a = str;
            this.f11606b = j;
            this.f11607c = i2;
            this.f11608d = j2;
            this.f11609e = z;
            this.f11610f = str2;
            this.f11611g = str3;
            this.h = j3;
            this.i = j4;
        }

        /* renamed from: a */
        public int compareTo(Long l) {
            if (this.f11608d > l.longValue()) {
                return 1;
            }
            return this.f11608d < l.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i2, String str, long j2, long j3, boolean z, int i3, int i4, int i5, long j4, boolean z2, boolean z3, a aVar, List<a> list, List<String> list2) {
        super(str);
        String str2 = str;
        this.f11598a = i2;
        this.f11600c = j3;
        this.f11601d = z;
        this.f11602e = i3;
        this.f11603f = i4;
        this.f11604g = i5;
        this.h = j4;
        this.i = z2;
        this.j = z3;
        this.k = aVar;
        this.l = Collections.unmodifiableList(list);
        if (!list.isEmpty()) {
            a aVar2 = list.get(list.size() - 1);
            this.n = aVar2.f11608d + aVar2.f11606b;
        } else {
            this.n = 0;
        }
        this.f11599b = j2 == -9223372036854775807L ? -9223372036854775807L : j2 >= 0 ? j2 : this.n + j2;
        this.m = Collections.unmodifiableList(list2);
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        int i2 = this.f11603f;
        int i3 = bVar.f11603f;
        if (i2 > i3) {
            return true;
        }
        if (i2 < i3) {
            return false;
        }
        int size = this.l.size();
        int size2 = bVar.l.size();
        if (size > size2) {
            return true;
        }
        if (size != size2 || !this.i || bVar.i) {
            return false;
        }
        return true;
    }

    public long a() {
        return this.f11600c + this.n;
    }

    public b a(long j2, int i2) {
        return new b(this.f11598a, this.o, this.f11599b, j2, true, i2, this.f11603f, this.f11604g, this.h, this.i, this.j, this.k, this.l, this.m);
    }

    public b b() {
        if (this.i) {
            return this;
        }
        return new b(this.f11598a, this.o, this.f11599b, this.f11600c, this.f11601d, this.f11602e, this.f11603f, this.f11604g, this.h, true, this.j, this.k, this.l, this.m);
    }
}
