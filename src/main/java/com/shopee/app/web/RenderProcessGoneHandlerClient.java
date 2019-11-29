package com.shopee.app.web;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.h;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.f.f;
import com.shopee.app.application.ar;
import com.shopee.app.ui.home.HomeActivity_;
import d.d.b.j;

public abstract class RenderProcessGoneHandlerClient extends WebViewClient {
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        doWhenRenderProcessGone(webView != null ? webView.getContext() : null);
        logNonFatalReport(renderProcessGoneDetail);
        if (webView == null) {
            return true;
        }
        webView.destroy();
        return true;
    }

    private final void doWhenRenderProcessGone(Context context) {
        f.a().a(new RenderProcessGoneHandlerClient$doWhenRenderProcessGone$1(this, context));
    }

    /* access modifiers changed from: private */
    public final void subscribeToLifecycleEvents(Dialog dialog, Context context) {
        if (context instanceof h) {
            androidx.lifecycle.f renderProcessGoneHandlerClient$subscribeToLifecycleEvents$lifecycleObserver$1 = new RenderProcessGoneHandlerClient$subscribeToLifecycleEvents$lifecycleObserver$1(dialog);
            ((h) context).getLifecycle().a(renderProcessGoneHandlerClient$subscribeToLifecycleEvents$lifecycleObserver$1);
            dialog.setOnDismissListener(new RenderProcessGoneHandlerClient$subscribeToLifecycleEvents$1(context, renderProcessGoneHandlerClient$subscribeToLifecycleEvents$lifecycleObserver$1));
        }
    }

    private final void logNonFatalReport(RenderProcessGoneDetail renderProcessGoneDetail) {
        String errorMessage = getErrorMessage(renderProcessGoneDetail);
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        f2.e().fabricClient().a((Throwable) new Exception(errorMessage), "RenderProcessGoneHandlerClient");
        a.a(errorMessage, new Object[0]);
    }

    private final String getErrorMessage(RenderProcessGoneDetail renderProcessGoneDetail) {
        StringBuilder sb = new StringBuilder();
        sb.append("WebView renderProcess has gone.");
        if (Build.VERSION.SDK_INT >= 26) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\ndetail.didCrash = ");
            sb2.append(renderProcessGoneDetail != null ? renderProcessGoneDetail.didCrash() : false);
            sb.append(sb2.toString());
        }
        String sb3 = sb.toString();
        j.a((Object) sb3, "builder.toString()");
        return sb3;
    }

    /* access modifiers changed from: private */
    public final void jumpToHome(Activity activity) {
        ((HomeActivity_.a) HomeActivity_.a(activity).k(67108864)).a();
    }
}
