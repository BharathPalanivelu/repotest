package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import java.util.ArrayList;

public class q extends f {
    protected ArrayList<f> az = new ArrayList<>();

    public void g() {
        this.az.clear();
        super.g();
    }

    public void b(f fVar) {
        this.az.add(fVar);
        if (fVar.l() != null) {
            ((q) fVar.l()).c(fVar);
        }
        fVar.a((f) this);
    }

    public void c(f fVar) {
        this.az.remove(fVar);
        fVar.a((f) null);
    }

    public g T() {
        f l = l();
        g gVar = this instanceof g ? (g) this : null;
        while (l != null) {
            f l2 = l.l();
            if (l instanceof g) {
                gVar = (g) l;
            }
            l = l2;
        }
        return gVar;
    }

    public void b(int i, int i2) {
        super.b(i, i2);
        int size = this.az.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.az.get(i3).b(w(), x());
        }
    }

    public void E() {
        super.E();
        ArrayList<f> arrayList = this.az;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.az.get(i);
                fVar.b(u(), v());
                if (!(fVar instanceof g)) {
                    fVar.E();
                }
            }
        }
    }

    public void N() {
        E();
        ArrayList<f> arrayList = this.az;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.az.get(i);
                if (fVar instanceof q) {
                    ((q) fVar).N();
                }
            }
        }
    }

    public void a(c cVar) {
        super.a(cVar);
        int size = this.az.size();
        for (int i = 0; i < size; i++) {
            this.az.get(i).a(cVar);
        }
    }

    public void U() {
        this.az.clear();
    }
}
