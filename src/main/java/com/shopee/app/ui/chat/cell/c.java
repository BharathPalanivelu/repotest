package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f20081g = false;
    private final org.a.a.b.c h = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        c();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f20081g) {
            this.f20081g = true;
            inflate(getContext(), R.layout.chat_chat_order_item_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.h);
        org.a.a.b.c.a((b) this);
        this.f20075a = androidx.core.content.b.c(getContext(), R.color.white);
        this.f20076b = androidx.core.content.b.c(getContext(), R.color.black87);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20077c = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f20078d = (Button) aVar.internalFindViewById(R.id.goto_cart);
        if (this.f20078d != null) {
            this.f20078d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
        a();
    }
}
