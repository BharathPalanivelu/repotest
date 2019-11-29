package com.shopee.app.ui.webview.simpleweb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.tracking.b.d;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.webview.e;
import com.shopee.app.util.x;
import java.util.ArrayList;
import java.util.List;

public class a extends b implements com.shopee.a.b.b, x<e> {

    /* renamed from: a  reason: collision with root package name */
    String f26073a;

    /* renamed from: b  reason: collision with root package name */
    String f26074b;

    /* renamed from: c  reason: collision with root package name */
    boolean f26075c;

    /* renamed from: d  reason: collision with root package name */
    private e f26076d;

    /* renamed from: e  reason: collision with root package name */
    private b f26077e;

    /* renamed from: f  reason: collision with root package name */
    private d f26078f;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f26077e = c.a(this);
        this.f26077e.a(new WebPageModel(this.f26074b), this.f26075c);
        a((View) this.f26077e);
        this.f26078f = new d(this.f26074b);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f26076d = com.shopee.app.ui.webview.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f26076d.a(this);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b(this.f26073a, this.f26074b);
    }

    /* renamed from: c */
    public e b() {
        return this.f26076d;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            b bVar = this.f26077e;
            if (bVar != null) {
                bVar.a(i, (List<String>) stringArrayListExtra);
                return;
            }
            return;
        }
        b bVar2 = this.f26077e;
        if (bVar2 != null) {
            bVar2.a(i, (List<String>) new ArrayList());
        }
    }

    public com.shopee.a.b.a r() {
        return this.f26078f;
    }
}
