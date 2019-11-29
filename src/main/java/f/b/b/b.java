package f.b.b;

import com.google.c.ad;
import f.e;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;

final class b<T extends ad> implements e<T, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    private static final MediaType f32901a = MediaType.parse("application/x-protobuf");

    b() {
    }

    public RequestBody a(T t) throws IOException {
        return RequestBody.create(f32901a, t.e());
    }
}
