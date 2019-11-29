package d;

import java.io.Serializable;

public final class j<A, B> implements Serializable {
    private final A first;
    private final B second;

    public final A c() {
        return this.first;
    }

    public final B d() {
        return this.second;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return d.d.b.j.a((Object) this.first, (Object) jVar.first) && d.d.b.j.a((Object) this.second, (Object) jVar.second);
    }

    public int hashCode() {
        A a2 = this.first;
        int i = 0;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.second;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }

    public j(A a2, B b2) {
        this.first = a2;
        this.second = b2;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
