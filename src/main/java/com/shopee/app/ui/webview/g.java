package com.shopee.app.ui.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.MailTo;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TimePicker;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.afollestad.materialdialogs.f;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.a.b;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.g.h;
import com.shopee.app.h.m;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.ui.common.au;
import com.shopee.app.ui.common.av;
import com.shopee.app.ui.common.ay;
import com.shopee.app.ui.common.n;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.follow.following.FollowingActivity;
import com.shopee.app.ui.product.newsearch.SearchTabActivity_;
import com.shopee.app.ui.webview.c;
import com.shopee.app.ui.webview.j;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.CartAnimation;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bl;
import com.shopee.app.util.bm;
import com.shopee.app.util.i;
import com.shopee.app.util.u;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.app.web.JavascriptHandler;
import com.shopee.app.web.RenderProcessGoneHandlerClient;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.bridge.WebBridge;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.ConfigureButtonMessage;
import com.shopee.app.web.protocol.ConfigureRightDrawerMessage;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;
import com.shopee.id.R;
import com.shopee.shopeetracker.ShopeeTracker;
import com.squareup.a.ah;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends FrameLayout implements SwipeRefreshLayout.b, com.shopee.app.react.modules.ui.product.e, au {
    private static long ai;
    private static ConnectivityManager al;
    public boolean A = false;
    private String B;
    /* access modifiers changed from: private */
    public WebPageModel C;
    private String D = null;
    /* access modifiers changed from: private */
    public List<Dialog> E;
    /* access modifiers changed from: private */
    public Object F = null;
    private c.b G;
    private UpdateItemShippingMessage H = null;
    /* access modifiers changed from: private */
    public k I;
    private String J = null;
    private SearchConfig K = new SearchConfig();
    private String L = "";
    /* access modifiers changed from: private */
    public String M;
    private boolean N = false;
    private boolean O;
    /* access modifiers changed from: private */
    public String P;
    private String Q;
    /* access modifiers changed from: private */
    public String R;
    private SwipeRefreshLayout.b S;
    /* access modifiers changed from: private */
    public boolean T;
    private int U;
    /* access modifiers changed from: private */
    public g V;
    private g W;

    /* renamed from: a  reason: collision with root package name */
    TouchWebView f25975a;
    private boolean aa = true;
    private boolean ab = false;
    /* access modifiers changed from: private */
    public boolean ac = false;
    /* access modifiers changed from: private */
    public int ad = -1;
    private o ae = null;
    private boolean af = true;
    /* access modifiers changed from: private */
    public final JavascriptHandler ag = new JavascriptHandler(String.valueOf(hashCode()));
    private ViewTreeObserver.OnScrollChangedListener ah;
    /* access modifiers changed from: private */
    public boolean aj = false;
    private boolean ak = false;
    /* access modifiers changed from: private */
    public boolean am = false;
    /* access modifiers changed from: private */
    public boolean an = false;
    private String ao = "";
    private String ap = null;
    private boolean aq = false;
    /* access modifiers changed from: private */
    public String ar = null;
    private boolean as = false;
    /* access modifiers changed from: private */
    public boolean at = false;
    private Runnable au = new Runnable() {
        public void run() {
            if (g.this.at) {
                g.this.D();
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean av = false;
    /* access modifiers changed from: private */
    public ConfigureRightDrawerMessage aw = null;

    /* renamed from: b  reason: collision with root package name */
    View f25976b;

    /* renamed from: c  reason: collision with root package name */
    FrameLayout f25977c;

    /* renamed from: d  reason: collision with root package name */
    Activity f25978d;

    /* renamed from: e  reason: collision with root package name */
    View f25979e;

    /* renamed from: f  reason: collision with root package name */
    SwipeRefreshLayout f25980f;

    /* renamed from: g  reason: collision with root package name */
    f f25981g;
    ak h;
    bc i;
    com.shopee.app.ui.actionbar.a j;
    r k;
    UserInfo l;
    be m;
    ShareConfigStore n;
    m o;
    com.shopee.app.ui.common.a p;
    n q;
    UploadManager r;
    MeCounter s;
    h t;
    WebBridge u;
    public ImageView v;
    public boolean w = false;
    public boolean x = false;
    public int y = 0;
    public boolean z = true;

    public void a(boolean z2) {
        this.f25980f.setEnabled(z2 && this.z && !this.O);
    }

    public void a(ShareMessage shareMessage, h.b bVar) {
        this.t.a(shareMessage, this.n.getShareOptions(), this.n, shareMessage.getShopID() == this.o.g().intValue(), bVar);
    }

    public void a(Activity activity, boolean z2) {
        this.f25978d = activity;
        this.f25980f.getViewTreeObserver().addOnScrollChangedListener(this.ah);
        if (z2) {
            b();
        }
    }

    public void b() {
        this.f25975a.scrollTo(0, 0);
    }

    public g(Context context, String str, String str2, SearchConfig searchConfig) {
        super(context);
        this.B = str;
        this.J = str2;
        this.K = searchConfig;
        a(context);
    }

    public boolean c() {
        return this.f25978d.isFinishing();
    }

    public void d() {
        this.h.f();
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            ((e) ((x) context).b()).a(this);
            this.E = new ArrayList();
            Log.d("LFCY", String.format("AC_INIT %1$s %2$s", new Object[]{getActivity().getLocalClassName(), String.valueOf(hashCode())}));
            this.T = this.f25981g.f();
        }
    }

    public void i() {
        this.k.a();
    }

    public void j() {
        this.k.b();
    }

    public void e() {
        if (!this.E.isEmpty()) {
            for (Dialog dismiss : this.E) {
                dismiss.dismiss();
            }
        }
        this.E.clear();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (!isInEditMode()) {
            this.i.a(this.f25981g);
            this.f25981g.a(this);
            this.u.attachView(this);
            g(this.J);
            ViewTreeObserver viewTreeObserver = this.f25980f.getViewTreeObserver();
            AnonymousClass1 r1 = new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    if (g.this.f25975a.getScrollY() == 0) {
                        g.this.a(true);
                    } else {
                        g.this.a(false);
                    }
                }
            };
            this.ah = r1;
            viewTreeObserver.addOnScrollChangedListener(r1);
            if (!TextUtils.isEmpty(this.B) && !c()) {
                this.E.add(com.shopee.app.ui.dialog.a.a(getContext(), (String) null, this.B, 0, (int) R.string.sp_label_ok));
            }
            this.f25976b.findViewById(R.id.error_retry).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String a2 = (!"about:blank".equals(g.this.f25975a.getUrl()) || TextUtils.isEmpty(g.this.M)) ? "" : g.this.M;
                    if (TextUtils.isEmpty(a2)) {
                        a2 = g.this.C.getUrl();
                    }
                    g.this.q();
                    g.this.ag.setEnabled(true);
                    g.this.f25975a.setVisibility(0);
                    g.this.f25976b.setVisibility(8);
                    g.this.f25975a.loadUrl(a2);
                }
            });
            this.p.a(hashCode(), this);
            this.q.a(this, "Web Page");
        }
    }

    public void a(int i2) {
        if (!p() && this.aq) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - ai > 16) {
                ai = currentTimeMillis;
                t(String.format(Locale.ENGLISH, "window._gascrollY_=%d; if(window.onscroll != null){window.onscroll();} if(typeof(__gawindow__) != 'undefined' && __gawindow__ != null && __gawindow__.scroll != null){__gawindow__.scroll();}", new Object[]{Integer.valueOf(i2)}));
            }
        }
    }

    public void a(WebPageModel webPageModel) {
        this.C = webPageModel;
        setCurUrl(webPageModel.getUrl());
        this.ar = CookieManager.getInstance().getCookie(this.ap);
        d(false);
    }

    public void l() {
        if (TextUtils.isEmpty(this.f25975a.getUrl())) {
            WebPageModel webPageModel = this.C;
            if (webPageModel != null) {
                this.f25975a.loadUrl(webPageModel.getUrl());
            }
        }
    }

    public void b(WebPageModel webPageModel) {
        this.C = webPageModel;
        this.Q = webPageModel.getLastPageJS();
        setCurUrl(webPageModel.getUrl());
        this.ar = CookieManager.getInstance().getCookie(this.ap);
        d(true);
    }

    @SuppressLint({"addJavascriptInterface"})
    public void setIsPlv(boolean z2) {
        this.aj = z2;
        if (z2) {
            this.f25975a.addJavascriptInterface(new a(), "__gaplvbridge__");
        } else {
            this.f25975a.removeJavascriptInterface("__gaplvbridge__");
        }
    }

    class a {
        a() {
        }

        @JavascriptInterface
        public void afterPlvReset() {
            g.this.N();
            Activity activity = g.this.getActivity();
            if (activity instanceof c) {
                ((c) activity).l();
            }
        }

        @JavascriptInterface
        public void plvSetUrl(String str) {
            Activity activity = g.this.getActivity();
            if (activity instanceof c) {
                ((c) activity).a(str);
            }
        }

        @JavascriptInterface
        public void confirmPlv() {
            g.this.A = true;
        }
    }

    public void a(c cVar, String str, int i2) {
        if (this.aj) {
            Context context = getContext();
            if (context instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context).setBaseContext(cVar);
            }
            ((e) cVar.b()).a(this);
            this.f25981g.a(this);
            cVar.a((q) this.f25981g);
            a((Activity) cVar, false);
            a(cVar.c(), str, i2);
        }
    }

    private void a(String str, String str2, int i2) {
        if (this.aj) {
            WebPageModel webPageModel = this.C;
            if (webPageModel != null && str2 != null) {
                webPageModel.setUrl(str2);
                setCurUrl(str2);
                String replace = str2.replaceAll("\\\\", "\\\\\\\\").replace("'", "\\'");
                t(String.format(Locale.ENGLISH, "if(window.plvLoad){window.plvLoad('%s', '%s', %d);}else{location.href='%s';}", new Object[]{str, replace, Integer.valueOf(i2), replace}));
            }
        }
    }

    public void m() {
        if (this.aj) {
            t("if(window.plvTaken){window.plvTaken();}");
        }
    }

    public void b(boolean z2) {
        if (this.aj) {
            this.V = null;
            this.aw = null;
            this.av = false;
            if (z2) {
                t("if(window.plvClean){window.plvClean();}");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        if (this.aj) {
            this.f25978d = null;
            this.i = null;
            this.h = null;
            this.j = null;
            this.f25979e = null;
            this.f25981g = null;
            this.k = null;
            this.t = null;
            Context context = getContext();
            if (context instanceof c.C0397c) {
                ((c.C0397c) context).setBaseContext(ar.f());
            }
        }
    }

    public WebPageModel getPageModel() {
        return this.C;
    }

    public void g(String str) {
        this.O = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                if ("1".equals(new JSONObject(str).optString("disableReload"))) {
                    this.O = true;
                }
            } catch (JSONException unused) {
            }
        }
        if (!this.O) {
            this.f25980f.setOnRefreshListener(this);
        } else {
            this.f25980f.setEnabled(false);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("enableRotation")) {
                    return;
                }
                if ("1".equals(jSONObject.optString("enableRotation"))) {
                    this.f25978d.setRequestedOrientation(2);
                } else {
                    this.f25978d.setRequestedOrientation(1);
                }
            } catch (JSONException unused2) {
            }
        }
    }

    public Activity getActivity() {
        return this.f25978d;
    }

    public void a(int i2, int i3) {
        t(String.format(Locale.ENGLISH, "_gatap_(%d, %d);", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public void setForceDisableNativeTap(boolean z2) {
        this.ak = z2;
    }

    public boolean o() {
        return !this.ak && this.ag.hasGaTap();
    }

    public boolean p() {
        return this.ag.hasInput();
    }

    public boolean b(int i2, int i3) {
        if (i2 < 0 || i3 < 0 || this.ag.getSwipeableRects() == null) {
            return false;
        }
        ConcurrentLinkedQueue<Rect> swipeableRects = this.ag.getSwipeableRects();
        if (swipeableRects.size() == 0) {
            return false;
        }
        int scrollX = i2 + ((int) (((float) this.f25975a.getScrollX()) / this.f25975a.f25803a));
        int scrollY = i3 + ((int) (((float) this.f25975a.getScrollY()) / this.f25975a.f25803a));
        Iterator<Rect> it = swipeableRects.iterator();
        while (it.hasNext()) {
            if (it.next().contains(scrollX, scrollY)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void s(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f25975a.evaluateJavascript(str, (ValueCallback) null);
            return;
        }
        if (str.startsWith("javascript:")) {
            str = str.substring(11);
        }
        String a2 = bm.a(str);
        TouchWebView touchWebView = this.f25975a;
        touchWebView.loadUrl("javascript:eval(decodeURIComponent(\"" + a2 + "\"))");
    }

    /* access modifiers changed from: private */
    public void t(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                s(str);
            } else {
                f.a().a(new Runnable() {
                    public void run() {
                        g.this.s(str);
                    }
                });
            }
        }
    }

    public void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f.a().a(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2) {
        t(String.format(Locale.ENGLISH, "$('#%s').val('%s').blur();", new Object[]{str, str2}));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void d(boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        TouchWebView touchWebView = this.f25975a;
        touchWebView.f25804b = this;
        WebSettings settings = touchWebView.getSettings();
        if (TextUtils.isEmpty(this.P)) {
            this.P = ((((settings.getUserAgentString() + " Shopee Beeshop") + " locale/" + ar.f().e().deviceStore().b()) + " version=297") + " appver=" + getAppVer()) + " rnver=" + getRNVer();
        }
        settings.setUserAgentString(this.P);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.f25975a.setWebViewClient(new e(this));
        this.f25975a.setWebChromeClient(new d());
        this.f25975a.addJavascriptInterface(this.ag, "gabridge");
        this.f25975a.addJavascriptInterface(new b(), "__gapickerbridge__");
        this.f25975a.addJavascriptInterface(new c(), "__gaselectorbridge__");
        int i2 = Build.VERSION.SDK_INT;
        settings.setDomStorageEnabled(true);
        settings.setAppCacheMaxSize(33554432);
        settings.setAppCachePath(getContext().getCacheDir().toString());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        this.f25975a.getSettings().setCacheMode(-1);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.setCookie(this.C.getUrl(), "userid=" + this.l.getUserId() + "; shopid=" + this.l.getShopId() + "; shopee_token=" + this.l.getToken() + "; domain=" + i.f7042e + "; path=/;");
        instance.setCookie(this.C.getUrl(), "shopee_token=" + this.l.getToken() + "; domain=" + i.f7042e + "; path=/;");
        instance.setCookie(this.C.getUrl(), "username=" + this.l.getUsername() + "; domain=" + i.f7042e + "; path=/;");
        instance.setCookie(this.C.getUrl(), "UA=" + bm.a(this.P) + "; domain=" + i.f7042e + "; path=/;");
        CookieSyncManager.getInstance().sync();
        if (z2) {
            System.out.println("prepareWebView.before-load-url|dur=" + (System.currentTimeMillis() - currentTimeMillis) + " url=" + this.C.getUrl());
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f25975a.loadUrl(this.C.getUrl());
            System.out.println("prepareWebView.after-load-url|dur=" + (System.currentTimeMillis() - currentTimeMillis2) + " url=" + this.C.getUrl());
            return;
        }
        System.out.println("prepareWebView.no-load|dur=" + (System.currentTimeMillis() - currentTimeMillis) + " url=" + this.C.getUrl());
    }

    class b {

        /* renamed from: b  reason: collision with root package name */
        private final String[] f26008b = {"date", "month", "time"};

        b() {
        }

        private int a(String str, int i) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i;
            }
        }

        /* access modifiers changed from: private */
        public String a(int i) {
            if (i >= 10) {
                return String.valueOf(i);
            }
            return AppEventsConstants.EVENT_PARAM_VALUE_NO + i;
        }

        private DatePickerDialog a(DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(g.this.getActivity(), R.style.SpinnerDateDialogTheme, onDateSetListener, i, i2, i3);
                try {
                    int identifier = Resources.getSystem().getIdentifier("day", "id", "android");
                    if (identifier != 0) {
                        View findViewById = datePickerDialog.getDatePicker().findViewById(identifier);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                        }
                    }
                } catch (Exception unused) {
                }
                return datePickerDialog;
            }
            DatePickerDialog datePickerDialog2 = new DatePickerDialog(g.this.getActivity(), onDateSetListener, i, i2, i3);
            try {
                for (Field field : datePickerDialog2.getClass().getDeclaredFields()) {
                    if (field.getName().equals("mDatePicker")) {
                        field.setAccessible(true);
                        DatePicker datePicker = (DatePicker) field.get(datePickerDialog2);
                        for (Field field2 : field.getType().getDeclaredFields()) {
                            if ("mDaySpinner".equals(field2.getName())) {
                                field2.setAccessible(true);
                                ((View) field2.get(datePicker)).setVisibility(8);
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return datePickerDialog2;
        }

        public void a(String str, String str2, int i) {
            final String str3 = str;
            String str4 = str2;
            int i2 = i;
            if (g.this.F == null) {
                Calendar instance = Calendar.getInstance();
                int i3 = instance.get(1);
                int i4 = instance.get(2);
                int i5 = instance.get(5);
                int i6 = instance.get(11);
                int i7 = instance.get(12);
                String[] split = str4.split("-");
                if (split.length >= 1) {
                    i3 = a(split[0], i3);
                }
                if (split.length >= 2) {
                    i4 = Math.max(0, a(split[1], i4) - 1);
                }
                if (split.length >= 3) {
                    i5 = a(split[2], i5);
                }
                String[] split2 = str4.split(":");
                if (split2.length >= 1) {
                    i6 = a(split2[0], i6);
                }
                int i8 = i6;
                if (split2.length >= 2) {
                    i7 = a(split2[1], i7);
                }
                int i9 = i7;
                if (i2 == 2) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(g.this.getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            Object unused = g.this.F = null;
                            g.this.b(str3, b.this.a(i) + ":" + b.this.a(i2));
                        }
                    }, i8, i9, true);
                    timePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            Object unused = g.this.F = null;
                        }
                    });
                    if (!g.this.c()) {
                        Object unused = g.this.F = timePickerDialog;
                        g.this.E.add(timePickerDialog);
                        timePickerDialog.show();
                    }
                } else if (i2 == 1) {
                    DatePickerDialog a2 = a(new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            Object unused = g.this.F = null;
                            g.this.b(str3, i + "-" + b.this.a(i2 + 1));
                        }
                    }, i3, i4, i5);
                    a2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            Object unused = g.this.F = null;
                        }
                    });
                    if (!g.this.c()) {
                        Object unused2 = g.this.F = a2;
                        a2.show();
                        g.this.E.add(a2);
                    }
                } else {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(g.this.getActivity(), new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            Object unused = g.this.F = null;
                            g.this.b(str3, i + "-" + b.this.a(i2 + 1) + "-" + b.this.a(i3));
                        }
                    }, i3, i4, i5);
                    datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            Object unused = g.this.F = null;
                        }
                    });
                    if (!g.this.c()) {
                        Object unused3 = g.this.F = datePickerDialog;
                        datePickerDialog.show();
                        g.this.E.add(datePickerDialog);
                    }
                }
            }
        }

        private void b(final String str, final String str2, final int i) {
            g.this.a((Runnable) new Runnable() {
                public void run() {
                    b.this.a(str, str2, i);
                }
            });
        }

        @JavascriptInterface
        public void pickDate(String str, String str2) {
            b(str, str2, 0);
        }

        @JavascriptInterface
        public void pickMonth(String str, String str2) {
            b(str, str2, 1);
        }

        @JavascriptInterface
        public void pickTime(String str, String str2) {
            b(str, str2, 2);
        }
    }

    class c {
        c() {
        }

        @JavascriptInterface
        public void select(String str, String str2, String str3, String str4) {
            final int i;
            if (g.this.F == null) {
                final String[] split = str2.split("\\|");
                final String[] split2 = str3.split("\\|");
                if (split != null && split2 != null && split.length == split2.length && split.length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split.length) {
                            i = -1;
                            break;
                        } else if (split[i2].equals(str4)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    final String str5 = str;
                    g.this.a((Runnable) new Runnable() {
                        public void run() {
                            if (!g.this.c()) {
                                com.afollestad.materialdialogs.f c2 = new f.a(g.this.getContext()).a((CharSequence[]) split2).a(i, (f.C0065f) new f.C0065f() {
                                    public boolean a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                                        Object unused = g.this.F = null;
                                        g.this.b(str5, split[i]);
                                        return true;
                                    }
                                }).a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        Object unused = g.this.F = null;
                                    }
                                }).c();
                                g.this.E.add(c2);
                                Object unused = g.this.F = c2;
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getAppVer() {
        return com.shopee.app.react.modules.app.appmanager.a.b();
    }

    /* access modifiers changed from: protected */
    public String getRNVer() {
        return String.valueOf(com.shopee.app.react.g.a().i());
    }

    /* access modifiers changed from: private */
    public boolean O() {
        if (al == null) {
            al = (ConnectivityManager) getContext().getSystemService("connectivity");
        }
        NetworkInfo activeNetworkInfo = al.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void h(final String str) {
        a((Runnable) new Runnable() {
            public void run() {
                if (str.equals(g.this.f25975a.getUrl()) && !g.this.p()) {
                    if (g.this.f25975a.getHeight() == 0 || g.this.f25975a.getScrollY() < g.this.f25975a.getHeight()) {
                        g gVar = g.this;
                        gVar.w = true;
                        gVar.x = true;
                        gVar.y = gVar.f25975a.getScrollY();
                        g.this.f25975a.reload();
                    }
                }
            }
        });
    }

    public void q() {
        if (!this.f25980f.isRefreshing()) {
            View view = this.f25979e;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void r() {
        View view = this.f25979e;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f25980f.setRefreshing(false);
    }

    public void i(String str) {
        try {
            com.shopee.app.util.h.a.c(str);
            String replace = str.replaceAll("\\\\", "\\\\\\\\").replace("'", "\\'");
            t(String.format(Locale.ENGLISH, "if(typeof(WebViewJavascriptBridge) != 'undefined'){WebViewJavascriptBridge._handleMessageFromObjC('%s');}", new Object[]{replace}));
        } catch (Throwable unused) {
        }
    }

    public void a(String str, o oVar) {
        try {
            o oVar2 = new o();
            if (!TextUtils.isEmpty(str)) {
                oVar2.a("responseId", str);
            }
            oVar2.a("responseData", (l) oVar);
            i(oVar2.toString());
        } catch (Throwable unused) {
        }
    }

    public int getScrollYPt() {
        TouchWebView touchWebView = this.f25975a;
        if (touchWebView == null) {
            return 0;
        }
        return (int) (((float) touchWebView.getScrollY()) / this.f25975a.f25803a);
    }

    public TouchWebView getWebView() {
        return this.f25975a;
    }

    public f getPresenter() {
        return this.f25981g;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return this.f25980f;
    }

    private void P() {
        this.am = O();
    }

    public void onRefresh() {
        if (this.aj) {
            this.an = true;
        }
        if (!"about:blank".equals(this.f25975a.getUrl())) {
            P();
            i.h(this.f25975a.getUrl());
            this.f25975a.reload();
        } else {
            String str = !TextUtils.isEmpty(this.M) ? this.M : "";
            if (TextUtils.isEmpty(str)) {
                str = this.C.getUrl();
            }
            this.f25975a.setVisibility(0);
            this.f25976b.setVisibility(8);
            this.ag.setEnabled(true);
            P();
            i.h(str);
            this.f25975a.loadUrl(str);
        }
        SwipeRefreshLayout.b bVar = this.S;
        if (bVar != null) {
            bVar.onRefresh();
        }
    }

    public void setOnRefreshListener(SwipeRefreshLayout.b bVar) {
        this.S = bVar;
    }

    public void s() {
        this.h.u();
    }

    public void b(String str) {
        this.h.e(str);
    }

    public void a(Dialog dialog) {
        this.E.add(dialog);
    }

    public void t() {
        this.h.w();
    }

    public void j(String str) {
        this.h.i(str);
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.L = str;
        }
        o oVar = new o();
        oVar.a("data", this.L);
        this.ae = oVar;
    }

    public void a(o oVar) {
        o oVar2 = new o();
        oVar2.a("dataNative", (l) oVar);
        this.ae = oVar2;
    }

    public void u() {
        if (this.af) {
            this.af = false;
            return;
        }
        o oVar = new o();
        oVar.a("handlerName", "viewWillReappear");
        oVar.a("data", (l) this.ae);
        i(oVar.toString());
        this.L = "";
    }

    public void v() {
        o oVar = new o();
        oVar.a("handlerName", "viewDidDisappear");
        i(oVar.toString());
    }

    public void b(String str, o oVar) {
        o oVar2 = new o();
        oVar2.a("handlerName", str);
        oVar2.a("data", (l) oVar);
        i(oVar2.toString());
    }

    public void e(String str) {
        o oVar = new o();
        oVar.a("status", (Number) 1);
        a(str, oVar);
    }

    public void f(String str) {
        this.f25981g.a(str);
    }

    public void g() {
        this.f25981g.e();
    }

    public void h() {
        this.f25981g.g();
    }

    public void b(int i2) {
        this.f25981g.a(i2);
    }

    public void a(int i2, List<String> list) {
        k kVar = this.I;
        if (kVar != null) {
            kVar.a(i2, list);
        }
    }

    public void a(int i2, Intent intent) {
        this.f25981g.a(i2, intent);
    }

    public void a(String str, int i2) {
        Intent intent = new Intent();
        intent.putExtra("returnData", str);
        intent.putExtra("returnCountKey", i2 - 1);
        if (!TextUtils.isEmpty(this.D)) {
            intent.putExtra("RETURN_ADDRESS", this.D);
        }
        if (this.H != null) {
            intent.putExtra("updateItemShippingMessage", WebRegister.GSON.b(this.H, UpdateItemShippingMessage.class));
        }
        this.f25978d.setResult(-1, intent);
        this.f25978d.finish();
    }

    private boolean Q() {
        if (getContext() instanceof com.shopee.app.ui.home.c) {
            return true;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ay) {
                return true;
            }
        }
        return false;
    }

    public boolean a(String str, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4) {
        String str5 = str;
        com.garena.android.appkit.d.a.b("JSSEARCH: " + str + " | Supported: " + this.ag.supportsSearch(), new Object[0]);
        if (!this.ag.supportsSearch()) {
            return false;
        }
        String str6 = str5 == null ? "" : str5;
        if (this.f25981g.f25844a) {
            b(str6, i2, i3, str2, i4, i5, i6, str3, str4);
            return true;
        }
        final String str7 = str;
        final int i7 = i2;
        final int i8 = i3;
        final String str8 = str2;
        final int i9 = i4;
        final int i10 = i5;
        final int i11 = i6;
        final String str9 = str3;
        final String str10 = str4;
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                g.this.a(str7, i7, i8, str8, i9, i10, i11, str9, str10);
            }
        }, 200);
        return true;
    }

    public boolean w() {
        if (!this.ag.hasDidTapBackHandler()) {
            return false;
        }
        y();
        return true;
    }

    public void k(String str) {
        if (!this.ao.equals(str) && str != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.ao = str;
            String url = this.C.getUrl();
            String a2 = bm.a(url, "search=" + bm.a(str));
            if (!a2.equals(this.f25975a.getUrl())) {
                this.j.setTitleForSearch(str);
                this.j.setSearchText(str);
                this.f25975a.loadUrl(a2);
            }
        }
    }

    public void a(String str, int i2, int i3, String str2, int i4, int i5, String str3, String str4) {
        this.U = i2;
        String str5 = TextUtils.isEmpty(str) ? this.ao : str;
        if (!a(str5, i2, i3, str2, i4, i5, 0, str3, str4)) {
            k(str5);
        }
    }

    public void a(String str, int i2, String str2, String str3) {
        if (!a(str, this.U, 0, "", -1, -1, i2, str2, str3)) {
            k(str);
        }
    }

    public void a(List<String> list) {
        this.f25981g.a(list);
    }

    public boolean a() {
        if (this.V != null) {
            DrawerLayout y2 = ((com.shopee.app.ui.a.b) this.f25978d).y();
            if (y2.isDrawerOpen(8388613)) {
                y2.closeDrawers();
                setDetachable(true);
                return true;
            }
        }
        return w();
    }

    public String getCurrentUrl() {
        return this.ap;
    }

    /* access modifiers changed from: private */
    public void setCurUrl(String str) {
        this.ap = str;
        this.aq = u(str);
    }

    public void setTitle(String str) {
        if (this.j.getType() != 0) {
            this.j.setTitle(str);
        }
    }

    public void l(String str) {
        NavbarMessage navbarMessage;
        com.shopee.app.ui.a.d x2 = ((com.shopee.app.ui.a.b) this.f25978d).x();
        a.C0296a aVar = new a.C0296a();
        aVar.f(1).e(0).b(str, getCurrentUrl());
        x2.b(aVar);
        try {
            navbarMessage = (NavbarMessage) WebRegister.GSON.a(str, NavbarMessage.class);
        } catch (Exception unused) {
            navbarMessage = new NavbarMessage();
        }
        this.K = navbarMessage.getSearchConfig();
        x();
    }

    public void x() {
        com.shopee.app.ui.actionbar.a aVar = this.j;
        if (aVar != null) {
            aVar.a("ACTION_BAR_CART", this.s.getCartCount());
        }
    }

    public void m(String str) {
        c(str, new o());
    }

    public void c(String str, o oVar) {
        o oVar2 = new o();
        oVar2.a("handlerName", "onEventCallback");
        o oVar3 = new o();
        oVar3.a("key", str);
        oVar3.a("data", (l) oVar);
        oVar2.a("data", (l) oVar3);
        i(oVar2.toString());
    }

    public void a(long j2, int i2, int i3, String str) {
        this.h.a(j2, i3, i2, str);
    }

    public void a(int i2, int i3, long j2) {
        this.h.a(i2, i3, j2);
    }

    public void b(String str, int i2, int i3, String str2, int i4, int i5, int i6, String str3, String str4) {
        o oVar = new o();
        oVar.a("handlerName", "search");
        o oVar2 = new o();
        oVar2.a("keyword", str);
        oVar2.a("type", (Number) Integer.valueOf(i2));
        oVar2.a("defaultSuggestionsIndex", (Number) Integer.valueOf(i4));
        oVar2.a("scopeListIndex", (Number) Integer.valueOf(i5));
        oVar2.a("trigger", (Number) Integer.valueOf(i6));
        oVar2.a("cateId", (Number) Integer.valueOf(i3));
        oVar2.a("cateName", str2);
        if (!TextUtils.isEmpty(str3)) {
            oVar2.a(ShareConstants.FEED_SOURCE_PARAM, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            oVar2.a("tracking", (l) WebRegister.GSON.a(str4, o.class));
        }
        oVar.a("data", (l) oVar2);
        i(oVar.toString());
    }

    public void y() {
        o oVar = new o();
        oVar.a("handlerName", "didTapBack");
        i(oVar.toString());
    }

    public void z() {
        this.h.g();
    }

    public void A() {
        d(this.L);
    }

    public void B() {
        if (this.as) {
            this.f25977c.addView(this.f25975a, new FrameLayout.LayoutParams(-1, -1));
        }
        this.as = false;
        this.at = false;
        this.ab = false;
    }

    public void C() {
        if (this.aa && !this.ab) {
            this.at = true;
            postDelayed(this.au, 1000);
        }
        g gVar = this.W;
        if (gVar != null) {
            gVar.v();
        }
        v();
    }

    public void D() {
        try {
            this.f25977c.removeView(this.f25975a);
            this.f25975a.setLayerType(0, (Paint) null);
            this.as = true;
        } catch (Exception unused) {
        }
    }

    public void n(final String str) {
        if (!c()) {
            this.E.add(com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_place_order_need_phone, (int) R.string.sp_label_later, (int) R.string.sp_label_ok, (f.b) new f.b() {
                public void onNegative(com.afollestad.materialdialogs.f fVar) {
                }

                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    IsAuthProxyActivity_.a(g.this.f25978d).a(str).b(0).a(6);
                }
            }));
        }
    }

    public void o(String str) {
        this.D = str;
    }

    public void c(boolean z2) {
        if (z2) {
            R();
        } else {
            this.N = true;
        }
    }

    public void E() {
        if (this.N) {
            R();
            this.N = false;
        }
    }

    private void R() {
        if (this.m.s()) {
            this.m.q();
            int i2 = com.shopee.app.h.g.a() ? R.string.sp_location_enable_high_accuracy : R.string.sp_location_enable_more_sources;
            if (!c()) {
                this.E.add(com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_tips, i2, (int) R.string.sp_ignore, (int) R.string.sp_settings, (a.C0318a) new a.C0318a() {
                    public void onNegative() {
                    }

                    public void onPositive() {
                        g.this.f25978d.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                    }
                }));
            }
        }
    }

    public void setLastPageJs(String str) {
        this.Q = str;
    }

    public void a(CharSequence[] charSequenceArr, String str) {
        Dialog dialog;
        if (charSequenceArr != null) {
            if (TextUtils.isEmpty(str)) {
                dialog = com.shopee.app.ui.dialog.a.a(getContext(), charSequenceArr, (a.c) new a.c() {
                    public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                        g.this.f25981g.b(i);
                    }
                }, (a.g) new a.g() {
                    public void a() {
                        g.this.f25981g.b(-1);
                    }
                });
            } else {
                dialog = com.shopee.app.ui.dialog.a.a(getContext(), str, charSequenceArr, (a.c) new a.c() {
                    public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                        g.this.f25981g.b(i);
                    }
                }, (a.g) new a.g() {
                    public void a() {
                        g.this.f25981g.b(-1);
                    }
                });
            }
            a(dialog);
        }
    }

    public void setSnsStr(String str) {
        this.R = str;
    }

    public String getSnsStr() {
        return this.R;
    }

    public void setLogisticInfo(UpdateItemShippingMessage updateItemShippingMessage) {
        this.H = updateItemShippingMessage;
    }

    public void p(String str) {
        this.h.d(str);
    }

    public void F() {
        if (!Q()) {
            ((SearchTabActivity_.a) SearchTabActivity_.a(this.f25978d).b(WebRegister.GSON.b(this.K, SearchConfig.class)).a(this.j.getSearchText()).b(this.K.getCurrentSearchType()).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a(10029);
        }
    }

    public void G() {
        getActivity().startActivity(new Intent(getActivity(), FollowingActivity.class));
    }

    public void H() {
        this.h.x();
    }

    public void I() {
        this.f25978d.overridePendingTransition(R.anim.slide_in_from_bottom_fast, R.anim.not_move_ani);
    }

    public void a(long j2) {
        this.h.a(j2, this.r);
    }

    public void a(String str, String str2) {
        int i2;
        try {
            this.f25978d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            i2 = 1;
        } catch (ActivityNotFoundException unused) {
            i2 = 0;
        }
        o oVar = new o();
        oVar.a("status", (Number) Integer.valueOf(i2));
        a(str2, oVar);
    }

    public void a(ConfigureButtonMessage configureButtonMessage) {
        this.j.b(configureButtonMessage.getKey(), configureButtonMessage.getIconDrawable());
    }

    private boolean S() {
        return getActivity() instanceof com.shopee.app.ui.home.c;
    }

    private av T() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof av) {
                return (av) parent;
            }
        }
        return null;
    }

    public boolean J() {
        if (S()) {
            com.garena.android.uikit.a.c cVar = (com.garena.android.uikit.a.c) getActivity().findViewById(R.id.sp_home_tab_view);
            av T2 = T();
            if (T2 == null) {
                Object tag = getTag(R.id.home_web_tag);
                if (!(tag instanceof Integer)) {
                    com.garena.b.a.a.b("HOME_WEB_VIEW", "A web view in home page must have a INTEGER tag!");
                    return false;
                } else if (cVar.getSelectedIndex() == ((Integer) tag).intValue()) {
                    return true;
                } else {
                    return false;
                }
            } else if (cVar.getSelectedIndex() != 2) {
                return false;
            } else {
                com.garena.android.uikit.a.c cVar2 = (com.garena.android.uikit.a.c) getActivity().findViewById(R.id.tab_view);
                if (T2.getTag() == null || cVar2.getSelectedIndex() != ((Integer) T2.getTag()).intValue()) {
                    return false;
                }
                return true;
            }
        } else {
            av T3 = T();
            if (T3 == null) {
                return true;
            }
            com.garena.android.uikit.a.c cVar3 = (com.garena.android.uikit.a.c) getActivity().findViewById(R.id.tab_view);
            if (T3.getTag() == null || cVar3.getSelectedIndex() != ((Integer) T3.getTag()).intValue()) {
                return false;
            }
            return true;
        }
    }

    public void a(c.b bVar) {
        this.G = bVar;
    }

    public void d(AddCartMessage addCartMessage) {
        this.G = new c.b(new int[]{(int) (((float) com.garena.android.appkit.tools.b.b()) * addCartMessage.getAddCartStartPercent()), com.garena.android.appkit.tools.b.d() - b.a.t}, this.j.getCartLocation(), addCartMessage.itemImage, false);
    }

    public void f() {
        View cartView = this.j.getCartView();
        c.b bVar = this.G;
        if (bVar != null && bVar.f21089b[0] != -1 && cartView != null) {
            if (this.v == null) {
                this.v = new ImageView(getContext());
            }
            this.v.setImageResource(R.drawable.com_garena_shopee_ic_product_default);
            z.b(getContext()).a(this.G.f21090c).a(b.a.t * 2).a((ah) new u()).a(this.v);
            new CartAnimation().activity(this.f25978d).cartLocation(this.G.f21089b).startLocation(this.G.f21088a).imageView(this.v).cartView(cartView).animationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    g.this.e();
                    g.this.r(com.garena.android.appkit.tools.b.e(R.string.sp_add_cart_success));
                }
            }).build().start();
        }
    }

    public void setButtonLoc(com.shopee.app.util.ar arVar) {
        this.v.setTranslationX(arVar.f26161a);
        this.v.setTranslationY(arVar.f26162b);
    }

    public void a(ConfigureRightDrawerMessage configureRightDrawerMessage) {
        this.aw = configureRightDrawerMessage;
        Activity activity = this.f25978d;
        if (activity != null && ((com.shopee.app.ui.a.b) activity).y() != null) {
            if (this.V == null) {
                DrawerLayout y2 = ((com.shopee.app.ui.a.b) this.f25978d).y();
                y2.setDrawerListener(new DrawerLayout.c() {
                    public void onDrawerSlide(View view, float f2) {
                    }

                    public void onDrawerStateChanged(int i) {
                    }

                    public void onDrawerOpened(View view) {
                        g.this.f25981g.d();
                        if (g.this.V != null) {
                            if (!g.this.av) {
                                g.this.V.b(new WebPageModel(g.this.aw.url));
                                boolean unused = g.this.av = true;
                            }
                            g.this.V.getPresenter().c();
                        }
                    }

                    public void onDrawerClosed(View view) {
                        g.this.f25981g.c();
                        if (g.this.V != null) {
                            g.this.V.getPresenter().d();
                        }
                    }
                });
                if (this.aw.disableSwipeToOpen) {
                    y2.setDrawerLockMode(1);
                } else {
                    y2.setDrawerLockMode(0);
                }
                FrameLayout frameLayout = (FrameLayout) y2.getChildAt(1);
                this.V = WebPageView_.a(getContext(), "", configureRightDrawerMessage.config, new SearchConfig());
                this.V.setParentWebView(this);
                this.V.setDetachable(false);
                frameLayout.getLayoutParams().width = (int) (((float) com.garena.android.appkit.tools.b.b()) * configureRightDrawerMessage.width);
                frameLayout.addView(this.V, new FrameLayout.LayoutParams(-1, -1));
                this.i.b(this.V.getPresenter());
                return;
            }
            this.av = false;
            DrawerLayout y3 = ((com.shopee.app.ui.a.b) this.f25978d).y();
            if (this.aw.disableSwipeToOpen) {
                y3.setDrawerLockMode(1);
            } else {
                y3.setDrawerLockMode(0);
            }
        }
    }

    public void setDetachable(boolean z2) {
        this.aa = z2;
    }

    public void setHasTransparentPopup(boolean z2) {
        this.ab = z2;
    }

    private void setParentWebView(g gVar) {
        this.W = gVar;
    }

    public void K() {
        ConfigureRightDrawerMessage configureRightDrawerMessage = this.aw;
        if (configureRightDrawerMessage != null && !configureRightDrawerMessage.disableSwipeToOpen) {
            L();
        }
    }

    public void L() {
        setDetachable(false);
        ((com.shopee.app.ui.a.b) this.f25978d).y().openDrawer(5);
    }

    public void q(String str) {
        ((com.shopee.app.ui.a.b) this.f25978d).y().closeDrawers();
        this.W.L = str;
        setDetachable(true);
    }

    public void M() {
        WebViewClient webViewClient = this.f25975a.getWebViewClient();
        if (webViewClient != null && (webViewClient instanceof e)) {
            ((e) webViewClient).a();
        }
    }

    public void a(SearchConfig searchConfig) {
        this.K = searchConfig;
    }

    public SearchConfig getSearchConfig() {
        return this.K;
    }

    public void setNavigateForResult(boolean z2) {
        this.f25981g.a(z2);
    }

    public void setResultToPass(String str) {
        this.L = str;
    }

    public void c(int i2) {
        if (!this.ac) {
            this.ad = i2;
            return;
        }
        o oVar = new o();
        oVar.a("handlerName", "tabShow");
        o oVar2 = new o();
        oVar2.a("index", (Number) Integer.valueOf(i2));
        oVar.a("data", (l) oVar2);
        i(oVar.toString());
    }

    public void d(int i2) {
        if (this.ac) {
            o oVar = new o();
            oVar.a("handlerName", "tabHide");
            o oVar2 = new o();
            oVar2.a("index", (Number) Integer.valueOf(i2));
            oVar.a("data", (l) oVar2);
            i(oVar.toString());
        }
    }

    public class d extends WebChromeClient {
        public d() {
        }

        @SuppressLint({"SetJavaScriptEnabled"})
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            final Dialog dialog = new Dialog(g.this.getActivity());
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.web_dialog_layout);
            dialog.setCancelable(true);
            if (!g.this.c()) {
                dialog.show();
                g.this.E.add(dialog);
            }
            final WebView webView2 = (WebView) dialog.findViewById(R.id.webView);
            webView2.setOverScrollMode(2);
            WebSettings settings = webView2.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(false);
            settings.setUseWideViewPort(false);
            settings.setSupportMultipleWindows(true);
            if (Build.VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            webView2.setWebChromeClient(new d());
            dialog.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    dialog.dismiss();
                    webView2.destroy();
                }
            });
            webView2.requestFocusFromTouch();
            webView2.setWebViewClient(new WebViewClient());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            g gVar = g.this;
            k unused = gVar.I = new k(gVar.f25978d);
            g.this.I.a(valueCallback);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean u(String str) {
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        if (org.apache.commons.c.d.a(str) || !str.contains(i.f7042e)) {
            return false;
        }
        return true;
    }

    public void N() {
        t("if(typeof(WebViewJavascriptBridge) != 'undefined'){WebViewJavascriptBridge.hasHandlerCB('search');WebViewJavascriptBridge.hasHandlerCB('didTapBack');}");
        if (!this.ak) {
            t(String.format(Locale.ENGLISH, "if(document.getElementsByTagName('input').length == 0 && document.getElementsByTagName('textarea').length == 0){gabridge.onHasInput('false'); if(typeof(_gatap_init_) != 'undefined'){gabridge.onHasHandler('_gatap_', _gatap_init_() ? 'true' : 'false'); %s} else {gabridge.onHasHandler('_gatap_', 'false');}} else {gabridge.onHasInput('true');gabridge.onHasHandler('_gatap_', 'false');}", new Object[]{"if(typeof($) != 'undefined'){$('select').each(function(idx,o){o.disabled=true;}).off('tap').on('tap', function(e){o=$(this.options); values=o.map(function(){return this.value;}).get().join('|'); texts=o.map(function(){return this.text;}).get().join('|'); __gaselectorbridge__.select(this.id, values, texts, this.value);});}"}));
        } else {
            t("if(document.getElementsByTagName('input').length == 0 && document.getElementsByTagName('textarea').length == 0){gabridge.onHasInput('false');} else {gabridge.onHasInput('true');}");
        }
        t(String.format(Locale.ENGLISH, "if(typeof($) != 'undefined'){$('input[type=\"%s\"]').attr('type', 'text').off('focus').on('focus', function(e){this.blur();__gapickerbridge__.pick%s(this.id, this.value);});}", new Object[]{"date", HttpConstants.Header.DATE}));
        t(String.format(Locale.ENGLISH, "if(typeof($) != 'undefined'){$('input[type=\"%s\"]').attr('type', 'text').off('focus').on('focus', function(e){this.blur();__gapickerbridge__.pick%s(this.id, this.value);});}", new Object[]{"month", "Month"}));
        t(String.format(Locale.ENGLISH, "if(typeof($) != 'undefined'){$('input[type=\"%s\"]').attr('type', 'text').off('focus').on('focus', function(e){this.blur();__gapickerbridge__.pick%s(this.id, this.value);});}", new Object[]{"time", "Time"}));
        t("var __gawindow__ = null; if(typeof($) != 'undefined'){__gawindow__ = $(window);}");
        this.ag.getSwipeableRects().clear();
        if (this.f25975a.a()) {
            t("function isdef(t){return t != 'undefined'} function __native_getSwipeables__(){   var found = false;    $.each($('*'), function(i, e){       var events = $._data(e, 'events');       var overflowX = window.getComputedStyle(e)['overflowX'];       if(overflowX == 'scroll' || (isdef(typeof(events)) && (isdef(typeof(events.swipeleft)) || isdef(typeof(events.swiperight))))){           found = true;            var r = e.getBoundingClientRect();            var offset = $(e).offset();           var top = offset.hasOwnProperty('top') ? offset['top'] : r.top;           var bottom = top + r.height;           gabridge.onAddSwipeableRect(r.left, top, r.right, bottom);       }   });    if(!found){       setTimeout(__native_getSwipeables__, 500);   }} if(isdef(typeof($))){   setTimeout(__native_getSwipeables__, 500);}");
        }
        if (!TextUtils.isEmpty(this.Q)) {
            String replace = this.Q.replace("'", "\\'");
            t(String.format(Locale.ENGLISH, "if(typeof(_deeplink_trigger_) != 'undefined'){_deeplink_trigger_('%s');}", new Object[]{replace}));
            this.Q = null;
        }
        if (!TextUtils.isEmpty(this.R)) {
            com.garena.android.appkit.f.f.a().a(new Runnable() {
                public void run() {
                    g.this.t(String.format(Locale.ENGLISH, "_simple_nav_('%s')", new Object[]{g.this.R}));
                    g.this.t(String.format(Locale.ENGLISH, "_simple_nav_('%s')", new Object[]{g.this.R}));
                    String unused = g.this.R = null;
                }
            }, 1000);
        }
    }

    public static class e extends RenderProcessGoneHandlerClient {

        /* renamed from: a  reason: collision with root package name */
        private String f26034a;

        /* renamed from: b  reason: collision with root package name */
        public String f26035b;

        /* renamed from: c  reason: collision with root package name */
        long f26036c = 0;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26037d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26038e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final g f26039f;

        /* renamed from: g  reason: collision with root package name */
        private Runnable f26040g = new Runnable() {
            public void run() {
                if (e.this.f26039f.f25976b.getVisibility() != 0) {
                    e.this.f26039f.q();
                }
            }
        };

        public void a() {
        }

        public e(g gVar) {
            this.f26039f = gVar;
            this.f26034a = this.f26039f.C.getUrl();
            this.f26035b = this.f26039f.P;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!this.f26037d) {
                this.f26038e = true;
            }
            if ("__WVJB_QUEUE_MESSAGE__".equals(Uri.parse(str).getHost())) {
                return true;
            }
            if (str.startsWith("tel:")) {
                this.f26039f.getActivity().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            } else if (str.startsWith("mailto:")) {
                MailTo parse = MailTo.parse(str);
                this.f26039f.getActivity().startActivity(a(this.f26039f.getActivity(), parse.getTo(), parse.getSubject(), parse.getBody(), parse.getCc()));
                return true;
            } else if (str.startsWith("sms:")) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("smsto:" + str.substring(4)));
                this.f26039f.getActivity().startActivity(intent);
                return true;
            } else if (str.startsWith("shopeeid")) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                this.f26039f.f25978d.startActivity(intent2);
                return true;
            } else if (WebPageModel.isPdfUrl(str)) {
                this.f26039f.f25978d.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (str.startsWith("scbeasy:")) {
                try {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setData(Uri.parse(str));
                    this.f26039f.f25978d.startActivity(intent3);
                } catch (Exception e2) {
                    com.garena.b.a.a.a("Open SCB Easy app " + str, (Throwable) e2);
                }
                return true;
            } else if (bl.c(str)) {
                try {
                    Intent intent4 = new Intent("android.intent.action.VIEW");
                    intent4.setData(Uri.parse(str));
                    this.f26039f.f25978d.startActivity(intent4);
                } catch (Exception e3) {
                    com.garena.b.a.a.a("Open Google Play " + str, (Throwable) e3);
                }
                return true;
            } else {
                this.f26034a = str;
                this.f26039f.setCurUrl(str);
                String unused = this.f26039f.ar = CookieManager.getInstance().getCookie(str);
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
            if (!org.apache.commons.c.d.a(str) && this.f26039f.u(str)) {
                try {
                    Uri parse = Uri.parse(str);
                    if (!TextUtils.isEmpty(parse.getLastPathSegment()) && parse.getLastPathSegment().endsWith(".ttf")) {
                        AssetManager assets = this.f26039f.getContext().getAssets();
                        return new WebResourceResponse("application/font-sfnt", "UTF-8", assets.open("fonts/" + parse.getLastPathSegment()));
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
            InputStream inputStream = null;
            if (!this.f26039f.u(str)) {
                com.garena.android.appkit.d.a.e("shouldInterceptRequest.not-our-domain: url=%s", str);
                return null;
            }
            boolean equals = this.f26034a.equals(str);
            boolean g2 = i.g(str);
            if (g2) {
                return null;
            }
            String f2 = i.f(str);
            if (equals || g2 || i.a(str, f2)) {
                boolean b2 = i.b(str);
                if (!b2 && !this.f26039f.O()) {
                    return null;
                }
                if (!this.f26039f.T) {
                    if (equals && b2) {
                        byte[] c2 = i.c(str);
                        if (c2 != null) {
                            com.garena.android.appkit.d.a.e("shouldInterceptRequest.bypass-resource-cache: url=%s", str);
                            if (this.f26039f.x) {
                                this.f26039f.x = false;
                            } else if (this.f26039f.O()) {
                                j.a(new j(str, this.f26035b, this.f26039f.f25975a, this.f26039f));
                            }
                            return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(c2));
                        }
                    }
                    return null;
                }
                if (b2 && (g2 || !this.f26039f.am)) {
                    if (equals || !org.apache.commons.c.d.a(i.d(str))) {
                        byte[] c3 = i.c(str);
                        if (c3 != null) {
                            inputStream = new ByteArrayInputStream(c3);
                        }
                        if (equals) {
                            if (this.f26039f.x) {
                                this.f26039f.x = false;
                            } else if (this.f26039f.O()) {
                                j.a(new j(str, this.f26035b, this.f26039f.f25975a, this.f26039f));
                            }
                        }
                    }
                    if (inputStream == null) {
                        i.h(str);
                    }
                }
                if (inputStream == null) {
                    inputStream = new j.a(str, this.f26035b, this.f26039f.ar, this.f26039f.getWebView());
                }
                return new WebResourceResponse(i.d(str), "UTF-8", inputStream);
            }
            com.garena.android.appkit.d.a.e("shouldInterceptRequest.not-cacheable: url=%s,ext=%s", str, f2);
            return null;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            this.f26036c = System.currentTimeMillis();
            try {
                ar.f().e().fabricClient().a("webUrl", str);
            } catch (Exception unused) {
            }
            b.a(webView, str);
            this.f26037d = false;
            if (TextUtils.isEmpty(str) || !str.startsWith(i.f7040c)) {
                this.f26039f.a(this.f26040g);
            } else {
                com.garena.android.appkit.f.f.a().a(this.f26040g, 2000);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            long j = 0;
            if (!this.f26039f.aj || this.f26036c != 0) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("onPageFinished: dur=");
                sb.append(this.f26036c == 0 ? 0 : System.currentTimeMillis() - this.f26036c);
                sb.append(" url=");
                sb.append(str);
                printStream.println(sb.toString());
                this.f26036c = 0;
                boolean unused = this.f26039f.am = false;
                if (this.f26038e) {
                    this.f26037d = true;
                    this.f26038e = false;
                }
                com.garena.android.appkit.f.f.a().b(this.f26040g);
                this.f26039f.a((Runnable) new Runnable() {
                    public void run() {
                        e.this.f26039f.r();
                    }
                });
                if (!this.f26039f.f25975a.getSettings().getLoadsImagesAutomatically()) {
                    this.f26039f.f25975a.getSettings().setLoadsImagesAutomatically(true);
                }
                if (this.f26039f.an) {
                    boolean unused2 = this.f26039f.an = false;
                    Activity activity = this.f26039f.getActivity();
                    if (activity instanceof c) {
                        this.f26039f.t(String.format(Locale.ENGLISH, "if(window.plvSetId){window.plvSetId('%s');}", new Object[]{((c) activity).c()}));
                    }
                }
                this.f26039f.N();
                if (!this.f26039f.ac) {
                    boolean unused3 = this.f26039f.ac = true;
                    if (this.f26039f.ad != -1) {
                        g gVar = this.f26039f;
                        gVar.c(gVar.ad);
                        int unused4 = this.f26039f.ad = -1;
                    }
                }
                if (this.f26039f.y > 0) {
                    webView.scrollTo(webView.getScrollX(), this.f26039f.y);
                    this.f26039f.y = 0;
                }
                String cookie = CookieManager.getInstance().getCookie(this.f26039f.C.getUrl());
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
                        return;
                    }
                    return;
                }
                return;
            }
            PrintStream printStream2 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onPageFinished-plv: dur=");
            if (this.f26036c != 0) {
                j = System.currentTimeMillis() - this.f26036c;
            }
            sb2.append(j);
            sb2.append(" url=");
            sb2.append(str);
            printStream2.println(sb2.toString());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            boolean unused = this.f26039f.am = false;
            if (!"about:blank".equals(this.f26039f.f25975a.getUrl()) && !TextUtils.isEmpty(this.f26039f.f25975a.getUrl())) {
                g gVar = this.f26039f;
                String unused2 = gVar.M = gVar.f25975a.getUrl();
            }
            this.f26039f.f25975a.loadUrl("javascript:document.body.innerHTML='';");
            this.f26039f.ag.setEnabled(false);
            this.f26039f.f25975a.loadDataWithBaseURL((String) null, "<html><head><meta charset=\"UTF-8\"></head><body></body></html>", "text/html", "UTF-8", (String) null);
            com.garena.android.appkit.f.f.a().b(this.f26040g);
            this.f26039f.a((Runnable) new Runnable() {
                public void run() {
                    e.this.f26039f.f25976b.setVisibility(0);
                    e.this.f26039f.f25975a.setVisibility(8);
                    e.this.f26039f.r();
                }
            });
        }
    }

    public void a(ShareMessage shareMessage) {
        if (this.f25978d instanceof c) {
            boolean a2 = m.a(shareMessage.getShopID());
            int i2 = shareMessage.getmTime();
            String url = shareMessage.getUrl();
            if (a2) {
                if (i2 == 0) {
                    url = url + "?is_owner=1";
                } else {
                    url = url + "?is_owner=1&v=" + i2;
                }
            } else if (i2 != 0) {
                url = url + "?v=" + i2;
            }
            ShareDialog shareDialog = new ShareDialog(this.f25978d);
            if (!ShareDialog.canShow(ShareLinkContent.class)) {
                return;
            }
            if (TextUtils.isEmpty(url)) {
                com.shopee.app.h.r.a().b((int) R.string.sp_server_error);
            } else {
                shareDialog.show(((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(url))).build());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(String str) {
        com.shopee.app.h.r.a().a(str);
    }

    public void c(String str) {
        com.shopee.app.h.r.a().a(str);
    }

    public void a(String str) {
        com.shopee.app.h.q.a((View) this, str);
    }
}
