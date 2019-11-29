package com.shopee.app.ui.video.trim;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.video.e;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    String f25788a;

    /* renamed from: b  reason: collision with root package name */
    private e f25789b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f25790c;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25790c = c.a(this, this.f25788a);
        a((View) this.f25790c);
        v().setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.secondary_dark));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25789b = com.shopee.app.ui.video.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25789b.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.f25789b;
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).c((int) R.color.white).a((a.b) new a.b("SUBMIT", R.drawable.com_garena_shopee_ic_done) {
            public void a() {
                a.this.f25790c.c();
            }
        }).a(com.garena.android.appkit.tools.b.e(R.string.sp_label_trim_video));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f25790c.b();
    }
}
