package f.b.a;

import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.f;
import com.google.a.m;
import com.google.a.w;
import f.e;
import java.io.IOException;
import okhttp3.ResponseBody;

final class c<T> implements e<ResponseBody, T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f32898a;

    /* renamed from: b  reason: collision with root package name */
    private final w<T> f32899b;

    c(f fVar, w<T> wVar) {
        this.f32898a = fVar;
        this.f32899b = wVar;
    }

    public T a(ResponseBody responseBody) throws IOException {
        a a2 = this.f32898a.a(responseBody.charStream());
        try {
            T read = this.f32899b.read(a2);
            if (a2.f() == b.END_DOCUMENT) {
                return read;
            }
            throw new m("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
