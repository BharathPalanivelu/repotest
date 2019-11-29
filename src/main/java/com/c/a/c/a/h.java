package com.c.a.c.a;

import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.c.a.c.a.b;
import com.c.a.c.c.g;
import com.c.a.c.e;
import com.c.a.i.d;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class h implements b<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    static final b f5663a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final g f5664b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5665c;

    /* renamed from: d  reason: collision with root package name */
    private final b f5666d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f5667e;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f5668f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f5669g;

    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public h(g gVar, int i) {
        this(gVar, i, f5663a);
    }

    h(g gVar, int i, b bVar) {
        this.f5664b = gVar;
        this.f5665c = i;
        this.f5666d = bVar;
    }

    public void a(com.c.a.g gVar, b.a<? super InputStream> aVar) {
        long a2 = d.a();
        try {
            InputStream a3 = a(this.f5664b.a(), 0, (URL) null, this.f5664b.b());
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + d.a(a2) + " ms and loaded " + a3);
            }
            aVar.a(a3);
        } catch (IOException e2) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f5667e = this.f5666d.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.f5667e.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f5667e.setConnectTimeout(this.f5665c);
            this.f5667e.setReadTimeout(this.f5665c);
            this.f5667e.setUseCaches(false);
            this.f5667e.setDoInput(true);
            this.f5667e.setInstanceFollowRedirects(false);
            this.f5667e.connect();
            this.f5668f = this.f5667e.getInputStream();
            if (this.f5669g) {
                return null;
            }
            int responseCode = this.f5667e.getResponseCode();
            int i2 = responseCode / 100;
            if (i2 == 2) {
                return a(this.f5667e);
            }
            if (i2 == 3) {
                String headerField = this.f5667e.getHeaderField(Constants.HTTP_REDIRECT_URL_HEADER_FIELD);
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    a();
                    return a(url3, i + 1, url, map);
                }
                throw new e("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new e(responseCode);
            } else {
                throw new e(this.f5667e.getResponseMessage(), responseCode);
            }
        } else {
            throw new e("Too many (> 5) redirects!");
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f5668f = com.c.a.i.b.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f5668f = httpURLConnection.getInputStream();
        }
        return this.f5668f;
    }

    public void a() {
        InputStream inputStream = this.f5668f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f5667e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f5667e = null;
    }

    public void b() {
        this.f5669g = true;
    }

    public Class<InputStream> d() {
        return InputStream.class;
    }

    public com.c.a.c.a c() {
        return com.c.a.c.a.REMOTE;
    }

    private static class a implements b {
        a() {
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        }
    }
}
