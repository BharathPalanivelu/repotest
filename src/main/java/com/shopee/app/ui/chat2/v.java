package com.shopee.app.ui.chat2;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.chat.c;
import com.shopee.app.util.x;
import com.shopee.id.R;
import tencent.tls.platform.TLSErrInfo;

public class v extends b implements x<com.shopee.app.ui.chat.b> {

    /* renamed from: a  reason: collision with root package name */
    int f20945a = -1;

    /* renamed from: b  reason: collision with root package name */
    String f20946b = "";

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.app.ui.chat.b f20947c;

    /* renamed from: d  reason: collision with root package name */
    private y f20948d;

    public interface a {
        void a(v vVar);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f20948d = z.a(this, this.f20945a, this.f20946b);
        a((View) this.f20948d);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_message_shortcuts).e(0);
        if (this.f20945a > -1) {
            aVar.a(new e.a().a((int) R.string.sp_label_delete, (int) TLSErrInfo.PENDING, "http://mall.test.shopee.sg/static/images/ic_bankaccount_delete_3x.png").a((int) R.string.sp_label_back_to_home, -1101, (int) R.drawable.ic_backtohomepage));
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20947c = c.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20947c.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.chat.b b() {
        return this.f20947c;
    }

    public void onBackPressed() {
        this.f20948d.f();
    }
}
