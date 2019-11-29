package com.airbnb.lottie.d;

import android.content.Context;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.k;
import com.airbnb.lottie.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3660a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3661b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3662c;

    public static l<d> a(Context context, String str) {
        return new c(context, str).b();
    }

    private c(Context context, String str) {
        this.f3660a = context.getApplicationContext();
        this.f3661b = str;
        this.f3662c = new b(this.f3660a, str);
    }

    private l<d> b() {
        return new l<>(new Callable<k<d>>() {
            /* renamed from: a */
            public k<d> call() throws Exception {
                return c.this.a();
            }
        });
    }

    public k<d> a() {
        d c2 = c();
        if (c2 != null) {
            return new k<>(c2);
        }
        com.airbnb.lottie.c.a("Animation for " + this.f3661b + " not found in cache. Fetching from network.");
        return d();
    }

    private d c() {
        k<d> kVar;
        androidx.core.util.d<a, InputStream> a2 = this.f3662c.a();
        if (a2 == null) {
            return null;
        }
        a aVar = (a) a2.f1882a;
        InputStream inputStream = (InputStream) a2.f1883b;
        if (aVar == a.Zip) {
            kVar = e.a(new ZipInputStream(inputStream), this.f3661b);
        } else {
            kVar = e.a(inputStream, this.f3661b);
        }
        if (kVar.a() != null) {
            return kVar.a();
        }
        return null;
    }

    private k<d> d() {
        try {
            return e();
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    private k e() throws IOException {
        a aVar;
        k<d> kVar;
        com.airbnb.lottie.c.a("Fetching " + this.f3661b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f3661b).openConnection()));
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            char c2 = 65535;
            int hashCode = contentType.hashCode();
            boolean z = true;
            if (hashCode != -1248325150) {
                if (hashCode == -43840953 && contentType.equals(HttpConstants.ContentType.JSON)) {
                    c2 = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c2 = 0;
            }
            if (c2 != 0) {
                com.airbnb.lottie.c.a("Received json response.");
                aVar = a.Json;
                kVar = e.a((InputStream) new FileInputStream(new File(this.f3662c.a(httpURLConnection.getInputStream(), aVar).getAbsolutePath())), this.f3661b);
            } else {
                com.airbnb.lottie.c.a("Handling zip response.");
                aVar = a.Zip;
                kVar = e.a(new ZipInputStream(new FileInputStream(this.f3662c.a(httpURLConnection.getInputStream(), aVar))), this.f3661b);
            }
            if (kVar.a() != null) {
                this.f3662c.a(aVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Completed fetch from network. Success: ");
            if (kVar.a() == null) {
                z = false;
            }
            sb.append(z);
            com.airbnb.lottie.c.a(sb.toString());
            return kVar;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append(10);
            } else {
                return new k((Throwable) new IllegalArgumentException("Unable to fetch " + this.f3661b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + sb2));
            }
        }
    }
}
