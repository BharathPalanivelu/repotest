package com.shopee.app.ui.order.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean o = false;
    private final c p = new c();

    public g(Context context) {
        super(context);
        b();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.o) {
            this.o = true;
            inflate(getContext(), R.layout.order_product_item_layout, this);
            this.p.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.p);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.h = resources.getString(R.string.sp_new_n_old_price);
        this.l = resources.getDimensionPixelSize(R.dimen.font_size_14);
        this.m = resources.getDimensionPixelSize(R.dimen.dp8);
        this.n = resources.getDimensionPixelSize(R.dimen.dp16);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23885a = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f23886b = (TextView) aVar.internalFindViewById(R.id.product_title);
        this.f23887c = (TextView) aVar.internalFindViewById(R.id.product_variation);
        this.f23888d = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f23889e = (TextView) aVar.internalFindViewById(R.id.bundle_price);
        this.f23890f = (TextView) aVar.internalFindViewById(R.id.product_quantity);
        this.f23891g = (TextView) aVar.internalFindViewById(R.id.returnRefund15days);
        this.i = (TextView) aVar.internalFindViewById(R.id.returnRefundText);
        this.j = aVar.internalFindViewById(R.id.divider);
        this.k = aVar.internalFindViewById(R.id.bundle_section);
        a();
    }
}
