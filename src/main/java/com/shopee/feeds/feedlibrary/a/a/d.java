package com.shopee.feeds.feedlibrary.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.a.f;
import com.google.a.g;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.sdk.b;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f27289a = MediaType.parse(LiveAgentRequest.HEADER_ACCEPT_VALUE);

    /* renamed from: b  reason: collision with root package name */
    public static int f27290b = 30;

    /* renamed from: c  reason: collision with root package name */
    public static int f27291c = 30;

    /* renamed from: d  reason: collision with root package name */
    public static int f27292d = 30;
    private static OkHttpClient y = b.a().g().a();
    /* access modifiers changed from: private */
    public static Handler z = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.a.b f27293e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f27294f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27295g;
    private Object h;
    private String i;
    private String j;
    private int k;
    private String l;
    private Map<String, String> m;
    private CacheControl n;
    private String o;
    private Map<String, String> p;
    /* access modifiers changed from: private */
    public b q;
    private String r;
    /* access modifiers changed from: private */
    public int s;
    private Map<String, String> t;
    private boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    private a<c> w;
    private a<Object> x;

    public d(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2, boolean z2, boolean z3, b bVar, String str3, int i2, boolean z4, Object obj, a aVar, a aVar2, Map<String, String> map3, String str4, CacheControl cacheControl, int i3, String str5) {
        boolean z5 = z2;
        this.f27294f = context;
        this.i = str;
        this.l = str2;
        this.p = map;
        this.m = map2;
        this.u = z5;
        this.q = bVar;
        this.v = z3;
        this.r = str3;
        this.s = i2;
        this.w = aVar;
        this.x = aVar2;
        this.n = cacheControl;
        this.t = map3;
        this.o = str4;
        this.k = i3;
        this.j = str5;
        this.f27295g = z4;
        this.h = obj;
        if (z5) {
            this.f27293e = new com.shopee.feeds.feedlibrary.a.b(context);
        }
    }

    public void a() {
        Request request;
        if (this.u) {
            this.f27293e.a(this.f27294f);
        }
        if ("get".equals(this.j)) {
            request = b();
        } else if ("feeds_post".equals(this.j)) {
            request = c();
        } else {
            request = "put".equals(this.j) ? d() : null;
        }
        a(request, (a) this.w);
    }

    public void a(Request request, a aVar) {
        if (this.j.equals("get")) {
            a(request, aVar, false);
            return;
        }
        int i2 = this.k;
        if (i2 == 1) {
            a(request, aVar, true, true);
        } else if (i2 == 2) {
            a(request, aVar, true, false);
        } else if (i2 == 3) {
            a(request, aVar, false);
        } else if (i2 == 4) {
            a(request, aVar, true);
        } else if (i2 == 5) {
            a(request, aVar, false, false);
        }
    }

    public void a(Request request, a aVar, boolean z2, boolean z3) {
        final a aVar2 = aVar;
        final boolean z4 = z2;
        final Request request2 = request;
        final boolean z5 = z3;
        y.dispatcher().executorService().submit(new Runnable() {
            public void run() {
                d.this.g();
                final c a2 = d.this.q.a(d.this.j());
                if (d.this.v) {
                    d.z.post(new Runnable() {
                        public void run() {
                            if (a2 != null) {
                                d.this.a(aVar2, a2, "from_cache");
                            }
                            if (z4) {
                                d.this.a(request2, aVar2, z5);
                            }
                        }
                    });
                    return;
                }
                if (a2 != null) {
                    d.this.a(aVar2, a2, "from_cache");
                }
                if (z4) {
                    d.z.post(new Runnable() {
                        public void run() {
                            d.this.a(request2, aVar2, z5);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.u) {
            z.post(new Runnable() {
                public void run() {
                    d.this.f27293e.b(d.this.f27294f);
                }
            });
        }
    }

    public Request b() {
        Request.Builder e2 = e();
        e2.get();
        return e2.build();
    }

    public Request c() {
        Request.Builder e2 = e();
        if (this.f27295g) {
            e2.post(h());
        } else {
            e2.post(i());
        }
        return e2.build();
    }

    public Request d() {
        Request.Builder e2 = e();
        e2.put(i());
        return e2.build();
    }

    public Request.Builder e() {
        Request.Builder builder = new Request.Builder();
        builder.url(this.i);
        a(builder, this.p);
        a(builder, this.n);
        a(builder, this.o);
        return builder;
    }

    private Request.Builder a(Request.Builder builder, CacheControl cacheControl) {
        builder.cacheControl(cacheControl);
        return builder;
    }

    private Request.Builder a(Request.Builder builder, String str) {
        if (str == null) {
            return builder;
        }
        builder.tag(str);
        return builder;
    }

    private RequestBody h() {
        if (this.h == null) {
            return null;
        }
        g gVar = new g();
        gVar.c();
        RequestBody create = RequestBody.create(f27289a, gVar.d().b(this.h));
        a(this.h);
        return create;
    }

    private RequestBody i() {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        Map<String, String> map = this.m;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                builder.setType(MultipartBody.FORM).addFormDataPart((String) next.getKey(), (String) next.getValue());
            }
            Map<String, String> map2 = this.t;
            if (map2 != null) {
                for (Map.Entry<String, String> value : map2.entrySet()) {
                    File file = new File(q.b((String) value.getValue()));
                    if (file.exists()) {
                        builder.addFormDataPart(UriUtil.LOCAL_FILE_SCHEME, file.getName(), RequestBody.create(MediaType.parse(COSRequestHeaderKey.APPLICATION_OCTET_STREAM), file));
                    }
                }
            }
        }
        return builder.build();
    }

    private Request.Builder a(Request.Builder builder, Map<String, String> map) {
        if (map == null) {
            return builder;
        }
        for (Map.Entry next : map.entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        return builder;
    }

    public void a(Request request, final a aVar, final boolean z2) {
        FirebasePerfOkHttpClient.enqueue(y.newCall(request), new Callback() {
            public void onFailure(Call call, IOException iOException) {
                d.this.g();
                d.z.post(new Runnable() {
                    public void run() {
                        u.a(d.this.f27294f, com.garena.android.appkit.tools.b.e(c.g.feeds_network_error_toast));
                    }
                });
                a aVar = aVar;
                if (aVar != null) {
                    d.this.a(aVar, -1, "");
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                String str;
                d.this.g();
                ResponseBody body = response.body();
                if (body == null) {
                    d.this.a(aVar, -2, (String) null);
                }
                String string = body.string();
                if (string == null) {
                    d.this.a(aVar, -3, (String) null);
                } else if (!com.shopee.feeds.feedlibrary.util.d.a(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        c cVar = new c();
                        int i = -1;
                        if (jSONObject.has("code")) {
                            i = jSONObject.getInt("code");
                        } else if (jSONObject.has("status")) {
                            i = jSONObject.getInt("status");
                        } else if (jSONObject.has("error")) {
                            i = jSONObject.getInt("error");
                        }
                        cVar.a(i);
                        String str2 = "";
                        if (jSONObject.has("msg")) {
                            str2 = jSONObject.getString("msg");
                        } else if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                            str2 = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                        } else if (jSONObject.has("error_msg")) {
                            str2 = jSONObject.getString("error_msg");
                        }
                        cVar.a(str2);
                        String string2 = jSONObject.has("data") ? jSONObject.getString("data") : null;
                        if (string2 == null) {
                            str = null;
                        } else {
                            str = string2.toString();
                        }
                        cVar.b(str);
                        if (d.this.a(i, str2, aVar)) {
                            if (z2) {
                                if (d.this.s > 0) {
                                    d.this.q.a(d.this.j(), cVar, d.this.s);
                                } else {
                                    d.this.q.a(d.this.j(), cVar);
                                }
                            }
                            d.this.a(aVar, cVar, "from_network");
                        }
                    } catch (JSONException e2) {
                        d.this.a(aVar, -4, (String) null);
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String j() {
        String str = this.r;
        return str == null ? this.i : str;
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, String str, a aVar) {
        if (i2 == 0) {
            return true;
        }
        a(aVar, i2, str);
        return false;
    }

    public void a(final a aVar, final int i2, final String str) {
        if (this.v) {
            z.post(new Runnable() {
                public void run() {
                    aVar.a(i2, str);
                }
            });
        } else if (aVar != null) {
            aVar.a(i2, str);
        }
    }

    public void a(final a aVar, final c cVar, final String str) {
        if (this.v) {
            z.post(new Runnable() {
                public void run() {
                    aVar.a(cVar, str);
                }
            });
        } else {
            aVar.a(cVar, str);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f27317a;

        /* renamed from: b  reason: collision with root package name */
        private String f27318b;

        /* renamed from: c  reason: collision with root package name */
        private String f27319c;

        /* renamed from: d  reason: collision with root package name */
        private int f27320d;

        /* renamed from: e  reason: collision with root package name */
        private Map<String, String> f27321e;

        /* renamed from: f  reason: collision with root package name */
        private CacheControl f27322f;

        /* renamed from: g  reason: collision with root package name */
        private String f27323g;
        private Map<String, String> h;
        private b i;
        private String j;
        private int k;
        private Map<String, String> l;
        private boolean m;
        private boolean n;
        private a<c> o;
        private a<Object> p;
        private boolean q;
        private Object r;

        public a(Context context) {
            this.f27317a = context;
        }

        public a a(String str) {
            if (str != null) {
                this.f27318b = str;
                return this;
            }
            throw new NullPointerException("请求链接不能为空");
        }

        public a a(a<c> aVar) {
            this.o = aVar;
            return this;
        }

        public a a() {
            this.f27319c = "feeds_post";
            return this;
        }

        public a b() {
            this.f27319c = "get";
            return this;
        }

        public a a(int i2) {
            this.f27320d = i2;
            return this;
        }

        public a a(HashMap<String, String> hashMap) {
            if (this.l == null) {
                this.l = new HashMap();
            }
            this.l.putAll(hashMap);
            return this;
        }

        public a c() {
            this.m = true;
            return this;
        }

        public a d() {
            this.q = true;
            return this;
        }

        public a e() {
            this.n = true;
            return this;
        }

        public a a(Object obj) {
            this.r = obj;
            return this;
        }

        public d f() {
            if ("feeds_post".equals(this.f27319c)) {
                if (this.f27321e == null) {
                    this.f27321e = new HashMap();
                }
                this.f27321e.put("pushtime", String.valueOf(System.currentTimeMillis()));
                this.f27321e.put("network_type", com.shopee.feeds.feedlibrary.a.b.b.a().name());
                if (com.shopee.feeds.feedlibrary.data.c.c.f27687a == 1) {
                    com.shopee.sdk.modules.app.a.a a2 = b.a().a().a();
                    this.f27321e.put("system_os", "Android");
                    this.f27321e.put("system_version", a2.f());
                    this.f27321e.put("app_version", a2.a());
                    this.f27321e.put("device_model", a2.g());
                }
            }
            if (TextUtils.isEmpty(this.f27319c)) {
                this.f27319c = "get";
            }
            Map<String, String> map = this.f27321e;
            String jSONObject = map == null ? "" : new JSONObject(map).toString();
            Map<String, String> map2 = this.f27321e;
            if (this.f27322f == null) {
                this.f27322f = CacheControl.FORCE_NETWORK;
            }
            d dVar = r2;
            d dVar2 = new d(this.f27317a, this.f27318b, jSONObject, this.h, map2, this.m, this.n, this.i, this.j, this.k, this.q, this.r, this.o, this.p, this.l, this.f27323g, this.f27322f, this.f27320d, this.f27319c);
            return dVar;
        }
    }

    private void a(Object obj) {
        try {
            RequestBody.create(f27289a, new f().b(obj));
        } catch (Exception e2) {
            e2.printStackTrace();
            com.shopee.feeds.feedlibrary.util.d.a(obj);
        }
    }
}
