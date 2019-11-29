package com.shopee.app.ui.chat.cell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class ak extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    public WebView f20062a;

    /* renamed from: b  reason: collision with root package name */
    private ChatMessage f20063b;

    /* renamed from: c  reason: collision with root package name */
    private String f20064c;

    /* renamed from: d  reason: collision with root package name */
    private Float f20065d;

    /* renamed from: e  reason: collision with root package name */
    private b f20066e = new b();

    public ak(Context context) {
        super(context);
        a();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a() {
        this.f20062a = new WebView(getContext());
        this.f20062a.setBackgroundColor(0);
        this.f20062a.setWebViewClient(new a());
        this.f20062a.getSettings().setUseWideViewPort(false);
        this.f20062a.getSettings().setJavaScriptEnabled(true);
        this.f20062a.addJavascriptInterface(this, "ChatWebItemView");
        WebSettings settings = this.f20062a.getSettings();
        if (TextUtils.isEmpty(this.f20064c)) {
            this.f20064c = settings.getUserAgentString() + SQLBuilder.BLANK + al.a().b();
        }
        settings.setUserAgentString(this.f20064c);
        addView(this.f20062a, new FrameLayout.LayoutParams(-1, com.garena.android.appkit.tools.b.d(R.dimen.dp150)));
    }

    public void a(ChatMessage chatMessage) {
        String str = (String) chatMessage.getData();
        this.f20065d = al.a().a(str);
        int a2 = a(this.f20065d);
        if (a2 != this.f20062a.getMeasuredHeight()) {
            this.f20062a.setLayoutParams(new FrameLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, a2));
            requestLayout();
        }
        if (!chatMessage.equals(this.f20063b)) {
            this.f20063b = chatMessage;
            this.f20062a.loadUrl(str);
        }
    }

    private int a(Float f2) {
        if (f2 == null || f2.floatValue() <= BitmapDescriptorFactory.HUE_RED) {
            return this.f20062a.getMeasuredHeight();
        }
        return (int) (f2.floatValue() * getResources().getDisplayMetrics().density);
    }

    private class a extends WebViewClient {
        private a() {
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            a(str);
        }

        public void onPageFinished(WebView webView, String str) {
            ak.this.f20062a.loadUrl("javascript:ChatWebItemView.resize(document.body.firstElementChild.offsetHeight)");
        }

        private void a(String str) {
            if (ak.this.f20062a != null) {
                ak.this.f20062a.loadUrl("about:blank");
                ak.this.f20062a.loadDataWithBaseURL((String) null, "<html><body><div><div align=\"center\" >Something wrong with your network</div><div align=\"center\">" + str + "</div></div></body></html>", "text/html", "UTF-8", (String) null);
                ak.this.f20062a.invalidate();
                ak.this.f20062a.loadUrl("javascript:ChatWebItemView.resize(document.body.firstElementChild.offsetHeight)");
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        float f20068a;

        /* renamed from: b  reason: collision with root package name */
        String f20069b;

        private b() {
        }

        public void run() {
            ak.this.f20062a.setLayoutParams(new FrameLayout.LayoutParams(ak.this.getResources().getDisplayMetrics().widthPixels, (int) (this.f20068a * ak.this.getResources().getDisplayMetrics().density)));
            ak.this.requestLayout();
            al.a().a(this.f20069b, this.f20068a);
        }
    }

    @JavascriptInterface
    public void resize(float f2) {
        Float f3 = this.f20065d;
        if (f3 == null || f2 != f3.floatValue()) {
            b bVar = this.f20066e;
            bVar.f20068a = f2;
            bVar.f20069b = (String) this.f20063b.getData();
            removeCallbacks(this.f20066e);
            postDelayed(this.f20066e, 1000);
        } else if (f2 == this.f20065d.floatValue()) {
            removeCallbacks(this.f20066e);
        }
    }
}
