package com.garena.pay.android.f;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.beetalk.sdk.l;
import com.facebook.appevents.AppEventsConstants;
import com.garena.pay.android.c.f;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.tencent.ugc.TXRecordCommon;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.tls.platform.SigType;

public class i extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f8289a = (!i.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private b f8290b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8291c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public WebView f8292d;

    /* renamed from: e  reason: collision with root package name */
    private j f8293e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ProgressDialog f8294f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f8295g;
    /* access modifiers changed from: private */
    public boolean h;
    private String i;
    /* access modifiers changed from: private */
    public Context j;
    private List<String> k = new ArrayList<String>() {
        {
            add("garena.com");
            add("garenanow.com");
            add("molsolutions.com");
        }
    };

    public interface b {
        void a(Bundle bundle, com.garena.pay.android.b.a aVar);
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        return true;
    }

    public i(Context context, String str, int i2) {
        super(context, i2);
        this.i = str;
        a(context);
    }

    private void a(Context context) {
        this.j = context;
        this.f8293e = new j(context);
    }

    public void a(b bVar) {
        this.f8290b = bVar;
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle) {
        b bVar = this.f8290b;
        if (bVar != null && !this.f8291c) {
            this.f8291c = true;
            bVar.a(bundle, (com.garena.pay.android.b.a) null);
        }
    }

    public void onDetachedFromWindow() {
        this.h = true;
        this.f8293e.b();
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.h = false;
        this.f8293e.a();
        super.onAttachedToWindow();
    }

    public void dismiss() {
        WebView webView = this.f8292d;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.h) {
            if (this.f8294f.isShowing()) {
                this.f8294f.dismiss();
            }
            super.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                i.this.b();
            }
        });
        this.f8294f = new ProgressDialog(getContext());
        this.f8294f.requestWindowFeature(1);
        this.f8294f.setMessage("Loading");
        this.f8294f.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                i.this.b();
                i.this.dismiss();
            }
        });
        requestWindowFeature(1);
        this.f8295g = new FrameLayout(getContext());
        a();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        a(20);
        setContentView(this.f8295g);
    }

    private void a(int i2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f8292d = new WebView(getContext());
        this.f8292d.setVerticalScrollBarEnabled(false);
        this.f8292d.setHorizontalScrollBarEnabled(false);
        this.f8292d.setWebViewClient(new a());
        WebSettings settings = this.f8292d.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        this.f8292d.addJavascriptInterface(this.f8293e, "__native_bridge");
        if (!l.f5464b) {
            this.f8292d.clearCache(true);
        }
        this.f8292d.loadUrl(this.i);
        this.f8292d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8292d.setVisibility(4);
        this.f8292d.getSettings().setSavePassword(false);
        this.f8292d.getSettings().setUserAgentString(new com.beetalk.sdk.f.b(this.j).toString());
        this.f8292d.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (i.this.j != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(SigType.TLS);
                    intent.setData(Uri.parse(str));
                    i.this.j.startActivity(intent);
                }
            }
        });
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(this.f8292d);
        linearLayout.setBackgroundColor(-872415232);
        this.f8295g.addView(linearLayout);
    }

    private void a() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    private int a(int i2, float f2, int i3, int i4) {
        int i5 = (int) (((float) i2) / f2);
        double d2 = 0.5d;
        if (i5 <= i3) {
            d2 = 1.0d;
        } else if (i5 < i4) {
            double d3 = (double) (i4 - i5);
            double d4 = (double) (i4 - i3);
            Double.isNaN(d3);
            Double.isNaN(d4);
            d2 = 0.5d + ((d3 / d4) * 0.5d);
        }
        double d5 = (double) i2;
        Double.isNaN(d5);
        return (int) (d5 * d2);
    }

    /* access modifiers changed from: private */
    public void b() {
        a(new com.garena.pay.android.b.a(com.garena.pay.android.a.PAYMENT_USER_CANCELLED.getStringValue(), com.garena.pay.android.a.PAYMENT_USER_CANCELLED.getCode()));
    }

    /* access modifiers changed from: private */
    public void a(com.garena.pay.android.b.a aVar) {
        Bundle bundle = new Bundle();
        if (f8289a || aVar != null) {
            bundle.putInt("extra_error_code", aVar.a().intValue());
            bundle.putString("error", aVar.getMessage());
            b bVar = this.f8290b;
            if (bVar != null && !this.f8291c) {
                this.f8291c = true;
                bVar.a(bundle, aVar);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public com.garena.pay.android.b.a b(String str) {
        com.garena.pay.android.a aVar = com.garena.pay.android.a.UNKNOWN_ERROR;
        if (str != null) {
            if (str.equals("error_params")) {
                aVar = com.garena.pay.android.a.PAYMENT_ERROR_IN_PARAMS;
            } else if (str.equals("error_scope")) {
                aVar = com.garena.pay.android.a.PAYMENT_ERROR_IN_SCOPE;
            } else if (str.equals("error_token")) {
                aVar = com.garena.pay.android.a.PAYMENT_ERROR_IN_TOKEN;
            } else if (str.equals("server_error")) {
                aVar = com.garena.pay.android.a.PAYMENT_INVALID_SERVER_RESPONSE;
            }
        }
        return new com.garena.pay.android.b.a(aVar.getStringValue(), aVar.getCode());
    }

    private class a extends WebViewClient {
        private a() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.beetalk.sdk.e.a.b("Redirect URL: %s", str);
            if (str.endsWith("pay/result?")) {
                a(str);
                i.this.dismiss();
                return true;
            } else if (str.endsWith("pay/channel/cancel")) {
                i.this.b();
                i.this.dismiss();
                return true;
            } else if (str.startsWith(l.h()) || i.this.a(str)) {
                return false;
            } else {
                i.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }

        private void a(String str) {
            Map<String, String> b2 = f.b(str);
            if (!b2.containsKey(AbTestingModule.KEY_RESULT) || !b2.get(AbTestingModule.KEY_RESULT).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                i iVar = i.this;
                iVar.a(iVar.b(b2.get("error")));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("txn_id", b2.get("txn_id"));
            bundle.putString("app_point_amount", b2.get("app_point_amount"));
            bundle.putString("item_name", b2.get("item_name"));
            bundle.putString("item_icon", b2.get("item_icon"));
            bundle.putString("rebate_card_id", b2.get("rebate_card_id"));
            bundle.putString("remaining_days", b2.get("remaining_days"));
            i.this.a(bundle);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            int intValue = com.garena.pay.android.a.UNKNOWN_ERROR.getCode().intValue();
            switch (i) {
                case -15:
                case -11:
                case XStream.PRIORITY_LOW /*-10*/:
                case TXRecordCommon.RECORD_RESULT_COMPOSE_INTERNAL_ERR /*-9*/:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                case -3:
                case -2:
                    intValue = com.garena.pay.android.a.PAYMENT_NETWORK_CONNECTION_EXCEPTION.getCode().intValue();
                    break;
                case -14:
                case -12:
                    intValue = com.garena.pay.android.a.PAYMENT_ERROR_IN_PARAMS.getCode().intValue();
                    break;
            }
            i.this.a(new com.garena.pay.android.b.a(str, Integer.valueOf(intValue)));
            i.this.dismiss();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.beetalk.sdk.e.a.b("Webview loading URL: %s", str);
            super.onPageStarted(webView, str, bitmap);
            if (!i.this.h) {
                i.this.f8294f.show();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!i.this.h) {
                i.this.f8294f.dismiss();
            }
            if (str.contains("pay/result?") && !str.contains("#")) {
                a(str);
            }
            i.this.f8295g.setBackgroundColor(0);
            i.this.f8292d.setVisibility(0);
        }
    }
}
