package f;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface e<F, T> {

    public static abstract class a {
        public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
            return null;
        }

        public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
            return null;
        }

        public e<?, String> b(Type type, Annotation[] annotationArr, n nVar) {
            return null;
        }
    }

    T a(F f2) throws IOException;
}
