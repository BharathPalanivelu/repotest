package com.c.a.g;

public class j implements c, d {

    /* renamed from: a  reason: collision with root package name */
    private c f6208a;

    /* renamed from: b  reason: collision with root package name */
    private c f6209b;

    /* renamed from: c  reason: collision with root package name */
    private d f6210c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6211d;

    public j() {
        this((d) null);
    }

    public j(d dVar) {
        this.f6210c = dVar;
    }

    public void a(c cVar, c cVar2) {
        this.f6208a = cVar;
        this.f6209b = cVar2;
    }

    public boolean b(c cVar) {
        return k() && (cVar.equals(this.f6208a) || !this.f6208a.f());
    }

    private boolean k() {
        d dVar = this.f6210c;
        return dVar == null || dVar.b(this);
    }

    public boolean c(c cVar) {
        return l() && cVar.equals(this.f6208a) && !j();
    }

    private boolean l() {
        d dVar = this.f6210c;
        return dVar == null || dVar.c(this);
    }

    public boolean j() {
        return m() || f();
    }

    public void d(c cVar) {
        if (!cVar.equals(this.f6209b)) {
            d dVar = this.f6210c;
            if (dVar != null) {
                dVar.d(this);
            }
            if (!this.f6209b.e()) {
                this.f6209b.c();
            }
        }
    }

    public void e(c cVar) {
        if (cVar.equals(this.f6208a)) {
            d dVar = this.f6210c;
            if (dVar != null) {
                dVar.e(this);
            }
        }
    }

    private boolean m() {
        d dVar = this.f6210c;
        return dVar != null && dVar.j();
    }

    public void a() {
        this.f6211d = true;
        if (!this.f6209b.d()) {
            this.f6209b.a();
        }
        if (this.f6211d && !this.f6208a.d()) {
            this.f6208a.a();
        }
    }

    public void b() {
        this.f6211d = false;
        this.f6208a.b();
        this.f6209b.b();
    }

    public void c() {
        this.f6211d = false;
        this.f6209b.c();
        this.f6208a.c();
    }

    public boolean d() {
        return this.f6208a.d();
    }

    public boolean e() {
        return this.f6208a.e() || this.f6209b.e();
    }

    public boolean f() {
        return this.f6208a.f() || this.f6209b.f();
    }

    public boolean g() {
        return this.f6208a.g();
    }

    public boolean h() {
        return this.f6208a.h();
    }

    public void i() {
        this.f6208a.i();
        this.f6209b.i();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.c.a.g.c r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.c.a.g.j
            r1 = 0
            if (r0 == 0) goto L_0x002a
            com.c.a.g.j r4 = (com.c.a.g.j) r4
            com.c.a.g.c r0 = r3.f6208a
            if (r0 != 0) goto L_0x0010
            com.c.a.g.c r0 = r4.f6208a
            if (r0 != 0) goto L_0x002a
            goto L_0x0018
        L_0x0010:
            com.c.a.g.c r2 = r4.f6208a
            boolean r0 = r0.a(r2)
            if (r0 == 0) goto L_0x002a
        L_0x0018:
            com.c.a.g.c r0 = r3.f6209b
            if (r0 != 0) goto L_0x0021
            com.c.a.g.c r4 = r4.f6209b
            if (r4 != 0) goto L_0x002a
            goto L_0x0029
        L_0x0021:
            com.c.a.g.c r4 = r4.f6209b
            boolean r4 = r0.a(r4)
            if (r4 == 0) goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.g.j.a(com.c.a.g.c):boolean");
    }
}
