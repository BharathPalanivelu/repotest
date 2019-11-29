package com.shopee.app.ui.home.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.ui.home.d.k;
import com.shopee.app.ui.home.e;
import com.shopee.app.ui.webview.g;
import com.shopee.app.util.aw;
import com.shopee.app.util.i;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends com.garena.android.uikit.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    g f7011a;

    public a(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    public g getWebPageView() {
        return this.f7011a;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void d() {
        this.f7011a.setTag(R.id.home_web_tag, 0);
        this.f7011a.b(new WebPageModel(i.f7040c));
    }

    public void a() {
        if (!TextUtils.isEmpty(aw.f26171a)) {
            this.f7011a.setSnsStr(aw.f26171a);
            aw.f26171a = null;
            this.f7011a.b(new WebPageModel(i.f7040c));
        }
        this.f7011a.getPresenter().c();
        if (!k.f22190a) {
            this.f7011a.c(0);
        }
    }

    public void b() {
        this.f7011a.getPresenter().d();
        if (!k.f22190a) {
            this.f7011a.d(0);
        }
    }
}
