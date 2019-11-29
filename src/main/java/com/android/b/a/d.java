package com.android.b.a;

import com.android.b.l;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final HttpClient f4578a;

    /* access modifiers changed from: protected */
    public void a(HttpUriRequest httpUriRequest) throws IOException {
    }

    public d(HttpClient httpClient) {
        this.f4578a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    public HttpResponse a(l<?> lVar, Map<String, String> map) throws IOException, com.android.b.a {
        HttpUriRequest b2 = b(lVar, map);
        a(b2, map);
        a(b2, lVar.getHeaders());
        a(b2);
        HttpParams params = b2.getParams();
        int timeoutMs = lVar.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return FirebasePerfHttpClient.execute(this.f4578a, b2);
    }

    static HttpUriRequest b(l<?> lVar, Map<String, String> map) throws com.android.b.a {
        switch (lVar.getMethod()) {
            case -1:
                byte[] postBody = lVar.getPostBody();
                if (postBody == null) {
                    return new HttpGet(lVar.getUrl());
                }
                HttpPost httpPost = new HttpPost(lVar.getUrl());
                httpPost.addHeader(HttpConstants.Header.CONTENT_TYPE, lVar.getPostBodyContentType());
                httpPost.setEntity(new ByteArrayEntity(postBody));
                return httpPost;
            case 0:
                return new HttpGet(lVar.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(lVar.getUrl());
                httpPost2.addHeader(HttpConstants.Header.CONTENT_TYPE, lVar.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpPost2, lVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(lVar.getUrl());
                httpPut.addHeader(HttpConstants.Header.CONTENT_TYPE, lVar.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpPut, lVar);
                return httpPut;
            case 3:
                return new HttpDelete(lVar.getUrl());
            case 4:
                return new HttpHead(lVar.getUrl());
            case 5:
                return new HttpOptions(lVar.getUrl());
            case 6:
                return new HttpTrace(lVar.getUrl());
            case 7:
                a aVar = new a(lVar.getUrl());
                aVar.addHeader(HttpConstants.Header.CONTENT_TYPE, lVar.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) aVar, lVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, l<?> lVar) throws com.android.b.a {
        byte[] body = lVar.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    public static final class a extends HttpEntityEnclosingRequestBase {
        public String getMethod() {
            return "PATCH";
        }

        public a() {
        }

        public a(String str) {
            setURI(URI.create(str));
        }
    }
}
