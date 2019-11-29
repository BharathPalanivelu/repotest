package com.shopee.app.ui.setting.emailnotification;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    View f25225a;

    /* renamed from: b  reason: collision with root package name */
    a f25226b;

    /* renamed from: c  reason: collision with root package name */
    a f25227c;

    /* renamed from: d  reason: collision with root package name */
    a f25228d;

    /* renamed from: e  reason: collision with root package name */
    a f25229e;

    /* renamed from: f  reason: collision with root package name */
    a f25230f;

    /* renamed from: g  reason: collision with root package name */
    b f25231g;
    bc h;
    UserInfo i;
    r j;
    Activity k;
    RegionConfig l;
    private boolean m = false;
    private boolean n = false;

    public d(Context context) {
        super(context);
        ((m) ((x) context).b()).a(this);
        setOrientation(1);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.h.a(this.f25231g);
        this.f25231g.a(this);
        int i2 = 0;
        this.f25229e.setVisibility(this.l.isFullBuild() ? 0 : 8);
        a aVar = this.f25227c;
        if (!this.l.isFullBuild()) {
            i2 = 8;
        }
        aVar.setVisibility(i2);
        c();
        this.m = true;
    }

    public void a(UserInfo userInfo) {
        this.i = userInfo;
        if (this.n) {
            com.shopee.app.h.r.a().b((int) R.string.sp_email_reminder);
        }
        c();
    }

    public void b() {
        this.m = false;
        c();
        this.m = true;
    }

    public void c() {
        this.f25226b.setChecked(this.i.isAllEmailNotiOn());
        if (this.f25226b.c()) {
            this.f25225a.setVisibility(0);
            this.f25230f.setChecked(this.i.isEmailPersonalizeOn());
            this.f25228d.setChecked(this.i.isEmailListOn());
            this.f25229e.setChecked(this.i.isEmailNewsOn());
            this.f25227c.setChecked(this.i.isEmailOrderOn());
            return;
        }
        this.f25225a.setVisibility(4);
    }

    public void d() {
        this.j.a();
    }

    public void e() {
        this.j.b();
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        if (this.m) {
            this.n = !this.f25226b.c() && (this.f25230f.c() || this.f25229e.c());
            this.f25231g.a(this.i, this.f25226b.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        if (this.m) {
            this.n = !this.f25230f.c();
            this.f25231g.b(this.i, this.f25230f.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        if (this.m) {
            this.f25231g.c(this.i, this.f25228d.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        if (this.m) {
            this.n = !this.f25229e.c();
            this.f25231g.d(this.i, this.f25229e.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        if (this.m) {
            this.f25231g.e(this.i, this.f25227c.c());
        }
    }

    public void a(String str) {
        q.a((View) this, str);
    }
}
