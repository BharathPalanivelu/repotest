package com.shopee.app.ui.image.editor;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    String f22881a;

    /* renamed from: b  reason: collision with root package name */
    private d f22882b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) f.a(this, this.f22881a));
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).c((int) R.color.white).a(com.garena.android.appkit.tools.b.e(R.string.sp_label_all_images));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22882b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22882b.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f22882b;
    }
}
