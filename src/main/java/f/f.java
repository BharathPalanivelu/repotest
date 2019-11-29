package f;

import f.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

final class f extends c.a {

    /* renamed from: a  reason: collision with root package name */
    static final c.a f32904a = new f();

    f() {
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e2 = p.e(type);
        return new c<Object, b<?>>() {
            /* renamed from: b */
            public b<Object> a(b<Object> bVar) {
                return bVar;
            }

            public Type a() {
                return e2;
            }
        };
    }
}
