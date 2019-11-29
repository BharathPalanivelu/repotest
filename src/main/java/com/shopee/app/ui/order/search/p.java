package com.shopee.app.ui.order.search;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class p extends o implements a, b {
    private boolean m = false;
    private final c n = new c();

    public p(Context context, int i, int i2, String str, int i3) {
        super(context, i, i2, str, i3);
        g();
    }

    public static o a(Context context, int i, int i2, String str, int i3) {
        p pVar = new p(context, i, i2, str, i3);
        pVar.onFinishInflate();
        return pVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.search_orders_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23852e = (ListView) aVar.internalFindViewById(R.id.order_list);
        this.f23853f = aVar.internalFindViewById(R.id.empty_vew);
        this.f23854g = (TextView) aVar.internalFindViewById(R.id.label);
        this.h = (TextView) aVar.internalFindViewById(R.id.label1);
        if (this.f23852e != null) {
            this.f23852e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.order.search.p r2 = com.shopee.app.ui.order.search.p.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.order.search.f r1 = (com.shopee.app.ui.order.search.f) r1
                        r2.a((com.shopee.app.ui.order.search.f) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.order.search.p.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}
