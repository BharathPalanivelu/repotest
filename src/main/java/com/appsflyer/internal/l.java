package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.ServerParameters;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class l implements Runnable {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f184;

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f185;
    /* access modifiers changed from: private */

    /* renamed from: ʼ  reason: contains not printable characters */
    public Map<String, String> f186;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f187;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Intent f188;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f189;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f190;
    /* access modifiers changed from: private */

    /* renamed from: ˏ  reason: contains not printable characters */
    public WeakReference<Context> f191;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f192;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f193;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(AppsFlyerLibCore.f37);
        sb.append("/androidevent?buildnumber=4.10.0&app_id=");
        f184 = sb.toString();
    }

    public l(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, Intent intent) {
        this.f191 = new WeakReference<>(context);
        this.f190 = str;
        this.f189 = str2;
        this.f192 = str4;
        this.f185 = str5;
        this.f193 = str6;
        this.f186 = map;
        this.f187 = str3;
        this.f188 = intent;
    }

    public final void run() {
        String str = this.f190;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isTrackingStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.f191.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.f189);
                    hashMap.put("sig-data", this.f192);
                    hashMap.put("signature", this.f187);
                    final HashMap hashMap2 = new HashMap();
                    hashMap2.putAll(hashMap);
                    Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
                        public final void run() {
                            l lVar = l.this;
                            l.m162(lVar, hashMap2, lVar.f186, l.this.f191);
                        }
                    }, 5, TimeUnit.MILLISECONDS);
                    hashMap.put("dev_key", this.f190);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM));
                    String jSONObject = new JSONObject(hashMap).toString();
                    String url = ServerConfigHandler.getUrl("https://%ssdk-services.%s/validate-android-signature");
                    if (x.f258 == null) {
                        x.f258 = new x();
                    }
                    x.f258.m205("server_request", url, jSONObject);
                    HttpURLConnection r2 = m161(jSONObject, url);
                    int i = -1;
                    if (r2 != null) {
                        i = r2.getResponseCode();
                    }
                    AppsFlyerLibCore.getInstance();
                    String r5 = AppsFlyerLibCore.m81(r2);
                    if (x.f258 == null) {
                        x.f258 = new x();
                    }
                    x.f258.m205("server_response", url, String.valueOf(i), r5);
                    JSONObject jSONObject2 = new JSONObject(r5);
                    jSONObject2.put("code", i);
                    if (i == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.afInfoLog(sb.toString());
                        m163(jSONObject2.optBoolean(AbTestingModule.KEY_RESULT) ? jSONObject2.getBoolean(AbTestingModule.KEY_RESULT) : false, this.f192, this.f185, this.f193, jSONObject2.toString());
                    } else {
                        AFLogger.afInfoLog("Failed Validate request");
                        m163(false, this.f192, this.f185, this.f193, jSONObject2.toString());
                    }
                    if (r2 != null) {
                        r2.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static HttpURLConnection m161(String str, String str2) throws IOException {
        try {
            q qVar = new q((Context) null, AppsFlyerLib.getInstance().isTrackingStopped());
            qVar.f234 = str;
            qVar.f233 = false;
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                StringBuilder sb = new StringBuilder("Main thread detected. Calling ");
                sb.append(str2);
                sb.append(" in a new thread.");
                AFLogger.afDebugLog(sb.toString());
                qVar.execute(new String[]{str2});
            } else {
                StringBuilder sb2 = new StringBuilder("Calling ");
                sb2.append(str2);
                sb2.append(" (on current thread: ");
                sb2.append(Thread.currentThread().toString());
                sb2.append(" )");
                AFLogger.afDebugLog(sb2.toString());
                qVar.onPreExecute();
                qVar.onPostExecute(qVar.doInBackground(str2));
            }
            return qVar.f235;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not send callStats request", th);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m163(boolean z, String str, String str2, String str3, String str4) {
        if (AppsFlyerLibCore.f31 != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(SQLBuilder.BLANK);
            sb.append(str2);
            sb.append(SQLBuilder.BLANK);
            sb.append(str3);
            AFLogger.afDebugLog(sb.toString());
            if (z) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AppsFlyerLibCore.f31.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AppsFlyerLibCore.f31;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [java.net.HttpURLConnection, java.lang.String] */
    /* renamed from: ˋ  reason: contains not printable characters */
    static /* synthetic */ void m162(l lVar, Map map, Map map2, WeakReference weakReference) {
        l lVar2 = lVar;
        if (weakReference.get() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(f184));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            SharedPreferences r10 = AppsFlyerLibCore.m46((Context) weakReference.get());
            ? r2 = 0;
            String string = r10.getString("referrer", r2);
            if (string == null) {
                string = "";
            }
            Map<String, Object> r3 = AppsFlyerLibCore.getInstance().m93((Context) weakReference.get(), lVar2.f190, AFInAppEventType.PURCHASE, "", string, true, r10, false, lVar2.f188, (String) null);
            r3.put("price", lVar2.f185);
            r3.put("currency", lVar2.f193);
            JSONObject jSONObject = new JSONObject(r3);
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject.put("receipt_data", jSONObject2);
            } catch (JSONException e2) {
                AFLogger.afErrorLog("Failed to build 'receipt_data'", e2);
            }
            if (map2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    for (Map.Entry entry2 : map2.entrySet()) {
                        jSONObject3.put((String) entry2.getKey(), entry2.getValue());
                    }
                    jSONObject.put("extra_prms", jSONObject3);
                } catch (JSONException e3) {
                    AFLogger.afErrorLog("Failed to build 'extra_prms'", e3);
                }
            }
            String jSONObject4 = jSONObject.toString();
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x.f258.m205("server_request", obj, jSONObject4);
            try {
                HttpURLConnection r22 = m161(jSONObject4, obj);
                int i = -1;
                if (r22 != null) {
                    i = r22.getResponseCode();
                }
                AppsFlyerLibCore.getInstance();
                String r32 = AppsFlyerLibCore.m81(r22);
                if (x.f258 == null) {
                    x.f258 = new x();
                }
                x.f258.m205("server_response", obj, String.valueOf(i), r32);
                JSONObject jSONObject5 = new JSONObject(r32);
                if (i == 200) {
                    StringBuilder sb2 = new StringBuilder("Validate-WH response - 200: ");
                    sb2.append(jSONObject5.toString());
                    AFLogger.afInfoLog(sb2.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder("Validate-WH response failed - ");
                    sb3.append(i);
                    sb3.append(": ");
                    sb3.append(jSONObject5.toString());
                    AFLogger.afWarnLog(sb3.toString());
                }
                if (r22 != null) {
                    r22.disconnect();
                }
            } catch (Throwable th) {
                if (r2 != 0) {
                    r2.disconnect();
                }
                throw th;
            }
        }
    }
}
