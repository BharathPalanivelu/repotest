package com.shopee.app.ui.tracklog;

import android.os.Bundle;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;

public class TrackLogActivity extends b implements x<h> {

    /* renamed from: a  reason: collision with root package name */
    private h f25633a;

    /* access modifiers changed from: protected */
    public void a(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void b(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        x().setContentView(k.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a("Track Events");
    }

    /* renamed from: c */
    public h b() {
        return this.f25633a;
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25633a = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25633a.a(this);
    }

    public void onBackPressed() {
        finish();
    }
}
