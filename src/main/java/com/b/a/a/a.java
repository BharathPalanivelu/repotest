package com.b.a.a;

import com.b.a.a.b;
import java.util.ArrayList;
import java.util.List;

public class a<P extends b<C>, C> {

    /* renamed from: a  reason: collision with root package name */
    private P f4651a;

    /* renamed from: b  reason: collision with root package name */
    private C f4652b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4653c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4654d = false;

    /* renamed from: e  reason: collision with root package name */
    private List<a<P, C>> f4655e;

    public a(P p) {
        this.f4651a = p;
        this.f4655e = a(p);
    }

    public a(C c2) {
        this.f4652b = c2;
    }

    public P a() {
        return this.f4651a;
    }

    public C b() {
        return this.f4652b;
    }

    public boolean c() {
        return this.f4654d;
    }

    public void a(boolean z) {
        this.f4654d = z;
    }

    public boolean d() {
        return this.f4653c;
    }

    public List<a<P, C>> e() {
        if (this.f4653c) {
            return this.f4655e;
        }
        throw new IllegalStateException("Parent not wrapped");
    }

    private List<a<P, C>> a(P p) {
        ArrayList arrayList = new ArrayList();
        for (Object aVar : p.getChildList()) {
            arrayList.add(new a(aVar));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        P p = this.f4651a;
        if (p == null ? aVar.f4651a != null : !p.equals(aVar.f4651a)) {
            return false;
        }
        C c2 = this.f4652b;
        if (c2 != null) {
            return c2.equals(aVar.f4652b);
        }
        if (aVar.f4652b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        P p = this.f4651a;
        int i = 0;
        int hashCode = (p != null ? p.hashCode() : 0) * 31;
        C c2 = this.f4652b;
        if (c2 != null) {
            i = c2.hashCode();
        }
        return hashCode + i;
    }
}
