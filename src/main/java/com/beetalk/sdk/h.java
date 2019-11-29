package com.beetalk.sdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.beetalk.sdk.b;
import com.beetalk.sdk.data.d;
import com.beetalk.sdk.e.c;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.garena.d.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.tls.platform.SigType;

public class h extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f5440a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b.a f5441b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f5442c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5440a = new WebView(this);
        this.f5440a.getSettings().setUseWideViewPort(true);
        this.f5440a.getSettings().setLoadWithOverviewMode(true);
        this.f5440a.getSettings().setJavaScriptEnabled(true);
        this.f5440a.getSettings().setBuiltInZoomControls(true);
        this.f5440a.clearCache(true);
        CookieManager.getInstance().removeAllCookie();
        if (TextUtils.isEmpty(g.d())) {
            setTitle(a.f.beetalk_sdk_label_garena_login);
        } else {
            setTitle(g.d());
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(getResources().getColor(a.b.com_facebook_blue));
        setContentView(linearLayout);
        linearLayout.addView(this.f5440a, new LinearLayout.LayoutParams(-1, -1));
        this.f5440a.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                h.this.a(b.c.a(h.this.f5441b, com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED.getCode().intValue()));
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!str.contains(l.g()) && !str.contains(h.this.f5442c)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                int indexOf = str.indexOf("code=");
                if (indexOf != -1) {
                    final String substring = str.substring(indexOf + 5);
                    com.beetalk.sdk.e.a.c("web code 1%s %s", str, substring);
                    com.beetalk.sdk.f.a.a().a(new Runnable() {
                        public void run() {
                            h.this.a(substring);
                        }
                    });
                } else {
                    int indexOf2 = str.indexOf("error=");
                    if (indexOf2 == -1) {
                        com.beetalk.sdk.f.a.a().a(new Runnable() {
                            public void run() {
                                h.this.a(com.garena.pay.android.a.UNKNOWN_ERROR.getCode().intValue());
                            }
                        });
                    } else if (str.substring(indexOf2 + 6).equals("access_denied")) {
                        h.this.a();
                    }
                }
                return true;
            }
        });
        this.f5440a.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(SigType.TLS);
                intent.setData(Uri.parse(str));
                h.this.startActivity(intent);
            }
        });
        try {
            this.f5441b = (b.a) getIntent().getSerializableExtra("garena_request_info");
            String e2 = this.f5441b.e();
            this.f5442c = l.i + this.f5441b.e() + "://auth/";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.f5442c));
            arrayList.add(new BasicNameValuePair(ShareConstants.FEED_SOURCE_PARAM, g.b().toString()));
            arrayList.add(new BasicNameValuePair(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "code"));
            arrayList.add(new BasicNameValuePair("client_id", e2));
            arrayList.add(new BasicNameValuePair("display", "embedded"));
            Locale c2 = c.c(getApplicationContext());
            if (c2 != null) {
                arrayList.add(new BasicNameValuePair("locale", c2.toString()));
            }
            try {
                this.f5440a.getSettings().setUserAgentString(new com.beetalk.sdk.f.b(this).toString());
                WebView webView = this.f5440a;
                webView.loadUrl(l.f() + com.beetalk.sdk.f.c.a((List<NameValuePair>) arrayList));
            } catch (UnsupportedEncodingException e3) {
                com.beetalk.sdk.e.a.a((Exception) e3);
                finish();
            }
        } catch (NullPointerException e4) {
            com.beetalk.sdk.e.a.a((Exception) e4);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.beetalk.sdk.e.a.c("onAuthSuccess-user code %s", str);
        final b.c a2 = a(str, this.f5441b);
        this.f5440a.post(new Runnable() {
            public void run() {
                h.this.a(a2);
            }
        });
    }

    private b.c a(String str, b.a aVar) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("grant_type", "authorization_code");
        hashMap.put("code", str);
        hashMap.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.f5442c);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, g.b().toString());
        hashMap.put("client_id", aVar.e());
        hashMap.put("client_secret", aVar.f());
        JSONObject a2 = com.beetalk.sdk.f.c.a().a(l.d(), hashMap);
        int intValue = com.garena.pay.android.a.UNKNOWN_ERROR.getCode().intValue();
        b.c cVar = null;
        if (a2 == null) {
            intValue = com.garena.pay.android.a.NETWORK_EXCEPTION.getCode().intValue();
        } else if (a2 == null || !a2.has("open_id")) {
            intValue = com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED.getCode().intValue();
        } else {
            try {
                String string = a2.getString("open_id");
                String string2 = a2.getString("access_token");
                String string3 = a2.getString("refresh_token");
                int i = a2.getInt("expiry_time");
                com.beetalk.sdk.data.a aVar2 = new com.beetalk.sdk.data.a(string2, d.GARENA_WEB_ANDROID);
                aVar2.b(string3);
                aVar2.a(i);
                cVar = b.c.a(aVar, aVar2, string);
            } catch (JSONException e2) {
                com.beetalk.sdk.e.a.a((Exception) e2);
            }
        }
        return cVar == null ? b.c.a(aVar, intValue) : cVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        com.beetalk.sdk.e.a.c("onAuthFailed-failed", new Object[0]);
        final b.c a2 = b.c.a(this.f5441b, i);
        this.f5440a.post(new Runnable() {
            public void run() {
                h.this.a(a2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(b.c cVar) {
        Intent intent = new Intent();
        intent.putExtra("garena_auth_result", cVar);
        setResult(b.c.a(cVar.resultCode) ? 0 : -1, intent);
        finish();
    }
}
