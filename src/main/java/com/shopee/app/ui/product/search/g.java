package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f24831b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f24832c = new c();

    public g(Context context) {
        super(context);
        a();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.f24831b) {
            this.f24831b = true;
            inflate(getContext(), R.layout.search_history_header_item_layout, this);
            this.f24832c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f24832c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24830a = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
