package com.shopee.app.ui.webview;

import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import d.d.b.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25830a = new b();

    private b() {
    }

    public static final void a(WebView webView, String str) {
        j.b(webView, "webView");
        j.b(str, "url");
        Uri parse = Uri.parse(str);
        j.a((Object) parse, ShareConstants.MEDIA_URI);
        if (j.a((Object) parse.getHost(), (Object) "payments.gcash.com")) {
            webView.setInitialScale(1);
            WebSettings settings = webView.getSettings();
            j.a((Object) settings, "webView.settings");
            settings.setUseWideViewPort(true);
            return;
        }
        webView.setInitialScale(0);
        WebSettings settings2 = webView.getSettings();
        j.a((Object) settings2, "webView.settings");
        settings2.setUseWideViewPort(false);
    }
}
