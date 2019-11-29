package com.shopee.app.ui.order.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f23870g = false;
    private final org.a.a.b.c h = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        d();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f23870g) {
            this.f23870g = true;
            inflate(getContext(), R.layout.order_footer_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.h);
        Resources resources = getContext().getResources();
        org.a.a.b.c.a((b) this);
        this.f23866d = resources.getDimensionPixelSize(R.dimen.dp8);
        this.f23867e = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f23868f = resources.getDimensionPixelSize(R.dimen.dp0);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23863a = (TextView) aVar.internalFindViewById(R.id.label);
        this.f23864b = (Button) aVar.internalFindViewById(R.id.button);
        this.f23865c = (Button) aVar.internalFindViewById(R.id.button1);
        a();
    }
}
