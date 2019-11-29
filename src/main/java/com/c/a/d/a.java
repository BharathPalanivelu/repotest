package com.c.a.d;

import com.c.a.i.i;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f6121a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f6122b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6123c;

    a() {
    }

    public void a(i iVar) {
        this.f6121a.add(iVar);
        if (this.f6123c) {
            iVar.e();
        } else if (this.f6122b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    public void b(i iVar) {
        this.f6121a.remove(iVar);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f6122b = true;
        for (T c2 : i.a(this.f6121a)) {
            c2.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f6122b = false;
        for (T d2 : i.a(this.f6121a)) {
            d2.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f6123c = true;
        for (T e2 : i.a(this.f6121a)) {
            e2.e();
        }
    }
}
