package com.shopee.app.ui.webview.simpleweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.ui.webview.e;
import com.shopee.app.ui.webview.k;
import com.shopee.app.util.x;
import com.shopee.app.web.RenderProcessGoneHandlerClient;
import com.shopee.id.R;
import java.util.List;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageButton f26079a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f26080b;

    /* renamed from: c  reason: collision with root package name */
    WebView f26081c;

    /* renamed from: d  reason: collision with root package name */
    TextView f26082d;

    /* renamed from: e  reason: collision with root package name */
    ProgressBar f26083e;

    /* renamed from: f  reason: collision with root package name */
    Activity f26084f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f26085g;
    /* access modifiers changed from: private */
    public WebPageModel h;
    /* access modifiers changed from: private */
    public k i;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f26081c.canGoBack()) {
            this.f26081c.goBack();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f26081c.canGoForward()) {
            this.f26081c.goForward();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f26081c.reload();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        findViewById(R.id.toolbar).setVisibility(0);
        this.f26079a.setAlpha(0.5f);
        this.f26080b.setAlpha(0.5f);
        this.f26080b.setEnabled(false);
        this.f26079a.setEnabled(false);
        this.f26082d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String a2 = (!"about:blank".equals(b.this.f26081c.getUrl()) || TextUtils.isEmpty(b.this.f26085g)) ? "" : b.this.f26085g;
                if (TextUtils.isEmpty(a2)) {
                    a2 = b.this.h.getUrl();
                }
                b.this.e();
                b.this.f26081c.setVisibility(0);
                b.this.f26082d.setVisibility(8);
                b.this.f26081c.loadUrl(a2);
            }
        });
    }

    public void a(WebPageModel webPageModel, boolean z) {
        this.h = webPageModel;
        a(z);
    }

    public void a(int i2, List<String> list) {
        k kVar = this.i;
        if (kVar != null) {
            kVar.a(i2, list);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void a(boolean z) {
        WebSettings settings = this.f26081c.getSettings();
        StringBuilder sb = new StringBuilder();
        sb.append(settings.getUserAgentString());
        sb.append(z ? "" : " Shopee Beeshop");
        settings.setUserAgentString((sb.toString() + " locale/" + ar.f().e().deviceStore().b()) + " version=297");
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setSupportMultipleWindows(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.f26081c.setWebViewClient(new C0398b());
        this.f26081c.setWebChromeClient(new a());
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(33554432);
        settings.setAppCachePath(getContext().getCacheDir().toString());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        this.f26081c.getSettings().setCacheMode(-1);
        this.f26081c.loadUrl(this.h.getUrl());
    }

    public void e() {
        this.f26083e.setVisibility(0);
    }

    public void f() {
        this.f26083e.setVisibility(8);
    }

    public class a extends WebChromeClient {
        public a() {
        }

        @SuppressLint({"SetJavaScriptEnabled"})
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            final Dialog dialog = new Dialog(b.this.getContext());
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.web_dialog_layout);
            dialog.setCancelable(true);
            dialog.show();
            final WebView webView2 = (WebView) dialog.findViewById(R.id.webView);
            webView2.setOverScrollMode(2);
            webView2.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                webView2.getSettings().setMixedContentMode(0);
            }
            webView2.setWebChromeClient(new WebChromeClient() {
                public void onCloseWindow(WebView webView) {
                    dialog.dismiss();
                    webView.destroy();
                }
            });
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
            b bVar = b.this;
            k unused = bVar.i = new k(bVar.f26084f);
            b.this.i.a(valueCallback);
            return true;
        }
    }

    /* renamed from: com.shopee.app.ui.webview.simpleweb.b$b  reason: collision with other inner class name */
    public class C0398b extends RenderProcessGoneHandlerClient {
        C0398b() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("tel:")) {
                b.this.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            } else if (str.startsWith("mailto:")) {
                MailTo parse = MailTo.parse(str);
                b.this.getContext().startActivity(a(b.this.getContext(), parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
                return true;
            } else if (!str.startsWith("shopeeid")) {
                return super.shouldOverrideUrlLoading(webView, str);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                b.this.f26081c.setWebViewClient(new WebViewClient());
                b.this.f26084f.startActivity(intent);
                return true;
            }
        }

        private Intent a(Context context, String str, String str2, String str3, String str4) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
            intent.putExtra("android.intent.extra.TEXT", str3);
            intent.putExtra("android.intent.extra.SUBJECT", str2);
            intent.putExtra("android.intent.extra.CC", str4);
            intent.setType("message/rfc822");
            return intent;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            try {
                ar.f().e().fabricClient().a("webUrl", str);
            } catch (Exception unused) {
            }
            com.shopee.app.ui.webview.b.a(webView, str);
            b.this.e();
        }

        public void onPageFinished(WebView webView, String str) {
            b.this.f();
            if (b.this.f26081c.canGoForward()) {
                b.this.f26079a.setAlpha(1.0f);
                b.this.f26079a.setEnabled(true);
            } else {
                b.this.f26079a.setAlpha(0.5f);
                b.this.f26079a.setEnabled(false);
            }
            if (b.this.f26081c.canGoBack()) {
                b.this.f26080b.setAlpha(1.0f);
                b.this.f26080b.setEnabled(true);
                return;
            }
            b.this.f26080b.setAlpha(0.5f);
            b.this.f26080b.setEnabled(false);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            b.this.f26081c.loadUrl("javascript:document.body.innerHTML='';");
            if (!"about:blank".equals(b.this.f26081c.getUrl()) && !TextUtils.isEmpty(b.this.f26081c.getUrl())) {
                b bVar = b.this;
                String unused = bVar.f26085g = bVar.f26081c.getUrl();
            }
            b.this.f26081c.loadDataWithBaseURL((String) null, "<html><head><meta charset=\"UTF-8\"></head><body></body></html>", "text/html", "UTF-8", (String) null);
            b.this.f26082d.setVisibility(0);
            b.this.f26081c.setVisibility(8);
            b.this.f();
        }
    }
}
