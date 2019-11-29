package com.linecorp.linesdk.a.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.b;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f15002a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private final e f15003b;

    /* renamed from: c  reason: collision with root package name */
    private final d f15004c;

    /* renamed from: d  reason: collision with root package name */
    private int f15005d;

    /* renamed from: e  reason: collision with root package name */
    private int f15006e;

    public a(Context context, String str) {
        this(new e(context, str));
    }

    private a(e eVar) {
        this.f15003b = eVar;
        this.f15004c = new d("UTF-8");
        this.f15005d = 90000;
        this.f15006e = 90000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> com.linecorp.linesdk.a<T> a(android.net.Uri r6, java.util.Map<java.lang.String, java.lang.String> r7, java.util.Map<java.lang.String, java.lang.String> r8, com.linecorp.linesdk.a.a.a.c<T> r9) {
        /*
            r5 = this;
            byte[] r8 = a((java.util.Map<java.lang.String, java.lang.String>) r8)
            r0 = 0
            int r1 = r8.length     // Catch:{ IOException -> 0x0066 }
            java.net.HttpURLConnection r6 = a((android.net.Uri) r6)     // Catch:{ IOException -> 0x0066 }
            r2 = 1
            r6.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r3 = "User-Agent"
            com.linecorp.linesdk.a.a.a.e r4 = r5.f15003b     // Catch:{ IOException -> 0x0066 }
            java.lang.String r4 = r4.a()     // Catch:{ IOException -> 0x0066 }
            r6.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "gzip"
            r6.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/x-www-form-urlencoded"
            r6.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r3 = "Content-Length"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0066 }
            r6.setRequestProperty(r3, r1)     // Catch:{ IOException -> 0x0066 }
            int r1 = r5.f15005d     // Catch:{ IOException -> 0x0066 }
            r6.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0066 }
            int r1 = r5.f15006e     // Catch:{ IOException -> 0x0066 }
            r6.setReadTimeout(r1)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r1 = "POST"
            r6.setRequestMethod(r1)     // Catch:{ IOException -> 0x0066 }
            r6.setDoOutput(r2)     // Catch:{ IOException -> 0x0066 }
            a(r6, r7)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r6.connect()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            java.io.OutputStream r7 = r6.getOutputStream()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r7.write(r8)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r7.flush()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            com.linecorp.linesdk.a.a.a.d r7 = r5.f15004c     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            com.linecorp.linesdk.a r7 = a(r6, r9, r7)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            if (r6 == 0) goto L_0x005d
            r6.disconnect()
        L_0x005d:
            return r7
        L_0x005e:
            r7 = move-exception
            r0 = r6
            goto L_0x0078
        L_0x0061:
            r7 = move-exception
            r0 = r6
            goto L_0x0067
        L_0x0064:
            r7 = move-exception
            goto L_0x0078
        L_0x0066:
            r7 = move-exception
        L_0x0067:
            com.linecorp.linesdk.b r6 = com.linecorp.linesdk.b.NETWORK_ERROR     // Catch:{ all -> 0x0064 }
            com.linecorp.linesdk.LineApiError r8 = new com.linecorp.linesdk.LineApiError     // Catch:{ all -> 0x0064 }
            r8.<init>((java.lang.Exception) r7)     // Catch:{ all -> 0x0064 }
            com.linecorp.linesdk.a r6 = com.linecorp.linesdk.a.a(r6, r8)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0077
            r0.disconnect()
        L_0x0077:
            return r6
        L_0x0078:
            if (r0 == 0) goto L_0x007d
            r0.disconnect()
        L_0x007d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linecorp.linesdk.a.a.a.a.a(android.net.Uri, java.util.Map, java.util.Map, com.linecorp.linesdk.a.a.a.c):com.linecorp.linesdk.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> com.linecorp.linesdk.a<T> b(android.net.Uri r3, java.util.Map<java.lang.String, java.lang.String> r4, java.util.Map<java.lang.String, java.lang.String> r5, com.linecorp.linesdk.a.a.a.c<T> r6) {
        /*
            r2 = this;
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x000c:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.appendQueryParameter(r1, r0)
            goto L_0x000c
        L_0x0028:
            r5 = 0
            android.net.Uri r3 = r3.build()     // Catch:{ IOException -> 0x0070 }
            java.net.HttpURLConnection r3 = a((android.net.Uri) r3)     // Catch:{ IOException -> 0x0070 }
            r0 = 1
            r3.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x0070 }
            java.lang.String r0 = "User-Agent"
            com.linecorp.linesdk.a.a.a.e r1 = r2.f15003b     // Catch:{ IOException -> 0x0070 }
            java.lang.String r1 = r1.a()     // Catch:{ IOException -> 0x0070 }
            r3.setRequestProperty(r0, r1)     // Catch:{ IOException -> 0x0070 }
            java.lang.String r0 = "Accept-Encoding"
            java.lang.String r1 = "gzip"
            r3.setRequestProperty(r0, r1)     // Catch:{ IOException -> 0x0070 }
            int r0 = r2.f15005d     // Catch:{ IOException -> 0x0070 }
            r3.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0070 }
            int r0 = r2.f15006e     // Catch:{ IOException -> 0x0070 }
            r3.setReadTimeout(r0)     // Catch:{ IOException -> 0x0070 }
            java.lang.String r0 = "GET"
            r3.setRequestMethod(r0)     // Catch:{ IOException -> 0x0070 }
            a(r3, r4)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r3.connect()     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            com.linecorp.linesdk.a.a.a.d r4 = r2.f15004c     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            com.linecorp.linesdk.a r4 = a(r3, r6, r4)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            if (r3 == 0) goto L_0x0067
            r3.disconnect()
        L_0x0067:
            return r4
        L_0x0068:
            r4 = move-exception
            r5 = r3
            goto L_0x0082
        L_0x006b:
            r4 = move-exception
            r5 = r3
            goto L_0x0071
        L_0x006e:
            r4 = move-exception
            goto L_0x0082
        L_0x0070:
            r4 = move-exception
        L_0x0071:
            com.linecorp.linesdk.b r3 = com.linecorp.linesdk.b.NETWORK_ERROR     // Catch:{ all -> 0x006e }
            com.linecorp.linesdk.LineApiError r6 = new com.linecorp.linesdk.LineApiError     // Catch:{ all -> 0x006e }
            r6.<init>((java.lang.Exception) r4)     // Catch:{ all -> 0x006e }
            com.linecorp.linesdk.a r3 = com.linecorp.linesdk.a.a(r3, r6)     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x0081
            r5.disconnect()
        L_0x0081:
            return r3
        L_0x0082:
            if (r5 == 0) goto L_0x0087
            r5.disconnect()
        L_0x0087:
            goto L_0x0089
        L_0x0088:
            throw r4
        L_0x0089:
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: com.linecorp.linesdk.a.a.a.a.b(android.net.Uri, java.util.Map, java.util.Map, com.linecorp.linesdk.a.a.a.c):com.linecorp.linesdk.a");
    }

    private static HttpURLConnection a(Uri uri) {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection());
        if (!(uRLConnection instanceof HttpsURLConnection)) {
            throw new IllegalArgumentException("The scheme of the server url must be https." + uri);
        } else if (Build.VERSION.SDK_INT >= 24) {
            return (HttpURLConnection) uRLConnection;
        } else {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            httpsURLConnection.setSSLSocketFactory(new com.linecorp.a.a.a(httpsURLConnection.getSSLSocketFactory()));
            return httpsURLConnection;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
    }

    private static byte[] a(Map<String, String> map) {
        if (map.isEmpty()) {
            return f15002a;
        }
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        try {
            return builder.build().getEncodedQuery().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static <T> com.linecorp.linesdk.a<T> a(HttpURLConnection httpURLConnection, c<T> cVar, c<String> cVar2) {
        GZIPInputStream gZIPInputStream;
        if (httpURLConnection.getResponseCode() < 400) {
            gZIPInputStream = httpURLConnection.getInputStream();
        } else {
            gZIPInputStream = httpURLConnection.getErrorStream();
        }
        List list = (List) httpURLConnection.getHeaderFields().get(COSRequestHeaderKey.CONTENT_ENCODING);
        boolean z = false;
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (((String) list.get(i)).equalsIgnoreCase("gzip")) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (z) {
            gZIPInputStream = new GZIPInputStream(gZIPInputStream);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return com.linecorp.linesdk.a.a(cVar.a(gZIPInputStream));
        }
        try {
            return com.linecorp.linesdk.a.a(b.SERVER_ERROR, new LineApiError(responseCode, cVar2.a(gZIPInputStream)));
        } catch (IOException e2) {
            return com.linecorp.linesdk.a.a(b.INTERNAL_ERROR, new LineApiError(responseCode, (Exception) e2));
        }
    }
}
