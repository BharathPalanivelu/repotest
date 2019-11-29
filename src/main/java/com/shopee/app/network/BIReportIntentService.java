package com.shopee.app.network;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.d.a;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.shopee.app.application.ar;
import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.e;
import com.shopee.app.database.orm.bean.DBBIReport;
import com.shopee.app.util.i;
import com.shopee.app.util.l;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BIReportIntentService extends IntentService {

    /* renamed from: c  reason: collision with root package name */
    private static final MediaType f17771c = MediaType.parse(LiveAgentRequest.HEADER_ACCEPT_VALUE);

    /* renamed from: a  reason: collision with root package name */
    e f17772a = b.f().F();

    /* renamed from: b  reason: collision with root package name */
    private boolean f17773b = false;

    public BIReportIntentService() {
        super("BI_REPORT_INTENT_SERVICE");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (ar.f().e().settingConfigStore().biEnabled() && intent != null && a.b(ar.a()) && e.c().f()) {
            try {
                Bundle extras = intent.getExtras();
                String string = extras.getString("SIGNATURE");
                String string2 = extras.getString("HASH");
                OkHttpClient build = new OkHttpClient.Builder().connectTimeout(3, TimeUnit.MINUTES).readTimeout(3, TimeUnit.MINUTES).retryOnConnectionFailure(false).build();
                while (this.f17772a != null && this.f17772a.e() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", l.A);
                    jSONObject.put("actiondatas", b(20));
                    jSONObject.put("signature", string);
                    jSONObject.put("hash", string2);
                    jSONObject.put(ShareConstants.FEED_SOURCE_PARAM, "android_app");
                    RequestBody create = RequestBody.create(f17771c, jSONObject.toString());
                    Request.Builder builder = new Request.Builder();
                    FirebasePerfOkHttpClient.enqueue(build.newCall(builder.url(i.f7038a + "/batchrecord").post(create).build()), new Callback() {
                        public void onFailure(Call call, IOException iOException) {
                        }

                        public void onResponse(Call call, Response response) throws IOException {
                        }
                    });
                    a(20);
                }
            } catch (Exception e2) {
                a(20);
                ar.f().e().fabricClient().a((Throwable) e2, "crash_from:BIService");
                a.a(e2);
            }
        }
    }

    private JSONObject a(String str, String str2) {
        if (this.f17773b) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str);
            jSONObject.put("data", str2);
            return jSONObject;
        } catch (JSONException e2) {
            a.a(e2);
            return null;
        }
    }

    public void a(long j) {
        this.f17772a.b(j);
    }

    public JSONArray b(long j) {
        try {
            if (this.f17773b) {
                return null;
            }
            List<DBBIReport> a2 = this.f17772a.a(j);
            JSONArray jSONArray = new JSONArray();
            for (DBBIReport next : a2) {
                jSONArray.put(a(next.a(), next.b()));
            }
            return jSONArray;
        } catch (Exception e2) {
            a.a(e2);
            return null;
        }
    }
}
