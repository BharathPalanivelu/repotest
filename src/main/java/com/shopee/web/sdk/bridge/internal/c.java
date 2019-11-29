package com.shopee.web.sdk.bridge.internal;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.a.l;
import com.google.a.o;
import com.shopee.web.sdk.a.a;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<WebView> f30484a;

    c() {
    }

    public void a(BridgeMessage bridgeMessage) {
        a(a.f30470a.b((Object) bridgeMessage));
    }

    public void a(String str, Object obj) {
        a(str, obj != null ? a.f30470a.a(obj).m() : new o());
    }

    private void a(String str, o oVar) {
        try {
            o oVar2 = new o();
            if (!TextUtils.isEmpty(str)) {
                oVar2.a("responseId", str);
            }
            oVar2.a("responseData", (l) oVar);
            a(oVar2.toString());
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String replace = str.replaceAll("\\\\", "\\\\\\\\").replace("'", "\\'");
            b(String.format(Locale.ENGLISH, "if(typeof(WebViewJavascriptBridge) != 'undefined'){WebViewJavascriptBridge._handleMessageFromObjC('%s');}", new Object[]{replace}));
        } catch (Throwable unused) {
        }
    }

    private void b(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c(str);
            } else {
                a.f30467a.post(new Runnable() {
                    public void run() {
                        c.this.c(str);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            WeakReference<WebView> weakReference = this.f30484a;
            if (weakReference != null && weakReference.get() != null) {
                ((WebView) this.f30484a.get()).evaluateJavascript(str, (ValueCallback) null);
                return;
            }
            return;
        }
        if (str.startsWith("javascript:")) {
            str = str.substring(11);
        }
        String a2 = a.a(str);
        WeakReference<WebView> weakReference2 = this.f30484a;
        if (weakReference2 != null && weakReference2.get() != null) {
            ((WebView) this.f30484a.get()).loadUrl("javascript:eval(decodeURIComponent(\"" + a2 + "\"))");
        }
    }

    public void a(WebView webView) {
        this.f30484a = new WeakReference<>(webView);
    }

    public void a() {
        this.f30484a = null;
    }
}
