package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class o extends n implements a, b {
    private boolean h = false;
    private final c i = new c();

    public o(Context context, int i2, int i3, String str) {
        super(context, i2, i3, str);
        h();
    }

    public static n a(Context context, int i2, int i3, String str) {
        o oVar = new o(context, i2, i3, str);
        oVar.onFinishInflate();
        return oVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.product_selection_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f20821a = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.tabView);
        this.f20822b = (Button) aVar.internalFindViewById(R.id.send_link_btn);
        this.f20824d = aVar.internalFindViewById(R.id.send_link);
        a();
    }
}
