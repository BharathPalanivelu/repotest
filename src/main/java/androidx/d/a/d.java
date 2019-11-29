package androidx.d.a;

import androidx.d.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class d extends b<d> {
    private e w = null;
    private float x = Float.MAX_VALUE;
    private boolean y = false;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
    }

    public d a(e eVar) {
        this.w = eVar;
        return this;
    }

    public void a() {
        d();
        this.w.a((double) c());
        super.a();
    }

    private void d() {
        e eVar = this.w;
        if (eVar != null) {
            double a2 = (double) eVar.a();
            if (a2 > ((double) this.u)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a2 < ((double) this.v)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(long j) {
        if (this.y) {
            float f2 = this.x;
            if (f2 != Float.MAX_VALUE) {
                this.w.c(f2);
                this.x = Float.MAX_VALUE;
            }
            this.p = this.w.a();
            this.o = BitmapDescriptorFactory.HUE_RED;
            this.y = false;
            return true;
        }
        if (this.x != Float.MAX_VALUE) {
            this.w.a();
            long j2 = j / 2;
            b.a a2 = this.w.a((double) this.p, (double) this.o, j2);
            this.w.c(this.x);
            this.x = Float.MAX_VALUE;
            b.a a3 = this.w.a((double) a2.f1961a, (double) a2.f1962b, j2);
            this.p = a3.f1961a;
            this.o = a3.f1962b;
        } else {
            b.a a4 = this.w.a((double) this.p, (double) this.o, j);
            this.p = a4.f1961a;
            this.o = a4.f1962b;
        }
        this.p = Math.max(this.p, this.v);
        this.p = Math.min(this.p, this.u);
        if (!a(this.p, this.o)) {
            return false;
        }
        this.p = this.w.a();
        this.o = BitmapDescriptorFactory.HUE_RED;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, float f3) {
        return this.w.a(f2, f3);
    }
}
