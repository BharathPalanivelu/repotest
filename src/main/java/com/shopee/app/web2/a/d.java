package com.shopee.app.web2.a;

import android.view.ViewTreeObserver;
import android.webkit.WebView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.UiThreadUtil;

public class d extends h implements SwipeRefreshLayout.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SwipeRefreshLayout f26616a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f26617b = true;

    public d(SwipeRefreshLayout swipeRefreshLayout) {
        this.f26616a = swipeRefreshLayout;
    }

    public void a(final com.shopee.app.web2.d dVar) {
        super.a(dVar);
        this.f26616a.setOnRefreshListener(this);
        this.f26616a.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                WebView d2 = d.this.d();
                if (d2 != null) {
                    boolean unused = d.this.f26617b = d2.getScrollY() == 0;
                    d.this.a(dVar.j());
                }
            }
        });
    }

    public boolean a() {
        return this.f26616a.isRefreshing();
    }

    public void b() {
        this.f26616a.setRefreshing(false);
    }

    public void a(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                d.this.f26616a.setEnabled(z && d.this.f26617b);
            }
        });
    }

    public void onRefresh() {
        com.shopee.app.web2.d c2 = c();
        if (c2 != null) {
            c2.onRefresh();
        }
    }
}
