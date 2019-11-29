package com.shopee.web.sdk.bridge.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.google.a.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static f f30470a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b> f30471b;

    /* renamed from: c  reason: collision with root package name */
    private final c f30472c;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<String> f30473d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f30474e;

    private a(C0476a aVar) {
        this.f30471b = aVar.f30475a;
        this.f30472c = new c();
        this.f30473d = new HashSet<>();
        this.f30474e = aVar.f30476b;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(WebView webView) {
        webView.addJavascriptInterface(this, "gabridge");
        this.f30472c.a(webView);
        for (b a2 : this.f30471b.values()) {
            a2.a(webView, this.f30472c);
        }
    }

    public void a() {
        for (b c2 : this.f30471b.values()) {
            c2.c();
        }
    }

    public void b() {
        for (b d2 : this.f30471b.values()) {
            d2.d();
        }
    }

    public void c() {
        this.f30472c.a();
        for (b b2 : this.f30471b.values()) {
            b2.b();
        }
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        for (b a2 : this.f30471b.values()) {
            a2.a(activity, i, i2, intent);
        }
    }

    public void a(Activity activity, int i, String[] strArr, int[] iArr) {
        for (b a2 : this.f30471b.values()) {
            a2.a(activity, i, strArr, iArr);
        }
    }

    @JavascriptInterface
    public void sendMsg(String str) {
        a(str);
    }

    @JavascriptInterface
    public void onHasHandler(String str, String str2) {
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str2)) {
            this.f30473d.add(str);
        } else {
            this.f30473d.remove(str);
        }
    }

    private void a(String str) {
        try {
            BridgeMessage bridgeMessage = (BridgeMessage) f30470a.a(str, BridgeMessage.class);
            if (this.f30474e == null || this.f30474e.contains(bridgeMessage.getHandlerName())) {
                b bVar = this.f30471b.get(bridgeMessage.getHandlerName());
                bVar.a(bridgeMessage.getCallbackId(), f30470a.a(bridgeMessage.getData(), bVar.h()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.garena.b.a.a.b("WebSDK", (Throwable) e2);
        }
    }

    public boolean d() {
        if (!this.f30473d.contains("didTapBack")) {
            return false;
        }
        this.f30472c.a(BridgeMessage.forEvent("didTapBack", (Object) null));
        return true;
    }

    /* renamed from: com.shopee.web.sdk.bridge.internal.a$a  reason: collision with other inner class name */
    public static final class C0476a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Map<String, b> f30475a = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public List<String> f30476b = null;

        public C0476a a(b bVar) {
            if (!this.f30475a.containsKey(bVar.a())) {
                this.f30475a.put(bVar.a(), bVar);
                return this;
            }
            throw new RuntimeException("Duplicated bridge name: " + bVar.a());
        }

        public C0476a a(List<String> list) {
            this.f30476b = list;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
