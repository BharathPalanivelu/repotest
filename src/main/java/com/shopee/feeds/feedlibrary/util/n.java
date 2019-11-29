package com.shopee.feeds.feedlibrary.util;

import a.k;
import android.content.Context;
import android.content.Intent;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FeedsInstagramData;
import com.shopee.feeds.feedlibrary.webview.CommonWebviewActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.d.b.a.d;
import org.d.b.a.e;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public a f28329a;

    /* renamed from: b  reason: collision with root package name */
    private Context f28330b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<FeedsInstagramData> f28331c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private String f28332d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f28333e = null;

    /* renamed from: f  reason: collision with root package name */
    private org.d.a f28334f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f28335g = 40;
    private long h = -1;
    private long i = -1;

    public interface a {
        void a();

        void a(ArrayList<FeedsInstagramData> arrayList, boolean z);

        void b();

        void c();
    }

    public n(Context context) {
        this.f28330b = context;
    }

    public void a(final boolean z) {
        this.f28333e = i.a();
        if (d.a(this.f28333e)) {
            this.f28329a.a();
        } else {
            a((com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                public void a(Object obj, String str) {
                    n.this.b(z);
                }

                public void a(String str) {
                    f.a().a(new Runnable() {
                        public void run() {
                            i.b();
                            n.this.f28329a.a();
                        }
                    });
                }
            });
        }
    }

    public void a() {
        Intent intent = new Intent(this.f28330b, CommonWebviewActivity.class);
        intent.putExtra("url", "https://instagram.com/oauth/authorize/?client_id=d347e85a935b438399735251844c80dd&redirect_uri=shopee://callback&response_type=token");
        intent.putExtra("title", b.e(c.g.feeds_instagram_login_navi_title));
        this.f28330b.startActivity(intent);
    }

    public void b() {
        if (this.f28334f == null) {
            this.f28334f = new org.d.a(new org.d.a.b.b(this.f28333e, (String) null));
        }
        c();
    }

    public void c() {
        try {
            this.f28332d = this.f28334f.a().a().b();
        } catch (org.d.c.b e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void b(final boolean z) {
        if (!d.a(this.f28333e)) {
            k.a(new Callable<Object>() {
                public Object call() throws Exception {
                    n.this.b();
                    n.this.c(z);
                    return null;
                }
            });
        }
    }

    public void c(final boolean z) {
        try {
            d();
            if (this.f28332d == null) {
                this.f28332d = this.f28334f.a().a().b();
            }
            final org.d.b.b.b.b a2 = this.f28334f.a(this.f28332d, this.f28335g, (String) null, (String) null, (Date) null, (Date) null);
            if (!(a2 == null || a2.b() == null)) {
                if (a2.b().size() > 0) {
                    a(a2, (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                        /* JADX WARNING: type inference failed for: r2v9, types: [java.util.List] */
                        /* JADX WARNING: type inference failed for: r2v11, types: [java.util.List] */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void a(java.lang.Object r2, java.lang.String r3) {
                            /*
                                r1 = this;
                                java.lang.Integer r2 = (java.lang.Integer) r2
                                int r2 = r2.intValue()
                                java.util.ArrayList r3 = new java.util.ArrayList
                                r3.<init>()
                                r0 = -1
                                if (r2 == r0) goto L_0x001e
                                r0 = 1
                                if (r2 == r0) goto L_0x0012
                                goto L_0x002a
                            L_0x0012:
                                com.shopee.feeds.feedlibrary.util.n r2 = com.shopee.feeds.feedlibrary.util.n.this
                                org.d.b.b.b.b r3 = r0
                                java.util.List r2 = r2.a((org.d.b.b.b.b) r3, (boolean) r0)
                                r3 = r2
                                java.util.ArrayList r3 = (java.util.ArrayList) r3
                                goto L_0x002a
                            L_0x001e:
                                com.shopee.feeds.feedlibrary.util.n r2 = com.shopee.feeds.feedlibrary.util.n.this
                                org.d.b.b.b.b r3 = r0
                                r0 = 0
                                java.util.List r2 = r2.a((org.d.b.b.b.b) r3, (boolean) r0)
                                r3 = r2
                                java.util.ArrayList r3 = (java.util.ArrayList) r3
                            L_0x002a:
                                com.shopee.feeds.feedlibrary.util.n r2 = com.shopee.feeds.feedlibrary.util.n.this
                                java.util.List r2 = r2.f28331c
                                r2.addAll(r3)
                                com.shopee.feeds.feedlibrary.util.n r2 = com.shopee.feeds.feedlibrary.util.n.this
                                com.shopee.feeds.feedlibrary.util.n$a r2 = r2.f28329a
                                if (r2 == 0) goto L_0x0045
                                com.garena.android.appkit.f.f r2 = com.garena.android.appkit.f.f.a()
                                com.shopee.feeds.feedlibrary.util.n$4$1 r0 = new com.shopee.feeds.feedlibrary.util.n$4$1
                                r0.<init>(r3)
                                r2.a(r0)
                            L_0x0045:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.util.n.AnonymousClass4.a(java.lang.Object, java.lang.String):void");
                        }

                        public void a(String str) {
                            n.this.f28329a.b();
                        }
                    });
                    return;
                }
            }
            f.a().a(new Runnable() {
                public void run() {
                    if (n.this.f28329a != null) {
                        n.this.f28329a.b();
                    }
                }
            });
        } catch (Exception e2) {
            f.a().a(new Runnable() {
                public void run() {
                    if (n.this.f28329a != null) {
                        n.this.f28329a.c();
                    }
                }
            });
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void d() {
        this.f28331c = new ArrayList();
        this.h = -1;
        this.i = -1;
    }

    /* access modifiers changed from: private */
    public List<FeedsInstagramData> a(org.d.b.b.b.b bVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (org.d.b.b.b.c next : bVar.b()) {
            List<org.d.b.b.b.a> g2 = next.g();
            if (g2 != null && g2.size() > 0) {
                for (int i2 = 0; i2 < g2.size(); i2++) {
                    a(next, g2.get(i2).a(), arrayList, i2, z);
                }
            } else if (!"video".equals(next.f())) {
                a(next, next.d(), arrayList, 0, z);
            }
            long parseLong = Long.parseLong(next.c()) * 1000;
            long j = this.i;
            if (j == -1 || parseLong < j) {
                this.i = parseLong - 1000;
            }
            long j2 = this.h;
            if (j2 == -1 || parseLong > j2) {
                this.h = parseLong + 1000;
            }
        }
        return arrayList;
    }

    private void a(org.d.b.b.b.c cVar, e eVar, List<FeedsInstagramData> list, int i2, boolean z) {
        if (eVar != null) {
            d a2 = eVar.a();
            if (a2 != null && !d.a(a2.a())) {
                FeedsInstagramData feedsInstagramData = new FeedsInstagramData();
                if (i2 != 0 || !z) {
                    feedsInstagramData.setImage(a2.a());
                } else {
                    feedsInstagramData.setImage(a(cVar.b()));
                }
                feedsInstagramData.setThumbnail(a2.a());
                feedsInstagramData.setWidth(a2.b());
                feedsInstagramData.setHeight(a2.c());
                if (cVar.a() != null) {
                    feedsInstagramData.setDescription(cVar.a().a());
                }
                feedsInstagramData.setId(cVar.e());
                list.add(feedsInstagramData);
            }
        }
    }

    private void a(final com.shopee.feeds.feedlibrary.a.a aVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                OkHttpClient a2 = com.shopee.sdk.b.a().g().a();
                CacheControl build = new CacheControl.Builder().noCache().build();
                if (a2 == null) {
                    return null;
                }
                Request.Builder builder = new Request.Builder();
                builder.url("https://api.instagram.com/v1/users/self/media/recent?access_token=" + n.this.f28333e);
                builder.cacheControl(build);
                FirebasePerfOkHttpClient.enqueue(a2.newCall(builder.build()), new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        aVar.a("", "");
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        if (response == null || response.code() != 400) {
                            aVar.a("", "");
                        } else {
                            aVar.a("");
                        }
                    }
                });
                return null;
            }
        });
    }

    private void a(org.d.b.b.b.b bVar, final com.shopee.feeds.feedlibrary.a.a aVar) {
        String str;
        List<org.d.b.b.b.c> b2 = bVar.b();
        if (b2 == null || b2.size() <= 0) {
            aVar.a("");
            return;
        }
        Iterator<org.d.b.b.b.c> it = b2.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            org.d.b.b.b.c next = it.next();
            if (!"video".equals(next.f())) {
                str = a(next.b());
                break;
            }
        }
        if (!d.a(str)) {
            OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request.Builder newBuilder = chain.request().newBuilder();
                    newBuilder.addHeader("cookie", "");
                    return chain.proceed(newBuilder.build());
                }
            }).build();
            CacheControl build2 = new CacheControl.Builder().noCache().build();
            if (build != null) {
                Request.Builder builder = new Request.Builder();
                builder.url(str);
                builder.cacheControl(build2);
                FirebasePerfOkHttpClient.enqueue(build.newCall(builder.build()), new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        aVar.a(-1, "");
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        if (response == null || response.code() < 400 || response.code() >= 500) {
                            aVar.a(1, "");
                        } else {
                            aVar.a(-1, "");
                        }
                    }
                });
                return;
            }
            return;
        }
        aVar.a("");
    }

    private String a(String str) {
        return str + "media/?size=l";
    }

    public void a(a aVar) {
        this.f28329a = aVar;
    }
}
