package f;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface c<R, T> {
    T a(b<R> bVar);

    Type a();

    public static abstract class a {
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, n nVar);

        protected static Type a(int i, ParameterizedType parameterizedType) {
            return p.a(i, parameterizedType);
        }

        protected static Class<?> a(Type type) {
            return p.a(type);
        }
    }
}
