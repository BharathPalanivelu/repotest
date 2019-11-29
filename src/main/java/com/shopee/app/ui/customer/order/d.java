package com.shopee.app.ui.customer.order;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.shopee.app.ui.common.o;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean k = false;
    private final c l = new c();

    public d(Context context, int i, int i2, String str) {
        super(context, i, i2, str);
        g();
    }

    public static c a(Context context, int i, int i2, String str) {
        d dVar = new d(context, i, i2, str);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.customer_orders_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21440a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f21441b = (TextView) aVar.internalFindViewById(R.id.username);
        this.f21442c = (TextView) aVar.internalFindViewById(R.id.nickname);
        this.f21443d = (o) aVar.internalFindViewById(R.id.divider);
        this.f21444e = (ListView) aVar.internalFindViewById(R.id.order_list);
        View internalFindViewById = aVar.internalFindViewById(R.id.user_section);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.b();
                }
            });
        }
        if (this.f21444e != null) {
            this.f21444e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.customer.order.d r2 = com.shopee.app.ui.customer.order.d.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.ui.a.m r1 = (com.shopee.app.ui.a.m) r1
                        r2.a((com.shopee.app.ui.a.m) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.customer.order.d.AnonymousClass2.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}
