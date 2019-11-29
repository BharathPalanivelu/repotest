package f;

import f.a;
import f.c;
import f.e;
import f.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    final Call.Factory f32972a;

    /* renamed from: b  reason: collision with root package name */
    final HttpUrl f32973b;

    /* renamed from: c  reason: collision with root package name */
    final List<e.a> f32974c;

    /* renamed from: d  reason: collision with root package name */
    final List<c.a> f32975d;

    /* renamed from: e  reason: collision with root package name */
    final Executor f32976e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f32977f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Method, o<?, ?>> f32978g = new ConcurrentHashMap();

    n(Call.Factory factory, HttpUrl httpUrl, List<e.a> list, List<c.a> list2, Executor executor, boolean z) {
        this.f32972a = factory;
        this.f32973b = httpUrl;
        this.f32974c = list;
        this.f32975d = list2;
        this.f32976e = executor;
        this.f32977f = z;
    }

    public <T> T a(final Class<T> cls) {
        p.a(cls);
        if (this.f32977f) {
            b(cls);
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {

            /* renamed from: c  reason: collision with root package name */
            private final k f32981c = k.a();

            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.f32981c.a(method)) {
                    return this.f32981c.a(method, cls, obj, objArr);
                }
                o<?, ?> a2 = n.this.a(method);
                return a2.a((b<?>) new i(a2, objArr));
            }
        });
    }

    private void b(Class<?> cls) {
        k a2 = k.a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a2.a(method)) {
                a(method);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public o<?, ?> a(Method method) {
        o<?, ?> oVar;
        o<?, ?> oVar2 = this.f32978g.get(method);
        if (oVar2 != null) {
            return oVar2;
        }
        synchronized (this.f32978g) {
            oVar = this.f32978g.get(method);
            if (oVar == null) {
                oVar = new o.a(this, method).a();
                this.f32978g.put(method, oVar);
            }
        }
        return oVar;
    }

    public Call.Factory a() {
        return this.f32972a;
    }

    public HttpUrl b() {
        return this.f32973b;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public c<?, ?> a(c.a aVar, Type type, Annotation[] annotationArr) {
        p.a(type, "returnType == null");
        p.a(annotationArr, "annotations == null");
        int indexOf = this.f32975d.indexOf(aVar) + 1;
        int size = this.f32975d.size();
        for (int i = indexOf; i < size; i++) {
            c<?, ?> a2 = this.f32975d.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f32975d.get(i2).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f32975d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f32975d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, RequestBody> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a((e.a) null, type, annotationArr, annotationArr2);
    }

    public <T> e<T, RequestBody> a(e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        p.a(type, "type == null");
        p.a(annotationArr, "parameterAnnotations == null");
        p.a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f32974c.indexOf(aVar) + 1;
        int size = this.f32974c.size();
        for (int i = indexOf; i < size; i++) {
            e<?, RequestBody> a2 = this.f32974c.get(i).a(type, annotationArr, annotationArr2, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f32974c.get(i2).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f32974c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f32974c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<ResponseBody, T> b(Type type, Annotation[] annotationArr) {
        return a((e.a) null, type, annotationArr);
    }

    public <T> e<ResponseBody, T> a(e.a aVar, Type type, Annotation[] annotationArr) {
        p.a(type, "type == null");
        p.a(annotationArr, "annotations == null");
        int indexOf = this.f32974c.indexOf(aVar) + 1;
        int size = this.f32974c.size();
        for (int i = indexOf; i < size; i++) {
            e<ResponseBody, ?> a2 = this.f32974c.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.f32974c.get(i2).getClass().getName());
            }
            sb.append(10);
        }
        sb.append("  Tried:");
        int size2 = this.f32974c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f32974c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        p.a(type, "type == null");
        p.a(annotationArr, "annotations == null");
        int size = this.f32974c.size();
        for (int i = 0; i < size; i++) {
            e<?, String> b2 = this.f32974c.get(i).b(type, annotationArr, this);
            if (b2 != null) {
                return b2;
            }
        }
        return a.d.f32891a;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final k f32982a;

        /* renamed from: b  reason: collision with root package name */
        private Call.Factory f32983b;

        /* renamed from: c  reason: collision with root package name */
        private HttpUrl f32984c;

        /* renamed from: d  reason: collision with root package name */
        private final List<e.a> f32985d;

        /* renamed from: e  reason: collision with root package name */
        private final List<c.a> f32986e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f32987f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f32988g;

        a(k kVar) {
            this.f32985d = new ArrayList();
            this.f32986e = new ArrayList();
            this.f32982a = kVar;
        }

        public a() {
            this(k.a());
        }

        public a a(OkHttpClient okHttpClient) {
            return a((Call.Factory) p.a(okHttpClient, "client == null"));
        }

        public a a(Call.Factory factory) {
            this.f32983b = (Call.Factory) p.a(factory, "factory == null");
            return this;
        }

        public a a(String str) {
            p.a(str, "baseUrl == null");
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                return a(parse);
            }
            throw new IllegalArgumentException("Illegal URL: " + str);
        }

        public a a(HttpUrl httpUrl) {
            p.a(httpUrl, "baseUrl == null");
            List<String> pathSegments = httpUrl.pathSegments();
            if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                this.f32984c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public a a(e.a aVar) {
            this.f32985d.add(p.a(aVar, "factory == null"));
            return this;
        }

        public a a(c.a aVar) {
            this.f32986e.add(p.a(aVar, "factory == null"));
            return this;
        }

        public n a() {
            if (this.f32984c != null) {
                Call.Factory factory = this.f32983b;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor executor = this.f32987f;
                if (executor == null) {
                    executor = this.f32982a.b();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f32986e);
                arrayList.add(this.f32982a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f32985d.size() + 1);
                arrayList2.add(new a());
                arrayList2.addAll(this.f32985d);
                return new n(factory2, this.f32984c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f32988g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }
}
