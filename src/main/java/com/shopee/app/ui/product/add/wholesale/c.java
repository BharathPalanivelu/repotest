package com.shopee.app.ui.product.add.wholesale;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.application.ar;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class c extends b implements l, x<e> {

    /* renamed from: a  reason: collision with root package name */
    k f24191a;

    /* renamed from: b  reason: collision with root package name */
    Long f24192b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<WholesaleTierModel> f24193c;

    /* renamed from: d  reason: collision with root package name */
    boolean f24194d;

    /* renamed from: e  reason: collision with root package name */
    private g f24195e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f24195e = new g(this);
        this.f24195e.setPresenter(this.f24191a);
        this.f24195e.setModel(new i(this.f24191a));
        this.f24191a.a(this);
        a((q) this.f24191a);
        a((View) this.f24195e);
        r();
        if (this.f24194d) {
            q();
        }
    }

    private void r() {
        this.f24191a.a(this.f24192b);
        this.f24191a.a((List<WholesaleTierModel>) this.f24193c);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        super.a(aVar);
        aVar.f(1).b((int) R.string.wholesale).e(0).a((a.b) new a.b("save", getString(R.string.sp_label_save).toUpperCase()) {
            public void a() {
                c.this.f24191a.h();
            }
        });
    }

    /* renamed from: c */
    public e b() {
        e a2 = a.c().a(ar.f().e()).a(new com.shopee.app.a.b(this)).a();
        a2.a(this);
        return a2;
    }

    public void removeTier(View view) {
        this.f24195e.a(view);
        this.f24195e.a();
    }

    public void a(String str) {
        com.shopee.app.h.q.b(this.f24195e.getTierRootView(), str);
    }

    public void b(int i) {
        int i2 = i + 2;
        LinearLayout tierRootView = this.f24195e.getTierRootView();
        int childCount = tierRootView.getChildCount();
        if (i2 >= 0 && i2 < childCount) {
            tierRootView.getChildAt(i2).setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        }
    }

    public void l() {
        LinearLayout tierRootView = this.f24195e.getTierRootView();
        for (int i = 2; i < tierRootView.getChildCount() - 3; i++) {
            tierRootView.getChildAt(i).setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.white));
        }
    }

    public void p() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("EXTRA_WHOLESALE_TIERS", new ArrayList(this.f24191a.g()));
        setResult(-1, intent);
        finish();
    }

    public f a(WholesaleTierModel wholesaleTierModel) {
        LinearLayout tierRootView = this.f24195e.getTierRootView();
        f fVar = new f(this);
        fVar.setPresenter(this.f24191a);
        fVar.a(wholesaleTierModel);
        tierRootView.addView(fVar, tierRootView.getChildCount() - 4);
        this.f24195e.a();
        return fVar;
    }

    public void showKeyboard(View view) {
        com.shopee.app.c.a.b(view);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f24191a.i();
        return super.dispatchTouchEvent(motionEvent);
    }

    public void q() {
        com.shopee.app.ui.dialog.a.a((Context) this, 0, (int) R.string.wholesale_promotion_warning, (int) R.string.button_ok, 0);
    }

    public void onBackPressed() {
        if (this.f24191a.j()) {
            com.shopee.app.ui.dialog.a.a((Context) this, (int) R.string.wholesale_back_popup, (int) R.string.sp_label_no, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    c.super.onBackPressed();
                }
            });
        } else {
            super.onBackPressed();
        }
    }
}
