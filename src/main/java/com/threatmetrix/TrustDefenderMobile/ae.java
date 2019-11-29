package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class ae extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final m f32552a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32553b = ae.class.getName();

    public ae(m mVar) {
        this.f32552a = mVar;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        String str3 = this.f32553b;
        Log.d(str3, "onJsAlert() -" + str2);
        this.f32552a.getString(str2);
        jsResult.confirm();
        return true;
    }
}
