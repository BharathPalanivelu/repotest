package com.squareup.a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.squareup.a.j;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ai implements j {

    /* renamed from: a  reason: collision with root package name */
    static volatile Object f30526a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f30527b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f30528c = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final Context f30529d;

    public ai(Context context) {
        this.f30529d = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    public j.a a(Uri uri, int i) throws IOException {
        String str;
        if (Build.VERSION.SDK_INT >= 14) {
            a(this.f30529d);
        }
        HttpURLConnection a2 = a(uri);
        a2.setUseCaches(true);
        if (i != 0) {
            if (s.isOfflineOnly(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = f30528c.get();
                sb.setLength(0);
                if (!s.shouldReadFromDiskCache(i)) {
                    sb.append("no-cache");
                }
                if (!s.shouldWriteToDiskCache(i)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                str = sb.toString();
            }
            a2.setRequestProperty(COSRequestHeaderKey.CACHE_CONTROL, str);
        }
        int responseCode = a2.getResponseCode();
        if (responseCode < 300) {
            long headerFieldInt = (long) a2.getHeaderFieldInt(HttpConstants.Header.CONTENT_LENGTH, -1);
            return new j.a(a2.getInputStream(), aj.a(a2.getHeaderField("X-Android-Response-Source")), headerFieldInt);
        }
        a2.disconnect();
        throw new j.b(responseCode + SQLBuilder.BLANK + a2.getResponseMessage(), i, responseCode);
    }

    private static void a(Context context) {
        if (f30526a == null) {
            try {
                synchronized (f30527b) {
                    if (f30526a == null) {
                        f30526a = a.a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    private static class a {
        static Object a(Context context) throws IOException {
            File b2 = aj.b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(b2, aj.a(b2)) : installed;
        }
    }
}
