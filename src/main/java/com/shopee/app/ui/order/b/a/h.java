package com.shopee.app.ui.order.b.a;

import android.content.Context;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.order.views.p;
import com.shopee.app.ui.order.views.q;
import com.shopee.id.R;
import java.util.List;

public class h extends m<p, a> {

    public interface a {
        int a();

        List<Long> b();
    }

    public int b() {
        return 5;
    }

    public p a(Context context, a aVar, int i) {
        return q.a(context);
    }

    public void a(p pVar, a aVar) {
        pVar.setViewMoreCount(aVar.a());
        pVar.setIds(aVar.b());
        Object a2 = a();
        boolean z = a2 instanceof CheckoutItem;
        Integer valueOf = Integer.valueOf(R.color.unread_bg);
        Integer valueOf2 = Integer.valueOf(R.color.white);
        if (z) {
            if (((CheckoutItem) a2).isUnread()) {
                pVar.setBackgroundColor(b.a(R.color.unread_bg));
                pVar.setTag(R.id.button, valueOf);
                return;
            }
            pVar.setBackgroundColor(b.a(R.color.white));
            pVar.setTag(R.id.button, valueOf2);
        } else if (a2 instanceof OrderDetail) {
            if (((OrderDetail) a2).isUnread()) {
                pVar.setBackgroundColor(b.a(R.color.unread_bg));
                pVar.setTag(R.id.button, valueOf);
                return;
            }
            pVar.setBackgroundColor(b.a(R.color.white));
            pVar.setTag(R.id.button, valueOf2);
        } else if (!(a2 instanceof ReturnItem)) {
            pVar.setBackgroundColor(b.a(R.color.white));
            pVar.setTag(R.id.button, valueOf2);
        } else if (((ReturnItem) a2).isUnread()) {
            pVar.setBackgroundColor(b.a(R.color.unread_bg));
            pVar.setTag(R.id.button, valueOf);
        } else {
            pVar.setBackgroundColor(b.a(R.color.white));
            pVar.setTag(R.id.button, valueOf2);
        }
    }
}
