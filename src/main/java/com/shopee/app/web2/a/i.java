package com.shopee.app.web2.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.MailTo;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.garena.android.appkit.f.f;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.ui.webview.b;
import com.shopee.app.web.RenderProcessGoneHandlerClient;
import com.shopee.app.web2.d;
import com.shopee.shopeetracker.ShopeeTracker;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

public class i extends h {
    public WebViewClient a() {
        return new a(c());
    }

    public static class a extends RenderProcessGoneHandlerClient {

        /* renamed from: a  reason: collision with root package name */
        public String f26630a;

        /* renamed from: b  reason: collision with root package name */
        long f26631b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f26632c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26633d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final d f26634e;

        /* renamed from: f  reason: collision with root package name */
        private Runnable f26635f = new Runnable() {
            public void run() {
                if (a.this.f26634e.f26668e.getVisibility() != 0) {
                    a.this.f26634e.d();
                }
            }
        };

        public a(d dVar) {
            this.f26634e = dVar;
            this.f26630a = this.f26634e.n;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!this.f26632c) {
                this.f26633d = true;
            }
            if ("__WVJB_QUEUE_MESSAGE__".equals(Uri.parse(str).getHost())) {
                return true;
            }
            if (str.startsWith("tel:")) {
                this.f26634e.getActivity().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            } else if (str.startsWith("mailto:")) {
                MailTo parse = MailTo.parse(str);
                this.f26634e.getActivity().startActivity(a(this.f26634e.getActivity(), parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
                return true;
            } else if (str.startsWith("sms:")) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("smsto:" + str.substring(4)));
                this.f26634e.getActivity().startActivity(intent);
                return true;
            } else if (str.startsWith("shopeeid")) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                this.f26634e.getActivity().startActivity(intent2);
                return true;
            } else if (WebPageModel.isPdfUrl(str)) {
                this.f26634e.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else {
                this.f26634e.setCurUrl(str);
                return super.shouldOverrideUrlLoading(webView, str);
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

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (!org.apache.commons.c.d.a(str) && str.endsWith("/favicon.ico")) {
                return new WebResourceResponse("image/x-icon", "UTF-8", new ByteArrayInputStream(new byte[0]));
            }
            if (org.apache.commons.c.d.a(str) || !this.f26634e.a(str)) {
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                if (TextUtils.isEmpty(parse.getLastPathSegment()) || !parse.getLastPathSegment().endsWith(".ttf")) {
                    return null;
                }
                AssetManager assets = this.f26634e.getContext().getAssets();
                return new WebResourceResponse("application/font-sfnt", "UTF-8", assets.open("fonts/" + parse.getLastPathSegment()));
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
                return null;
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f26631b = System.currentTimeMillis();
            b.a(webView, str);
            try {
                ar.f().e().fabricClient().a("webUrl", str);
            } catch (Exception unused) {
            }
            this.f26632c = false;
            if (TextUtils.isEmpty(str) || !str.startsWith(com.shopee.app.util.i.f7040c)) {
                this.f26634e.a(this.f26635f);
            } else {
                f.a().a(this.f26635f, 2000);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("onPageFinished: dur=");
            sb.append(this.f26631b == 0 ? 0 : System.currentTimeMillis() - this.f26631b);
            sb.append(" url=");
            sb.append(str);
            printStream.println(sb.toString());
            this.f26631b = 0;
            if (this.f26633d) {
                this.f26632c = true;
                this.f26633d = false;
            }
            f.a().b(this.f26635f);
            this.f26634e.a((Runnable) new Runnable() {
                public void run() {
                    a.this.f26634e.e();
                }
            });
            if (!this.f26634e.f26667d.getSettings().getLoadsImagesAutomatically()) {
                this.f26634e.f26667d.getSettings().setLoadsImagesAutomatically(true);
            }
            this.f26634e.i();
            String cookie = CookieManager.getInstance().getCookie(this.f26634e.f26664a.getUrl());
            if (cookie != null) {
                String str2 = null;
                String str3 = null;
                for (String trim : cookie.split(";")) {
                    String trim2 = trim.trim();
                    if (trim2.startsWith("SPC_T_IV")) {
                        str3 = trim2.substring(10, trim2.length() - 1);
                    }
                    if (trim2.startsWith("SPC_T_ID")) {
                        str2 = trim2.substring(10, trim2.length() - 1);
                    }
                }
                if (ShopeeTracker.isInitialized()) {
                    ShopeeTracker.getInstance().addConfig("signature", str2);
                    ShopeeTracker.getInstance().addConfig("hash", str3);
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (!"about:blank".equals(this.f26634e.f26667d.getUrl()) && !TextUtils.isEmpty(this.f26634e.f26667d.getUrl())) {
                d dVar = this.f26634e;
                dVar.m = dVar.f26667d.getUrl();
            }
            this.f26634e.f26667d.loadUrl("javascript:document.body.innerHTML='';");
            this.f26634e.f26667d.loadDataWithBaseURL((String) null, "<html><head><meta charset=\"UTF-8\"></head><body></body></html>", "text/html", "UTF-8", (String) null);
            f.a().b(this.f26635f);
            this.f26634e.a((Runnable) new Runnable() {
                public void run() {
                    a.this.f26634e.f26668e.setVisibility(0);
                    a.this.f26634e.f26667d.setVisibility(8);
                    a.this.f26634e.e();
                }
            });
        }
    }
}
