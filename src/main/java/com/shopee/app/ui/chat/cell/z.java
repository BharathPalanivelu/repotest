package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class z extends y implements a, b {
    private boolean s = false;
    private final c t = new c();

    public z(Context context, an anVar, boolean z) {
        super(context, anVar, z);
        e();
    }

    public void onFinishInflate() {
        if (!this.s) {
            this.s = true;
            inflate(getContext(), R.layout.in_chat_product_item_view, this);
            this.t.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.t);
        c.a((b) this);
        this.h = androidx.core.content.b.c(getContext(), R.color.white);
        this.i = androidx.core.content.b.c(getContext(), R.color.primary);
        this.j = androidx.core.content.b.c(getContext(), R.color.black87);
        this.k = androidx.core.content.b.c(getContext(), R.color.black26);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static y a(Context context, an anVar, boolean z) {
        z zVar = new z(context, anVar, z);
        zVar.onFinishInflate();
        return zVar;
    }

    public void onViewChanged(a aVar) {
        this.f20157a = (TextView) aVar.internalFindViewById(R.id.product_name);
        this.f20158b = (TextView) aVar.internalFindViewById(R.id.original_price);
        this.f20159c = (TextView) aVar.internalFindViewById(R.id.make_offer);
        this.f20160d = (TextView) aVar.internalFindViewById(R.id.buy_now);
        this.f20161e = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f20162f = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f20163g = aVar.internalFindViewById(R.id.upper_panel);
        this.l = aVar.internalFindViewById(R.id.offer_panel);
        this.m = aVar.internalFindViewById(R.id.divider);
        if (this.f20159c != null) {
            this.f20159c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    z.this.c();
                }
            });
        }
        if (this.f20160d != null) {
            this.f20160d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    z.this.d();
                }
            });
        }
        a();
    }
}
