package com.shopee.app.ui.common;

import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.store.al;
import com.shopee.app.ui.home.m;
import com.shopee.app.ui.webview.g;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final al f21300a;

    private void a(FrameLayout frameLayout, String str, int i) {
    }

    public n(al alVar) {
        this.f21300a = alVar;
    }

    public void a(FrameLayout frameLayout, String str) {
        a(frameLayout, str, 0);
    }

    public void b(FrameLayout frameLayout, String str) {
        a(frameLayout, str, b.a.r);
    }

    public void a(FrameLayout frameLayout, View view, String str) {
        if (!(view instanceof g) && !(view instanceof ay) && !(view instanceof m)) {
            a(frameLayout, str, b.a.r);
        }
    }
}
