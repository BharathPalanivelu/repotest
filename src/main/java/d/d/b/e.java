package d.d.b;

import d.d.a;
import d.f.b;

public final class e implements d, b<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f32662a;

    public e(Class<?> cls) {
        j.b(cls, "jClass");
        this.f32662a = cls;
    }

    public Class<?> a() {
        return this.f32662a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && j.a((Object) a.a(this), (Object) a.a((b) obj));
    }

    public int hashCode() {
        return a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
