package com.shopee.f.a.a.a;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f27220a;

    /* renamed from: b  reason: collision with root package name */
    private e f27221b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27222c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f27223d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f27224e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f27225f = new a();

    /* renamed from: g  reason: collision with root package name */
    private k f27226g;
    private ConcurrentHashMap<String, Boolean> h = new ConcurrentHashMap<>();

    private class a {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f27237b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f27238c;

        private a() {
            this.f27237b = "";
            this.f27238c = "";
        }
    }

    public static j a() {
        if (f27220a == null) {
            synchronized (j.class) {
                if (f27220a == null) {
                    f27220a = new j();
                }
            }
        }
        return f27220a;
    }

    private j() {
    }

    public void a(String str) {
        this.f27223d = str;
        if (!this.f27222c) {
            this.f27221b = new e();
            b();
            this.f27222c = true;
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f27226g = k.a(this.f27223d, 10);
        this.f27226g.a((Callback) new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Log.i("TVC-OptCenter", "prepareUpload failed:" + iOException.getMessage());
            }

            public void onResponse(Call call, Response response) throws IOException {
                Log.i("TVC-OptCenter", "prepareUpload resp:" + response.message());
                if (response.isSuccessful()) {
                    j.this.g(response.body().string());
                }
            }
        });
    }

    public void b() {
        String unused = this.f27225f.f27237b = "";
        String unused2 = this.f27225f.f27238c = "";
        if (this.f27221b != null && !TextUtils.isEmpty(this.f27223d)) {
            this.f27221b.b();
            this.f27221b.a(c.f27194a, (Callback) new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    j.this.d();
                }

                public void onResponse(Call call, Response response) throws IOException {
                    j.this.d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void g(String str) {
        Log.i("TVC-OptCenter", "parsePrepareUploadRsp->response is " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("code", -1);
                try {
                    new String(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "").getBytes("UTF-8"), "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (optInt == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    jSONObject2.optString("appId", "");
                    JSONArray optJSONArray = jSONObject2.optJSONArray("cosRegionList");
                    if (optJSONArray == null) {
                        Log.e("TVC-OptCenter", "parsePrepareUploadRsp , cosRegionList is null!");
                        return;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject3.optString("region", "");
                        String optString2 = jSONObject3.optString("domain", "");
                        int optInt2 = jSONObject3.optInt("isAcc", 0);
                        String optString3 = jSONObject3.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                a(optString, optString2, optInt2, optString3);
                            }
                        }
                    }
                }
            } catch (JSONException e3) {
                Log.e("TVC-OptCenter", e3.toString());
            }
        }
    }

    private void a(final String str, final String str2, int i, String str3) {
        if (TextUtils.isEmpty(str3)) {
            this.f27221b.a(str2, (Callback) new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    j.this.a(str, str2);
                }

                public void onResponse(Call call, Response response) throws IOException {
                    j.this.a(str, str2);
                }
            });
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (str3.contains(";")) {
            String[] split = str3.split(",");
            for (String add : split) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(str3);
        }
        this.f27221b.a(str2, (ArrayList<String>) arrayList);
        a(str, str2);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        synchronized (this.f27226g) {
            final long currentTimeMillis = System.currentTimeMillis();
            final String str3 = str2;
            final String str4 = str;
            this.f27226g.a(str2, (Callback) new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    Log.i("TVC-OptCenter", "detect cos domain " + str3 + " failed , " + iOException.getMessage());
                }

                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        if (j.this.f27224e == 0 || currentTimeMillis < j.this.f27224e) {
                            long unused = j.this.f27224e = currentTimeMillis;
                            String unused2 = j.this.f27225f.f27237b = str4;
                            String unused3 = j.this.f27225f.f27238c = str3;
                            return;
                        }
                        return;
                    }
                    Log.i("TVC-OptCenter", "detect cos domain " + str3 + " failed , httpcode" + response.code());
                }
            });
        }
    }

    public boolean b(String str) {
        e eVar = this.f27221b;
        return eVar != null && eVar.b(str);
    }

    public List<String> c(String str) {
        e eVar = this.f27221b;
        if (eVar != null) {
            return eVar.a(str);
        }
        return null;
    }

    public String c() {
        return this.f27225f.f27237b;
    }

    public void d(String str) {
        this.h.put(str, true);
    }

    public void e(String str) {
        this.h.remove(str);
    }

    public boolean f(String str) {
        if (this.h.containsKey(str)) {
            return this.h.get(str).booleanValue();
        }
        return false;
    }
}
