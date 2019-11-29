package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f24834b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f24835c = new c();

    public i(Context context) {
        super(context);
        a();
    }

    public static h a(Context context) {
        i iVar = new i(context);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.f24834b) {
            this.f24834b = true;
            inflate(getContext(), R.layout.search_history_item_layout, this);
            this.f24835c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f24835c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f24833a = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
