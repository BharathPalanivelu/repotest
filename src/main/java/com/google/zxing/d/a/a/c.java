package com.google.zxing.d.a.a;

import java.util.ArrayList;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f14563a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14564b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14565c;

    c(List<b> list, int i, boolean z) {
        this.f14563a = new ArrayList(list);
        this.f14564b = i;
        this.f14565c = z;
    }

    /* access modifiers changed from: package-private */
    public List<b> a() {
        return this.f14563a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f14564b;
    }

    /* access modifiers changed from: package-private */
    public boolean a(List<b> list) {
        return this.f14563a.equals(list);
    }

    public String toString() {
        return "{ " + this.f14563a + " }";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f14563a.equals(cVar.a()) || this.f14565c != cVar.f14565c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f14563a.hashCode() ^ Boolean.valueOf(this.f14565c).hashCode();
    }
}
