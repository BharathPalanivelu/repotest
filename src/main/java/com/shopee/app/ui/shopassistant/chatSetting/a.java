package com.shopee.app.ui.shopassistant.chatSetting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    private b f25391a;

    /* renamed from: b  reason: collision with root package name */
    private f f25392b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25392b = g.a(this);
        a((View) this.f25392b);
    }

    public void onBackPressed() {
        this.f25392b.e();
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_chat_settings).a((a.b) new d(this)).g().e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25391a = i.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25391a.a(this);
    }

    /* renamed from: c */
    public b b() {
        return this.f25391a;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            this.f25392b.b(intent.getStringExtra("AUTO_REPLY"));
        }
    }
}
