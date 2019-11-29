package com.shopee.app.ui.setting.notificationsound;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.x;
import com.shopee.id.R;
import d.d.b.j;

public class a extends b implements x<m> {

    /* renamed from: a  reason: collision with root package name */
    public m f25304a;

    public void a(m mVar) {
        j.b(mVar, "<set-?>");
        this.f25304a = mVar;
    }

    public m c() {
        m mVar = this.f25304a;
        if (mVar == null) {
            j.b("mComponent");
        }
        return mVar;
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        m a2 = com.shopee.app.ui.setting.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        j.a((Object) a2, "DaggerSettingComponent.b…\n                .build()");
        a(a2);
        c().a(this);
    }

    /* renamed from: l */
    public m b() {
        return c();
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        if (aVar != null) {
            a.C0296a f2 = aVar.f(1);
            if (f2 != null) {
                a.C0296a b2 = f2.b((int) R.string.sp_label_select_notification_sounds);
                if (b2 != null) {
                    b2.e(0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new b(this, (AttributeSet) null, 0, 6, (g) null));
    }
}
