package io.a.a.a;

import android.content.Context;
import io.a.a.a.a.b.p;
import io.a.a.a.a.c.d;
import io.a.a.a.a.c.l;
import java.io.File;
import java.util.Collection;

public abstract class i<Result> implements Comparable<i> {

    /* renamed from: e  reason: collision with root package name */
    c f33301e;

    /* renamed from: f  reason: collision with root package name */
    h<Result> f33302f = new h<>(this);

    /* renamed from: g  reason: collision with root package name */
    Context f33303g;
    f<Result> h;
    p i;
    final d j = ((d) getClass().getAnnotation(d.class));

    public abstract String a();

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    public abstract String b();

    /* access modifiers changed from: protected */
    public void b(Result result) {
    }

    /* access modifiers changed from: protected */
    public abstract Result f();

    /* access modifiers changed from: protected */
    public boolean h_() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, c cVar, f<Result> fVar, p pVar) {
        this.f33301e = cVar;
        this.f33303g = new d(context, b(), t());
        this.h = fVar;
        this.i = pVar;
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        this.f33302f.a(this.f33301e.f(), null);
    }

    /* access modifiers changed from: protected */
    public p q() {
        return this.i;
    }

    public Context r() {
        return this.f33303g;
    }

    public c s() {
        return this.f33301e;
    }

    public String t() {
        return ".Fabric" + File.separator + b();
    }

    /* renamed from: a */
    public int compareTo(i iVar) {
        if (b(iVar)) {
            return 1;
        }
        if (iVar.b(this)) {
            return -1;
        }
        if (u() && !iVar.u()) {
            return 1;
        }
        if (u() || !iVar.u()) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean b(i iVar) {
        if (u()) {
            for (Class isAssignableFrom : this.j.a()) {
                if (isAssignableFrom.isAssignableFrom(iVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        return this.j != null;
    }

    /* access modifiers changed from: protected */
    public Collection<l> v() {
        return this.f33302f.c();
    }
}
