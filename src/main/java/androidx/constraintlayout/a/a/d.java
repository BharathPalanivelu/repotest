package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected f f1370a;

    /* renamed from: b  reason: collision with root package name */
    protected f f1371b;

    /* renamed from: c  reason: collision with root package name */
    protected f f1372c;

    /* renamed from: d  reason: collision with root package name */
    protected f f1373d;

    /* renamed from: e  reason: collision with root package name */
    protected f f1374e;

    /* renamed from: f  reason: collision with root package name */
    protected f f1375f;

    /* renamed from: g  reason: collision with root package name */
    protected f f1376g;
    protected ArrayList<f> h;
    protected int i;
    protected int j;
    protected float k = BitmapDescriptorFactory.HUE_RED;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    private int o;
    private boolean p = false;
    private boolean q;

    public d(f fVar, int i2, boolean z) {
        this.f1370a = fVar;
        this.o = i2;
        this.p = z;
    }

    private static boolean a(f fVar, int i2) {
        return fVar.m() != 8 && fVar.C[i2] == f.a.MATCH_CONSTRAINT && (fVar.f1391g[i2] == 0 || fVar.f1391g[i2] == 3);
    }

    private void b() {
        int i2 = this.o * 2;
        boolean z = false;
        f fVar = this.f1370a;
        f fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            f fVar3 = null;
            fVar.af[this.o] = null;
            fVar.ae[this.o] = null;
            if (fVar.m() != 8) {
                if (this.f1371b == null) {
                    this.f1371b = fVar;
                }
                this.f1373d = fVar;
                if (fVar.C[this.o] == f.a.MATCH_CONSTRAINT && (fVar.f1391g[this.o] == 0 || fVar.f1391g[this.o] == 3 || fVar.f1391g[this.o] == 2)) {
                    this.j++;
                    float f2 = fVar.ad[this.o];
                    if (f2 > BitmapDescriptorFactory.HUE_RED) {
                        this.k += fVar.ad[this.o];
                    }
                    if (a(fVar, this.o)) {
                        if (f2 < BitmapDescriptorFactory.HUE_RED) {
                            this.l = true;
                        } else {
                            this.m = true;
                        }
                        if (this.h == null) {
                            this.h = new ArrayList<>();
                        }
                        this.h.add(fVar);
                    }
                    if (this.f1375f == null) {
                        this.f1375f = fVar;
                    }
                    f fVar4 = this.f1376g;
                    if (fVar4 != null) {
                        fVar4.ae[this.o] = fVar;
                    }
                    this.f1376g = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.af[this.o] = fVar;
            }
            e eVar = fVar.A[i2 + 1].f1379c;
            if (eVar != null) {
                f fVar5 = eVar.f1377a;
                if (fVar5.A[i2].f1379c != null && fVar5.A[i2].f1379c.f1377a == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f1372c = fVar;
        if (this.o != 0 || !this.p) {
            this.f1374e = this.f1370a;
        } else {
            this.f1374e = this.f1372c;
        }
        if (this.m && this.l) {
            z = true;
        }
        this.n = z;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
