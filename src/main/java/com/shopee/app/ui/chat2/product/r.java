package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class r extends q implements a, b {
    private boolean q = false;
    private final c r = new c();

    public r(Context context, boolean z) {
        super(context, z);
        d();
    }

    public static q a(Context context, boolean z) {
        r rVar = new r(context, z);
        rVar.onFinishInflate();
        return rVar;
    }

    public void onFinishInflate() {
        if (!this.q) {
            this.q = true;
            inflate(getContext(), R.layout.chat_product_select_item_view, this);
            this.r.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.r);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.j = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.k = resources.getDimensionPixelOffset(R.dimen.font_size_18);
        this.h = androidx.core.content.b.c(getContext(), R.color.black26);
        this.i = androidx.core.content.b.c(getContext(), R.color.black87);
        this.l = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20833a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f20834b = (TextView) aVar.internalFindViewById(R.id.title);
        this.f20835c = (TextView) aVar.internalFindViewById(R.id.price);
        this.f20836d = (CheckBox) aVar.internalFindViewById(R.id.checkbox);
        this.f20837e = (TextView) aVar.internalFindViewById(R.id.sold_label);
        this.f20838f = (TextView) aVar.internalFindViewById(R.id.variation);
        this.f20839g = (TextView) aVar.internalFindViewById(R.id.quantity);
        a();
    }
}
