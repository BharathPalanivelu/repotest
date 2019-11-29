package f;

import f.c.w;
import f.e;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

final class a extends e.a {
    a() {
    }

    public e<ResponseBody, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (type == ResponseBody.class) {
            if (p.a(annotationArr, (Class<? extends Annotation>) w.class)) {
                return c.f32890a;
            }
            return C0504a.f32866a;
        } else if (type == Void.class) {
            return e.f32892a;
        } else {
            return null;
        }
    }

    public e<?, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, n nVar) {
        if (RequestBody.class.isAssignableFrom(p.a(type))) {
            return b.f32889a;
        }
        return null;
    }

    static final class e implements e<ResponseBody, Void> {

        /* renamed from: a  reason: collision with root package name */
        static final e f32892a = new e();

        e() {
        }

        public Void a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    static final class b implements e<RequestBody, RequestBody> {

        /* renamed from: a  reason: collision with root package name */
        static final b f32889a = new b();

        public RequestBody a(RequestBody requestBody) {
            return requestBody;
        }

        b() {
        }
    }

    static final class c implements e<ResponseBody, ResponseBody> {

        /* renamed from: a  reason: collision with root package name */
        static final c f32890a = new c();

        public ResponseBody a(ResponseBody responseBody) {
            return responseBody;
        }

        c() {
        }
    }

    /* renamed from: f.a$a  reason: collision with other inner class name */
    static final class C0504a implements e<ResponseBody, ResponseBody> {

        /* renamed from: a  reason: collision with root package name */
        static final C0504a f32866a = new C0504a();

        C0504a() {
        }

        public ResponseBody a(ResponseBody responseBody) throws IOException {
            try {
                return p.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    static final class d implements e<Object, String> {

        /* renamed from: a  reason: collision with root package name */
        static final d f32891a = new d();

        d() {
        }

        /* renamed from: b */
        public String a(Object obj) {
            return obj.toString();
        }
    }
}
