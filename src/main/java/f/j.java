package f;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

abstract class j<T> {
    /* access modifiers changed from: package-private */
    public abstract void a(l lVar, T t) throws IOException;

    j() {
    }

    /* access modifiers changed from: package-private */
    public final j<Iterable<T>> a() {
        return new j<Iterable<T>>() {
            /* access modifiers changed from: package-private */
            public void a(l lVar, Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T a2 : iterable) {
                        j.this.a(lVar, a2);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final j<Object> b() {
        return new j<Object>() {
            /* access modifiers changed from: package-private */
            public void a(l lVar, Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        j.this.a(lVar, Array.get(obj, i));
                    }
                }
            }
        };
    }

    static final class m extends j<Object> {
        m() {
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Object obj) {
            p.a(obj, "@Url parameter is null.");
            lVar.a(obj);
        }
    }

    static final class d<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f32940a;

        /* renamed from: b  reason: collision with root package name */
        private final e<T, String> f32941b;

        d(String str, e<T, String> eVar) {
            this.f32940a = (String) p.a(str, "name == null");
            this.f32941b = eVar;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) throws IOException {
            if (t != null) {
                String a2 = this.f32941b.a(t);
                if (a2 != null) {
                    lVar.a(this.f32940a, a2);
                }
            }
        }
    }

    static final class h<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f32947a;

        /* renamed from: b  reason: collision with root package name */
        private final e<T, String> f32948b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f32949c;

        h(String str, e<T, String> eVar, boolean z) {
            this.f32947a = (String) p.a(str, "name == null");
            this.f32948b = eVar;
            this.f32949c = z;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) throws IOException {
            if (t != null) {
                lVar.a(this.f32947a, this.f32948b.a(t), this.f32949c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f32947a + "\" value must not be null.");
        }
    }

    static final class i<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f32950a;

        /* renamed from: b  reason: collision with root package name */
        private final e<T, String> f32951b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f32952c;

        i(String str, e<T, String> eVar, boolean z) {
            this.f32950a = (String) p.a(str, "name == null");
            this.f32951b = eVar;
            this.f32952c = z;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) throws IOException {
            if (t != null) {
                String a2 = this.f32951b.a(t);
                if (a2 != null) {
                    lVar.b(this.f32950a, a2, this.f32952c);
                }
            }
        }
    }

    static final class k<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T, String> f32955a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f32956b;

        k(e<T, String> eVar, boolean z) {
            this.f32955a = eVar;
            this.f32956b = z;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) throws IOException {
            if (t != null) {
                lVar.b(this.f32955a.a(t), (String) null, this.f32956b);
            }
        }
    }

    /* renamed from: f.j$j  reason: collision with other inner class name */
    static final class C0506j<T> extends j<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T, String> f32953a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f32954b;

        C0506j(e<T, String> eVar, boolean z) {
            this.f32953a = eVar;
            this.f32954b = z;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String a2 = this.f32953a.a(value);
                            if (a2 != null) {
                                lVar.b(str, a2, this.f32954b);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f32953a.getClass().getName() + " for key '" + str + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    static final class e<T> extends j<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T, String> f32942a;

        e(e<T, String> eVar) {
            this.f32942a = eVar;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            lVar.a(str, this.f32942a.a(value));
                        } else {
                            throw new IllegalArgumentException("Header map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    static final class b<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f32935a;

        /* renamed from: b  reason: collision with root package name */
        private final e<T, String> f32936b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f32937c;

        b(String str, e<T, String> eVar, boolean z) {
            this.f32935a = (String) p.a(str, "name == null");
            this.f32936b = eVar;
            this.f32937c = z;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) throws IOException {
            if (t != null) {
                String a2 = this.f32936b.a(t);
                if (a2 != null) {
                    lVar.c(this.f32935a, a2, this.f32937c);
                }
            }
        }
    }

    static final class c<T> extends j<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T, String> f32938a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f32939b;

        c(e<T, String> eVar, boolean z) {
            this.f32938a = eVar;
            this.f32939b = z;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            String a2 = this.f32938a.a(value);
                            if (a2 != null) {
                                lVar.c(str, a2, this.f32939b);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f32938a.getClass().getName() + " for key '" + str + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    static final class f<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Headers f32943a;

        /* renamed from: b  reason: collision with root package name */
        private final e<T, RequestBody> f32944b;

        f(Headers headers, e<T, RequestBody> eVar) {
            this.f32943a = headers;
            this.f32944b = eVar;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) {
            if (t != null) {
                try {
                    lVar.a(this.f32943a, this.f32944b.a(t));
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
                }
            }
        }
    }

    static final class l extends j<MultipartBody.Part> {

        /* renamed from: a  reason: collision with root package name */
        static final l f32957a = new l();

        private l() {
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, MultipartBody.Part part) {
            if (part != null) {
                lVar.a(part);
            }
        }
    }

    static final class g<T> extends j<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T, RequestBody> f32945a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32946b;

        g(e<T, RequestBody> eVar, String str) {
            this.f32945a = eVar;
            this.f32946b = str;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    if (str != null) {
                        Object value = next.getValue();
                        if (value != null) {
                            lVar.a(Headers.of(COSRequestHeaderKey.CONTENT_DISPOSITION, "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.f32946b), this.f32945a.a(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + str + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class a<T> extends j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final e<T, RequestBody> f32934a;

        a(e<T, RequestBody> eVar) {
            this.f32934a = eVar;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, T t) {
            if (t != null) {
                try {
                    lVar.a(this.f32934a.a(t));
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }
}
