package com.shopee.app.ui.auth.phone;

import android.os.Bundle;
import android.view.View;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;

public class g extends b implements x<com.shopee.app.ui.auth.b.b> {
    private com.shopee.app.ui.auth.b.b H;
    private j I;

    /* renamed from: a  reason: collision with root package name */
    int f19714a;

    /* renamed from: b  reason: collision with root package name */
    String f19715b = "";

    /* renamed from: c  reason: collision with root package name */
    int f19716c = R.string.sp_label_verification_code;

    /* renamed from: d  reason: collision with root package name */
    int f19717d;

    /* renamed from: e  reason: collision with root package name */
    int f19718e;

    /* renamed from: f  reason: collision with root package name */
    String f19719f;

    /* renamed from: g  reason: collision with root package name */
    String f19720g;
    String h;
    String i;
    boolean j = true;
    boolean k = false;
    String l;
    int m;
    String n;

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
        this.I = k.a(this, this.f19715b, this.f19714a, this.f19717d, this.f19718e, this.f19719f, this.f19720g, this.h, this.i, this.j, this.k, this.l, this.m);
        a((View) this.I);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        String lowerCase = com.garena.android.appkit.tools.b.e(this.f19716c).toLowerCase();
        a.C0296a f2 = aVar.f(1);
        f2.a(Character.toUpperCase(lowerCase.charAt(0)) + lowerCase.substring(1)).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.H = com.shopee.app.ui.auth.b.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.H.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.b.b b() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public String h() {
        o oVar = new o();
        oVar.a("otpSeed", this.l);
        return WebRegister.GSON.a((l) oVar);
    }

    /* access modifiers changed from: package-private */
    public void g_(int i2) {
        if (i2 == -1) {
            setResult(i2);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (i2 == -1) {
            setResult(i2);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (i2 == -1) {
            setResult(i2);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        if (i2 == -1) {
            setResult(i2);
        }
        finish();
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        if (i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 12 && iArr.length > 0 && iArr[0] == 0) {
            j jVar = this.I;
            if (jVar != null) {
                jVar.f();
            }
        }
    }

    /* access modifiers changed from: protected */
    public o p_() {
        o oVar = new o();
        oVar.a("acquisition_source", this.n);
        return oVar;
    }

    public String j() {
        if ("seed_login".equals(this.l)) {
            return "login_sms_otp";
        }
        if ("seed_signup".equals(this.l)) {
            return "sign_up_sms_otp";
        }
        if ("seed_bind_email".equals(this.l)) {
            return "sign_up_email_otp";
        }
        return super.j();
    }
}
