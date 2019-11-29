package com.c.a.g;

public final class a implements c, d {

    /* renamed from: a  reason: collision with root package name */
    private final d f6179a;

    /* renamed from: b  reason: collision with root package name */
    private c f6180b;

    /* renamed from: c  reason: collision with root package name */
    private c f6181c;

    public a(d dVar) {
        this.f6179a = dVar;
    }

    public void a(c cVar, c cVar2) {
        this.f6180b = cVar;
        this.f6181c = cVar2;
    }

    public void a() {
        if (!this.f6180b.d()) {
            this.f6180b.a();
        }
    }

    public void b() {
        if (!this.f6180b.h()) {
            this.f6180b.b();
        }
        if (this.f6181c.d()) {
            this.f6181c.b();
        }
    }

    public void c() {
        if (this.f6180b.h()) {
            this.f6181c.c();
        } else {
            this.f6180b.c();
        }
    }

    public boolean d() {
        return (this.f6180b.h() ? this.f6181c : this.f6180b).d();
    }

    public boolean e() {
        return (this.f6180b.h() ? this.f6181c : this.f6180b).e();
    }

    public boolean f() {
        return (this.f6180b.h() ? this.f6181c : this.f6180b).f();
    }

    public boolean g() {
        return (this.f6180b.h() ? this.f6181c : this.f6180b).g();
    }

    public boolean h() {
        return this.f6180b.h() && this.f6181c.h();
    }

    public void i() {
        this.f6180b.i();
        this.f6181c.i();
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof a)) {
            return false;
        }
        a aVar = (a) cVar;
        if (!this.f6180b.a(aVar.f6180b) || !this.f6181c.a(aVar.f6181c)) {
            return false;
        }
        return true;
    }

    public boolean b(c cVar) {
        return k() && f(cVar);
    }

    private boolean k() {
        d dVar = this.f6179a;
        return dVar == null || dVar.b(this);
    }

    public boolean c(c cVar) {
        return l() && f(cVar);
    }

    private boolean l() {
        d dVar = this.f6179a;
        return dVar == null || dVar.c(this);
    }

    private boolean f(c cVar) {
        return cVar.equals(this.f6180b) || (this.f6180b.h() && cVar.equals(this.f6181c));
    }

    public boolean j() {
        return m() || f();
    }

    private boolean m() {
        d dVar = this.f6179a;
        return dVar != null && dVar.j();
    }

    public void d(c cVar) {
        d dVar = this.f6179a;
        if (dVar != null) {
            dVar.d(this);
        }
    }

    public void e(c cVar) {
        if (cVar.equals(this.f6181c)) {
            d dVar = this.f6179a;
            if (dVar != null) {
                dVar.e(this.f6181c);
            }
        } else if (!this.f6181c.d()) {
            this.f6181c.a();
        }
    }
}
