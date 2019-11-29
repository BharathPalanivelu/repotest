package com.shopee.app.ui.product.search.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f24817c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f24818d = new c();

    public d(Context context) {
        super(context);
        b();
    }

    public static c a(Context context) {
        d dVar = new d(context);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.f24817c) {
            this.f24817c = true;
            inflate(getContext(), R.layout.search_hot_word_grid_item_layout, this);
            this.f24818d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f24818d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24813a = (LinearLayout) aVar.internalFindViewById(R.id.grid);
        this.f24814b = (TextView) aVar.internalFindViewById(R.id.label);
        a();
    }
}
