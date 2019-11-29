package com.shopee.app.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.garena.android.appkit.b.i;
import com.garena.reactpush.d.e;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.react.b.c;
import com.shopee.app.react.e.a;
import com.shopee.app.react.e.f;
import com.shopee.app.react.modules.ui.navigator.NavigateModule;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.common.n;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.error.b;
import com.shopee.app.util.aj;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.web.sdk.bridge.a.f.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d extends b implements com.garena.reactpush.d.b, com.shopee.a.b.b, c, a, x<c>, com.shopee.react.sdk.activity.a, com.shopee.web.sdk.bridge.a.f.a {
    private c H;
    private Map<String, com.shopee.app.react.modules.base.b> I;
    private Map<String, com.shopee.react.sdk.bridge.modules.base.d> J;
    private h K;
    private boolean L = false;
    private com.shopee.app.react.e.c M;
    private com.shopee.app.react.e.c N;
    private com.shopee.app.react.e.c O;
    private f P;
    private f Q;
    private i R;
    private com.shopee.app.util.o.b S;
    private com.shopee.app.tracking.b.b T;

    /* renamed from: a  reason: collision with root package name */
    g f18633a;

    /* renamed from: b  reason: collision with root package name */
    ReactInstanceManager f18634b;

    /* renamed from: c  reason: collision with root package name */
    r f18635c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.react.a.a f18636d;

    /* renamed from: e  reason: collision with root package name */
    com.garena.reactpush.d.c f18637e;

    /* renamed from: f  reason: collision with root package name */
    n f18638f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.app.ui.tracklog.i f18639g;
    com.shopee.app.ui.c.a h;
    String i;
    String j;
    String k;
    int l = 0;
    int m = 0;
    private ReactRootView n;

    public Activity a() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        com.shopee.app.util.o.d.a().a((Activity) this);
        com.shopee.app.react.util.c.a(this, !this.f18636d.g());
        this.K = new h(this, this.f18634b, this.f18636d);
        this.K.setProcessingIndicator(this.l);
        this.M = new com.shopee.app.react.e.c(this, "viewWillAppear");
        this.N = new com.shopee.app.react.e.c(this, "viewWillReappear");
        this.O = new com.shopee.app.react.e.c(this, "viewDidDisappear");
        this.P = new f(this, true);
        this.Q = new f(this, false);
        super.setContentView(this.K);
        int i2 = Build.VERSION.SDK_INT;
        a(bundle);
        this.T = new com.shopee.app.tracking.b.b(this.i, this.k);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.R = com.garena.a.a.a.b.a(this);
        this.R.a();
        this.I = new HashMap();
        this.J = new HashMap();
        this.f18633a.f();
        r_();
    }

    /* access modifiers changed from: protected */
    public void r_() {
        this.n = new ReactRootView(this);
        this.f18637e.a(this, true);
        this.K.setContentView(this.n);
        this.f18638f.b(this.K, "React Native");
        this.f18639g.a(this.K);
        this.S = new com.shopee.app.util.o.b(this, this.K, this.n);
        com.shopee.app.ui.setting.b.a.f25184a.b(this, this.i);
    }

    public String j() {
        return super.j() + this.i;
    }

    public String l() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.R.c();
        ReactInstanceManager reactInstanceManager = this.f18634b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostResume(this, this);
            d(true);
        }
        this.h.a((Context) this);
        this.S.a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.R.d();
        if (this.f18634b != null) {
            d(false);
            if (com.shopee.app.react.d.b.a(this.f18634b, this)) {
                this.f18634b.onHostPause(this);
            }
        }
        this.S.b();
    }

    public void m() {
        super.m();
        View viewRef = getViewRef();
        if (viewRef != null) {
            viewRef.post(this.P);
        }
    }

    public void n() {
        super.n();
        View viewRef = getViewRef();
        if (viewRef != null) {
            viewRef.post(this.Q);
        }
    }

    private void d(boolean z) {
        if (getViewRef() == null) {
            return;
        }
        if (!z) {
            getViewRef().post(this.O);
        } else if (!this.L) {
            getViewRef().post(this.M);
            this.L = true;
        } else {
            if (!NavigateModule.HANDLED_POP_EVENT) {
                getViewRef().post(this.N);
            }
            NavigateModule.HANDLED_POP_EVENT = false;
        }
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public void onBackPressed() {
        ReactInstanceManager reactInstanceManager = this.f18634b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onBackPressed();
        } else {
            invokeDefaultOnBackPressed();
        }
    }

    public void finish() {
        super.finish();
        aj.b(this, this.m);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        com.shopee.app.react.util.c.a(this, i2, !this.f18636d.g());
        ReactInstanceManager reactInstanceManager = this.f18634b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onActivityResult(this, i2, i3, intent);
        }
    }

    public void a(List<String> list, b.C0475b bVar) {
        this.h.a((Context) this, list, bVar);
    }

    public void a(List<String> list, String str, b.C0475b bVar) {
        this.h.a(this, list, str, bVar);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.h.a((Activity) this, i2, iArr);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 82) {
            ReactInstanceManager reactInstanceManager = this.f18634b;
            if (reactInstanceManager != null) {
                reactInstanceManager.showDevOptionsDialog();
                return true;
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f18633a.g();
        this.R.b();
        this.P.a();
        this.Q.a();
        this.M.a();
        this.O.a();
        this.N.a();
        this.P.a();
        super.onDestroy();
        for (com.shopee.app.react.modules.base.b next : this.I.values()) {
            if (next instanceof com.shopee.app.react.util.a) {
                ((com.shopee.app.react.util.a) next).d();
            }
        }
        for (com.shopee.react.sdk.bridge.modules.base.d next2 : this.J.values()) {
            if (next2 instanceof com.shopee.app.react.util.a) {
                ((com.shopee.app.react.util.a) next2).d();
            }
        }
        ReactRootView reactRootView = this.n;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
            this.n = null;
        }
        ReactInstanceManager reactInstanceManager = this.f18634b;
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostDestroy(this);
        }
        this.S.c();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.H = com.shopee.app.react.b.a.c().a(g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.H.a(this);
    }

    /* renamed from: p */
    public c b() {
        return this.H;
    }

    public void a(String str, com.shopee.app.react.modules.base.b bVar) {
        this.I.put(str, bVar);
    }

    public com.shopee.app.react.modules.base.b a(String str) {
        return this.I.get(str);
    }

    public void a(String str, com.shopee.react.sdk.bridge.modules.base.d dVar) {
        this.J.put(str, dVar);
    }

    public com.shopee.react.sdk.bridge.modules.base.d b(String str) {
        return this.J.get(str);
    }

    public ReactContext getReactContext() {
        return this.f18634b.getCurrentReactContext();
    }

    public int getReactTag() {
        ReactRootView reactRootView = this.n;
        if (reactRootView != null) {
            return reactRootView.getRootViewTag();
        }
        return 0;
    }

    public View getViewRef() {
        return this.K;
    }

    public com.shopee.app.react.modules.base.a c() {
        return b();
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.K.a(false);
    }

    public void d() {
        this.K.a(true);
    }

    public void e() {
        this.K.a(false, false, (b.a) null);
    }

    public void f() {
        if (this.n != null) {
            Bundle bundle = new Bundle();
            bundle.putString("propsEvent", this.j);
            PushData pushData = (PushData) WebRegister.GSON.a(this.k, PushData.class);
            if (!(pushData == null || pushData.getPropsString() == null)) {
                bundle.putString("propsString", pushData.getPropsString());
            }
            this.n.startReactApplication(this.f18634b, this.i, bundle);
            this.f18633a.c();
        }
    }

    public void s_() {
        this.K.a(true, true, new b.a() {
            public void a() {
                d.this.f18637e.a(d.this, true);
                d.this.f18633a.a((e) null);
            }
        });
    }

    public void t_() {
        this.K.postDelayed(new Runnable() {
            public void run() {
                d.this.f18633a.a((e) null);
            }
        }, 5000);
    }

    public com.shopee.a.b.a r() {
        return this.T;
    }
}
