package com.shopee.app.ui.auth.signup.phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.h;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;

public class a extends b implements x<com.shopee.app.ui.auth.signup.b> {

    /* renamed from: a  reason: collision with root package name */
    String f19885a;

    /* renamed from: b  reason: collision with root package name */
    String f19886b;

    /* renamed from: c  reason: collision with root package name */
    boolean f19887c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f19888d = false;

    /* renamed from: e  reason: collision with root package name */
    d f19889e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.ui.auth.signup.b f19890f;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f19889e = e.a(this, this.f19885a, this.f19886b);
        a((View) this.f19889e);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        if (this.f19887c) {
            aVar.f(1).b((int) R.string.sp_complete_profile).e(0).a((a.b) new h(this, new h.a() {
                public void a() {
                    a.this.l();
                }
            }));
        } else {
            aVar.f(1).b((int) R.string.sp_sign_up).e(0).a((a.b) new h(this, new h.a() {
                public void a() {
                    a.this.l();
                }
            }));
        }
    }

    /* access modifiers changed from: protected */
    public String h() {
        o oVar = new o();
        oVar.a("otpAutoFill", Boolean.valueOf(this.f19888d));
        return WebRegister.GSON.a((l) oVar);
    }

    private void a(a.C0318a aVar) {
        com.shopee.app.ui.dialog.a.a((Context) this, (int) R.string.sp_label_sign_up, (int) R.string.sp_discard_signup, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, aVar);
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!this.f19889e.d()) {
            p();
        } else {
            a((a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    a.this.p();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        ((AuthTabActivity_.a) AuthTabActivity_.a(this).b(0).k(67108864)).a();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19890f = com.shopee.app.ui.auth.signup.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19890f.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.signup.b b() {
        return this.f19890f;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            this.f19889e.a(intent.getStringArrayListExtra("add_product_image_uri_list").get(0));
        }
    }

    public void onBackPressed() {
        if (!this.f19889e.d()) {
            super.onBackPressed();
        } else {
            a((a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    a.this.finish();
                }
            });
        }
    }
}
