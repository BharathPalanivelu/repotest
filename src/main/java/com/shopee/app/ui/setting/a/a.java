package com.shopee.app.ui.setting.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.h.r;
import com.shopee.app.network.http.a.d;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.b.a;
import com.shopee.app.ui.b.c;
import com.shopee.app.ui.image.icimage.c;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.n;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.a.f.b;
import java.util.List;

public class a extends b implements x<m>, b.C0475b {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.app.h.m f25028a;

    /* renamed from: b  reason: collision with root package name */
    d f25029b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.application.a.b f25030c;

    /* renamed from: d  reason: collision with root package name */
    n f25031d;

    /* renamed from: e  reason: collision with root package name */
    al f25032e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.ui.setting.a.a.a f25033f;

    /* renamed from: g  reason: collision with root package name */
    private m f25034g;
    private c h;
    private com.shopee.app.ui.c.a i;
    private com.shopee.app.ui.b.c j;
    private com.shopee.app.ui.b.a k;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25033f = new com.shopee.app.ui.setting.a.a.a(this);
        a((View) this.f25033f);
        this.h = c.b(new c.a() {
            public void onResult(String str, int i) {
                a.this.f25033f.a(str, i);
                r a2 = r.a();
                a2.a("photoOrientation: " + i);
            }
        });
        this.i = new com.shopee.app.ui.c.a(this.f25032e);
        this.j = new com.shopee.app.ui.b.c(this.f25028a, this.f25029b, new c.a() {
            public void onCheckConnectionResult(int i, String str) {
                r.a().a(String.valueOf(i) + "\nToken: " + str);
            }
        });
        this.k = new com.shopee.app.ui.b.a(this.f25030c, this.f25031d, new a.C0300a() {
            public void hideProgress() {
            }

            public void showProgress() {
            }

            public void onSuccess(String str) {
                r.a().a("Token: " + str);
            }

            public void onError(int i) {
                r.a().a("error");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.i.a((Context) this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_forbidden_zone_title).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25034g = com.shopee.app.ui.setting.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25034g.a(this);
    }

    /* renamed from: c */
    public m b() {
        return this.f25034g;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str) {
        r.a().a(str);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.h.a(this, i2, i3, intent);
        this.k.a(i2, i3, intent);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.i.a((Activity) this, i2, iArr);
    }

    public void l() {
        this.h.a(new PhotoFrameInfo(1.5f, 50));
        this.h.a((IcCamera3Info) null);
        this.h.a((Activity) this);
    }

    public void b(int i2) {
        this.h.a(new IcCamera3Info(i2));
        this.h.a((PhotoFrameInfo) null);
        this.h.a((Activity) this);
    }

    public void a(List<String> list) {
        this.i.a((Context) this, list, (b.C0475b) this);
    }

    public void b(List<String> list) {
        this.i.a((Activity) this, list, (b.C0475b) this);
    }

    public void p() {
        this.j.a();
    }

    public void q() {
        this.k.a((Activity) this);
    }

    public void onResult(List<Boolean> list) {
        r.a().a(list != null ? list.toString() : "Request Done!");
    }
}
