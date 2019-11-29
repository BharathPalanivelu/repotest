package com.shopee.app.ui.product.comment.FeedsComment;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.product.comment.a;
import com.shopee.app.ui.product.comment.s;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends b implements x<a> {

    /* renamed from: a  reason: collision with root package name */
    int f24425a;

    /* renamed from: b  reason: collision with root package name */
    long f24426b;

    /* renamed from: c  reason: collision with root package name */
    private a f24427c;

    /* renamed from: d  reason: collision with root package name */
    private g f24428d;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f24428d = h.a(this, this.f24425a, this.f24426b);
        a((View) this.f24428d);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_comments).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24427c = s.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24427c.a(this);
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.f24428d);
    }

    /* renamed from: c */
    public com.shopee.app.ui.product.comment.a b() {
        return this.f24427c;
    }
}
