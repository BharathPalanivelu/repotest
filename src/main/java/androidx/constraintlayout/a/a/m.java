package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class m extends o {

    /* renamed from: a  reason: collision with root package name */
    e f1403a;

    /* renamed from: b  reason: collision with root package name */
    float f1404b;

    /* renamed from: c  reason: collision with root package name */
    m f1405c;

    /* renamed from: d  reason: collision with root package name */
    float f1406d;

    /* renamed from: e  reason: collision with root package name */
    m f1407e;

    /* renamed from: f  reason: collision with root package name */
    float f1408f;

    /* renamed from: g  reason: collision with root package name */
    int f1409g = 0;
    private m j;
    private float k;
    private n l = null;
    private int m = 1;
    private n n = null;
    private int o = 1;

    /* access modifiers changed from: package-private */
    public String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public m(e eVar) {
        this.f1403a = eVar;
    }

    public String toString() {
        if (this.i != 1) {
            return "{ " + this.f1403a + " UNRESOLVED} type: " + a(this.f1409g);
        } else if (this.f1407e == this) {
            return "[" + this.f1403a + ", RESOLVED: " + this.f1408f + "]  type: " + a(this.f1409g);
        } else {
            return "[" + this.f1403a + ", RESOLVED: " + this.f1407e + ":" + this.f1408f + "] type: " + a(this.f1409g);
        }
    }

    public void a(m mVar, float f2) {
        if (this.i == 0 || !(this.f1407e == mVar || this.f1408f == f2)) {
            this.f1407e = mVar;
            this.f1408f = f2;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    public void a() {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z = true;
        if (this.i != 1 && this.f1409g != 4) {
            n nVar = this.l;
            if (nVar != null) {
                if (nVar.i == 1) {
                    this.f1406d = ((float) this.m) * this.l.f1410a;
                } else {
                    return;
                }
            }
            n nVar2 = this.n;
            if (nVar2 != null) {
                if (nVar2.i == 1) {
                    this.k = ((float) this.o) * this.n.f1410a;
                } else {
                    return;
                }
            }
            if (this.f1409g == 1) {
                m mVar = this.f1405c;
                if (mVar == null || mVar.i == 1) {
                    m mVar2 = this.f1405c;
                    if (mVar2 == null) {
                        this.f1407e = this;
                        this.f1408f = this.f1406d;
                    } else {
                        this.f1407e = mVar2.f1407e;
                        this.f1408f = mVar2.f1408f + this.f1406d;
                    }
                    f();
                    return;
                }
            }
            if (this.f1409g == 2) {
                m mVar3 = this.f1405c;
                if (mVar3 != null && mVar3.i == 1) {
                    m mVar4 = this.j;
                    if (mVar4 != null) {
                        m mVar5 = mVar4.f1405c;
                        if (mVar5 != null && mVar5.i == 1) {
                            if (e.a() != null) {
                                e.a().w++;
                            }
                            this.f1407e = this.f1405c.f1407e;
                            m mVar6 = this.j;
                            mVar6.f1407e = mVar6.f1405c.f1407e;
                            int i = 0;
                            if (!(this.f1403a.f1378b == e.c.RIGHT || this.f1403a.f1378b == e.c.BOTTOM)) {
                                z = false;
                            }
                            if (z) {
                                f3 = this.f1405c.f1408f;
                                f2 = this.j.f1405c.f1408f;
                            } else {
                                f3 = this.j.f1405c.f1408f;
                                f2 = this.f1405c.f1408f;
                            }
                            float f6 = f3 - f2;
                            if (this.f1403a.f1378b == e.c.LEFT || this.f1403a.f1378b == e.c.RIGHT) {
                                f5 = f6 - ((float) this.f1403a.f1377a.q());
                                f4 = this.f1403a.f1377a.S;
                            } else {
                                f5 = f6 - ((float) this.f1403a.f1377a.s());
                                f4 = this.f1403a.f1377a.T;
                            }
                            int e2 = this.f1403a.e();
                            int e3 = this.j.f1403a.e();
                            if (this.f1403a.g() == this.j.f1403a.g()) {
                                f4 = 0.5f;
                                e3 = 0;
                            } else {
                                i = e2;
                            }
                            float f7 = (float) i;
                            float f8 = (float) e3;
                            float f9 = (f5 - f7) - f8;
                            if (z) {
                                m mVar7 = this.j;
                                mVar7.f1408f = mVar7.f1405c.f1408f + f8 + (f9 * f4);
                                this.f1408f = (this.f1405c.f1408f - f7) - (f9 * (1.0f - f4));
                            } else {
                                this.f1408f = this.f1405c.f1408f + f7 + (f9 * f4);
                                m mVar8 = this.j;
                                mVar8.f1408f = (mVar8.f1405c.f1408f - f8) - (f9 * (1.0f - f4));
                            }
                            f();
                            this.j.f();
                            return;
                        }
                    }
                }
            }
            if (this.f1409g == 3) {
                m mVar9 = this.f1405c;
                if (mVar9 != null && mVar9.i == 1) {
                    m mVar10 = this.j;
                    if (mVar10 != null) {
                        m mVar11 = mVar10.f1405c;
                        if (mVar11 != null && mVar11.i == 1) {
                            if (androidx.constraintlayout.a.e.a() != null) {
                                androidx.constraintlayout.a.e.a().x++;
                            }
                            m mVar12 = this.f1405c;
                            this.f1407e = mVar12.f1407e;
                            m mVar13 = this.j;
                            m mVar14 = mVar13.f1405c;
                            mVar13.f1407e = mVar14.f1407e;
                            this.f1408f = mVar12.f1408f + this.f1406d;
                            mVar13.f1408f = mVar14.f1408f + mVar13.f1406d;
                            f();
                            this.j.f();
                            return;
                        }
                    }
                }
            }
            if (this.f1409g == 5) {
                this.f1403a.f1377a.d();
            }
        }
    }

    public void b(int i) {
        this.f1409g = i;
    }

    public void b() {
        super.b();
        this.f1405c = null;
        this.f1406d = BitmapDescriptorFactory.HUE_RED;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.f1407e = null;
        this.f1408f = BitmapDescriptorFactory.HUE_RED;
        this.f1404b = BitmapDescriptorFactory.HUE_RED;
        this.j = null;
        this.k = BitmapDescriptorFactory.HUE_RED;
        this.f1409g = 0;
    }

    public void c() {
        e g2 = this.f1403a.g();
        if (g2 != null) {
            if (g2.g() == this.f1403a) {
                this.f1409g = 4;
                g2.a().f1409g = 4;
            }
            int e2 = this.f1403a.e();
            if (this.f1403a.f1378b == e.c.RIGHT || this.f1403a.f1378b == e.c.BOTTOM) {
                e2 = -e2;
            }
            a(g2.a(), e2);
        }
    }

    public void a(int i, m mVar, int i2) {
        this.f1409g = i;
        this.f1405c = mVar;
        this.f1406d = (float) i2;
        this.f1405c.a(this);
    }

    public void a(m mVar, int i) {
        this.f1405c = mVar;
        this.f1406d = (float) i;
        this.f1405c.a(this);
    }

    public void a(m mVar, int i, n nVar) {
        this.f1405c = mVar;
        this.f1405c.a(this);
        this.l = nVar;
        this.m = i;
        this.l.a(this);
    }

    public void b(m mVar, float f2) {
        this.j = mVar;
        this.k = f2;
    }

    public void b(m mVar, int i, n nVar) {
        this.j = mVar;
        this.n = nVar;
        this.o = i;
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.constraintlayout.a.e eVar) {
        h b2 = this.f1403a.b();
        m mVar = this.f1407e;
        if (mVar == null) {
            eVar.a(b2, (int) (this.f1408f + 0.5f));
        } else {
            eVar.c(b2, eVar.a((Object) mVar.f1403a), (int) (this.f1408f + 0.5f), 6);
        }
    }

    public float d() {
        return this.f1408f;
    }
}
