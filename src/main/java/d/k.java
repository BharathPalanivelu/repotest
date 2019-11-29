package d;

import d.d.a.a;
import d.d.b.j;
import java.io.Serializable;

final class k<T> implements e<T>, Serializable {
    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;

    public k(a<? extends T> aVar, Object obj) {
        j.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = n.f32713a;
        this.lock = obj == null ? this : obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(a aVar, Object obj, int i, g gVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    public T a() {
        T t;
        T t2 = this._value;
        if (t2 != n.f32713a) {
            return t2;
        }
        synchronized (this.lock) {
            t = this._value;
            if (t == n.f32713a) {
                a aVar = this.initializer;
                if (aVar == null) {
                    j.a();
                }
                t = aVar.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    public boolean b() {
        return this._value != n.f32713a;
    }

    public String toString() {
        return b() ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new c(a());
    }
}
