package com.threatmetrix.TrustDefenderMobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.slf4j.Marker;

class l extends af {

    /* renamed from: d  reason: collision with root package name */
    private static final Method f32588d = a(WebView.class, "evaluateJavascript", String.class, ValueCallback.class);

    /* renamed from: e  reason: collision with root package name */
    private static final Method f32589e = a(WebSettings.class, "getDefaultUserAgent", Context.class);

    /* renamed from: f  reason: collision with root package name */
    private static final Method f32590f = a(WebSettings.class, "setPluginState", WebSettings.PluginState.class);

    /* renamed from: g  reason: collision with root package name */
    private static final Method f32591g = a(WebView.class, "removeJavascriptInterface", String.class);
    private static final Method h = a(WebView.class, "addJavascriptInterface", Object.class, String.class);
    private static final String i = "com.threatmetrix.TrustDefenderMobile.l";
    private static final TreeMap<Integer, String> m = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    private WebView f32592a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32593b;

    /* renamed from: c  reason: collision with root package name */
    private m f32594c;
    private boolean j;
    private WebSettings k;
    private final boolean l;

    static {
        if (f32588d == null && Build.VERSION.SDK_INT >= 19) {
            Log.e(i, "Failed to find expected function: evaluateJavascript");
        }
        if (f32589e == null && Build.VERSION.SDK_INT >= 17) {
            Log.e(i, "Failed to find expected function: getDefaultUserAgent");
        }
        if (f32590f == null && (Build.VERSION.SDK_INT >= 8 || Build.VERSION.SDK_INT <= 18)) {
            Log.e(i, "Failed to find expected function: setPluginState");
        }
        if (f32591g == null && Build.VERSION.SDK_INT >= 11) {
            Log.e(i, "Failed to find expected function: removeJavascriptInterface");
        }
        if (h == null && Build.VERSION.SDK_INT >= 17) {
            Log.e(i, "Failed to find expected function: addJavascriptInterface");
        }
        m.put(9, "533.1");
        m.put(10, "533.1");
        m.put(11, "533.1");
        m.put(12, "533.1");
        m.put(13, "534.13");
        m.put(14, "534.30");
        m.put(15, "534.30");
        m.put(16, "534.30");
        m.put(17, "534.30");
        m.put(18, "534.30");
    }

    public static boolean a() {
        return f32588d != null;
    }

    public static boolean b() {
        try {
            return Build.VERSION.RELEASE.startsWith("2.3");
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(Context context) {
        String str = (String) a((Object) null, f32589e, context);
        if (str != null && !str.isEmpty()) {
            return str;
        }
        if (this.l) {
            WebSettings webSettings = this.k;
            if (webSettings != null) {
                str = webSettings.getUserAgentString();
            }
        }
        if (str == null || str.isEmpty()) {
            return c();
        }
        return str;
    }

    public static String c() {
        String str;
        Log.d(i, "Generating a browser string");
        if (m.containsKey(Integer.valueOf(Build.VERSION.SDK_INT))) {
            str = m.get(Integer.valueOf(Build.VERSION.SDK_INT));
        } else {
            str = m.lastEntry().getValue() + Marker.ANY_NON_NULL_MARKER;
        }
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        if (!country.isEmpty()) {
            language = language + "-" + country;
        }
        return "Mozilla/5.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + language.toLowerCase(Locale.US) + "; " + Build.MODEL + " Build/" + Build.DISPLAY + ") AppleWebKit/" + str + " (KHTML, like Gecko) Version/4.0 Mobile Safari/" + str + SQLBuilder.BLANK + ab.f32535a;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public l(Context context, m mVar, boolean z) {
        this.f32592a = null;
        this.f32593b = false;
        this.f32594c = null;
        this.j = false;
        this.j = b();
        String str = i;
        StringBuilder sb = new StringBuilder();
        sb.append("JSExecutor() Build: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append(this.j ? " busted js interface " : " normal js interface ");
        sb.append(a() ? " has async interface " : " has no async interface ");
        Log.d(str, sb.toString());
        this.f32594c = mVar;
        this.l = z;
        if (z) {
            boolean a2 = t.a();
            this.f32593b = false;
            this.f32592a = t.a(context);
            if (this.f32592a != null) {
                if (a2 && !this.f32593b) {
                    Log.w(i, "WebView re-used from previous instance. Using a short-lived TrustDefenderMobile object is not recommended. Better profiling performance will be achieved by re-using a long-lived TrustDefenderMobile instance");
                }
                String str2 = i;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Webview ");
                sb2.append(this.f32593b ? "init'd" : "un-init'd");
                Log.d(str2, sb2.toString());
                if (this.f32594c == null) {
                    this.f32594c = new m((CountDownLatch) null);
                }
                WebViewClient webViewClient = new WebViewClient();
                this.k = this.f32592a.getSettings();
                this.k.setJavaScriptEnabled(true);
                a((Object) this.k, f32590f, WebSettings.PluginState.ON);
                this.f32592a.setVisibility(4);
                if (!this.j) {
                    a((Object) this.f32592a, f32591g, "androidJSInterface");
                }
                this.f32592a.setWebViewClient(webViewClient);
                if (a()) {
                    if (this.f32594c.f32595a == null) {
                        Log.e(i, "alternate JS interface but no global latch");
                    }
                    Log.d(i, "JSExecutor() alternate JS interface detected");
                } else if (!this.j) {
                    a((Object) this.f32592a, h, this.f32594c, "androidJSInterface");
                } else {
                    if (this.f32594c.f32595a == null) {
                        Log.e(i, "broken JS interface but no global latch");
                    }
                    Log.d(i, "JSExecutor() Broken JS interface detected, using workaround");
                    this.f32592a.setWebChromeClient(new ae(this.f32594c));
                }
            }
        }
    }

    public void d() throws InterruptedException {
        String str;
        CountDownLatch countDownLatch;
        Log.d(i, "init() - init'd = " + this.f32593b);
        if (this.f32593b) {
            return;
        }
        if (this.f32592a == null) {
            Log.d(i, "init() - No web view, nothing needs to be done");
            this.f32593b = true;
            return;
        }
        Log.d(i, "init() loading bogus page");
        if (this.j || a()) {
            str = "<html><head></head><body></body></html>";
            countDownLatch = null;
        } else {
            countDownLatch = new CountDownLatch(1);
            Log.d(i, "Creating latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
            this.f32594c.a(countDownLatch);
            this.f32594c.f32596b = null;
            str = "<html><head></head><body onLoad='javascript:window.androidJSInterface.getString(1)'></body></html>";
        }
        if (!Thread.currentThread().isInterrupted()) {
            this.f32592a.loadData(str, "text/html", (String) null);
            if (this.j || countDownLatch == null || a()) {
                this.f32593b = true;
                return;
            }
            Log.d(i, "waiting for latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
            if (!countDownLatch.await(5, TimeUnit.SECONDS)) {
                Log.e(i, "timed out waiting for javascript");
                return;
            }
            this.f32593b = true;
            Log.d(i, "in init() count = " + countDownLatch.getCount());
            if (this.f32594c.f32596b == null) {
                Log.d(i, "init() After latch: got null");
                return;
            }
            Log.d(i, "init() After latch: got " + this.f32594c.f32596b);
        }
    }

    public String a(String str) throws InterruptedException {
        CountDownLatch countDownLatch;
        String str2;
        if (!this.f32593b) {
            return null;
        }
        if (Thread.currentThread().isInterrupted()) {
            return "";
        }
        boolean z = true;
        if (this.j || a()) {
            countDownLatch = null;
        } else {
            countDownLatch = new CountDownLatch(1);
            this.f32594c.a(countDownLatch);
        }
        if (a()) {
            str2 = "javascript:(function(){try{return " + str + " + \"\";}catch(js_eval_err){return '';}})();";
        } else if (!this.j) {
            str2 = "javascript:window.androidJSInterface.getString((function(){try{return " + str + " + \"\";}catch(js_eval_err){return '';}})());";
        } else {
            str2 = "javascript:alert((function(){try{return " + str + " + \"\";}catch(js_eval_err){return '';}})());";
        }
        Log.d(i, "getJSResult() attempting to execute: " + str2);
        this.f32594c.f32596b = null;
        if (a()) {
            try {
                f32588d.invoke(this.f32592a, new Object[]{str2, this.f32594c});
                z = false;
            } catch (IllegalAccessException e2) {
                Log.e(i, "getJSResult() invoke failed: ", e2);
            } catch (IllegalArgumentException e3) {
                Log.e(i, "getJSResult() invoke failed: ", e3);
            } catch (InvocationTargetException e4) {
                Log.e(i, "getJSResult() invoke failed: ", e4);
            }
            if (z && this.f32594c.f32595a != null) {
                Log.d(i, "getJSResult countdown for latch: " + this.f32594c.f32595a.hashCode() + " with count: " + this.f32594c.f32595a.getCount());
                this.f32594c.f32595a.countDown();
            }
        } else {
            this.f32592a.loadUrl(str2);
        }
        if (this.j || a()) {
            return null;
        }
        if (countDownLatch != null) {
            Log.d(i, "getJSResult waiting for latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
            if (!countDownLatch.await(5, TimeUnit.SECONDS)) {
                Log.d(i, "getJSResult timeout waiting for latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
            }
        } else {
            Log.e(i, "latch == null");
        }
        if (this.f32594c.f32596b == null) {
            Log.d(i, "getJSResult() After latch: got null");
        } else {
            Log.d(i, "getJSResult() After latch: got " + this.f32594c.f32596b);
        }
        return this.f32594c.f32596b;
    }

    public boolean a(boolean z) {
        return z != this.l || !this.f32593b;
    }
}
