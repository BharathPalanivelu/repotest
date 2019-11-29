package com.shopee.app.ui.chat2.product;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20723b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20724c = new c();

    public b(Context context) {
        super(context);
        a();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f20723b) {
            this.f20723b = true;
            inflate(getContext(), R.layout.chat_product_select_item_header_view, this);
            this.f20724c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void a() {
        c a2 = c.a(this.f20724c);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20691a = (TextView) aVar.internalFindViewById(R.id.label);
    }
}
