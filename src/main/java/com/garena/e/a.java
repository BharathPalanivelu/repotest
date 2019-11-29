package com.garena.e;

import android.util.Log;
import com.beetalk.sdk.f.d;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.Future;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f7906a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f7907b = "[SDK] AsyncHttpClient";

    /* renamed from: com.garena.e.a$a  reason: collision with other inner class name */
    public interface C0131a<T> extends g<b, T> {
    }

    public interface b extends C0131a<JSONObject> {
    }

    private a() {
    }

    public static a a() {
        if (f7906a == null) {
            f7906a = new a();
        }
        return f7906a;
    }

    public Future<JSONObject> a(d dVar, b bVar) {
        return a(dVar, new e(), bVar);
    }

    private <T> Future<T> a(final d dVar, final f<b, T> fVar, final C0131a<T> aVar) {
        return c.a().a(new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f7908a = (!a.class.desiredAssertionStatus());

            public void run() {
                final String str;
                try {
                    if (dVar.a().equals("GET")) {
                        str = b();
                    } else {
                        str = a();
                    }
                    final AnonymousClass1 r1 = new b() {
                        public String a() {
                            return str;
                        }
                    };
                    final Object a2 = fVar.a(r1);
                    d.a().a(new Runnable() {
                        public void run() {
                            aVar.a((Exception) null, r1, a2);
                        }
                    });
                } catch (Exception e2) {
                    d.a().a(new Runnable() {
                        public void run() {
                            aVar.a(e2, null, null);
                        }
                    });
                }
            }

            private String a() {
                HttpURLConnection httpURLConnection;
                try {
                    String trim = dVar.c().toExternalForm().trim();
                    URL url = new URL(trim);
                    if (dVar.b()) {
                        SSLContext instance = SSLContext.getInstance("TLS");
                        instance.init((KeyManager[]) null, (TrustManager[]) null, new SecureRandom());
                        httpURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(instance.getSocketFactory());
                    } else {
                        httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                    }
                    if (!f7908a) {
                        if (httpURLConnection == null) {
                            throw new AssertionError();
                        }
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setRequestMethod("POST");
                    if (dVar.f().size() > 0) {
                        for (String next : dVar.f().keySet()) {
                            httpURLConnection.addRequestProperty(next, dVar.f().get(next));
                        }
                    }
                    httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setConnectTimeout(CONSTANT.TIME.MIN_1);
                    httpURLConnection.setReadTimeout(CONSTANT.TIME.MIN_1);
                    String a2 = a.this.f7907b;
                    Log.d(a2, "Making POST Request for url:" + trim + "and params" + dVar.d().toString());
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(dVar.e());
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    int responseCode = httpURLConnection.getResponseCode();
                    String a3 = a.this.f7907b;
                    Log.d(a3, "Request Code " + responseCode);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            bufferedReader.close();
                            httpURLConnection.disconnect();
                            return sb.toString();
                        }
                    }
                } catch (NoSuchAlgorithmException e2) {
                    Log.e(a.this.f7907b, e2.toString());
                    e2.printStackTrace();
                    return "";
                } catch (IOException e3) {
                    Log.e(a.this.f7907b, e3.toString());
                    e3.printStackTrace();
                    return "";
                } catch (KeyManagementException e4) {
                    Log.e(a.this.f7907b, e4.toString());
                    e4.printStackTrace();
                    return "";
                }
            }

            private String b() {
                HttpURLConnection httpURLConnection;
                try {
                    URL url = new URL(dVar.c().toExternalForm().trim() + "?" + dVar.e());
                    if (dVar.b()) {
                        httpURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                        SSLContext instance = SSLContext.getInstance("TLS");
                        instance.init((KeyManager[]) null, (TrustManager[]) null, new SecureRandom());
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(instance.getSocketFactory());
                    } else {
                        httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
                    if (dVar.f().size() > 0) {
                        for (String next : dVar.f().keySet()) {
                            httpURLConnection.addRequestProperty(next, dVar.f().get(next));
                        }
                    }
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    com.beetalk.sdk.e.a.c("request code %d", Integer.valueOf(httpURLConnection.getResponseCode()));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            bufferedReader.close();
                            httpURLConnection.disconnect();
                            return sb.toString();
                        }
                    }
                } catch (NoSuchAlgorithmException e2) {
                    Log.e(a.this.f7907b, e2.toString());
                    e2.printStackTrace();
                    return "";
                } catch (UnsupportedEncodingException e3) {
                    Log.e(a.this.f7907b, e3.toString());
                    e3.printStackTrace();
                    return "";
                } catch (ProtocolException e4) {
                    Log.e(a.this.f7907b, e4.toString());
                    e4.printStackTrace();
                    return "";
                } catch (MalformedURLException e5) {
                    Log.e(a.this.f7907b, e5.toString());
                    e5.printStackTrace();
                    return "";
                } catch (IOException e6) {
                    Log.e(a.this.f7907b, e6.toString());
                    e6.printStackTrace();
                    return "";
                } catch (KeyManagementException e7) {
                    Log.e(a.this.f7907b, e7.toString());
                    e7.printStackTrace();
                    return "";
                }
            }
        }, 0);
    }
}
