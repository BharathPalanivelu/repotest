package androidx.lifecycle;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final a f2592a;

    /* renamed from: b  reason: collision with root package name */
    private final s f2593b;

    public interface a {
        <T extends q> T a(Class<T> cls);
    }

    static abstract class b implements a {
        public abstract <T extends q> T a(String str, Class<T> cls);

        b() {
        }
    }

    public r(s sVar, a aVar) {
        this.f2592a = aVar;
        this.f2593b = sVar;
    }

    public <T extends q> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends q> T a(String str, Class<T> cls) {
        T t;
        T a2 = this.f2593b.a(str);
        if (cls.isInstance(a2)) {
            return a2;
        }
        a aVar = this.f2592a;
        if (aVar instanceof b) {
            t = ((b) aVar).a(str, cls);
        } else {
            t = aVar.a(cls);
        }
        this.f2593b.a(str, t);
        return t;
    }
}
