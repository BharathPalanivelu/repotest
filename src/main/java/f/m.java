package f;

import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class m<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Response f32969a;

    /* renamed from: b  reason: collision with root package name */
    private final T f32970b;

    /* renamed from: c  reason: collision with root package name */
    private final ResponseBody f32971c;

    public static <T> m<T> a(T t, Response response) {
        p.a(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new m<>(response, t, (ResponseBody) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> m<T> a(ResponseBody responseBody, Response response) {
        p.a(responseBody, "body == null");
        p.a(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new m<>(response, (Object) null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private m(Response response, T t, ResponseBody responseBody) {
        this.f32969a = response;
        this.f32970b = t;
        this.f32971c = responseBody;
    }

    public int a() {
        return this.f32969a.code();
    }

    public String b() {
        return this.f32969a.message();
    }

    public Headers c() {
        return this.f32969a.headers();
    }

    public boolean d() {
        return this.f32969a.isSuccessful();
    }

    public T e() {
        return this.f32970b;
    }

    public String toString() {
        return this.f32969a.toString();
    }
}
