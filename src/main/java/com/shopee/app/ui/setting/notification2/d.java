package com.shopee.app.ui.setting.notification2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.v;
import com.shopee.app.h.q;
import com.shopee.app.pushnotification.a.a.c;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.setting.cell.SettingWithSelectionItemView;
import com.shopee.app.ui.setting.cell.a;
import com.shopee.app.ui.setting.m;
import com.shopee.app.ui.setting.notificationsound.NotificationSoundsActivity_;
import com.shopee.app.util.bc;
import com.shopee.app.util.s;
import com.shopee.app.util.x;

public class d extends LinearLayout implements r {

    /* renamed from: a  reason: collision with root package name */
    View f25279a;

    /* renamed from: b  reason: collision with root package name */
    a f25280b;

    /* renamed from: c  reason: collision with root package name */
    a f25281c;

    /* renamed from: d  reason: collision with root package name */
    SettingWithSelectionItemView f25282d;

    /* renamed from: e  reason: collision with root package name */
    a f25283e;

    /* renamed from: f  reason: collision with root package name */
    a f25284f;

    /* renamed from: g  reason: collision with root package name */
    a f25285g;
    a h;
    a i;
    a j;
    a k;
    a l;
    a m;
    a n;
    a o;
    a p;
    b q;
    bc r;
    UserInfo s;
    com.shopee.app.ui.common.r t;
    Activity u;
    RegionConfig v;
    SettingConfigStore w;
    s x;
    v y;
    private boolean z = false;

    public void c() {
    }

    public void d() {
    }

    public d(Context context) {
        super(context);
        ((m) ((x) context).b()).a(this);
        setOrientation(1);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.r.a(this.q);
        this.q.a(this);
        int i2 = 0;
        this.f25285g.setVisibility(this.v.isFullBuild() ? 0 : 8);
        this.f25283e.setVisibility(this.v.isFullBuild() ? 0 : 8);
        this.l.setVisibility((!this.w.buyerRatingEnabled() || !this.s.isSeller()) ? 8 : 0);
        this.m.setVisibility(this.s.isWalletFeatureOn() ? 0 : 8);
        a aVar = this.f25281c;
        if (!this.x.a("shopee_custom_noti_sound")) {
            i2 = 8;
        }
        aVar.setVisibility(i2);
        f();
        this.z = true;
    }

    public void b() {
        g();
    }

    public void a(UserInfo userInfo) {
        this.s = userInfo;
        f();
    }

    public void e() {
        this.z = false;
        f();
        this.z = true;
    }

    public void f() {
        this.f25280b.setChecked(this.s.isAllNotiOn());
        if (this.f25280b.c()) {
            this.f25279a.setVisibility(0);
            g();
            this.h.setChecked(this.s.isChatNotiOn());
            this.f25284f.setChecked(this.s.isActionRequiredNotiOn());
            this.i.setChecked(this.s.isActivityNotiOn());
            this.f25285g.setChecked(this.s.isOOSNotiOn());
            this.f25283e.setChecked(this.s.isSmartNotiOn());
            this.j.setChecked(this.s.isShopeePromotionNotiOn());
            this.k.setChecked(this.s.isPersonalContentNotiOn());
            this.l.setChecked(this.s.isNotiRatingOn());
            this.m.setChecked(this.s.isWalletNotiOn());
            this.n.setChecked(this.s.isFeedCommentNotiOn());
            this.o.setChecked(this.s.isFeedLikedNotiOn());
            this.p.setChecked(this.s.isFeedMentionedNotiOn());
            return;
        }
        this.f25279a.setVisibility(4);
    }

    public void g() {
        int i2 = 0;
        boolean z2 = this.x.a("shopee_custom_noti_sound") && this.y.f();
        SettingWithSelectionItemView settingWithSelectionItemView = this.f25282d;
        if (!z2) {
            i2 = 8;
        }
        settingWithSelectionItemView.setVisibility(i2);
        this.f25282d.setSelectionText(b.e(c.a().b()));
    }

    public void h() {
        this.t.a();
    }

    public void i() {
        this.t.b();
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        if (this.z) {
            this.q.a(this.f25281c.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        if (this.z) {
            NotificationSoundsActivity_.a(this.u).a();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        if (this.z) {
            this.q.a(this.s, this.f25280b.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        if (this.z) {
            this.q.b(this.s, this.h.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        if (this.z) {
            this.q.c(this.s, this.f25284f.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
        if (this.z) {
            this.q.d(this.s, this.i.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void g(View view) {
        if (this.z) {
            this.q.i(this.s, this.l.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void h(View view) {
        if (this.z) {
            this.q.j(this.s, this.m.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void i(View view) {
        if (this.z) {
            this.q.h(this.s, this.k.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void j(View view) {
        if (this.z) {
            this.q.e(this.s, this.f25285g.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        if (this.z) {
            this.q.f(this.s, this.f25283e.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void l(View view) {
        if (this.z) {
            this.q.g(this.s, this.j.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.z) {
            this.q.k(this.s, this.n.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.z) {
            this.q.l(this.s, this.o.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (this.z) {
            this.q.m(this.s, this.p.c());
        }
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void a(boolean z2) {
        this.z = false;
        this.f25281c.setChecked(z2);
        g();
        this.z = true;
    }
}
