package com.shopee.app.ui.product.newsearch.a;

import android.content.Context;
import android.widget.LinearLayout;
import com.garena.android.uikit.a.a.a;
import com.shopee.app.ui.follow.search.m;
import com.shopee.app.ui.follow.search.n;

public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private m f24682a;

    public h(Context context, String str, boolean z) {
        super(context);
        this.f24682a = n.a(context, str, z, 0, false, (String) null);
        addView(this.f24682a, new LinearLayout.LayoutParams(-1, -1));
    }

    public void a() {
        this.f24682a.e();
    }

    public void b() {
        this.f24682a.f();
    }
}
