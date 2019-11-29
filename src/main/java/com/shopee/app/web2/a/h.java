package com.shopee.app.web2.a;

import android.app.Activity;
import android.webkit.WebView;
import com.shopee.app.web2.d;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private d f26629a;

    public void a(d dVar) {
        this.f26629a = dVar;
    }

    public d c() {
        return this.f26629a;
    }

    public WebView d() {
        d c2 = c();
        if (c2 != null) {
            return c2.getView();
        }
        return null;
    }

    public Activity e() {
        d c2 = c();
        if (c2 != null) {
            return c2.getActivity();
        }
        return null;
    }
}
