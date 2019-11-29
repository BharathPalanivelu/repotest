package com.shopee.app.ui.home.b;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.webview.g;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f22102b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f22103c = new c();

    public b(Context context) {
        super(context);
        e();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f22102b) {
            this.f22102b = true;
            inflate(getContext(), R.layout.home_tab_layout, this);
            this.f22103c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f22103c);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f7011a = (g) aVar.internalFindViewById(R.id.webPageView);
        d();
    }
}
