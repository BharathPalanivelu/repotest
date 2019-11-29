package com.airbnb.lottie.c;

import androidx.core.util.d;
import com.litesuits.orm.db.assit.SQLBuilder;

public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    T f3649a;

    /* renamed from: b  reason: collision with root package name */
    T f3650b;

    public void a(T t, T t2) {
        this.f3649a = t;
        this.f3650b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!b(dVar.f1882a, this.f3649a) || !b(dVar.f1883b, this.f3650b)) {
            return false;
        }
        return true;
    }

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.f3649a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f3650b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f3649a) + SQLBuilder.BLANK + String.valueOf(this.f3650b) + "}";
    }
}
