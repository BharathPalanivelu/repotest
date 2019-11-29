package com.shopee.app.ui.myaccount.SocialAccounts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.beetalk.sdk.g;
import com.beetalk.sdk.l;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.garena.android.appkit.d.a;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    CallbackManager f23278a;

    /* renamed from: b  reason: collision with root package name */
    private b f23279b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public f f23280c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f23280c = g.a(this);
        this.f23280c.p();
        a((View) this.f23280c);
        this.f23278a = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.f23278a, new FacebookCallback<LoginResult>() {
            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                c.this.f23280c.d();
            }

            public void onCancel() {
                a.e("user cancel", new Object[0]);
            }

            public void onError(FacebookException facebookException) {
                c.this.f23280c.a(com.garena.android.appkit.tools.b.e(R.string.sp_label_facebook_login_error));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_social_account).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23279b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23279b.a(this);
    }

    /* renamed from: c */
    public b b() {
        return this.f23279b;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            this.f23280c.a(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i, Intent intent) {
        if (i == -1) {
            this.f23280c.b(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == l.f5467e.intValue()) {
            g.a(this, i, i2, intent);
        } else if (i == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode()) {
            this.f23278a.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i, Intent intent) {
        if (this.f23280c == null) {
            return;
        }
        if (i != -1 || !intent.hasExtra("data")) {
            this.f23280c.b(com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error));
        } else {
            this.f23280c.f23307c.c(((com.shopee.app.line.a) intent.getSerializableExtra("data")).a());
        }
    }
}
