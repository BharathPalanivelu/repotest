package com.shopee.app.util.youtube;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.FactoryConfigurationError;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    public static String a(b bVar) throws IOException, FactoryConfigurationError {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpResponse execute = FirebasePerfHttpClient.execute(defaultHttpClient, new HttpGet("http://gdata.youtube.com/feeds/api/playlists/" + bVar.a() + "?v=2&max-results=50&alt=json"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            execute.getEntity().writeTo(byteArrayOutputStream);
            JSONArray jSONArray = new JSONObject(byteArrayOutputStream.toString("UTF-8")).getJSONObject("feed").getJSONArray("entry");
            JSONArray jSONArray2 = jSONArray.getJSONObject(jSONArray.length() - 1).getJSONArray("link");
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                String optString = jSONObject.optString("rel", (String) null);
                if (optString != null && optString.equals("alternate")) {
                    return Uri.parse(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_HREF, (String) null)).getQueryParameter("v");
                }
            }
            return null;
        } catch (IllegalStateException e2) {
            Log.i(f.class.getSimpleName(), "Error retrieving content from YouTube", e2);
            return null;
        } catch (IOException e3) {
            Log.i(f.class.getSimpleName(), "Error retrieving content from YouTube", e3);
            return null;
        } catch (JSONException e4) {
            Log.i(f.class.getSimpleName(), "Error retrieving content from YouTube", e4);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r9, boolean r10, java.lang.String r11) throws java.io.IOException, com.shopee.app.util.youtube.g {
        /*
            org.apache.http.impl.client.DefaultHttpClient r0 = new org.apache.http.impl.client.DefaultHttpClient
            r0.<init>()
            org.apache.http.client.methods.HttpGet r1 = new org.apache.http.client.methods.HttpGet
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "http://www.youtube.com/get_video_info?&video_id="
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.<init>(r11)
            org.apache.http.HttpResponse r11 = com.google.firebase.perf.network.FirebasePerfHttpClient.execute(r0, r1)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            org.apache.http.HttpEntity r11 = r11.getEntity()
            r11.writeTo(r0)
            java.lang.String r11 = new java.lang.String
            java.lang.String r1 = "UTF-8"
            java.lang.String r0 = r0.toString(r1)
            r11.<init>(r0)
            java.lang.String r0 = "&"
            java.lang.String[] r11 = r11.split(r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2 = 0
            r3 = 0
        L_0x0043:
            int r4 = r11.length
            if (r3 >= r4) goto L_0x0063
            r4 = r11[r3]
            java.lang.String r5 = "="
            java.lang.String[] r4 = r4.split(r5)
            if (r4 == 0) goto L_0x0060
            int r5 = r4.length
            r6 = 2
            if (r5 < r6) goto L_0x0060
            r5 = r4[r2]
            r6 = 1
            r4 = r4[r6]
            java.lang.String r4 = java.net.URLDecoder.decode(r4)
            r0.put(r5, r4)
        L_0x0060:
            int r3 = r3 + 1
            goto L_0x0043
        L_0x0063:
            java.lang.String r11 = "errorcode"
            boolean r3 = r0.containsKey(r11)
            if (r3 == 0) goto L_0x0086
            java.lang.Object r3 = r0.get(r11)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "0"
            int r3 = r3.compareTo(r4)
            if (r3 != 0) goto L_0x007a
            goto L_0x0086
        L_0x007a:
            com.shopee.app.util.youtube.g r9 = new com.shopee.app.util.youtube.g
            java.lang.Object r10 = r0.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            r9.<init>(r10)
            throw r9
        L_0x0086:
            java.lang.String r11 = "fmt_list"
            java.lang.Object r11 = r0.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r11 = java.net.URLDecoder.decode(r11)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = ","
            if (r11 == 0) goto L_0x00b0
            java.lang.String[] r11 = r11.split(r4)
            int r5 = r11.length
            r6 = 0
        L_0x00a1:
            if (r6 >= r5) goto L_0x00b0
            r7 = r11[r6]
            com.shopee.app.util.youtube.a r8 = new com.shopee.app.util.youtube.a
            r8.<init>((java.lang.String) r7)
            r3.add(r8)
            int r6 = r6 + 1
            goto L_0x00a1
        L_0x00b0:
            java.lang.String r11 = "url_encoded_fmt_stream_map"
            java.lang.Object r11 = r0.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0106
            java.lang.String[] r11 = r11.split(r4)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r4 = r11.length
        L_0x00c4:
            if (r2 >= r4) goto L_0x00d3
            r5 = r11[r2]
            com.shopee.app.util.youtube.d r6 = new com.shopee.app.util.youtube.d
            r6.<init>(r5)
            r0.add(r6)
            int r2 = r2 + 1
            goto L_0x00c4
        L_0x00d3:
            int r9 = java.lang.Integer.parseInt(r9)
            com.shopee.app.util.youtube.a r11 = new com.shopee.app.util.youtube.a
            r11.<init>((int) r9)
        L_0x00dc:
            boolean r9 = r3.contains(r11)
            if (r9 != 0) goto L_0x00f5
            if (r10 == 0) goto L_0x00f5
            int r9 = r11.a()
            int r2 = a((int) r9)
            if (r9 != r2) goto L_0x00ef
            goto L_0x00f5
        L_0x00ef:
            com.shopee.app.util.youtube.a r11 = new com.shopee.app.util.youtube.a
            r11.<init>((int) r2)
            goto L_0x00dc
        L_0x00f5:
            int r9 = r3.indexOf(r11)
            if (r9 < 0) goto L_0x0106
            java.lang.Object r9 = r0.get(r9)
            com.shopee.app.util.youtube.d r9 = (com.shopee.app.util.youtube.d) r9
            java.lang.String r9 = r9.a()
            goto L_0x0107
        L_0x0106:
            r9 = 0
        L_0x0107:
            if (r9 == 0) goto L_0x0121
            java.lang.String r10 = r9.toLowerCase()
            java.lang.String r11 = "http://"
            boolean r11 = r10.startsWith(r11)
            if (r11 != 0) goto L_0x0121
            java.lang.String r11 = "https://"
            boolean r10 = r10.startsWith(r11)
            if (r10 != 0) goto L_0x0121
            java.lang.String r9 = java.net.URLDecoder.decode(r9, r1)
        L_0x0121:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.youtube.f.a(java.lang.String, boolean, java.lang.String):java.lang.String");
    }

    public static void a(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (str != null) {
            String string = defaultSharedPreferences.getString("com.keyes.screebl.lastViewedVideoIds", (String) null);
            if (string == null) {
                string = "";
            }
            String[] split = string.split(";");
            if (split == null) {
                split = new String[0];
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < split.length; i++) {
                hashMap.put(split[i], split[i]);
            }
            String str2 = "";
            for (String str3 : hashMap.keySet()) {
                if (!str3.trim().equals("")) {
                    str2 = str2 + str3 + ";";
                }
            }
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putString("com.keyes.screebl.lastViewedVideoIds", str2 + str + ";");
            edit.commit();
        }
    }

    public static int a(int i) {
        int[] iArr = {13, 17, 18, 22, 37};
        int i2 = i;
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (i == iArr[length] && length > 0) {
                i2 = iArr[length - 1];
            }
        }
        return i2;
    }
}
