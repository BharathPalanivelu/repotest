package com.shopee.app.ui.product.add;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.util.bi;
import com.shopee.id.R;

public class q extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    View f24148a;

    /* renamed from: b  reason: collision with root package name */
    View f24149b;

    /* renamed from: c  reason: collision with root package name */
    View f24150c;

    /* renamed from: d  reason: collision with root package name */
    bi f24151d;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public q(Context context) {
        super(context);
        ((p) context).b().a(this);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f24150c.setVisibility(0);
        t tVar = new t();
        tVar.a(b.e(R.string.sp_label_share_description));
        tVar.c("NO_FACEBOOK_PAGE_SELECTED");
        this.f24151d.a("FACEBOOK_PAGE_SELECTED", new a(tVar));
    }

    public void c() {
        this.f24148a.setVisibility(8);
        this.f24149b.setVisibility(8);
    }

    public void d() {
        this.f24150c.setVisibility(0);
    }
}
