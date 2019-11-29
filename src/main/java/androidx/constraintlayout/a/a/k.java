package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class k {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f1402a = new boolean[3];

    static void a(g gVar, e eVar, f fVar) {
        if (gVar.C[0] != f.a.WRAP_CONTENT && fVar.C[0] == f.a.MATCH_PARENT) {
            int i = fVar.s.f1380d;
            int q = gVar.q() - fVar.u.f1380d;
            fVar.s.f1382f = eVar.a((Object) fVar.s);
            fVar.u.f1382f = eVar.a((Object) fVar.u);
            eVar.a(fVar.s.f1382f, i);
            eVar.a(fVar.u.f1382f, q);
            fVar.f1385a = 2;
            fVar.c(i, q);
        }
        if (gVar.C[1] != f.a.WRAP_CONTENT && fVar.C[1] == f.a.MATCH_PARENT) {
            int i2 = fVar.t.f1380d;
            int s = gVar.s() - fVar.v.f1380d;
            fVar.t.f1382f = eVar.a((Object) fVar.t);
            fVar.v.f1382f = eVar.a((Object) fVar.v);
            eVar.a(fVar.t.f1382f, i2);
            eVar.a(fVar.v.f1382f, s);
            if (fVar.O > 0 || fVar.m() == 8) {
                fVar.w.f1382f = eVar.a((Object) fVar.w);
                eVar.a(fVar.w.f1382f, fVar.O + i2);
            }
            fVar.f1386b = 2;
            fVar.d(i2, s);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(androidx.constraintlayout.a.a.f r4, int r5) {
        /*
            androidx.constraintlayout.a.a.f$a[] r0 = r4.C
            r0 = r0[r5]
            androidx.constraintlayout.a.a.f$a r1 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r4.G
            r1 = 0
            r3 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.a.a.f$a[] r4 = r4.C
            if (r5 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r4 = r4[r3]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x001e
        L_0x001e:
            return r2
        L_0x001f:
            if (r5 != 0) goto L_0x002f
            int r5 = r4.f1389e
            if (r5 == 0) goto L_0x0026
            return r2
        L_0x0026:
            int r5 = r4.h
            if (r5 != 0) goto L_0x002e
            int r4 = r4.i
            if (r4 == 0) goto L_0x003d
        L_0x002e:
            return r2
        L_0x002f:
            int r5 = r4.f1390f
            if (r5 == 0) goto L_0x0034
            return r2
        L_0x0034:
            int r5 = r4.k
            if (r5 != 0) goto L_0x003e
            int r4 = r4.l
            if (r4 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            return r3
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.k.a(androidx.constraintlayout.a.a.f, int):boolean");
    }

    static void a(int i, f fVar) {
        f fVar2 = fVar;
        fVar.h();
        m a2 = fVar2.s.a();
        m a3 = fVar2.t.a();
        m a4 = fVar2.u.a();
        m a5 = fVar2.v.a();
        boolean z = (i & 8) == 8;
        boolean z2 = fVar2.C[0] == f.a.MATCH_CONSTRAINT && a(fVar2, 0);
        if (!(a2.f1409g == 4 || a4.f1409g == 4)) {
            if (fVar2.C[0] == f.a.FIXED || (z2 && fVar.m() == 8)) {
                if (fVar2.s.f1379c == null && fVar2.u.f1379c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, fVar.j());
                    } else {
                        a4.a(a2, fVar.q());
                    }
                } else if (fVar2.s.f1379c != null && fVar2.u.f1379c == null) {
                    a2.b(1);
                    a4.b(1);
                    if (z) {
                        a4.a(a2, 1, fVar.j());
                    } else {
                        a4.a(a2, fVar.q());
                    }
                } else if (fVar2.s.f1379c == null && fVar2.u.f1379c != null) {
                    a2.b(1);
                    a4.b(1);
                    a2.a(a4, -fVar.q());
                    if (z) {
                        a2.a(a4, -1, fVar.j());
                    } else {
                        a2.a(a4, -fVar.q());
                    }
                } else if (!(fVar2.s.f1379c == null || fVar2.u.f1379c == null)) {
                    a2.b(2);
                    a4.b(2);
                    if (z) {
                        fVar.j().a(a2);
                        fVar.j().a(a4);
                        a2.b(a4, -1, fVar.j());
                        a4.b(a2, 1, fVar.j());
                    } else {
                        a2.b(a4, (float) (-fVar.q()));
                        a4.b(a2, (float) fVar.q());
                    }
                }
            } else if (z2) {
                int q = fVar.q();
                a2.b(1);
                a4.b(1);
                if (fVar2.s.f1379c == null && fVar2.u.f1379c == null) {
                    if (z) {
                        a4.a(a2, 1, fVar.j());
                    } else {
                        a4.a(a2, q);
                    }
                } else if (fVar2.s.f1379c == null || fVar2.u.f1379c != null) {
                    if (fVar2.s.f1379c != null || fVar2.u.f1379c == null) {
                        if (!(fVar2.s.f1379c == null || fVar2.u.f1379c == null)) {
                            if (z) {
                                fVar.j().a(a2);
                                fVar.j().a(a4);
                            }
                            if (fVar2.G == BitmapDescriptorFactory.HUE_RED) {
                                a2.b(3);
                                a4.b(3);
                                a2.b(a4, BitmapDescriptorFactory.HUE_RED);
                                a4.b(a2, BitmapDescriptorFactory.HUE_RED);
                            } else {
                                a2.b(2);
                                a4.b(2);
                                a2.b(a4, (float) (-q));
                                a4.b(a2, (float) q);
                                fVar2.j(q);
                            }
                        }
                    } else if (z) {
                        a2.a(a4, -1, fVar.j());
                    } else {
                        a2.a(a4, -q);
                    }
                } else if (z) {
                    a4.a(a2, 1, fVar.j());
                } else {
                    a4.a(a2, q);
                }
            }
        }
        boolean z3 = fVar2.C[1] == f.a.MATCH_CONSTRAINT && a(fVar2, 1);
        if (a3.f1409g != 4 && a5.f1409g != 4) {
            if (fVar2.C[1] == f.a.FIXED || (z3 && fVar.m() == 8)) {
                if (fVar2.t.f1379c == null && fVar2.v.f1379c == null) {
                    a3.b(1);
                    a5.b(1);
                    if (z) {
                        a5.a(a3, 1, fVar.k());
                    } else {
                        a5.a(a3, fVar.s());
                    }
                    if (fVar2.w.f1379c != null) {
                        fVar2.w.a().b(1);
                        a3.a(1, fVar2.w.a(), -fVar2.O);
                    }
                } else if (fVar2.t.f1379c != null && fVar2.v.f1379c == null) {
                    a3.b(1);
                    a5.b(1);
                    if (z) {
                        a5.a(a3, 1, fVar.k());
                    } else {
                        a5.a(a3, fVar.s());
                    }
                    if (fVar2.O > 0) {
                        fVar2.w.a().a(1, a3, fVar2.O);
                    }
                } else if (fVar2.t.f1379c == null && fVar2.v.f1379c != null) {
                    a3.b(1);
                    a5.b(1);
                    if (z) {
                        a3.a(a5, -1, fVar.k());
                    } else {
                        a3.a(a5, -fVar.s());
                    }
                    if (fVar2.O > 0) {
                        fVar2.w.a().a(1, a3, fVar2.O);
                    }
                } else if (fVar2.t.f1379c != null && fVar2.v.f1379c != null) {
                    a3.b(2);
                    a5.b(2);
                    if (z) {
                        a3.b(a5, -1, fVar.k());
                        a5.b(a3, 1, fVar.k());
                        fVar.k().a(a3);
                        fVar.j().a(a5);
                    } else {
                        a3.b(a5, (float) (-fVar.s()));
                        a5.b(a3, (float) fVar.s());
                    }
                    if (fVar2.O > 0) {
                        fVar2.w.a().a(1, a3, fVar2.O);
                    }
                }
            } else if (z3) {
                int s = fVar.s();
                a3.b(1);
                a5.b(1);
                if (fVar2.t.f1379c == null && fVar2.v.f1379c == null) {
                    if (z) {
                        a5.a(a3, 1, fVar.k());
                    } else {
                        a5.a(a3, s);
                    }
                } else if (fVar2.t.f1379c == null || fVar2.v.f1379c != null) {
                    if (fVar2.t.f1379c != null || fVar2.v.f1379c == null) {
                        if (fVar2.t.f1379c != null && fVar2.v.f1379c != null) {
                            if (z) {
                                fVar.k().a(a3);
                                fVar.j().a(a5);
                            }
                            if (fVar2.G == BitmapDescriptorFactory.HUE_RED) {
                                a3.b(3);
                                a5.b(3);
                                a3.b(a5, BitmapDescriptorFactory.HUE_RED);
                                a5.b(a3, BitmapDescriptorFactory.HUE_RED);
                                return;
                            }
                            a3.b(2);
                            a5.b(2);
                            a3.b(a5, (float) (-s));
                            a5.b(a3, (float) s);
                            fVar2.k(s);
                            if (fVar2.O > 0) {
                                fVar2.w.a().a(1, a3, fVar2.O);
                            }
                        }
                    } else if (z) {
                        a3.a(a5, -1, fVar.k());
                    } else {
                        a3.a(a5, -s);
                    }
                } else if (z) {
                    a5.a(a3, 1, fVar.k());
                } else {
                    a5.a(a3, s);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.Z == 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r7.aa == 2) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(androidx.constraintlayout.a.a.g r23, androidx.constraintlayout.a.e r24, int r25, int r26, androidx.constraintlayout.a.a.d r27) {
        /*
            r0 = r24
            r1 = r25
            r2 = r27
            androidx.constraintlayout.a.a.f r3 = r2.f1370a
            androidx.constraintlayout.a.a.f r4 = r2.f1372c
            androidx.constraintlayout.a.a.f r5 = r2.f1371b
            androidx.constraintlayout.a.a.f r6 = r2.f1373d
            androidx.constraintlayout.a.a.f r7 = r2.f1374e
            float r8 = r2.k
            androidx.constraintlayout.a.a.f r9 = r2.f1375f
            androidx.constraintlayout.a.a.f r2 = r2.f1376g
            r9 = r23
            androidx.constraintlayout.a.a.f$a[] r2 = r9.C
            r2 = r2[r1]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            r2 = 2
            r10 = 1
            if (r1 != 0) goto L_0x0038
            int r11 = r7.Z
            if (r11 != 0) goto L_0x0028
            r11 = 1
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            int r12 = r7.Z
            if (r12 != r10) goto L_0x002f
            r12 = 1
            goto L_0x0030
        L_0x002f:
            r12 = 0
        L_0x0030:
            int r7 = r7.Z
            if (r7 != r2) goto L_0x0036
        L_0x0034:
            r2 = 1
            goto L_0x004b
        L_0x0036:
            r2 = 0
            goto L_0x004b
        L_0x0038:
            int r11 = r7.aa
            if (r11 != 0) goto L_0x003e
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            int r12 = r7.aa
            if (r12 != r10) goto L_0x0045
            r12 = 1
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            int r7 = r7.aa
            if (r7 != r2) goto L_0x0036
            goto L_0x0034
        L_0x004b:
            r14 = r3
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0053:
            r7 = 8
            if (r13 != 0) goto L_0x010c
            int r9 = r14.m()
            if (r9 == r7) goto L_0x00a1
            int r15 = r15 + 1
            if (r1 != 0) goto L_0x0066
            int r9 = r14.q()
            goto L_0x006a
        L_0x0066:
            int r9 = r14.s()
        L_0x006a:
            float r9 = (float) r9
            float r16 = r16 + r9
            if (r14 == r5) goto L_0x007a
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            r9 = r9[r26]
            int r9 = r9.e()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x007a:
            if (r14 == r6) goto L_0x0089
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            int r19 = r26 + 1
            r9 = r9[r19]
            int r9 = r9.e()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x0089:
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            r9 = r9[r26]
            int r9 = r9.e()
            float r9 = (float) r9
            float r17 = r17 + r9
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            int r19 = r26 + 1
            r9 = r9[r19]
            int r9 = r9.e()
            float r9 = (float) r9
            float r17 = r17 + r9
        L_0x00a1:
            androidx.constraintlayout.a.a.e[] r9 = r14.A
            r9 = r9[r26]
            int r9 = r14.m()
            if (r9 == r7) goto L_0x00df
            androidx.constraintlayout.a.a.f$a[] r7 = r14.C
            r7 = r7[r1]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r7 != r9) goto L_0x00df
            int r10 = r10 + 1
            if (r1 != 0) goto L_0x00c7
            int r7 = r14.f1389e
            if (r7 == 0) goto L_0x00bd
            r7 = 0
            return r7
        L_0x00bd:
            r7 = 0
            int r9 = r14.h
            if (r9 != 0) goto L_0x00c6
            int r9 = r14.i
            if (r9 == 0) goto L_0x00d6
        L_0x00c6:
            return r7
        L_0x00c7:
            r7 = 0
            int r9 = r14.f1390f
            if (r9 == 0) goto L_0x00cd
            return r7
        L_0x00cd:
            int r9 = r14.k
            if (r9 != 0) goto L_0x00de
            int r9 = r14.l
            if (r9 == 0) goto L_0x00d6
            goto L_0x00de
        L_0x00d6:
            float r9 = r14.G
            r18 = 0
            int r9 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r9 == 0) goto L_0x00df
        L_0x00de:
            return r7
        L_0x00df:
            androidx.constraintlayout.a.a.e[] r7 = r14.A
            int r9 = r26 + 1
            r7 = r7[r9]
            androidx.constraintlayout.a.a.e r7 = r7.f1379c
            if (r7 == 0) goto L_0x0101
            androidx.constraintlayout.a.a.f r7 = r7.f1377a
            androidx.constraintlayout.a.a.e[] r9 = r7.A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.e r9 = r9.f1379c
            if (r9 == 0) goto L_0x0101
            androidx.constraintlayout.a.a.e[] r9 = r7.A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.e r9 = r9.f1379c
            androidx.constraintlayout.a.a.f r9 = r9.f1377a
            if (r9 == r14) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r19 = r7
            goto L_0x0103
        L_0x0101:
            r19 = 0
        L_0x0103:
            if (r19 == 0) goto L_0x0109
            r14 = r19
            goto L_0x0053
        L_0x0109:
            r13 = 1
            goto L_0x0053
        L_0x010c:
            androidx.constraintlayout.a.a.e[] r9 = r3.A
            r9 = r9[r26]
            androidx.constraintlayout.a.a.m r9 = r9.a()
            androidx.constraintlayout.a.a.e[] r13 = r4.A
            int r19 = r26 + 1
            r13 = r13[r19]
            androidx.constraintlayout.a.a.m r13 = r13.a()
            androidx.constraintlayout.a.a.m r7 = r9.f1405c
            if (r7 == 0) goto L_0x0390
            androidx.constraintlayout.a.a.m r7 = r13.f1405c
            if (r7 != 0) goto L_0x0128
            goto L_0x0390
        L_0x0128:
            androidx.constraintlayout.a.a.m r7 = r9.f1405c
            int r7 = r7.i
            r20 = r3
            r3 = 1
            if (r7 != r3) goto L_0x038e
            androidx.constraintlayout.a.a.m r7 = r13.f1405c
            int r7 = r7.i
            if (r7 == r3) goto L_0x0139
            goto L_0x038e
        L_0x0139:
            if (r10 <= 0) goto L_0x013f
            if (r10 == r15) goto L_0x013f
            r3 = 0
            return r3
        L_0x013f:
            if (r2 != 0) goto L_0x0148
            if (r11 != 0) goto L_0x0148
            if (r12 == 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r7 = 0
            goto L_0x0161
        L_0x0148:
            if (r5 == 0) goto L_0x0154
            androidx.constraintlayout.a.a.e[] r3 = r5.A
            r3 = r3[r26]
            int r3 = r3.e()
            float r7 = (float) r3
            goto L_0x0155
        L_0x0154:
            r7 = 0
        L_0x0155:
            if (r6 == 0) goto L_0x0161
            androidx.constraintlayout.a.a.e[] r3 = r6.A
            r3 = r3[r19]
            int r3 = r3.e()
            float r3 = (float) r3
            float r7 = r7 + r3
        L_0x0161:
            androidx.constraintlayout.a.a.m r3 = r9.f1405c
            float r3 = r3.f1408f
            androidx.constraintlayout.a.a.m r6 = r13.f1405c
            float r6 = r6.f1408f
            int r13 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x016f
            float r6 = r6 - r3
            goto L_0x0171
        L_0x016f:
            float r6 = r3 - r6
        L_0x0171:
            float r6 = r6 - r16
            r21 = 1
            if (r10 <= 0) goto L_0x0227
            if (r10 != r15) goto L_0x0227
            androidx.constraintlayout.a.a.f r2 = r14.l()
            if (r2 == 0) goto L_0x018d
            androidx.constraintlayout.a.a.f r2 = r14.l()
            androidx.constraintlayout.a.a.f$a[] r2 = r2.C
            r2 = r2[r1]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r2 != r5) goto L_0x018d
            r2 = 0
            return r2
        L_0x018d:
            float r6 = r6 + r16
            float r6 = r6 - r17
            r2 = r20
        L_0x0193:
            if (r2 == 0) goto L_0x0225
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            if (r5 == 0) goto L_0x01b1
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            long r11 = r5.B
            long r11 = r11 - r21
            r5.B = r11
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            long r11 = r5.s
            long r11 = r11 + r21
            r5.s = r11
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            long r11 = r5.y
            long r11 = r11 + r21
            r5.y = r11
        L_0x01b1:
            androidx.constraintlayout.a.a.f[] r5 = r2.af
            r5 = r5[r1]
            if (r5 != 0) goto L_0x01b9
            if (r2 != r4) goto L_0x0222
        L_0x01b9:
            float r7 = (float) r10
            float r7 = r6 / r7
            r11 = 0
            int r12 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x01d4
            float[] r7 = r2.ad
            r7 = r7[r1]
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x01cd
            r7 = 0
            goto L_0x01d4
        L_0x01cd:
            float[] r7 = r2.ad
            r7 = r7[r1]
            float r7 = r7 * r6
            float r7 = r7 / r8
        L_0x01d4:
            int r11 = r2.m()
            r12 = 8
            if (r11 != r12) goto L_0x01dd
            r7 = 0
        L_0x01dd:
            androidx.constraintlayout.a.a.e[] r11 = r2.A
            r11 = r11[r26]
            int r11 = r11.e()
            float r11 = (float) r11
            float r3 = r3 + r11
            androidx.constraintlayout.a.a.e[] r11 = r2.A
            r11 = r11[r26]
            androidx.constraintlayout.a.a.m r11 = r11.a()
            androidx.constraintlayout.a.a.m r12 = r9.f1407e
            r11.a((androidx.constraintlayout.a.a.m) r12, (float) r3)
            androidx.constraintlayout.a.a.e[] r11 = r2.A
            r11 = r11[r19]
            androidx.constraintlayout.a.a.m r11 = r11.a()
            androidx.constraintlayout.a.a.m r12 = r9.f1407e
            float r3 = r3 + r7
            r11.a((androidx.constraintlayout.a.a.m) r12, (float) r3)
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r26]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            r7.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r19]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            r7.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.A
            r2 = r2[r19]
            int r2 = r2.e()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x0222:
            r2 = r5
            goto L_0x0193
        L_0x0225:
            r2 = 1
            return r2
        L_0x0227:
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x022f
            r2 = 1
            r11 = 0
            r12 = 0
        L_0x022f:
            if (r2 == 0) goto L_0x02b4
            float r6 = r6 - r7
            r2 = r20
            float r5 = r2.g(r1)
            float r6 = r6 * r5
            float r3 = r3 + r6
        L_0x023b:
            if (r2 == 0) goto L_0x02bb
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            if (r5 == 0) goto L_0x0259
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            long r6 = r5.B
            long r6 = r6 - r21
            r5.B = r6
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            long r6 = r5.s
            long r6 = r6 + r21
            r5.s = r6
            androidx.constraintlayout.a.f r5 = androidx.constraintlayout.a.e.f1429g
            long r6 = r5.y
            long r6 = r6 + r21
            r5.y = r6
        L_0x0259:
            androidx.constraintlayout.a.a.f[] r5 = r2.af
            r5 = r5[r1]
            if (r5 != 0) goto L_0x0261
            if (r2 != r4) goto L_0x02b2
        L_0x0261:
            if (r1 != 0) goto L_0x0268
            int r6 = r2.q()
            goto L_0x026c
        L_0x0268:
            int r6 = r2.s()
        L_0x026c:
            float r6 = (float) r6
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r26]
            int r7 = r7.e()
            float r7 = (float) r7
            float r3 = r3 + r7
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r26]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            androidx.constraintlayout.a.a.m r8 = r9.f1407e
            r7.a((androidx.constraintlayout.a.a.m) r8, (float) r3)
            androidx.constraintlayout.a.a.e[] r7 = r2.A
            r7 = r7[r19]
            androidx.constraintlayout.a.a.m r7 = r7.a()
            androidx.constraintlayout.a.a.m r8 = r9.f1407e
            float r3 = r3 + r6
            r7.a((androidx.constraintlayout.a.a.m) r8, (float) r3)
            androidx.constraintlayout.a.a.e[] r6 = r2.A
            r6 = r6[r26]
            androidx.constraintlayout.a.a.m r6 = r6.a()
            r6.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r6 = r2.A
            r6 = r6[r19]
            androidx.constraintlayout.a.a.m r6 = r6.a()
            r6.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.A
            r2 = r2[r19]
            int r2 = r2.e()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x02b2:
            r2 = r5
            goto L_0x023b
        L_0x02b4:
            r2 = r20
            if (r11 != 0) goto L_0x02be
            if (r12 == 0) goto L_0x02bb
            goto L_0x02be
        L_0x02bb:
            r0 = 1
            goto L_0x038d
        L_0x02be:
            if (r11 == 0) goto L_0x02c2
        L_0x02c0:
            float r6 = r6 - r7
            goto L_0x02c5
        L_0x02c2:
            if (r12 == 0) goto L_0x02c5
            goto L_0x02c0
        L_0x02c5:
            int r7 = r15 + 1
            float r7 = (float) r7
            float r7 = r6 / r7
            if (r12 == 0) goto L_0x02d7
            r8 = 1
            if (r15 <= r8) goto L_0x02d3
            int r7 = r15 + -1
            float r7 = (float) r7
            goto L_0x02d5
        L_0x02d3:
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x02d5:
            float r7 = r6 / r7
        L_0x02d7:
            int r6 = r2.m()
            r8 = 8
            if (r6 == r8) goto L_0x02e2
            float r6 = r3 + r7
            goto L_0x02e3
        L_0x02e2:
            r6 = r3
        L_0x02e3:
            if (r12 == 0) goto L_0x02f2
            r8 = 1
            if (r15 <= r8) goto L_0x02f2
            androidx.constraintlayout.a.a.e[] r6 = r5.A
            r6 = r6[r26]
            int r6 = r6.e()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02f2:
            if (r11 == 0) goto L_0x0300
            if (r5 == 0) goto L_0x0300
            androidx.constraintlayout.a.a.e[] r3 = r5.A
            r3 = r3[r26]
            int r3 = r3.e()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x0300:
            if (r2 == 0) goto L_0x02bb
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.f1429g
            if (r3 == 0) goto L_0x031e
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.f1429g
            long r10 = r3.B
            long r10 = r10 - r21
            r3.B = r10
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.f1429g
            long r10 = r3.s
            long r10 = r10 + r21
            r3.s = r10
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.f1429g
            long r10 = r3.y
            long r10 = r10 + r21
            r3.y = r10
        L_0x031e:
            androidx.constraintlayout.a.a.f[] r3 = r2.af
            r3 = r3[r1]
            if (r3 != 0) goto L_0x032a
            if (r2 != r4) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r8 = 8
            goto L_0x038a
        L_0x032a:
            if (r1 != 0) goto L_0x0331
            int r8 = r2.q()
            goto L_0x0335
        L_0x0331:
            int r8 = r2.s()
        L_0x0335:
            float r8 = (float) r8
            if (r2 == r5) goto L_0x0342
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r26]
            int r10 = r10.e()
            float r10 = (float) r10
            float r6 = r6 + r10
        L_0x0342:
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r26]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            androidx.constraintlayout.a.a.m r11 = r9.f1407e
            r10.a((androidx.constraintlayout.a.a.m) r11, (float) r6)
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r19]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            androidx.constraintlayout.a.a.m r11 = r9.f1407e
            float r12 = r6 + r8
            r10.a((androidx.constraintlayout.a.a.m) r11, (float) r12)
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r26]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            r10.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r10 = r2.A
            r10 = r10[r19]
            androidx.constraintlayout.a.a.m r10 = r10.a()
            r10.a((androidx.constraintlayout.a.e) r0)
            androidx.constraintlayout.a.a.e[] r2 = r2.A
            r2 = r2[r19]
            int r2 = r2.e()
            float r2 = (float) r2
            float r8 = r8 + r2
            float r6 = r6 + r8
            if (r3 == 0) goto L_0x0327
            int r2 = r3.m()
            r8 = 8
            if (r2 == r8) goto L_0x038a
            float r6 = r6 + r7
        L_0x038a:
            r2 = r3
            goto L_0x0300
        L_0x038d:
            return r0
        L_0x038e:
            r0 = 0
            return r0
        L_0x0390:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.k.a(androidx.constraintlayout.a.a.g, androidx.constraintlayout.a.e, int, int, androidx.constraintlayout.a.a.d):boolean");
    }

    static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        fVar.A[i3].a().f1407e = fVar.l().s.a();
        fVar.A[i3].a().f1408f = (float) i2;
        fVar.A[i3].a().i = 1;
        fVar.A[i4].a().f1407e = fVar.A[i3].a();
        fVar.A[i4].a().f1408f = (float) fVar.f(i);
        fVar.A[i4].a().i = 1;
    }
}
