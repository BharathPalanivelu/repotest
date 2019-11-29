package f.b.b;

import com.google.c.ad;
import com.google.c.aj;
import com.google.c.p;
import com.google.c.v;
import f.e;
import java.io.IOException;
import okhttp3.ResponseBody;

final class c<T extends ad> implements e<ResponseBody, T> {

    /* renamed from: a  reason: collision with root package name */
    private final aj<T> f32902a;

    /* renamed from: b  reason: collision with root package name */
    private final p f32903b;

    c(aj<T> ajVar, p pVar) {
        this.f32902a = ajVar;
        this.f32903b = pVar;
    }

    public T a(ResponseBody responseBody) throws IOException {
        try {
            T t = (ad) this.f32902a.c(responseBody.byteStream(), this.f32903b);
            responseBody.close();
            return t;
        } catch (v e2) {
            throw new RuntimeException(e2);
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
