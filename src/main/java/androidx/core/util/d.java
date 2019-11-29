package androidx.core.util;

import com.litesuits.orm.db.assit.SQLBuilder;

public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f1882a;

    /* renamed from: b  reason: collision with root package name */
    public final S f1883b;

    public d(F f2, S s) {
        this.f1882a = f2;
        this.f1883b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.f1882a, this.f1882a) || !c.a(dVar.f1883b, this.f1883b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f2 = this.f1882a;
        int i = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f1883b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1882a) + SQLBuilder.BLANK + String.valueOf(this.f1883b) + "}";
    }

    public static <A, B> d<A, B> a(A a2, B b2) {
        return new d<>(a2, b2);
    }
}
