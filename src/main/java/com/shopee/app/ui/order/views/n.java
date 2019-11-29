package com.shopee.app.ui.order.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean i = false;
    private final c j = new c();

    public n(Context context) {
        super(context);
        b();
    }

    public static m a(Context context) {
        n nVar = new n(context);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.order_total_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.j);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f23913g = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.f23910d = resources.getDimensionPixelSize(R.dimen.dp8);
        this.f23911e = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f23912f = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f23907a = (TextView) aVar.internalFindViewById(R.id.item_count);
        this.f23908b = (TextView) aVar.internalFindViewById(R.id.total_price);
        this.f23909c = aVar.internalFindViewById(R.id.divider);
        a();
    }
}
