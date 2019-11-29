package f.b.a;

import com.google.a.f;
import com.google.a.w;
import e.c;
import f.e;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;

final class b<T> implements e<T, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    private static final MediaType f32894a = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f32895b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private final f f32896c;

    /* renamed from: d  reason: collision with root package name */
    private final w<T> f32897d;

    b(f fVar, w<T> wVar) {
        this.f32896c = fVar;
        this.f32897d = wVar;
    }

    /* renamed from: b */
    public RequestBody a(T t) throws IOException {
        c cVar = new c();
        com.google.a.d.c a2 = this.f32896c.a((Writer) new OutputStreamWriter(cVar.c(), f32895b));
        this.f32897d.write(a2, t);
        a2.close();
        return RequestBody.create(f32894a, cVar.r());
    }
}
