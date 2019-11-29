package com.shopee.live.livestreaming.ui;

import android.content.Context;
import android.util.Base64;
import com.google.a.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.shopee.live.livestreaming.data.entity.UploadListEntity;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f28798a;

    /* renamed from: b  reason: collision with root package name */
    private OkHttpClient f28799b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f28800c = new ArrayList();

    public a(Context context) {
        this.f28798a = context;
        this.f28799b = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
        c();
    }

    public void a() {
        Request.Builder builder = new Request.Builder();
        builder.url(p.d());
        FirebasePerfOkHttpClient.enqueue(this.f28799b.newCall(builder.build()), new Callback() {
            public void onFailure(Call call, IOException iOException) {
                a aVar = a.this;
                aVar.a((ArrayList<String>) aVar.f28800c);
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (body == null) {
                    a aVar = a.this;
                    aVar.a((ArrayList<String>) aVar.f28800c);
                    return;
                }
                String string = body.string();
                if (string == null) {
                    a aVar2 = a.this;
                    aVar2.a((ArrayList<String>) aVar2.f28800c);
                } else if (!d.a(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        String str = null;
                        if (jSONObject.has("data")) {
                            str = jSONObject.getString("data");
                        }
                        if (str != null) {
                            a.this.a(((UploadListEntity) new f().a(str.toString(), UploadListEntity.class)).getList());
                        } else {
                            a.this.a((ArrayList<String>) a.this.f28800c);
                        }
                    } catch (JSONException e2) {
                        a aVar3 = a.this;
                        aVar3.a((ArrayList<String>) aVar3.f28800c);
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public void a(ArrayList<String> arrayList) {
        try {
            int f2 = x.f();
            if (f2 > 0 && arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (String.valueOf(f2).equals(a(arrayList.get(i)))) {
                        com.shopee.live.livestreaming.util.f.a().a(true);
                        return;
                    }
                }
            }
            b();
        } catch (Exception unused) {
            b();
        }
    }

    private void c() {
        if (this.f28800c == null) {
            this.f28800c = new ArrayList();
        }
        String b2 = x.b();
        if (ShopeeEnv.ENV_TEST.equals(b2)) {
            this.f28800c.add("NTEwOTMy");
        } else if (ShopeeEnv.ENV_UAT.equals(b2)) {
            this.f28800c.add("MjEyNDUx");
        } else if (ShopeeEnv.ENV_STAGING.equals(b2)) {
            this.f28800c.add("NTEwOTMy");
        } else if ("live".equals(b2)) {
            this.f28800c.add("MjA2MzM=");
        } else {
            this.f28800c.add("NTEwOTMy");
        }
    }

    private String a(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception unused) {
            return "";
        }
    }

    public void b() {
        com.shopee.live.livestreaming.util.f.a().a(false);
    }
}
