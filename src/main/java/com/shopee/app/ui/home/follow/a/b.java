package com.shopee.app.ui.home.follow.a;

import android.app.Activity;
import com.google.a.o;
import com.shopee.app.ui.webview.g;
import com.shopee.id.R;
import d.d.b.j;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final int f22213a = this.f22214b.getResources().getDimensionPixelSize(R.dimen.home_navi_tab_view_height);

    /* renamed from: b  reason: collision with root package name */
    private final Activity f22214b;

    /* renamed from: c  reason: collision with root package name */
    private final g f22215c;

    public b(Activity activity, g gVar) {
        j.b(activity, "activity");
        j.b(gVar, "webPageView");
        this.f22214b = activity;
        this.f22215c = gVar;
    }

    public void a(int i) {
        o oVar = new o();
        oVar.a("keyboardHeight", (Number) Integer.valueOf(i));
        oVar.a("bottomBarHeight", (Number) Integer.valueOf(this.f22213a));
        this.f22215c.b("keyboardOpen", oVar);
    }

    public void a() {
        this.f22215c.b("keyboardClose", new o());
    }
}
