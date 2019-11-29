package com.shopee.app.ui.follow.following.recommend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.beetalk.sdk.g;
import com.beetalk.sdk.l;
import com.facebook.CallbackManager;
import com.facebook.internal.CallbackManagerImpl;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class h extends b implements x<i> {

    /* renamed from: a  reason: collision with root package name */
    int f21710a;

    /* renamed from: b  reason: collision with root package name */
    int f21711b;

    /* renamed from: c  reason: collision with root package name */
    private i f21712c;

    /* renamed from: d  reason: collision with root package name */
    private CallbackManager f21713d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f21713d = CallbackManager.Factory.create();
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) k.a(this, this.f21710a, this.f21711b));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        int i = this.f21710a;
        if (i == 2) {
            aVar.f(1).e(0).b((int) R.string.sp_label_facebook_friends);
        } else if (i == 4) {
            aVar.f(1).e(0).b((int) R.string.sp_contact_friends_title);
        } else if (i == 5) {
            aVar.f(1).e(0).b((int) R.string.sp_beetalk_friends_title);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21712c = f.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21712c.a(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == l.f5467e.intValue()) {
            g.a(this, i, i2, intent);
        } else if (i == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode()) {
            this.f21713d.onActivityResult(i, i2, intent);
        }
    }

    /* renamed from: c */
    public i b() {
        return this.f21712c;
    }
}
