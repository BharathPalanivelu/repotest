package com.google.android.exoplayer2.source.c;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.d.e;
import com.google.android.exoplayer2.e.d;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.e.m;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.l.f;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.m.r;
import com.google.android.exoplayer2.source.a.c;
import com.google.android.exoplayer2.source.aa;
import com.google.android.exoplayer2.source.ac;
import com.google.android.exoplayer2.source.ad;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.c.o;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.z;
import java.io.IOException;
import java.util.LinkedList;

final class v implements d.c, h, r.a<c>, aa {

    /* renamed from: a  reason: collision with root package name */
    private final int f11759a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11760b;

    /* renamed from: c  reason: collision with root package name */
    private final o f11761c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11762d;

    /* renamed from: e  reason: collision with root package name */
    private final j f11763e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11764f;

    /* renamed from: g  reason: collision with root package name */
    private final r f11765g = new r("Loader:HlsSampleStreamWrapper");
    private final r.a h;
    private final o.b i = new o.b();
    private final SparseArray<d> j = new SparseArray<>();
    private final LinkedList<r> k = new LinkedList<>();
    private final Runnable l = new Runnable() {
        public void run() {
            v.this.i();
        }
    };
    private final Handler m = new Handler();
    private boolean n;
    private boolean o;
    private int p;
    private j q;
    private int r;
    private boolean s;
    private ad t;
    private int u;
    private boolean[] v;
    private long w;
    private long x;
    private boolean y;

    public interface a extends aa.a<v> {
        void a(a.C0186a aVar);

        void h();
    }

    public void a(m mVar) {
    }

    public v(int i2, a aVar, o oVar, b bVar, long j2, j jVar, int i3, r.a aVar2) {
        this.f11759a = i2;
        this.f11760b = aVar;
        this.f11761c = oVar;
        this.f11762d = bVar;
        this.f11763e = jVar;
        this.f11764f = i3;
        this.h = aVar2;
        this.w = j2;
        this.x = j2;
    }

    public void b() {
        if (!this.o) {
            d(this.w);
        }
    }

    public void b(j jVar) {
        a(0, -1).a(jVar);
        this.n = true;
        i();
    }

    public void c() throws IOException {
        h();
    }

    public ad d() {
        return this.t;
    }

    public boolean a(f[] fVarArr, boolean[] zArr, z[] zVarArr, boolean[] zArr2, boolean z) {
        com.google.android.exoplayer2.n.a.b(this.o);
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (zVarArr[i2] != null && (fVarArr[i2] == null || !zArr[i2])) {
                int i3 = zVarArr[i2].f11757a;
                b(i3, false);
                this.j.valueAt(i3).c();
                zVarArr[i2] = null;
            }
        }
        f fVar = null;
        boolean z2 = false;
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            if (zVarArr[i4] == null && fVarArr[i4] != null) {
                f fVar2 = fVarArr[i4];
                int a2 = this.t.a(fVar2.d());
                b(a2, true);
                if (a2 == this.u) {
                    this.f11761c.a(fVar2);
                    fVar = fVar2;
                }
                zVarArr[i4] = new u(this, a2);
                zArr2[i4] = true;
                z2 = true;
            }
        }
        if (z) {
            int size = this.j.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!this.v[i5]) {
                    this.j.valueAt(i5).c();
                }
            }
            if (fVar != null && !this.k.isEmpty()) {
                fVar.a(0);
                if (fVar.g() != this.f11761c.b().a(this.k.getLast().f11498c)) {
                    a(this.w);
                }
            }
        }
        if (this.p == 0) {
            this.f11761c.c();
            this.q = null;
            this.k.clear();
            if (this.f11765g.a()) {
                this.f11765g.b();
            }
        }
        return z2;
    }

    public void a(long j2) {
        this.w = j2;
        this.x = j2;
        this.y = false;
        this.k.clear();
        if (this.f11765g.a()) {
            this.f11765g.b();
            return;
        }
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.valueAt(i2).a(this.v[i2]);
        }
    }

    public long e() {
        if (this.y) {
            return Long.MIN_VALUE;
        }
        if (k()) {
            return this.x;
        }
        long j2 = this.w;
        r last = this.k.getLast();
        if (!last.g()) {
            if (this.k.size() > 1) {
                LinkedList<r> linkedList = this.k;
                last = linkedList.get(linkedList.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j2 = Math.max(j2, last.f11502g);
        }
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, this.j.valueAt(i2).h());
        }
        return j2;
    }

    public void g() {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.valueAt(i2).c();
        }
        this.f11765g.c();
        this.m.removeCallbacksAndMessages((Object) null);
        this.s = true;
    }

    public void a(boolean z) {
        this.f11761c.a(z);
    }

    public void a(a.C0186a aVar, long j2) {
        this.f11761c.a(aVar, j2);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return this.y || (!k() && !this.j.valueAt(i2).d());
    }

    /* access modifiers changed from: package-private */
    public void h() throws IOException {
        this.f11765g.d();
        this.f11761c.a();
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, ah ahVar, e eVar, boolean z) {
        if (k()) {
            return -3;
        }
        while (this.k.size() > 1 && a(this.k.getFirst())) {
            this.k.removeFirst();
        }
        r first = this.k.getFirst();
        j jVar = first.f11498c;
        if (!jVar.equals(this.q)) {
            this.h.a(this.f11759a, jVar, first.f11499d, first.f11500e, first.f11501f);
        }
        this.q = jVar;
        return this.j.valueAt(i2).a(ahVar, eVar, z, this.y, this.w);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        d valueAt = this.j.valueAt(i2);
        if (!this.y || j2 <= valueAt.h()) {
            valueAt.a(j2, true);
        } else {
            valueAt.i();
        }
    }

    private boolean a(r rVar) {
        int i2 = rVar.j;
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            if (this.v[i3] && this.j.valueAt(i3).f() == i2) {
                return false;
            }
        }
        return true;
    }

    public boolean d(long j2) {
        if (this.y || this.f11765g.a()) {
            return false;
        }
        o oVar = this.f11761c;
        r last = this.k.isEmpty() ? null : this.k.getLast();
        long j3 = this.x;
        if (j3 == -9223372036854775807L) {
            j3 = j2;
        }
        oVar.a(last, j3, this.i);
        boolean z = this.i.f11739b;
        c cVar = this.i.f11738a;
        a.C0186a aVar = this.i.f11740c;
        this.i.a();
        if (z) {
            this.y = true;
            return true;
        } else if (cVar == null) {
            if (aVar != null) {
                this.f11760b.a(aVar);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.x = -9223372036854775807L;
                r rVar = (r) cVar;
                rVar.a(this);
                this.k.add(rVar);
            }
            this.h.a(cVar.f11496a, cVar.f11497b, this.f11759a, cVar.f11498c, cVar.f11499d, cVar.f11500e, cVar.f11501f, cVar.f11502g, this.f11765g.a(cVar, this, this.f11764f));
            return true;
        }
    }

    public long f() {
        if (k()) {
            return this.x;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return this.k.getLast().f11502g;
    }

    public void a(c cVar, long j2, long j3) {
        c cVar2 = cVar;
        this.f11761c.a(cVar2);
        this.h.a(cVar2.f11496a, cVar2.f11497b, this.f11759a, cVar2.f11498c, cVar2.f11499d, cVar2.f11500e, cVar2.f11501f, cVar2.f11502g, j2, j3, cVar.e());
        if (!this.o) {
            d(this.w);
        } else {
            this.f11760b.a(this);
        }
    }

    public void a(c cVar, long j2, long j3, boolean z) {
        c cVar2 = cVar;
        this.h.b(cVar2.f11496a, cVar2.f11497b, this.f11759a, cVar2.f11498c, cVar2.f11499d, cVar2.f11500e, cVar2.f11501f, cVar2.f11502g, j2, j3, cVar.e());
        if (!z) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.j.valueAt(i2).a(this.v[i2]);
            }
            this.f11760b.a(this);
        }
    }

    public int a(c cVar, long j2, long j3, IOException iOException) {
        c cVar2 = cVar;
        long e2 = cVar.e();
        boolean a2 = a(cVar);
        boolean z = true;
        if (!this.f11761c.a(cVar2, !a2 || e2 == 0, iOException)) {
            z = false;
        } else if (a2) {
            com.google.android.exoplayer2.n.a.b(this.k.removeLast() == cVar2);
            if (this.k.isEmpty()) {
                this.x = this.w;
            }
        }
        this.h.a(cVar2.f11496a, cVar2.f11497b, this.f11759a, cVar2.f11498c, cVar2.f11499d, cVar2.f11500e, cVar2.f11501f, cVar2.f11502g, j2, j3, cVar.e(), iOException, z);
        if (!z) {
            return 0;
        }
        if (!this.o) {
            d(this.w);
            return 2;
        }
        this.f11760b.a(this);
        return 2;
    }

    public void a(int i2, boolean z) {
        this.r = i2;
        for (int i3 = 0; i3 < this.j.size(); i3++) {
            this.j.valueAt(i3).a(i2);
        }
        if (z) {
            for (int i4 = 0; i4 < this.j.size(); i4++) {
                this.j.valueAt(i4).a();
            }
        }
    }

    /* renamed from: b */
    public d a(int i2, int i3) {
        if (this.j.indexOfKey(i2) >= 0) {
            return this.j.get(i2);
        }
        d dVar = new d(this.f11762d);
        dVar.a((d.c) this);
        dVar.a(this.r);
        this.j.put(i2, dVar);
        return dVar;
    }

    public void a() {
        this.n = true;
        this.m.post(this.l);
    }

    public void a(j jVar) {
        this.m.post(this.l);
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!this.s && !this.o && this.n) {
            int size = this.j.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.j.valueAt(i2).g() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            j();
            this.o = true;
            this.f11760b.h();
        }
    }

    private void j() {
        int size = this.j.size();
        int i2 = 0;
        char c2 = 0;
        int i3 = -1;
        while (true) {
            char c3 = 3;
            if (i2 >= size) {
                break;
            }
            String str = this.j.valueAt(i2).g().f10427f;
            if (!com.google.android.exoplayer2.n.h.b(str)) {
                if (com.google.android.exoplayer2.n.h.a(str)) {
                    c3 = 2;
                } else {
                    c3 = com.google.android.exoplayer2.n.h.c(str) ? (char) 1 : 0;
                }
            }
            if (c3 > c2) {
                i3 = i2;
                c2 = c3;
            } else if (c3 == c2 && i3 != -1) {
                i3 = -1;
            }
            i2++;
        }
        ac b2 = this.f11761c.b();
        int i4 = b2.f11534a;
        this.u = -1;
        this.v = new boolean[size];
        ac[] acVarArr = new ac[size];
        for (int i5 = 0; i5 < size; i5++) {
            j g2 = this.j.valueAt(i5).g();
            if (i5 == i3) {
                j[] jVarArr = new j[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    jVarArr[i6] = a(b2.a(i6), g2);
                }
                acVarArr[i5] = new ac(jVarArr);
                this.u = i5;
            } else {
                acVarArr[i5] = new ac(a((c2 != 3 || !com.google.android.exoplayer2.n.h.a(g2.f10427f)) ? null : this.f11763e, g2));
            }
        }
        this.t = new ad(acVarArr);
    }

    private void b(int i2, boolean z) {
        int i3 = 1;
        com.google.android.exoplayer2.n.a.b(this.v[i2] != z);
        this.v[i2] = z;
        int i4 = this.p;
        if (!z) {
            i3 = -1;
        }
        this.p = i4 + i3;
    }

    private static j a(j jVar, j jVar2) {
        if (jVar == null) {
            return jVar2;
        }
        String str = null;
        int g2 = com.google.android.exoplayer2.n.h.g(jVar2.f10427f);
        if (g2 == 1) {
            str = a(jVar.f10424c);
        } else if (g2 == 2) {
            str = b(jVar.f10424c);
        }
        return jVar2.a(jVar.f10422a, str, jVar.f10423b, jVar.j, jVar.k, jVar.x, jVar.y);
    }

    private boolean a(c cVar) {
        return cVar instanceof r;
    }

    private boolean k() {
        return this.x != -9223372036854775807L;
    }

    private static String a(String str) {
        return a(str, 1);
    }

    private static String b(String str) {
        return a(str, 2);
    }

    private static String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i2 == com.google.android.exoplayer2.n.h.h(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
