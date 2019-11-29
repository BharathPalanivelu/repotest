package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class g extends com.shopee.app.ui.a.b implements x<a> {

    /* renamed from: a  reason: collision with root package name */
    int f24507a;

    /* renamed from: b  reason: collision with root package name */
    long f24508b;

    /* renamed from: c  reason: collision with root package name */
    int f24509c;

    /* renamed from: d  reason: collision with root package name */
    int f24510d;

    /* renamed from: e  reason: collision with root package name */
    ak f24511e;

    /* renamed from: f  reason: collision with root package name */
    private a f24512f;

    /* renamed from: g  reason: collision with root package name */
    private b f24513g;
    private p h;

    public interface a {
        void a(g gVar);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.h = q.a(this, this.f24507a, this.f24508b, this.f24509c);
        a((View) this.h);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_comments).e(0);
        if (this.f24510d == 1) {
            this.f24513g = new b();
            aVar.a((a.b) this.f24513g);
        }
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24512f = s.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24512f.a(this);
    }

    private class b extends a.b {
        public b() {
            super("GOTO_PRODUCT_DETAIL", (int) R.drawable.com_garena_shopee_ic_order);
        }

        public void a() {
            g.this.f24511e.b(g.this.f24507a, g.this.f24508b);
        }
    }

    public void a(String str) {
        if (this.f24510d == 1) {
            ImageButton imageButton = (ImageButton) v().findViewWithTag(this.f24513g);
            imageButton.setPadding(b.a.f7693d, b.a.f7693d, b.a.f7693d, b.a.f7693d);
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            z.b((Context) this).a(str).a((ImageView) imageButton);
        }
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.h);
    }

    /* renamed from: c */
    public a b() {
        return this.f24512f;
    }
}
