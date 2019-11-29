package com.shopee.app.ui.chat2.offer.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {

    /* renamed from: f  reason: collision with root package name */
    private boolean f20603f = false;

    /* renamed from: g  reason: collision with root package name */
    private final c f20604g = new c();

    public h(Context context, int i) {
        super(context, i);
        g();
    }

    public static g a(Context context, int i) {
        h hVar = new h(context, i);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.f20603f) {
            this.f20603f = true;
            inflate(getContext(), R.layout.offer_product_selection_list_layout, this);
            this.f20604g.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.f20604g);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20596a = (RecyclerView) aVar.internalFindViewById(R.id.list);
        this.f20597b = aVar.internalFindViewById(R.id.emptyView);
        d();
    }
}
