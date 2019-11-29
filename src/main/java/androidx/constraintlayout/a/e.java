package androidx.constraintlayout.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.h;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.HashMap;

public class e {

    /* renamed from: g  reason: collision with root package name */
    public static f f1429g = null;
    private static int h = 1000;

    /* renamed from: a  reason: collision with root package name */
    int f1430a = 0;

    /* renamed from: b  reason: collision with root package name */
    b[] f1431b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1432c;

    /* renamed from: d  reason: collision with root package name */
    int f1433d;

    /* renamed from: e  reason: collision with root package name */
    int f1434e;

    /* renamed from: f  reason: collision with root package name */
    final c f1435f;
    private HashMap<String, h> i = null;
    private a j;
    private int k = 32;
    private int l;
    private boolean[] m;
    private int n;
    private h[] o;
    private int p;
    private b[] q;
    private final a r;

    interface a {
        h a(e eVar, boolean[] zArr);

        void a(a aVar);

        void d(h hVar);

        void f();

        h g();
    }

    public e() {
        int i2 = this.k;
        this.l = i2;
        this.f1431b = null;
        this.f1432c = false;
        this.m = new boolean[i2];
        this.f1433d = 1;
        this.f1434e = 0;
        this.n = i2;
        this.o = new h[h];
        this.p = 0;
        this.q = new b[i2];
        this.f1431b = new b[i2];
        i();
        this.f1435f = new c();
        this.j = new d(this.f1435f);
        this.r = new b(this.f1435f);
    }

    public static f a() {
        return f1429g;
    }

    private void h() {
        this.k *= 2;
        this.f1431b = (b[]) Arrays.copyOf(this.f1431b, this.k);
        c cVar = this.f1435f;
        cVar.f1428c = (h[]) Arrays.copyOf(cVar.f1428c, this.k);
        int i2 = this.k;
        this.m = new boolean[i2];
        this.l = i2;
        this.n = i2;
        f fVar = f1429g;
        if (fVar != null) {
            fVar.f1439d++;
            f fVar2 = f1429g;
            fVar2.p = Math.max(fVar2.p, (long) this.k);
            f fVar3 = f1429g;
            fVar3.D = fVar3.p;
        }
    }

    private void i() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.f1431b;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.f1435f.f1426a.a(bVar);
                }
                this.f1431b[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    public void b() {
        for (h hVar : this.f1435f.f1428c) {
            if (hVar != null) {
                hVar.b();
            }
        }
        this.f1435f.f1427b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f1435f.f1428c, (Object) null);
        HashMap<String, h> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1430a = 0;
        this.j.f();
        this.f1433d = 1;
        for (int i2 = 0; i2 < this.f1434e; i2++) {
            this.f1431b[i2].f1423c = false;
        }
        i();
        this.f1434e = 0;
    }

    public h a(Object obj) {
        h hVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f1433d + 1 >= this.l) {
            h();
        }
        if (obj instanceof androidx.constraintlayout.a.a.e) {
            androidx.constraintlayout.a.a.e eVar = (androidx.constraintlayout.a.a.e) obj;
            hVar = eVar.b();
            if (hVar == null) {
                eVar.a(this.f1435f);
                hVar = eVar.b();
            }
            if (hVar.f1445a == -1 || hVar.f1445a > this.f1430a || this.f1435f.f1428c[hVar.f1445a] == null) {
                if (hVar.f1445a != -1) {
                    hVar.b();
                }
                this.f1430a++;
                this.f1433d++;
                hVar.f1445a = this.f1430a;
                hVar.f1450f = h.a.UNRESTRICTED;
                this.f1435f.f1428c[this.f1430a] = hVar;
            }
        }
        return hVar;
    }

    public b c() {
        b a2 = this.f1435f.f1426a.a();
        if (a2 == null) {
            a2 = new b(this.f1435f);
        } else {
            a2.c();
        }
        h.a();
        return a2;
    }

    public h d() {
        f fVar = f1429g;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.f1433d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.SLACK, (String) null);
        this.f1430a++;
        this.f1433d++;
        a2.f1445a = this.f1430a;
        this.f1435f.f1428c[this.f1430a] = a2;
        return a2;
    }

    public h e() {
        f fVar = f1429g;
        if (fVar != null) {
            fVar.o++;
        }
        if (this.f1433d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.SLACK, (String) null);
        this.f1430a++;
        this.f1433d++;
        a2.f1445a = this.f1430a;
        this.f1435f.f1428c[this.f1430a] = a2;
        return a2;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i2, int i3) {
        bVar.c(a(i3, (String) null), i2);
    }

    public h a(int i2, String str) {
        f fVar = f1429g;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.f1433d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.ERROR, str);
        this.f1430a++;
        this.f1433d++;
        a2.f1445a = this.f1430a;
        a2.f1447c = i2;
        this.f1435f.f1428c[this.f1430a] = a2;
        this.j.d(a2);
        return a2;
    }

    private h a(h.a aVar, String str) {
        h a2 = this.f1435f.f1427b.a();
        if (a2 == null) {
            a2 = new h(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.b();
            a2.a(aVar, str);
        }
        int i2 = this.p;
        int i3 = h;
        if (i2 >= i3) {
            h = i3 * 2;
            this.o = (h[]) Arrays.copyOf(this.o, h);
        }
        h[] hVarArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        hVarArr[i4] = a2;
        return a2;
    }

    public int b(Object obj) {
        h b2 = ((androidx.constraintlayout.a.a.e) obj).b();
        if (b2 != null) {
            return (int) (b2.f1448d + 0.5f);
        }
        return 0;
    }

    public void f() throws Exception {
        f fVar = f1429g;
        if (fVar != null) {
            fVar.f1440e++;
        }
        if (this.f1432c) {
            f fVar2 = f1429g;
            if (fVar2 != null) {
                fVar2.r++;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f1434e) {
                    z = true;
                    break;
                } else if (!this.f1431b[i2].f1425e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                a(this.j);
                return;
            }
            f fVar3 = f1429g;
            if (fVar3 != null) {
                fVar3.q++;
            }
            j();
            return;
        }
        a(this.j);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) throws Exception {
        f fVar = f1429g;
        if (fVar != null) {
            fVar.t++;
            f fVar2 = f1429g;
            fVar2.u = Math.max(fVar2.u, (long) this.f1433d);
            f fVar3 = f1429g;
            fVar3.v = Math.max(fVar3.v, (long) this.f1434e);
        }
        c((b) aVar);
        b(aVar);
        a(aVar, false);
        j();
    }

    private final void c(b bVar) {
        if (this.f1434e > 0) {
            bVar.f1424d.a(bVar, this.f1431b);
            if (bVar.f1424d.f1363a == 0) {
                bVar.f1425e = true;
            }
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            f fVar = f1429g;
            if (fVar != null) {
                fVar.f1441f++;
                if (bVar.f1425e) {
                    f1429g.f1442g++;
                }
            }
            if (this.f1434e + 1 >= this.n || this.f1433d + 1 >= this.l) {
                h();
            }
            boolean z = false;
            if (!bVar.f1425e) {
                c(bVar);
                if (!bVar.e()) {
                    bVar.d();
                    if (bVar.a(this)) {
                        h e2 = e();
                        bVar.f1421a = e2;
                        d(bVar);
                        this.r.a(bVar);
                        a(this.r, true);
                        if (e2.f1446b == -1) {
                            if (bVar.f1421a == e2) {
                                h b2 = bVar.b(e2);
                                if (b2 != null) {
                                    f fVar2 = f1429g;
                                    if (fVar2 != null) {
                                        fVar2.j++;
                                    }
                                    bVar.c(b2);
                                }
                            }
                            if (!bVar.f1425e) {
                                bVar.f1421a.c(bVar);
                            }
                            this.f1434e--;
                        }
                        z = true;
                    }
                    if (!bVar.a()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                d(bVar);
            }
        }
    }

    private final void d(b bVar) {
        if (this.f1431b[this.f1434e] != null) {
            this.f1435f.f1426a.a(this.f1431b[this.f1434e]);
        }
        this.f1431b[this.f1434e] = bVar;
        h hVar = bVar.f1421a;
        int i2 = this.f1434e;
        hVar.f1446b = i2;
        this.f1434e = i2 + 1;
        bVar.f1421a.c(bVar);
    }

    private final int a(a aVar, boolean z) {
        f fVar = f1429g;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i2 = 0; i2 < this.f1433d; i2++) {
            this.m[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar2 = f1429g;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i3++;
            if (i3 >= this.f1433d * 2) {
                return i3;
            }
            if (aVar.g() != null) {
                this.m[aVar.g().f1445a] = true;
            }
            h a2 = aVar.a(this, this.m);
            if (a2 != null) {
                if (this.m[a2.f1445a]) {
                    return i3;
                }
                this.m[a2.f1445a] = true;
            }
            if (a2 != null) {
                int i4 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i5 = 0; i5 < this.f1434e; i5++) {
                    b bVar = this.f1431b[i5];
                    if (bVar.f1421a.f1450f != h.a.UNRESTRICTED && !bVar.f1425e && bVar.a(a2)) {
                        float b2 = bVar.f1424d.b(a2);
                        if (b2 < BitmapDescriptorFactory.HUE_RED) {
                            float f3 = (-bVar.f1422b) / b2;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f1431b[i4];
                    bVar2.f1421a.f1446b = -1;
                    f fVar3 = f1429g;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.c(a2);
                    bVar2.f1421a.f1446b = i4;
                    bVar2.f1421a.c(bVar2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    private int b(a aVar) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            int i3 = this.f1434e;
            f2 = BitmapDescriptorFactory.HUE_RED;
            if (i2 >= i3) {
                z = false;
                break;
            } else if (this.f1431b[i2].f1421a.f1450f != h.a.UNRESTRICTED && this.f1431b[i2].f1422b < BitmapDescriptorFactory.HUE_RED) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i4 = 0;
        while (!z2) {
            f fVar = f1429g;
            if (fVar != null) {
                fVar.k++;
            }
            i4++;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            float f3 = Float.MAX_VALUE;
            int i8 = 0;
            while (i5 < this.f1434e) {
                b bVar = this.f1431b[i5];
                if (bVar.f1421a.f1450f != h.a.UNRESTRICTED && !bVar.f1425e && bVar.f1422b < f2) {
                    int i9 = 1;
                    while (i9 < this.f1433d) {
                        h hVar = this.f1435f.f1428c[i9];
                        float b2 = bVar.f1424d.b(hVar);
                        if (b2 > f2) {
                            int i10 = i8;
                            float f4 = f3;
                            int i11 = i7;
                            int i12 = i6;
                            for (int i13 = 0; i13 < 7; i13++) {
                                float f5 = hVar.f1449e[i13] / b2;
                                if ((f5 < f4 && i13 == i10) || i13 > i10) {
                                    i11 = i9;
                                    i12 = i5;
                                    f4 = f5;
                                    i10 = i13;
                                }
                            }
                            i6 = i12;
                            i7 = i11;
                            f3 = f4;
                            i8 = i10;
                        }
                        i9++;
                        f2 = BitmapDescriptorFactory.HUE_RED;
                    }
                }
                i5++;
                f2 = BitmapDescriptorFactory.HUE_RED;
            }
            if (i6 != -1) {
                b bVar2 = this.f1431b[i6];
                bVar2.f1421a.f1446b = -1;
                f fVar2 = f1429g;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.c(this.f1435f.f1428c[i7]);
                bVar2.f1421a.f1446b = i6;
                bVar2.f1421a.c(bVar2);
            } else {
                z2 = true;
            }
            if (i4 > this.f1433d / 2) {
                z2 = true;
            }
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        return i4;
    }

    private void j() {
        for (int i2 = 0; i2 < this.f1434e; i2++) {
            b bVar = this.f1431b[i2];
            bVar.f1421a.f1448d = bVar.f1422b;
        }
    }

    public c g() {
        return this.f1435f;
    }

    public void a(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        h d2 = d();
        d2.f1447c = 0;
        c2.a(hVar, hVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.f1424d.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, boolean z) {
        b c2 = c();
        h d2 = d();
        d2.f1447c = 0;
        c2.a(hVar, hVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f1424d.b(d2) * -1.0f), 1);
        }
        a(c2);
    }

    public void b(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        h d2 = d();
        d2.f1447c = 0;
        c2.b(hVar, hVar2, d2, i2);
        if (i3 != 6) {
            a(c2, (int) (c2.f1424d.b(d2) * -1.0f), i3);
        }
        a(c2);
    }

    public void b(h hVar, h hVar2, boolean z) {
        b c2 = c();
        h d2 = d();
        d2.f1447c = 0;
        c2.b(hVar, hVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f1424d.b(d2) * -1.0f), 1);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, int i2, float f2, h hVar3, h hVar4, int i3, int i4) {
        int i5 = i4;
        b c2 = c();
        c2.a(hVar, hVar2, i2, f2, hVar3, hVar4, i3);
        if (i5 != 6) {
            c2.a(this, i5);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, h hVar3, h hVar4, float f2, int i2) {
        b c2 = c();
        c2.a(hVar, hVar2, hVar3, hVar4, f2);
        if (i2 != 6) {
            c2.a(this, i2);
        }
        a(c2);
    }

    public b c(h hVar, h hVar2, int i2, int i3) {
        b c2 = c();
        c2.a(hVar, hVar2, i2);
        if (i3 != 6) {
            c2.a(this, i3);
        }
        a(c2);
        return c2;
    }

    public void a(h hVar, int i2) {
        int i3 = hVar.f1446b;
        if (hVar.f1446b != -1) {
            b bVar = this.f1431b[i3];
            if (bVar.f1425e) {
                bVar.f1422b = (float) i2;
            } else if (bVar.f1424d.f1363a == 0) {
                bVar.f1425e = true;
                bVar.f1422b = (float) i2;
            } else {
                b c2 = c();
                c2.b(hVar, i2);
                a(c2);
            }
        } else {
            b c3 = c();
            c3.a(hVar, i2);
            a(c3);
        }
    }

    public static b a(e eVar, h hVar, h hVar2, h hVar3, float f2, boolean z) {
        b c2 = eVar.c();
        if (z) {
            eVar.b(c2);
        }
        return c2.a(hVar, hVar2, hVar3, f2);
    }

    public void a(f fVar, f fVar2, float f2, int i2) {
        f fVar3 = fVar;
        f fVar4 = fVar2;
        h a2 = a((Object) fVar3.a(e.c.LEFT));
        h a3 = a((Object) fVar3.a(e.c.TOP));
        h a4 = a((Object) fVar3.a(e.c.RIGHT));
        h a5 = a((Object) fVar3.a(e.c.BOTTOM));
        h a6 = a((Object) fVar4.a(e.c.LEFT));
        h a7 = a((Object) fVar4.a(e.c.TOP));
        h a8 = a((Object) fVar4.a(e.c.RIGHT));
        h a9 = a((Object) fVar4.a(e.c.BOTTOM));
        b c2 = c();
        double d2 = (double) f2;
        double sin = Math.sin(d2);
        h hVar = a4;
        double d3 = (double) i2;
        Double.isNaN(d3);
        c2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(c2);
        b c3 = c();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        c3.b(a2, hVar, a6, a8, (float) (cos * d3));
        a(c3);
    }
}
