package com.shopee.app.ui.error;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.react.g;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.x;

public class a extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    String f21604a = "404";

    /* renamed from: b  reason: collision with root package name */
    private e f21605b;

    /* renamed from: com.shopee.app.ui.error.a$a  reason: collision with other inner class name */
    public interface C0319a {
        void a(a aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) c.a(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a(this.f21604a);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21605b = com.shopee.app.ui.home.b.c().a(g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.f21605b.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.f21605b;
    }
}
