package com.shopee.app.ui.product.newsearch.a;

import android.content.Context;
import android.view.View;
import com.shopee.app.web.protocol.SearchConfig;
import org.a.a.b.a;
import org.a.a.b.c;

public final class f extends e implements a {

    /* renamed from: d  reason: collision with root package name */
    private boolean f24680d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f24681e = new c();

    public f(Context context, String str, SearchConfig searchConfig, int i) {
        super(context, str, searchConfig, i);
        d();
    }

    public static e a(Context context, String str, SearchConfig searchConfig, int i) {
        f fVar = new f(context, str, searchConfig, i);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.f24680d) {
            this.f24680d = true;
            this.f24681e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c.a(c.a(this.f24681e));
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }
}
