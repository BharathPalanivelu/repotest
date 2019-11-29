package com.google.c;

import com.google.c.a;
import com.google.c.a.C0223a;
import com.google.c.ag;

public class an<MType extends a, BType extends a.C0223a, IType extends ag> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.b f13631a;

    /* renamed from: b  reason: collision with root package name */
    private BType f13632b;

    /* renamed from: c  reason: collision with root package name */
    private MType f13633c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13634d;

    public an(MType mtype, a.b bVar, boolean z) {
        if (mtype != null) {
            this.f13633c = mtype;
            this.f13631a = bVar;
            this.f13634d = z;
            return;
        }
        throw new NullPointerException();
    }

    public MType b() {
        if (this.f13633c == null) {
            this.f13633c = (a) this.f13632b.t();
        }
        return this.f13633c;
    }

    public MType c() {
        this.f13634d = true;
        return b();
    }

    public BType d() {
        if (this.f13632b == null) {
            this.f13632b = (a.C0223a) this.f13633c.a((a.b) this);
            this.f13632b.c((ac) this.f13633c);
            this.f13632b.c();
        }
        return this.f13632b;
    }

    public IType e() {
        Object obj = this.f13632b;
        if (obj != null) {
            return obj;
        }
        return this.f13633c;
    }

    public an<MType, BType, IType> a(MType mtype) {
        if (this.f13632b == null) {
            MType mtype2 = this.f13633c;
            if (mtype2 == mtype2.L()) {
                this.f13633c = mtype;
                f();
                return this;
            }
        }
        d().c((ac) mtype);
        f();
        return this;
    }

    private void f() {
        if (this.f13632b != null) {
            this.f13633c = null;
        }
        if (this.f13634d) {
            a.b bVar = this.f13631a;
            if (bVar != null) {
                bVar.a();
                this.f13634d = false;
            }
        }
    }

    public void a() {
        f();
    }
}
