package com.shopee.app.ui.home.react;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.garena.android.appkit.b.i;
import com.garena.reactpush.d.b;
import com.garena.reactpush.d.c;
import com.google.firebase.perf.metrics.Trace;
import com.shopee.app.react.e.d;
import com.shopee.app.react.e.e;
import com.shopee.app.react.g;
import com.shopee.app.react.h;
import com.shopee.app.react.modules.ui.navigator.NavigateModule;
import com.shopee.app.ui.a.a;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.error.b;
import com.shopee.app.util.az;
import com.shopee.app.util.x;

public class ReactTabView extends a implements b, com.shopee.a.b.b, com.shopee.app.react.e.a {

    /* renamed from: a  reason: collision with root package name */
    g f22698a;

    /* renamed from: b  reason: collision with root package name */
    ReactInstanceManager f22699b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.react.a.a f22700c;

    /* renamed from: d  reason: collision with root package name */
    r f22701d;

    /* renamed from: e  reason: collision with root package name */
    c f22702e;

    /* renamed from: f  reason: collision with root package name */
    ReactRootView f22703f;

    /* renamed from: g  reason: collision with root package name */
    private h f22704g;
    private final String h;
    private final String i;
    private boolean j = false;
    private int k = 0;
    private final e l;
    private final e m;
    private final com.shopee.app.react.e.c n;
    private final com.shopee.app.react.e.c o;
    private final com.shopee.app.react.e.c p;
    private final com.shopee.app.react.e.c q;
    private final d r;
    private i s;
    private Trace t;
    private com.shopee.app.tracking.b.c u;

    public View getViewRef() {
        return this;
    }

    public ReactTabView(Context context, String str, String str2) {
        super(context);
        ((com.shopee.app.ui.home.e) ((x) context).b()).a(this);
        this.s = com.garena.a.a.a.b.a(this);
        this.s.a();
        this.h = str;
        this.i = str2;
        this.f22704g = new h(context, this.f22699b, this.f22700c);
        this.f22704g.setProcessingIndicator(q() ? 2 : 3);
        addView(this.f22704g, new LinearLayout.LayoutParams(-1, -1));
        this.l = new e(this, getRnEventTabName(), true);
        this.m = new e(this, getRnEventTabName(), false);
        this.n = new com.shopee.app.react.e.c(this, "viewWillAppear");
        this.o = new com.shopee.app.react.e.c(this, "viewWillReappear");
        this.p = new com.shopee.app.react.e.c(this, "viewDidDisappear");
        this.q = new com.shopee.app.react.e.c(this, "didRequestMeFeedsPageRefresh");
        this.r = new d(this, getRnEventTabName());
        this.f22698a.f();
        i();
        this.u = new com.shopee.app.tracking.b.c(this.h, this.i);
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (!n()) {
            if (!o() || this.j) {
                j();
                return;
            }
            if (this.k >= 15) {
                j();
            } else {
                postDelayed(new Runnable() {
                    public void run() {
                        ReactTabView.this.i();
                    }
                }, 1000);
            }
            this.k++;
        }
    }

    private boolean n() {
        return s() || p() || t();
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f22703f = new ReactRootView(getContext());
        this.f22702e.a(this, o());
        this.f22704g.setContentView(this.f22703f);
    }

    public ReactContext getReactContext() {
        return this.f22699b.getCurrentReactContext();
    }

    public int getReactTag() {
        ReactRootView reactRootView = this.f22703f;
        if (reactRootView != null) {
            return reactRootView.getRootViewTag();
        }
        return 0;
    }

    public void k() {
        if (u()) {
            post(this.q);
        }
    }

    public void a() {
        super.a();
        this.s.c();
        if (n() && this.f22703f == null) {
            j();
        }
        a(true);
        b(true);
    }

    public void b() {
        super.b();
        this.s.d();
        b(false);
        a(false);
    }

    public void c() {
        super.c();
        this.s.b();
        this.l.a();
        this.m.a();
        this.n.a();
        this.o.a();
        this.p.a();
        this.r.a();
        this.f22698a.g();
        ReactRootView reactRootView = this.f22703f;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
            this.f22703f = null;
        }
    }

    private void a(boolean z) {
        if (!z) {
            post(this.p);
        } else if (!this.j) {
            post(this.n);
            this.j = true;
        } else {
            if (!NavigateModule.HANDLED_POP_EVENT) {
                post(this.o);
            }
            NavigateModule.HANDLED_POP_EVENT = false;
        }
    }

    private void b(boolean z) {
        if (z) {
            post(this.l);
        } else {
            post(this.m);
        }
    }

    private boolean o() {
        return !"HOME_PAGE".equals(this.h);
    }

    private boolean p() {
        return "MALL_PAGE".equals(this.h);
    }

    private boolean q() {
        return "HOME_PAGE".equals(this.h);
    }

    private boolean s() {
        return "@shopee-rn/feed/HOME".equals(this.h);
    }

    private boolean t() {
        return az.f26222a.a().equals(this.h);
    }

    private boolean u() {
        return "EMBEDDED_POSTS_PAGE".equals(this.h);
    }

    private String getRnEventTabName() {
        if (u()) {
            return "me_post";
        }
        if (s()) {
            return "feed";
        }
        if (p()) {
            return "mall";
        }
        if (q()) {
            return "home";
        }
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (u() && this.f22703f != null) {
            requestLayout();
            invalidate();
            this.f22704g.requestLayout();
            this.f22704g.invalidate();
            this.f22703f.requestLayout();
            this.f22703f.invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.f22704g.a(false);
        c(false);
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, String> pair) {
        if (!p() && !q() && !s()) {
            return;
        }
        if (getRnEventTabName().equals(pair.first) || ("follow".equals(pair.first) && s())) {
            this.r.a((String) pair.second);
            post(this.r);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (u()) {
            int a2 = com.shopee.app.react.util.d.a(this.f22703f);
            if (a2 > 0) {
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(a2, 1073741824));
                return;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void d() {
        this.f22704g.a(true);
        c(true);
    }

    public void e() {
        this.f22704g.a(false, false, (b.a) null);
    }

    public void f() {
        if (this.f22703f != null) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.i)) {
                bundle.putString("propsString", this.i);
            }
            this.f22703f.startReactApplication(this.f22699b, this.h, bundle);
            this.f22698a.c();
        }
    }

    public void s_() {
        this.f22704g.a(true, true, new b.a() {
            public void a() {
                ReactTabView.this.f22702e.a(ReactTabView.this, true);
                ReactTabView.this.f22698a.a((com.garena.reactpush.d.e) null);
            }
        });
    }

    public void t_() {
        this.f22704g.postDelayed(new Runnable() {
            public void run() {
                ReactTabView.this.f22698a.a((com.garena.reactpush.d.e) null);
            }
        }, 5000);
    }

    private void c(boolean z) {
        try {
            if (q() && getReactContext() == null && z && this.t == null) {
                this.t = com.google.firebase.perf.a.a().a("RN_bundle_load");
            }
            if (this.t == null) {
                return;
            }
            if (z) {
                this.t.start();
                return;
            }
            this.t.stop();
            this.t = null;
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public com.shopee.a.b.a r() {
        return this.u;
    }
}
