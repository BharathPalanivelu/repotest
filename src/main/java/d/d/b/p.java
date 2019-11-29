package d.d.b;

import d.f.b;
import d.f.f;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final q f32670a;

    /* renamed from: b  reason: collision with root package name */
    private static final b[] f32671b = new b[0];

    static {
        q qVar = null;
        try {
            qVar = (q) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (qVar == null) {
            qVar = new q();
        }
        f32670a = qVar;
    }

    public static b a(Class cls) {
        return f32670a.a(cls);
    }

    public static String a(k kVar) {
        return f32670a.a(kVar);
    }

    public static f a(m mVar) {
        return f32670a.a(mVar);
    }
}
