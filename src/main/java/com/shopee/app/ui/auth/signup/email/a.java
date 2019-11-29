package com.shopee.app.ui.auth.signup.email;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.h;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<com.shopee.app.ui.auth.signup.b> {

    /* renamed from: a  reason: collision with root package name */
    private d f19824a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.app.ui.auth.signup.b f19825b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f19824a = e.a(this);
        a((View) this.f19824a);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a((a.b) new h(this, new h.a() {
            public void a() {
                a.this.l();
            }
        })).b((int) R.string.sp_sign_up);
    }

    private void a(a.C0318a aVar) {
        com.shopee.app.ui.dialog.a.a((Context) this, (int) R.string.sp_label_sign_up, (int) R.string.sp_discard_signup, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, aVar);
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!this.f19824a.f()) {
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
        this.f19825b = com.shopee.app.ui.auth.signup.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19825b.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.signup.b b() {
        return this.f19825b;
    }

    public void onBackPressed() {
        if (!this.f19824a.f()) {
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

    /* access modifiers changed from: package-private */
    public void h_(int i) {
        if (i == -1) {
            setResult(i);
            finish();
            return;
        }
        this.f19824a.b();
    }
}
