package com.shopee.app.network.d.h;

import com.beetalklib.network.d.f;
import com.shopee.app.data.viewmodel.OrderRateItemInfo;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.RateOrder;
import com.shopee.protocol.shop.ItemCmt;
import java.util.ArrayList;
import java.util.List;

public class q extends az {

    /* renamed from: a  reason: collision with root package name */
    private List<ItemCmt> f18405a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<OrderRateItemInfo> f18406b;

    /* access modifiers changed from: protected */
    public f a() {
        if (this.f18405a.size() <= 0) {
            return null;
        }
        int intValue = this.f18405a.get(0).shopid.intValue();
        long longValue = this.f18405a.get(0).orderid.longValue();
        RateOrder.Builder builder = new RateOrder.Builder();
        builder.requestid(i().a()).shopid(Integer.valueOf(intValue)).orderid(Long.valueOf(longValue)).comment(this.f18405a);
        return new f(101, builder.build().toByteArray());
    }

    public void a(List<OrderRateItemInfo> list) {
        this.f18406b = list;
        ArrayList arrayList = new ArrayList();
        for (OrderRateItemInfo next : list) {
            ItemCmt.Builder builder = new ItemCmt.Builder();
            builder.shopid(Integer.valueOf(next.getOrderItemInfo().getShopId())).orderid(Long.valueOf(next.getOrderItemInfo().getOrderId())).itemid(Long.valueOf(next.getOrderItemInfo().getItemId())).comment(next.getComment()).rating(Integer.valueOf(next.getRate()));
            arrayList.add(builder.build());
        }
        if (arrayList.size() > 0) {
            this.f18405a.addAll(arrayList);
        }
        g();
    }

    public List<OrderRateItemInfo> b() {
        return this.f18406b;
    }
}
