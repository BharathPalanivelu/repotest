package com.shopee.app.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.a.o;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.application.a.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.h.q;
import com.shopee.app.tracking.a;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class r extends a {

    /* renamed from: b  reason: collision with root package name */
    MaterialEditText f19769b;

    /* renamed from: c  reason: collision with root package name */
    TextView f19770c;

    /* renamed from: d  reason: collision with root package name */
    View f19771d;

    /* renamed from: e  reason: collision with root package name */
    View f19772e;

    /* renamed from: f  reason: collision with root package name */
    ak f19773f;

    /* renamed from: g  reason: collision with root package name */
    bc f19774g;
    p h;
    com.shopee.app.ui.common.r i;
    UserInfo j;
    Activity k;
    SettingConfigStore l;
    b m;
    a n;
    al o;
    com.shopee.app.tracking.trackingv3.b p;
    s q;
    private final g r;
    private final k s;
    private boolean t = true;

    public r(Context context, String str, g gVar, k kVar) {
        super(context, str);
        this.r = gVar;
        this.s = kVar;
        ((com.shopee.app.ui.auth.b.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f19774g.a(this.h);
        this.h.a(this);
        this.f19769b.b((com.rengwuxian.materialedittext.a.b) new as.a(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format)));
        if (this.q.a("line_login")) {
            this.f19772e.setVisibility(0);
        } else {
            this.f19772e.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().trim())) {
            this.f19769b.setError((CharSequence) null);
            this.f19771d.setEnabled(false);
            return;
        }
        this.f19771d.setEnabled(true);
        if (this.t) {
            this.t = false;
            as.a(getContext(), editable);
            this.t = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        as.a(getContext(), (EditText) this.f19769b);
        if (this.f19769b.b()) {
            this.h.a(this.f19769b.getText().toString().trim());
            this.n.e(this.k.getClass().getSimpleName());
        }
    }

    public void a(boolean z) {
        IsNoAuthProxyActivity_.a(getContext()).b(3).a(this.f19769b.getText().toString().trim()).a(z).b(this.f19480a).a(1);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f19773f.d();
    }

    public void g() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_phone_call_otp_popup_msg, (int) R.string.sp_label_cancel, (int) R.string.sp_label_call_me, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                r.this.h.e();
            }
        });
    }

    public void h() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_registered_ask_login, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                r.this.f19773f.b(r.this.f19769b.getText().toString().trim());
            }
        });
    }

    public void i() {
        this.f19769b.setError(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format));
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void j() {
        this.i.a();
    }

    public void k() {
        this.i.b();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.m.b();
        com.shopee.app.f.a.a().a(this.k);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.s.b();
    }

    public void b() {
        super.b();
        this.h.d();
    }

    public void a() {
        super.a();
        this.h.c();
    }

    /* access modifiers changed from: package-private */
    public void a(o oVar, ViewCommon viewCommon) {
        this.p.a("sign_up", viewCommon, oVar);
    }
}
