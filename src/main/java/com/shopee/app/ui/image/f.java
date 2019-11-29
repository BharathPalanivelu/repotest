package com.shopee.app.ui.image;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;

public class f extends b implements x<h> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f22960a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<MediaData> f22961b;

    /* renamed from: c  reason: collision with root package name */
    boolean f22962c = false;

    /* renamed from: d  reason: collision with root package name */
    int f22963d = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f22964e = true;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.tracking.trackingv3.b f22965f;

    /* renamed from: g  reason: collision with root package name */
    private h f22966g;
    private j h;

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.b(bundle);
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(2);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.h = k.a(this, this.f22961b, this.f22962c, this.f22963d, this.f22964e);
        this.h.setId(R.id.tab_cont);
        a((View) this.h);
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22966g = e.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22966g.a(this);
    }

    /* renamed from: c */
    public h b() {
        return this.f22966g;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 64 && iArr.length > 0 && iArr[0] == 0) {
            this.h.d();
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.h.e();
    }

    public void onBackPressed() {
        this.h.c();
    }
}
