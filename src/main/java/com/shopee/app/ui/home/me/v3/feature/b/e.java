package com.shopee.app.ui.home.me.v3.feature.b;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.home.me.v3.feature.i;
import com.shopee.app.ui.home.me.v3.feature.n;
import d.d.b.j;

public final class e extends n {

    /* renamed from: b  reason: collision with root package name */
    public static final e f22597b = new e();

    public boolean a(i iVar) {
        j.b(iVar, "metaData");
        return true;
    }

    private e() {
        super("sales", "my_sales");
    }

    public View a(Context context) {
        j.b(context, "context");
        f a2 = g.a(context);
        j.a((Object) a2, "MySaleFeatureView_.build(context)");
        return a2;
    }
}
