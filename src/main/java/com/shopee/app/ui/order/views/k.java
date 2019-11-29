package com.shopee.app.ui.order.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f23905f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f23906g = new c();

    public k(Context context) {
        super(context);
        b();
    }

    public static j a(Context context) {
        k kVar = new k(context);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.f23905f) {
            this.f23905f = true;
            inflate(getContext(), R.layout.order_status_view, this);
            this.f23906g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f23906g);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f23899c = resources.getDimensionPixelSize(R.dimen.dp8);
        this.f23900d = resources.getDimensionPixelSize(R.dimen.dp16);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23897a = aVar.internalFindViewById(R.id.order_status_section);
        this.f23898b = (TextView) aVar.internalFindViewById(R.id.order_status);
        a();
    }
}
