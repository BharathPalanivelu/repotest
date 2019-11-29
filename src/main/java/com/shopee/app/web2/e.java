package com.shopee.app.web2;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean w = false;
    private final c x = new c();

    public e(Context context, ConfigurePageRequest.ConfigMessage configMessage, com.shopee.web.sdk.bridge.internal.a aVar) {
        super(context, configMessage, aVar);
        k();
    }

    public static d a(Context context, ConfigurePageRequest.ConfigMessage configMessage, com.shopee.web.sdk.bridge.internal.a aVar) {
        e eVar = new e(context, configMessage, aVar);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.w) {
            this.w = true;
            inflate(getContext(), R.layout.web_page_layout2, this);
            this.x.a((a) this);
        }
        super.onFinishInflate();
    }

    private void k() {
        c a2 = c.a(this.x);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f26667d = (WebView) aVar.internalFindViewById(R.id.webView);
        this.f26668e = aVar.internalFindViewById(R.id.error);
        this.f26669f = (FrameLayout) aVar.internalFindViewById(R.id.webview_root);
        this.h = aVar.internalFindViewById(R.id.progress_wheel);
        this.i = (SwipeRefreshLayout) aVar.internalFindViewById(R.id.swipe_container);
        c();
    }
}
