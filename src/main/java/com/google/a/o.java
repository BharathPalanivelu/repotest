package com.google.a;

import com.google.a.b.h;
import java.util.Map;
import java.util.Set;

public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    private final h<String, l> f8934a = new h<>();

    public void a(String str, l lVar) {
        if (lVar == null) {
            lVar = n.f8933a;
        }
        this.f8934a.put(str, lVar);
    }

    public l a(String str) {
        return this.f8934a.remove(str);
    }

    public void a(String str, String str2) {
        a(str, a((Object) str2));
    }

    public void a(String str, Number number) {
        a(str, a((Object) number));
    }

    public void a(String str, Boolean bool) {
        a(str, a((Object) bool));
    }

    private l a(Object obj) {
        return obj == null ? n.f8933a : new r(obj);
    }

    public Set<Map.Entry<String, l>> a() {
        return this.f8934a.entrySet();
    }

    public Set<String> q() {
        return this.f8934a.keySet();
    }

    public boolean b(String str) {
        return this.f8934a.containsKey(str);
    }

    public l c(String str) {
        return this.f8934a.get(str);
    }

    public i d(String str) {
        return (i) this.f8934a.get(str);
    }

    public o e(String str) {
        return (o) this.f8934a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f8934a.equals(this.f8934a));
    }

    public int hashCode() {
        return this.f8934a.hashCode();
    }
}
