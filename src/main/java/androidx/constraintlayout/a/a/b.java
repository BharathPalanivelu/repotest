package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

public class b extends j {
    private int ak = 0;
    private ArrayList<m> al = new ArrayList<>(4);
    private boolean am = true;

    public boolean a() {
        return true;
    }

    public void a(int i) {
        this.ak = i;
    }

    public void a(boolean z) {
        this.am = z;
    }

    public boolean b() {
        return this.am;
    }

    public void c() {
        super.c();
        this.al.clear();
    }

    public void b(int i) {
        m mVar;
        m mVar2;
        if (this.D != null && ((g) this.D).u(2)) {
            int i2 = this.ak;
            if (i2 == 0) {
                mVar = this.s.a();
            } else if (i2 == 1) {
                mVar = this.u.a();
            } else if (i2 == 2) {
                mVar = this.t.a();
            } else if (i2 == 3) {
                mVar = this.v.a();
            } else {
                return;
            }
            mVar.b(5);
            int i3 = this.ak;
            if (i3 == 0 || i3 == 1) {
                this.t.a().a((m) null, (float) BitmapDescriptorFactory.HUE_RED);
                this.v.a().a((m) null, (float) BitmapDescriptorFactory.HUE_RED);
            } else {
                this.s.a().a((m) null, (float) BitmapDescriptorFactory.HUE_RED);
                this.u.a().a((m) null, (float) BitmapDescriptorFactory.HUE_RED);
            }
            this.al.clear();
            for (int i4 = 0; i4 < this.aj; i4++) {
                f fVar = this.ai[i4];
                if (this.am || fVar.a()) {
                    int i5 = this.ak;
                    if (i5 == 0) {
                        mVar2 = fVar.s.a();
                    } else if (i5 == 1) {
                        mVar2 = fVar.u.a();
                    } else if (i5 != 2) {
                        mVar2 = i5 != 3 ? null : fVar.v.a();
                    } else {
                        mVar2 = fVar.t.a();
                    }
                    if (mVar2 != null) {
                        this.al.add(mVar2);
                        mVar2.a(mVar);
                    }
                }
            }
        }
    }

    public void d() {
        m mVar;
        int i = this.ak;
        float f2 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                mVar = this.u.a();
            } else if (i == 2) {
                mVar = this.t.a();
            } else if (i == 3) {
                mVar = this.v.a();
            } else {
                return;
            }
            f2 = BitmapDescriptorFactory.HUE_RED;
        } else {
            mVar = this.s.a();
        }
        int size = this.al.size();
        m mVar2 = null;
        int i2 = 0;
        while (i2 < size) {
            m mVar3 = this.al.get(i2);
            if (mVar3.i == 1) {
                int i3 = this.ak;
                if (i3 == 0 || i3 == 2) {
                    if (mVar3.f1408f < f2) {
                        f2 = mVar3.f1408f;
                        mVar2 = mVar3.f1407e;
                    }
                } else if (mVar3.f1408f > f2) {
                    f2 = mVar3.f1408f;
                    mVar2 = mVar3.f1407e;
                }
                i2++;
            } else {
                return;
            }
        }
        if (e.a() != null) {
            e.a().z++;
        }
        mVar.f1407e = mVar2;
        mVar.f1408f = f2;
        mVar.f();
        int i4 = this.ak;
        if (i4 == 0) {
            this.u.a().a(mVar2, f2);
        } else if (i4 == 1) {
            this.s.a().a(mVar2, f2);
        } else if (i4 == 2) {
            this.v.a().a(mVar2, f2);
        } else if (i4 == 3) {
            this.t.a().a(mVar2, f2);
        }
    }

    public void a(e eVar) {
        boolean z;
        this.A[0] = this.s;
        this.A[2] = this.t;
        this.A[1] = this.u;
        this.A[3] = this.v;
        for (int i = 0; i < this.A.length; i++) {
            this.A[i].f1382f = eVar.a((Object) this.A[i]);
        }
        int i2 = this.ak;
        if (i2 >= 0 && i2 < 4) {
            e eVar2 = this.A[this.ak];
            int i3 = 0;
            while (true) {
                if (i3 >= this.aj) {
                    z = false;
                    break;
                }
                f fVar = this.ai[i3];
                if (this.am || fVar.a()) {
                    int i4 = this.ak;
                    if ((i4 != 0 && i4 != 1) || fVar.G() != f.a.MATCH_CONSTRAINT) {
                        int i5 = this.ak;
                        if ((i5 == 2 || i5 == 3) && fVar.H() == f.a.MATCH_CONSTRAINT) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            z = true;
            int i6 = this.ak;
            if (i6 == 0 || i6 == 1 ? l().G() == f.a.WRAP_CONTENT : l().H() == f.a.WRAP_CONTENT) {
                z = false;
            }
            for (int i7 = 0; i7 < this.aj; i7++) {
                f fVar2 = this.ai[i7];
                if (this.am || fVar2.a()) {
                    h a2 = eVar.a((Object) fVar2.A[this.ak]);
                    e[] eVarArr = fVar2.A;
                    int i8 = this.ak;
                    eVarArr[i8].f1382f = a2;
                    if (i8 == 0 || i8 == 2) {
                        eVar.b(eVar2.f1382f, a2, z);
                    } else {
                        eVar.a(eVar2.f1382f, a2, z);
                    }
                }
            }
            int i9 = this.ak;
            if (i9 == 0) {
                eVar.c(this.u.f1382f, this.s.f1382f, 0, 6);
                if (!z) {
                    eVar.c(this.s.f1382f, this.D.u.f1382f, 0, 5);
                }
            } else if (i9 == 1) {
                eVar.c(this.s.f1382f, this.u.f1382f, 0, 6);
                if (!z) {
                    eVar.c(this.s.f1382f, this.D.s.f1382f, 0, 5);
                }
            } else if (i9 == 2) {
                eVar.c(this.v.f1382f, this.t.f1382f, 0, 6);
                if (!z) {
                    eVar.c(this.t.f1382f, this.D.v.f1382f, 0, 5);
                }
            } else if (i9 == 3) {
                eVar.c(this.t.f1382f, this.v.f1382f, 0, 6);
                if (!z) {
                    eVar.c(this.t.f1382f, this.D.t.f1382f, 0, 5);
                }
            }
        }
    }
}
