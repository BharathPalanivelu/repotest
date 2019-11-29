package com.shopee.app.ui.order.rate;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean h = false;
    private final c i = new c();

    public g(Context context, long j, int i2, int i3, int i4) {
        super(context, j, i2, i3, i4);
        e();
    }

    public static f a(Context context, long j, int i2, int i3, int i4) {
        g gVar = new g(context, j, i2, i3, i4);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.rate_order_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23787a = (LinearLayout) aVar.internalFindViewById(R.id.order_list);
        this.f23788b = aVar.internalFindViewById(R.id.empty_vew);
        a();
    }
}
