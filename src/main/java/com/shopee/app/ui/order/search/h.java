package com.shopee.app.ui.order.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f23821d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f23822e = new c();

    public h(Context context) {
        super(context);
        a();
    }

    public static g a(Context context) {
        h hVar = new h(context);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.f23821d) {
            this.f23821d = true;
            inflate(getContext(), R.layout.search_orders_item_summary_view, this);
            this.f23822e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f23822e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23817a = (TextView) aVar.internalFindViewById(R.id.name);
        this.f23818b = (TextView) aVar.internalFindViewById(R.id.see_all);
    }
}
