package androidx.constraintlayout.a;

import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class b implements e.a {

    /* renamed from: a  reason: collision with root package name */
    h f1421a = null;

    /* renamed from: b  reason: collision with root package name */
    float f1422b = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: c  reason: collision with root package name */
    boolean f1423c = false;

    /* renamed from: d  reason: collision with root package name */
    public final a f1424d;

    /* renamed from: e  reason: collision with root package name */
    boolean f1425e = false;

    public b(c cVar) {
        this.f1424d = new a(this, cVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        h hVar = this.f1421a;
        return hVar != null && (hVar.f1450f == h.a.UNRESTRICTED || this.f1422b >= BitmapDescriptorFactory.HUE_RED);
    }

    public String toString() {
        return b();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b() {
        /*
            r9 = this;
            androidx.constraintlayout.a.h r0 = r9.f1421a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.a.h r1 = r9.f1421a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r9.f1422b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.f1422b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            androidx.constraintlayout.a.a r5 = r9.f1424d
            int r5 = r5.f1363a
        L_0x005b:
            if (r2 >= r5) goto L_0x00ec
            androidx.constraintlayout.a.a r6 = r9.f1424d
            androidx.constraintlayout.a.h r6 = r6.a((int) r2)
            if (r6 != 0) goto L_0x0067
            goto L_0x00e8
        L_0x0067:
            androidx.constraintlayout.a.a r7 = r9.f1424d
            float r7 = r7.b((int) r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0073
            goto L_0x00e8
        L_0x0073:
            java.lang.String r6 = r6.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0091
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x0091:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ba
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b8:
            float r7 = r7 * r8
        L_0x00ba:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00d0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e7
        L_0x00d0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e7:
            r1 = 1
        L_0x00e8:
            int r2 = r2 + 1
            goto L_0x005b
        L_0x00ec:
            if (r1 != 0) goto L_0x00ff
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00ff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.b.b():java.lang.String");
    }

    public void c() {
        this.f1421a = null;
        this.f1424d.a();
        this.f1422b = BitmapDescriptorFactory.HUE_RED;
        this.f1425e = false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(h hVar) {
        return this.f1424d.a(hVar);
    }

    /* access modifiers changed from: package-private */
    public b a(h hVar, int i) {
        this.f1421a = hVar;
        float f2 = (float) i;
        hVar.f1448d = f2;
        this.f1422b = f2;
        this.f1425e = true;
        return this;
    }

    public b b(h hVar, int i) {
        if (i < 0) {
            this.f1422b = (float) (i * -1);
            this.f1424d.a(hVar, 1.0f);
        } else {
            this.f1422b = (float) i;
            this.f1424d.a(hVar, -1.0f);
        }
        return this;
    }

    public b a(h hVar, h hVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1422b = (float) i;
        }
        if (!z) {
            this.f1424d.a(hVar, -1.0f);
            this.f1424d.a(hVar2, 1.0f);
        } else {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b c(h hVar, int i) {
        this.f1424d.a(hVar, (float) i);
        return this;
    }

    public b a(h hVar, h hVar2, h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1422b = (float) i;
        }
        if (!z) {
            this.f1424d.a(hVar, -1.0f);
            this.f1424d.a(hVar2, 1.0f);
            this.f1424d.a(hVar3, 1.0f);
        } else {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
            this.f1424d.a(hVar3, -1.0f);
        }
        return this;
    }

    public b b(h hVar, h hVar2, h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1422b = (float) i;
        }
        if (!z) {
            this.f1424d.a(hVar, -1.0f);
            this.f1424d.a(hVar2, 1.0f);
            this.f1424d.a(hVar3, -1.0f);
        } else {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
            this.f1424d.a(hVar3, 1.0f);
        }
        return this;
    }

    public b a(float f2, float f3, float f4, h hVar, h hVar2, h hVar3, h hVar4) {
        this.f1422b = BitmapDescriptorFactory.HUE_RED;
        if (f3 == BitmapDescriptorFactory.HUE_RED || f2 == f4) {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
            this.f1424d.a(hVar4, 1.0f);
            this.f1424d.a(hVar3, -1.0f);
        } else if (f2 == BitmapDescriptorFactory.HUE_RED) {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
        } else if (f4 == BitmapDescriptorFactory.HUE_RED) {
            this.f1424d.a(hVar3, 1.0f);
            this.f1424d.a(hVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
            this.f1424d.a(hVar4, f5);
            this.f1424d.a(hVar3, -f5);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(h hVar, h hVar2, int i, float f2, h hVar3, h hVar4, int i2) {
        if (hVar2 == hVar3) {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar4, 1.0f);
            this.f1424d.a(hVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f1424d.a(hVar, 1.0f);
            this.f1424d.a(hVar2, -1.0f);
            this.f1424d.a(hVar3, -1.0f);
            this.f1424d.a(hVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f1422b = (float) ((-i) + i2);
            }
        } else if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            this.f1424d.a(hVar, -1.0f);
            this.f1424d.a(hVar2, 1.0f);
            this.f1422b = (float) i;
        } else if (f2 >= 1.0f) {
            this.f1424d.a(hVar3, -1.0f);
            this.f1424d.a(hVar4, 1.0f);
            this.f1422b = (float) i2;
        } else {
            float f3 = 1.0f - f2;
            this.f1424d.a(hVar, f3 * 1.0f);
            this.f1424d.a(hVar2, f3 * -1.0f);
            this.f1424d.a(hVar3, -1.0f * f2);
            this.f1424d.a(hVar4, 1.0f * f2);
            if (i > 0 || i2 > 0) {
                this.f1422b = (((float) (-i)) * f3) + (((float) i2) * f2);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.f1424d.a(eVar.a(i, "ep"), 1.0f);
        this.f1424d.a(eVar.a(i, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(h hVar, h hVar2, h hVar3, float f2) {
        this.f1424d.a(hVar, -1.0f);
        this.f1424d.a(hVar2, 1.0f - f2);
        this.f1424d.a(hVar3, f2);
        return this;
    }

    public b a(h hVar, h hVar2, h hVar3, h hVar4, float f2) {
        this.f1424d.a(hVar, -1.0f);
        this.f1424d.a(hVar2, 1.0f);
        this.f1424d.a(hVar3, f2);
        this.f1424d.a(hVar4, -f2);
        return this;
    }

    public b b(h hVar, h hVar2, h hVar3, h hVar4, float f2) {
        this.f1424d.a(hVar3, 0.5f);
        this.f1424d.a(hVar4, 0.5f);
        this.f1424d.a(hVar, -0.5f);
        this.f1424d.a(hVar2, -0.5f);
        this.f1422b = -f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        float f2 = this.f1422b;
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            this.f1422b = f2 * -1.0f;
            this.f1424d.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(e eVar) {
        boolean z;
        h a2 = this.f1424d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            c(a2);
            z = false;
        }
        if (this.f1424d.f1363a == 0) {
            this.f1425e = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public h b(h hVar) {
        return this.f1424d.a((boolean[]) null, hVar);
    }

    /* access modifiers changed from: package-private */
    public void c(h hVar) {
        h hVar2 = this.f1421a;
        if (hVar2 != null) {
            this.f1424d.a(hVar2, -1.0f);
            this.f1421a = null;
        }
        float a2 = this.f1424d.a(hVar, true) * -1.0f;
        this.f1421a = hVar;
        if (a2 != 1.0f) {
            this.f1422b /= a2;
            this.f1424d.a(a2);
        }
    }

    public boolean e() {
        return this.f1421a == null && this.f1422b == BitmapDescriptorFactory.HUE_RED && this.f1424d.f1363a == 0;
    }

    public h a(e eVar, boolean[] zArr) {
        return this.f1424d.a(zArr, (h) null);
    }

    public void f() {
        this.f1424d.a();
        this.f1421a = null;
        this.f1422b = BitmapDescriptorFactory.HUE_RED;
    }

    public void a(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f1421a = null;
            this.f1424d.a();
            for (int i = 0; i < bVar.f1424d.f1363a; i++) {
                this.f1424d.a(bVar.f1424d.a(i), bVar.f1424d.b(i), true);
            }
        }
    }

    public void d(h hVar) {
        float f2 = 1.0f;
        if (hVar.f1447c != 1) {
            if (hVar.f1447c == 2) {
                f2 = 1000.0f;
            } else if (hVar.f1447c == 3) {
                f2 = 1000000.0f;
            } else if (hVar.f1447c == 4) {
                f2 = 1.0E9f;
            } else if (hVar.f1447c == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f1424d.a(hVar, f2);
    }

    public h g() {
        return this.f1421a;
    }
}
