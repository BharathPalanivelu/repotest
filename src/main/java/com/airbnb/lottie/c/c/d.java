package com.airbnb.lottie.c.c;

import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.g;
import java.util.List;
import java.util.Locale;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.airbnb.lottie.c.b.b> f3623a;

    /* renamed from: b  reason: collision with root package name */
    private final com.airbnb.lottie.d f3624b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3625c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3626d;

    /* renamed from: e  reason: collision with root package name */
    private final a f3627e;

    /* renamed from: f  reason: collision with root package name */
    private final long f3628f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3629g;
    private final List<g> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final com.airbnb.lottie.c.a.b s;
    private final List<com.airbnb.lottie.g.a<Float>> t;
    private final b u;

    public enum a {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    public enum b {
        None,
        Add,
        Invert,
        Unknown
    }

    public d(List<com.airbnb.lottie.c.b.b> list, com.airbnb.lottie.d dVar, String str, long j2, a aVar, long j3, String str2, List<g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, j jVar, k kVar, List<com.airbnb.lottie.g.a<Float>> list3, b bVar, com.airbnb.lottie.c.a.b bVar2) {
        this.f3623a = list;
        this.f3624b = dVar;
        this.f3625c = str;
        this.f3626d = j2;
        this.f3627e = aVar;
        this.f3628f = j3;
        this.f3629g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
    }

    /* access modifiers changed from: package-private */
    public com.airbnb.lottie.d a() {
        return this.f3624b;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.n / this.f3624b.k();
    }

    /* access modifiers changed from: package-private */
    public List<com.airbnb.lottie.g.a<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.f3626d;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return this.f3625c;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f3629g;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public List<g> j() {
        return this.h;
    }

    public a k() {
        return this.f3627e;
    }

    /* access modifiers changed from: package-private */
    public b l() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public long m() {
        return this.f3628f;
    }

    /* access modifiers changed from: package-private */
    public List<com.airbnb.lottie.c.b.b> n() {
        return this.f3623a;
    }

    /* access modifiers changed from: package-private */
    public l o() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public j s() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public k t() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public com.airbnb.lottie.c.a.b u() {
        return this.s;
    }

    public String toString() {
        return a("");
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        d a2 = this.f3624b.a(m());
        if (a2 != null) {
            sb.append("\t\tParents: ");
            sb.append(a2.f());
            d a3 = this.f3624b.a(a2.m());
            while (a3 != null) {
                sb.append("->");
                sb.append(a3.f());
                a3 = this.f3624b.a(a3.m());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(j().size());
            sb.append("\n");
        }
        if (!(r() == 0 || q() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())}));
        }
        if (!this.f3623a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.c.b.b next : this.f3623a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
