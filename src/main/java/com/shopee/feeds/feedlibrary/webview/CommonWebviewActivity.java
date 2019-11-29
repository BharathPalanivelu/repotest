package com.shopee.feeds.feedlibrary.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.GetInsTokenEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.i;

public class CommonWebviewActivity extends com.shopee.feeds.feedlibrary.activity.a {
    @BindView
    RobotoTextView btnTopBack;

    /* renamed from: c  reason: collision with root package name */
    private WebView f28733c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f28734d;

    /* renamed from: e  reason: collision with root package name */
    private String f28735e;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    @BindView
    LinearLayout llMainLayout;
    @BindView
    RelativeLayout llTitleLayout;
    @BindView
    RobotoTextView tvRight;
    @BindView
    FrameLayout webviewContainer;
    @BindView
    WebView webviewContent;

    public boolean e() {
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_common_webview);
        getWindow().setFormat(-3);
        this.f7086a = this;
        ButterKnife.a((Activity) this);
        this.f28734d = d.a((Activity) this, "url");
        this.f28735e = d.a((Activity) this, "title");
        this.f28733c = (WebView) findViewById(c.e.webview_content);
        this.f28733c.getSettings().setJavaScriptEnabled(true);
        this.f28733c.getSettings().setDefaultTextEncodingName("utf-8");
        this.f28733c.getSettings().setDomStorageEnabled(true);
        this.f28733c.getSettings().setBuiltInZoomControls(true);
        this.f28733c.getSettings().setUseWideViewPort(true);
        this.f28733c.getSettings().setLoadWithOverviewMode(true);
        this.f28733c.clearHistory();
        this.f28733c.clearFormData();
        this.f28733c.clearCache(true);
        this.f28733c.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.f28733c.getSettings().setBlockNetworkImage(true);
        this.f28733c.setInitialScale(100);
        this.f28733c.setScrollBarStyle(33554432);
        this.f28733c.setWebViewClient(new a());
        if (!d.a(this.f28734d)) {
            if (this.f28734d.indexOf("http") == -1) {
                this.f28734d = "http://" + this.f28734d;
            }
            this.f28733c.loadUrl(this.f28734d);
        }
        if (!d.a(this.f28735e)) {
            this.btnTopBack.setText(this.f28735e);
            this.ivRight.setVisibility(8);
            this.tvRight.setVisibility(8);
        }
    }

    private class a extends WebViewClient {
        public void onReceivedError(WebView webView, int i, String str, String str2) {
        }

        private a() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.contains("shopee://callback#access_token=")) {
                i.a(str.substring(str.indexOf("shopee://callback#access_token=") + 31));
                CookieManager.getInstance().getCookie("https://www.instagram.com/");
                org.greenrobot.eventbus.c.a().c(new GetInsTokenEntity(true));
                CommonWebviewActivity.this.finish();
                return true;
            } else if (!str.contains("shopee://callback?error_reason")) {
                return false;
            } else {
                org.greenrobot.eventbus.c.a().c(new GetInsTokenEntity(false));
                CommonWebviewActivity.this.finish();
                return true;
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String unused = CommonWebviewActivity.this.f28734d = str;
        }
    }

    @OnClick
    public void onClick(View view) {
        if (view.getId() == c.e.iv_left) {
            finish();
        }
    }
}
