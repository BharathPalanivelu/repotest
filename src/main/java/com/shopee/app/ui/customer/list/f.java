package com.shopee.app.ui.customer.list;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f21421g = false;
    private final c h = new c();

    public f(Context context) {
        super(context);
        g();
    }

    public static e a(Context context) {
        f fVar = new f(context);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.f21421g) {
            this.f21421g = true;
            inflate(getContext(), R.layout.my_customer_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21414a = (ListView) aVar.internalFindViewById(R.id.customer_list);
        if (this.f21414a != null) {
            this.f21414a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.customer.list.f r2 = com.shopee.app.ui.customer.list.f.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.data.viewmodel.UserBriefInfo r1 = (com.shopee.app.data.viewmodel.UserBriefInfo) r1
                        r2.a((com.shopee.app.data.viewmodel.UserBriefInfo) r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.customer.list.f.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}
