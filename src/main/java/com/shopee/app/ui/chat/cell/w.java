package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class w extends v implements a, b {
    private boolean q = false;
    private final c r = new c();

    public w(Context context) {
        super(context);
        f();
    }

    public static v a(Context context) {
        w wVar = new w(context);
        wVar.onFinishInflate();
        return wVar;
    }

    public void onFinishInflate() {
        if (!this.q) {
            this.q = true;
            inflate(getContext(), R.layout.chat_product_card_item_view, this);
            this.r.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.r);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20146a = (TextView) aVar.internalFindViewById(R.id.product_name);
        this.f20147b = (TextView) aVar.internalFindViewById(R.id.product_variation);
        this.f20148c = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f20149d = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f20150e = aVar.internalFindViewById(R.id.send_link_btn);
        this.f20151f = aVar.internalFindViewById(R.id.divider);
        this.f20152g = (TextView) aVar.internalFindViewById(R.id.make_offer);
        this.h = (TextView) aVar.internalFindViewById(R.id.buy_now);
        this.i = aVar.internalFindViewById(R.id.offer_panel);
        this.j = (TextView) aVar.internalFindViewById(R.id.sent_label);
        this.k = (TextView) aVar.internalFindViewById(R.id.send_link_btn2);
        this.l = aVar.internalFindViewById(R.id.divider2);
        View internalFindViewById = aVar.internalFindViewById(R.id.content_container);
        if (this.f20152g != null) {
            this.f20152g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.b();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.c();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.d();
                }
            });
        }
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.e();
                }
            });
        }
        a();
    }
}
