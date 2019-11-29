package com.firebase.jobdispatcher;

import com.firebase.jobdispatcher.n;
import com.firebase.jobdispatcher.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f7192a;

    /* renamed from: b  reason: collision with root package name */
    private final aa f7193b;

    /* renamed from: c  reason: collision with root package name */
    private final x.a f7194c = new x.a(this.f7193b);

    public static final class a extends RuntimeException {
    }

    public e(c cVar) {
        this.f7192a = cVar;
        this.f7193b = new aa(cVar.a());
    }

    public int a(n nVar) {
        if (!this.f7192a.b()) {
            return 2;
        }
        return this.f7192a.a(nVar);
    }

    public int a(String str) {
        if (!this.f7192a.b()) {
            return 2;
        }
        return this.f7192a.a(str);
    }

    public void b(n nVar) {
        if (a(nVar) != 0) {
            throw new a();
        }
    }

    public n.a a() {
        return new n.a(this.f7193b);
    }
}
