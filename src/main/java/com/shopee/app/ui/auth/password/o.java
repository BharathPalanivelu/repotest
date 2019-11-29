package com.shopee.app.ui.auth.password;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.h.q;
import com.shopee.app.ui.auth.IsNoAuthProxyActivity_;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class o extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialEditText f19640a;

    /* renamed from: b  reason: collision with root package name */
    Button f19641b;

    /* renamed from: c  reason: collision with root package name */
    m f19642c;

    /* renamed from: d  reason: collision with root package name */
    bc f19643d;

    /* renamed from: e  reason: collision with root package name */
    Activity f19644e;

    /* renamed from: f  reason: collision with root package name */
    r f19645f;

    /* renamed from: g  reason: collision with root package name */
    ak f19646g;
    private int h;
    private String i;
    private boolean j = true;

    public o(Context context, String str) {
        super(context);
        ((i) ((x) context).b()).a(this);
        this.i = str;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19643d.a(this.f19642c);
        this.f19642c.a(this);
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        if (com.shopee.app.util.o.a((CharSequence) this.i) || as.b(this.i)) {
            this.f19640a.setText(this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView, Editable editable) {
        if (this.j) {
            this.j = false;
            this.h = as.a(getContext(), editable);
            this.j = true;
        }
    }

    public void b() {
        this.f19640a.setError(b.e(R.string.sp_invalid_phone_or_email));
    }

    public void c() {
        this.f19645f.a();
    }

    public void d() {
        this.f19645f.b();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        as.a(getContext(), (EditText) this.f19640a);
        String obj = this.f19640a.getText().toString();
        int i2 = this.h;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f19642c.a(obj);
                return;
            } else if (i2 != 2) {
                b();
                return;
            }
        }
        this.f19642c.b(obj);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f19646g.t("MOBILE_NO_CHANGE");
    }

    public void g() {
        this.f19644e.setResult(-1);
        this.f19644e.finish();
    }

    public void a(boolean z) {
        if (z) {
            IsNoAuthProxyActivity_.a(getContext()).b(5).a(this.f19640a.getText().toString()).a(9);
        } else {
            IsNoAuthProxyActivity_.a(getContext()).b(4).a(this.f19640a.getText().toString()).a(2);
        }
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void h() {
        com.shopee.app.h.r.a().b((int) R.string.sp_reset_password_mail_has_been_sent);
    }
}
