package com.shopee.app.ui.order.views;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class q extends p implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f23918b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f23919c = new c();

    public q(Context context) {
        super(context);
        a();
    }

    public static p a(Context context) {
        q qVar = new q(context);
        qVar.onFinishInflate();
        return qVar;
    }

    public void onFinishInflate() {
        if (!this.f23918b) {
            this.f23918b = true;
            inflate(getContext(), R.layout.order_view_more_layout, this);
            this.f23919c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f23919c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23916a = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
