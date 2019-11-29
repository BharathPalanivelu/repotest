package com.linecorp.linesdk.a;

import java.util.Collections;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final d f15033a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f15034b;

    public e(d dVar, List<String> list) {
        this.f15033a = dVar;
        this.f15034b = Collections.unmodifiableList(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f15033a.equals(eVar.f15033a)) {
            return false;
        }
        return this.f15034b.equals(eVar.f15034b);
    }

    public final int hashCode() {
        return (this.f15033a.hashCode() * 31) + this.f15034b.hashCode();
    }

    public final String toString() {
        return "IssueAccessTokenResult{accessToken=" + "#####" + ", permissions=" + this.f15034b + '}';
    }
}
