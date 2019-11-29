package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean n = false;
    private final c o = new c();

    public n(Context context, an anVar, boolean z) {
        super(context, anVar, z);
        b();
    }

    public void onFinishInflate() {
        if (!this.n) {
            this.n = true;
            inflate(getContext(), R.layout.in_chat_offer_item_view, this);
            this.o.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.o);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.m = resources.getDimensionPixelSize(R.dimen.dp8);
        this.h = androidx.core.content.b.c(getContext(), R.color.white);
        this.i = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static m a(Context context, an anVar, boolean z) {
        n nVar = new n(context, anVar, z);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onViewChanged(a aVar) {
        this.f20118a = (TextView) aVar.internalFindViewById(R.id.offer_status);
        this.f20119b = (TextView) aVar.internalFindViewById(R.id.offer_price);
        this.f20120c = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f20121d = (TextView) aVar.internalFindViewById(R.id.offer_quantity);
        this.f20122e = (TextView) aVar.internalFindViewById(R.id.variation);
        this.f20123f = (TextView) aVar.internalFindViewById(R.id.itemName);
        this.f20124g = (TextView) aVar.internalFindViewById(R.id.tap_view);
        a();
    }
}
