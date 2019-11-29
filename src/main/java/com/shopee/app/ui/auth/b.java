package com.shopee.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.beetalk.sdk.g;
import com.beetalk.sdk.l;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.store.al;
import com.shopee.app.h.k;
import com.shopee.app.h.r;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<com.shopee.app.ui.auth.b.b> {

    /* renamed from: a  reason: collision with root package name */
    int f19485a;

    /* renamed from: b  reason: collision with root package name */
    String f19486b;

    /* renamed from: c  reason: collision with root package name */
    boolean f19487c;

    /* renamed from: d  reason: collision with root package name */
    String f19488d;

    /* renamed from: e  reason: collision with root package name */
    bi f19489e;

    /* renamed from: f  reason: collision with root package name */
    g f19490f;

    /* renamed from: g  reason: collision with root package name */
    com.shopee.app.tracking.trackingv3.b f19491g;
    al h;
    f i;
    private d j;
    private com.shopee.app.ui.auth.b.b k;
    private CallbackManager l;

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    /* access modifiers changed from: protected */
    public void u_() {
    }

    /* access modifiers changed from: protected */
    public void v_() {
    }

    /* access modifiers changed from: protected */
    public void w_() {
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        v().setVisibility(8);
        this.j = e.a(this, this.f19486b, this.f19488d);
        a((View) this.j);
        this.j.setTabIndex(this.f19485a);
        this.l = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.l, new FacebookCallback<LoginResult>() {
            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                b.this.f19490f.c();
            }

            public void onCancel() {
                com.garena.android.appkit.d.a.e("user cancel", new Object[0]);
            }

            public void onError(FacebookException facebookException) {
                r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_facebook_error));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f19490f.b();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.k = com.shopee.app.ui.auth.b.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.k.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.b.b b() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ((ar) ar.a()).h();
        if (i2 == l.f5467e.intValue()) {
            g.a(this, i2, i3, intent);
        } else if (i2 == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode()) {
            this.l.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        com.shopee.app.react.g.a((String) null);
        super.onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public void c_(int i2) {
        if (i2 == -1) {
            b("sms_otp");
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 == -1) {
            a("sms_otp");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Intent intent) {
        if (this.j.f19519d == null) {
            return;
        }
        if (i2 != -1 || !intent.hasExtra("data")) {
            this.j.f19519d.f();
            return;
        }
        this.j.f19519d.a((com.shopee.app.line.a) intent.getSerializableExtra("data"));
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f19491g.b("login", "action_login_success", com.shopee.app.tracking.trackingv3.b.b(str));
            this.i.b(str);
            k.a(getApplicationContext(), j(), str, this.h.a().getUserId());
        }
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.f19491g.b("sign_up", "action_sign_up_success", com.shopee.app.tracking.trackingv3.b.b(str));
        k.b(getApplicationContext(), j(), str, this.h.a().getUserId());
        setResult(-1);
        finish();
    }
}
