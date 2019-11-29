package com.airpay.paysdk.pay.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.ui.PaymentOTPWebViewActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentOTPWebViewActivity extends com.airpay.paysdk.base.ui.a.a {

    /* renamed from: b  reason: collision with root package name */
    private String f4278b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f4279c;

    /* renamed from: d  reason: collision with root package name */
    private WebView f4280d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f4281e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f4282f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f4283g = 0;

    /* access modifiers changed from: protected */
    public int a() {
        return c.h.com_garena_airpay_credit_card_otp_web_layout;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void b() {
        this.f4278b = getIntent().getStringExtra("term_url");
        String stringExtra = getIntent().getStringExtra("form_content");
        this.f4283g = getIntent().getLongExtra("key_order_id", 0);
        setTitle(c.i.com_garena_beepay_label_credit_card_verification);
        this.f3840a.setHomeAction(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentOTPWebViewActivity.this.b(view);
            }
        });
        this.f4279c = (ProgressBar) findViewById(c.f.com_garena_beepay_webview_progress_bar);
        this.f4279c.setMax(100);
        this.f4281e = (LinearLayout) findViewById(c.f.com_garena_beepay_webview_error_page);
        this.f4280d = new WebView(this);
        ((FrameLayout) findViewById(c.f.com_garena_beepay_webview_container)).addView(this.f4280d, 0, new FrameLayout.LayoutParams(-1, -1));
        this.f4280d.resumeTimers();
        WebSettings settings = this.f4280d.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.getUserAgentString();
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.f4280d.setWebViewClient(new b(this.f4283g));
        this.f4280d.setWebChromeClient(new c());
        a(this.f4280d);
        this.f4281e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentOTPWebViewActivity.this.a(view);
            }
        });
        this.f4280d.loadDataWithBaseURL((String) null, stringExtra, "text/html", "UTF-8", (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f4282f = false;
        finish();
    }

    /* access modifiers changed from: protected */
    public void a(WebView webView, String str) {
        if (!TextUtils.isEmpty(this.f4278b) && str.startsWith(this.f4278b)) {
            webView.loadUrl("javascript:window.HTMLOUT.getData(document.getElementsByName('PaRes')[0].value,document.getElementsByName('MD')[0].value);");
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"AddJavascriptInterface"})
    public void a(WebView webView) {
        webView.addJavascriptInterface(new a(), "HTMLOUT");
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        h();
        this.f4279c = null;
        WebView webView = this.f4280d;
        if (webView != null) {
            webView.destroy();
            this.f4280d = null;
        }
        this.f4281e = null;
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        WebView webView = this.f4280d;
        if (webView != null && this.f4281e != null && this.f4279c != null) {
            if (z) {
                webView.setVisibility(4);
                this.f4281e.setVisibility(0);
            } else {
                webView.setVisibility(0);
                this.f4281e.setVisibility(4);
            }
            this.f4279c.setVisibility(8);
        }
    }

    public void h() {
        WebView webView = this.f4280d;
        if (webView != null) {
            webView.stopLoading();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("MD", str2);
        intent.putExtra("pares", str);
        setResult(-1, intent);
        finish();
    }

    class a {
        a() {
        }

        @JavascriptInterface
        public void getData(String str, String str2) {
            com.airpay.paysdk.common.c.a.a().a(new Runnable(str, str2) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    PaymentOTPWebViewActivity.a.this.a(this.f$1, this.f$2);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str, String str2) {
            PaymentOTPWebViewActivity.this.h();
            PaymentOTPWebViewActivity.this.a(str, str2);
        }
    }

    private class b extends WebViewClient {

        /* renamed from: b  reason: collision with root package name */
        private long f4286b;

        b(long j) {
            this.f4286b = j;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.airpay.paysdk.common.b.a.d("webview start: " + str, new Object[0]);
        }

        public void onPageFinished(WebView webView, String str) {
            com.airpay.paysdk.common.b.a.d("webview finish: " + str, new Object[0]);
            PaymentOTPWebViewActivity.this.a(webView, str);
            PaymentOTPWebViewActivity paymentOTPWebViewActivity = PaymentOTPWebViewActivity.this;
            paymentOTPWebViewActivity.c(paymentOTPWebViewActivity.f4282f);
        }

        @SuppressLint({"DefaultLocale"})
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Matcher matcher = Pattern.compile("(https?://[^?]*)").matcher(str2);
            if (matcher.find()) {
                matcher.group();
            }
            com.airpay.paysdk.common.b.a.a("onReceivedError, errCode: " + i + ", desc: " + str + ", failingUrl: " + str2, new Object[0]);
            boolean unused = PaymentOTPWebViewActivity.this.f4282f = true;
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            message2.sendToTarget();
        }
    }

    private class c extends WebChromeClient {
        private c() {
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (PaymentOTPWebViewActivity.this.f4279c != null) {
                if (i == 100) {
                    PaymentOTPWebViewActivity.this.f4279c.setProgress(i);
                    PaymentOTPWebViewActivity.this.f4279c.setVisibility(8);
                    return;
                }
                PaymentOTPWebViewActivity.this.f4279c.setVisibility(0);
                PaymentOTPWebViewActivity.this.f4279c.setProgress(i);
            }
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            c cVar = new c(PaymentOTPWebViewActivity.this);
            cVar.a(PaymentOTPWebViewActivity.this.d());
            ((WebView.WebViewTransport) message.obj).setWebView(cVar.a());
            message.sendToTarget();
            return true;
        }
    }
}
