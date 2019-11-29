package d.d.b;

import d.f.a;
import d.f.e;

public abstract class l extends c implements e {
    /* access modifiers changed from: protected */
    /* renamed from: h */
    public e d() {
        return (e) super.d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (!e().equals(lVar.e()) || !f().equals(lVar.f()) || !g().equals(lVar.g()) || !j.a(b(), lVar.b())) {
                return false;
            }
            return true;
        } else if (obj instanceof e) {
            return obj.equals(c());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((e().hashCode() * 31) + f().hashCode()) * 31) + g().hashCode();
    }

    public String toString() {
        a c2 = c();
        if (c2 != this) {
            return c2.toString();
        }
        return "property " + f() + " (Kotlin reflection is not available)";
    }
}
