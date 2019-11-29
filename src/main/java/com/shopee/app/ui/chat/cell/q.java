package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class q extends p implements a, b {
    private boolean j = false;
    private final c k = new c();

    public q(Context context) {
        super(context);
        d();
    }

    public static p a(Context context) {
        q qVar = new q(context);
        qVar.onFinishInflate();
        return qVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.chat_product_card_item_view, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20130a = (TextView) aVar.internalFindViewById(R.id.product_name);
        this.f20131b = (TextView) aVar.internalFindViewById(R.id.product_variation);
        this.f20132c = (TextView) aVar.internalFindViewById(R.id.product_price);
        this.f20133d = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f20134e = (TextView) aVar.internalFindViewById(R.id.sent_label);
        this.f20135f = (Button) aVar.internalFindViewById(R.id.send_link_btn);
        View internalFindViewById = aVar.internalFindViewById(R.id.content_container);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    q.this.b();
                }
            });
        }
        if (this.f20135f != null) {
            this.f20135f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    q.this.c();
                }
            });
        }
        a();
    }
}
