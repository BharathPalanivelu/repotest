package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.webview.g;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class aw extends av implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21200c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f21201d = new c();

    public aw(Context context, int i, String str, ay ayVar) {
        super(context, i, str, ayVar);
        e();
    }

    public static av a(Context context, int i, String str, ay ayVar) {
        aw awVar = new aw(context, i, str, ayVar);
        awVar.onFinishInflate();
        return awVar;
    }

    public void onFinishInflate() {
        if (!this.f21200c) {
            this.f21200c = true;
            inflate(getContext(), R.layout.webpage_tab_content_view, this);
            this.f21201d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f21201d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21195a = (g) aVar.internalFindViewById(R.id.webPageView);
        d();
    }
}
