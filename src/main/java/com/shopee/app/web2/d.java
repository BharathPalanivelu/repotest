package com.shopee.app.web2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.util.bc;
import com.shopee.app.util.bm;
import com.shopee.app.util.x;
import com.shopee.app.web2.a.a;
import com.shopee.app.web2.a.b;
import com.shopee.app.web2.a.c;
import com.shopee.app.web2.a.e;
import com.shopee.app.web2.a.f;
import com.shopee.app.web2.a.g;
import com.shopee.app.web2.a.h;
import com.shopee.app.web2.a.i;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class d extends FrameLayout implements SwipeRefreshLayout.b {
    private boolean A = true;
    private boolean B = false;
    private ConfigurePageRequest.ConfigMessage C;
    private List<h> D;
    private String E = null;
    private boolean F = false;
    /* access modifiers changed from: private */
    public boolean G = false;
    private Runnable H = new Runnable() {
        public void run() {
            if (d.this.G) {
                d.this.h();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public WebPageModel f26664a;

    /* renamed from: b  reason: collision with root package name */
    public List<Dialog> f26665b;

    /* renamed from: c  reason: collision with root package name */
    public Object f26666c = null;

    /* renamed from: d  reason: collision with root package name */
    public WebView f26667d;

    /* renamed from: e  reason: collision with root package name */
    public View f26668e;

    /* renamed from: f  reason: collision with root package name */
    FrameLayout f26669f;

    /* renamed from: g  reason: collision with root package name */
    Activity f26670g;
    View h;
    SwipeRefreshLayout i;
    c j;
    bc k;
    UserInfo l;
    public String m;
    public String n;
    com.shopee.app.web2.a.d o;
    f p;
    i q;
    b r;
    c s;
    g t;
    e u;
    a v;
    private final com.shopee.web.sdk.bridge.internal.a w;
    private String x;
    private boolean y;
    private SwipeRefreshLayout.b z;

    public boolean a() {
        return this.f26670g.isFinishing();
    }

    public d(Context context, ConfigurePageRequest.ConfigMessage configMessage, com.shopee.web.sdk.bridge.internal.a aVar) {
        super(context);
        this.C = configMessage;
        this.w = aVar;
        a(context);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            ((com.shopee.app.ui.webview.e) ((x) context).b()).a(this);
            this.f26665b = new ArrayList();
            this.D = new ArrayList();
        }
    }

    public void b() {
        if (!this.f26665b.isEmpty()) {
            for (Dialog dismiss : this.f26665b) {
                dismiss.dismiss();
            }
        }
        this.f26665b.clear();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!isInEditMode()) {
            this.k.a(this.j);
            this.j.a(this);
            this.w.a(this.f26667d);
            this.o = new com.shopee.app.web2.a.d(this.i);
            this.o.a(this);
            this.D.add(this.o);
            this.p = new f();
            this.p.a(this);
            this.D.add(this.p);
            this.q = new i();
            this.q.a(this);
            this.D.add(this.q);
            this.s = new c();
            this.s.a(this);
            this.D.add(this.s);
            this.r = new b();
            this.r.a(this);
            this.D.add(this.r);
            this.t = new g();
            this.t.a(this);
            this.D.add(this.t);
            this.u = new e(this.l);
            this.u.a(this);
            this.D.add(this.u);
            this.v = new a();
            this.v.a(this);
            this.D.add(this.v);
            this.f26668e.findViewById(R.id.error_retry).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String str = (!"about:blank".equals(d.this.f26667d.getUrl()) || TextUtils.isEmpty(d.this.m)) ? "" : d.this.m;
                    if (TextUtils.isEmpty(str)) {
                        str = d.this.f26664a.getUrl();
                    }
                    d.this.d();
                    d.this.f26667d.setVisibility(0);
                    d.this.f26668e.setVisibility(8);
                    d.this.f26667d.loadUrl(str);
                }
            });
        }
    }

    public void a(WebPageModel webPageModel) {
        this.f26664a = webPageModel;
        this.x = webPageModel.getLastPageJS();
        setCurUrl(webPageModel.getUrl());
        a(true);
    }

    public Activity getActivity() {
        return this.f26670g;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f26667d.evaluateJavascript(str, (ValueCallback) null);
            return;
        }
        if (str.startsWith("javascript:")) {
            str = str.substring(11);
        }
        String a2 = bm.a(str);
        WebView webView = this.f26667d;
        webView.loadUrl("javascript:eval(decodeURIComponent(\"" + a2 + "\"))");
    }

    private void c(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(str);
            } else {
                com.garena.android.appkit.f.f.a().a(new Runnable() {
                    public void run() {
                        d.this.b(str);
                    }
                });
            }
        }
    }

    public void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            com.garena.android.appkit.f.f.a().a(runnable);
        }
    }

    public void a(String str, String str2) {
        c(String.format(Locale.ENGLISH, "$('#%s').val('%s').blur();", new Object[]{str, str2}));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void a(boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.t.a();
        this.f26667d.setWebViewClient(this.q.a());
        this.f26667d.setWebChromeClient(this.p.a());
        this.f26667d.addJavascriptInterface(this.r.a(), "__gapickerbridge__");
        this.f26667d.addJavascriptInterface(this.s.a(), "__gaselectorbridge__");
        this.u.a();
        this.v.a(this.C);
        if (z2) {
            PrintStream printStream = System.out;
            printStream.println("prepareWebView.before-load-url|dur=" + (System.currentTimeMillis() - currentTimeMillis) + " url=" + this.f26664a.getUrl());
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f26667d.loadUrl(this.f26664a.getUrl());
            PrintStream printStream2 = System.out;
            printStream2.println("prepareWebView.after-load-url|dur=" + (System.currentTimeMillis() - currentTimeMillis2) + " url=" + this.f26664a.getUrl());
            return;
        }
        PrintStream printStream3 = System.out;
        printStream3.println("prepareWebView.no-load|dur=" + (System.currentTimeMillis() - currentTimeMillis) + " url=" + this.f26664a.getUrl());
    }

    public void a(ConfigurePageRequest.ConfigMessage configMessage) {
        this.C = configMessage;
        this.v.a(configMessage);
    }

    public String getAppVer() {
        return com.shopee.app.react.modules.app.appmanager.a.b();
    }

    public String getRNVer() {
        return String.valueOf(com.shopee.app.react.g.a().i());
    }

    public void d() {
        if (!this.o.a()) {
            View view = this.h;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void e() {
        View view = this.h;
        if (view != null) {
            view.setVisibility(8);
        }
        this.o.b();
    }

    public c getPresenter() {
        return this.j;
    }

    public void onRefresh() {
        if (!"about:blank".equals(this.f26667d.getUrl())) {
            com.shopee.app.ui.webview.i.h(this.f26667d.getUrl());
            this.f26667d.reload();
        } else {
            String str = !TextUtils.isEmpty(this.m) ? this.m : "";
            if (TextUtils.isEmpty(str)) {
                str = this.f26664a.getUrl();
            }
            this.f26667d.setVisibility(0);
            this.f26668e.setVisibility(8);
            com.shopee.app.ui.webview.i.h(str);
            this.f26667d.loadUrl(str);
        }
        SwipeRefreshLayout.b bVar = this.z;
        if (bVar != null) {
            bVar.onRefresh();
        }
    }

    public String getCurrentUrl() {
        return this.E;
    }

    public void setCurUrl(String str) {
        this.E = str;
    }

    public void f() {
        if (this.F) {
            this.f26669f.addView(this.f26667d, new FrameLayout.LayoutParams(-1, -1));
        }
        this.F = false;
        this.G = false;
        this.B = false;
        this.w.a();
    }

    public void g() {
        this.w.b();
        if (this.A && !this.B) {
            this.G = true;
            postDelayed(this.H, 1000);
        }
    }

    public void h() {
        try {
            this.f26669f.removeView(this.f26667d);
            this.f26667d.setLayerType(0, (Paint) null);
            this.F = true;
        } catch (Exception unused) {
        }
    }

    public void setLastPageJs(String str) {
        this.x = str;
    }

    public void setDetachable(boolean z2) {
        this.A = z2;
    }

    public void setHasTransparentPopup(boolean z2) {
        this.B = z2;
    }

    public boolean a(String str) {
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        if (org.apache.commons.c.d.a(str) || !str.contains(com.shopee.app.util.i.f7042e)) {
            return false;
        }
        return true;
    }

    public void i() {
        c(String.format(Locale.ENGLISH, "if(typeof($) != 'undefined'){$('input[type=\"%s\"]').attr('type', 'text').off('focus').on('focus', function(e){this.blur();__gapickerbridge__.pick%s(this.id, this.value);});}", new Object[]{"date", HttpConstants.Header.DATE}));
        c(String.format(Locale.ENGLISH, "if(typeof($) != 'undefined'){$('input[type=\"%s\"]').attr('type', 'text').off('focus').on('focus', function(e){this.blur();__gapickerbridge__.pick%s(this.id, this.value);});}", new Object[]{"month", "Month"}));
        c(String.format(Locale.ENGLISH, "if(typeof($) != 'undefined'){$('input[type=\"%s\"]').attr('type', 'text').off('focus').on('focus', function(e){this.blur();__gapickerbridge__.pick%s(this.id, this.value);});}", new Object[]{"time", "Time"}));
        if (!TextUtils.isEmpty(this.x)) {
            String replace = this.x.replace("'", "\\'");
            c(String.format(Locale.ENGLISH, "if(typeof(_deeplink_trigger_) != 'undefined'){_deeplink_trigger_('%s');}", new Object[]{replace}));
            this.x = null;
        }
    }

    public WebView getView() {
        return this.f26667d;
    }

    public boolean j() {
        return this.y;
    }

    public void setShouldEnableReload(boolean z2) {
        this.y = z2;
        this.o.a(z2);
    }
}
