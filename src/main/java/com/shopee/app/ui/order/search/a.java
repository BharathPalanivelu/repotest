package com.shopee.app.ui.order.search;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.order.d;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    String f23797a;

    /* renamed from: b  reason: collision with root package name */
    String f23798b;

    /* renamed from: c  reason: collision with root package name */
    int f23799c;

    /* renamed from: d  reason: collision with root package name */
    int f23800d;

    /* renamed from: e  reason: collision with root package name */
    int f23801e = 0;

    /* renamed from: f  reason: collision with root package name */
    SettingConfigStore f23802f;

    /* renamed from: g  reason: collision with root package name */
    private d f23803g;

    /* renamed from: com.shopee.app.ui.order.search.a$a  reason: collision with other inner class name */
    public interface C0371a {
        void a(a aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) p.a(this, this.f23801e, this.f23800d, this.f23798b, this.f23799c));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        int i = this.f23801e;
        if (i == 0) {
            aVar.f(2);
            if (this.f23802f.searchRecipientEnabled()) {
                aVar.b(com.garena.android.appkit.tools.b.e(R.string.sp_order_search_hint));
            } else {
                aVar.b(com.garena.android.appkit.tools.b.e(R.string.sp_order_search_hint_no_recipient));
            }
        } else if (i == 1) {
            aVar.f(1).e(0).a(this.f23797a);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23803g = com.shopee.app.ui.order.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23803g.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f23803g;
    }
}
