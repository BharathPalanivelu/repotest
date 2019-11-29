package com.shopee.live.livestreaming.util;

import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.google.a.f;
import com.google.a.o;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.live.livestreaming.c;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class e {

    public interface a {
        void a();

        void a(o oVar);
    }

    public static void a(String str, final a aVar) {
        Request.Builder builder = new Request.Builder();
        builder.url(a(str));
        FirebasePerfOkHttpClient.enqueue(a().newCall(builder.build()), new Callback() {
            public void onFailure(Call call, IOException iOException) {
                aVar.a();
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (body == null) {
                    aVar.a();
                    return;
                }
                String string = body.string();
                if (TextUtils.isEmpty(string)) {
                    aVar.a();
                    return;
                }
                try {
                    o oVar = (o) new f().a(string, o.class);
                    if (oVar == null) {
                        aVar.a();
                    } else {
                        aVar.a(oVar);
                    }
                } catch (Exception unused) {
                    aVar.a();
                }
            }
        });
    }

    private static String a(String str) {
        String b2 = x.b();
        String e2 = b.e(c.g.live_streaming_base_url_cdn);
        if (ShopeeEnv.ENV_TEST.equals(b2)) {
            return e2 + "test/" + str + "?ts=" + System.currentTimeMillis();
        } else if (ShopeeEnv.ENV_UAT.equals(b2)) {
            return e2 + "uat/" + str + "?ts=" + System.currentTimeMillis();
        } else if (ShopeeEnv.ENV_STAGING.equals(b2)) {
            return e2 + "test/" + str + "?ts=" + System.currentTimeMillis();
        } else if ("live".equals(b2)) {
            return e2 + "live/" + str + "?ts=" + System.currentTimeMillis();
        } else {
            return e2 + "test/" + str + "?ts=" + System.currentTimeMillis();
        }
    }

    private static OkHttpClient a() {
        OkHttpClient a2 = com.shopee.sdk.b.a().g().a();
        return a2 == null ? new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build() : a2;
    }
}
