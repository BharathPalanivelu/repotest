package com.shopee.app.web2.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.shopee.app.ui.webview.k;
import com.shopee.app.web2.d;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class f extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<Dialog> f26623a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f26624b;

    public void a(d dVar) {
        super.a(dVar);
        this.f26623a = new ArrayList();
    }

    public WebChromeClient a() {
        return new a();
    }

    public class a extends WebChromeClient {
        public a() {
        }

        @SuppressLint({"SetJavaScriptEnabled"})
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Activity e2 = f.this.e();
            if (e2 == null || e2.isFinishing()) {
                return false;
            }
            final Dialog dialog = new Dialog(e2);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.web_dialog_layout);
            dialog.setCancelable(true);
            dialog.show();
            f.this.f26623a.add(dialog);
            final WebView webView2 = (WebView) dialog.findViewById(R.id.webView);
            webView2.setOverScrollMode(2);
            WebSettings settings = webView2.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(false);
            settings.setUseWideViewPort(false);
            settings.setSupportMultipleWindows(true);
            if (Build.VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            webView2.setWebChromeClient(new a());
            dialog.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                    webView2.destroy();
                }
            });
            webView2.requestFocusFromTouch();
            webView2.setWebViewClient(new WebViewClient());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            Activity e2 = f.this.e();
            if (e2 == null || e2.isFinishing()) {
                return false;
            }
            k unused = f.this.f26624b = new k(e2);
            f.this.f26624b.a(valueCallback);
            return true;
        }
    }
}
