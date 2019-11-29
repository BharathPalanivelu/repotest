package io.a.a.a;

import io.a.a.a.a.b.u;
import io.a.a.a.a.c.e;
import io.a.a.a.a.c.f;
import io.a.a.a.a.c.m;

class h<Result> extends f<Void, Void, Result> {

    /* renamed from: a  reason: collision with root package name */
    final i<Result> f33300a;

    public h(i<Result> iVar) {
        this.f33300a = iVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        u a2 = a("onPreExecute");
        try {
            boolean h_ = this.f33300a.h_();
            a2.b();
            if (h_) {
                return;
            }
        } catch (m e2) {
            throw e2;
        } catch (Exception e3) {
            c.h().e("Fabric", "Failure onPreExecute()", e3);
            a2.b();
        } catch (Throwable th) {
            a2.b();
            a(true);
            throw th;
        }
        a(true);
    }

    /* access modifiers changed from: protected */
    public Result a(Void... voidArr) {
        u a2 = a("doInBackground");
        Result f2 = !e() ? this.f33300a.f() : null;
        a2.b();
        return f2;
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
        this.f33300a.a(result);
        this.f33300a.h.a(result);
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        this.f33300a.b(result);
        this.f33300a.h.a((Exception) new g(this.f33300a.b() + " Initialization was cancelled"));
    }

    public e b() {
        return e.HIGH;
    }

    private u a(String str) {
        u uVar = new u(this.f33300a.b() + "." + str, "KitInitialization");
        uVar.a();
        return uVar;
    }
}
