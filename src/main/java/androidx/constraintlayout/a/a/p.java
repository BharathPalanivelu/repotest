package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import java.util.ArrayList;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f1411a;

    /* renamed from: b  reason: collision with root package name */
    private int f1412b;

    /* renamed from: c  reason: collision with root package name */
    private int f1413c;

    /* renamed from: d  reason: collision with root package name */
    private int f1414d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<a> f1415e = new ArrayList<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f1416a;

        /* renamed from: b  reason: collision with root package name */
        private e f1417b;

        /* renamed from: c  reason: collision with root package name */
        private int f1418c;

        /* renamed from: d  reason: collision with root package name */
        private e.b f1419d;

        /* renamed from: e  reason: collision with root package name */
        private int f1420e;

        public a(e eVar) {
            this.f1416a = eVar;
            this.f1417b = eVar.g();
            this.f1418c = eVar.e();
            this.f1419d = eVar.f();
            this.f1420e = eVar.h();
        }

        public void a(f fVar) {
            this.f1416a = fVar.a(this.f1416a.d());
            e eVar = this.f1416a;
            if (eVar != null) {
                this.f1417b = eVar.g();
                this.f1418c = this.f1416a.e();
                this.f1419d = this.f1416a.f();
                this.f1420e = this.f1416a.h();
                return;
            }
            this.f1417b = null;
            this.f1418c = 0;
            this.f1419d = e.b.STRONG;
            this.f1420e = 0;
        }

        public void b(f fVar) {
            fVar.a(this.f1416a.d()).a(this.f1417b, this.f1418c, this.f1419d, this.f1420e);
        }
    }

    public p(f fVar) {
        this.f1411a = fVar.o();
        this.f1412b = fVar.p();
        this.f1413c = fVar.q();
        this.f1414d = fVar.s();
        ArrayList<e> D = fVar.D();
        int size = D.size();
        for (int i = 0; i < size; i++) {
            this.f1415e.add(new a(D.get(i)));
        }
    }

    public void a(f fVar) {
        this.f1411a = fVar.o();
        this.f1412b = fVar.p();
        this.f1413c = fVar.q();
        this.f1414d = fVar.s();
        int size = this.f1415e.size();
        for (int i = 0; i < size; i++) {
            this.f1415e.get(i).a(fVar);
        }
    }

    public void b(f fVar) {
        fVar.h(this.f1411a);
        fVar.i(this.f1412b);
        fVar.j(this.f1413c);
        fVar.k(this.f1414d);
        int size = this.f1415e.size();
        for (int i = 0; i < size; i++) {
            this.f1415e.get(i).b(fVar);
        }
    }
}
