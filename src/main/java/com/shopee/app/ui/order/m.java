package com.shopee.app.ui.order;

import android.content.Context;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.id.R;

public class m extends com.shopee.app.ui.a.m<n, a> {
    public int b() {
        return 6;
    }

    public n a(Context context, a aVar, int i) {
        return o.a(context);
    }

    public void a(n nVar, a aVar) {
        nVar.setOrderId(aVar.a());
        if (a() instanceof OrderDetail) {
            OrderDetail orderDetail = (OrderDetail) a();
            nVar.setOrderNumber("#" + orderDetail.getSerialNumber());
            if (orderDetail.isUnread()) {
                nVar.setBackgroundColor(b.a(R.color.unread_bg));
                nVar.setTag(R.id.button, Integer.valueOf(R.color.white));
            } else {
                nVar.setBackgroundColor(b.a(R.color.white));
                nVar.setTag(R.id.button, Integer.valueOf(R.color.white));
            }
            if (aVar.q()) {
                nVar.setDividerVisibility(8);
            } else {
                nVar.setDividerVisibility(0);
            }
        }
    }
}
