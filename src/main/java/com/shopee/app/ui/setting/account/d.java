package com.shopee.app.ui.setting.account;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.a.b;
import com.rengwuxian.materialedittext.a.c;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    String f25169a;

    /* renamed from: b  reason: collision with root package name */
    String f25170b;

    /* renamed from: c  reason: collision with root package name */
    MaterialEditText f25171c;

    /* renamed from: d  reason: collision with root package name */
    Button f25172d;

    /* renamed from: e  reason: collision with root package name */
    b f25173e;

    /* renamed from: f  reason: collision with root package name */
    ak f25174f;

    /* renamed from: g  reason: collision with root package name */
    bc f25175g;
    Activity h;
    r i;
    UserInfo j;
    private String k = "";

    public d(Context context) {
        super(context);
        ((m) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25175g.a(this.f25173e);
        this.f25173e.a(this);
        h();
    }

    private void h() {
        this.f25172d.setText(this.f25169a);
        String str = (String) com.shopee.app.data.store.ak.a().j().b("");
        this.k = str;
        if (!TextUtils.isEmpty(str)) {
            this.k = str;
            this.f25171c.setText(str);
        } else {
            this.k = "";
            this.f25171c.setHint(this.f25170b);
        }
        this.f25171c.b((b) new c(com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email), "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,10}$"));
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void b() {
        this.f25173e.b(this.f25171c.getText().toString().trim());
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!this.f25171c.b()) {
            return;
        }
        if (this.k.equals(this.f25171c.getText().toString())) {
            b();
        } else {
            this.f25173e.a(this.f25171c.getText().toString().trim());
        }
    }

    public void d() {
        this.i.a();
    }

    public void e() {
        this.i.b();
    }

    public void f() {
        a.a(getContext(), 0, (int) R.string.sp_try_another_email, 0, (int) R.string.sp_label_ok);
    }

    public void g() {
        this.f25174f.p(this.j.getEmail());
    }
}
