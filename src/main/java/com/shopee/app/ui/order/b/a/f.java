package com.shopee.app.ui.order.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.a.m;
import com.shopee.app.ui.order.views.j;
import com.shopee.app.ui.order.views.k;
import com.shopee.id.R;

public class f extends m<j, a> {
    public int b() {
        return 8;
    }

    public j a(Context context, a aVar, int i) {
        return k.a(context);
    }

    public void a(j jVar, a aVar) {
        Object a2 = a();
        if (a2 instanceof OrderDetail) {
            OrderDetail orderDetail = (OrderDetail) a2;
            if (!TextUtils.isEmpty(orderDetail.getDeliveryStatusDes())) {
                jVar.a(orderDetail.getDeliveryStatusDes(), orderDetail.getOrderId(), orderDetail.getShopId());
            }
            if (orderDetail.isUnread()) {
                jVar.setBackgroundColor(b.a(R.color.unread_bg));
                jVar.setTag(R.id.button, Integer.valueOf(R.color.unread_bg));
                return;
            }
            jVar.setBackgroundColor(b.a(R.color.white));
            jVar.setTag(R.id.button, Integer.valueOf(R.color.white));
        }
    }
}
