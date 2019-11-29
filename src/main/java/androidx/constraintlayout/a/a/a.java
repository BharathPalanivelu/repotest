package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    public static void a(g gVar) {
        if ((gVar.b() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.ax = true;
        gVar.as = false;
        gVar.at = false;
        gVar.au = false;
        ArrayList<f> arrayList = gVar.az;
        List<h> list = gVar.ar;
        boolean z = gVar.G() == f.a.WRAP_CONTENT;
        boolean z2 = gVar.H() == f.a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (f fVar : arrayList) {
            fVar.r = null;
            fVar.Y = false;
            fVar.c();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.r == null && !a(fVar2, list, z3)) {
                b(gVar);
                gVar.ax = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (h next : list) {
            i = Math.max(i, a(next, 0));
            i2 = Math.max(i2, a(next, 1));
        }
        if (z) {
            gVar.a(f.a.FIXED);
            gVar.j(i);
            gVar.as = true;
            gVar.at = true;
            gVar.av = i;
        }
        if (z2) {
            gVar.b(f.a.FIXED);
            gVar.k(i2);
            gVar.as = true;
            gVar.au = true;
            gVar.aw = i2;
        }
        a(list, 0, gVar.q());
        a(list, 1, gVar.s());
    }

    private static boolean a(f fVar, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(fVar, hVar, list, z);
    }

    private static boolean a(f fVar, h hVar, List<h> list, boolean z) {
        if (fVar == null) {
            return true;
        }
        fVar.X = false;
        g gVar = (g) fVar.l();
        if (fVar.r == null) {
            fVar.W = true;
            hVar.f1394a.add(fVar);
            fVar.r = hVar;
            if (fVar.s.f1379c == null && fVar.u.f1379c == null && fVar.t.f1379c == null && fVar.v.f1379c == null && fVar.w.f1379c == null && fVar.z.f1379c == null) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (!(fVar.t.f1379c == null || fVar.v.f1379c == null)) {
                f.a H = gVar.H();
                f.a aVar = f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.t.f1379c.f1377a == fVar.l() && fVar.v.f1379c.f1377a == fVar.l())) {
                    a(gVar, fVar, hVar);
                }
            }
            if (!(fVar.s.f1379c == null || fVar.u.f1379c == null)) {
                f.a G = gVar.G();
                f.a aVar2 = f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.s.f1379c.f1377a == fVar.l() && fVar.u.f1379c.f1377a == fVar.l())) {
                    a(gVar, fVar, hVar);
                }
            }
            if (((fVar.G() == f.a.MATCH_CONSTRAINT) ^ (fVar.H() == f.a.MATCH_CONSTRAINT)) && fVar.G != BitmapDescriptorFactory.HUE_RED) {
                a(fVar);
            } else if (fVar.G() == f.a.MATCH_CONSTRAINT || fVar.H() == f.a.MATCH_CONSTRAINT) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (((fVar.s.f1379c == null && fVar.u.f1379c == null) || ((fVar.s.f1379c != null && fVar.s.f1379c.f1377a == fVar.D && fVar.u.f1379c == null) || ((fVar.u.f1379c != null && fVar.u.f1379c.f1377a == fVar.D && fVar.s.f1379c == null) || (fVar.s.f1379c != null && fVar.s.f1379c.f1377a == fVar.D && fVar.u.f1379c != null && fVar.u.f1379c.f1377a == fVar.D)))) && fVar.z.f1379c == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f1399f.add(fVar);
            }
            if (((fVar.t.f1379c == null && fVar.v.f1379c == null) || ((fVar.t.f1379c != null && fVar.t.f1379c.f1377a == fVar.D && fVar.v.f1379c == null) || ((fVar.v.f1379c != null && fVar.v.f1379c.f1377a == fVar.D && fVar.t.f1379c == null) || (fVar.t.f1379c != null && fVar.t.f1379c.f1377a == fVar.D && fVar.v.f1379c != null && fVar.v.f1379c.f1377a == fVar.D)))) && fVar.z.f1379c == null && fVar.w.f1379c == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f1400g.add(fVar);
            }
            if (fVar instanceof j) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
                j jVar = (j) fVar;
                for (int i = 0; i < jVar.aj; i++) {
                    if (!a(jVar.ai[i], hVar, list, z)) {
                        return false;
                    }
                }
            }
            for (e eVar : fVar.A) {
                if (!(eVar.f1379c == null || eVar.f1379c.f1377a == fVar.l())) {
                    if (eVar.f1378b == e.c.CENTER) {
                        a(gVar, fVar, hVar);
                        if (z) {
                            return false;
                        }
                    } else {
                        a(eVar);
                    }
                    if (!a(eVar.f1379c.f1377a, hVar, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.r != hVar) {
            hVar.f1394a.addAll(fVar.r.f1394a);
            hVar.f1399f.addAll(fVar.r.f1399f);
            hVar.f1400g.addAll(fVar.r.f1400g);
            if (!fVar.r.f1397d) {
                hVar.f1397d = false;
            }
            list.remove(fVar.r);
            for (f fVar2 : fVar.r.f1394a) {
                fVar2.r = hVar;
            }
        }
        return true;
    }

    private static void a(g gVar, f fVar, h hVar) {
        hVar.f1397d = false;
        gVar.ax = false;
        fVar.W = false;
    }

    private static int a(h hVar, int i) {
        int i2 = i * 2;
        List<f> a2 = hVar.a(i);
        int size = a2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = a2.get(i4);
            int i5 = i2 + 1;
            i3 = Math.max(i3, a(fVar, i, fVar.A[i5].f1379c == null || !(fVar.A[i2].f1379c == null || fVar.A[i5].f1379c == null), 0));
        }
        hVar.f1398e[i] = i3;
        return i3;
    }

    private static int a(f fVar, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int q;
        int i9;
        int i10;
        int i11;
        f fVar2 = fVar;
        int i12 = i;
        boolean z2 = z;
        int i13 = 0;
        if (!fVar2.W) {
            return 0;
        }
        boolean z3 = fVar2.w.f1379c != null && i12 == 1;
        if (z2) {
            i6 = fVar.B();
            i5 = fVar.s() - fVar.B();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = fVar.s() - fVar.B();
            i5 = fVar.B();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        if (fVar2.A[i3].f1379c == null || fVar2.A[i4].f1379c != null) {
            i7 = i3;
            i3 = i4;
            i8 = 1;
        } else {
            i7 = i4;
            i8 = -1;
        }
        int i14 = z3 ? i2 - i6 : i2;
        int e2 = (fVar2.A[i3].e() * i8) + a(fVar, i);
        int i15 = i14 + e2;
        int q2 = (i12 == 0 ? fVar.q() : fVar.s()) * i8;
        Iterator it = fVar2.A[i3].a().h.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, a(((m) ((o) it.next())).f1403a.f1377a, i12, z2, i15));
        }
        int i16 = 0;
        for (Iterator it2 = fVar2.A[i7].a().h.iterator(); it2.hasNext(); it2 = it2) {
            i16 = Math.max(i16, a(((m) ((o) it2.next())).f1403a.f1377a, i12, z2, q2 + i15));
        }
        if (z3) {
            i13 -= i6;
            q = i16 + i5;
        } else {
            q = i16 + ((i12 == 0 ? fVar.q() : fVar.s()) * i8);
        }
        int i17 = 1;
        if (i12 == 1) {
            Iterator it3 = fVar2.w.a().h.iterator();
            int i18 = 0;
            while (it3.hasNext()) {
                Iterator it4 = it3;
                m mVar = (m) ((o) it3.next());
                if (i8 == i17) {
                    i18 = Math.max(i18, a(mVar.f1403a.f1377a, i12, z2, i6 + i15));
                    i11 = i7;
                } else {
                    i11 = i7;
                    i18 = Math.max(i18, a(mVar.f1403a.f1377a, i12, z2, (i5 * i8) + i15));
                }
                it3 = it4;
                i7 = i11;
                i17 = 1;
            }
            i9 = i7;
            int i19 = i18;
            i10 = (fVar2.w.a().h.size() <= 0 || z3) ? i19 : i8 == 1 ? i19 + i6 : i19 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = e2 + Math.max(i13, Math.max(q, i10));
        int i20 = i15 + q2;
        if (i8 == -1) {
            int i21 = i15;
            i15 = i20;
            i20 = i21;
        }
        if (z2) {
            k.a(fVar2, i12, i15);
            fVar2.a(i15, i20, i12);
        } else {
            fVar2.r.a(fVar2, i12);
            fVar2.e(i15, i12);
        }
        if (fVar.t(i) == f.a.MATCH_CONSTRAINT && fVar2.G != BitmapDescriptorFactory.HUE_RED) {
            fVar2.r.a(fVar2, i12);
        }
        if (!(fVar2.A[i3].f1379c == null || fVar2.A[i9].f1379c == null)) {
            f l = fVar.l();
            if (fVar2.A[i3].f1379c.f1377a == l && fVar2.A[i9].f1379c.f1377a == l) {
                fVar2.r.a(fVar2, i12);
            }
        }
        return max;
    }

    private static void a(e eVar) {
        m a2 = eVar.a();
        if (eVar.f1379c != null && eVar.f1379c.f1379c != eVar) {
            eVar.f1379c.a().a(a2);
        }
    }

    private static void b(g gVar) {
        gVar.ar.clear();
        gVar.ar.add(0, new h(gVar.az));
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (f next : list.get(i3).b(i)) {
                if (next.W) {
                    a(next, i, i2);
                }
            }
        }
    }

    private static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        e eVar = fVar.A[i3];
        e eVar2 = fVar.A[i3 + 1];
        if ((eVar.f1379c == null || eVar2.f1379c == null) ? false : true) {
            k.a(fVar, i, a(fVar, i) + eVar.e());
        } else if (fVar.G == BitmapDescriptorFactory.HUE_RED || fVar.t(i) != f.a.MATCH_CONSTRAINT) {
            int p = i2 - fVar.p(i);
            int f2 = p - fVar.f(i);
            fVar.a(f2, p, i);
            k.a(fVar, i, f2);
        } else {
            int a2 = a(fVar);
            int i4 = (int) fVar.A[i3].a().f1408f;
            eVar2.a().f1407e = eVar.a();
            eVar2.a().f1408f = (float) a2;
            eVar2.a().i = 1;
            fVar.a(i4, i4 + a2, i);
        }
    }

    private static int a(f fVar, int i) {
        int i2 = i * 2;
        e eVar = fVar.A[i2];
        e eVar2 = fVar.A[i2 + 1];
        if (eVar.f1379c == null || eVar.f1379c.f1377a != fVar.D || eVar2.f1379c == null || eVar2.f1379c.f1377a != fVar.D) {
            return 0;
        }
        return (int) (((float) (((fVar.D.f(i) - eVar.e()) - eVar2.e()) - fVar.f(i))) * (i == 0 ? fVar.S : fVar.T));
    }

    private static int a(f fVar) {
        float f2;
        float f3;
        if (fVar.G() == f.a.MATCH_CONSTRAINT) {
            if (fVar.H == 0) {
                f3 = ((float) fVar.s()) * fVar.G;
            } else {
                f3 = ((float) fVar.s()) / fVar.G;
            }
            int i = (int) f3;
            fVar.j(i);
            return i;
        } else if (fVar.H() != f.a.MATCH_CONSTRAINT) {
            return -1;
        } else {
            if (fVar.H == 1) {
                f2 = ((float) fVar.q()) * fVar.G;
            } else {
                f2 = ((float) fVar.q()) / fVar.G;
            }
            int i2 = (int) f2;
            fVar.k(i2);
            return i2;
        }
    }
}
