package com.shopee.app.ui.product.add;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.b.a;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.bi;

public class u extends RelativeLayout implements n<t> {

    /* renamed from: a  reason: collision with root package name */
    TextView f24159a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f24160b;

    /* renamed from: c  reason: collision with root package name */
    View f24161c;

    /* renamed from: d  reason: collision with root package name */
    bi f24162d;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public u(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((p) context).b().a(this);
    }

    public void a(final t tVar) {
        this.f24159a.setText(tVar.a());
        if (tVar.d()) {
            this.f24161c.setVisibility(0);
        }
        AnonymousClass1 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                u.this.f24161c.setVisibility(0);
                u.this.f24162d.a("FACEBOOK_PAGE_SELECTED", new a(tVar));
            }
        };
        this.f24160b.setOnClickListener(r0);
        this.f24159a.setOnClickListener(r0);
    }
}
