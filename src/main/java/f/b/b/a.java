package f.b.b;

import com.google.c.ad;
import com.google.c.aj;
import com.google.c.p;
import f.e;
import f.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class a extends e.a {

    /* renamed from: a  reason: collision with root package name */
    private final p f32900a;

    public static a a(p pVar) {
        return new a(pVar);
    }

    private a(p pVar) {
        this.f32900a = pVar;
    }

    public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        aj ajVar;
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!ad.class.isAssignableFrom(cls)) {
            return null;
        }
        try {
            ajVar = (aj) cls.getDeclaredMethod("parser", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2.getCause());
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            try {
                ajVar = (aj) cls.getDeclaredField("PARSER").get((Object) null);
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
                throw new IllegalArgumentException("Found a protobuf message but " + cls.getName() + " had no parser() method or PARSER field.");
            }
        }
        return new c(ajVar, this.f32900a);
    }

    public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        if ((type instanceof Class) && ad.class.isAssignableFrom((Class) type)) {
            return new b();
        }
        return null;
    }
}
