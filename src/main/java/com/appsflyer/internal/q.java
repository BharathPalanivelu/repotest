package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Build;
import com.appsflyer.AFExecutor;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.ServerConfigHandler;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import org.json.JSONObject;

public final class q extends AsyncTask<String, Void, String> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f230 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    private URL f231;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f232 = "";

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean f233;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f234;

    /* renamed from: ˎ  reason: contains not printable characters */
    HttpURLConnection f235;

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean f236;

    /* renamed from: ॱ  reason: contains not printable characters */
    public Map<String, String> f237;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private WeakReference<Context> f238;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f239 = false;

    /* access modifiers changed from: protected */
    public final void onCancelled() {
    }

    public q(Context context, boolean z) {
        this.f238 = new WeakReference<>(context);
        this.f236 = true;
        this.f233 = true;
        this.f230 = z;
    }

    public final void onPreExecute() {
        if (this.f234 == null) {
            this.f234 = new JSONObject(this.f237).toString();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String doInBackground(String... strArr) {
        if (this.f230) {
            return null;
        }
        try {
            this.f231 = new URL(strArr[0]);
            if (this.f236) {
                if (x.f258 == null) {
                    x.f258 = new x();
                }
                x.f258.m205("server_request", this.f231.toString(), this.f234);
                int length = this.f234.getBytes("UTF-8").length;
                StringBuilder sb = new StringBuilder("call = ");
                sb.append(this.f231);
                sb.append("; size = ");
                sb.append(length);
                sb.append(" byte");
                sb.append(length > 1 ? "s" : "");
                sb.append("; body = ");
                sb.append(this.f234);
                AFExecutor.AnonymousClass2.AnonymousClass1.m27(sb.toString());
            }
            if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
            }
            this.f235 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(this.f231.openConnection()));
            this.f235.setReadTimeout(30000);
            this.f235.setConnectTimeout(30000);
            this.f235.setRequestMethod("POST");
            this.f235.setDoInput(true);
            this.f235.setDoOutput(true);
            this.f235.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.JSON);
            OutputStream outputStream = this.f235.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(this.f234);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            this.f235.connect();
            int responseCode = this.f235.getResponseCode();
            if (this.f233) {
                AppsFlyerLibCore.getInstance();
                this.f232 = AppsFlyerLibCore.m81(this.f235);
            }
            if (this.f236) {
                if (x.f258 == null) {
                    x.f258 = new x();
                }
                x.f258.m205("server_response", this.f231.toString(), String.valueOf(responseCode), this.f232);
            }
            if (responseCode == 200) {
                AFLogger.afInfoLog("Status 200 ok");
                Context context = this.f238.get();
                if (this.f231.toString().startsWith(ServerConfigHandler.getUrl(AppsFlyerLibCore.f34)) && context != null) {
                    SharedPreferences.Editor edit = AppsFlyerLibCore.m46(context).edit();
                    edit.putBoolean("sentRegisterRequestToAF", true);
                    edit.apply();
                    AFLogger.afDebugLog("Successfully registered for Uninstall Tracking");
                }
            } else {
                this.f239 = true;
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Error while calling ");
            sb2.append(this.f231.toString());
            AFLogger.afErrorLog(sb2.toString(), th);
            this.f239 = true;
        }
        return this.f232;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void onPostExecute(String str) {
        if (this.f239) {
            AFLogger.afInfoLog("Connection error: ".concat(String.valueOf(str)));
        } else {
            AFLogger.afInfoLog("Connection call succeeded: ".concat(String.valueOf(str)));
        }
    }
}
