package com.shopee.app.ui.chat2.offer;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20638b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20639c = new c();

    public d(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
        c();
    }

    public static c a(Context context, int i, int i2, boolean z) {
        d dVar = new d(context, i, i2, z);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.f20638b) {
            this.f20638b = true;
            inflate(getContext(), R.layout.product_selection_layout, this);
            this.f20639c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.f20639c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20633a = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.tabView);
        a();
    }
}
