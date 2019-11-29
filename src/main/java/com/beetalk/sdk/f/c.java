package com.beetalk.sdk.f;

import android.content.Context;
import com.beetalk.sdk.e.a;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f5428a;

    private String a(String str) {
        return str == null ? "" : str;
    }

    private c() {
    }

    public static c a() {
        if (f5428a == null) {
            f5428a = new c();
        }
        return f5428a;
    }

    public static String a(List<NameValuePair> list) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (NameValuePair next : list) {
            if (next.getValue() == null) {
                a.c("get query null  %s", next.getName());
            }
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(next.getName(), "UTF-8"));
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    public JSONObject a(String str, Map<String, String> map) {
        JSONObject jSONObject;
        try {
            URL url = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
            httpsURLConnection.setRequestProperty(HttpConstants.Header.USER_AGENT, new b((Context) null).toString());
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            ArrayList arrayList = new ArrayList();
            if (!map.isEmpty()) {
                for (String next : map.keySet()) {
                    arrayList.add(new BasicNameValuePair(next, a(map.get(next))));
                }
            }
            a.c("Making Request for url %s & params %s", url, arrayList.toString());
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(a((List<NameValuePair>) arrayList));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            httpsURLConnection.connect();
            InputStream inputStream = httpsURLConnection.getInputStream();
            int responseCode = httpsURLConnection.getResponseCode();
            a.c("request code %d", Integer.valueOf(responseCode));
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                try {
                    jSONObject = new JSONObject(sb.toString());
                } catch (JSONException e2) {
                    a.a((Exception) e2);
                }
                httpsURLConnection.disconnect();
                return jSONObject;
            }
            jSONObject = null;
            httpsURLConnection.disconnect();
            return jSONObject;
        } catch (IOException e3) {
            a.a((Exception) e3);
            return null;
        } catch (KeyManagementException e4) {
            a.a((Exception) e4);
            return null;
        } catch (NoSuchAlgorithmException e5) {
            a.a((Exception) e5);
            return null;
        }
    }

    public JSONObject b(String str, Map<String, String> map) {
        JSONObject jSONObject;
        try {
            ArrayList arrayList = new ArrayList();
            if (!map.isEmpty()) {
                for (String next : map.keySet()) {
                    arrayList.add(new BasicNameValuePair(next, a(map.get(next))));
                }
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str + "?" + a((List<NameValuePair>) arrayList)).openConnection()));
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, (TrustManager[]) null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
            httpsURLConnection.setRequestProperty(HttpConstants.Header.USER_AGENT, new b((Context) null).toString());
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.connect();
            InputStream inputStream = httpsURLConnection.getInputStream();
            int responseCode = httpsURLConnection.getResponseCode();
            a.c("request code %d", Integer.valueOf(responseCode));
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                try {
                    jSONObject = new JSONObject(sb.toString());
                } catch (JSONException e2) {
                    a.a((Exception) e2);
                }
                httpsURLConnection.disconnect();
                return jSONObject;
            }
            jSONObject = null;
            httpsURLConnection.disconnect();
            return jSONObject;
        } catch (IOException e3) {
            a.a((Exception) e3);
            return null;
        } catch (KeyManagementException e4) {
            a.a((Exception) e4);
            return null;
        } catch (NoSuchAlgorithmException e5) {
            a.a((Exception) e5);
            return null;
        }
    }
}
