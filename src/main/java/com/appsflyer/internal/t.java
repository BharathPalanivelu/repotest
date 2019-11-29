package com.appsflyer.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLibCore;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.ServerConfigHandler;
import com.appsflyer.share.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class t extends OneLinkHttpTask {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static List<String> f240 = Arrays.asList(new String[]{"onelink.me", "onelnk.com", "app.aflink.com"});

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f241;

    /* renamed from: ˎ  reason: contains not printable characters */
    public d f242;

    public interface d {
        /* renamed from: ˊ  reason: contains not printable characters */
        void m183(String str);

        /* renamed from: ˎ  reason: contains not printable characters */
        void m184(Map<String, String> map);
    }

    public t(Uri uri, AppsFlyerLibCore appsFlyerLibCore) {
        super(appsFlyerLibCore);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            boolean z = false;
            for (String contains : f240) {
                if (uri.getHost().contains(contains)) {
                    z = true;
                }
            }
            String[] split = uri.getPath().split(Constants.URL_PATH_DELIMITER);
            if (z && split.length == 3) {
                this.f110 = split[1];
                this.f241 = split[2];
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m181(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        httpsURLConnection.setRequestMethod("GET");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m179() {
        StringBuilder sb = new StringBuilder();
        sb.append(ServerConfigHandler.getUrl("https://%sonelink.%s/shortlink-sdk/v1"));
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(this.f110);
        sb.append("?id=");
        sb.append(this.f241);
        return sb.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m180(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.f242.m184(hashMap);
        } catch (JSONException e2) {
            this.f242.m183("Can't parse one link data");
            AFLogger.afErrorLog("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m182() {
        this.f242.m183("Can't get one link data");
    }
}
