package com.shopee.f.a.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static String f27239a = ("https://" + c.f27194a + "/v3/index.php?Action=");
    private static k h;

    /* renamed from: b  reason: collision with root package name */
    private String f27240b;

    /* renamed from: c  reason: collision with root package name */
    private OkHttpClient f27241c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f27242d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f27243e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f27244f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f27245g = 0;

    public static k a(String str, int i) {
        synchronized (k.class) {
            if (h == null) {
                h = new k(str, i);
            } else if (str != null && !TextUtils.isEmpty(str)) {
                h.a(str);
            }
        }
        return h;
    }

    private k(String str, int i) {
        this.f27240b = str;
        long j = (long) i;
        this.f27241c = new OkHttpClient().newBuilder().dns(new a()).connectTimeout(j, TimeUnit.SECONDS).readTimeout(j, TimeUnit.SECONDS).writeTimeout(j, TimeUnit.SECONDS).addNetworkInterceptor(new a()).build();
    }

    public void a(Callback callback) {
        String str = f27239a + "PrepareUploadUGC";
        Log.d("TVC-UGCClient", "PrepareUploadUGC->request url:" + str);
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("clientVersion", "1.0.10.2");
            jSONObject.put("signature", this.f27240b);
            str2 = jSONObject.toString();
            Log.d("TVC-UGCClient", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        FirebasePerfOkHttpClient.enqueue(this.f27241c.newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse(HttpConstants.ContentType.JSON), str2)).build()), callback);
    }

    public void a(String str, Callback callback) {
        String str2 = "http://" + str;
        Log.d("TVC-UGCClient", "detectDomain->request url:" + str2);
        FirebasePerfOkHttpClient.enqueue(this.f27241c.newCall(new Request.Builder().url(str2).method("HEAD", (RequestBody) null).build()), callback);
    }

    public int a(g gVar, String str, String str2, Callback callback) {
        String str3 = f27239a + "ApplyUploadUGC";
        Log.d("TVC-UGCClient", "initUploadUGC->request url:" + str3);
        String str4 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signature", this.f27240b);
            jSONObject.put("videoName", gVar.f());
            jSONObject.put("videoType", gVar.a());
            jSONObject.put("videoSize", gVar.h());
            if (gVar.e()) {
                jSONObject.put("coverName", gVar.g());
                jSONObject.put("coverType", gVar.c());
                jSONObject.put("coverSize", gVar.i());
            }
            jSONObject.put("clientReportId", str);
            jSONObject.put("clientVersion", "1.0.10.2");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("vodSessionKey", str2);
            }
            String c2 = j.a().c();
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("storageRegion", c2);
            }
            str4 = jSONObject.toString();
            Log.d("TVC-UGCClient", str4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RequestBody create = RequestBody.create(MediaType.parse(HttpConstants.ContentType.JSON), str4);
        this.f27243e = System.currentTimeMillis();
        Request build = new Request.Builder().url(str3).post(create).build();
        if (e.a()) {
            final String host = build.url().host();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String unused = k.this.f27242d = InetAddress.getByName(host).getHostAddress();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
        }
        FirebasePerfOkHttpClient.enqueue(this.f27241c.newCall(build), callback);
        return 0;
    }

    public int a(String str, String str2, String str3, Callback callback) {
        String str4 = f27239a + "CommitUploadUGC";
        Log.d("TVC-UGCClient", "finishUploadUGC->request url:" + str4);
        String str5 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signature", this.f27240b);
            jSONObject.put("clientReportId", str2);
            jSONObject.put("clientVersion", "1.0.10.2");
            jSONObject.put("vodSessionKey", str3);
            str5 = jSONObject.toString();
            Log.d("TVC-UGCClient", str5);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RequestBody create = RequestBody.create(MediaType.parse(HttpConstants.ContentType.JSON), str5);
        this.f27243e = System.currentTimeMillis();
        Request build = new Request.Builder().url(str4).post(create).build();
        if (e.a()) {
            final String host = build.url().host();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String unused = k.this.f27242d = InetAddress.getByName(host).getHostAddress();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
        }
        FirebasePerfOkHttpClient.enqueue(this.f27241c.newCall(build), callback);
        return 0;
    }

    public String a() {
        return this.f27242d;
    }

    public long b() {
        return this.f27244f;
    }

    public long c() {
        return this.f27245g;
    }

    public void a(String str) {
        this.f27240b = str;
    }

    private class a implements Interceptor {
        private a() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("TVC-UGCClient", "Sending request " + request.url() + " on " + chain.connection() + "\n" + request.headers());
            if (!e.a()) {
                String unused = k.this.f27242d = chain.connection().route().socketAddress().getAddress().getHostAddress();
            }
            k kVar = k.this;
            long unused2 = kVar.f27244f = currentTimeMillis - kVar.f27243e;
            Response proceed = chain.proceed(request);
            long unused3 = k.this.f27245g = System.currentTimeMillis() - currentTimeMillis;
            Log.d("TVC-UGCClient", "Received response for " + proceed.request().url() + " in " + k.this.f27245g + "ms\n" + proceed.headers());
            return proceed;
        }
    }
}
