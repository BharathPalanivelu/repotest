package com.shopee.f.a.a.a;

import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static String f27205b = "http://119.29.29.29/d?dn=";

    /* renamed from: a  reason: collision with root package name */
    private OkHttpClient f27206a = new OkHttpClient().newBuilder().connectTimeout(5, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).build();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, List<String>> f27207c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<String, List<String>> f27208d = new ConcurrentHashMap<>();

    public void a(final String str, final Callback callback) {
        if (!a()) {
            String str2 = f27205b + str;
            Log.i("TVC-TVCDnsCache", "freshDNS->request url:" + str2);
            FirebasePerfOkHttpClient.enqueue(this.f27206a.newCall(new Request.Builder().url(str2).build()), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(call, iOException);
                    }
                    Log.w("TVC-TVCDnsCache", "freshDNS failed :" + iOException.getMessage());
                }

                public void onResponse(Call call, Response response) throws IOException {
                    if (response != null && response.isSuccessful()) {
                        String string = response.body().string();
                        Log.i("TVC-TVCDnsCache", "freshDNS succ :" + string);
                        if (!(string == null || string.length() == 0)) {
                            ArrayList arrayList = new ArrayList();
                            if (string.contains(";")) {
                                String[] split = string.split(";");
                                for (String add : split) {
                                    arrayList.add(add);
                                }
                            } else {
                                arrayList.add(string);
                            }
                            e.this.f27207c.put(str, arrayList);
                            Callback callback = callback;
                            if (callback != null) {
                                callback.onResponse(call, response);
                                return;
                            }
                        }
                    }
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onFailure(call, new IOException("freshDNS failed"));
                    }
                }
            });
        }
    }

    public void a(String str, ArrayList<String> arrayList) {
        if (!a() && arrayList != null && arrayList.size() != 0) {
            this.f27208d.put(str, arrayList);
        }
    }

    public List<String> a(String str) {
        if (this.f27207c.containsKey(str) && this.f27207c.get(str).size() > 0) {
            return this.f27207c.get(str);
        }
        if (!this.f27208d.containsKey(str) || this.f27208d.get(str).size() <= 0) {
            return null;
        }
        return this.f27208d.get(str);
    }

    public boolean b(String str) {
        if (this.f27207c.containsKey(str) && this.f27207c.get(str).size() > 0) {
            return true;
        }
        if (!this.f27208d.containsKey(str) || this.f27208d.get(str).size() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean a() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property == null || property2 == null) {
            return false;
        }
        Log.i("TVC-TVCDnsCache", "use proxy " + property + ":" + property2 + ", will not use httpdns");
        return true;
    }

    public void b() {
        this.f27207c.clear();
        this.f27208d.clear();
    }
}
