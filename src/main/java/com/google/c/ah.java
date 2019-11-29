package com.google.c;

import com.google.c.ac;
import com.google.c.ad;
import com.google.c.at;
import com.google.c.ay;
import com.google.c.j;
import com.google.c.n;
import com.google.c.q;
import com.google.c.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class ah {

    interface c {

        public enum a {
            MESSAGE,
            EXTENSION_SET
        }

        a a();

        c a(j.f fVar, Object obj);

        n.b a(n nVar, j.a aVar, int i);

        Object a(f fVar, p pVar, j.f fVar2, ac acVar) throws IOException;

        Object a(g gVar, p pVar, j.f fVar, ac acVar) throws IOException;

        c b(j.f fVar, Object obj);

        Object b(g gVar, p pVar, j.f fVar, ac acVar) throws IOException;

        boolean b(j.f fVar);

        ay.c c(j.f fVar);
    }

    static void a(ac acVar, Map<j.f, Object> map, h hVar, boolean z) throws IOException {
        boolean i = acVar.g().e().i();
        if (z) {
            TreeMap treeMap = new TreeMap(map);
            for (j.f next : acVar.g().f()) {
                if (next.n() && !treeMap.containsKey(next)) {
                    treeMap.put(next, acVar.b(next));
                }
            }
            map = treeMap;
        }
        for (Map.Entry next2 : map.entrySet()) {
            j.f fVar = (j.f) next2.getKey();
            Object value = next2.getValue();
            if (!i || !fVar.u() || fVar.i() != j.f.b.MESSAGE || fVar.p()) {
                q.a((q.a<?>) fVar, value, hVar);
            } else {
                hVar.b(fVar.f(), (ad) (ac) value);
            }
        }
        at f2 = acVar.f();
        if (i) {
            f2.b(hVar);
        } else {
            f2.a(hVar);
        }
    }

    static int a(ac acVar, Map<j.f, Object> map) {
        int i;
        int i2;
        boolean i3 = acVar.g().e().i();
        int i4 = 0;
        for (Map.Entry next : map.entrySet()) {
            j.f fVar = (j.f) next.getKey();
            Object value = next.getValue();
            if (!i3 || !fVar.u() || fVar.i() != j.f.b.MESSAGE || fVar.p()) {
                i2 = q.c(fVar, value);
            } else {
                i2 = h.d(fVar.f(), (ad) (ac) value);
            }
            i4 += i2;
        }
        at f2 = acVar.f();
        if (i3) {
            i = f2.i();
        } else {
            i = f2.b();
        }
        return i4 + i;
    }

    static boolean a(ag agVar) {
        for (j.f next : agVar.g().f()) {
            if (next.n() && !agVar.a(next)) {
                return false;
            }
        }
        for (Map.Entry next2 : agVar.o_().entrySet()) {
            j.f fVar = (j.f) next2.getKey();
            if (fVar.g() == j.f.a.MESSAGE) {
                if (fVar.p()) {
                    for (ac a2 : (List) next2.getValue()) {
                        if (!a2.a()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((ac) next2.getValue()).a()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String a(String str, j.f fVar, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (fVar.u()) {
            sb.append('(');
            sb.append(fVar.c());
            sb.append(')');
        } else {
            sb.append(fVar.b());
        }
        if (i != -1) {
            sb.append('[');
            sb.append(i);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    private static void a(ag agVar, String str, List<String> list) {
        for (j.f next : agVar.g().f()) {
            if (next.n() && !agVar.a(next)) {
                list.add(str + next.b());
            }
        }
        for (Map.Entry next2 : agVar.o_().entrySet()) {
            j.f fVar = (j.f) next2.getKey();
            Object value = next2.getValue();
            if (fVar.g() == j.f.a.MESSAGE) {
                if (fVar.p()) {
                    int i = 0;
                    for (ag a2 : (List) value) {
                        a(a2, a(str, fVar, i), list);
                        i++;
                    }
                } else if (agVar.a(fVar)) {
                    a((ag) value, a(str, fVar, -1), list);
                }
            }
        }
    }

    static List<String> b(ag agVar) {
        ArrayList arrayList = new ArrayList();
        a(agVar, "", (List<String>) arrayList);
        return arrayList;
    }

    static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ac.a f13618a;

        public a(ac.a aVar) {
            this.f13618a = aVar;
        }

        public Object a(j.f fVar) {
            return this.f13618a.b(fVar);
        }

        public boolean b(j.f fVar) {
            return this.f13618a.a(fVar);
        }

        public c a(j.f fVar, Object obj) {
            this.f13618a.f(fVar, obj);
            return this;
        }

        public c b(j.f fVar, Object obj) {
            this.f13618a.e(fVar, obj);
            return this;
        }

        public c.a a() {
            return c.a.MESSAGE;
        }

        public n.b a(n nVar, j.a aVar, int i) {
            return nVar.a(aVar, i);
        }

        public Object a(g gVar, p pVar, j.f fVar, ac acVar) throws IOException {
            ac.a aVar;
            if (acVar != null) {
                aVar = acVar.H();
            } else {
                aVar = this.f13618a.d(fVar);
            }
            if (!fVar.p()) {
                ac acVar2 = (ac) a(fVar);
                if (acVar2 != null) {
                    aVar.c(acVar2);
                }
            }
            gVar.a(fVar.f(), (ad.a) aVar, pVar);
            return aVar.t();
        }

        public Object b(g gVar, p pVar, j.f fVar, ac acVar) throws IOException {
            ac.a aVar;
            if (acVar != null) {
                aVar = acVar.H();
            } else {
                aVar = this.f13618a.d(fVar);
            }
            if (!fVar.p()) {
                ac acVar2 = (ac) a(fVar);
                if (acVar2 != null) {
                    aVar.c(acVar2);
                }
            }
            gVar.a((ad.a) aVar, pVar);
            return aVar.t();
        }

        public Object a(f fVar, p pVar, j.f fVar2, ac acVar) throws IOException {
            ac.a aVar;
            if (acVar != null) {
                aVar = acVar.H();
            } else {
                aVar = this.f13618a.d(fVar2);
            }
            if (!fVar2.p()) {
                ac acVar2 = (ac) a(fVar2);
                if (acVar2 != null) {
                    aVar.c(acVar2);
                }
            }
            aVar.c(fVar, pVar);
            return aVar.t();
        }

        public ay.c c(j.f fVar) {
            if (fVar.l()) {
                return ay.c.STRICT;
            }
            if (fVar.p() || !(this.f13618a instanceof r.a)) {
                return ay.c.LOOSE;
            }
            return ay.c.LAZY;
        }
    }

    static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final q<j.f> f13619a;

        b(q<j.f> qVar) {
            this.f13619a = qVar;
        }

        public Object a(j.f fVar) {
            return this.f13619a.b(fVar);
        }

        public boolean b(j.f fVar) {
            return this.f13619a.a(fVar);
        }

        public c a(j.f fVar, Object obj) {
            this.f13619a.a(fVar, obj);
            return this;
        }

        public c b(j.f fVar, Object obj) {
            this.f13619a.b(fVar, obj);
            return this;
        }

        public c.a a() {
            return c.a.EXTENSION_SET;
        }

        public n.b a(n nVar, j.a aVar, int i) {
            return nVar.a(aVar, i);
        }

        public Object a(g gVar, p pVar, j.f fVar, ac acVar) throws IOException {
            ac.a H = acVar.H();
            if (!fVar.p()) {
                ac acVar2 = (ac) a(fVar);
                if (acVar2 != null) {
                    H.c(acVar2);
                }
            }
            gVar.a(fVar.f(), (ad.a) H, pVar);
            return H.t();
        }

        public Object b(g gVar, p pVar, j.f fVar, ac acVar) throws IOException {
            ac.a H = acVar.H();
            if (!fVar.p()) {
                ac acVar2 = (ac) a(fVar);
                if (acVar2 != null) {
                    H.c(acVar2);
                }
            }
            gVar.a((ad.a) H, pVar);
            return H.t();
        }

        public Object a(f fVar, p pVar, j.f fVar2, ac acVar) throws IOException {
            ac.a H = acVar.H();
            if (!fVar2.p()) {
                ac acVar2 = (ac) a(fVar2);
                if (acVar2 != null) {
                    H.c(acVar2);
                }
            }
            H.c(fVar, pVar);
            return H.t();
        }

        public ay.c c(j.f fVar) {
            if (fVar.l()) {
                return ay.c.STRICT;
            }
            return ay.c.LOOSE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(com.google.c.g r7, com.google.c.at.a r8, com.google.c.p r9, com.google.c.j.a r10, com.google.c.ah.c r11, int r12) throws java.io.IOException {
        /*
            com.google.c.i$s r0 = r10.e()
            boolean r0 = r0.i()
            r1 = 1
            if (r0 == 0) goto L_0x0013
            int r0 = com.google.c.ay.f13700a
            if (r12 != r0) goto L_0x0013
            a(r7, r8, r9, r10, r11)
            return r1
        L_0x0013:
            int r0 = com.google.c.ay.a(r12)
            int r2 = com.google.c.ay.b(r12)
            boolean r3 = r10.a((int) r2)
            r4 = 0
            if (r3 == 0) goto L_0x005d
            boolean r3 = r9 instanceof com.google.c.n
            if (r3 == 0) goto L_0x006d
            r3 = r9
            com.google.c.n r3 = (com.google.c.n) r3
            com.google.c.n$b r10 = r11.a(r3, r10, r2)
            if (r10 != 0) goto L_0x0030
            goto L_0x006d
        L_0x0030:
            com.google.c.j$f r3 = r10.f13989a
            com.google.c.ac r4 = r10.f13990b
            if (r4 != 0) goto L_0x005a
            com.google.c.j$f$a r10 = r3.g()
            com.google.c.j$f$a r5 = com.google.c.j.f.a.MESSAGE
            if (r10 == r5) goto L_0x003f
            goto L_0x005a
        L_0x003f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Message-typed extension lacked default instance: "
            r8.append(r9)
            java.lang.String r9 = r3.c()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x005a:
            r10 = r4
            r4 = r3
            goto L_0x006e
        L_0x005d:
            com.google.c.ah$c$a r3 = r11.a()
            com.google.c.ah$c$a r5 = com.google.c.ah.c.a.MESSAGE
            if (r3 != r5) goto L_0x006d
            com.google.c.j$f r10 = r10.b(r2)
            r6 = r4
            r4 = r10
            r10 = r6
            goto L_0x006e
        L_0x006d:
            r10 = r4
        L_0x006e:
            r3 = 0
            if (r4 != 0) goto L_0x0074
        L_0x0071:
            r0 = 0
            r3 = 1
            goto L_0x0091
        L_0x0074:
            com.google.c.ay$a r5 = r4.k()
            int r5 = com.google.c.q.a((com.google.c.ay.a) r5, (boolean) r3)
            if (r0 != r5) goto L_0x0080
            r0 = 0
            goto L_0x0091
        L_0x0080:
            boolean r5 = r4.r()
            if (r5 == 0) goto L_0x0071
            com.google.c.ay$a r5 = r4.k()
            int r5 = com.google.c.q.a((com.google.c.ay.a) r5, (boolean) r1)
            if (r0 != r5) goto L_0x0071
            r0 = 1
        L_0x0091:
            if (r3 == 0) goto L_0x0098
            boolean r7 = r8.a((int) r12, (com.google.c.g) r7)
            return r7
        L_0x0098:
            if (r0 == 0) goto L_0x00f3
            int r8 = r7.t()
            int r8 = r7.d(r8)
            com.google.c.ay$a r9 = r4.k()
            com.google.c.ay$a r10 = com.google.c.ay.a.ENUM
            if (r9 != r10) goto L_0x00d9
        L_0x00aa:
            int r9 = r7.y()
            if (r9 <= 0) goto L_0x00ef
            int r9 = r7.o()
            com.google.c.j$g r10 = r4.d()
            boolean r10 = r10.k()
            if (r10 == 0) goto L_0x00ca
            com.google.c.j$d r10 = r4.z()
            com.google.c.j$e r9 = r10.b(r9)
            r11.b(r4, r9)
            goto L_0x00aa
        L_0x00ca:
            com.google.c.j$d r10 = r4.z()
            com.google.c.j$e r9 = r10.a((int) r9)
            if (r9 != 0) goto L_0x00d5
            return r1
        L_0x00d5:
            r11.b(r4, r9)
            goto L_0x00aa
        L_0x00d9:
            int r9 = r7.y()
            if (r9 <= 0) goto L_0x00ef
            com.google.c.ay$a r9 = r4.k()
            com.google.c.ay$c r10 = r11.c(r4)
            java.lang.Object r9 = com.google.c.ay.a(r7, r9, r10)
            r11.b(r4, r9)
            goto L_0x00d9
        L_0x00ef:
            r7.e(r8)
            goto L_0x0151
        L_0x00f3:
            int[] r12 = com.google.c.ah.AnonymousClass1.f13617a
            com.google.c.j$f$b r0 = r4.i()
            int r0 = r0.ordinal()
            r12 = r12[r0]
            if (r12 == r1) goto L_0x0140
            r0 = 2
            if (r12 == r0) goto L_0x013b
            r9 = 3
            if (r12 == r9) goto L_0x0114
            com.google.c.ay$a r8 = r4.k()
            com.google.c.ay$c r9 = r11.c(r4)
            java.lang.Object r7 = com.google.c.ay.a(r7, r8, r9)
            goto L_0x0144
        L_0x0114:
            int r7 = r7.o()
            com.google.c.j$g r9 = r4.d()
            boolean r9 = r9.k()
            if (r9 == 0) goto L_0x012b
            com.google.c.j$d r8 = r4.z()
            com.google.c.j$e r7 = r8.b(r7)
            goto L_0x0144
        L_0x012b:
            com.google.c.j$d r9 = r4.z()
            com.google.c.j$e r9 = r9.a((int) r7)
            if (r9 != 0) goto L_0x0139
            r8.a((int) r2, (int) r7)
            return r1
        L_0x0139:
            r7 = r9
            goto L_0x0144
        L_0x013b:
            java.lang.Object r7 = r11.b(r7, r9, r4, r10)
            goto L_0x0144
        L_0x0140:
            java.lang.Object r7 = r11.a((com.google.c.g) r7, (com.google.c.p) r9, (com.google.c.j.f) r4, (com.google.c.ac) r10)
        L_0x0144:
            boolean r8 = r4.p()
            if (r8 == 0) goto L_0x014e
            r11.b(r4, r7)
            goto L_0x0151
        L_0x014e:
            r11.a(r4, r7)
        L_0x0151:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.ah.a(com.google.c.g, com.google.c.at$a, com.google.c.p, com.google.c.j$a, com.google.c.ah$c, int):boolean");
    }

    /* renamed from: com.google.c.ah$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13617a = new int[j.f.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.google.c.j$f$b[] r0 = com.google.c.j.f.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13617a = r0
                int[] r0 = f13617a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.GROUP     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f13617a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f13617a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.c.j$f$b r1 = com.google.c.j.f.b.ENUM     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.ah.AnonymousClass1.<clinit>():void");
        }
    }

    private static void a(g gVar, at.a aVar, p pVar, j.a aVar2, c cVar) throws IOException {
        int i = 0;
        f fVar = null;
        n.b bVar = null;
        while (true) {
            int a2 = gVar.a();
            if (a2 == 0) {
                break;
            } else if (a2 == ay.f13702c) {
                i = gVar.n();
                if (i != 0 && (pVar instanceof n)) {
                    bVar = cVar.a((n) pVar, aVar2, i);
                }
            } else if (a2 == ay.f13703d) {
                if (i == 0 || bVar == null || !p.c()) {
                    fVar = gVar.m();
                } else {
                    a(gVar, bVar, pVar, cVar);
                    fVar = null;
                }
            } else if (!gVar.b(a2)) {
                break;
            }
        }
        gVar.a(ay.f13701b);
        if (fVar != null && i != 0) {
            if (bVar != null) {
                a(fVar, bVar, pVar, cVar);
            } else if (fVar != null) {
                aVar.a(i, at.b.a().a(fVar).a());
            }
        }
    }

    private static void a(f fVar, n.b bVar, p pVar, c cVar) throws IOException {
        j.f fVar2 = bVar.f13989a;
        if (cVar.b(fVar2) || p.c()) {
            cVar.a(fVar2, cVar.a(fVar, pVar, fVar2, bVar.f13990b));
        } else {
            cVar.a(fVar2, new w(bVar.f13990b, pVar, fVar));
        }
    }

    private static void a(g gVar, n.b bVar, p pVar, c cVar) throws IOException {
        j.f fVar = bVar.f13989a;
        cVar.a(fVar, cVar.b(gVar, pVar, fVar, bVar.f13990b));
    }
}
