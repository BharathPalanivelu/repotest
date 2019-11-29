package com.shopee.app.ui.image.icimage;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;

public class d extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    String f22995a;

    /* renamed from: b  reason: collision with root package name */
    PhotoFrameInfo f22996b;

    /* renamed from: c  reason: collision with root package name */
    IcCamera3Info f22997c;

    /* renamed from: d  reason: collision with root package name */
    int f22998d;

    /* renamed from: e  reason: collision with root package name */
    private b f22999e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        getWindow().getDecorView().setSystemUiVisibility(4);
        v().setVisibility(8);
        a((View) f.a(this, this.f22995a, this.f22996b, this.f22997c, this.f22998d));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22999e = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22999e.a(this);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* renamed from: c */
    public b b() {
        return this.f22999e;
    }
}
