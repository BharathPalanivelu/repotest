package com.shopee.app.ui.follow.following;

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

public class FollowingActivity extends b implements x<com.shopee.app.ui.follow.b> {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.app.ui.follow.b f21625a;

    /* renamed from: b  reason: collision with root package name */
    private CallbackManager f21626b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public f f21627c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f21627c = g.a(this);
        a((View) this.f21627c);
        this.f21626b = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.f21626b, new FacebookCallback<LoginResult>() {
            public void onError(FacebookException facebookException) {
            }

            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                FollowingActivity.this.f21627c.e();
            }

            public void onCancel() {
                a.e("user cancel", new Object[0]);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b((int) R.string.sp_title_add_friend).a("ACTIVITY_SEARCH_FRIENDS", (int) R.drawable.com_garena_shopee_ic_search);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21625a = com.shopee.app.ui.follow.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21625a.a(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == l.f5467e.intValue()) {
            g.a(this, i, i2, intent);
        } else if (i == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode()) {
            this.f21626b.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1114 && iArr.length > 0 && iArr[0] == 0) {
            this.f21627c.getContact();
        }
    }

    /* renamed from: c */
    public com.shopee.app.ui.follow.b b() {
        return this.f21625a;
    }
}
