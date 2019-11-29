package com.shopee.app.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;

public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    WebView f17749a;

    public c(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f17749a.getSettings().setJavaScriptEnabled(true);
        this.f17749a.setWebViewClient(new a());
    }

    public void setUrl(String str) {
        this.f17749a.loadUrl(str);
    }

    private class a extends WebViewClient {
        private a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.contains("shopee://callback#access_token=")) {
                Intent intent = new Intent();
                intent.putExtra(AbTestingModule.KEY_RESULT, str);
                ((Activity) c.this.getContext()).setResult(-1, intent);
                ((Activity) c.this.getContext()).finish();
                return true;
            } else if (!str.contains("shopee://callback?error_reason")) {
                return false;
            } else {
                ((Activity) c.this.getContext()).setResult(0);
                ((Activity) c.this.getContext()).finish();
                return true;
            }
        }
    }
}
