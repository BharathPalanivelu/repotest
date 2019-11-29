package com.shopee.app.ui.myproduct;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.garena.android.appkit.floating.FloatingActionsMenu;
import com.garena.android.uikit.a.c;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.common.ap;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.ak;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;

public class e extends RelativeLayout implements FloatingActionsMenu.OnFloatingActionsMenuUpdateListener, r {

    /* renamed from: a  reason: collision with root package name */
    c f23432a;

    /* renamed from: b  reason: collision with root package name */
    FloatingActionsMenu f23433b;

    /* renamed from: c  reason: collision with root package name */
    View f23434c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f23435d;

    /* renamed from: e  reason: collision with root package name */
    ak f23436e;

    /* renamed from: f  reason: collision with root package name */
    f f23437f;

    /* renamed from: g  reason: collision with root package name */
    UserInfo f23438g;
    UploadManager h;
    SettingConfigStore i;
    Activity j;
    s k;
    private final int l;
    private View.OnClickListener m = new View.OnClickListener() {
        public void onClick(View view) {
            e.this.f23433b.collapse();
        }
    };

    public e(Context context, int i2) {
        super(context);
        ((c) ((x) context).b()).a(this);
        this.l = i2;
    }

    public void onMenuExpanded() {
        this.f23434c.setVisibility(0);
    }

    public void onMenuCollapsed() {
        this.f23434c.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        d dVar = new d(this.k.a("delist_product"));
        this.f23432a.setAdapter(dVar);
        this.f23432a.setTabIndicator(new ap(dVar.b()));
        this.f23432a.a();
        this.f23432a.setSelectedIndex(this.l);
        this.f23433b.setOnFloatingActionsMenuUpdateListener(this);
        this.f23434c.setOnClickListener(this.m);
        if (this.i.showTheme()) {
            this.f23435d.setVisibility(0);
            w.a(getContext()).a(this.i.getThemeOneImage()).a().a(this.f23435d);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a(0);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a(1);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a(2);
    }

    private void a(int i2) {
        boolean z = false;
        if (!this.f23438g.isLoggedIn()) {
            a.a(getContext(), (int) R.string.sp_login_msg_add_product, 0);
        } else if (this.f23438g.isHolidayMode()) {
            com.shopee.app.h.r.a().b((int) R.string.sp_vacation_add_edit_error);
        } else {
            if (this.f23438g.isBACheckNeeded() && this.i.allowBACheck()) {
                z = true;
            }
            this.f23436e.a(i2, this.h, z, true);
        }
    }

    public boolean h() {
        if (!this.f23433b.isExpanded()) {
            return false;
        }
        this.f23433b.collapse();
        return true;
    }

    public void b() {
        this.f23432a.b();
    }

    public void c() {
        this.f23432a.c();
        this.f23433b.collapse();
    }

    public void d() {
        this.f23432a.d();
    }
}
