package com.shopee.app.ui.chat2.order;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f20679f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f20680g = new c();

    public g(Context context, int i, int i2) {
        super(context, i, i2);
        h();
    }

    public static f a(Context context, int i, int i2) {
        g gVar = new g(context, i, i2);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.f20679f) {
            this.f20679f = true;
            inflate(getContext(), R.layout.order_selection_list_layout, this);
            this.f20680g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.f20680g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20668a = (ListView) aVar.internalFindViewById(R.id.listView);
        if (this.f20668a != null) {
            this.f20668a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.chat2.order.g r2 = com.shopee.app.ui.chat2.order.g.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.a.m r1 = (com.shopee.app.ui.a.m) r1
                        r2.a((com.shopee.app.ui.a.m) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.chat2.order.g.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        d();
    }
}
