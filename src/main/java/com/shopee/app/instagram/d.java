package com.shopee.app.instagram;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f17751b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f17752c = new c();

    public d(Context context) {
        super(context);
        b();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.f17751b) {
            this.f17751b = true;
            inflate(getContext(), R.layout.twitter_auth_layout, this);
            this.f17752c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f17752c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f17749a = (WebView) aVar.internalFindViewById(R.id.webView);
        a();
    }
}
