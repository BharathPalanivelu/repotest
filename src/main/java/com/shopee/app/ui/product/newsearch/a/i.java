package com.shopee.app.ui.product.newsearch.a;

import android.content.Context;
import android.view.View;
import org.a.a.b.a;
import org.a.a.b.c;

public final class i extends h implements a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24683a = false;

    /* renamed from: b  reason: collision with root package name */
    private final c f24684b = new c();

    public i(Context context, String str, boolean z) {
        super(context, str, z);
        d();
    }

    public static h a(Context context, String str, boolean z) {
        i iVar = new i(context, str, z);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.f24683a) {
            this.f24683a = true;
            this.f24684b.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c.a(c.a(this.f24684b));
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }
}
