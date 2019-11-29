package f;

import com.tencent.qcloud.core.http.HttpConstants;
import e.c;
import e.d;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f32960a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private final String f32961b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpUrl f32962c;

    /* renamed from: d  reason: collision with root package name */
    private String f32963d;

    /* renamed from: e  reason: collision with root package name */
    private HttpUrl.Builder f32964e;

    /* renamed from: f  reason: collision with root package name */
    private final Request.Builder f32965f = new Request.Builder();

    /* renamed from: g  reason: collision with root package name */
    private MediaType f32966g;
    private final boolean h;
    private MultipartBody.Builder i;
    private FormBody.Builder j;
    private RequestBody k;

    l(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f32961b = str;
        this.f32962c = httpUrl;
        this.f32963d = str2;
        this.f32966g = mediaType;
        this.h = z;
        if (headers != null) {
            this.f32965f.headers(headers);
        }
        if (z2) {
            this.j = new FormBody.Builder();
        } else if (z3) {
            this.i = new MultipartBody.Builder();
            this.i.setType(MultipartBody.FORM);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        this.f32963d = obj.toString();
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (HttpConstants.Header.CONTENT_TYPE.equalsIgnoreCase(str)) {
            MediaType parse = MediaType.parse(str2);
            if (parse != null) {
                this.f32966g = parse;
                return;
            }
            throw new IllegalArgumentException("Malformed content type: " + str2);
        }
        this.f32965f.addHeader(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) {
        String str3 = this.f32963d;
        if (str3 != null) {
            this.f32963d = str3.replace("{" + str + "}", a(str2, z));
            return;
        }
        throw new AssertionError();
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                c cVar = new c();
                cVar.a(str, 0, i2);
                a(cVar, str, i2, length, z);
                return cVar.s();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void a(c cVar, String str, int i2, int i3, boolean z) {
        c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    cVar2.a(codePointAt);
                    while (!cVar2.f()) {
                        byte i4 = cVar2.i() & 255;
                        cVar.k(37);
                        cVar.k((int) f32960a[(i4 >> 4) & 15]);
                        cVar.k((int) f32960a[i4 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str, String str2, boolean z) {
        String str3 = this.f32963d;
        if (str3 != null) {
            this.f32964e = this.f32962c.newBuilder(str3);
            if (this.f32964e != null) {
                this.f32963d = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f32962c + ", Relative: " + this.f32963d);
            }
        }
        if (z) {
            this.f32964e.addEncodedQueryParameter(str, str2);
        } else {
            this.f32964e.addQueryParameter(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(String str, String str2, boolean z) {
        if (z) {
            this.j.addEncoded(str, str2);
        } else {
            this.j.add(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Headers headers, RequestBody requestBody) {
        this.i.addPart(headers, requestBody);
    }

    /* access modifiers changed from: package-private */
    public void a(MultipartBody.Part part) {
        this.i.addPart(part);
    }

    /* access modifiers changed from: package-private */
    public void a(RequestBody requestBody) {
        this.k = requestBody;
    }

    /* access modifiers changed from: package-private */
    public Request a() {
        HttpUrl httpUrl;
        HttpUrl.Builder builder = this.f32964e;
        if (builder != null) {
            httpUrl = builder.build();
        } else {
            httpUrl = this.f32962c.resolve(this.f32963d);
            if (httpUrl == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f32962c + ", Relative: " + this.f32963d);
            }
        }
        a aVar = this.k;
        if (aVar == null) {
            FormBody.Builder builder2 = this.j;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.i;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.h) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f32966g;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f32965f.addHeader(HttpConstants.Header.CONTENT_TYPE, mediaType.toString());
            }
        }
        return this.f32965f.url(httpUrl).method(this.f32961b, aVar).build();
    }

    private static class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        private final RequestBody f32967a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaType f32968b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.f32967a = requestBody;
            this.f32968b = mediaType;
        }

        public MediaType contentType() {
            return this.f32968b;
        }

        public long contentLength() throws IOException {
            return this.f32967a.contentLength();
        }

        public void writeTo(d dVar) throws IOException {
            this.f32967a.writeTo(dVar);
        }
    }
}
