package com.shopee.app.ui.auth.signup.email;

import android.content.Context;
import android.content.Intent;
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

public class g extends b implements x<com.shopee.app.ui.auth.signup.b> {

    /* renamed from: a  reason: collision with root package name */
    String f19850a;

    /* renamed from: b  reason: collision with root package name */
    String f19851b;

    /* renamed from: c  reason: collision with root package name */
    private j f19852c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.app.ui.auth.signup.b f19853d;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f19852c = k.a(this, this.f19850a, this.f19851b);
        a((View) this.f19852c);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a((a.b) new h(this, new h.a() {
            public void a() {
                g.this.l();
            }
        })).b((int) R.string.sp_sign_up);
    }

    private void a(a.C0318a aVar) {
        com.shopee.app.ui.dialog.a.a((Context) this, (int) R.string.sp_label_sign_up, (int) R.string.sp_discard_signup, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, aVar);
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!this.f19852c.c()) {
            p();
        } else {
            a((a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    g.this.p();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        ((AuthTabActivity_.a) AuthTabActivity_.a(this).b(0).k(67108864)).a();
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            this.f19852c.a(intent.getStringArrayListExtra("add_product_image_uri_list").get(0));
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19853d = com.shopee.app.ui.auth.signup.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19853d.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.auth.signup.b b() {
        return this.f19853d;
    }
}
