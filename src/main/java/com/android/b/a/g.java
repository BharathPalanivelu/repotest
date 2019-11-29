package com.android.b.a;

import com.android.b.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final a f4579a;

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f4580b;

    public interface a {
        String a(String str);
    }

    public g() {
        this((a) null);
    }

    public g(a aVar) {
        this(aVar, (SSLSocketFactory) null);
    }

    public g(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f4579a = aVar;
        this.f4580b = sSLSocketFactory;
    }

    public HttpResponse a(l<?> lVar, Map<String, String> map) throws IOException, com.android.b.a {
        String str;
        String url = lVar.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(lVar.getHeaders());
        hashMap.putAll(map);
        a aVar = this.f4579a;
        if (aVar != null) {
            str = aVar.a(url);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
        } else {
            str = url;
        }
        HttpURLConnection a2 = a(new URL(str), lVar);
        for (String str2 : hashMap.keySet()) {
            a2.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        a(a2, lVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() != -1) {
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
            basicHttpResponse.setEntity(a(a2));
            for (Map.Entry entry : a2.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
                }
            }
            return basicHttpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    private HttpURLConnection a(URL url, l<?> lVar) throws IOException {
        HttpURLConnection a2 = a(url);
        int timeoutMs = lVar.getTimeoutMs();
        a2.setConnectTimeout(timeoutMs);
        a2.setReadTimeout(timeoutMs);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol())) {
            SSLSocketFactory sSLSocketFactory = this.f4580b;
            if (sSLSocketFactory != null) {
                ((HttpsURLConnection) a2).setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return a2;
    }

    static void a(HttpURLConnection httpURLConnection, l<?> lVar) throws IOException, com.android.b.a {
        switch (lVar.getMethod()) {
            case -1:
                byte[] postBody = lVar.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty(HttpConstants.Header.CONTENT_TYPE, lVar.getPostBodyContentType());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(postBody);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, lVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, lVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod(HttpConstants.RequestMethod.TRACE);
                return;
            case 7:
                b(httpURLConnection, lVar);
                httpURLConnection.setRequestMethod("PATCH");
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, l<?> lVar) throws IOException, com.android.b.a {
        byte[] body = lVar.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HttpConstants.Header.CONTENT_TYPE, lVar.getBodyContentType());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(body);
            dataOutputStream.close();
        }
    }
}
