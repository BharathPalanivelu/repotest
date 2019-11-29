package com.shopee.app.ui.actionbox2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.uikit.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.actionbox2.item.d;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends LinearLayout {
    b A;

    /* renamed from: a  reason: collision with root package name */
    TextView f19358a;

    /* renamed from: b  reason: collision with root package name */
    View f19359b;

    /* renamed from: c  reason: collision with root package name */
    View f19360c;

    /* renamed from: d  reason: collision with root package name */
    View f19361d;

    /* renamed from: e  reason: collision with root package name */
    d f19362e;

    /* renamed from: f  reason: collision with root package name */
    d f19363f;

    /* renamed from: g  reason: collision with root package name */
    d f19364g;
    d h;
    d i;
    d j;
    d k;
    d l;
    d m;
    d n;
    View o;
    ImageView p;
    TextView q;
    d r;
    ak s;
    ActionRequiredCounter t;
    ActivityCounter u;
    bi v;
    be w;
    UserInfo x;
    SettingConfigStore y;
    Activity z;

    public a(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        n();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        com.shopee.app.tracking.a.a.a(this.A, 3);
        this.s.b(this.x.isSeller());
    }

    /* access modifiers changed from: package-private */
    public void c() {
        com.shopee.app.tracking.a.a.a(this.A, 3);
        this.s.aa();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        com.shopee.app.tracking.a.a.a(this.A, 9);
        this.s.e(9);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        com.shopee.app.tracking.a.a.a(this.A, 10);
        this.s.e(10);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        com.shopee.app.tracking.a.a.a(this.A, 1);
        this.s.e(1);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        com.shopee.app.tracking.a.a.a(this.A, 6);
        this.s.e(6);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        com.shopee.app.tracking.a.a.a(this.A, 8);
        this.s.e(8);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        com.shopee.app.tracking.a.a.a(this.A, 7);
        this.s.e(7);
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.t.clear(11);
        this.s.u("@shopee-rn/foody/NOTIFICATION_PAGE");
    }

    /* access modifiers changed from: package-private */
    public void k() {
        com.shopee.app.tracking.a.a.a(this.A, 12);
        this.s.e(12);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        c cVar = (c) this.z.findViewById(R.id.sp_home_tab_view);
        if (cVar != null) {
            cVar.setSelectedIndex(0);
        }
    }

    public void setReadAllViewVisibility(int i2) {
        if (i2 == 8) {
            this.f19358a.setVisibility(8);
            this.f19360c.setVisibility(0);
            return;
        }
        this.f19358a.setVisibility(0);
        this.f19360c.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.A.a("read_all_button", "order_updates", b.f19172a, "notifications");
        this.v.a().ae.a();
    }

    private void s() {
        if (!com.shopee.app.util.c.b() || !this.w.d() || !this.x.isAllNotiOn()) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        f a2 = f.a(getContext());
        a2.a((int) R.string.sp_no_push_info).a().b(com.garena.android.appkit.tools.b.a(R.color.white)).c().b();
        a2.a(SQLBuilder.BLANK).b();
        a2.a().a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_tap_4_noti_settings)).a().b(com.garena.android.appkit.tools.b.a(R.color.white)).a().c().b();
        a2.a(this.q);
    }

    public void n() {
        s();
        if (this.x.isSeller()) {
            this.f19362e.setVisibility(8);
            this.f19364g.setVisibility(0);
            return;
        }
        this.f19362e.setVisibility(0);
        this.f19364g.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.s.af();
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.p.setVisibility(8);
        this.w.e();
        n();
    }

    /* access modifiers changed from: package-private */
    public void q() {
        com.shopee.app.tracking.a.a.a(this.A, 13);
        this.s.e(13);
    }

    public void r() {
        n();
        this.l.setBadgeCount(this.t.getCount(7));
        this.k.setBadgeCount(this.t.getCount(1));
        this.j.setBadgeCount(this.t.getCount(6));
        this.i.setBadgeCount(this.t.getCount(8));
        this.f19362e.setBadgeCount(this.u.getCount());
        this.h.setBadgeCount(this.t.getCount(9));
        this.f19364g.setBadgeCount(this.t.getCount(2) + this.u.getCount());
        this.f19363f.setBadgeCount(this.t.getCount(10));
        this.m.setBadgeCount(this.t.getCount(11));
        this.n.setBadgeCount(this.t.getCount(12));
        this.r.setBadgeCount(this.t.getCount(13));
        int count = this.t.getCount(4);
        if (count <= 0) {
            this.f19358a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
            this.f19358a.setClickable(false);
            this.f19358a.setText(R.string.sp_label_read_all);
            return;
        }
        this.f19358a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f19358a.setClickable(true);
        TextView textView = this.f19358a;
        textView.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_read_all) + " (" + count + SQLBuilder.PARENTHESES_RIGHT);
    }

    public void a(String str) {
        n();
        this.f19364g.a(str);
    }

    public void a(int i2, String str) {
        n();
        switch (i2) {
            case 1:
                this.k.a(str);
                return;
            case 3:
                this.f19362e.a(str);
                return;
            case 6:
                if (TextUtils.isEmpty(str)) {
                    this.j.setVisibility(8);
                    return;
                }
                this.j.setVisibility(0);
                this.j.a(str);
                return;
            case 7:
                if (!this.y.buyerRatingEnabled() || TextUtils.isEmpty(str)) {
                    this.l.setVisibility(8);
                    return;
                }
                this.l.setVisibility(0);
                this.l.a(str);
                return;
            case 8:
                if (TextUtils.isEmpty(str)) {
                    this.i.setVisibility(8);
                    return;
                }
                this.i.setVisibility(0);
                this.i.a(str);
                return;
            case 9:
                if (TextUtils.isEmpty(str)) {
                    this.h.setVisibility(8);
                    return;
                }
                this.h.setVisibility(0);
                this.h.a(str);
                return;
            case 10:
                if (TextUtils.isEmpty(str)) {
                    this.f19363f.setVisibility(8);
                    return;
                }
                this.f19363f.setVisibility(0);
                this.f19363f.a(str);
                return;
            case 11:
                if (TextUtils.isEmpty(str)) {
                    this.m.setVisibility(8);
                    return;
                }
                this.m.setVisibility(0);
                this.m.a(str);
                return;
            case 12:
                if (TextUtils.isEmpty(str)) {
                    this.n.setVisibility(8);
                    return;
                }
                this.n.setVisibility(0);
                this.n.a(str);
                return;
            case 13:
                if (TextUtils.isEmpty(str)) {
                    this.r.setVisibility(8);
                    return;
                }
                this.r.setVisibility(0);
                this.r.a(str);
                return;
            default:
                return;
        }
    }
}
