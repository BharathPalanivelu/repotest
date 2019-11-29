package com.shopee.app.ui.myaccount.PhoneSettings;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.as;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ak f23255a;

    /* renamed from: b  reason: collision with root package name */
    a f23256b;

    /* renamed from: c  reason: collision with root package name */
    UserInfo f23257c;

    /* renamed from: d  reason: collision with root package name */
    d f23258d;

    /* renamed from: e  reason: collision with root package name */
    bc f23259e;

    /* renamed from: f  reason: collision with root package name */
    Activity f23260f;

    /* renamed from: g  reason: collision with root package name */
    r f23261g;
    m h;
    String i;

    public f(Context context) {
        super(context);
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23259e.a(this.f23258d);
        this.f23258d.a(this);
        this.f23256b.b();
        b();
    }

    public void a(UserInfo userInfo) {
        this.f23257c = userInfo;
        b();
    }

    public void b() {
        if (!TextUtils.isEmpty(this.f23257c.getPhone())) {
            this.f23256b.setTextSecondary(as.d(this.f23257c.getPhone()));
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!this.f23257c.hasPhone()) {
            IsAuthProxyActivity_.a(getContext()).b(0).a();
        } else if (this.f23257c.hasPassword()) {
            this.f23255a.Z();
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.msg_no_password_to_change_phone, 0, (int) R.string.button_ok);
        }
    }

    public void d() {
        this.f23261g.b();
    }

    public void a(String str) {
        q.a((View) this, str);
    }
}
