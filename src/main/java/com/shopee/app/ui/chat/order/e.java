package com.shopee.app.ui.chat.order;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20187b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20188c = new c();

    public e(Context context) {
        super(context);
        b();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.f20187b) {
            this.f20187b = true;
            inflate(getContext(), R.layout.chat_order_product_list_layout, this);
            this.f20188c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20188c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20186a = (LinearLayout) aVar.internalFindViewById(R.id.product_list);
        a();
    }
}
