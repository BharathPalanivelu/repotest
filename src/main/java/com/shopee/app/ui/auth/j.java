package com.shopee.app.ui.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.auth.b.a;
import com.shopee.app.ui.auth.password.SetNewPasswordActivity_;
import com.shopee.app.ui.auth.phone.PhoneAskActivity_;
import com.shopee.app.ui.auth.phone.PhoneVerifyActivity_;
import com.shopee.app.ui.auth.signup.phone.PhoneDetailActivity_;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class j extends b implements x<com.shopee.app.ui.auth.b.b> {

    /* renamed from: a  reason: collision with root package name */
    int f19542a = -1;

    /* renamed from: b  reason: collision with root package name */
    String f19543b;

    /* renamed from: c  reason: collision with root package name */
    boolean f19544c = false;

    /* renamed from: d  reason: collision with root package name */
    String f19545d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.app.ui.auth.b.b f19546e;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null && this.f19542a != -1) {
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new RelativeLayout(this));
    }

    private void l() {
        int i = this.f19542a;
        if (i == 3) {
            PhoneVerifyActivity_.a(this).a(this.f19543b).b(this.f19544c).d(this.f19544c ? R.string.sp_phone_OTP_page_hint : 0).a(false).f("seed_signup").b(6).f(1).a(1821);
        } else if (i == 4) {
            PhoneVerifyActivity_.a(this).a(this.f19543b).f("seed_change_password").f(21).b(6).a(1821);
        } else if (i == 5) {
            if (TextUtils.isEmpty(this.f19543b)) {
                PhoneAskActivity_.a(this).b(5).b("seed_login").d(2).a(1724);
            } else {
                PhoneVerifyActivity_.a(this).a(this.f19543b).f("seed_login").f(2).b(5).a(1821);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, String str, String str2, boolean z) {
        if (i == -1) {
            int i2 = this.f19542a;
            if (i2 == 3) {
                PhoneDetailActivity_.a(this).a(str).b(str2).a(z).a(1);
            } else if (i2 == 4) {
                SetNewPasswordActivity_.a(this).a(str).b(str2).a(2);
            } else if (i2 != 5) {
                finish();
            } else {
                setResult(-1);
                finish();
            }
        } else {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void e_(int i) {
        setResult(i);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        setResult(i);
        finish();
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        setResult(i);
        finish();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19546e = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19546e.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.b.b b() {
        return this.f19546e;
    }
}
