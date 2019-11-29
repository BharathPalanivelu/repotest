package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class t extends s implements a, b {
    private boolean l = false;
    private final c m = new c();

    public t(Context context, an anVar, boolean z) {
        super(context, anVar, z);
        c();
    }

    public static s a(Context context, an anVar, boolean z) {
        t tVar = new t(context, anVar, z);
        tVar.onFinishInflate();
        return tVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.in_chat_order_item_view, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.m);
        c.a((b) this);
        this.f20143e = androidx.core.content.b.c(getContext(), R.color.white);
        this.f20144f = androidx.core.content.b.c(getContext(), R.color.black87);
        this.f20145g = androidx.core.content.b.c(getContext(), R.color.black26);
        this.h = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20139a = (TextView) aVar.internalFindViewById(R.id.order_id);
        this.f20140b = (TextView) aVar.internalFindViewById(R.id.order_total);
        this.f20141c = (TextView) aVar.internalFindViewById(R.id.order_status);
        this.f20142d = (ImageView) aVar.internalFindViewById(R.id.product_image);
        a();
    }
}
