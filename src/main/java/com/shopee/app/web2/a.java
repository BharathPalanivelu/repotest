package com.shopee.app.web2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.afollestad.materialdialogs.f;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.home.d.d;
import com.shopee.app.ui.webview.e;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.internal.a;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import java.util.ArrayList;
import java.util.List;

public class a extends b implements com.shopee.a.b.b, x<e> {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.web.sdk.bridge.internal.a f26578a;

    /* renamed from: b  reason: collision with root package name */
    a.C0476a f26579b;

    /* renamed from: c  reason: collision with root package name */
    String f26580c;

    /* renamed from: d  reason: collision with root package name */
    boolean f26581d;

    /* renamed from: e  reason: collision with root package name */
    String f26582e;

    /* renamed from: f  reason: collision with root package name */
    String f26583f;

    /* renamed from: g  reason: collision with root package name */
    int f26584g;
    String h;
    ConfigurePageRequest.ConfigMessage i;
    private d j;
    private e k;
    private d l = new d();
    private com.shopee.app.util.a.b m = new com.shopee.app.util.a.b();
    private com.shopee.app.tracking.b.d n;

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.l.c();
        this.m.a();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.f26582e);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("url");
        if (!TextUtils.isEmpty(string)) {
            this.f26582e = string;
        }
    }

    public void onPause() {
        super.onPause();
        this.l.b();
        if (isFinishing() && this.f26581d) {
            overridePendingTransition(R.anim.not_move_ani, R.anim.slide_out_from_bottom_fast);
        }
        this.m.b();
    }

    public void onDestroy() {
        d dVar = this.j;
        if (dVar != null) {
            dVar.b();
        }
        super.onDestroy();
        this.l.f();
        this.f26578a.c();
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        try {
            if (this.i != null && this.i.getWebviewType() == 2) {
                List bridgeWhitelist = this.i.getBridgeWhitelist();
                if (bridgeWhitelist == null) {
                    bridgeWhitelist = new ArrayList();
                }
                this.f26579b.a((List<String>) bridgeWhitelist);
            }
            this.f26578a = this.f26579b.a();
            d a2 = e.a(this, this.i, this.f26578a);
            a2.a(new WebPageModel(this.f26582e));
            a2.setLastPageJs(this.f26583f);
            this.f26583f = null;
            this.j = a2;
            a((View) a2);
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage(), 0).show();
            a(new View(this));
            com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.sp_label_webview_error, 0, (int) R.string.button_ok, (f.b) new f.b() {
                public void onPositive(f fVar) {
                    ar.a(false);
                }
            });
        }
        this.n = new com.shopee.app.tracking.b.d(this.f26582e);
        com.shopee.app.ui.setting.b.a.f25184a.a(this, this.f26582e);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.l.a(this, i2, i3, intent);
        this.f26578a.a((Activity) this, i2, i3, intent);
        com.shopee.sdk.b.a().e().a((Activity) this, i2, i3, intent);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f26578a.a((Activity) this, i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b(this.f26580c, this.f26582e);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.k = com.shopee.app.ui.webview.a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.k.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.k;
    }

    public void onBackPressed() {
        if (!this.f26578a.d()) {
            super.onBackPressed();
        }
    }

    public void a(ConfigurePageRequest.ConfigMessage configMessage) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.a(configMessage);
        }
    }

    public void a(String str) {
        a.C0296a aVar = new a.C0296a();
        aVar.f(1).e(0).b(str, this.f26582e);
        x().b(aVar);
    }

    public com.shopee.a.b.a r() {
        return this.n;
    }
}
