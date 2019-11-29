package okhttp3.internal.http;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import e.l;
import e.n;
import e.v;
import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;

public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        this.cookieJar = cookieJar2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header(HttpConstants.Header.CONTENT_TYPE, contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header(HttpConstants.Header.CONTENT_LENGTH, Long.toString(contentLength));
                newBuilder.removeHeader(HttpConstants.Header.TRANSFER_ENCODING);
            } else {
                newBuilder.header(HttpConstants.Header.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader(HttpConstants.Header.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.header(HttpConstants.Header.HOST) == null) {
            newBuilder.header(HttpConstants.Header.HOST, Util.hostHeader(request.url(), false));
        }
        if (request.header(HttpConstants.Header.CONNECTION) == null) {
            newBuilder.header(HttpConstants.Header.CONNECTION, "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            z = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", cookieHeader(loadForRequest));
        }
        if (request.header(HttpConstants.Header.USER_AGENT) == null) {
            newBuilder.header(HttpConstants.Header.USER_AGENT, Version.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header(COSRequestHeaderKey.CONTENT_ENCODING)) && HttpHeaders.hasBody(proceed)) {
            l lVar = new l(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll(COSRequestHeaderKey.CONTENT_ENCODING).removeAll(HttpConstants.Header.CONTENT_LENGTH).build());
            request2.body(new RealResponseBody(proceed.header(HttpConstants.Header.CONTENT_TYPE), -1, n.a((v) lVar)));
        }
        return request2.build();
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }
}
