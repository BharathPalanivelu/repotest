package com.shopee.app.ui.order;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {
    private boolean j = false;
    private final c k = new c();

    public h(Context context, int i, String str) {
        super(context, i, str);
        g();
    }

    public static g a(Context context, int i, String str) {
        h hVar = new h(context, i, str);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.my_order_view_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23667c = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.tab_view);
        a();
    }
}
