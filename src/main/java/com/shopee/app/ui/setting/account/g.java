package com.shopee.app.ui.setting.account;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.i;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class g extends b implements x<m> {

    /* renamed from: a  reason: collision with root package name */
    int f25177a;

    /* renamed from: b  reason: collision with root package name */
    String f25178b;

    /* renamed from: c  reason: collision with root package name */
    ak f25179c;

    /* renamed from: d  reason: collision with root package name */
    UserInfo f25180d;

    /* renamed from: e  reason: collision with root package name */
    private m f25181e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        if (this.f25177a == 0) {
            a((View) e.a(this));
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a((a.b) new i(this));
        if (this.f25177a != 0) {
            aVar.b((int) R.string.sp_label_password);
        } else {
            aVar.b((int) R.string.sp_email);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25181e = com.shopee.app.ui.setting.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25181e.a(this);
    }

    /* renamed from: c */
    public m b() {
        return this.f25181e;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        if (i == -1) {
            setResult(i);
        }
        finish();
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        setResult(i);
        if (i == -1) {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i) {
        if (i == -1) {
            setResult(i);
        }
        finish();
    }

    /* access modifiers changed from: package-private */
    public void e(int i) {
        if (i == -1) {
            setResult(-1);
        }
        finish();
    }
}
