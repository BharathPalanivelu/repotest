package com.shopee.app.ui.video;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;

public class d extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    String f25772a;

    /* renamed from: b  reason: collision with root package name */
    private e f25773b;

    /* renamed from: c  reason: collision with root package name */
    private f f25774c;

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.b(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25774c = g.a(this, this.f25772a);
        a((View) this.f25774c);
        v().setVisibility(8);
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(4);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25773b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25773b.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.f25773b;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 64 && iArr.length > 0) {
            int i2 = iArr[0];
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f25774c.c();
    }
}
