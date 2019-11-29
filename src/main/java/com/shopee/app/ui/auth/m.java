package com.shopee.app.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.a.o;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.application.a.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.f.a;
import com.shopee.app.h.q;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import com.shopee.app.ui.auth.b.d;
import com.shopee.app.ui.auth.password.h;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class m extends a {
    static final /* synthetic */ boolean q = (!m.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    MaterialEditText f19563b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f19564c;

    /* renamed from: d  reason: collision with root package name */
    View f19565d;

    /* renamed from: e  reason: collision with root package name */
    Button f19566e;

    /* renamed from: f  reason: collision with root package name */
    View f19567f;

    /* renamed from: g  reason: collision with root package name */
    d f19568g;
    bc h;
    Activity i;
    ak j;
    r k;
    aa l;
    SettingConfigStore m;
    b n;
    com.shopee.app.tracking.trackingv3.b o;
    s p;
    private final String r;
    private final g s;
    private final k t;

    /* access modifiers changed from: package-private */
    public void m() {
    }

    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public m(Context context, String str, String str2, g gVar, k kVar) {
        super(context, str2);
        this.r = str;
        this.s = gVar;
        this.t = kVar;
        ((com.shopee.app.ui.auth.b.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.h.a(this.f19568g);
        this.f19568g.a(this);
        this.f19564c.setTypeface(Typeface.DEFAULT);
        if (TextUtils.isEmpty(this.r)) {
            this.f19563b.setText(this.l.l());
        } else {
            this.f19563b.setText(this.r);
        }
        if (!TextUtils.isEmpty(this.f19563b.getText())) {
            this.f19564c.requestFocus();
        }
        as.a(getContext(), (EditText) this.f19563b);
        this.f19564c.b((com.rengwuxian.materialedittext.a.b) h.b());
        this.f19566e.setVisibility(8);
        if (this.p.a("line_login")) {
            this.f19567f.setVisibility(0);
        } else {
            this.f19567f.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        if (!z) {
            as.a(getContext(), (EditText) this.f19563b);
        }
    }

    public void setPhoneNumber(String str) {
        this.f19563b.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        as.a(getContext(), (EditText) this.f19563b);
        if (this.f19564c.a((com.rengwuxian.materialedittext.a.b) h.b())) {
            this.f19568g.a(this.f19563b.getText().toString().trim(), this.f19564c.getText().toString());
        }
    }

    public void f() {
        this.k.a();
    }

    public void g() {
        this.k.b();
    }

    public void a(String str) {
        if (q || (this.i instanceof b)) {
            ((b) this.i).a(str);
            return;
        }
        throw new AssertionError();
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.j.c(this.f19563b.getText().toString().trim());
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.t.a();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.n.b();
        a.a().a(this.i);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        IsNoAuthProxyActivity_.a(getContext()).b(5).b(this.f19480a).a(9);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.j.t("LOGIN_SIGNUP");
    }

    public void n() {
        com.shopee.app.ui.dialog.a.a(getContext(), com.garena.android.appkit.tools.b.e(R.string.action_shadow_account_login), (String) null, com.garena.android.appkit.tools.b.e(R.string.sp_label_ok), (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                m.this.h();
            }
        });
    }

    public void o() {
        com.shopee.app.ui.dialog.a.a(getContext(), this.j);
    }

    public void a(String str, String str2, String str3, String str4) {
        this.j.a(str, str2, str3, str4);
        this.f19564c.setText("");
    }

    public void p() {
        com.shopee.app.ui.dialog.a.b(getContext(), this.j);
    }

    /* access modifiers changed from: package-private */
    public void a(o oVar, ViewCommon viewCommon) {
        this.o.a("login", viewCommon, oVar);
    }
}
