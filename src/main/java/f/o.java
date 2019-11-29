package f;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import f.c.b;
import f.c.c;
import f.c.d;
import f.c.e;
import f.c.f;
import f.c.g;
import f.c.h;
import f.c.i;
import f.c.k;
import f.c.l;
import f.c.m;
import f.c.n;
import f.c.p;
import f.c.q;
import f.c.r;
import f.c.s;
import f.c.t;
import f.c.u;
import f.c.v;
import f.c.x;
import f.j;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class o<R, T> {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f32989a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: b  reason: collision with root package name */
    static final Pattern f32990b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: c  reason: collision with root package name */
    private final Call.Factory f32991c;

    /* renamed from: d  reason: collision with root package name */
    private final c<R, T> f32992d;

    /* renamed from: e  reason: collision with root package name */
    private final HttpUrl f32993e;

    /* renamed from: f  reason: collision with root package name */
    private final e<ResponseBody, R> f32994f;

    /* renamed from: g  reason: collision with root package name */
    private final String f32995g;
    private final String h;
    private final Headers i;
    private final MediaType j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final j<?>[] n;

    o(a<R, T> aVar) {
        this.f32991c = aVar.f32996a.a();
        this.f32992d = aVar.w;
        this.f32993e = aVar.f32996a.b();
        this.f32994f = aVar.v;
        this.f32995g = aVar.m;
        this.h = aVar.q;
        this.i = aVar.r;
        this.j = aVar.s;
        this.k = aVar.n;
        this.l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.u;
    }

    /* access modifiers changed from: package-private */
    public Call a(Object... objArr) throws IOException {
        l lVar = new l(this.f32995g, this.f32993e, this.h, this.i, this.j, this.k, this.l, this.m);
        j<?>[] jVarArr = this.n;
        int length = objArr != null ? objArr.length : 0;
        if (length == jVarArr.length) {
            for (int i2 = 0; i2 < length; i2++) {
                jVarArr[i2].a(lVar, objArr[i2]);
            }
            return this.f32991c.newCall(lVar.a());
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + jVarArr.length + SQLBuilder.PARENTHESES_RIGHT);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [f.b<R>, f.b] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a(f.b<R> r2) {
        /*
            r1 = this;
            f.c<R, T> r0 = r1.f32992d
            java.lang.Object r2 = r0.a(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f.o.a(f.b):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public R a(ResponseBody responseBody) throws IOException {
        return this.f32994f.a(responseBody);
    }

    static final class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final n f32996a;

        /* renamed from: b  reason: collision with root package name */
        final Method f32997b;

        /* renamed from: c  reason: collision with root package name */
        final Annotation[] f32998c;

        /* renamed from: d  reason: collision with root package name */
        final Annotation[][] f32999d;

        /* renamed from: e  reason: collision with root package name */
        final Type[] f33000e;

        /* renamed from: f  reason: collision with root package name */
        Type f33001f;

        /* renamed from: g  reason: collision with root package name */
        boolean f33002g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        String m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        Headers r;
        MediaType s;
        Set<String> t;
        j<?>[] u;
        e<ResponseBody, T> v;
        c<T, R> w;

        a(n nVar, Method method) {
            this.f32996a = nVar;
            this.f32997b = method;
            this.f32998c = method.getAnnotations();
            this.f33000e = method.getGenericParameterTypes();
            this.f32999d = method.getParameterAnnotations();
        }

        public o a() {
            this.w = b();
            this.f33001f = this.w.a();
            Type type = this.f33001f;
            if (type == m.class || type == Response.class) {
                throw a("'" + p.a(this.f33001f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.v = c();
            for (Annotation a2 : this.f32998c) {
                a(a2);
            }
            if (this.m != null) {
                if (!this.n) {
                    if (this.p) {
                        throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.o) {
                        throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f32999d.length;
                this.u = new j[length];
                int i2 = 0;
                while (i2 < length) {
                    Type type2 = this.f33000e[i2];
                    if (!p.d(type2)) {
                        Annotation[] annotationArr = this.f32999d[i2];
                        if (annotationArr != null) {
                            this.u[i2] = a(i2, type2, annotationArr);
                            i2++;
                        } else {
                            throw a(i2, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw a(i2, "Parameter type must not include a type variable or wildcard: %s", type2);
                    }
                }
                if (this.q == null && !this.l) {
                    throw a("Missing either @%s URL or @Url parameter.", this.m);
                } else if (!this.o && !this.p && !this.n && this.i) {
                    throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.o && !this.f33002g) {
                    throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.p || this.h) {
                    return new o(this);
                } else {
                    throw a("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private c<T, R> b() {
            Type genericReturnType = this.f32997b.getGenericReturnType();
            if (p.d(genericReturnType)) {
                throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType != Void.TYPE) {
                try {
                    return this.f32996a.a(genericReturnType, this.f32997b.getAnnotations());
                } catch (RuntimeException e2) {
                    throw a((Throwable) e2, "Unable to create call adapter for %s", genericReturnType);
                }
            } else {
                throw a("Service methods cannot return void.", new Object[0]);
            }
        }

        private void a(Annotation annotation) {
            if (annotation instanceof b) {
                a("DELETE", ((b) annotation).a(), false);
            } else if (annotation instanceof f) {
                a("GET", ((f) annotation).a(), false);
            } else if (annotation instanceof g) {
                a("HEAD", ((g) annotation).a(), false);
                if (!Void.class.equals(this.f33001f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof n) {
                a("PATCH", ((n) annotation).a(), true);
            } else if (annotation instanceof f.c.o) {
                a("POST", ((f.c.o) annotation).a(), true);
            } else if (annotation instanceof p) {
                a("PUT", ((p) annotation).a(), true);
            } else if (annotation instanceof m) {
                a("OPTIONS", ((m) annotation).a(), false);
            } else if (annotation instanceof h) {
                h hVar = (h) annotation;
                a(hVar.a(), hVar.b(), hVar.c());
            } else if (annotation instanceof k) {
                String[] a2 = ((k) annotation).a();
                if (a2.length != 0) {
                    this.r = a(a2);
                    return;
                }
                throw a("@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof l) {
                if (!this.o) {
                    this.p = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof e)) {
            } else {
                if (!this.p) {
                    this.o = true;
                    return;
                }
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.m;
            if (str3 == null) {
                this.m = str;
                this.n = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (o.f32989a.matcher(substring).find()) {
                            throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.q = str2;
                    this.t = o.a(str2);
                    return;
                }
                return;
            }
            throw a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private Headers a(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpConstants.Header.CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    MediaType parse = MediaType.parse(trim);
                    if (parse != null) {
                        this.s = parse;
                    } else {
                        throw a("Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private j<?> a(int i2, Type type, Annotation[] annotationArr) {
            j<?> jVar = null;
            for (Annotation a2 : annotationArr) {
                j<?> a3 = a(i2, type, annotationArr, a2);
                if (a3 != null) {
                    if (jVar == null) {
                        jVar = a3;
                    } else {
                        throw a(i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (jVar != null) {
                return jVar;
            }
            throw a(i2, "No Retrofit annotation found.", new Object[0]);
        }

        private j<?> a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                if (this.l) {
                    throw a(i2, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.j) {
                    throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.k) {
                    throw a(i2, "A @Url parameter must not come after a @Query", new Object[0]);
                } else if (this.q == null) {
                    this.l = true;
                    if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new j.m();
                    }
                    throw a(i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw a(i2, "@Url cannot be used with @%s URL", this.m);
                }
            } else if (annotation instanceof s) {
                if (this.k) {
                    throw a(i2, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.l) {
                    throw a(i2, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.q != null) {
                    this.j = true;
                    s sVar = (s) annotation;
                    String a2 = sVar.a();
                    a(i2, a2);
                    return new j.h(a2, this.f32996a.c(type, annotationArr), sVar.b());
                } else {
                    throw a(i2, "@Path can only be used with relative url on @%s", this.m);
                }
            } else if (annotation instanceof t) {
                t tVar = (t) annotation;
                String a3 = tVar.a();
                boolean b2 = tVar.b();
                Class<?> a4 = p.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(a4)) {
                    if (type instanceof ParameterizedType) {
                        return new j.i(a3, this.f32996a.c(p.a(0, (ParameterizedType) type), annotationArr), b2).a();
                    }
                    throw a(i2, a4.getSimpleName() + " must include generic type (e.g., " + a4.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a4.isArray()) {
                    return new j.i(a3, this.f32996a.c(type, annotationArr), b2);
                } else {
                    return new j.i(a3, this.f32996a.c(o.a(a4.getComponentType()), annotationArr), b2).b();
                }
            } else if (annotation instanceof v) {
                boolean a5 = ((v) annotation).a();
                Class<?> a6 = p.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(a6)) {
                    if (type instanceof ParameterizedType) {
                        return new j.k(this.f32996a.c(p.a(0, (ParameterizedType) type), annotationArr), a5).a();
                    }
                    throw a(i2, a6.getSimpleName() + " must include generic type (e.g., " + a6.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a6.isArray()) {
                    return new j.k(this.f32996a.c(type, annotationArr), a5);
                } else {
                    return new j.k(this.f32996a.c(o.a(a6.getComponentType()), annotationArr), a5).b();
                }
            } else if (annotation instanceof u) {
                Class<?> a7 = p.a(type);
                if (Map.class.isAssignableFrom(a7)) {
                    Type b3 = p.b(type, a7, Map.class);
                    if (b3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) b3;
                        Type a8 = p.a(0, parameterizedType);
                        if (String.class == a8) {
                            return new j.C0506j(this.f32996a.c(p.a(1, parameterizedType), annotationArr), ((u) annotation).a());
                        }
                        throw a(i2, "@QueryMap keys must be of type String: " + a8, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof i) {
                String a9 = ((i) annotation).a();
                Class<?> a10 = p.a(type);
                if (Iterable.class.isAssignableFrom(a10)) {
                    if (type instanceof ParameterizedType) {
                        return new j.d(a9, this.f32996a.c(p.a(0, (ParameterizedType) type), annotationArr)).a();
                    }
                    throw a(i2, a10.getSimpleName() + " must include generic type (e.g., " + a10.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a10.isArray()) {
                    return new j.d(a9, this.f32996a.c(type, annotationArr));
                } else {
                    return new j.d(a9, this.f32996a.c(o.a(a10.getComponentType()), annotationArr)).b();
                }
            } else if (annotation instanceof f.c.j) {
                Class<?> a11 = p.a(type);
                if (Map.class.isAssignableFrom(a11)) {
                    Type b4 = p.b(type, a11, Map.class);
                    if (b4 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) b4;
                        Type a12 = p.a(0, parameterizedType2);
                        if (String.class == a12) {
                            return new j.e(this.f32996a.c(p.a(1, parameterizedType2), annotationArr));
                        }
                        throw a(i2, "@HeaderMap keys must be of type String: " + a12, new Object[0]);
                    }
                    throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof c) {
                if (this.o) {
                    c cVar = (c) annotation;
                    String a13 = cVar.a();
                    boolean b5 = cVar.b();
                    this.f33002g = true;
                    Class<?> a14 = p.a(type);
                    if (Iterable.class.isAssignableFrom(a14)) {
                        if (type instanceof ParameterizedType) {
                            return new j.b(a13, this.f32996a.c(p.a(0, (ParameterizedType) type), annotationArr), b5).a();
                        }
                        throw a(i2, a14.getSimpleName() + " must include generic type (e.g., " + a14.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!a14.isArray()) {
                        return new j.b(a13, this.f32996a.c(type, annotationArr), b5);
                    } else {
                        return new j.b(a13, this.f32996a.c(o.a(a14.getComponentType()), annotationArr), b5).b();
                    }
                } else {
                    throw a(i2, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof d) {
                if (this.o) {
                    Class<?> a15 = p.a(type);
                    if (Map.class.isAssignableFrom(a15)) {
                        Type b6 = p.b(type, a15, Map.class);
                        if (b6 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) b6;
                            Type a16 = p.a(0, parameterizedType3);
                            if (String.class == a16) {
                                e c2 = this.f32996a.c(p.a(1, parameterizedType3), annotationArr);
                                this.f33002g = true;
                                return new j.c(c2, ((d) annotation).a());
                            }
                            throw a(i2, "@FieldMap keys must be of type String: " + a16, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof q) {
                if (this.p) {
                    q qVar = (q) annotation;
                    this.h = true;
                    String a17 = qVar.a();
                    Class<?> a18 = p.a(type);
                    if (!a17.isEmpty()) {
                        Headers of = Headers.of(COSRequestHeaderKey.CONTENT_DISPOSITION, "form-data; name=\"" + a17 + "\"", "Content-Transfer-Encoding", qVar.b());
                        if (Iterable.class.isAssignableFrom(a18)) {
                            if (type instanceof ParameterizedType) {
                                Type a19 = p.a(0, (ParameterizedType) type);
                                if (!MultipartBody.Part.class.isAssignableFrom(p.a(a19))) {
                                    return new j.f(of, this.f32996a.a(a19, annotationArr, this.f32998c)).a();
                                }
                                throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            throw a(i2, a18.getSimpleName() + " must include generic type (e.g., " + a18.getSimpleName() + "<String>)", new Object[0]);
                        } else if (a18.isArray()) {
                            Class<?> a20 = o.a(a18.getComponentType());
                            if (!MultipartBody.Part.class.isAssignableFrom(a20)) {
                                return new j.f(of, this.f32996a.a((Type) a20, annotationArr, this.f32998c)).b();
                            }
                            throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!MultipartBody.Part.class.isAssignableFrom(a18)) {
                            return new j.f(of, this.f32996a.a(type, annotationArr, this.f32998c));
                        } else {
                            throw a(i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(a18)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw a(i2, a18.getSimpleName() + " must include generic type (e.g., " + a18.getSimpleName() + "<String>)", new Object[0]);
                        } else if (MultipartBody.Part.class.isAssignableFrom(p.a(p.a(0, (ParameterizedType) type)))) {
                            return j.l.f32957a.a();
                        } else {
                            throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (a18.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(a18.getComponentType())) {
                            return j.l.f32957a.b();
                        }
                        throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (MultipartBody.Part.class.isAssignableFrom(a18)) {
                        return j.l.f32957a;
                    } else {
                        throw a(i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw a(i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof r) {
                if (this.p) {
                    this.h = true;
                    Class<?> a21 = p.a(type);
                    if (Map.class.isAssignableFrom(a21)) {
                        Type b7 = p.b(type, a21, Map.class);
                        if (b7 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) b7;
                            Type a22 = p.a(0, parameterizedType4);
                            if (String.class == a22) {
                                Type a23 = p.a(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(p.a(a23))) {
                                    return new j.g(this.f32996a.a(a23, annotationArr, this.f32998c), ((r) annotation).a());
                                }
                                throw a(i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw a(i2, "@PartMap keys must be of type String: " + a22, new Object[0]);
                        }
                        throw a(i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw a(i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw a(i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (!(annotation instanceof f.c.a)) {
                return null;
            } else {
                if (this.o || this.p) {
                    throw a(i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.i) {
                    try {
                        e a24 = this.f32996a.a(type, annotationArr, this.f32998c);
                        this.i = true;
                        return new j.a(a24);
                    } catch (RuntimeException e2) {
                        throw a((Throwable) e2, i2, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw a(i2, "Multiple @Body method annotations found.", new Object[0]);
                }
            }
        }

        private void a(int i2, String str) {
            if (!o.f32990b.matcher(str).matches()) {
                throw a(i2, "@Path parameter name must match %s. Found: %s", o.f32989a.pattern(), str);
            } else if (!this.t.contains(str)) {
                throw a(i2, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
            }
        }

        private e<ResponseBody, T> c() {
            try {
                return this.f32996a.b(this.f33001f, this.f32997b.getAnnotations());
            } catch (RuntimeException e2) {
                throw a((Throwable) e2, "Unable to create converter for %s", this.f33001f);
            }
        }

        private RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        private RuntimeException a(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            return new IllegalArgumentException(format + "\n    for method " + this.f32997b.getDeclaringClass().getSimpleName() + "." + this.f32997b.getName(), th);
        }

        private RuntimeException a(Throwable th, int i2, String str, Object... objArr) {
            return a(th, str + " (parameter #" + (i2 + 1) + SQLBuilder.PARENTHESES_RIGHT, objArr);
        }

        private RuntimeException a(int i2, String str, Object... objArr) {
            return a(str + " (parameter #" + (i2 + 1) + SQLBuilder.PARENTHESES_RIGHT, objArr);
        }
    }

    static Set<String> a(String str) {
        Matcher matcher = f32989a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    static Class<?> a(Class<?> cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }
}
