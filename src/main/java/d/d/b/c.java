package d.d.b;

import d.d.b;
import java.io.ObjectStreamException;
import java.io.Serializable;

public abstract class c implements d.f.a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f32659a = a.f32661a;

    /* renamed from: b  reason: collision with root package name */
    private transient d.f.a f32660b;
    protected final Object receiver;

    /* access modifiers changed from: protected */
    public abstract d.f.a a();

    private static class a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f32661a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f32661a;
        }
    }

    public c() {
        this(f32659a);
    }

    protected c(Object obj) {
        this.receiver = obj;
    }

    public Object b() {
        return this.receiver;
    }

    public d.f.a c() {
        d.f.a aVar = this.f32660b;
        if (aVar != null) {
            return aVar;
        }
        d.f.a a2 = a();
        this.f32660b = a2;
        return a2;
    }

    /* access modifiers changed from: protected */
    public d.f.a d() {
        d.f.a c2 = c();
        if (c2 != this) {
            return c2;
        }
        throw new b();
    }

    public d.f.c e() {
        throw new AbstractMethodError();
    }

    public String f() {
        throw new AbstractMethodError();
    }

    public String g() {
        throw new AbstractMethodError();
    }

    public Object a(Object... objArr) {
        return d().a(objArr);
    }
}
