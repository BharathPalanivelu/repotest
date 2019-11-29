package com.shopee.app.ui.order.b.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {
    private boolean i = false;
    private final org.a.a.b.c j = new org.a.a.b.c();

    public c(Context context, boolean z) {
        super(context, z);
        g();
    }

    public static b a(Context context, boolean z) {
        c cVar = new c(context, z);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.my_order_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.j);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23519a = (ListView) aVar.internalFindViewById(R.id.order_list);
        this.f23520b = (FrameLayout) aVar.internalFindViewById(R.id.container);
        d();
    }
}
