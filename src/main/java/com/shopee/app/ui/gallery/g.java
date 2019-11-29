package com.shopee.app.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;

public class g extends b implements x<m> {

    /* renamed from: a  reason: collision with root package name */
    GalleryData f21901a;

    /* renamed from: b  reason: collision with root package name */
    int f21902b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<GalleryData> f21903c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    int f21904d = 0;

    /* renamed from: e  reason: collision with root package name */
    long f21905e = -99;

    /* renamed from: f  reason: collision with root package name */
    String f21906f = "";

    /* renamed from: g  reason: collision with root package name */
    private m f21907g;
    private j h;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.h = k.a(this, this.f21903c, this.f21905e, this.f21904d, this.f21901a, this.f21902b, this.f21906f);
        a((View) this.h);
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21907g = d.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21907g.a(this);
    }

    /* renamed from: c */
    public m b() {
        return this.f21907g;
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).a("ACTION_BAR_DONE", (int) R.drawable.com_garena_shopee_ic_done);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("imageList", this.h.getImageList());
        setResult(-1, intent);
        super.onBackPressed();
    }
}
