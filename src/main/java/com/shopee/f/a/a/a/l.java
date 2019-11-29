package com.shopee.f.a.a.a;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f27251a;

    /* renamed from: b  reason: collision with root package name */
    private Context f27252b;

    /* renamed from: c  reason: collision with root package name */
    private OkHttpClient f27253c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<a> f27254d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private TimerTask f27255e = null;

    /* renamed from: f  reason: collision with root package name */
    private Timer f27256f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27260a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f27261b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f27262c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f27263d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f27264e = "";

        /* renamed from: f  reason: collision with root package name */
        public long f27265f = 0;

        /* renamed from: g  reason: collision with root package name */
        public long f27266g = 0;
        public long h = 0;
        public String i = "";
        public String j = "";
        public String k = "";
        public int l = 0;
        public String m = "";
        public int n = 0;
        public String o = "";
        public String p = "";
        public String q = "";
        public String r = "";
        public int s = 0;
        public long t = 0;
        public long u = 0;
        public int v = 0;
        public boolean w = false;

        public a() {
        }

        public a(a aVar) {
            this.f27260a = aVar.f27260a;
            this.f27261b = aVar.f27261b;
            this.f27264e = aVar.f27264e;
            this.f27262c = aVar.f27262c;
            this.f27263d = aVar.f27263d;
            this.f27265f = aVar.f27265f;
            this.f27266g = aVar.f27266g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.q = aVar.q;
            this.r = aVar.r;
            this.s = aVar.s;
            this.t = aVar.t;
            this.u = aVar.u;
            this.v = 0;
            this.w = false;
        }
    }

    public static l a(Context context) {
        if (f27251a == null) {
            synchronized (l.class) {
                if (f27251a == null) {
                    f27251a = new l(context);
                }
            }
        }
        return f27251a;
    }

    private l(Context context) {
        this.f27252b = context;
        this.f27253c = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
        this.f27255e = new TimerTask() {
            public void run() {
                l.this.a();
            }
        };
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        if (i.f(this.f27252b)) {
            synchronized (this.f27254d) {
                Iterator<a> it = this.f27254d.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.v >= 4) {
                        it.remove();
                    } else if (!next.w) {
                        b(next);
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        if (this.f27256f == null) {
            this.f27256f = new Timer(true);
            this.f27256f.schedule(this.f27255e, 0, 10000);
        }
        a aVar2 = new a(aVar);
        synchronized (this.f27254d) {
            if (this.f27254d.size() > 100) {
                this.f27254d.remove(0);
            }
            this.f27254d.add(aVar2);
        }
        a();
    }

    public void b(final a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "1.0.10.2");
            jSONObject.put("reqType", aVar.f27260a);
            jSONObject.put("errCode", aVar.f27261b);
            jSONObject.put("vodErrCode", aVar.f27262c);
            jSONObject.put("cosErrCode", aVar.f27263d);
            jSONObject.put("errMsg", aVar.f27264e);
            jSONObject.put("reqTimeCost", aVar.f27266g);
            jSONObject.put("reqServerIp", aVar.m);
            jSONObject.put("useHttpDNS", aVar.n);
            jSONObject.put("platform", 2000);
            jSONObject.put("device", Build.MANUFACTURER + Build.MODEL);
            jSONObject.put("osType", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("netType", i.g(this.f27252b));
            jSONObject.put("reqTime", aVar.f27265f);
            jSONObject.put("reportId", aVar.o);
            jSONObject.put("uuid", i.e(this.f27252b));
            jSONObject.put("reqKey", aVar.p);
            jSONObject.put("appId", aVar.l);
            jSONObject.put("fileSize", aVar.h);
            jSONObject.put("fileType", aVar.i);
            jSONObject.put("fileName", aVar.j);
            jSONObject.put("vodSessionKey", aVar.q);
            jSONObject.put("fileId", aVar.k);
            jSONObject.put("cosRegion", aVar.r);
            jSONObject.put("useCosAcc", aVar.s);
            jSONObject.put("tcpConnTimeCost", aVar.t);
            jSONObject.put("recvRespTimeCost", aVar.u);
            jSONObject.put("packageName", i.h(this.f27252b));
            jSONObject.put("appName", i.i(this.f27252b));
            aVar.v++;
            aVar.w = true;
            String jSONObject2 = jSONObject.toString();
            Log.i("TVC-UGCReport", "reportUGCEvent->request url:" + "https://vodreport.qcloud.com/ugcupload_new" + " body:" + jSONObject2);
            FirebasePerfOkHttpClient.enqueue(this.f27253c.newCall(new Request.Builder().url("https://vodreport.qcloud.com/ugcupload_new").post(RequestBody.create(MediaType.parse(HttpConstants.ContentType.JSON), jSONObject2)).build()), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    aVar.w = false;
                }

                public void onResponse(Call call, Response response) throws IOException {
                    if (response == null || !response.isSuccessful()) {
                        aVar.w = false;
                        return;
                    }
                    synchronized (l.this.f27254d) {
                        l.this.f27254d.remove(aVar);
                    }
                }
            });
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
