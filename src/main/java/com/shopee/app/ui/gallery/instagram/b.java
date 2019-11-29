package com.shopee.app.ui.gallery.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.gallery.GalleryData;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;

public class b extends com.shopee.app.ui.a.b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    int f21933a = 1;

    /* renamed from: b  reason: collision with root package name */
    String f21934b = "";

    /* renamed from: c  reason: collision with root package name */
    private c f21935c;

    /* renamed from: d  reason: collision with root package name */
    private f f21936d;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f21936d = g.a(this, this.f21933a, bundle == null, this.f21934b);
        a((View) this.f21936d);
        v().setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.secondary_dark));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).c((int) R.color.white).a("Instagram");
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21935c = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21935c.a(this);
    }

    /* renamed from: c */
    public c b() {
        return this.f21935c;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<GalleryData> arrayList, boolean z, int i) {
        this.f21936d.a(arrayList);
        if (z) {
            this.f21936d.c(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            this.f21936d.a(intent);
        } else {
            finish();
        }
    }
}
