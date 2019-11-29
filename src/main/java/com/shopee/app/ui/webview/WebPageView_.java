package com.shopee.app.ui.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class WebPageView_ extends g implements a, b {
    private boolean B = false;
    private final c C = new c();

    public WebPageView_(Context context, String str, String str2, SearchConfig searchConfig) {
        super(context, str, str2, searchConfig);
        O();
    }

    public WebPageView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O();
    }

    public WebPageView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O();
    }

    public static g a(Context context, String str, String str2, SearchConfig searchConfig) {
        WebPageView_ webPageView_ = new WebPageView_(context, str, str2, searchConfig);
        webPageView_.onFinishInflate();
        return webPageView_;
    }

    public void onFinishInflate() {
        if (!this.B) {
            this.B = true;
            inflate(getContext(), R.layout.web_page_layout, this);
            this.C.a((a) this);
        }
        super.onFinishInflate();
    }

    private void O() {
        c a2 = c.a(this.C);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25975a = (TouchWebView) aVar.internalFindViewById(R.id.webView);
        this.f25976b = aVar.internalFindViewById(R.id.error);
        this.f25977c = (FrameLayout) aVar.internalFindViewById(R.id.webview_root);
        this.f25979e = aVar.internalFindViewById(R.id.progress_wheel);
        this.f25980f = (SwipeRefreshLayout) aVar.internalFindViewById(R.id.swipe_container);
        k();
    }
}
