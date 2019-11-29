package com.shopee.app.ui.order.b.c;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean j = false;
    private final c k = new c();

    public g(Context context, boolean z) {
        super(context, z);
        h();
    }

    public g(Context context, boolean z, int i) {
        super(context, z, i);
        h();
    }

    public static f a(Context context, boolean z) {
        g gVar = new g(context, z);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.my_order_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static f a(Context context, boolean z, int i) {
        g gVar = new g(context, z, i);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onViewChanged(a aVar) {
        this.f23553a = (ListView) aVar.internalFindViewById(R.id.order_list);
        this.f23554b = (FrameLayout) aVar.internalFindViewById(R.id.container);
        if (this.f23553a != null) {
            this.f23553a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.order.b.c.g r2 = com.shopee.app.ui.order.b.c.g.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.a.m r1 = (com.shopee.app.ui.a.m) r1
                        r2.a((com.shopee.app.ui.a.m) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.order.b.c.g.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        d();
    }
}
