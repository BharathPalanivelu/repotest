package com.shopee.app.ui.home.me.editprofile.bio;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.home.me.editprofile.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    String f22328a = "";

    /* renamed from: b  reason: collision with root package name */
    int f22329b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f22330c = R.string.sp_info_edit_message_shortcuts;

    /* renamed from: d  reason: collision with root package name */
    int f22331d = 500;

    /* renamed from: e  reason: collision with root package name */
    int f22332e = R.string.sp_feed_bio_error;

    /* renamed from: f  reason: collision with root package name */
    int f22333f = R.string.sp_edit_profile;

    /* renamed from: g  reason: collision with root package name */
    private d f22334g;
    private d h;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.h = e.a(this, this.f22328a, this.f22331d, this.f22332e, this.f22330c, this.f22329b);
        a((View) this.h);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b(this.f22333f).a("ACTION_BAR_DONE", com.garena.android.appkit.tools.b.e(R.string.sp_label_save).toUpperCase()).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22334g = com.shopee.app.ui.home.me.editprofile.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22334g.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f22334g;
    }

    public void onBackPressed() {
        this.h.d();
    }
}
