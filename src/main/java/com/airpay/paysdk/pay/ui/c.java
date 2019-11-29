package com.airpay.paysdk.pay.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.base.ui.weidget.b;
import com.airpay.paysdk.c;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private View f4312a;

    /* renamed from: b  reason: collision with root package name */
    private b f4313b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f4314c = new WebView(this.f4312a.getContext());

    public c(Context context) {
        this.f4312a = LayoutInflater.from(context).inflate(c.h.com_garena_beepay_webview_popup, (ViewGroup) null);
        d.a(this.f4312a, c.f.com_garena_beepay_btn_popup_close, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                c.this.b();
            }
        });
        ((FrameLayout) this.f4312a.findViewById(c.f.com_garena_beepay_popup_webview_container)).addView(this.f4314c, new FrameLayout.LayoutParams(-1, -1));
        this.f4314c.setOverScrollMode(2);
        this.f4314c.getSettings().setJavaScriptEnabled(true);
        this.f4314c.setWebChromeClient(new WebChromeClient() {
            public void onCloseWindow(WebView webView) {
                c.this.b();
            }
        });
        this.f4314c.setWebViewClient(new WebViewClient());
    }

    public WebView a() {
        return this.f4314c;
    }

    public void a(View view) {
        this.f4313b = new b(this.f4312a);
        this.f4313b.a(view);
    }

    /* access modifiers changed from: private */
    public void b() {
        b bVar = this.f4313b;
        if (bVar != null) {
            bVar.a();
            WebView webView = this.f4314c;
            if (webView != null) {
                webView.destroy();
                this.f4314c = null;
            }
        }
    }
}
