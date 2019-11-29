package com.shopee.feeds.feedlibrary.util;

import a.k;
import com.garena.android.appkit.f.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.sdk.b;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

public class y {

    public interface a {
        void a(boolean z);
    }

    public static boolean a(boolean z) {
        final int a2 = b.a().d().a().a();
        com.shopee.feeds.feedlibrary.data.b.a u = j.a().u();
        if (!u.hasPulled || z) {
            final OkHttpClient a3 = b.a().g().a();
            final CacheControl build = new CacheControl.Builder().noCache().build();
            final com.shopee.feeds.feedlibrary.data.d.b a4 = com.shopee.feeds.feedlibrary.b.b().a();
            if (a3 != null) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                final CountDownLatch countDownLatch2 = countDownLatch;
                k.a(new Callable<Object>() {
                    public Object call() throws Exception {
                        Request.Builder builder = new Request.Builder();
                        builder.url(com.shopee.feeds.feedlibrary.data.c.b.s + "userid=" + a2);
                        builder.cacheControl(build);
                        try {
                            String string = FirebasePerfOkHttpClient.execute(a3.newCall(builder.get().build())).body().string();
                            h.b("%s", "isInWhiteList " + a2 + "," + string);
                            JSONArray jSONArray = new JSONObject(string).getJSONArray("data");
                            if (jSONArray == null || jSONArray.length() <= 0) {
                                return null;
                            }
                            int i = 0;
                            while (i < jSONArray.length()) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                String optString = jSONObject.optString("name");
                                boolean optBoolean = jSONObject.optBoolean("toggle");
                                if (!"feed_picture_optimisation".equals(optString)) {
                                    i++;
                                } else if (optBoolean) {
                                    a4.d(a2, 1);
                                    h.b("%s", "isInWhiteList you are in white list");
                                    j.a().e(true);
                                    countDownLatch2.countDown();
                                    return true;
                                } else {
                                    a4.d(a2, 0);
                                    return false;
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return null;
                        }
                    }
                });
                if (z) {
                    try {
                        countDownLatch.await(2000, TimeUnit.MILLISECONDS);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } else {
                    countDownLatch.await(200, TimeUnit.MILLISECONDS);
                }
            }
            j.a().e(false);
            return false;
        }
        h.b("%s", "isInWhiteList has pulled " + u.isWhiteList);
        return u.isWhiteList;
    }

    public static void a(a aVar) {
        int d2 = com.shopee.feeds.feedlibrary.b.b().a().d(b.a().d().a().a());
        if (d2 == 0) {
            aVar.a(false);
            b((a) null);
        } else if (d2 == 1) {
            aVar.a(true);
            b((a) null);
        } else {
            b(aVar);
        }
    }

    public static boolean a() {
        int d2 = com.shopee.feeds.feedlibrary.b.b().a().d(b.a().d().a().a());
        if (d2 == 0) {
            return false;
        }
        if (d2 == 1) {
            return true;
        }
        a(false);
        return false;
    }

    public static void b(final a aVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                com.shopee.feeds.feedlibrary.data.d.b a2 = com.shopee.feeds.feedlibrary.b.b().a();
                int a3 = b.a().d().a().a();
                OkHttpClient a4 = b.a().g().a();
                CacheControl build = new CacheControl.Builder().noCache().build();
                if (a4 != null) {
                    Request.Builder builder = new Request.Builder();
                    builder.url(com.shopee.feeds.feedlibrary.data.c.b.s + "userid=" + a3);
                    builder.cacheControl(build);
                    try {
                        String string = FirebasePerfOkHttpClient.execute(a4.newCall(builder.get().build())).body().string();
                        h.b("%s", "isInWhiteList " + a3 + "," + string);
                        JSONArray jSONArray = new JSONObject(string).getJSONArray("data");
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (i < jSONArray.length()) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                String optString = jSONObject.optString("name");
                                boolean optBoolean = jSONObject.optBoolean("toggle");
                                if (!"feed_create_flow_importing_instagram".equals(optString) || !optBoolean) {
                                    i++;
                                } else {
                                    a2.c(a3, 1);
                                    f.a().a(new Runnable() {
                                        public void run() {
                                            if (aVar != null) {
                                                aVar.a(true);
                                            }
                                        }
                                    });
                                    return null;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                a2.c(a3, 0);
                f.a().a(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            aVar.a(false);
                        }
                    }
                });
                return null;
            }
        });
    }

    public static void b() {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                y.a(true);
                return null;
            }
        });
    }
}
