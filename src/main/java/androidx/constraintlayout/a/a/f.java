package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.ArrayList;

public class f {
    public static float R = 0.5f;
    protected e[] A = {this.s, this.u, this.t, this.v, this.w, this.z};
    protected ArrayList<e> B = new ArrayList<>();
    protected a[] C = {a.FIXED, a.FIXED};
    f D = null;
    int E = 0;
    int F = 0;
    protected float G = BitmapDescriptorFactory.HUE_RED;
    protected int H = -1;
    protected int I = 0;
    protected int J = 0;
    int K = 0;
    int L = 0;
    protected int M = 0;
    protected int N = 0;
    int O = 0;
    protected int P;
    protected int Q;
    float S;
    float T;
    boolean U;
    boolean V;
    boolean W;
    boolean X;
    boolean Y;
    int Z;

    /* renamed from: a  reason: collision with root package name */
    public int f1385a = -1;
    int aa;
    boolean ab;
    boolean ac;
    float[] ad;
    protected f[] ae;
    protected f[] af;
    f ag;
    f ah;
    private int[] ai = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float aj = BitmapDescriptorFactory.HUE_RED;
    private int ak = 0;
    private int al = 0;
    private int am = 0;
    private int an = 0;
    private int ao;
    private int ap;
    private Object aq;
    private int ar;
    private int as;
    private String at;
    private String au;

    /* renamed from: b  reason: collision with root package name */
    public int f1386b = -1;

    /* renamed from: c  reason: collision with root package name */
    n f1387c;

    /* renamed from: d  reason: collision with root package name */
    n f1388d;

    /* renamed from: e  reason: collision with root package name */
    int f1389e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f1390f = 0;

    /* renamed from: g  reason: collision with root package name */
    int[] f1391g = new int[2];
    int h = 0;
    int i = 0;
    float j = 1.0f;
    int k = 0;
    int l = 0;
    float m = 1.0f;
    boolean n;
    boolean o;
    int p = -1;
    float q = 1.0f;
    h r = null;
    e s = new e(this, e.c.LEFT);
    e t = new e(this, e.c.TOP);
    e u = new e(this, e.c.RIGHT);
    e v = new e(this, e.c.BOTTOM);
    e w = new e(this, e.c.BASELINE);
    e x = new e(this, e.c.CENTER_X);
    e y = new e(this, e.c.CENTER_Y);
    e z = new e(this, e.c.CENTER);

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void d() {
    }

    public void c(int i2) {
        this.ai[0] = i2;
    }

    public void d(int i2) {
        this.ai[1] = i2;
    }

    public boolean e() {
        return this.f1389e == 0 && this.G == BitmapDescriptorFactory.HUE_RED && this.h == 0 && this.i == 0 && this.C[0] == a.MATCH_CONSTRAINT;
    }

    public boolean f() {
        return this.f1390f == 0 && this.G == BitmapDescriptorFactory.HUE_RED && this.k == 0 && this.l == 0 && this.C[1] == a.MATCH_CONSTRAINT;
    }

    public void g() {
        this.s.i();
        this.t.i();
        this.u.i();
        this.v.i();
        this.w.i();
        this.x.i();
        this.y.i();
        this.z.i();
        this.D = null;
        this.aj = BitmapDescriptorFactory.HUE_RED;
        this.E = 0;
        this.F = 0;
        this.G = BitmapDescriptorFactory.HUE_RED;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.ak = 0;
        this.al = 0;
        this.am = 0;
        this.an = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.ao = 0;
        this.ap = 0;
        float f2 = R;
        this.S = f2;
        this.T = f2;
        this.C[0] = a.FIXED;
        this.C[1] = a.FIXED;
        this.aq = null;
        this.ar = 0;
        this.as = 0;
        this.au = null;
        this.U = false;
        this.V = false;
        this.Z = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = false;
        float[] fArr = this.ad;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1385a = -1;
        this.f1386b = -1;
        int[] iArr = this.ai;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1389e = 0;
        this.f1390f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.h = 0;
        this.k = 0;
        this.p = -1;
        this.q = 1.0f;
        n nVar = this.f1387c;
        if (nVar != null) {
            nVar.b();
        }
        n nVar2 = this.f1388d;
        if (nVar2 != null) {
            nVar2.b();
        }
        this.r = null;
        this.W = false;
        this.X = false;
        this.Y = false;
    }

    public void c() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.A[i2].a().b();
        }
    }

    public void h() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.A[i2].a().c();
        }
    }

    public void b(int i2) {
        k.a(i2, this);
    }

    public boolean i() {
        if (this.s.a().i == 1 && this.u.a().i == 1 && this.t.a().i == 1 && this.v.a().i == 1) {
            return true;
        }
        return false;
    }

    public n j() {
        if (this.f1387c == null) {
            this.f1387c = new n();
        }
        return this.f1387c;
    }

    public n k() {
        if (this.f1388d == null) {
            this.f1388d = new n();
        }
        return this.f1388d;
    }

    public f() {
        float f2 = R;
        this.S = f2;
        this.T = f2;
        this.ar = 0;
        this.as = 0;
        this.at = null;
        this.au = null;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = 0;
        this.aa = 0;
        this.ad = new float[]{-1.0f, -1.0f};
        this.ae = new f[]{null, null};
        this.af = new f[]{null, null};
        this.ag = null;
        this.ah = null;
        b();
    }

    public void a(c cVar) {
        this.s.a(cVar);
        this.t.a(cVar);
        this.u.a(cVar);
        this.v.a(cVar);
        this.w.a(cVar);
        this.z.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
    }

    private void b() {
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    public f l() {
        return this.D;
    }

    public void a(f fVar) {
        this.D = fVar;
    }

    public void b(boolean z2) {
        this.n = z2;
    }

    public void c(boolean z2) {
        this.o = z2;
    }

    public void a(f fVar, float f2, int i2) {
        a(e.c.CENTER, fVar, e.c.CENTER, i2, 0);
        this.aj = f2;
    }

    public void e(int i2) {
        this.as = i2;
    }

    public int m() {
        return this.as;
    }

    public String n() {
        return this.at;
    }

    public void a(String str) {
        this.at = str;
    }

    public void b(androidx.constraintlayout.a.e eVar) {
        eVar.a((Object) this.s);
        eVar.a((Object) this.t);
        eVar.a((Object) this.u);
        eVar.a((Object) this.v);
        if (this.O > 0) {
            eVar.a((Object) this.w);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.au != null) {
            str = "type: " + this.au + SQLBuilder.BLANK;
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.at != null) {
            str2 = "id: " + this.at + SQLBuilder.BLANK;
        }
        sb.append(str2);
        sb.append(SQLBuilder.PARENTHESES_LEFT);
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        sb.append(" x ");
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.ao);
        sb.append(" x ");
        sb.append(this.ap);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb.toString();
    }

    public int o() {
        return this.I;
    }

    public int p() {
        return this.J;
    }

    public int q() {
        if (this.as == 8) {
            return 0;
        }
        return this.E;
    }

    public int r() {
        return this.ao;
    }

    public int s() {
        if (this.as == 8) {
            return 0;
        }
        return this.F;
    }

    public int t() {
        return this.ap;
    }

    public int f(int i2) {
        if (i2 == 0) {
            return q();
        }
        if (i2 == 1) {
            return s();
        }
        return 0;
    }

    public int u() {
        return this.ak + this.M;
    }

    public int v() {
        return this.al + this.N;
    }

    /* access modifiers changed from: protected */
    public int w() {
        return this.I + this.M;
    }

    /* access modifiers changed from: protected */
    public int x() {
        return this.J + this.N;
    }

    public int y() {
        return o() + this.E;
    }

    public int z() {
        return p() + this.F;
    }

    public float g(int i2) {
        if (i2 == 0) {
            return this.S;
        }
        if (i2 == 1) {
            return this.T;
        }
        return -1.0f;
    }

    public boolean A() {
        return this.O > 0;
    }

    public int B() {
        return this.O;
    }

    public Object C() {
        return this.aq;
    }

    public ArrayList<e> D() {
        return this.B;
    }

    public void h(int i2) {
        this.I = i2;
    }

    public void i(int i2) {
        this.J = i2;
    }

    public void a(int i2, int i3) {
        this.I = i2;
        this.J = i3;
    }

    public void b(int i2, int i3) {
        this.M = i2;
        this.N = i3;
    }

    public void E() {
        int i2 = this.I;
        int i3 = this.J;
        this.ak = i2;
        this.al = i3;
        this.am = (this.E + i2) - i2;
        this.an = (this.F + i3) - i3;
    }

    public void j(int i2) {
        this.E = i2;
        int i3 = this.E;
        int i4 = this.P;
        if (i3 < i4) {
            this.E = i4;
        }
    }

    public void k(int i2) {
        this.F = i2;
        int i3 = this.F;
        int i4 = this.Q;
        if (i3 < i4) {
            this.F = i4;
        }
    }

    public void a(int i2, int i3, int i4, float f2) {
        this.f1389e = i2;
        this.h = i3;
        this.i = i4;
        this.j = f2;
        if (f2 < 1.0f && this.f1389e == 0) {
            this.f1389e = 2;
        }
    }

    public void b(int i2, int i3, int i4, float f2) {
        this.f1390f = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        if (f2 < 1.0f && this.f1390f == 0) {
            this.f1390f = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.G = r9
            r8.H = r1
        L_0x008d:
            return
        L_0x008e:
            r8.G = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.b(java.lang.String):void");
    }

    public void a(float f2) {
        this.S = f2;
    }

    public void b(float f2) {
        this.T = f2;
    }

    public void l(int i2) {
        if (i2 < 0) {
            this.P = 0;
        } else {
            this.P = i2;
        }
    }

    public void m(int i2) {
        if (i2 < 0) {
            this.Q = 0;
        } else {
            this.Q = i2;
        }
    }

    public void n(int i2) {
        this.ao = i2;
    }

    public void o(int i2) {
        this.ap = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r5 < r3) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r4 < r2) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            int r4 = r4 - r2
            int r5 = r5 - r3
            r1.I = r2
            r1.J = r3
            int r2 = r1.as
            r3 = 0
            r0 = 8
            if (r2 != r0) goto L_0x0012
            r1.E = r3
            r1.F = r3
            return
        L_0x0012:
            androidx.constraintlayout.a.a.f$a[] r2 = r1.C
            r2 = r2[r3]
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.a.a.f.a.FIXED
            if (r2 != r3) goto L_0x001f
            int r2 = r1.E
            if (r4 >= r2) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r2 = r4
        L_0x0020:
            androidx.constraintlayout.a.a.f$a[] r3 = r1.C
            r4 = 1
            r3 = r3[r4]
            androidx.constraintlayout.a.a.f$a r0 = androidx.constraintlayout.a.a.f.a.FIXED
            if (r3 != r0) goto L_0x002e
            int r3 = r1.F
            if (r5 >= r3) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r3 = r5
        L_0x002f:
            r1.E = r2
            r1.F = r3
            int r2 = r1.F
            int r3 = r1.Q
            if (r2 >= r3) goto L_0x003b
            r1.F = r3
        L_0x003b:
            int r2 = r1.E
            int r3 = r1.P
            if (r2 >= r3) goto L_0x0043
            r1.E = r3
        L_0x0043:
            r1.X = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.a(int, int, int, int):void");
    }

    public void a(int i2, int i3, int i4) {
        if (i4 == 0) {
            c(i2, i3);
        } else if (i4 == 1) {
            d(i2, i3);
        }
        this.X = true;
    }

    public void c(int i2, int i3) {
        this.I = i2;
        this.E = i3 - i2;
        int i4 = this.E;
        int i5 = this.P;
        if (i4 < i5) {
            this.E = i5;
        }
    }

    public void d(int i2, int i3) {
        this.J = i2;
        this.F = i3 - i2;
        int i4 = this.F;
        int i5 = this.Q;
        if (i4 < i5) {
            this.F = i5;
        }
    }

    /* access modifiers changed from: package-private */
    public int p(int i2) {
        if (i2 == 0) {
            return this.K;
        }
        if (i2 == 1) {
            return this.L;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, int i3) {
        if (i3 == 0) {
            this.K = i2;
        } else if (i3 == 1) {
            this.L = i2;
        }
    }

    public void q(int i2) {
        this.O = i2;
    }

    public void a(Object obj) {
        this.aq = obj;
    }

    public void c(float f2) {
        this.ad[0] = f2;
    }

    public void d(float f2) {
        this.ad[1] = f2;
    }

    public void r(int i2) {
        this.Z = i2;
    }

    public void s(int i2) {
        this.aa = i2;
    }

    public boolean a() {
        return this.as != 8;
    }

    public void a(e.c cVar, f fVar, e.c cVar2, int i2, int i3) {
        a(cVar).a(fVar.a(cVar2), i2, i3, e.b.STRONG, 0, true);
    }

    public void F() {
        f l2 = l();
        if (l2 == null || !(l2 instanceof g) || !((g) l()).S()) {
            int size = this.B.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.B.get(i2).i();
            }
        }
    }

    public e a(e.c cVar) {
        switch (cVar) {
            case LEFT:
                return this.s;
            case TOP:
                return this.t;
            case RIGHT:
                return this.u;
            case BOTTOM:
                return this.v;
            case BASELINE:
                return this.w;
            case CENTER:
                return this.z;
            case CENTER_X:
                return this.x;
            case CENTER_Y:
                return this.y;
            case NONE:
                return null;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public a G() {
        return this.C[0];
    }

    public a H() {
        return this.C[1];
    }

    public a t(int i2) {
        if (i2 == 0) {
            return G();
        }
        if (i2 == 1) {
            return H();
        }
        return null;
    }

    public void a(a aVar) {
        this.C[0] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            j(this.ao);
        }
    }

    public void b(a aVar) {
        this.C[1] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            k(this.ap);
        }
    }

    public boolean I() {
        if (this.s.f1379c == null || this.s.f1379c.f1379c != this.s) {
            return this.u.f1379c != null && this.u.f1379c.f1379c == this.u;
        }
        return true;
    }

    public boolean J() {
        if (this.t.f1379c == null || this.t.f1379c.f1379c != this.t) {
            return this.v.f1379c != null && this.v.f1379c.f1379c == this.v;
        }
        return true;
    }

    private boolean a(int i2) {
        int i3 = i2 * 2;
        if (this.A[i3].f1379c != null) {
            e eVar = this.A[i3].f1379c.f1379c;
            e[] eVarArr = this.A;
            if (eVar != eVarArr[i3]) {
                int i4 = i3 + 1;
                return eVarArr[i4].f1379c != null && this.A[i4].f1379c.f1379c == this.A[i4];
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01b6, code lost:
        if (r1 == -1) goto L_0x01ba;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x025a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.a.e r39) {
        /*
            r38 = this;
            r15 = r38
            r14 = r39
            androidx.constraintlayout.a.a.e r0 = r15.s
            androidx.constraintlayout.a.h r21 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.e r0 = r15.u
            androidx.constraintlayout.a.h r10 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.e r0 = r15.t
            androidx.constraintlayout.a.h r6 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.e r0 = r15.v
            androidx.constraintlayout.a.h r4 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.e r0 = r15.w
            androidx.constraintlayout.a.h r3 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.a.a.f r0 = r15.D
            r1 = 8
            r2 = 1
            r13 = 0
            if (r0 == 0) goto L_0x00b0
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.a.a.f$a[] r0 = r0.C
            r0 = r0[r13]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r0 != r5) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            androidx.constraintlayout.a.a.f r5 = r15.D
            if (r5 == 0) goto L_0x0045
            androidx.constraintlayout.a.a.f$a[] r5 = r5.C
            r5 = r5[r2]
            androidx.constraintlayout.a.a.f$a r7 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r5 != r7) goto L_0x0045
            r5 = 1
            goto L_0x0046
        L_0x0045:
            r5 = 0
        L_0x0046:
            boolean r7 = r15.a((int) r13)
            if (r7 == 0) goto L_0x0055
            androidx.constraintlayout.a.a.f r7 = r15.D
            androidx.constraintlayout.a.a.g r7 = (androidx.constraintlayout.a.a.g) r7
            r7.a((androidx.constraintlayout.a.a.f) r15, (int) r13)
            r7 = 1
            goto L_0x0059
        L_0x0055:
            boolean r7 = r38.I()
        L_0x0059:
            boolean r8 = r15.a((int) r2)
            if (r8 == 0) goto L_0x0068
            androidx.constraintlayout.a.a.f r8 = r15.D
            androidx.constraintlayout.a.a.g r8 = (androidx.constraintlayout.a.a.g) r8
            r8.a((androidx.constraintlayout.a.a.f) r15, (int) r2)
            r8 = 1
            goto L_0x006c
        L_0x0068:
            boolean r8 = r38.J()
        L_0x006c:
            if (r0 == 0) goto L_0x0089
            int r9 = r15.as
            if (r9 == r1) goto L_0x0089
            androidx.constraintlayout.a.a.e r9 = r15.s
            androidx.constraintlayout.a.a.e r9 = r9.f1379c
            if (r9 != 0) goto L_0x0089
            androidx.constraintlayout.a.a.e r9 = r15.u
            androidx.constraintlayout.a.a.e r9 = r9.f1379c
            if (r9 != 0) goto L_0x0089
            androidx.constraintlayout.a.a.f r9 = r15.D
            androidx.constraintlayout.a.a.e r9 = r9.u
            androidx.constraintlayout.a.h r9 = r14.a((java.lang.Object) r9)
            r14.a((androidx.constraintlayout.a.h) r9, (androidx.constraintlayout.a.h) r10, (int) r13, (int) r2)
        L_0x0089:
            if (r5 == 0) goto L_0x00aa
            int r9 = r15.as
            if (r9 == r1) goto L_0x00aa
            androidx.constraintlayout.a.a.e r9 = r15.t
            androidx.constraintlayout.a.a.e r9 = r9.f1379c
            if (r9 != 0) goto L_0x00aa
            androidx.constraintlayout.a.a.e r9 = r15.v
            androidx.constraintlayout.a.a.e r9 = r9.f1379c
            if (r9 != 0) goto L_0x00aa
            androidx.constraintlayout.a.a.e r9 = r15.w
            if (r9 != 0) goto L_0x00aa
            androidx.constraintlayout.a.a.f r9 = r15.D
            androidx.constraintlayout.a.a.e r9 = r9.v
            androidx.constraintlayout.a.h r9 = r14.a((java.lang.Object) r9)
            r14.a((androidx.constraintlayout.a.h) r9, (androidx.constraintlayout.a.h) r4, (int) r13, (int) r2)
        L_0x00aa:
            r12 = r5
            r16 = r7
            r22 = r8
            goto L_0x00b6
        L_0x00b0:
            r0 = 0
            r12 = 0
            r16 = 0
            r22 = 0
        L_0x00b6:
            int r5 = r15.E
            int r7 = r15.P
            if (r5 >= r7) goto L_0x00bd
            r5 = r7
        L_0x00bd:
            int r7 = r15.F
            int r8 = r15.Q
            if (r7 >= r8) goto L_0x00c4
            r7 = r8
        L_0x00c4:
            androidx.constraintlayout.a.a.f$a[] r8 = r15.C
            r8 = r8[r13]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r8 == r9) goto L_0x00ce
            r8 = 1
            goto L_0x00cf
        L_0x00ce:
            r8 = 0
        L_0x00cf:
            androidx.constraintlayout.a.a.f$a[] r9 = r15.C
            r9 = r9[r2]
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r9 == r11) goto L_0x00d9
            r9 = 1
            goto L_0x00da
        L_0x00d9:
            r9 = 0
        L_0x00da:
            int r11 = r15.H
            r15.p = r11
            float r11 = r15.G
            r15.q = r11
            int r2 = r15.f1389e
            int r13 = r15.f1390f
            r18 = 0
            r19 = 4
            int r11 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r11 <= 0) goto L_0x019b
            int r11 = r15.as
            r1 = 8
            if (r11 == r1) goto L_0x019b
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r11 = 0
            r1 = r1[r11]
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            r23 = r3
            r3 = 3
            if (r1 != r11) goto L_0x0103
            if (r2 != 0) goto L_0x0103
            r2 = 3
        L_0x0103:
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r11 = 1
            r1 = r1[r11]
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r1 != r11) goto L_0x010f
            if (r13 != 0) goto L_0x010f
            r13 = 3
        L_0x010f:
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r11 = 0
            r1 = r1[r11]
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r1 != r11) goto L_0x012a
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r11 = 1
            r1 = r1[r11]
            androidx.constraintlayout.a.a.f$a r11 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r1 != r11) goto L_0x012a
            if (r2 != r3) goto L_0x012a
            if (r13 != r3) goto L_0x012a
            r15.a((boolean) r0, (boolean) r12, (boolean) r8, (boolean) r9)
            goto L_0x0190
        L_0x012a:
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r8 = 0
            r1 = r1[r8]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r1 != r9) goto L_0x0156
            if (r2 != r3) goto L_0x0156
            r15.p = r8
            float r1 = r15.q
            int r3 = r15.F
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            androidx.constraintlayout.a.a.f$a[] r3 = r15.C
            r8 = 1
            r3 = r3[r8]
            androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r3 == r5) goto L_0x0151
            r28 = r1
            r29 = r7
            r26 = r13
            r25 = 4
            goto L_0x01a5
        L_0x0151:
            r28 = r1
            r25 = r2
            goto L_0x0194
        L_0x0156:
            r8 = 1
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r1 = r1[r8]
            androidx.constraintlayout.a.a.f$a r9 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r1 != r9) goto L_0x0190
            if (r13 != r3) goto L_0x0190
            r15.p = r8
            int r1 = r15.H
            r3 = -1
            if (r1 != r3) goto L_0x016f
            r1 = 1065353216(0x3f800000, float:1.0)
            float r3 = r15.q
            float r1 = r1 / r3
            r15.q = r1
        L_0x016f:
            float r1 = r15.q
            int r3 = r15.E
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            androidx.constraintlayout.a.a.f$a[] r3 = r15.C
            r7 = 0
            r3 = r3[r7]
            androidx.constraintlayout.a.a.f$a r7 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT
            if (r3 == r7) goto L_0x0189
            r29 = r1
            r25 = r2
            r28 = r5
            r26 = 4
            goto L_0x01a5
        L_0x0189:
            r29 = r1
            r25 = r2
            r28 = r5
            goto L_0x0196
        L_0x0190:
            r25 = r2
            r28 = r5
        L_0x0194:
            r29 = r7
        L_0x0196:
            r26 = r13
            r27 = 1
            goto L_0x01a7
        L_0x019b:
            r23 = r3
            r25 = r2
            r28 = r5
            r29 = r7
            r26 = r13
        L_0x01a5:
            r27 = 0
        L_0x01a7:
            int[] r1 = r15.f1391g
            r2 = 0
            r1[r2] = r25
            r2 = 1
            r1[r2] = r26
            if (r27 == 0) goto L_0x01bd
            int r1 = r15.p
            if (r1 == 0) goto L_0x01b9
            r2 = -1
            if (r1 != r2) goto L_0x01be
            goto L_0x01ba
        L_0x01b9:
            r2 = -1
        L_0x01ba:
            r24 = 1
            goto L_0x01c0
        L_0x01bd:
            r2 = -1
        L_0x01be:
            r24 = 0
        L_0x01c0:
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r3 = 0
            r1 = r1[r3]
            androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r1 != r3) goto L_0x01d0
            boolean r1 = r15 instanceof androidx.constraintlayout.a.a.g
            if (r1 == 0) goto L_0x01d0
            r30 = 1
            goto L_0x01d2
        L_0x01d0:
            r30 = 0
        L_0x01d2:
            androidx.constraintlayout.a.a.e r1 = r15.z
            boolean r1 = r1.j()
            r3 = 1
            r31 = r1 ^ 1
            int r1 = r15.f1385a
            r13 = 2
            r32 = 0
            if (r1 == r13) goto L_0x0249
            androidx.constraintlayout.a.a.f r1 = r15.D
            if (r1 == 0) goto L_0x01ef
            androidx.constraintlayout.a.a.e r1 = r1.u
            androidx.constraintlayout.a.h r1 = r14.a((java.lang.Object) r1)
            r20 = r1
            goto L_0x01f1
        L_0x01ef:
            r20 = r32
        L_0x01f1:
            androidx.constraintlayout.a.a.f r1 = r15.D
            if (r1 == 0) goto L_0x01fe
            androidx.constraintlayout.a.a.e r1 = r1.s
            androidx.constraintlayout.a.h r1 = r14.a((java.lang.Object) r1)
            r33 = r1
            goto L_0x0200
        L_0x01fe:
            r33 = r32
        L_0x0200:
            androidx.constraintlayout.a.a.f$a[] r1 = r15.C
            r17 = 0
            r5 = r1[r17]
            androidx.constraintlayout.a.a.e r7 = r15.s
            androidx.constraintlayout.a.a.e r8 = r15.u
            int r9 = r15.I
            int r11 = r15.P
            int[] r1 = r15.ai
            r1 = r1[r17]
            r34 = r12
            r12 = r1
            float r1 = r15.S
            r13 = r1
            int r1 = r15.h
            r17 = r1
            int r1 = r15.i
            r18 = r1
            float r1 = r15.j
            r19 = r1
            r35 = r0
            r0 = r38
            r1 = r39
            r3 = -1
            r2 = r35
            r36 = r23
            r3 = r33
            r23 = r4
            r4 = r20
            r37 = r6
            r6 = r30
            r30 = r10
            r10 = r28
            r14 = r24
            r15 = r16
            r16 = r25
            r20 = r31
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0253
        L_0x0249:
            r37 = r6
            r30 = r10
            r34 = r12
            r36 = r23
            r23 = r4
        L_0x0253:
            r15 = r38
            int r0 = r15.f1386b
            r1 = 2
            if (r0 != r1) goto L_0x025b
            return
        L_0x025b:
            androidx.constraintlayout.a.a.f$a[] r0 = r15.C
            r14 = 1
            r0 = r0[r14]
            androidx.constraintlayout.a.a.f$a r1 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT
            if (r0 != r1) goto L_0x026a
            boolean r0 = r15 instanceof androidx.constraintlayout.a.a.g
            if (r0 == 0) goto L_0x026a
            r6 = 1
            goto L_0x026b
        L_0x026a:
            r6 = 0
        L_0x026b:
            if (r27 == 0) goto L_0x0277
            int r0 = r15.p
            if (r0 == r14) goto L_0x0274
            r1 = -1
            if (r0 != r1) goto L_0x0277
        L_0x0274:
            r16 = 1
            goto L_0x0279
        L_0x0277:
            r16 = 0
        L_0x0279:
            int r0 = r15.O
            if (r0 <= 0) goto L_0x02b6
            androidx.constraintlayout.a.a.e r0 = r15.w
            androidx.constraintlayout.a.a.m r0 = r0.a()
            int r0 = r0.i
            if (r0 != r14) goto L_0x0293
            androidx.constraintlayout.a.a.e r0 = r15.w
            androidx.constraintlayout.a.a.m r0 = r0.a()
            r10 = r39
            r0.a((androidx.constraintlayout.a.e) r10)
            goto L_0x02b8
        L_0x0293:
            r10 = r39
            int r0 = r38.B()
            r1 = 6
            r2 = r36
            r4 = r37
            r10.c(r2, r4, r0, r1)
            androidx.constraintlayout.a.a.e r0 = r15.w
            androidx.constraintlayout.a.a.e r0 = r0.f1379c
            if (r0 == 0) goto L_0x02ba
            androidx.constraintlayout.a.a.e r0 = r15.w
            androidx.constraintlayout.a.a.e r0 = r0.f1379c
            androidx.constraintlayout.a.h r0 = r10.a((java.lang.Object) r0)
            r3 = 0
            r10.c(r2, r0, r3, r1)
            r20 = 0
            goto L_0x02bc
        L_0x02b6:
            r10 = r39
        L_0x02b8:
            r4 = r37
        L_0x02ba:
            r20 = r31
        L_0x02bc:
            androidx.constraintlayout.a.a.f r0 = r15.D
            if (r0 == 0) goto L_0x02c9
            androidx.constraintlayout.a.a.e r0 = r0.v
            androidx.constraintlayout.a.h r0 = r10.a((java.lang.Object) r0)
            r24 = r0
            goto L_0x02cb
        L_0x02c9:
            r24 = r32
        L_0x02cb:
            androidx.constraintlayout.a.a.f r0 = r15.D
            if (r0 == 0) goto L_0x02d7
            androidx.constraintlayout.a.a.e r0 = r0.t
            androidx.constraintlayout.a.h r0 = r10.a((java.lang.Object) r0)
            r3 = r0
            goto L_0x02d9
        L_0x02d7:
            r3 = r32
        L_0x02d9:
            androidx.constraintlayout.a.a.f$a[] r0 = r15.C
            r5 = r0[r14]
            androidx.constraintlayout.a.a.e r7 = r15.t
            androidx.constraintlayout.a.a.e r8 = r15.v
            int r9 = r15.J
            int r11 = r15.Q
            int[] r0 = r15.ai
            r12 = r0[r14]
            float r13 = r15.T
            int r0 = r15.k
            r17 = r0
            int r0 = r15.l
            r18 = r0
            float r0 = r15.m
            r19 = r0
            r0 = r38
            r1 = r39
            r2 = r34
            r25 = r4
            r4 = r24
            r10 = r29
            r14 = r16
            r15 = r22
            r16 = r26
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r27 == 0) goto L_0x0337
            r6 = 6
            r7 = r38
            int r0 = r7.p
            r1 = 1
            if (r0 != r1) goto L_0x0326
            float r5 = r7.q
            r0 = r39
            r1 = r23
            r2 = r25
            r3 = r30
            r4 = r21
            r0.a((androidx.constraintlayout.a.h) r1, (androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r3, (androidx.constraintlayout.a.h) r4, (float) r5, (int) r6)
            goto L_0x0339
        L_0x0326:
            float r5 = r7.q
            r6 = 6
            r0 = r39
            r1 = r30
            r2 = r21
            r3 = r23
            r4 = r25
            r0.a((androidx.constraintlayout.a.h) r1, (androidx.constraintlayout.a.h) r2, (androidx.constraintlayout.a.h) r3, (androidx.constraintlayout.a.h) r4, (float) r5, (int) r6)
            goto L_0x0339
        L_0x0337:
            r7 = r38
        L_0x0339:
            androidx.constraintlayout.a.a.e r0 = r7.z
            boolean r0 = r0.j()
            if (r0 == 0) goto L_0x0361
            androidx.constraintlayout.a.a.e r0 = r7.z
            androidx.constraintlayout.a.a.e r0 = r0.g()
            androidx.constraintlayout.a.a.f r0 = r0.c()
            float r1 = r7.aj
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.a.a.e r2 = r7.z
            int r2 = r2.e()
            r3 = r39
            r3.a((androidx.constraintlayout.a.a.f) r7, (androidx.constraintlayout.a.a.f) r0, (float) r1, (int) r2)
        L_0x0361:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.a(androidx.constraintlayout.a.e):void");
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.p == -1) {
            if (z4 && !z5) {
                this.p = 0;
            } else if (!z4 && z5) {
                this.p = 1;
                if (this.H == -1) {
                    this.q = 1.0f / this.q;
                }
            }
        }
        if (this.p == 0 && (!this.t.j() || !this.v.j())) {
            this.p = 1;
        } else if (this.p == 1 && (!this.s.j() || !this.u.j())) {
            this.p = 0;
        }
        if (this.p == -1 && (!this.t.j() || !this.v.j() || !this.s.j() || !this.u.j())) {
            if (this.t.j() && this.v.j()) {
                this.p = 0;
            } else if (this.s.j() && this.u.j()) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (z2 && !z3) {
                this.p = 0;
            } else if (!z2 && z3) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (this.h > 0 && this.k == 0) {
                this.p = 0;
            } else if (this.h == 0 && this.k > 0) {
                this.q = 1.0f / this.q;
                this.p = 1;
            }
        }
        if (this.p == -1 && z2 && z3) {
            this.q = 1.0f / this.q;
            this.p = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.constraintlayout.a.e r26, boolean r27, androidx.constraintlayout.a.h r28, androidx.constraintlayout.a.h r29, androidx.constraintlayout.a.a.f.a r30, boolean r31, androidx.constraintlayout.a.a.e r32, androidx.constraintlayout.a.a.e r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            r25 = this;
            r0 = r25
            r10 = r26
            r11 = r28
            r12 = r29
            r13 = r32
            r14 = r33
            r1 = r36
            r2 = r37
            androidx.constraintlayout.a.h r15 = r10.a((java.lang.Object) r13)
            androidx.constraintlayout.a.h r9 = r10.a((java.lang.Object) r14)
            androidx.constraintlayout.a.a.e r3 = r32.g()
            androidx.constraintlayout.a.h r8 = r10.a((java.lang.Object) r3)
            androidx.constraintlayout.a.a.e r3 = r33.g()
            androidx.constraintlayout.a.h r7 = r10.a((java.lang.Object) r3)
            boolean r3 = r10.f1432c
            r6 = 1
            r4 = 6
            r5 = 0
            if (r3 == 0) goto L_0x0066
            androidx.constraintlayout.a.a.m r3 = r32.a()
            int r3 = r3.i
            if (r3 != r6) goto L_0x0066
            androidx.constraintlayout.a.a.m r3 = r33.a()
            int r3 = r3.i
            if (r3 != r6) goto L_0x0066
            androidx.constraintlayout.a.f r1 = androidx.constraintlayout.a.e.a()
            if (r1 == 0) goto L_0x0050
            androidx.constraintlayout.a.f r1 = androidx.constraintlayout.a.e.a()
            long r2 = r1.s
            r6 = 1
            long r2 = r2 + r6
            r1.s = r2
        L_0x0050:
            androidx.constraintlayout.a.a.m r1 = r32.a()
            r1.a((androidx.constraintlayout.a.e) r10)
            androidx.constraintlayout.a.a.m r1 = r33.a()
            r1.a((androidx.constraintlayout.a.e) r10)
            if (r40 != 0) goto L_0x0065
            if (r27 == 0) goto L_0x0065
            r10.a((androidx.constraintlayout.a.h) r12, (androidx.constraintlayout.a.h) r9, (int) r5, (int) r4)
        L_0x0065:
            return
        L_0x0066:
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.a()
            if (r3 == 0) goto L_0x0078
            androidx.constraintlayout.a.f r3 = androidx.constraintlayout.a.e.a()
            long r4 = r3.B
            r16 = 1
            long r4 = r4 + r16
            r3.B = r4
        L_0x0078:
            boolean r16 = r32.j()
            boolean r17 = r33.j()
            androidx.constraintlayout.a.a.e r3 = r0.z
            boolean r20 = r3.j()
            if (r16 == 0) goto L_0x008a
            r3 = 1
            goto L_0x008b
        L_0x008a:
            r3 = 0
        L_0x008b:
            if (r17 == 0) goto L_0x008f
            int r3 = r3 + 1
        L_0x008f:
            if (r20 == 0) goto L_0x0093
            int r3 = r3 + 1
        L_0x0093:
            r5 = r3
            if (r39 == 0) goto L_0x0098
            r3 = 3
            goto L_0x009a
        L_0x0098:
            r3 = r41
        L_0x009a:
            int[] r21 = androidx.constraintlayout.a.a.f.AnonymousClass1.f1393b
            int r22 = r30.ordinal()
            r4 = r21[r22]
            r14 = 2
            r13 = 4
            if (r4 == r6) goto L_0x00ad
            if (r4 == r14) goto L_0x00ad
            r14 = 3
            if (r4 == r14) goto L_0x00ad
            if (r4 == r13) goto L_0x00af
        L_0x00ad:
            r4 = 0
            goto L_0x00b3
        L_0x00af:
            if (r3 != r13) goto L_0x00b2
            goto L_0x00ad
        L_0x00b2:
            r4 = 1
        L_0x00b3:
            int r14 = r0.as
            r13 = 8
            if (r14 != r13) goto L_0x00bc
            r4 = 0
            r13 = 0
            goto L_0x00bf
        L_0x00bc:
            r13 = r4
            r4 = r35
        L_0x00bf:
            if (r45 == 0) goto L_0x00da
            if (r16 != 0) goto L_0x00cd
            if (r17 != 0) goto L_0x00cd
            if (r20 != 0) goto L_0x00cd
            r14 = r34
            r10.a((androidx.constraintlayout.a.h) r15, (int) r14)
            goto L_0x00da
        L_0x00cd:
            if (r16 == 0) goto L_0x00da
            if (r17 != 0) goto L_0x00da
            int r14 = r32.e()
            r6 = 6
            r10.c(r15, r8, r14, r6)
            goto L_0x00db
        L_0x00da:
            r6 = 6
        L_0x00db:
            if (r13 != 0) goto L_0x0109
            if (r31 == 0) goto L_0x00f6
            r6 = 0
            r14 = 3
            r10.c(r9, r15, r6, r14)
            if (r1 <= 0) goto L_0x00eb
            r4 = 6
            r10.a((androidx.constraintlayout.a.h) r9, (androidx.constraintlayout.a.h) r15, (int) r1, (int) r4)
            goto L_0x00ec
        L_0x00eb:
            r4 = 6
        L_0x00ec:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r6) goto L_0x00f4
            r10.b(r9, r15, r2, r4)
        L_0x00f4:
            r6 = 6
            goto L_0x00fa
        L_0x00f6:
            r14 = 3
            r10.c(r9, r15, r4, r6)
        L_0x00fa:
            r14 = r43
            r31 = r3
            r0 = r5
            r24 = r7
            r23 = r8
            r1 = 0
            r2 = 2
            r3 = r42
            goto L_0x01f3
        L_0x0109:
            r14 = 3
            r2 = -2
            r14 = r42
            if (r14 != r2) goto L_0x0113
            r14 = r43
            r6 = r4
            goto L_0x0116
        L_0x0113:
            r6 = r14
            r14 = r43
        L_0x0116:
            if (r14 != r2) goto L_0x0119
            r14 = r4
        L_0x0119:
            if (r6 <= 0) goto L_0x0124
            r2 = 6
            r10.a((androidx.constraintlayout.a.h) r9, (androidx.constraintlayout.a.h) r15, (int) r6, (int) r2)
            int r4 = java.lang.Math.max(r4, r6)
            goto L_0x0125
        L_0x0124:
            r2 = 6
        L_0x0125:
            if (r14 <= 0) goto L_0x012e
            r10.b(r9, r15, r14, r2)
            int r4 = java.lang.Math.min(r4, r14)
        L_0x012e:
            r2 = 1
            if (r3 != r2) goto L_0x0159
            if (r27 == 0) goto L_0x0145
            r2 = 6
            r10.c(r9, r15, r4, r2)
            r31 = r3
            r0 = r5
            r24 = r7
            r23 = r8
            r35 = r13
            r1 = 0
            r8 = r4
            r13 = r6
            goto L_0x01d6
        L_0x0145:
            r2 = 6
            if (r40 == 0) goto L_0x0150
            r35 = r13
            r13 = 4
            r10.c(r9, r15, r4, r13)
            goto L_0x01cc
        L_0x0150:
            r35 = r13
            r2 = 1
            r13 = 4
            r10.c(r9, r15, r4, r2)
            goto L_0x01cc
        L_0x0159:
            r35 = r13
            r2 = 2
            r13 = 4
            if (r3 != r2) goto L_0x01cc
            androidx.constraintlayout.a.a.e$c r2 = r32.d()
            androidx.constraintlayout.a.a.e$c r13 = androidx.constraintlayout.a.a.e.c.TOP
            if (r2 == r13) goto L_0x018b
            androidx.constraintlayout.a.a.e$c r2 = r32.d()
            androidx.constraintlayout.a.a.e$c r13 = androidx.constraintlayout.a.a.e.c.BOTTOM
            if (r2 != r13) goto L_0x0170
            goto L_0x018b
        L_0x0170:
            androidx.constraintlayout.a.a.f r2 = r0.D
            androidx.constraintlayout.a.a.e$c r13 = androidx.constraintlayout.a.a.e.c.LEFT
            androidx.constraintlayout.a.a.e r2 = r2.a((androidx.constraintlayout.a.a.e.c) r13)
            androidx.constraintlayout.a.h r2 = r10.a((java.lang.Object) r2)
            androidx.constraintlayout.a.a.f r13 = r0.D
            r31 = r2
            androidx.constraintlayout.a.a.e$c r2 = androidx.constraintlayout.a.a.e.c.RIGHT
            androidx.constraintlayout.a.a.e r2 = r13.a((androidx.constraintlayout.a.a.e.c) r2)
            androidx.constraintlayout.a.h r2 = r10.a((java.lang.Object) r2)
            goto L_0x01a5
        L_0x018b:
            androidx.constraintlayout.a.a.f r2 = r0.D
            androidx.constraintlayout.a.a.e$c r13 = androidx.constraintlayout.a.a.e.c.TOP
            androidx.constraintlayout.a.a.e r2 = r2.a((androidx.constraintlayout.a.a.e.c) r13)
            androidx.constraintlayout.a.h r2 = r10.a((java.lang.Object) r2)
            androidx.constraintlayout.a.a.f r13 = r0.D
            r31 = r2
            androidx.constraintlayout.a.a.e$c r2 = androidx.constraintlayout.a.a.e.c.BOTTOM
            androidx.constraintlayout.a.a.e r2 = r13.a((androidx.constraintlayout.a.a.e.c) r2)
            androidx.constraintlayout.a.h r2 = r10.a((java.lang.Object) r2)
        L_0x01a5:
            r22 = r31
            r13 = r2
            androidx.constraintlayout.a.b r2 = r26.c()
            r18 = 1
            r21 = 6
            r0 = r3
            r3 = r9
            r31 = r0
            r23 = r8
            r0 = 6
            r8 = r4
            r4 = r15
            r0 = r5
            r1 = 0
            r5 = r13
            r13 = r6
            r6 = r22
            r24 = r7
            r7 = r44
            androidx.constraintlayout.a.b r2 = r2.a(r3, r4, r5, r6, r7)
            r10.a((androidx.constraintlayout.a.b) r2)
            r5 = 0
            goto L_0x01d8
        L_0x01cc:
            r31 = r3
            r0 = r5
            r13 = r6
            r24 = r7
            r23 = r8
            r1 = 0
            r8 = r4
        L_0x01d6:
            r5 = r35
        L_0x01d8:
            if (r5 == 0) goto L_0x01f0
            r2 = 2
            if (r0 == r2) goto L_0x01f1
            if (r39 != 0) goto L_0x01f1
            int r3 = java.lang.Math.max(r13, r8)
            if (r14 <= 0) goto L_0x01e9
            int r3 = java.lang.Math.min(r14, r3)
        L_0x01e9:
            r4 = 6
            r10.c(r9, r15, r3, r4)
            r3 = r13
            r13 = 0
            goto L_0x01f3
        L_0x01f0:
            r2 = 2
        L_0x01f1:
            r3 = r13
            r13 = r5
        L_0x01f3:
            if (r45 == 0) goto L_0x0331
            if (r40 == 0) goto L_0x01f9
            goto L_0x0331
        L_0x01f9:
            r0 = 5
            if (r16 != 0) goto L_0x0207
            if (r17 != 0) goto L_0x0207
            if (r20 != 0) goto L_0x0207
            if (r27 == 0) goto L_0x0326
            r10.a((androidx.constraintlayout.a.h) r12, (androidx.constraintlayout.a.h) r9, (int) r1, (int) r0)
            goto L_0x0326
        L_0x0207:
            if (r16 == 0) goto L_0x0212
            if (r17 != 0) goto L_0x0212
            if (r27 == 0) goto L_0x0326
            r10.a((androidx.constraintlayout.a.h) r12, (androidx.constraintlayout.a.h) r9, (int) r1, (int) r0)
            goto L_0x0326
        L_0x0212:
            if (r16 != 0) goto L_0x0228
            if (r17 == 0) goto L_0x0228
            int r2 = r33.e()
            int r2 = -r2
            r8 = r24
            r3 = 6
            r10.c(r9, r8, r2, r3)
            if (r27 == 0) goto L_0x0326
            r10.a((androidx.constraintlayout.a.h) r15, (androidx.constraintlayout.a.h) r11, (int) r1, (int) r0)
            goto L_0x0326
        L_0x0228:
            r8 = r24
            if (r16 == 0) goto L_0x0326
            if (r17 == 0) goto L_0x0326
            if (r13 == 0) goto L_0x029e
            if (r27 == 0) goto L_0x023a
            r7 = 0
            if (r36 != 0) goto L_0x023b
            r1 = 6
            r10.a((androidx.constraintlayout.a.h) r9, (androidx.constraintlayout.a.h) r15, (int) r7, (int) r1)
            goto L_0x023b
        L_0x023a:
            r7 = 0
        L_0x023b:
            if (r31 != 0) goto L_0x0265
            if (r14 > 0) goto L_0x0245
            if (r3 <= 0) goto L_0x0242
            goto L_0x0245
        L_0x0242:
            r1 = 6
            r6 = 0
            goto L_0x0247
        L_0x0245:
            r1 = 4
            r6 = 1
        L_0x0247:
            int r2 = r32.e()
            r5 = r23
            r10.c(r15, r5, r2, r1)
            int r2 = r33.e()
            int r2 = -r2
            r10.c(r9, r8, r2, r1)
            if (r14 > 0) goto L_0x025f
            if (r3 <= 0) goto L_0x025d
            goto L_0x025f
        L_0x025d:
            r1 = 0
            goto L_0x0260
        L_0x025f:
            r1 = 1
        L_0x0260:
            r16 = r6
            r6 = 1
            r14 = 5
            goto L_0x0270
        L_0x0265:
            r4 = r31
            r5 = r23
            r6 = 1
            if (r4 != r6) goto L_0x0273
            r1 = 1
            r14 = 6
            r16 = 1
        L_0x0270:
            r4 = r25
            goto L_0x02a8
        L_0x0273:
            r1 = 3
            if (r4 != r1) goto L_0x029a
            if (r39 != 0) goto L_0x0283
            r4 = r25
            int r1 = r4.p
            r2 = -1
            if (r1 == r2) goto L_0x0285
            if (r14 > 0) goto L_0x0285
            r1 = 6
            goto L_0x0286
        L_0x0283:
            r4 = r25
        L_0x0285:
            r1 = 4
        L_0x0286:
            int r2 = r32.e()
            r10.c(r15, r5, r2, r1)
            int r2 = r33.e()
            int r2 = -r2
            r10.c(r9, r8, r2, r1)
            r1 = 1
            r14 = 5
            r16 = 1
            goto L_0x02a8
        L_0x029a:
            r4 = r25
            r1 = 0
            goto L_0x02a5
        L_0x029e:
            r5 = r23
            r6 = 1
            r7 = 0
            r4 = r25
            r1 = 1
        L_0x02a5:
            r14 = 5
            r16 = 0
        L_0x02a8:
            if (r1 == 0) goto L_0x02ed
            int r17 = r32.e()
            int r18 = r33.e()
            r1 = r26
            r2 = r15
            r3 = r5
            r4 = r17
            r17 = r5
            r5 = r38
            r19 = 1
            r6 = r8
            r0 = 0
            r7 = r9
            r12 = r8
            r0 = r17
            r8 = r18
            r11 = r9
            r9 = r14
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r32
            androidx.constraintlayout.a.a.e r2 = r1.f1379c
            androidx.constraintlayout.a.a.f r2 = r2.f1377a
            boolean r2 = r2 instanceof androidx.constraintlayout.a.a.b
            r3 = r33
            androidx.constraintlayout.a.a.e r4 = r3.f1379c
            androidx.constraintlayout.a.a.f r4 = r4.f1377a
            boolean r4 = r4 instanceof androidx.constraintlayout.a.a.b
            if (r2 == 0) goto L_0x02e5
            if (r4 != 0) goto L_0x02e5
            r19 = r27
            r2 = 1
            r4 = 5
            r5 = 6
            goto L_0x02fa
        L_0x02e5:
            if (r2 != 0) goto L_0x02f4
            if (r4 == 0) goto L_0x02f4
            r2 = r27
            r4 = 6
            goto L_0x02f9
        L_0x02ed:
            r1 = r32
            r3 = r33
            r0 = r5
            r12 = r8
            r11 = r9
        L_0x02f4:
            r2 = r27
            r19 = r2
            r4 = 5
        L_0x02f9:
            r5 = 5
        L_0x02fa:
            if (r16 == 0) goto L_0x02fe
            r4 = 6
            r5 = 6
        L_0x02fe:
            if (r13 != 0) goto L_0x0302
            if (r19 != 0) goto L_0x0304
        L_0x0302:
            if (r16 == 0) goto L_0x030b
        L_0x0304:
            int r1 = r32.e()
            r10.a((androidx.constraintlayout.a.h) r15, (androidx.constraintlayout.a.h) r0, (int) r1, (int) r4)
        L_0x030b:
            if (r13 != 0) goto L_0x030f
            if (r2 != 0) goto L_0x0311
        L_0x030f:
            if (r16 == 0) goto L_0x0319
        L_0x0311:
            int r0 = r33.e()
            int r0 = -r0
            r10.b(r11, r12, r0, r5)
        L_0x0319:
            if (r27 == 0) goto L_0x0324
            r0 = r28
            r1 = r11
            r2 = 6
            r3 = 0
            r10.a((androidx.constraintlayout.a.h) r15, (androidx.constraintlayout.a.h) r0, (int) r3, (int) r2)
            goto L_0x0329
        L_0x0324:
            r1 = r11
            goto L_0x0327
        L_0x0326:
            r1 = r9
        L_0x0327:
            r2 = 6
            r3 = 0
        L_0x0329:
            if (r27 == 0) goto L_0x0330
            r4 = r29
            r10.a((androidx.constraintlayout.a.h) r4, (androidx.constraintlayout.a.h) r1, (int) r3, (int) r2)
        L_0x0330:
            return
        L_0x0331:
            r5 = r0
            r1 = r9
            r0 = r11
            r4 = r12
            r2 = 6
            r3 = 0
            r6 = 2
            if (r5 >= r6) goto L_0x0342
            if (r27 == 0) goto L_0x0342
            r10.a((androidx.constraintlayout.a.h) r15, (androidx.constraintlayout.a.h) r0, (int) r3, (int) r2)
            r10.a((androidx.constraintlayout.a.h) r4, (androidx.constraintlayout.a.h) r1, (int) r3, (int) r2)
        L_0x0342:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.a(androidx.constraintlayout.a.e, boolean, androidx.constraintlayout.a.h, androidx.constraintlayout.a.h, androidx.constraintlayout.a.a.f$a, boolean, androidx.constraintlayout.a.a.e, androidx.constraintlayout.a.a.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.a.a.f$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1393b = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            /*
                androidx.constraintlayout.a.a.f$a[] r0 = androidx.constraintlayout.a.a.f.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1393b = r0
                r0 = 1
                int[] r1 = f1393b     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.a.a.f$a r2 = androidx.constraintlayout.a.a.f.a.FIXED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f1393b     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.a.a.f$a r3 = androidx.constraintlayout.a.a.f.a.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f1393b     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.a.a.f$a r4 = androidx.constraintlayout.a.a.f.a.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f1393b     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.constraintlayout.a.a.f$a r5 = androidx.constraintlayout.a.a.f.a.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                androidx.constraintlayout.a.a.e$c[] r4 = androidx.constraintlayout.a.a.e.c.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f1392a = r4
                int[] r4 = f1392a     // Catch:{ NoSuchFieldError -> 0x0048 }
                androidx.constraintlayout.a.a.e$c r5 = androidx.constraintlayout.a.a.e.c.LEFT     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x0052 }
                androidx.constraintlayout.a.a.e$c r4 = androidx.constraintlayout.a.a.e.c.TOP     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x005c }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.RIGHT     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x0066 }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x0071 }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.BASELINE     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x007c }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.CENTER     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x0087 }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x0093 }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r0 = f1392a     // Catch:{ NoSuchFieldError -> 0x009f }
                androidx.constraintlayout.a.a.e$c r1 = androidx.constraintlayout.a.a.e.c.NONE     // Catch:{ NoSuchFieldError -> 0x009f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.f.AnonymousClass1.<clinit>():void");
        }
    }

    public void c(androidx.constraintlayout.a.e eVar) {
        int b2 = eVar.b((Object) this.s);
        int b3 = eVar.b((Object) this.t);
        int b4 = eVar.b((Object) this.u);
        int b5 = eVar.b((Object) this.v);
        int i2 = b5 - b3;
        if (b4 - b2 < 0 || i2 < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }
}
