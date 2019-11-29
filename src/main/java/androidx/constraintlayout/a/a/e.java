package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;

public class e {

    /* renamed from: a  reason: collision with root package name */
    final f f1377a;

    /* renamed from: b  reason: collision with root package name */
    final c f1378b;

    /* renamed from: c  reason: collision with root package name */
    e f1379c;

    /* renamed from: d  reason: collision with root package name */
    public int f1380d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f1381e = -1;

    /* renamed from: f  reason: collision with root package name */
    h f1382f;

    /* renamed from: g  reason: collision with root package name */
    private m f1383g = new m(this);
    private b h = b.NONE;
    private a i = a.RELAXED;
    private int j = 0;

    public enum a {
        RELAXED,
        STRICT
    }

    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public m a() {
        return this.f1383g;
    }

    public e(f fVar, c cVar) {
        this.f1377a = fVar;
        this.f1378b = cVar;
    }

    public h b() {
        return this.f1382f;
    }

    public void a(androidx.constraintlayout.a.c cVar) {
        h hVar = this.f1382f;
        if (hVar == null) {
            this.f1382f = new h(h.a.UNRESTRICTED, (String) null);
        } else {
            hVar.b();
        }
    }

    public f c() {
        return this.f1377a;
    }

    public c d() {
        return this.f1378b;
    }

    public int e() {
        if (this.f1377a.m() == 8) {
            return 0;
        }
        if (this.f1381e > -1) {
            e eVar = this.f1379c;
            if (eVar != null && eVar.f1377a.m() == 8) {
                return this.f1381e;
            }
        }
        return this.f1380d;
    }

    public b f() {
        return this.h;
    }

    public e g() {
        return this.f1379c;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.f1379c = null;
        this.f1380d = 0;
        this.f1381e = -1;
        this.h = b.STRONG;
        this.j = 0;
        this.i = a.RELAXED;
        this.f1383g.b();
    }

    public boolean a(e eVar, int i2, b bVar, int i3) {
        return a(eVar, i2, -1, bVar, i3, false);
    }

    public boolean a(e eVar, int i2, int i3, b bVar, int i4, boolean z) {
        if (eVar == null) {
            this.f1379c = null;
            this.f1380d = 0;
            this.f1381e = -1;
            this.h = b.NONE;
            this.j = 2;
            return true;
        } else if (!z && !a(eVar)) {
            return false;
        } else {
            this.f1379c = eVar;
            if (i2 > 0) {
                this.f1380d = i2;
            } else {
                this.f1380d = 0;
            }
            this.f1381e = i3;
            this.h = bVar;
            this.j = i4;
            return true;
        }
    }

    public boolean j() {
        return this.f1379c != null;
    }

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        c d2 = eVar.d();
        c cVar = this.f1378b;
        if (d2 != cVar) {
            switch (this.f1378b) {
                case CENTER:
                    if (d2 == c.BASELINE || d2 == c.CENTER_X || d2 == c.CENTER_Y) {
                        return false;
                    }
                    return true;
                case LEFT:
                case RIGHT:
                    boolean z = d2 == c.LEFT || d2 == c.RIGHT;
                    if (eVar.c() instanceof i) {
                        return z || d2 == c.CENTER_X;
                    }
                    return z;
                case TOP:
                case BOTTOM:
                    boolean z2 = d2 == c.TOP || d2 == c.BOTTOM;
                    if (eVar.c() instanceof i) {
                        return z2 || d2 == c.CENTER_Y;
                    }
                    return z2;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.f1378b.name());
            }
        } else if (cVar != c.BASELINE || (eVar.c().A() && c().A())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.f1377a.n() + ":" + this.f1378b.toString();
    }
}
