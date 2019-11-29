package com.shopee.app.ui.chat2.order;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20666b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20667c = new c();

    public e(Context context, int i, int i2) {
        super(context, i, i2);
        b();
    }

    public static d a(Context context, int i, int i2) {
        e eVar = new e(context, i, i2);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f20666b) {
            this.f20666b = true;
            inflate(getContext(), R.layout.order_selection_tab_view, this);
            this.f20667c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20667c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20661a = (com.garena.android.uikit.a.c) aVar.internalFindViewById(R.id.tabView);
        a();
    }
}
