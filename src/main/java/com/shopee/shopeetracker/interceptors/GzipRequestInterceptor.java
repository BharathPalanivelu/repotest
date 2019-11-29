package com.shopee.shopeetracker.interceptors;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import e.d;
import e.k;
import e.n;
import e.u;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class GzipRequestInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() == null || request.header(COSRequestHeaderKey.CONTENT_ENCODING) != null) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().header(COSRequestHeaderKey.CONTENT_ENCODING, "gzip").method(request.method(), gzip(request.body())).build());
    }

    private RequestBody gzip(final RequestBody requestBody) {
        return new RequestBody() {
            public long contentLength() {
                return -1;
            }

            public MediaType contentType() {
                return requestBody.contentType();
            }

            public void writeTo(d dVar) throws IOException {
                d a2 = n.a((u) new k(dVar));
                requestBody.writeTo(a2);
                a2.close();
            }
        };
    }
}
