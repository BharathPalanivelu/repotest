package f.b.a;

import com.google.a.f;
import f.e;
import f.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class a extends e.a {

    /* renamed from: a  reason: collision with root package name */
    private final f f32893a;

    public static a a() {
        return a(new f());
    }

    public static a a(f fVar) {
        if (fVar != null) {
            return new a(fVar);
        }
        throw new NullPointerException("gson == null");
    }

    private a(f fVar) {
        this.f32893a = fVar;
    }

    public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        return new c(this.f32893a, this.f32893a.a(com.google.a.c.a.get(type)));
    }

    public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        return new b(this.f32893a, this.f32893a.a(com.google.a.c.a.get(type)));
    }
}
