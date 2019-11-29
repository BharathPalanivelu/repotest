package com.shopee.app.ui.product.twitter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.web.RenderProcessGoneHandlerClient;

public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    WebView f24906a;

    public c(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24906a.getSettings().setJavaScriptEnabled(true);
        this.f24906a.setWebViewClient(new a());
    }

    public void setUrl(String str) {
        this.f24906a.loadUrl(str);
    }

    private class a extends RenderProcessGoneHandlerClient {
        private a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.contains("oauth_token=") || !str.contains("oauth_verifier=")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra(AbTestingModule.KEY_RESULT, str);
            ((Activity) c.this.getContext()).setResult(-1, intent);
            ((Activity) c.this.getContext()).finish();
            return true;
        }
    }
}
