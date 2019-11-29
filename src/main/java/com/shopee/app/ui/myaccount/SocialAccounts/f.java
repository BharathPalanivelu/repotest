package com.shopee.app.ui.myaccount.SocialAccounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.shopee.app.application.a.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.product.twitter.e;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ak f23305a;

    /* renamed from: b  reason: collision with root package name */
    UserInfo f23306b;

    /* renamed from: c  reason: collision with root package name */
    d f23307c;

    /* renamed from: d  reason: collision with root package name */
    b f23308d;

    /* renamed from: e  reason: collision with root package name */
    bc f23309e;

    /* renamed from: f  reason: collision with root package name */
    Activity f23310f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23311g;
    TextView h;
    TextView i;
    a j;
    a k;
    a l;
    TextView m;
    a n;
    View o;
    e p;
    com.shopee.app.instagram.e q;
    r r;
    m s;
    RegionConfig t;
    s u;
    String v;
    private boolean w = false;

    public f(Context context) {
        super(context);
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23309e.a(this.f23307c);
        this.f23307c.a(this);
        k();
    }

    public void a(UserInfo userInfo) {
        this.f23306b = userInfo;
        k();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (com.shopee.app.f.a.a().b()) {
            d();
            return;
        }
        this.f23308d.b();
        com.shopee.app.f.a.a().a(this.f23310f);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f23307c.i();
    }

    public void d() {
        if (TextUtils.isEmpty(this.s.e())) {
            this.f23307c.a(com.shopee.app.f.a.a().d());
        } else if (!this.w) {
            this.f23307c.b(this.s.e());
        }
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putBoolean("isFbSet", this.w);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.w = bundle.getBoolean("isFbSet");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void q() {
        if (!TextUtils.isEmpty(this.f23306b.getPhone()) || !TextUtils.isEmpty(this.s.h()) || (!TextUtils.isEmpty(this.f23306b.getEmail()) && this.f23306b.hasPassword())) {
            this.f23311g.setVisibility(0);
        } else {
            this.f23311g.setVisibility(8);
        }
    }

    private void r() {
        if (!TextUtils.isEmpty(this.f23306b.getPhone()) || !TextUtils.isEmpty(this.s.e()) || (!TextUtils.isEmpty(this.f23306b.getEmail()) && this.f23306b.hasPassword())) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f23306b.isFbLogin()) {
            com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_logout_fb_unlink_info, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                public void onNegative(com.afollestad.materialdialogs.f fVar) {
                }

                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    f.this.f23307c.e();
                }
            });
        } else {
            this.f23307c.e();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.q.j();
        this.l.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_link_account));
        this.i.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.p.d();
        this.k.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_link_account));
        this.h.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.f23306b.isLineLogin()) {
            com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_logout_line_unlink_info, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                public void onNegative(com.afollestad.materialdialogs.f fVar) {
                }

                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    f.this.f23307c.h();
                }
            });
        } else {
            this.f23307c.h();
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (!this.p.a()) {
            this.p.a(getContext());
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (!this.q.a()) {
            this.q.a(getContext());
        }
    }

    public void k() {
        if (TextUtils.isEmpty(this.s.e())) {
            this.f23311g.setVisibility(8);
            this.j.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_link_account));
        } else {
            q();
            if (com.shopee.app.f.a.a().b()) {
                this.f23307c.b(this.s.e());
            } else {
                this.j.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_label_linked));
            }
        }
        if (this.p.a()) {
            this.p.b();
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
            this.k.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_link_account));
        }
        if (this.q.a()) {
            this.f23307c.g();
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
            this.l.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_link_account));
        }
        if (this.u.a("line_login")) {
            this.o.setVisibility(0);
            if (TextUtils.isEmpty(this.s.h())) {
                this.m.setVisibility(8);
                this.n.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_link_account));
                return;
            }
            this.n.setTextSecondary(com.garena.android.appkit.tools.b.e(R.string.sp_label_linked));
            r();
            return;
        }
        this.o.setVisibility(8);
    }

    public void l() {
        this.r.a();
    }

    public void m() {
        this.r.b();
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    public void c(String str) {
        this.w = true;
        this.j.setTextSecondary(str);
        q();
    }

    public void a(Intent intent) {
        this.p.a(intent);
        this.h.setVisibility(0);
    }

    public void b(Intent intent) {
        this.q.a(intent);
        this.f23307c.g();
        this.i.setVisibility(0);
    }

    public void d(String str) {
        if (this.p.a()) {
            this.k.setTextSecondary(str);
        }
    }

    public void e(String str) {
        if (this.q.a()) {
            this.l.setTextSecondary(str);
        }
    }

    public void n() {
        if (this.f23306b.isFbLogin()) {
            l();
            ar.f().i();
            this.f23310f.finish();
        }
    }

    public void o() {
        if (this.f23306b.isLineLogin()) {
            l();
            ar.f().i();
            this.f23310f.finish();
        }
    }

    public void p() {
        this.f23307c.f();
    }
}
