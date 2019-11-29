package com.shopee.live.livestreaming.network.service;

import android.content.Context;
import com.google.a.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.live.livestreaming.data.entity.require.LicenseEntity;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.p;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class TxLicensePullHelper {
    private static final String TAG = "TxLicensePullHelper";
    /* access modifiers changed from: private */
    public Context mContext;
    private OkHttpClient mHTTPClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();

    public interface PullLicenseListener {
        void onPullError(Throwable th);

        void onPullSuccess(LicenseEntity licenseEntity);
    }

    public TxLicensePullHelper(Context context) {
        this.mContext = context;
    }

    public Call pullLicense(final PullLicenseListener pullLicenseListener) {
        Request.Builder builder = new Request.Builder();
        builder.url(p.e());
        Call newCall = this.mHTTPClient.newCall(builder.build());
        FirebasePerfOkHttpClient.enqueue(newCall, new Callback() {
            public void onFailure(Call call, IOException iOException) {
                pullLicenseListener.onPullError(iOException);
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (body == null) {
                    pullLicenseListener.onPullError(new RuntimeException("body is empty when pulling license."));
                    return;
                }
                String string = body.string();
                if (d.a(string)) {
                    pullLicenseListener.onPullError(new RuntimeException("body string is empty when pulling license."));
                    return;
                }
                try {
                    String packageName = TxLicensePullHelper.this.mContext.getPackageName();
                    f fVar = new f();
                    JSONObject jSONObject = new JSONObject(string);
                    JSONObject optJSONObject = jSONObject.optJSONObject(packageName);
                    if (optJSONObject == null) {
                        optJSONObject = jSONObject.optJSONObject("default");
                    }
                    pullLicenseListener.onPullSuccess((LicenseEntity) fVar.a(optJSONObject.toString(), LicenseEntity.class));
                } catch (Exception e2) {
                    pullLicenseListener.onPullError(e2);
                }
            }
        });
        return newCall;
    }
}
