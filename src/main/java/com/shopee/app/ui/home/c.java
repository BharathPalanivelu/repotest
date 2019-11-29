package com.shopee.app.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import com.appsflyer.AppsFlyerLib;
import com.facebook.react.ReactInstanceManager;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.common.au;
import com.shopee.app.ui.home.d.d;
import com.shopee.app.ui.home.d.e;
import com.shopee.app.ui.home.d.g;
import com.shopee.app.ui.home.d.h;
import com.shopee.app.ui.home.d.i;
import com.shopee.app.ui.home.d.k;
import com.shopee.app.util.ak;
import com.shopee.app.util.al;
import com.shopee.app.util.aw;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.y;
import com.shopee.id.R;
import com.shopee.navigator.NavigationPath;
import com.shopee.navigator.options.JumpOption;
import com.shopee.react.sdk.activity.a;
import com.shopee.web.sdk.bridge.a.f.b;
import java.util.List;

public class c extends b implements com.shopee.a.b.b, com.shopee.app.react.c, x<e>, y, a, com.shopee.web.sdk.bridge.a.f.a {
    private m H;
    private e I;
    private al J;
    private d K;
    private com.shopee.app.ui.home.d.a L;
    private e M;
    private h N;
    private g O;
    private k P;
    private com.shopee.app.ui.home.d.c Q;
    private i R;
    private boolean S;
    private com.shopee.app.tracking.b.a T = new com.shopee.app.tracking.b.a();

    /* renamed from: a  reason: collision with root package name */
    public int f7012a;

    /* renamed from: b  reason: collision with root package name */
    public String f7013b;

    /* renamed from: c  reason: collision with root package name */
    public String f7014c;

    /* renamed from: d  reason: collision with root package name */
    int f7015d = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f7016e;

    /* renamed from: f  reason: collision with root package name */
    ak f7017f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.navigator.e f7018g;
    com.shopee.app.data.store.al h;
    aw i;
    com.shopee.app.tracking.a j;
    b.a<ReactInstanceManager> k;
    public bi l;
    com.shopee.app.ui.c.a m;
    com.shopee.app.tracking.trackingv3.b n;

    public Activity a() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: protected */
    public com.shopee.app.ui.a.d t() {
        return new b.C0295b(this);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        com.shopee.app.util.o.d.a().c(this);
        I();
        if (this.f7016e) {
            ((ar) getApplication()).h();
        }
        AppsFlyerLib.getInstance().sendDeepLinkData(this);
        com.shopee.app.h.k.a(getIntent(), (Activity) this);
        this.H = n.a(this, this.f7012a);
        a((View) this.H);
        J();
        getWindow().setBackgroundDrawable(new ColorDrawable(com.garena.android.appkit.tools.b.a(R.color.background)));
        this.S = bundle == null;
        if (this.S) {
            a(getIntent());
        }
        L();
    }

    private void a(Intent intent) {
        com.shopee.app.pushnotification.c.b((Context) this);
        this.N.a(intent, this.f7015d);
    }

    private void I() {
        this.K = new d();
        this.L = new com.shopee.app.ui.home.d.a(this);
        this.K.a(this.L);
        this.M = new e(this, this.h, this.f7017f);
        this.K.a(this.M);
        this.N = new h(this, this.i, this.j, this.n);
        this.K.a(this.N);
        this.O = new g(this, this.k);
        this.K.a(this.O);
        this.P = new k(this, this.l);
        this.K.a(this.P);
        this.Q = new com.shopee.app.ui.home.d.c(this);
        this.K.a(this.Q);
        this.R = new i(this);
        this.K.a(this.R);
    }

    public void d(String str) {
        this.N.a(str);
    }

    private void J() {
        this.J = new al();
        registerReceiver(this.J, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void K() {
        unregisterReceiver(this.J);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.I = b.c().a(com.shopee.app.react.g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.I.a(this);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f7012a = this.H.getCurrentIndex();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public void m() {
        super.m();
        this.O.d();
    }

    public void n() {
        super.n();
        this.O.e();
    }

    public void onPause() {
        super.onPause();
        this.K.b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.K.c();
        E();
        if (!(this.S ? this.M.a() : false) && this.S) {
            this.H.e();
        }
        this.S = false;
        G();
        this.m.a((Context) this);
    }

    public void onDestroy() {
        super.onDestroy();
        K();
        this.K.f();
    }

    /* renamed from: l */
    public e b() {
        return this.I;
    }

    public void onBackPressed() {
        if (this.k.get() != null) {
            this.k.get().onBackPressed();
        } else {
            invokeDefaultOnBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.O.a(i2, i3, intent);
    }

    public void a(List<String> list, b.C0475b bVar) {
        this.m.a((Context) this, list, bVar);
    }

    public void a(List<String> list, String str, b.C0475b bVar) {
        this.m.a(this, list, str, bVar);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.m.a((Activity) this, i2, iArr);
    }

    public void a(boolean z, int i2) {
        this.R.a(z);
        this.Q.a(z, i2);
    }

    public boolean b(int i2) {
        return this.Q.a(i2);
    }

    public void a(String str, com.shopee.react.sdk.bridge.modules.base.d dVar) {
        this.O.a(str, dVar);
    }

    public com.shopee.react.sdk.bridge.modules.base.d b(String str) {
        return this.O.b(str);
    }

    public void a(String str, com.shopee.app.react.modules.base.b bVar) {
        this.O.a(str, bVar);
    }

    public com.shopee.app.react.modules.base.b a(String str) {
        return this.O.a(str);
    }

    public int getReactTag() {
        return this.O.a();
    }

    public com.shopee.app.react.modules.base.a c() {
        return b();
    }

    public void invokeDefaultOnBackPressed() {
        if (!this.L.a()) {
            super.onBackPressed();
        }
    }

    public m p() {
        return this.H;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, int i3, int i4, String str2, int i5, int i6, String str3, String str4) {
        if (i2 == -1) {
            this.P.a(str, i3, i4, str2, i5, i6, str3, str4);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, String str, int i3, int i4, String str2, int i5, int i6, String str3, String str4) {
        if (i2 == -1) {
            this.P.a(str, i3, i4, str2, i5, i6, str3, str4);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.H.e();
        this.M.g();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Intent intent) {
        au currentWebPage = this.H.getCurrentWebPage();
        if (currentWebPage != null) {
            currentWebPage.a(i2, intent);
        }
    }

    public void q() {
        m mVar = this.H;
        if (mVar != null) {
            mVar.q();
        }
    }

    public boolean F() {
        return this.Q.a();
    }

    public void G() {
        if (this.h.a().isLoggedIn() && this.h.x()) {
            com.shopee.app.ui.dialog.a.a((Context) this, this.h.a().getPhone(), (DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            this.h.e(false);
        }
    }

    private void L() {
        com.shopee.navigator.c H2 = H();
        if (H2.g()) {
            H2.j();
            a(H2.e(), H2.c(), H2.h());
        }
    }

    public void a(NavigationPath navigationPath, o oVar, JumpOption jumpOption) {
        this.f7018g.a((Activity) this, navigationPath, oVar);
    }

    public com.shopee.navigator.c H() {
        return new com.shopee.navigator.c(getIntent());
    }

    public com.shopee.a.b.a r() {
        return this.T;
    }
}
